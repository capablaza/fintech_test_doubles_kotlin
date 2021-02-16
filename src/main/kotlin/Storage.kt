interface Storage {

    fun save(message: String)
    fun getMessages() : List<String>
}