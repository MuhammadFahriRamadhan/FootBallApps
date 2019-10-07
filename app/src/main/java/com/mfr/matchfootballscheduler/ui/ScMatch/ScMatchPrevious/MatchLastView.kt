package com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchPrevious

import com.mfr.matchfootballscheduler.data.ModelMatch.SchedulMatch
import com.mfr.matchfootballscheduler.ui.base.MVPView.MVPView

interface MatchLastView : MVPView {
    fun showPrevMatchList(data: List<SchedulMatch>)
}