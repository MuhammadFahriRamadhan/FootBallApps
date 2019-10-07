package com.mfr.matchfootballscheduler.ui.TeamClubDetail.overviewteamclub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mfr.matchfootballscheduler.R
import com.mfr.matchfootballscheduler.ui.TeamClubDetail.teamclubdetail
import com.mfr.matchfootballscheduler.ui.base.BaseFragment.BaseFragment
import kotlinx.android.synthetic.main.item_overview_teamclub.*

class fragmentteamclub: BaseFragment(),overviewclubinterface {


    companion object {

        fun newInstance(): fragmentteamclub = fragmentteamclub()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as teamclubdetail).setOnOverviewTeamClubListener(this)

    }

    override fun fetchoverviewcallback(leagueName: String?) {
        tv_club_overview.text =leagueName
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.item_overview_teamclub, container, false)
    }


}