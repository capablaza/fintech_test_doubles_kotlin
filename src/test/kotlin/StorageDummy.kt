class StorageDummy : Storage {
    override fun save(message: String) {
    }

    override fun getMessages(): List<String> {
        return emptyList()
    }
}