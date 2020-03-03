package za.co.dvt.android.testing.part5

import za.co.dvt.android.testing.part5.code.MovieProvider
import za.co.dvt.android.testing.part5.code.MovieProviderImpl

/**
 * Part 5 - Bug Testing
 * Write a failing test which replicates a bug, then fix the bug!
 */
class MovieListViewModel(private val movieProvider: MovieProvider) {

    fun filterMovies(query: String?): Collection<String> {
        val movies = movieProvider.provideMovies()
        if (query.isNullOrBlank()) {
            // return a copy of the list
            return movies.toList()
        }
        return movies.filter { it.contains(query) }
    }
}

/** Constructor-style factory method. */
@Suppress("FunctionName")
fun MovieListViewModel(): MovieListViewModel {
    return MovieListViewModel(MovieProviderImpl())
}
