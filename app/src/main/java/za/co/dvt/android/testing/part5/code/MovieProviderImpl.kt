package za.co.dvt.android.testing.part5.code

class MovieProviderImpl : MovieProvider {

    override fun provideMovies(): Collection<String> {
        return listOf(
                "Education of Mohammad Hussein, The",
                "Star Wars Uncut: Director's Cut",
                "Captain America: The First Avenger",
                "First Love, Last Rites",
                "The Boss",
                "Khodorkovsky",
                "Crack-Up",
                "Camelot",
                "The Count of Monte Cristo",
                "Big Shots",
                "Fast and the Furious, The",
                "When Evening Falls on Bucharest or Metabolism",
                "Primeval",
                "Defending Your Life",
                "After the Life",
                "May",
                "Mein Kampf",
                "Holy Flame of the Martial World (Wu lin sheng huo jin)",
                "Normal",
                "Fate of a Man (Sudba cheloveka)",
                "Still Breathing",
                "Unleashed (Danny the Dog)",
                "Rosie",
                "Last Call (Hoogste tijd)",
                "Peter Pan",
                "Cercle Rouge, Le (Red Circle, The)",
                "Carbine Williams",
                "Comedy, The"
        )
    }
}
