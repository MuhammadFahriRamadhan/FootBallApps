package com.mfr.matchfootballscheduler.ui.teamclub

import com.mfr.matchfootballscheduler.data.ModelMatch.teamitem
import com.mfr.matchfootballscheduler.ui.base.MVPView.MVPView

interface TeamClubView : MVPView {
    fun showTeamList(datas: List<teamitem>)
}