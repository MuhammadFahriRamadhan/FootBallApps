package com.mfr.matchfootballscheduler.ui.ScDetailMatch

import android.util.Log
import com.mfr.matchfootballscheduler.Utils.EspressoTest
import com.mfr.matchfootballscheduler.Utils.ScProviderInterface
import com.mfr.matchfootballscheduler.data.DataManagerInterface
import com.mfr.matchfootballscheduler.data.ModelMatch.SchedulMatch
import com.mfr.matchfootballscheduler.ui.base.BasePresenter.BasePresenter

class MatchDetailPresenter<V : MatchDetailView> constructor(DataManager: DataManagerInterface, ScheculerProvider: ScProviderInterface,private val espressotest : EspressoTest) : BasePresenter<V>(DataManager = DataManager, ScheculerProvider = ScheculerProvider) {

    fun setClubTeamHome(leagueId: String?) {
        espressotest.testincrement()
        compositeDisposable.add(DataManager.ClubTeamDetail(leagueId)
                .compose(ScheculerProvider.ioToMainSingleScheduler())
                .subscribe({ clubmatches ->

                    getView()?.let {

                        it.showClubImageHome(clubmatches.teams)
                    }

                    espressotest.testdecrement()

                }, {

                    Log.e("geterror", "Error : ${it.message}")
                    espressotest.testdecrement()

                }))
    }

    fun setClubTeamAway(ClubId: String?) {
        espressotest.testincrement()
        compositeDisposable.add(DataManager.ClubTeamDetail(ClubId)
                .compose(ScheculerProvider.ioToMainSingleScheduler())
                .subscribe({ clubmatches ->

                    getView()?.let {

                        it.showClubImageAway(clubmatches.teams)
                    }
                    espressotest.testdecrement()
                }, {

                    Log.e("geterror", "Error : ${it.message}")
                    espressotest.testdecrement()

                }))
    }


    fun getFavoriteClub(mMatchSchedule : SchedulMatch){

        DataManager.addMatchToFavorite(mMatchSchedule)
    }

    fun removeFavoriteClub(mMatchSchedule : SchedulMatch){

        DataManager.removeMatchFromFavorite(mMatchSchedule)
    }
}