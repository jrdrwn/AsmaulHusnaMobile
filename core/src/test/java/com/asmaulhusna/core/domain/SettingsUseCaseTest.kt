package com.asmaulhusna.core.domain

import com.asmaulhusna.core.domain.model.Settings
import com.asmaulhusna.core.domain.repository.ISettingsRepository
import com.asmaulhusna.core.domain.usecase.SettingsInteractor
import com.asmaulhusna.core.domain.usecase.SettingsUseCase
import com.asmaulhusna.core.utils.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class SettingsUseCaseTest {

    private lateinit var settingsUseCase: SettingsUseCase

    @Mock
    private lateinit var settingsRepository: ISettingsRepository

    @Before
    fun setUp() {
        settingsUseCase = SettingsInteractor(settingsRepository)
        val dummyData = Settings(
            true
        )
        `when`(settingsRepository.getSettings()).thenReturn(
            flowOf(
                dummyData
            )
        )
    }


    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun `should get data from repository`() = runTest {
        val asmaulHusna = settingsUseCase.getSettings()

        verify(settingsRepository).getSettings()
        verifyNoMoreInteractions(settingsRepository)
        Assert.assertEquals(true, asmaulHusna.first().darkMode)
    }
}