package za.co.dvt.android.testing.part2

/**
 * Part 2 - Complex Dependencies
 * Learn how to test classes that depend on other classes!
 */
class Part2 {
    private val thingProvider: ThingProvider = ThingProviderImpl()

    fun getMagicNumber(): Int {
        return thingProvider.provideThing().number
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
