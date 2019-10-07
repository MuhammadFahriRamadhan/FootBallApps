package com.mfr.matchfootballscheduler.ui.base.BasePresenter

import com.mfr.matchfootballscheduler.Utils.ScProviderInterface
import com.mfr.matchfootballscheduler.data.DataManagerInterface
import com.mfr.matchfootballscheduler.ui.base.MVPView.MVPView
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<V : MVPView> internal constructor(var DataManager: DataManagerInterface, var ScheculerProvider: ScProviderInterface) {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    fun onAttach(view: V?) {
        this.view = view
    }

    fun getView(): V? = view

    fun onDetach() {
        compositeDisposable.dispose()
        view = null
    }
}