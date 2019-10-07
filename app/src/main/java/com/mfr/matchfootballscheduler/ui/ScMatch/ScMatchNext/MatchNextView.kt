package com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchNext

import com.mfr.matchfootballscheduler.data.ModelMatch.SchedulMatch
import com.mfr.matchfootballscheduler.ui.base.MVPView.MVPView

interface MatchNextView : MVPView {
    fun showNextMatchList(data: List<SchedulMatch>)
}