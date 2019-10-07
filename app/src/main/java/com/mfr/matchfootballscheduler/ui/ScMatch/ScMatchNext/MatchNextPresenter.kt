package com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchNext

import android.util.Log
import com.mfr.matchfootballscheduler.Utils.EspressoTest
import com.mfr.matchfootballscheduler.Utils.ScProviderInterface
import com.mfr.matchfootballscheduler.data.DataManagerInterface
import com.mfr.matchfootballscheduler.ui.base.BasePresenter.BasePresenter
import java.util.concurrent.TimeUnit

class MatchNextPresenter<V : MatchNextView> constructor(DataManager: DataManagerInterface, ScheculerProvider: ScProviderInterface, private val espressotest : EspressoTest) : BasePresenter<V>(DataManager = DataManager, ScheculerProvider = ScheculerProvider) {

    fun getMatchNextList(leagueId: String?) {
        espressotest.testincrement()
        compositeDisposable.add(DataManager.NextMatchList(leagueId)
                .compose(ScheculerProvider.ioToMainSingleScheduler())
                .subscribe({ clubmatches ->

                    getView()?.let {
                        it.showNextMatchList(clubmatches.events)
                    }
                    espressotest.testdecrement()

                }, {

                    Log.e("MatchPrevPresenter", "Error PrevMatch : ${it.message}")
                    espressotest.testdecrement()

                }))
    }


    fun setSearchMatchList(query : String?){

        compositeDisposable.add(DataManager.SearchScMatchClub(query)
                .toObservable()
                .debounce(1000, TimeUnit.MILLISECONDS)
                .compose(ScheculerProvider.ioToMainObservableScheduler())
                .subscribe({ clubmatches ->

                    getView()?.let {
                        it.showNextMatchList(clubmatches.events!!)
                    }
                    Log.e("MatchNextPresenter", "getPrevMatch : ${clubmatches.events}")

                }, {

                    Log.e("MatchPrevPresenter", "Error PrevMatch : ${it.message}")


                }))
    }
}