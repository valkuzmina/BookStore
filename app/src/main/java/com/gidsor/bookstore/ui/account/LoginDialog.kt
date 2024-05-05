package com.gidsor.bookstore.ui.account

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.gidsor.bookstore.R

class LoginDialog : DialogFragment() {

    lateinit var email: String
    lateinit var password: String
    lateinit var registrationDialog: DialogFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registrationDialog = RegistrationDialog()

        view.findViewById<Button>(R.id.login_login).setOnClickListener {
            email = view.findViewById<EditText>(R.id.login_email_input).text.toString()
            password = view.findViewById<EditText>(R.id.login_password_input).text.toString()

            if ((parentFragment as AccountFragment).loginToAccount(email, password)) {
                dismiss()
            }
        }

        view.findViewById<Button>(R.id.login_registration).setOnClickListener {
            registrationDialog.show(fragmentManager, "registrationDialog")
        }
    }
}