package com.mfr.matchfootballscheduler.data.MatchDB

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.mfr.matchfootballscheduler.data.ModelMatch.FavoriteClubTeam
import com.mfr.matchfootballscheduler.data.ModelMatch.MatchFavorite
import org.jetbrains.anko.db.*

class MatchDBOpenHelper (ctx: Context) : ManagedSQLiteOpenHelper(ctx,  "MatchClubFavorite.db", null, 1) {
    companion object {
        private var instance: MatchDBOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context) = instance ?: MatchDBOpenHelper(ctx)
    }

    override fun onCreate(dbmatch : SQLiteDatabase?) {
        if (dbmatch != null) {
            dbmatch.createTable(MatchFavorite.TABLE_MATCH_FAVORITE, true,
                    MatchFavorite.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                    MatchFavorite.ID_MATCH_EVENT to TEXT ,
                    MatchFavorite.ID_MATCH_HOME to TEXT ,
                    MatchFavorite.ID_MATCH_AWAY to TEXT ,
                    MatchFavorite.DATE_MATCH_EVENT to TEXT,
                    MatchFavorite.HOME_MATCH_TEAM_NAME to TEXT,
                    MatchFavorite.AWAY_MATCH_TEAM_NAME to TEXT,
                    MatchFavorite.HOME_MATCH_BADGE_TEAM to TEXT,
                    MatchFavorite.AWAY_MATCH_BADGE_TEAM to TEXT,
                    MatchFavorite.INT_MATCH_HOME_GOAL to TEXT,
                    MatchFavorite.INT_MATCH_AWAY_GOAL to TEXT,
                    MatchFavorite.HOME_MATCH_GOAL_DETAIL to TEXT,
                    MatchFavorite.AWAY_MATCH_GOAL_DETAIL to TEXT,
                    MatchFavorite.HOME_MATCH_LINEUP_GK to TEXT,
                    MatchFavorite.AWAY_MATCH_LINEUP_GK to TEXT,
                    MatchFavorite.HOME_MATCH_LINEUP_DEF to TEXT,
                    MatchFavorite.AWAY_MATCH_LINEUP_DEF to TEXT,
                    MatchFavorite.HOME_MATCH_LINEUP_MIDF to TEXT,
                    MatchFavorite.AWAY_MATCH_LINEUP_MIDF to TEXT,
                    MatchFavorite.HOME_MATCH_LINEUP_FWD to TEXT,
                    MatchFavorite.AWAY_MATCH_LINEUP_FWD to TEXT,
                    MatchFavorite.HOME_MATCH_LINEUP_SUB to TEXT,
                    MatchFavorite.AWAY_MATCH_LINEUP_SUB to TEXT,
                    MatchFavorite.HOME_MATCH_SHOTS to TEXT,
                    MatchFavorite.AWAY_MATCH_SHOTS to TEXT,
                    MatchFavorite.STR_TIME to TEXT
                    )

            dbmatch.createTable(FavoriteClubTeam.TABLE_FAVORITE_CLUBTEAM,true,
                    FavoriteClubTeam.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                    FavoriteClubTeam.ID_CLUBTEAM to TEXT + UNIQUE,
                    FavoriteClubTeam.IMAGE_CLUBURL to TEXT,
                    FavoriteClubTeam.TEAM_CLUBNAME to TEXT,
                    FavoriteClubTeam.OVERVIEW_CLUB to TEXT
                    )
        }
    }




    override fun onUpgrade(dbmatch : SQLiteDatabase?, p1: Int, p2: Int) {
        if (dbmatch != null) {
            dbmatch.dropTable(MatchFavorite.TABLE_MATCH_FAVORITE, true)
            dbmatch.dropTable(FavoriteClubTeam.TABLE_FAVORITE_CLUBTEAM, true)
        }
    }
}

val Context.matchdatabase : MatchDBOpenHelper
    get() = MatchDBOpenHelper.getInstance(applicationContext)