package com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchPrevious


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.mfr.matchfootballscheduler.R
import com.mfr.matchfootballscheduler.data.ModelMatch.ScLeague
import com.mfr.matchfootballscheduler.data.ModelMatch.SchedulMatch
import com.mfr.matchfootballscheduler.ui.ScDetailMatch.MatchDetailActivity
import com.mfr.matchfootballscheduler.ui.base.BaseFragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_matchprev.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx
import org.koin.android.ext.android.inject

class MatchLastFragment : BaseFragment(), MatchLastView, lastscmatchinterface {



    companion object {

        fun newInstance(): MatchLastFragment = MatchLastFragment()
    }

    val mpresenter: MatchPrevPresenter<MatchLastView> by inject()
    val mAdapterprev: MatchLastAdapter by inject()
    private lateinit var listEvent: RecyclerView
    private var mLeagueName: String = ""
    private var scleaguenamge : String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rcv_fragmentprev.layoutManager = LinearLayoutManager(activity)
        rcv_fragmentprev.adapter = mAdapterprev

        mpresenter.onAttach(this)

        mAdapterprev.setOnLastMatchCLickListener {

            ctx.startActivity<MatchDetailActivity>("DetailMatch" to it)

        }

        val list = ScLeague.ScLeagueSpinnerList()
        val arrayleague = list.associateBy ( {it.nameleague}, {it.idleague} )

        val spnritems = resources.getStringArray(R.array.sc_league_array)
        val spnradapter = ArrayAdapter(ctx, android.R.layout.simple_spinner_dropdown_item, spnritems)
        spnr_sclastmatch.adapter = spnradapter

        spnr_sclastmatch.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                scleaguenamge = spnr_sclastmatch.selectedItem.toString()
                fetchlastscmatchcallback(arrayleague[scleaguenamge])

            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }



    }

    override fun fetchlastscmatchcallback(leagueName: String?) {
        leagueName?.let { mLeagueName = it }
        mpresenter.getMatchPrevList(leagueName)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_matchprev, container, false)
    }


    override fun showPrevMatchList(datas: List<SchedulMatch>) {

        mAdapterprev.addItemList(datas)
    }


}


