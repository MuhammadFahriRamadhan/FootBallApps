package com.mfr.matchfootballscheduler.ui.Home


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.a21buttons.bottomnavigationview.widget.BottomNavigationView
import com.mfr.matchfootballscheduler.R
import com.mfr.matchfootballscheduler.ui.Favorite.FragmentFavorite
import com.mfr.matchfootballscheduler.ui.ScMatch.FragmentScMatch
import com.mfr.matchfootballscheduler.ui.base.BaseActivity.BaseActivity
import com.mfr.matchfootballscheduler.ui.teamclub.FragmentTeamClub
import kotlinx.android.synthetic.main.activity_home_match.*

class HomeMatchActivity : BaseActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_home_match)

            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

            val bottomNavigationView: BottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation)
            bottomNavigationView.selectedItemId = R.id.nav_Match



    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }


    private fun setBottomNavigationFragment(fragment   : FragmentScMatch ) {
        supportFragmentManager.beginTransaction().disallowAddToBackStack().replace(R.id.fragment_controller,fragment).commitNow()

    }

    private fun setBottomNavigationFragment(fragment: FragmentTeamClub) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_controller, fragment).commit()
    }

    private fun setBottomNavigationFragment(fragment: FragmentFavorite) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_controller, fragment).commit()
    }



    private val mOnNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener {

        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.nav_Match -> {
                    setBottomNavigationFragment(FragmentScMatch.newInstance())
                    return true
                }
                R.id.Nav_TeamCLub -> {
                    setBottomNavigationFragment(FragmentTeamClub.newInstance())
                    return true
                }
                R.id.Nav_Fav -> {
                    setBottomNavigationFragment(FragmentFavorite.newInstance())
                    return true
                }

            }
            return false
        }


    }







}






