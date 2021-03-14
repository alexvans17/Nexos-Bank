package com.example.nexosbank.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.example.nexosbank.R
import com.example.nexosbank.data.model.LoggedInUser
import com.example.nexosbank.domain.entity.LoggedInUserView
import com.example.nexosbank.ui.di.component.DaggerAuthComponent
import com.example.nexosbank.ui.interfaces.view.AuthView
import com.example.nexosbank.ui.presenter.AuthPresenterImpl
import javax.inject.Inject

class LoginActivity : AppCompatActivity(),
    AuthView {

    @Inject
    lateinit var presenter: AuthPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        DaggerAuthComponent.builder().build().inject(this)
        presenter.setView(this)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val btnLogin = findViewById<Button>(R.id.login)
        val loading = findViewById<ProgressBar>(R.id.loading)

        password.apply {
            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        login(username.text.toString(), password.text.toString())
                }
                false
            }

            btnLogin.setOnClickListener {
                loading.visibility = View.VISIBLE
                login(username.text.toString(), password.text.toString())
            }
        }
    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome)
        val displayName = model.displayName
        // TODO : initiate successful logged in experience
        Toast.makeText(
                applicationContext,
                "$welcome $displayName",
                Toast.LENGTH_LONG
        ).show()
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }

    override fun login(username: String, password: String) {
        presenter.login(username, password)
    }

    override fun successLogin(fakeUser: LoggedInUser) {
        goToMainActivity()
    }

    override fun failLogin(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}
