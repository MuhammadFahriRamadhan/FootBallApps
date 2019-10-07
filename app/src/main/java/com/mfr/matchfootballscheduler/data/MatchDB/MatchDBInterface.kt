package com.mfr.matchfootballscheduler.data.MatchDB

import com.mfr.matchfootballscheduler.data.ModelMatch.SchedulMatch
import com.mfr.matchfootballscheduler.data.ModelMatch.teamitem

interface MatchDBInterface {

    fun addMatchToFavorite(mMatchSchedule : SchedulMatch)
    fun removeMatchFromFavorite(mMatchSchedule : SchedulMatch)
    fun addClubTeamFavorite(mteamitem : teamitem)
    fun removeClubFromFavorite(mteamitem : teamitem)
}