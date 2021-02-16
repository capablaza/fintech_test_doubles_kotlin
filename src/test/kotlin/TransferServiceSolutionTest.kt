import org.junit.Assert
import org.junit.Test

class TransferServiceSolutionTest {

    @Test
    fun testGivenTransRequestWhenAmountIsLessThanZeroThenResponseIs520() {
        val client = TransferClientStub(520, "")
        val storage: Storage = StorageDummy()

        val service = TransferService(client, storage)

        val amount = -100

        val from = "8736 8474 9034"
        val to = "8736 8474 8948"

        val request = TransferRequest(amount, from, to)

        val response: TransferResponse = service.transfer(request)

        Assert.assertEquals(response.code, 520)
    }

    @Test
    fun testGivenTransRequestWhenAmountIsEqualToZeroThenResponseIs520() {
        val client = TransferClientStub(520, "")
        val storage: Storage = StorageDummy()

        val service = TransferService(client, storage)

        val amount = 0
        val from = "8736 8474 9034"
        val to = "8736 8474 8948"

        val request = TransferRequest(amount, from, to)

        val response: TransferResponse = service.transfer(request)

        Assert.assertEquals(response.code, 520)
    }

    @Test
    fun testGivenTransRequestWhenAmountIsMajorThanMaximumThenResponseIs521() {
        val client = TransferClientStub(521, "")
        val storage: Storage = StorageDummy()

        val service = TransferService(client, storage)

        val amount = 500000

        val from = "8736 8474 9034"
        val to = "8736 8474 8948"

        val request = TransferRequest(amount, from, to)

        val response: TransferResponse = service.transfer(request)

        Assert.assertEquals(response.code, 521)
    }

    @Test
    fun testGivenTransRequestWhenOriginsAreEqualsThenResponseIs522() {
        val client = TransferClientStub(522, "")
        val storage: Storage = StorageDummy()

        val service = TransferService(client, storage)

        val amount = 5000
        val from = "8736 8474 9034"
        val to = "8736 8474 9034"
        val request = TransferRequest(amount, from, to)

        val response: TransferResponse = service.transfer(request)

        Assert.assertEquals(response.code, 522)

    }

    @Test
    fun testGivenTransRequestWhenConditionsAreBadThenSaveErrorInStorage() {
        val client = TransferClientStub(521, "")
        val storage: Storage = StorageFake()

        val service = TransferService(client, storage)

        val amount = 5000
        val from = "8736 8474 9034"
        val to = "8736 8474 1843"
        val request = TransferRequest(amount, from, to)

        val response: TransferResponse = service.transfer(request)

        Assert.assertEquals(response.code, 521)
        Assert.assertFalse(response.message.isEmpty())


    }
}