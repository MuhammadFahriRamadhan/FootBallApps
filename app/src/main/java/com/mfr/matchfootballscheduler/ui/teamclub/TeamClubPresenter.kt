package com.mfr.matchfootballscheduler.ui.teamclub

import android.util.Log
import com.mfr.matchfootballscheduler.Utils.ScProviderInterface
import com.mfr.matchfootballscheduler.data.DataManagerInterface
import com.mfr.matchfootballscheduler.ui.base.BasePresenter.BasePresenter
import java.util.concurrent.TimeUnit

class TeamClubPresenter<V : TeamClubView> constructor(dataManager : DataManagerInterface, scProvider: ScProviderInterface) : BasePresenter<V>(DataManager = dataManager, ScheculerProvider = scProvider) {

    fun getTeamClubList(leagueName: String?) {

        compositeDisposable.add(DataManager.ClubTeamList(leagueName)
                .compose(ScheculerProvider.ioToMainSingleScheduler())
                .subscribe({

                    getView()?.showTeamList(it.teams)

                    Log.e("", "Team TeamClubPresenter : ${it.teams}")
                }, {

                    Log.e("", "Team Fragment : ${it.message}")


                }))

    }

    fun setSearchTeamClubList(query : String?){

        compositeDisposable.add(DataManager.SeachTeamClub(query)
                .toObservable()
                .debounce(1000, TimeUnit.MILLISECONDS)
                .compose(ScheculerProvider.ioToMainObservableScheduler())
                .subscribe({

                    getView()?.showTeamList(it.teams)
                    Log.e("MatchPrevPresenter", "getPrevMatch : ${it.teams}")

                }, {

                    Log.e("MatchPrevPresenter", "Error PrevMatch : ${it.message}")


                }))
    }
}