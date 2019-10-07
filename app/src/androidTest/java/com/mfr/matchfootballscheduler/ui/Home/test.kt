package com.mfr.matchfootballscheduler.ui.Home

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.IdlingRegistry
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.mfr.matchfootballscheduler.R
import com.mfr.matchfootballscheduler.Utils.EspressoTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class test {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(HomeMatchActivity::class.java)

    @Test
    fun homeMatchActivityTest() {

        IdlingRegistry.getInstance().register(EspressoTest().idlingResource)
        Thread.sleep(2000)
        val bottomNavigationItemView = onView(
                allOf(withId(R.id.nav_Match), withContentDescription("ScheduleMatch"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.navigation),
                                        0),
                                0),
                        isDisplayed()))
        bottomNavigationItemView.perform(click())

        val recyclerView = onView(
                allOf(withId(R.id.rcv_fragmentprev)
                        ))
        Thread.sleep(2000)
        recyclerView.perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))


        val recyclerViewss = onView(
                allOf(withId(R.id.rcv_fragmentprev)
                ))
        Thread.sleep(2000)
        recyclerViewss.perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))

        val actionMenuItemView = onView(
                allOf(withId(R.id.fav_menu), withContentDescription("Favorite"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.action_bar),
                                        1),
                                0),
                        isDisplayed()))
        actionMenuItemView.perform(click())

        Thread.sleep(2000)
        pressBack()



        ///

        Thread.sleep(2000)
        val bottomNavigationItemViewnext = onView(
                allOf(withId(R.id.Nav_TeamCLub), withContentDescription("TeamClub"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.navigation),
                                        0),
                                1),
                        isDisplayed()))
        bottomNavigationItemViewnext.perform(click())

        val recyclerViewnext = onView(
                allOf(withId(R.id.rcv_teamclub)
                ))
        Thread.sleep(2000)
        recyclerViewnext.perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))


        val recyclerViewssnext = onView(
                allOf(withId(R.id.rcv_teamclub)
                ))
        Thread.sleep(2000)
        recyclerViewssnext.perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))

        val actionMenuItemViewnext = onView(
                allOf(withId(R.id.fav_menu), withContentDescription("Favorite"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.action_bar),
                                        1),
                                0),
                        isDisplayed()))
        actionMenuItemViewnext.perform(click())

        Thread.sleep(2000)
        pressBack()

        ///

        Thread.sleep(2000)
        val bottomNavigationItemViewfav = onView(
                allOf(withId(R.id.Nav_Fav), withContentDescription("Favorite"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.navigation),
                                        0),
                                2),
                        isDisplayed()))
        bottomNavigationItemViewfav.perform(click())

        val recyclerViewfav = onView(
                allOf(withId(R.id.rcv_fragment_fav)
                ))
        Thread.sleep(2000)
        recyclerViewfav.perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))


        val recyclerViewsfav = onView(
                allOf(withId(R.id.rcv_fragment_fav)
                ))
        Thread.sleep(2000)
        recyclerViewsfav.perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        val actionMenuItemViewfav = onView(
                allOf(withId(R.id.fav_menu), withContentDescription("Favorite"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.action_bar),
                                        1),
                                0),
                        isDisplayed()))
        actionMenuItemViewfav.perform(click())

        Thread.sleep(2000)
        pressBack()


    }

    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return (parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position))
            }
        }
    }
}
