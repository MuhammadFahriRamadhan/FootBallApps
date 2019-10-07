package com.mfr.matchfootballscheduler.ui.Favorite.MatchFavorite

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mfr.matchfootballscheduler.R
import com.mfr.matchfootballscheduler.Utils.ExtentionMatch.convertime
import com.mfr.matchfootballscheduler.data.ModelMatch.MatchFavorite
import org.jetbrains.anko.sdk25.coroutines.onClick

class MatchFavScAdapter (private val FavMatch: ArrayList<MatchFavorite>) : RecyclerView.Adapter<MatchFavScAdapter.MatchFavViewHolder>() {


    private lateinit var mListenerDetail: (MatchFavorite) -> Unit

    fun setOnFavMatchCLickListener(listener: (MatchFavorite) -> Unit) {
        this.mListenerDetail = listener
    }

    override fun onCreateViewHolder(parentitem: ViewGroup, Viewtype: Int): MatchFavViewHolder = MatchFavViewHolder(LayoutInflater.from(parentitem.context).inflate(R.layout.item_match, parentitem, false))

    override fun getItemCount(): Int = FavMatch.size

    override fun onBindViewHolder(HolderPrev: MatchFavViewHolder, position: Int) {
        HolderPrev.bindItem(FavMatch[position])
    }


    inner class MatchFavViewHolder(view: View) :  RecyclerView.ViewHolder(view) {


        private val datematch: TextView = itemView.findViewById(R.id.tv_datematch)
        private val hometeamclub: TextView = itemView.findViewById(R.id.tv_hometeam)
        private val awayteamclub: TextView = itemView.findViewById(R.id.tv_awayteam)
        private val scorehome: TextView = itemView.findViewById(R.id.tv_scr_home)
        private val scoreaway: TextView = itemView.findViewById(R.id.tv_scr_away)
        private val jam : TextView = itemView.findViewById(R.id.tv_jam)


         fun bindItem(favMatch: MatchFavorite) {
            datematch.text = favMatch.dateMatchEvent
            hometeamclub.text = favMatch.homeMatchTeamName
            awayteamclub.text = favMatch.awayMatchTeamName
            scorehome.text = favMatch.intMatchHomeGoal
            scoreaway.text = favMatch.intMatchAwayGoal
             jam.text = convertime(favMatch.str_jam!!)
            itemView.onClick { mListenerDetail(favMatch) }

        }
    }

    fun addItemMatchFavlist(favMatches: List<MatchFavorite>) {
        FavMatch.clear()
        FavMatch.addAll(favMatches)
        notifyDataSetChanged()
    }

}