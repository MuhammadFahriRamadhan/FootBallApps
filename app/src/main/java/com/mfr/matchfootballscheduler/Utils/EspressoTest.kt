package com.mfr.matchfootballscheduler.Utils

import android.support.test.espresso.IdlingResource
import android.support.test.espresso.idling.CountingIdlingResource

class EspressoTest {

    companion object EspressoTest {

        private const val RESOURCE = "RESOURCE"
    }

    private val countTestIdlingResource = CountingIdlingResource(RESOURCE)

    val idlingResource: IdlingResource
        get() = countTestIdlingResource

    fun testincrement() {

        countTestIdlingResource.increment()
    }

    fun testdecrement() {

        countTestIdlingResource.decrement()
    }
}