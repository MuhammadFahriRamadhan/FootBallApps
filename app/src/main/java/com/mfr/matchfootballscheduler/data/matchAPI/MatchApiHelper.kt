package com.mfr.matchfootballscheduler.data.matchAPI

import com.mfr.matchfootballscheduler.data.ModelMatch.*
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

class MatchApiHelper : ApiHelperInterface {
    override fun SeachTeamClub(queryclubteam: String?): Single<teamitemresponse> =
            Rx2AndroidNetworking.get(SportDbApi.SEARCH_TEAMCLUB)
                    .addQueryParameter("t", queryclubteam)
                    .build()
                    .getObjectSingle(teamitemresponse::class.java)

    override fun SearchScMatchClub(querymatch: String?): Single<SearchScMatchResponse> =
            Rx2AndroidNetworking.get(SportDbApi.SEARCH_SCMATCHCLUB)
            .addQueryParameter("e", querymatch)
            .build()
            .getObjectSingle(SearchScMatchResponse::class.java)

    override fun ClubTeamList(teamitem: String?): Single<teamitemresponse> =
            Rx2AndroidNetworking.get(SportDbApi.CLUBTEAM)
                    .addQueryParameter("l", teamitem)
                    .build()
                    .getObjectSingle(teamitemresponse::class.java)



    override fun LastMatchList(matchleagueId: String?): Single<MatchResponse> =
            Rx2AndroidNetworking.get(SportDbApi.LAST_MATCH)
                    .addQueryParameter("id", matchleagueId)
                    .build()
                    .getObjectSingle(MatchResponse::class.java)

    override fun NextMatchList(matchleagueId: String?): Single<MatchResponse> =
            Rx2AndroidNetworking.get(SportDbApi.MATCH_NEXT)
                    .addQueryParameter("id", matchleagueId)
                    .build()
                    .getObjectSingle(MatchResponse::class.java)


    override fun ClubTeamDetail(clubteamId: String?): Single<ClubTeamResponse> =
            Rx2AndroidNetworking.get(SportDbApi.DETAIL_MATCHTEAM)
                    .addQueryParameter("id", clubteamId)
                    .build()
                    .getObjectSingle(ClubTeamResponse::class.java)

    override fun ClubPlayerList(idclubpalyer: String?): Single<clubplayerresponse> =
            Rx2AndroidNetworking.get(SportDbApi.CLUBPLAYER)
                    .addQueryParameter("id", idclubpalyer)
                    .build()
                    .getObjectSingle(clubplayerresponse::class.java)





}