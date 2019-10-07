package com.mfr.matchfootballscheduler.ui.Favorite.ClubPlayerFavorite

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mfr.matchfootballscheduler.R
import com.mfr.matchfootballscheduler.data.MatchDB.matchdatabase
import com.mfr.matchfootballscheduler.data.ModelMatch.FavoriteClubTeam
import com.mfr.matchfootballscheduler.data.ModelMatch.teamitem
import com.mfr.matchfootballscheduler.ui.TeamClubDetail.teamclubdetail
import com.mfr.matchfootballscheduler.ui.base.BaseFragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_favorite_clubteam.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx
import org.koin.android.ext.android.inject

class FragmentFavClubTeam : BaseFragment() {

    companion object {

        fun newInstance(): FragmentFavClubTeam = FragmentFavClubTeam()
    }


    val mAdapterfav : ClubTeamAdapter by inject()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rcv_fragment_clubfav.layoutManager = LinearLayoutManager(activity)
        rcv_fragment_clubfav.adapter = mAdapterfav
        showFavScMatch()

        mAdapterfav.setFavClubOnclickListener {
            val itemsclub = teamitem()
            itemsclub.idTeam = it.IdClub
            itemsclub.strTeam = it.nameclub
            itemsclub.strTeamBadge = it.imageUrl
            itemsclub.strDescriptionEN = it.overviewclub


            ctx.startActivity<teamclubdetail>("DetailTeamClub" to itemsclub)
        }

        swipetorefs.setOnRefreshListener {

            showFavScMatch()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorite_clubteam, container, false)
    }

    private fun showFavScMatch(){
        context?.matchdatabase?.use {
            val result = select(FavoriteClubTeam.TABLE_FAVORITE_CLUBTEAM)
            val favorites = result.parseList(classParser<FavoriteClubTeam>())
            mAdapterfav.addClubToList(favorites)

        }
        swipetorefs.isRefreshing = false
    }
}


