package com.mfr.matchfootballscheduler.ui.TeamClubDetail

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.mfr.matchfootballscheduler.R
import com.mfr.matchfootballscheduler.Utils.ExtentionMatch.imageclubload
import com.mfr.matchfootballscheduler.data.MatchDB.matchdatabase
import com.mfr.matchfootballscheduler.data.ModelMatch.FavoriteClubTeam
import com.mfr.matchfootballscheduler.data.ModelMatch.teamitem
import com.mfr.matchfootballscheduler.ui.TeamClubDetail.PlayerTeamClub.clubpalyerinterface
import com.mfr.matchfootballscheduler.ui.TeamClubDetail.overviewteamclub.overviewclubinterface
import com.mfr.matchfootballscheduler.ui.base.BaseActivity.BaseActivity
import kotlinx.android.synthetic.main.team_club_detail.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.koin.android.ext.android.inject

class teamclubdetail : BaseActivity(),teamclubdetailview{
    lateinit var mteamitem: teamitem

    lateinit var getoverviewcallback : overviewclubinterface
    lateinit var getclubplayercallback : clubpalyerinterface

    private lateinit var PagerAdapter: PagerAdapterTeamClub

    val mpresenterdetail: teamclubdetailpresenter<teamclubdetailview> by inject()

    private var isFavoriteScMatch : Boolean = false
    private lateinit var mMenuItem : Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.team_club_detail)
        mteamitem = intent.getParcelableExtra("DetailTeamClub")

        mpresenterdetail.onAttach(this)

        mteamitem.strTeamBadge?.let { imgteamclub.imageclubload(it) }

        supportFragmentManager?.let { PagerAdapter = PagerAdapterTeamClub(it) }
        setupvpadapter()
        favoriteScMatch()
    }

    private fun setupvpadapter() {
        PagerAdapter.count = 2
        vp_teamclub.adapter = PagerAdapter
        tabs_teamclub.addTab(tabs_teamclub.newTab().setText("Overview"))
        tabs_teamclub.addTab(tabs_teamclub.newTab().setText("Player"))
        vp_teamclub.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs_teamclub))
        tabs_teamclub.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) { }

            override fun onTabUnselected(tab: TabLayout.Tab?) { }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let { vp_teamclub.currentItem = it.position }
            }
        })
    }

    fun setOnOverviewTeamClubListener(overviewCallback: overviewclubinterface) {
        this.getoverviewcallback = overviewCallback
        overviewCallback.fetchoverviewcallback(mteamitem.strDescriptionEN)
    }


    fun setOnClubPlayerListener(clubpalyerCallback: clubpalyerinterface) {
        this.getclubplayercallback = clubpalyerCallback
        clubpalyerCallback.fetchclubplayer(mteamitem.idTeam)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.favoriteset, menu)
        mMenuItem = menu
        setScMatchFavorite()
        return super.onCreateOptionsMenu(menu)
    }

    private fun favoriteScMatch(){

        matchdatabase.use {
            val result = select(FavoriteClubTeam.TABLE_FAVORITE_CLUBTEAM).whereArgs("(ID_CLUBTEAM = {id})", "id" to mteamitem.idTeam!!)
            val favorite = result.parseList(classParser<FavoriteClubTeam>())
            if (!favorite.isEmpty()) isFavoriteScMatch = true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.fav_menu -> {

                if (isFavoriteScMatch){
                    mpresenterdetail.removeFavoriteClub(mteamitem)
                    Toast.makeText(applicationContext,"Schedul Removed to favorite", Toast.LENGTH_LONG).show()
                }
                else {
                    mpresenterdetail.getFavoriteClub(mteamitem)
                    Toast.makeText(applicationContext,"Schedul Added to favorite", Toast.LENGTH_LONG).show()
                }

                isFavoriteScMatch = !isFavoriteScMatch
                setScMatchFavorite()

                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setScMatchFavorite() {
        if (isFavoriteScMatch)
            mMenuItem.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_set_fav)
        else
            mMenuItem.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_no_fav)
    }


}