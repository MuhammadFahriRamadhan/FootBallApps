package com.mfr.matchfootballscheduler.ui.TeamClubDetail.PlayerTeamClub

import android.util.Log
import com.mfr.matchfootballscheduler.Utils.ScProviderInterface
import com.mfr.matchfootballscheduler.data.DataManagerInterface
import com.mfr.matchfootballscheduler.ui.base.BasePresenter.BasePresenter

class PlayerClubPresenter<V : PlayerClubView> constructor(dataManager : DataManagerInterface, scProvider: ScProviderInterface) : BasePresenter<V>(DataManager = dataManager, ScheculerProvider = scProvider) {


    fun getclubpalyer(idteam : String?){
        compositeDisposable.add(DataManager.ClubPlayerList(idteam)
                .compose(ScheculerProvider.ioToMainSingleScheduler())
                .subscribe({ mpalyerresponse ->

                    mpalyerresponse.players?.let { getView()?.showclubplayerlist(it) }


                },{
                    Log.e("clubplayerpresenter","${it.message}")
                }

                )
                )

    }
}