class TransferClientStub : TransferClient{
    private var code = 0
    private var message: String

    constructor(code: Int, message: String) {
        this.code = code
        this.message = message
    }

    override fun transfer(request: TransferRequest): TransferClientResponse {
        return TransferClientResponse(this.code, this.message)
    }
}