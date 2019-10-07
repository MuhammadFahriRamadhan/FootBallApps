package com.mfr.matchfootballscheduler.ui.ClubDetailPlayer

import android.os.Bundle
import android.util.Log
import com.mfr.matchfootballscheduler.R
import com.mfr.matchfootballscheduler.Utils.ExtentionMatch.imageclubload
import com.mfr.matchfootballscheduler.data.ModelMatch.clubplayer
import com.mfr.matchfootballscheduler.ui.base.BaseActivity.BaseActivity
import kotlinx.android.synthetic.main.activity_detail_clubplayer.*

class ClubPlayerActivity : BaseActivity() {

    lateinit var  mclubplayer : clubplayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_clubplayer)
        setSupportActionBar(toolbar)



        Log.e("gettt","yaa")
        mclubplayer = intent.getParcelableExtra("ClubPlayerDetail")

        Log.e("ClubPlayerActivity","player:"+mclubplayer.strPosition)
        Log.e("gettt","yaa"+mclubplayer.strPlayer)

        mclubplayer.strThumb?.let { imagec_playerdetail.imageclubload(it) }
        mclubplayer.strCutout?.let { img_players.imageclubload(it) }

        toolbar_text.text = mclubplayer.strPlayer
        tv_playerpostion_detail.text = mclubplayer.strPosition
        tv_yearplayer.text = mclubplayer.dateBorn
        tv_overviewpalyer.text = mclubplayer.strDescriptionEN
        tv_weight.text =  mclubplayer.strWeight
        tv_height.text =  mclubplayer.strHeight


    }
}