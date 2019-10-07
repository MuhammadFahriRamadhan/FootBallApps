package com.mfr.matchfootballscheduler.data.ModelMatch

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class FavoriteClubTeam(val ID : Long?,
                   val IdClub : String?,
                   val imageUrl: String?,
                   val nameclub : String?,
                   val overviewclub : String?
                  ) : Parcelable {

    companion object {
        const val TABLE_FAVORITE_CLUBTEAM: String = "TABLE_FAVORITE_CLUBTEAM"
        const val ID : String = "ID"
        const val ID_CLUBTEAM : String = "ID_CLUBTEAM"
        const val TEAM_CLUBNAME: String = "TEAM_CLUBNAME"
        const val IMAGE_CLUBURL: String = "IMAGE_CLUBURL"
        const val OVERVIEW_CLUB : String = "OVERVIEW_CLUB"

    }
}