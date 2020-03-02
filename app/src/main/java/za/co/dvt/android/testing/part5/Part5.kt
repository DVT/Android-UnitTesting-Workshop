package za.co.dvt.android.testing.part5

/**
 * Part 5 - Bug Testing
 * Write a failing test which replicates a bug, then fix the bug!
 */
class Part5(private val nameProvider: NameProvider) {

    fun filterNames(query: String?): Collection<String> {
        val names = nameProvider.provideNames()
        if (query.isNullOrBlank()) {
            // return a copy of the list
            return names.toList()
        }
        return names.filter { it.contains(query) }
    }

    companion object {

        fun newInstance(): Part5 {
            return Part5(NameProviderImpl())
        }

    }

}

interface NameProvider {
    fun provideNames(): Collection<String>
}

class NameProviderImpl : NameProvider {

    override fun provideNames(): Collection<String> {
        return listOf(
            "Dulsea",
            "Cahra",
            "Adorne",
            "Marcille",
            "Harv",
            "Jenni",
            "Eran",
            "Tilly",
            "Land",
            "Dino",
            "D'arcy",
            "Catie",
            "Redford"
        )
    }

}
