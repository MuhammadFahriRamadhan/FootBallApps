package com.mfr.matchfootballscheduler.ui.base.BaseViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.mfr.matchfootballscheduler.data.ModelMatch.SchedulMatch

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



    abstract fun bindItem(schmatch: SchedulMatch)
}