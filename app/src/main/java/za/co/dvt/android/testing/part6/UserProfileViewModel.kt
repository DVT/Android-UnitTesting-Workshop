package za.co.dvt.android.testing.part6

import android.content.Intent
import android.os.Bundle
import androidx.databinding.ObservableField

/**
 * Part 6 - Android SDK Testing
 * Learn how to test classes that interact with classes within the Android SDK!
 */
class UserProfileViewModel {
    val userName = ObservableField<String>()
    val emailAddress = ObservableField<String>()

    fun initialise(args: Bundle?) {
        requireNotNull(args) { "args == null" }
        userName.set(args.getString("user_name"))
        emailAddress.set(args.getString("email_address"))
    }

    fun getEditScreenIntent(): Intent {
        return Intent("EDIT_USER_PROFILE")
    }
}
