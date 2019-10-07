package com.mfr.matchfootballscheduler.ui.Favorite

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mfr.matchfootballscheduler.R
import com.mfr.matchfootballscheduler.ui.base.BaseFragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_favorite.*

class FragmentFavorite : BaseFragment() {

    private lateinit var PagerAdapter: PagerAdapterFav




    companion object {

        fun newInstance(): FragmentFavorite = FragmentFavorite()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fragmentManager?.let { PagerAdapter = PagerAdapterFav(childFragmentManager) }
        setUp()



    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_favorite, container, false)


    private fun setUp() {


        PagerAdapter.count = 2

        match_view_pagerfav.adapter = PagerAdapter

        tabLayoutfav.addTab(tabLayoutfav.newTab().setText("Favorite Match"))
        tabLayoutfav.addTab(tabLayoutfav.newTab().setText("Favorite Team"))

        match_view_pagerfav.offscreenPageLimit = tabLayoutfav.tabCount
        match_view_pagerfav.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayoutfav))

        tabLayoutfav.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                match_view_pagerfav.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}