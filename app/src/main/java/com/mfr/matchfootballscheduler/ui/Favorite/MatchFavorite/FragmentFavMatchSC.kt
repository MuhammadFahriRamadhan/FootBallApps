package com.mfr.matchfootballscheduler.ui.Favorite.MatchFavorite

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mfr.matchfootballscheduler.R
import com.mfr.matchfootballscheduler.data.MatchDB.matchdatabase
import com.mfr.matchfootballscheduler.data.ModelMatch.MatchFavorite
import com.mfr.matchfootballscheduler.data.ModelMatch.SchedulMatch
import com.mfr.matchfootballscheduler.ui.ScDetailMatch.MatchDetailActivity
import com.mfr.matchfootballscheduler.ui.base.BaseFragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_favoritematch.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx
import org.koin.android.ext.android.inject

class FragmentFavMatchSC : BaseFragment() {

    companion object {

        fun newInstance(): FragmentFavMatchSC = FragmentFavMatchSC()
    }


    val mAdapterfav : MatchFavScAdapter by inject()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rcv_fragment_fav.layoutManager = LinearLayoutManager(activity)
        rcv_fragment_fav.adapter = mAdapterfav
        showFavScMatch()

        mAdapterfav.setOnFavMatchCLickListener {
            val matchitems = SchedulMatch()
            matchitems.idEvent = it.idMatchEvent
            matchitems.idHomeTeam = it.idHomeTeam
            matchitems.idAwayTeam = it.idAwayTeam
            matchitems.dateEvent = it.dateMatchEvent
            matchitems.strHomeTeam = it.homeMatchTeamName
            matchitems.strAwayTeam = it.awayMatchTeamName
            matchitems.homeBadge = it.homeMatchBadgeTeam
            matchitems.awayBadge = it.awayMatchBadgeTeam
            matchitems.intHomeScore = it.intMatchHomeGoal
            matchitems.intAwayScore = it.intMatchAwayGoal
            matchitems.strHomeGoalDetails = it.homeMatchGoalDetail
            matchitems.strAwayGoalDetails = it.awayMatchGoalDetail
            matchitems.strHomeLineupGoalkeeper = it.homeMatchLineup_GK
            matchitems.strHomeLineupDefense = it.homeMatchLineup_DEF
            matchitems.strHomeLineupMidfield = it.homeMatchLineup_MIDF
            matchitems.strHomeLineupForward = it.homeMatchLineup_FWD
            matchitems.strHomeLineupSubstitutes = it.homeMatchLineup_SUB
            matchitems.strAwayLineupGoalkeeper = it.awayMatchLineup_GK
            matchitems.strAwayLineupDefense = it.awayMatchLineup_DEF
            matchitems.strAwayLineupMidfield = it.awayMatchLineup_MIDF
            matchitems.strAwayLineupForward = it.awayMatchLineup_FWD
            matchitems.strAwayLineupSubstitutes = it.awayMatchLineup_SUB
            matchitems.intAwayShots = it.awayMatch_SHOTS
            matchitems.intHomeShots = it.homeMatch_SHOTS
            matchitems.strTime = it.str_jam
            ctx.startActivity<MatchDetailActivity>("DetailMatch" to matchitems)
        }

        swipetoref.setOnRefreshListener {

            showFavScMatch()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favoritematch, container, false)
    }

    private fun showFavScMatch(){
        context?.matchdatabase?.use {
            val result = select(MatchFavorite.TABLE_MATCH_FAVORITE)
            val favorites = result.parseList(classParser<MatchFavorite>())
            mAdapterfav.addItemMatchFavlist(favorites)

        }
        swipetoref.isRefreshing = false
    }






}