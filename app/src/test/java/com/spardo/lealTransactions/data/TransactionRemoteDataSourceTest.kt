package com.spardo.lealTransactions.data

import com.spardo.lealTransactions.data.network.LealApi
import com.spardo.lealTransactions.data.network.dto.BranchDTO
import com.spardo.lealTransactions.data.network.dto.CommerceDTO
import com.spardo.lealTransactions.data.network.dto.TransactionDTO
import com.spardo.lealTransactions.data.network.dto.TransactionDetailDTO
import com.spardo.lealTransactions.data.remote.TransactionRemoteDataSource
import com.spardo.lealTransactions.domain.models.TransactionDetailModel
import junit.framework.Assert.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.*

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class TransactionRemoteDataSourceTest {
    // Mocks
    private val mockLealApi = mock(LealApi::class.java)
    private val dataSource: TransactionRemoteDataSource =
        TransactionRemoteDataSource(
            lealApi = mockLealApi
        )

    // Dummies
    private val transactionDetailDTO = TransactionDetailDTO(
        id = 1,
        value = 670408.0,
        points = 67.0
    )

    private val transactionDTO = TransactionDTO(
        id = 1,
        userId = 1,
        createdDate = "2020-07-18T06:05:58.158Z",
        commerce = CommerceDTO(
            id = 1,
            name = "Apple",
            valueToPoints = 10000.0,
            branches = listOf(
                BranchDTO(
                    id = 1,
                    name = "Bogotá"
                ),
                BranchDTO(
                    id = 2,
                    name = "Medellín"
                )
            )
        ),
        branch = BranchDTO(
            id = 1,
            name = "Bogotá"
        )
    )

    @After
    fun tearDown() {
        verifyNoMoreInteractions(
            mockLealApi
        )
    }

    // Tests
    @Test
    fun `test get transaction detail success`() {
        runBlockingTest {
            `when`(mockLealApi.getTransactionDetail(1)).thenReturn(
                transactionDetailDTO
            )

            val result = dataSource.getTransactionDetailById(1)

            verify(mockLealApi).getTransactionDetail(1)

            assertTrue("The result should be a domain model", result is TransactionDetailModel)
            assertEquals("The id of the transaction does not match", 1L, result?.id)
            assertEquals("The value of the transaction does not match", 670408.0, result?.value)
            assertEquals("The points of the transaction do not match", 67.0, result?.points)
        }
    }

    @Test
    fun `test get transaction network error`() {
        runBlockingTest {
            `when`(mockLealApi.getTransactionDetail(1)).thenThrow(RuntimeException(""))

            val result = dataSource.getTransactionDetailById(1)

            verify(mockLealApi).getTransactionDetail(1)

            assertNull("The result should be null", result)
        }
    }

    @Test
    fun `test get transaction success`() {
        runBlockingTest {
            `when`(mockLealApi.getTransactions()).thenReturn(
                listOf(transactionDTO)
            )

            val result = dataSource.getTransactions()

            verify(mockLealApi).getTransactions()

            assertEquals("The size of the list should be 1", 1, result.size)
            assertEquals("The id of the transaction should be 1", 1, result[0].id)
            assertEquals(
                "The name of the commerce does not match",
                "Apple",
                result[0].commerce.name
            )
            assertEquals(
                "The value to point of the commerce does not match",
                10000.0,
                result[0].commerce.valueToPoints
            )
            assertEquals(
                "The amount of branches of the commerce do not match",
                2,
                result[0].commerce.branches.size
            )
            assertEquals("The id of the branch does not match", 1, result[0].branch.id)
            assertFalse("The transaction should not have been seen", result[0].seen)
        }
    }

    @Test
    fun `test get transaction failed on network request`() {
        runBlockingTest {
            `when`(mockLealApi.getTransactions()).thenThrow(RuntimeException(""))

            val result = dataSource.getTransactions()

            verify(mockLealApi).getTransactions()

            assertEquals("The list should be empty", 0, result.size)
        }
    }
}
