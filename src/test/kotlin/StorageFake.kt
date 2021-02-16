import java.util.ArrayList

class StorageFake : Storage {
    private val messages: MutableList<String> = ArrayList()

    override fun save(message: String) {
        messages.add(message)
    }

    override fun getMessages(): List<String> {
        return messages
    }
}