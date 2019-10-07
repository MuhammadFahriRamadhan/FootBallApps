package com.mfr.matchfootballscheduler.Utils


import io.reactivex.*
import io.reactivex.schedulers.TestScheduler

class TestForScMatchProvider(private val mTestScmatch : TestScheduler) : ScProviderInterface {

    override fun <T> ioToMainObservableScheduler(): ObservableTransformer<T, T>  = ObservableTransformer { upstream ->
        upstream.subscribeOn(io())
                .observeOn(ui())
    }

    override fun <T> ioToMainSingleScheduler(): SingleTransformer<T, T> = SingleTransformer { upstream ->
        upstream.subscribeOn(io())
                .observeOn(ui())
    }

    override fun ioToMainCompletableScheduler(): CompletableTransformer = CompletableTransformer { upstream ->
        upstream.subscribeOn(io())
                .observeOn(ui())
    }

    override fun <T> ioToMainFlowableScheduler(): FlowableTransformer<T, T> = FlowableTransformer { upstream ->
        upstream.subscribeOn(io())
                .observeOn(ui())
    }

    override fun <T> ioToMainMaybeScheduler(): MaybeTransformer<T, T> = MaybeTransformer { upstream ->
        upstream.subscribeOn(io())
                .observeOn(ui())
    }



    fun io(): Scheduler {
        return mTestScmatch
    }

    fun ui(): Scheduler {
        return mTestScmatch
    }
}