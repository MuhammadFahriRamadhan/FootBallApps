package com.mfr.matchfootballscheduler.data.ModelMatch

class scleaguespnr(var idleague : String? = null,
                         var nameleague : String? = null
                         )

object ScLeague {

    fun ScLeagueSpinnerList() : List<scleaguespnr> = arrayListOf(
            scleaguespnr("4328", "English Premier League" ),
            scleaguespnr("4329", "English League Championship"),
            scleaguespnr("4331", "German Bundesliga"),
            scleaguespnr("4332", "Italian Serie A"),
            scleaguespnr("4334", "French Ligue 1"),
            scleaguespnr("4335", "Spanish La Liga"))
}
