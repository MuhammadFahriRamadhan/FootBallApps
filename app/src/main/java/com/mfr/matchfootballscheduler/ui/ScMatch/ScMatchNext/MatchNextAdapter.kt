package com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchNext

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mfr.matchfootballscheduler.R
import com.mfr.matchfootballscheduler.Utils.ExtentionMatch.convertime
import com.mfr.matchfootballscheduler.data.ModelMatch.SchedulMatch
import com.mfr.matchfootballscheduler.ui.base.BaseViewHolder.BaseViewHolder
import org.jetbrains.anko.sdk25.coroutines.onClick

class MatchNextAdapter(private val Schedulmatch: ArrayList<SchedulMatch>) : RecyclerView.Adapter<MatchNextAdapter.MatchNextViewHolder>() {


    private lateinit var mListenerDetail: (SchedulMatch) -> Unit

    fun setOnNextMatchCLickListener(listener: (SchedulMatch) -> Unit) {
        this.mListenerDetail = listener
    }

    override fun onCreateViewHolder(parentitem: ViewGroup, Viewtype: Int): MatchNextViewHolder = MatchNextViewHolder(LayoutInflater.from(parentitem.context).inflate(R.layout.item_match, parentitem, false))

    override fun getItemCount(): Int = Schedulmatch.size

    override fun onBindViewHolder(HolderPrev: MatchNextViewHolder, position: Int) {
        HolderPrev.bindItem(Schedulmatch[position])
    }


    inner class MatchNextViewHolder(view: View) :BaseViewHolder(view) {


        private val datematch: TextView = itemView.findViewById(R.id.tv_datematch)
        private val hometeamclub: TextView = itemView.findViewById(R.id.tv_hometeam)
        private val awayteamclub: TextView = itemView.findViewById(R.id.tv_awayteam)
        private val scorehome: TextView = itemView.findViewById(R.id.tv_scr_home)
        private val scoreaway: TextView = itemView.findViewById(R.id.tv_scr_away)
        private val jam :TextView =itemView.findViewById(R.id.tv_jam)


        override fun bindItem(schmatch: SchedulMatch) {
            datematch.text = schmatch.dateEvent
            hometeamclub.text = schmatch.strHomeTeam
            awayteamclub.text = schmatch.strAwayTeam
            scorehome.text = schmatch.intHomeScore
            scoreaway.text = schmatch.intAwayScore
            if(schmatch.strTime != null ) {
                jam.text = convertime(schmatch.strTime.toString())
            }
            itemView.onClick { mListenerDetail(schmatch) }

        }
    }

    fun addItemMatchNextlist(schmatches: List<SchedulMatch>) {
        Schedulmatch.clear()
        Schedulmatch.addAll(schmatches)
        notifyDataSetChanged()
    }
}