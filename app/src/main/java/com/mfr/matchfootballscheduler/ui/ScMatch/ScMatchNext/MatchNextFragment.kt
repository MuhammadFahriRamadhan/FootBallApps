package com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchNext

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
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
import kotlinx.android.synthetic.main.fragment_matchnext.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx
import org.koin.android.ext.android.inject

class MatchNextFragment : BaseFragment(), MatchNextView,scnextmatchinterface {



    companion object {

        fun newInstance(): MatchNextFragment = MatchNextFragment()
    }

    val mpresenternextmatch: MatchNextPresenter<MatchNextView> by inject()
    val mAdapternext: MatchNextAdapter by inject()

    private var mLeagueName: String = ""
    private var scleaguenamge : String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rcv_fragmentnext.layoutManager = LinearLayoutManager(activity)
        rcv_fragmentnext.adapter = mAdapternext

        mpresenternextmatch.onAttach(this)




        mAdapternext.setOnNextMatchCLickListener {

            ctx.startActivity<MatchDetailActivity>("DetailMatch" to it)

        }

        val list = ScLeague.ScLeagueSpinnerList()
        val arrayleague = list.associateBy ( {it.nameleague}, {it.idleague} )

        val spnritems = resources.getStringArray(R.array.sc_league_array)
        val spnradapter = ArrayAdapter(ctx, android.R.layout.simple_spinner_dropdown_item, spnritems)
        spnr_scnextmatch.adapter = spnradapter

        spnr_scnextmatch.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                scleaguenamge = spnr_scnextmatch.selectedItem.toString()
                fetchnextscmatchcallback(arrayleague[scleaguenamge])

            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }



    }

    override fun fetchnextscmatchcallback(leagueName: String?) {
        leagueName?.let { mLeagueName = it }
        mpresenternextmatch.getMatchNextList(leagueName)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_matchnext, container, false)
    }


    override fun showNextMatchList(datas: List<SchedulMatch>) {

        mAdapternext.addItemMatchNextlist(datas)
    }


}
