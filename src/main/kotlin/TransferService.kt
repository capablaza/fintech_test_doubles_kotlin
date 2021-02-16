class TransferService {
    var client: TransferClient
    var storage: Storage

    constructor(clt: TransferClient, stg: Storage) {
        this.client = clt
        this.storage = stg
    }

    fun transfer(request: TransferRequest): TransferResponse {

        var response = client.transfer(request)

        if (response.code == 520) {
            storage.save("Try transfer amount not valid")
            return TransferResponse(520, "The amount must be major than zero.")
        }
        if (response.code == 521) {
            storage.save("Try transfer amount not valid")
            return TransferResponse(521, "The amount can't be major than 200.000.")
        }
        if (response.code == 522) {
            storage.save("Try with same accounts for transactions")
            return TransferResponse(522, "The accounts can't be equals.")
        }

        if (response.code == 503) {
            storage.save("Service Unavailable")
            return TransferResponse(503, "The operation can't be process, please try again.")
        }

        return TransferResponse(response.code, response.message)
    }
}
