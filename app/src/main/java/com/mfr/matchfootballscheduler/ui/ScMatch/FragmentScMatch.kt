package com.mfr.matchfootballscheduler.ui.ScMatch

import android.os.Bundle
import android.os.Handler
import android.support.design.widget.TabLayout
import android.util.Log
import android.view.*
import com.mfr.matchfootballscheduler.R
import com.mfr.matchfootballscheduler.data.ModelMatch.SchedulMatch
import com.mfr.matchfootballscheduler.ui.Home.HomeMatchActivity
import com.mfr.matchfootballscheduler.ui.MainMatch.PagerAdapterMatch
import com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchNext.MatchNextAdapter
import com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchNext.MatchNextPresenter
import com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchNext.MatchNextView
import com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchPrevious.MatchLastAdapter
import com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchPrevious.MatchLastView
import com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchPrevious.MatchPrevPresenter
import com.mfr.matchfootballscheduler.ui.base.BaseFragment.BaseFragment
import com.miguelcatalan.materialsearchview.MaterialSearchView
import kotlinx.android.synthetic.main.fragment_matchmain.*
import org.koin.android.ext.android.inject


class FragmentScMatch : BaseFragment(),MatchLastView,MatchNextView {


    private lateinit var PagerAdapter: PagerAdapterMatch

    val mpresenter: MatchPrevPresenter<MatchLastView> by inject()
    val mpresenternext : MatchNextPresenter<MatchNextView> by inject()


    val mAdapterprev: MatchLastAdapter by inject()
    val mAdapterrnext : MatchNextAdapter by inject()

    companion object {

        fun newInstance(): FragmentScMatch = FragmentScMatch()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as HomeMatchActivity).setSupportActionBar(toolbarmatch)
        setHasOptionsMenu(true)
        mpresenter.onAttach(this)
        mpresenternext.onAttach(this)
        fragmentManager?.let { PagerAdapter = PagerAdapterMatch(childFragmentManager) }
        setUp()




    }

    override fun showPrevMatchList(data: List<SchedulMatch>) {
        mAdapterprev.addItemList(data)
    }

    override fun showNextMatchList(data: List<SchedulMatch>) {
        mAdapterrnext.addItemMatchNextlist(data)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_matchmain, container, false)




    private fun setUp() {


        PagerAdapter.count = 2

        match_view_pager.adapter = PagerAdapter

        tabLayout.addTab(tabLayout.newTab().setText("Last Match"))
        tabLayout.addTab(tabLayout.newTab().setText("Next Match"))

        match_view_pager.offscreenPageLimit = tabLayout.tabCount
        match_view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                match_view_pager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }


    override fun onCreateOptionsMenu(menu: Menu?,menuInflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, menuInflater)
        menu!!.clear()
        setScMatch()
        true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.search_action -> {
                search_scmatch.showSearch()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setScMatch() {

        search_scmatch.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Log.i("SEARCH", "onQueryTextSubmit: $query")

                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                Log.i("SEARCH", "onQueryTextChange: $newText"+match_view_pager.currentItem)
                if (newText.length >= 2) {
                    Handler().postDelayed({
                        if ( match_view_pager.currentItem == 0) {
                            mpresenter.setSearchMatchList(newText)
                        }else if (match_view_pager.currentItem == 1 ){
                            Log.e("SEARCH",""+match_view_pager.currentItem)
                            mpresenternext.setSearchMatchList(newText)
                        }
                    }, 500)
                }
                return false
            }
        })

        search_scmatch.setOnSearchViewListener(object : MaterialSearchView.SearchViewListener {
            override fun onSearchViewShown() {
                Log.i("SEARCH", "onSearchViewShown: ")

            }

            override fun onSearchViewClosed() {

                Log.i("SEARCH", "onSearchViewClosed: ")

            }
        })
    }






}