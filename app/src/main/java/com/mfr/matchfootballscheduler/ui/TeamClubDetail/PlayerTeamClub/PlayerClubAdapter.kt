package com.mfr.matchfootballscheduler.ui.TeamClubDetail.PlayerTeamClub

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mfr.matchfootballscheduler.R
import com.mfr.matchfootballscheduler.Utils.ExtentionMatch.imageclubload
import com.mfr.matchfootballscheduler.data.ModelMatch.clubplayer
import org.jetbrains.anko.sdk25.coroutines.onClick

class PlayerClubAdapter(private val mclubplayer : ArrayList<clubplayer>) : RecyclerView.Adapter<PlayerClubAdapter.ClubPlayerViewHolder>() {


    private lateinit var mListeneClubPlayer : (clubplayer) -> Unit

    fun setOnClubPlayerCLickListener(listener: (clubplayer) -> Unit) {
        this.mListeneClubPlayer = listener
    }

    override fun onCreateViewHolder(parentitem: ViewGroup, Viewtype: Int): ClubPlayerViewHolder = ClubPlayerViewHolder(LayoutInflater.from(parentitem.context).inflate(R.layout.item_clubplayer, parentitem, false))

    override fun getItemCount(): Int = mclubplayer.size

    override fun onBindViewHolder(HolderPrev: ClubPlayerViewHolder, position: Int) {
        HolderPrev.bindItem(mclubplayer[position])
    }


    inner class ClubPlayerViewHolder(view: View) : RecyclerView.ViewHolder(view) {



        private val imgplayer : ImageView = itemView.findViewById(R.id.img_clubplayer)
        private val tv_nameplayer : TextView = itemView.findViewById(R.id.tv_playername)
        private val tv_playerposition : TextView = itemView.findViewById(R.id.tv_player_position)



        fun bindItem(mclubpalyer : clubplayer) {
            mclubpalyer.let {
                it.strCutout?.let { imgplayer.imageclubload(it) }
                tv_nameplayer.text = it.strPlayer
                tv_playerposition.text = it.strPosition
                Log.d("kuda2", "my Message"+it.strPlayer)
            }

            itemView.onClick { mListeneClubPlayer(mclubpalyer) }

        }
    }


    fun addItemList(mclubpalyer : List<clubplayer>) {
        mclubplayer.clear()
        mclubplayer.addAll(mclubpalyer)
        notifyDataSetChanged()
    }


}