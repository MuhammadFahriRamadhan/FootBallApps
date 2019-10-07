package com.mfr.matchfootballscheduler.NextMatchScTest

import com.mfr.matchfootballscheduler.Utils.EspressoTest
import com.mfr.matchfootballscheduler.Utils.TestForScMatchProvider
import com.mfr.matchfootballscheduler.data.DataManagerInterface
import com.mfr.matchfootballscheduler.data.ModelMatch.MatchResponse
import com.mfr.matchfootballscheduler.data.ModelMatch.SchedulMatch
import com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchNext.MatchNextPresenter
import com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchNext.MatchNextView
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class NextMatchScTest {


    @Mock
    private lateinit var dataManagerinterface: DataManagerInterface

    @Mock
    private lateinit var nextview: MatchNextView

    @Mock
    private lateinit var espressotest : EspressoTest


    private lateinit var presenterlastmatch : MatchNextPresenter<MatchNextView>

    private lateinit var mTestSchedulermatch : TestScheduler

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        mTestSchedulermatch = TestScheduler()
        val testForfcMatchProvider = TestForScMatchProvider(mTestSchedulermatch)

        presenterlastmatch = MatchNextPresenter(dataManagerinterface, testForfcMatchProvider, espressotest)
        presenterlastmatch.onAttach(nextview)
    }

    @Test
    fun TestNextScMatch() {
        val sclastmatches: MutableList<SchedulMatch> = mutableListOf()
        val matchresponse = MatchResponse(sclastmatches)
        val idlegua = "4328"

        Mockito.doReturn(Single.just(matchresponse)).`when`(dataManagerinterface).NextMatchList(idlegua)

        presenterlastmatch.getMatchNextList(idlegua)

        mTestSchedulermatch.triggerActions()

        Mockito.verify(presenterlastmatch.getView())?.showNextMatchList(sclastmatches)


        presenterlastmatch.onDetach()
    }
}