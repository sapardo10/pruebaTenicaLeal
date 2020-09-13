package com.spardo.lealTransactions.data

import com.spardo.lealTransactions.data.network.LealApi
import com.spardo.lealTransactions.data.network.dto.UserDTO
import com.spardo.lealTransactions.data.remote.UserRemoteDataSource
import com.spardo.lealTransactions.domain.models.UserModel
import junit.framework.Assert.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class UserRemoteDataSourceTest {

    // Mocks
    private val mockLealApi = Mockito.mock(LealApi::class.java)
    private val dataSource: UserRemoteDataSource =
        UserRemoteDataSource(
            lealApi = mockLealApi
        )

    private val userDTO = UserDTO(
        id = 1,
        createdDate = "2020-07-18T06:05:58.158Z",
        name = "José Licero",
        birthday = "1980-10-13T00:00:00.000Z",
        photo = "https://images.unsplash.com/photo-1560250097-0b93528c311a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1234&q=80"
    )

    @After
    fun tearDown() {
        Mockito.verifyNoMoreInteractions(
            mockLealApi
        )
    }

    // Tests
    @Test
    fun `test get user network error`() {
        runBlockingTest {
            `when`(mockLealApi.getUser(1)).thenThrow(RuntimeException(""))

            val result = dataSource.getUser(1)

            verify(mockLealApi).getUser(1)

            assertNull("result should be null", result)
        }
    }

    @Test
    fun `test get user success`() {
        runBlockingTest {
            `when`(mockLealApi.getUser(1)).thenReturn(userDTO)

            val result = dataSource.getUser(1)

            verify(mockLealApi).getUser(1)

            assertTrue("Result should be a UserModel type", result is UserModel)
            assertEquals("The id of the user does not match", 1L, result?.id)
            assertEquals(
                "The createdDate of the user does not match",
                "2020-07-18T06:05:58.158Z",
                result?.createdDate
            )
            assertEquals("The name of the user does not match", "José Licero", result?.name)
            assertEquals(
                "The birthday of the user does not match",
                "1980-10-13T00:00:00.000Z",
                result?.birthday
            )
            assertEquals(
                "The photo of the user does not match",
                "https://images.unsplash.com/photo-1560250097-0b93528c311a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1234&q=80",
                result?.photo
            )
        }
    }
}