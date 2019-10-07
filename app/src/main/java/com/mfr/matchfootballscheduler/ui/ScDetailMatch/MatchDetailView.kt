package com.mfr.matchfootballscheduler.ui.ScDetailMatch


import com.mfr.matchfootballscheduler.data.ModelMatch.TeamsClubItem
import com.mfr.matchfootballscheduler.ui.base.MVPView.MVPView

interface MatchDetailView : MVPView {

    fun showClubImageHome(clubteams: List<TeamsClubItem>)

    fun showClubImageAway(clubteams: List<TeamsClubItem>)
}