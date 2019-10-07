package com.mfr.matchfootballscheduler.data.ModelMatch

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class MatchFavorite(val id : Long?,
                    val idMatchEvent: String?,
                    val idHomeTeam: String?,
                    val idAwayTeam: String?,
                    val dateMatchEvent: String?,
                    val homeMatchTeamName: String?,
                    val awayMatchTeamName: String?,
                    val homeMatchBadgeTeam: String?,
                    val awayMatchBadgeTeam: String?,
                    val intMatchHomeGoal: String?,
                    val intMatchAwayGoal: String?,
                    val homeMatchGoalDetail: String?,
                    val awayMatchGoalDetail: String?,
                    val homeMatchLineup_GK: String?,
                    val awayMatchLineup_GK: String?,
                    val homeMatchLineup_DEF: String?,
                    val awayMatchLineup_DEF: String?,
                    val homeMatchLineup_MIDF: String?,
                    val awayMatchLineup_MIDF: String?,
                    val homeMatchLineup_FWD: String?,
                    val awayMatchLineup_FWD: String?,
                    val homeMatchLineup_SUB: String?,
                    val awayMatchLineup_SUB: String?,
                    val homeMatch_SHOTS: String?,
                    val awayMatch_SHOTS: String?,
                    val str_jam :String?
                    ) : Parcelable {

    companion object {
        const val TABLE_MATCH_FAVORITE: String = "TABLE_MATCH_FAVORITE"
        const val ID: String = "ID"
        const val ID_MATCH_EVENT: String = "ID_MATCH_EVENT"
        const val ID_MATCH_HOME: String = "ID_MATCH_HOME"
        const val ID_MATCH_AWAY: String = "ID_MATCH_AWAY"
        const val DATE_MATCH_EVENT: String = "DATE_MATCH_EVENT"
        const val HOME_MATCH_TEAM_NAME: String = "HOME_MATCH_TEAM_NAME"
        const val AWAY_MATCH_TEAM_NAME: String = "AWAY_MATCH_TEAM_NAME"
        const val HOME_MATCH_BADGE_TEAM: String = "HOME_MATCH_BADGE_TEAM"
        const val AWAY_MATCH_BADGE_TEAM: String = "AWAY_MATCH_BADGE_TEAM"
        const val INT_MATCH_HOME_GOAL: String = "INT_MATCH_HOME_GOAL"
        const val INT_MATCH_AWAY_GOAL: String = "INT_MATCH_AWAY_GOAL"
        const val HOME_MATCH_GOAL_DETAIL: String = "HOME_MATCH_GOAL_DETAIL"
        const val AWAY_MATCH_GOAL_DETAIL: String = "AWAY_MATCH_GOAL_DETAIL"
        const val HOME_MATCH_LINEUP_GK: String = "HOME_MATCH_LINEUP_GK"
        const val AWAY_MATCH_LINEUP_GK: String = "AWAY_MATCH_LINEUP_GK"
        const val HOME_MATCH_LINEUP_DEF: String = "HOME_MATCH_LINEUP_DEF"
        const val AWAY_MATCH_LINEUP_DEF: String = "AWAY_MATCH_LINEUP_DEF"
        const val HOME_MATCH_LINEUP_MIDF: String = "HOME_MATCH_LINEUP_MIDF"
        const val AWAY_MATCH_LINEUP_MIDF: String = "AWAY_MATCH_LINEUP_MIDF"
        const val HOME_MATCH_LINEUP_FWD: String = "HOME_MATCH_LINEUP_FWD"
        const val AWAY_MATCH_LINEUP_FWD: String = "AWAY_MATCH_LINEUP_FWD"
        const val HOME_MATCH_LINEUP_SUB: String = "HOME_MATCH_LINEUP_SUB"
        const val AWAY_MATCH_LINEUP_SUB: String = "AWAY_MATCH_LINEUP_SUB"
        const val HOME_MATCH_SHOTS: String = "HOME_MATCH_SHOTS"
        const val AWAY_MATCH_SHOTS: String = "AWAY_MATCH_SHOTS"
        const val STR_TIME : String = "STR_TIME"


    }



}