package com.mfr.matchfootballscheduler.ui.TeamClubDetail.PlayerTeamClub

import com.mfr.matchfootballscheduler.data.ModelMatch.clubplayer
import com.mfr.matchfootballscheduler.ui.base.MVPView.MVPView

interface PlayerClubView : MVPView {

    fun showclubplayerlist(dataplayer : List<clubplayer>)
}