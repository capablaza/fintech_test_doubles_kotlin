import org.junit.Test

class TransferServiceTest {

    @Test
    fun testGivenTransRequestWhenAmountIsLessThanZeroThenResponseIs520() {
    }

    @Test
    fun testGivenTransRequestWhenAmountIsEqualToZeroThenResponseIs520() {
    }

    @Test
    fun testGivenTransRequestWhenAmountIsMajorThanMaximumThenResponseIs521() {
    }

    @Test
    fun testGivenTransRequestWhenOriginsAreEqualsThenResponseIs522() {
    }

    @Test
    fun testGivenTransRequestWhenConditionsAreBadThenSaveErrorInStorage() {
    }
}