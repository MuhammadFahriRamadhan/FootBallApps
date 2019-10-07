package com.mfr.matchfootballscheduler.ui.teamclub

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mfr.matchfootballscheduler.R
import com.mfr.matchfootballscheduler.Utils.ExtentionMatch.imageclubload
import com.mfr.matchfootballscheduler.data.ModelMatch.teamitem
import org.jetbrains.anko.sdk25.coroutines.onClick

class TeamClubAdapter(private val clubteams : ArrayList<teamitem>) : RecyclerView.Adapter<TeamClubAdapter.ClubTeamViewHolder>() {

    private lateinit var  clublistener :(teamitem) -> Unit




    override fun onCreateViewHolder(parentclub : ViewGroup, viewTypeclub : Int): TeamClubAdapter.ClubTeamViewHolder =
            ClubTeamViewHolder(LayoutInflater.from(parentclub.context).inflate(R.layout.item_teamclub, parentclub, false))




    override fun getItemCount(): Int = clubteams.size



    override fun onBindViewHolder(HolderClubs : TeamClubAdapter.ClubTeamViewHolder,position: Int) {

        HolderClubs.bindItem(clubteams[position])

        Log.d("kuda2", "my Message")
    }

    fun addClubToList(clubitem : List<teamitem>) {
        this.clubteams.clear()
        this.clubteams.addAll(clubitem)
        notifyDataSetChanged()
    }


    inner class ClubTeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {


         fun bindItem(teamitems : teamitem) {
             teamitems.let {
                it.strTeamBadge?.let { ClubTeamImage.imageclubload(it) }
                teamClubName.text = it.strTeam
                Log.d("kuda2", "my Message"+it.strTeam)
            }
            itemView.onClick { clublistener(teamitems) }

        }


        private val ClubTeamImage : ImageView = itemView.findViewById(R.id.img_teamclub)
        private val teamClubName: TextView = itemView.findViewById(R.id.tv_teamclub)


    }

    fun setClubOnclickListener(listenerclub : (teamitem) -> Unit){
        this.clublistener = listenerclub

    }



}