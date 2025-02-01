package com.asmaulhusna.core.domain

import com.asmaulhusna.core.data.Resource
import com.asmaulhusna.core.domain.model.AsmaulHusna
import com.asmaulhusna.core.domain.repository.IAsmaulHusnaRepository
import com.asmaulhusna.core.domain.usecase.AsmaulHusnaInteractor
import com.asmaulhusna.core.domain.usecase.AsmaulHusnaUseCase
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
class AsmaulHusnaUseCaseTest {

    private lateinit var asmaulHusnaUseCase: AsmaulHusnaUseCase

    @Mock
    private lateinit var asmaulHusnaRepository: IAsmaulHusnaRepository

    @Before
    fun setUp() {
        asmaulHusnaUseCase = AsmaulHusnaInteractor(asmaulHusnaRepository)
        val dummyData = AsmaulHusna(
            1,
            "Ar Rahman",
            "الرَّحْمَنُ",
            "Yang Memiliki Mutlak sifat Pemurah",
            "The All Beneficent",
            false
        )
        `when`(asmaulHusnaRepository.getAllAsmaulHusna()).thenReturn(
            flowOf(
                Resource.Success(
                    listOf(
                        dummyData
                    )
                )
            )
        )
    }


    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun `should get data from repository`() = runTest {
        val asmaulHusna = asmaulHusnaUseCase.getAllAsmaulHusna()

        verify(asmaulHusnaRepository).getAllAsmaulHusna()
        verifyNoMoreInteractions(asmaulHusnaRepository)
        Assert.assertEquals(1, asmaulHusna.first().data?.first()?.id)
    }
}