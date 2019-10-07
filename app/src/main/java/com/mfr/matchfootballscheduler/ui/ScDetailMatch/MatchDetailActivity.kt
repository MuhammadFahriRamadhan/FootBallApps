package com.mfr.matchfootballscheduler.ui.ScDetailMatch


import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.mfr.matchfootballscheduler.R
import com.mfr.matchfootballscheduler.Utils.ExtentionMatch.convertime
import com.mfr.matchfootballscheduler.Utils.ExtentionMatch.imageclubload
import com.mfr.matchfootballscheduler.data.MatchDB.matchdatabase
import com.mfr.matchfootballscheduler.data.ModelMatch.MatchFavorite
import com.mfr.matchfootballscheduler.data.ModelMatch.SchedulMatch
import com.mfr.matchfootballscheduler.data.ModelMatch.TeamsClubItem
import com.mfr.matchfootballscheduler.ui.base.BaseActivity.BaseActivity
import kotlinx.android.synthetic.main.activity_matchdetail.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.koin.android.ext.android.inject


class MatchDetailActivity : BaseActivity(), MatchDetailView {
    lateinit var mMatchSchedule: SchedulMatch


    val mpresenterdetail: MatchDetailPresenter<MatchDetailView> by inject()
    private var isFavoriteScMatch : Boolean = false
    private lateinit var mMenuItem : Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matchdetail)
        mMatchSchedule = intent.getParcelableExtra("DetailMatch")


        mpresenterdetail.onAttach(this)

        setdatamatch(mMatchSchedule)

        mpresenterdetail.setClubTeamHome(mMatchSchedule.idHomeTeam)
        mpresenterdetail.setClubTeamAway(mMatchSchedule.idAwayTeam)

        favoriteScMatch()
    }

    private fun setdatamatch(results: SchedulMatch) {
        tv_jamdetail.text = convertime(results.strTime!!)
        tv_datedetail.text = results.dateEvent
        tv_gkhome.text = results.strHomeLineupGoalkeeper
        tv_gkaway.text = results.strAwayLineupGoalkeeper
        tv_homedefense.text = results.strHomeLineupDefense
        tv_awaydefense.text = results.strAwayLineupDefense
        tv_midlehome.text = results.strHomeLineupMidfield
        tv_midleaway.text = results.strAwayLineupMidfield
        tv_fowardhome.text = results.strHomeLineupForward
        tv_forwardaway.text = results.strAwayLineupForward
        tv_homesub.text = results.strHomeLineupSubstitutes
        tv_awaysub.text = results.strAwayLineupSubstitutes
        tv_hometeamdetail.text = results.strHomeTeam
        tv_scr_homedetail.text = results.intHomeScore
        tv_awaydetailteam.text = results.strAwayTeam
        tv_scr_awaydetail.text = results.intAwayScore
        tv_goalhome.text = results.strHomeGoalDetails
        tv_goalaway.text = results.strAwayGoalDetails
        tv_shotshome.text = results.intHomeShots
        tv_shotaway.text = results.intAwayShots

        Log.e("getttshot", "" + results.intHomeShots)


    }


    private fun favoriteScMatch(){

        matchdatabase.use {
            val result = select(MatchFavorite.TABLE_MATCH_FAVORITE).whereArgs("(ID_MATCH_EVENT = {id})", "id" to mMatchSchedule.idEvent!!)
            val favorite = result.parseList(classParser<MatchFavorite>())
            if (!favorite.isEmpty()) isFavoriteScMatch = true
        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.favoriteset, menu)
        mMenuItem = menu
        setScMatchFavorite()
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.fav_menu -> {

                if (isFavoriteScMatch){
                    mpresenterdetail.removeFavoriteClub(mMatchSchedule)
                    Toast.makeText(applicationContext,"Schedul Removed to favorite",Toast.LENGTH_LONG).show()
                }
                else {
                    mpresenterdetail.getFavoriteClub(mMatchSchedule)
                    Toast.makeText(applicationContext,"Schedul Added to favorite",Toast.LENGTH_LONG).show()
                }

                isFavoriteScMatch = !isFavoriteScMatch
                setScMatchFavorite()

                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showClubImageHome(clubteams: List<TeamsClubItem>) {


        clubteams[0].strTeamBadge?.let { img_home.imageclubload(it) }
    }

    override fun showClubImageAway(clubteams:List<TeamsClubItem>) {


        clubteams[0].strTeamBadge?.let { img_awaydetail.imageclubload(it) }
    }



    private fun setScMatchFavorite() {
        if (isFavoriteScMatch)
            mMenuItem.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_set_fav)
        else
            mMenuItem.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_no_fav)
    }


}
