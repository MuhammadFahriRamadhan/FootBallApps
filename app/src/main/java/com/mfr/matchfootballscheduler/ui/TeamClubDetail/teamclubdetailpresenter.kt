package com.mfr.matchfootballscheduler.ui.TeamClubDetail

import com.mfr.matchfootballscheduler.Utils.ScProviderInterface
import com.mfr.matchfootballscheduler.data.DataManagerInterface
import com.mfr.matchfootballscheduler.data.ModelMatch.teamitem
import com.mfr.matchfootballscheduler.ui.base.BasePresenter.BasePresenter

class teamclubdetailpresenter<V : teamclubdetailview> constructor(dataManager : DataManagerInterface, scProvider: ScProviderInterface) : BasePresenter<V>(DataManager = dataManager, ScheculerProvider = scProvider) {


    fun getFavoriteClub(mteamitem : teamitem){

        DataManager.addClubTeamFavorite(mteamitem)
    }

    fun removeFavoriteClub(mteamitem : teamitem){

        DataManager.removeClubFromFavorite(mteamitem)
    }

}