package com.mfr.matchfootballscheduler.ui.MainMatch

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchNext.MatchNextFragment
import com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchPrevious.MatchLastFragment

class PagerAdapterMatch(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private var tabCount = 0


    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> MatchLastFragment.newInstance()
            1 -> MatchNextFragment.newInstance()
            else -> null
        }
    }

    internal fun setCount(count: Int) {
        this.tabCount = count
    }
}