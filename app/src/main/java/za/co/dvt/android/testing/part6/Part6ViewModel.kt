package za.co.dvt.android.testing.part6

import android.content.Intent
import android.os.Bundle
import androidx.databinding.ObservableField

/**
 * Part 6 - Android SDK Testing
 * Learn how to test classes that interact with classes within the Android SDK!
 */
class Part6ViewModel {
    val userName = ObservableField<String>()
    val emailAddress = ObservableField<String>()

    fun initialise(args: Bundle?) {
        requireNotNull(args) { "args == null" }
        userName.set(args.getString("user_name"))
        emailAddress.set(args.getString("email_address"))
    }

    fun getSomeIntent(): Intent {
        return Intent("SOME_ACTION")
    }

}
