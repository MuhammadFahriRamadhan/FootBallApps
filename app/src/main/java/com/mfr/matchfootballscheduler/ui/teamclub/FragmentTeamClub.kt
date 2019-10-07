package com.mfr.matchfootballscheduler.ui.teamclub

import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.mfr.matchfootballscheduler.R
import com.mfr.matchfootballscheduler.data.ModelMatch.teamitem
import com.mfr.matchfootballscheduler.ui.Home.HomeMatchActivity
import com.mfr.matchfootballscheduler.ui.TeamClubDetail.teamclubdetail
import com.mfr.matchfootballscheduler.ui.base.BaseFragment.BaseFragment
import com.miguelcatalan.materialsearchview.MaterialSearchView
import kotlinx.android.synthetic.main.fragment_team_club.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx
import org.koin.android.ext.android.inject

class FragmentTeamClub : BaseFragment(),TeamClubView {

    companion object {

        fun newInstance(): FragmentTeamClub = FragmentTeamClub()
    }

    private var leagueName: String = ""
    val presenter : TeamClubPresenter<TeamClubView> by inject()
    val madapter  : TeamClubAdapter by inject()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as HomeMatchActivity).setSupportActionBar(toolbarteamclub)
        setHasOptionsMenu(true)

        presenter.onAttach(this)
        val gridlayout = GridLayoutManager(activity, 2)
        rcv_teamclub.layoutManager = gridlayout
        rcv_teamclub.adapter = madapter

        val spinnerItems = resources.getStringArray(R.array.sc_league_array)
        val spinnerAdapter = ArrayAdapter(ctx, android.R.layout.simple_spinner_dropdown_item, spinnerItems)
        spnr_teammatch.adapter = spinnerAdapter

        spnr_teammatch.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                leagueName = spnr_teammatch.selectedItem.toString()
                presenter.getTeamClubList(leagueName)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        madapter.setClubOnclickListener {

            ctx.startActivity<teamclubdetail>("DetailTeamClub" to it)

        }



    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_team_club, container, false)
    }

    override fun showTeamList(datas: List<teamitem>) {

        madapter.addClubToList(datas)
    }

    override fun onCreateOptionsMenu(menu: Menu?, menuInflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, menuInflater)
        menu!!.clear()
        setTeamClub()
        true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.search_action -> {
                search_teamclub.showSearch()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setTeamClub() {

        search_teamclub.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Log.i("SEARCH", "onQueryTextSubmit: $query")

                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {

                if (newText.length >= 2) {
                    Handler().postDelayed({

                            presenter.setSearchTeamClubList(newText)

                    }, 500)
                }
                return false
            }
        })

        search_teamclub.setOnSearchViewListener(object : MaterialSearchView.SearchViewListener {
            override fun onSearchViewShown() {
                Log.i("SEARCH", "onSearchViewShown: ")

            }

            override fun onSearchViewClosed() {

                Log.i("SEARCH", "onSearchViewClosed: ")

            }
        })
    }
}