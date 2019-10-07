package com.mfr.matchfootballscheduler.data.matchAPI

import com.mfr.matchfootballscheduler.data.ModelMatch.*
import io.reactivex.Single

interface ApiHelperInterface {

    fun LastMatchList(matchleagueId: String?): Single<MatchResponse>

    fun NextMatchList(matchleagueId: String?): Single<MatchResponse>

    fun ClubTeamDetail(matchleagueId: String?): Single<ClubTeamResponse>

    fun ClubTeamList(teamitem : String?): Single<teamitemresponse>

    fun ClubPlayerList(idplayer: String?): Single<clubplayerresponse>

    fun SearchScMatchClub(querymatch : String?) : Single<SearchScMatchResponse>

    fun SeachTeamClub(queryclubteam : String?) : Single<teamitemresponse>


}