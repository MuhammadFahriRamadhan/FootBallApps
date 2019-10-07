package com.mfr.matchfootballscheduler.ui.Favorite.ClubPlayerFavorite

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.mfr.matchfootballscheduler.Utils.ExtentionMatch.imageclubload
import com.mfr.matchfootballscheduler.data.ModelMatch.FavoriteClubTeam
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class ClubTeamAdapter(private val favclubteams : ArrayList<FavoriteClubTeam>) : RecyclerView.Adapter<ClubTeamAdapter.FavClubTeamViewHolder>() {

    private lateinit var  clublistener :(FavoriteClubTeam) -> Unit




    override fun onCreateViewHolder(parentclub : ViewGroup, viewTypeclub : Int): ClubTeamAdapter.FavClubTeamViewHolder =
            FavClubTeamViewHolder(ClubTeamsANKOUI().createView(AnkoContext.create(parentclub.context, parentclub)))




    override fun getItemCount(): Int = favclubteams.size



    override fun onBindViewHolder(HolderClubs : ClubTeamAdapter.FavClubTeamViewHolder,position: Int) {

        HolderClubs.bindItem(favclubteams[position])

        Log.d("kuda2", "my Message")
    }

    fun addClubToList(clubitem : List<FavoriteClubTeam>) {
        this.favclubteams.clear()
        this.favclubteams.addAll(clubitem)
        notifyDataSetChanged()
    }


    inner class FavClubTeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        fun bindItem(teamitems : FavoriteClubTeam) {
            teamitems.let {
                it.imageUrl?.let { ClubTeamImages.imageclubload(it) }
                teamClubNames.text = it.nameclub
                Log.d("kuda2", "my Message"+it.nameclub)
            }
            itemView.onClick { clublistener(teamitems) }

        }


        private val ClubTeamImages : ImageView = view.findViewById(Ids.image_clubs)
        private val teamClubNames: TextView = view.findViewById(Ids.name_clubs)


    }

    fun setFavClubOnclickListener(listenerclub : (FavoriteClubTeam) -> Unit){
        this.clublistener = listenerclub

    }




    class ClubTeamsANKOUI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                linearLayout {
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(16)
                    orientation = LinearLayout.HORIZONTAL

                    imageView {
                        id = Ids.image_clubs
                    }.lparams{
                        height = dip(50)
                        width = dip(50)
                    }

                    textView {
                        id = Ids.name_clubs
                        textSize = 20f
                    }.lparams{
                        margin = dip(15)
                    }

                }
            }
        }

    }
    private object Ids {
        val image_clubs = 1
        val name_clubs = 2
    }



}