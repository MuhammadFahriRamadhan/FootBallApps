package com.mfr.matchfootballscheduler.ui.ScMatch

import com.mfr.matchfootballscheduler.Utils.ScProviderInterface
import com.mfr.matchfootballscheduler.data.DataManagerInterface
import com.mfr.matchfootballscheduler.ui.base.BasePresenter.BasePresenter

class ScMatchPresenter <V : ScMatchInterface> constructor(DataManager: DataManagerInterface, ScheculerProvider: ScProviderInterface) : BasePresenter<V>(DataManager = DataManager, ScheculerProvider = ScheculerProvider)