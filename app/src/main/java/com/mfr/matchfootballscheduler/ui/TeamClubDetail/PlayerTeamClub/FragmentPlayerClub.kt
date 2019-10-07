package com.mfr.matchfootballscheduler.ui.TeamClubDetail.PlayerTeamClub

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mfr.matchfootballscheduler.R
import com.mfr.matchfootballscheduler.data.ModelMatch.clubplayer
import com.mfr.matchfootballscheduler.ui.ClubDetailPlayer.ClubPlayerActivity
import com.mfr.matchfootballscheduler.ui.TeamClubDetail.teamclubdetail
import com.mfr.matchfootballscheduler.ui.base.BaseFragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_clubplyer.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx
import org.koin.android.ext.android.inject

class FragmentPlayerClub : BaseFragment() ,PlayerClubView,clubpalyerinterface{



    companion object {

        fun newInstance(): FragmentPlayerClub = FragmentPlayerClub()
    }

    val mpresenter: PlayerClubPresenter<PlayerClubView> by inject()
    val mAdapterclubpalyer : PlayerClubAdapter by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rcv_fragmentplayer.layoutManager = LinearLayoutManager(activity)
        rcv_fragmentplayer.adapter = mAdapterclubpalyer
        (activity as teamclubdetail).setOnClubPlayerListener(this)

        mpresenter.onAttach(this)

        mAdapterclubpalyer.setOnClubPlayerCLickListener {
            ctx.startActivity<ClubPlayerActivity>("ClubPlayerDetail" to it)
        }

    }

    override fun fetchclubplayer(idteam: String?) {
        mpresenter.getclubpalyer(idteam)
    }

    override fun showclubplayerlist(dataplayer: List<clubplayer>) {
        mAdapterclubpalyer.addItemList(dataplayer)
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_clubplyer, container, false)
    }
}