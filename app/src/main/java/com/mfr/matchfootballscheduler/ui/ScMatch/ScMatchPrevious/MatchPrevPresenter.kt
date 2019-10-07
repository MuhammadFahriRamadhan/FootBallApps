package com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchPrevious

import android.util.Log
import com.mfr.matchfootballscheduler.Utils.EspressoTest
import com.mfr.matchfootballscheduler.Utils.ScProviderInterface
import com.mfr.matchfootballscheduler.data.DataManagerInterface
import com.mfr.matchfootballscheduler.ui.base.BasePresenter.BasePresenter
import java.util.concurrent.TimeUnit

class MatchPrevPresenter<V : MatchLastView> constructor(DataManager: DataManagerInterface, ScheculerProvider: ScProviderInterface, private val espressotest : EspressoTest) : BasePresenter<V>(DataManager = DataManager, ScheculerProvider = ScheculerProvider) {

    fun getMatchPrevList(leagueId: String?) {

        espressotest.testincrement()
        compositeDisposable.add(DataManager.LastMatchList(leagueId)
                .compose(ScheculerProvider.ioToMainSingleScheduler())
                .subscribe({ clubmatches ->

                    getView()?.let {
                        it.showPrevMatchList(clubmatches.events)
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
                        it.showPrevMatchList(clubmatches.events!!)
                    }
                    Log.e("MatchPrevPresenter", "getPrevMatch : ${clubmatches.events}")

                }, {

                    Log.e("MatchPrevPresenter", "Error PrevMatch : ${it.message}")


                }))
    }


}