package za.co.dvt.android.testing.part3

/**
 * Part 3 - Dependency Injection
 * Understand that "injecting" complex classes makes testing much easier!
 */
class Part3(private val thingProvider: ThingProvider) {

    fun getMagicNumber(): Int {
        return thingProvider.provideThing().number
    }

    companion object {

        fun newInstance(): Part3 {
            return Part3(ThingProviderImpl())
        }

    }

}

data class Thing(val number: Int)

interface ThingProvider {
    fun provideThing(): Thing
}

class ThingProviderImpl : ThingProvider {

    override fun provideThing(): Thing {
        val now = System.currentTimeMillis()
        val nowStr = now.toString()
        var result = 0
        for (element in nowStr) {
            result += element.toString().toInt()
        }
        return Thing(result)
    }

}
