package com.mfr.matchfootballscheduler.ui.Favorite

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.mfr.matchfootballscheduler.ui.Favorite.ClubPlayerFavorite.FragmentFavClubTeam
import com.mfr.matchfootballscheduler.ui.Favorite.MatchFavorite.FragmentFavMatchSC

class PagerAdapterFav (fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private var tabCount = 0


    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> FragmentFavMatchSC.newInstance()
            1 -> FragmentFavClubTeam.newInstance()
            else -> null
        }
    }

    internal fun setCount(count: Int) {
        this.tabCount = count
    }
}