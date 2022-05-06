package com.mega.metaweather

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mega.metaweather.domain.use_case.DisplayGetUseCase
import com.mega.metaweather.presentation.LocationViewModel
import com.mega.metaweather.utilities.Events
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.onEach
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import javax.inject.Inject

private const val CITY_EXAMPLE = "Toronto"

@HiltAndroidTest
class NetworkModuleTest {
    private val hiltRule = HiltAndroidRule(this)
    private lateinit var viewModel: LocationViewModel
    private val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val coroutineRule = MainCoroutineRule()

    @get:Rule
    val rule = RuleChain
        .outerRule(hiltRule)
        .around(instantTaskExecutorRule)
        .around(coroutineRule)

    @Inject
    lateinit var locationUseCase : DisplayGetUseCase

    @Before
    fun setUp() {
        hiltRule.inject()
        viewModel = LocationViewModel(locationUseCase)
    }

    @Test
    fun useCaseConnectionTest() {
        locationUseCase().onEach {
            when (it) {
                is Events.Success -> {
                    assertEquals(it.data?.title, CITY_EXAMPLE)
                }
                is Events.Error -> {
                    fail("Internet problem");
                }
            }
        }
    }
}