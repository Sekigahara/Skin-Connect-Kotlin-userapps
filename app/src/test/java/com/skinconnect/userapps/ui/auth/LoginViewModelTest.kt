package com.skinconnect.userapps.ui.auth

import androidx.lifecycle.MutableLiveData
import com.skinconnect.userapps.data.repository.Result
import com.skinconnect.userapps.util.DataDummy
import com.skinconnect.userapps.util.getOrAwaitValue
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

class LoginViewModelTest : AuthViewModelTest() {
    private val dummyRequest = DataDummy.generateDummyLoginRequest()

    override fun setUp() {
        viewModel = LoginViewModel(repository)
    }

    override fun `when Network Error Should Return Error`() {
        val viewModel = viewModel as LoginViewModel
        val expectedMessage = MutableLiveData<Result<String>>()
        expectedMessage.value = Result.Error("Error")
        `when`(viewModel.login(dummyRequest)).thenReturn(expectedMessage)
        val actualMessage = viewModel.login(dummyRequest).getOrAwaitValue()
        Mockito.verify(repository).login(dummyRequest)
        Assert.assertNotNull(actualMessage)
        Assert.assertTrue(actualMessage is Result.Error)
    }

    @Test
    fun `when Login Should Not Null and Return Success`() {
        val viewModel = viewModel as LoginViewModel
        val expectedMessage = MutableLiveData<Result<String>>()
        expectedMessage.value = Result.Success(dummyMessage)
        `when`(viewModel.login(dummyRequest)).thenReturn(expectedMessage)
        val actualMessage = viewModel.login(dummyRequest).getOrAwaitValue()
        Mockito.verify(repository).login(dummyRequest)
        Assert.assertNotNull(actualMessage)
        Assert.assertTrue(actualMessage is Result.Success)
        Assert.assertEquals(dummyMessage, (actualMessage as Result.Success).data)
    }
}