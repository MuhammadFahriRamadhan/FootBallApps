package com.mfr.matchfootballscheduler.data


import com.mfr.matchfootballscheduler.data.MatchDB.MatchDBInterface
import com.mfr.matchfootballscheduler.data.ModelMatch.*
import com.mfr.matchfootballscheduler.data.matchAPI.ApiHelperInterface
import io.reactivex.Single

class DataManager(private val ApiMatchHelper: ApiHelperInterface,private val DBScMatch : MatchDBInterface) : DataManagerInterface {
    override fun SeachTeamClub(queryclubteam: String?): Single<teamitemresponse> = ApiMatchHelper.SeachTeamClub(queryclubteam)

    override fun SearchScMatchClub(querymatch: String?): Single<SearchScMatchResponse> = ApiMatchHelper.SearchScMatchClub(querymatch)

    override fun addClubTeamFavorite(mteamitem: teamitem) = DBScMatch.addClubTeamFavorite(mteamitem)
    override fun removeClubFromFavorite(mteamitem: teamitem) = DBScMatch.removeClubFromFavorite(mteamitem)
    override fun ClubPlayerList(idplayer: String?): Single<clubplayerresponse> = ApiMatchHelper.ClubPlayerList(idplayer)

    override fun ClubTeamList(teamitem: String?): Single<teamitemresponse> = ApiMatchHelper.ClubTeamList(teamitem)

    override fun addMatchToFavorite(mMatchSchedule: SchedulMatch) {
        DBScMatch.addMatchToFavorite(mMatchSchedule)
    }

    override fun removeMatchFromFavorite(mMatchSchedule: SchedulMatch) {
        DBScMatch.removeMatchFromFavorite(mMatchSchedule)
    }


    override fun LastMatchList(matchleagueId: String?): Single<MatchResponse> = ApiMatchHelper.LastMatchList(matchleagueId)

    override fun NextMatchList(matchleagueId: String?): Single<MatchResponse> = ApiMatchHelper.NextMatchList(matchleagueId)

    override fun ClubTeamDetail(matchleagueId: String?): Single<ClubTeamResponse> = ApiMatchHelper.ClubTeamDetail(matchleagueId)

}