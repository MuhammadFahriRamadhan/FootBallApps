package com.mfr.matchfootballscheduler.di.module

import com.mfr.matchfootballscheduler.Utils.EspressoTest
import com.mfr.matchfootballscheduler.Utils.ScProviderInterface
import com.mfr.matchfootballscheduler.Utils.Schedulerprovider
import com.mfr.matchfootballscheduler.data.DataManager
import com.mfr.matchfootballscheduler.data.DataManagerInterface
import com.mfr.matchfootballscheduler.data.MatchDB.MatchDBHelper
import com.mfr.matchfootballscheduler.data.MatchDB.MatchDBInterface
import com.mfr.matchfootballscheduler.data.matchAPI.ApiHelperInterface
import com.mfr.matchfootballscheduler.data.matchAPI.MatchApiHelper
import com.mfr.matchfootballscheduler.ui.Favorite.ClubPlayerFavorite.ClubTeamAdapter
import com.mfr.matchfootballscheduler.ui.Favorite.MatchFavorite.MatchFavScAdapter
import com.mfr.matchfootballscheduler.ui.ScDetailMatch.MatchDetailPresenter
import com.mfr.matchfootballscheduler.ui.ScDetailMatch.MatchDetailView
import com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchNext.MatchNextAdapter
import com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchNext.MatchNextPresenter
import com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchNext.MatchNextView
import com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchPrevious.MatchLastAdapter
import com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchPrevious.MatchLastView
import com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchPrevious.MatchPrevPresenter
import com.mfr.matchfootballscheduler.ui.TeamClubDetail.PlayerTeamClub.PlayerClubAdapter
import com.mfr.matchfootballscheduler.ui.TeamClubDetail.PlayerTeamClub.PlayerClubPresenter
import com.mfr.matchfootballscheduler.ui.TeamClubDetail.PlayerTeamClub.PlayerClubView
import com.mfr.matchfootballscheduler.ui.TeamClubDetail.teamclubdetailpresenter
import com.mfr.matchfootballscheduler.ui.TeamClubDetail.teamclubdetailview
import com.mfr.matchfootballscheduler.ui.teamclub.TeamClubAdapter
import com.mfr.matchfootballscheduler.ui.teamclub.TeamClubPresenter
import com.mfr.matchfootballscheduler.ui.teamclub.TeamClubView
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

object AppModule {

    fun getModule(): Module = applicationContext {
        factory { MatchPrevPresenter<MatchLastView>(get(), get(),get()) }
        factory { MatchNextPresenter<MatchNextView>(get(), get(),get()) }
        factory { MatchDetailPresenter<MatchDetailView>(get(), get(),get()) }
        factory { TeamClubPresenter<TeamClubView>(get(), get()) }
        factory { teamclubdetailpresenter<teamclubdetailview>(get(), get()) }
        factory { PlayerClubPresenter<PlayerClubView>(get(), get()) }


        bean { MatchLastAdapter(ArrayList()) }
        bean { MatchNextAdapter(ArrayList()) }
        bean { MatchFavScAdapter(ArrayList()) }
        bean { TeamClubAdapter(ArrayList()) }
        bean { PlayerClubAdapter(ArrayList()) }
        bean { ClubTeamAdapter(ArrayList()) }

        bean { DataManager(get(),get()) as DataManagerInterface }
        bean { MatchApiHelper() as ApiHelperInterface }
        bean { MatchDBHelper(get()) as MatchDBInterface }

        bean { Schedulerprovider() as ScProviderInterface }
        bean { EspressoTest() }

    }


}