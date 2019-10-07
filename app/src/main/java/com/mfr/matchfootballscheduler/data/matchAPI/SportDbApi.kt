package com.mfr.matchfootballscheduler.data.matchAPI

import com.mfr.matchfootballscheduler.BuildConfig

object SportDbApi {

    const val LAST_MATCH = BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/eventspastleague.php"

    const val MATCH_NEXT = BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/eventsnextleague.php"

    const val DETAIL_MATCHTEAM = BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookupteam.php"

    const val CLUBTEAM = BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/search_all_teams.php"

    const val SEARCH_SCMATCHCLUB = BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/searchevents.php"

    const val SEARCH_TEAMCLUB = BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/searchteams.php"

    const val CLUBPLAYER = BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookup_all_players.php"

}