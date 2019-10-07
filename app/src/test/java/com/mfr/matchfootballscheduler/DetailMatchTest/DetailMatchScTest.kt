package com.mfr.matchfootballscheduler.DetailMatchTest

import com.mfr.matchfootballscheduler.Utils.EspressoTest
import com.mfr.matchfootballscheduler.Utils.TestForScMatchProvider
import com.mfr.matchfootballscheduler.data.DataManagerInterface
import com.mfr.matchfootballscheduler.data.ModelMatch.ClubTeamResponse
import com.mfr.matchfootballscheduler.data.ModelMatch.TeamsClubItem
import com.mfr.matchfootballscheduler.ui.ScDetailMatch.MatchDetailPresenter
import com.mfr.matchfootballscheduler.ui.ScDetailMatch.MatchDetailView
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailMatchScTest {

    @Mock
    private lateinit var dataManagerinterface: DataManagerInterface

    @Mock
    private lateinit var detailview: MatchDetailView

    @Mock
    private lateinit var espressotest : EspressoTest


    private lateinit var presenterdetailmatch : MatchDetailPresenter<MatchDetailView>

    private lateinit var mTestSchedulermatch : TestScheduler

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        mTestSchedulermatch = TestScheduler()
        val testForfcMatchProvider = TestForScMatchProvider(mTestSchedulermatch)

        presenterdetailmatch = MatchDetailPresenter(dataManagerinterface, testForfcMatchProvider, espressotest)
        presenterdetailmatch.onAttach(detailview)
    }

    @Test
    fun TestDetailScMatch() {


        val scdetailmatches :MutableList<TeamsClubItem> = mutableListOf()

        val clubteamresponse = ClubTeamResponse(scdetailmatches)
        val idteamhome = "133616"
        val idteamaway = "133610"

        Mockito.doReturn(Single.just(clubteamresponse)).`when`(dataManagerinterface).ClubTeamDetail(idteamhome)

        Mockito.doReturn(Single.just(clubteamresponse)).`when`(dataManagerinterface).ClubTeamDetail(idteamaway)

        presenterdetailmatch.setClubTeamHome(idteamhome)
        presenterdetailmatch.setClubTeamAway(idteamaway)

        mTestSchedulermatch.triggerActions()

        Mockito.verify(presenterdetailmatch.getView())?.showClubImageHome(scdetailmatches)
        Mockito.verify(presenterdetailmatch.getView())?.showClubImageAway(scdetailmatches)


        presenterdetailmatch.onDetach()
    }
}