package com.mfr.matchfootballscheduler.LastMatchTest

import com.mfr.matchfootballscheduler.Utils.EspressoTest
import com.mfr.matchfootballscheduler.Utils.TestForScMatchProvider
import com.mfr.matchfootballscheduler.data.DataManagerInterface
import com.mfr.matchfootballscheduler.data.ModelMatch.MatchResponse
import com.mfr.matchfootballscheduler.data.ModelMatch.SchedulMatch
import com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchPrevious.MatchLastView
import com.mfr.matchfootballscheduler.ui.ScMatch.ScMatchPrevious.MatchPrevPresenter
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class LastMatchScTest {

    @Mock
    private lateinit var dataManagerinterface: DataManagerInterface

    @Mock
    private lateinit var lastview: MatchLastView

    @Mock
    private lateinit var espressotest : EspressoTest


    private lateinit var presenterlastmatch : MatchPrevPresenter<MatchLastView>

    private lateinit var mTestSchedulermatch : TestScheduler

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        mTestSchedulermatch = TestScheduler()
        val testForfcMatchProvider = TestForScMatchProvider(mTestSchedulermatch)

        presenterlastmatch = MatchPrevPresenter(dataManagerinterface, testForfcMatchProvider, espressotest)
        presenterlastmatch.onAttach(lastview)
    }

    @Test
    fun TestLastScMatch() {
        val sclastmatches: MutableList<SchedulMatch> = mutableListOf()
        val matchresponse = MatchResponse(sclastmatches)
        val idlegua = "4328"

        Mockito.doReturn(Single.just(matchresponse)).`when`(dataManagerinterface).LastMatchList(idlegua)

        presenterlastmatch.getMatchPrevList(idlegua)

        mTestSchedulermatch.triggerActions()

        Mockito.verify(presenterlastmatch.getView())?.showPrevMatchList(sclastmatches)


        presenterlastmatch.onDetach()
    }
}