package com.mfr.matchfootballscheduler.data.MatchDB

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import com.mfr.matchfootballscheduler.data.ModelMatch.FavoriteClubTeam
import com.mfr.matchfootballscheduler.data.ModelMatch.MatchFavorite
import com.mfr.matchfootballscheduler.data.ModelMatch.SchedulMatch
import com.mfr.matchfootballscheduler.data.ModelMatch.teamitem
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert

class MatchDBHelper (private val context : Context) : MatchDBInterface {

    override fun addClubTeamFavorite(mteamitem : teamitem){
        try {

            context.matchdatabase.use {
                insert(FavoriteClubTeam.TABLE_FAVORITE_CLUBTEAM,
                        FavoriteClubTeam.ID_CLUBTEAM to mteamitem.idTeam,
                        FavoriteClubTeam.TEAM_CLUBNAME to mteamitem.strTeam,
                        FavoriteClubTeam.IMAGE_CLUBURL to  mteamitem.strTeamBadge,
                        FavoriteClubTeam.OVERVIEW_CLUB to mteamitem.strDescriptionEN
                )

            }

            Log.i("MatchDBHelper", "Added match database ")
        }catch (e: SQLiteConstraintException){
            Log.i("MatchDBHelper", "Added match database failed ")

        }


    }

    override fun removeClubFromFavorite(mteamitem : teamitem) {
        try {
            context.matchdatabase.use {
                delete(FavoriteClubTeam.TABLE_FAVORITE_CLUBTEAM, "(ID_CLUBTEAM = {id})",
                        "id" to mteamitem.idTeam!!)
            }
            Log.i("MatchDBHelper", "remove match database ")

        } catch (e: SQLiteConstraintException) {
            Log.e("MatchDBHelper", "remove match database failed"+e.stackTrace)

        }
    }


    
    override fun addMatchToFavorite(mMatchSchedule : SchedulMatch) {

        try {
            context.matchdatabase.use {
                insert(MatchFavorite.TABLE_MATCH_FAVORITE,
                        MatchFavorite.ID_MATCH_EVENT to mMatchSchedule.idEvent,
                        MatchFavorite.ID_MATCH_HOME to mMatchSchedule.idHomeTeam,
                        MatchFavorite.ID_MATCH_AWAY to mMatchSchedule.idAwayTeam,
                        MatchFavorite.DATE_MATCH_EVENT to mMatchSchedule.dateEvent,
                        MatchFavorite.INT_MATCH_HOME_GOAL to mMatchSchedule.intHomeScore,
                        MatchFavorite.INT_MATCH_AWAY_GOAL to mMatchSchedule.intAwayScore,
                        MatchFavorite.HOME_MATCH_TEAM_NAME to mMatchSchedule.strHomeTeam,
                        MatchFavorite.AWAY_MATCH_TEAM_NAME to mMatchSchedule.strAwayTeam,
                        MatchFavorite.HOME_MATCH_BADGE_TEAM to mMatchSchedule.homeBadge,
                        MatchFavorite.AWAY_MATCH_BADGE_TEAM to mMatchSchedule.awayBadge,
                        MatchFavorite.HOME_MATCH_GOAL_DETAIL to mMatchSchedule.strHomeGoalDetails,
                        MatchFavorite.AWAY_MATCH_GOAL_DETAIL to mMatchSchedule.strAwayGoalDetails,
                        MatchFavorite.HOME_MATCH_LINEUP_GK to mMatchSchedule.strHomeLineupGoalkeeper,
                        MatchFavorite.AWAY_MATCH_LINEUP_GK to mMatchSchedule.strAwayLineupGoalkeeper,
                        MatchFavorite.HOME_MATCH_LINEUP_DEF to mMatchSchedule.strHomeLineupDefense,
                        MatchFavorite.AWAY_MATCH_LINEUP_DEF to mMatchSchedule.strAwayLineupDefense,
                        MatchFavorite.HOME_MATCH_LINEUP_MIDF to mMatchSchedule.strHomeLineupMidfield,
                        MatchFavorite.AWAY_MATCH_LINEUP_MIDF to mMatchSchedule.strAwayLineupMidfield,
                        MatchFavorite.HOME_MATCH_LINEUP_FWD to mMatchSchedule.strHomeLineupForward,
                        MatchFavorite.AWAY_MATCH_LINEUP_FWD to mMatchSchedule.strAwayLineupForward,
                        MatchFavorite.HOME_MATCH_LINEUP_SUB to mMatchSchedule.strHomeLineupSubstitutes,
                        MatchFavorite.AWAY_MATCH_LINEUP_SUB to mMatchSchedule.strAwayLineupSubstitutes,
                        MatchFavorite.HOME_MATCH_SHOTS to mMatchSchedule.intHomeShots,
                        MatchFavorite.AWAY_MATCH_SHOTS to mMatchSchedule.intAwayShots,
                        MatchFavorite.STR_TIME to mMatchSchedule.strTime
                )
            }
            Log.i("MatchDBHelper", "Added match database ")

        } catch (e: SQLiteConstraintException) {
            Log.i("MatchDBHelper", "Added  match database failed")

        }
    }

    override fun removeMatchFromFavorite(mMatchSchedule : SchedulMatch) {
        try {
            context.matchdatabase.use {
                delete(MatchFavorite.TABLE_MATCH_FAVORITE, "(ID_MATCH_EVENT = {id})",
                        "id" to mMatchSchedule.idEvent!!)
            }
            Log.i("MatchDBHelper", "remove match database ")

        } catch (e: SQLiteConstraintException) {
            Log.e("MatchDBHelper", "remove match database failed"+e.stackTrace)

        }
    }

}