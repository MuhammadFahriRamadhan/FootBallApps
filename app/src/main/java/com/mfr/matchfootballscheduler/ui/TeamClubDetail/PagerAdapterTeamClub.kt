package com.mfr.matchfootballscheduler.ui.TeamClubDetail

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.mfr.matchfootballscheduler.ui.TeamClubDetail.PlayerTeamClub.FragmentPlayerClub
import com.mfr.matchfootballscheduler.ui.TeamClubDetail.overviewteamclub.fragmentteamclub

class PagerAdapterTeamClub (fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private var tabCount = 0


    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 ->fragmentteamclub.newInstance()
            1 ->FragmentPlayerClub.newInstance()
            else -> null
        }
    }

    internal fun setCount(count: Int) {
        this.tabCount = count
    }
}