package indrivo.dentistbooking.util

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class DateUtilTest {

    @Before
    fun setUp() {
    }

    @Test
    fun addMillisecondsToDateTest() {
        val beginDate = Date()
        val endDate = DateUtil.addMillisecondsToDate(beginDate, 600000)
        Assert.assertEquals(beginDate.time + 600000, endDate.time)
    }

}
