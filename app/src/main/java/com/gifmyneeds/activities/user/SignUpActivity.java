package com.gifmyneeds.activities.user;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gifmyneeds.R;
import com.gifmyneeds.database.UserDBApi;
import com.gifmyneeds.models.User;
import com.gifmyneeds.utilities.Validations;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SignUpActivity";

    private EditText etName;
    private EditText etEmail;
    private EditText etPassword;
    private Button btnSignUp;
    private TextView loginLink;
    private ProgressDialog signUpProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity_layout);

        etName = (EditText) findViewById(R.id.input_name_sign_up);
        etEmail = (EditText) findViewById(R.id.input_email_sign_up);
        etPassword = (EditText) findViewById(R.id.input_password_sign_up);
        btnSignUp = (Button) findViewById(R.id.btn_sign_up);
        loginLink = (TextView) findViewById(R.id.link_login_sign_up_activity);
        signUpProgressDialog = new ProgressDialog(this);
        btnSignUp.setOnClickListener(this);
        loginLink.setOnClickListener(this);
    }

    public void signUp() {
        btnSignUp.setEnabled(false);
        signUpProgressDialog.setIndeterminate(true);
        signUpProgressDialog.setMessage(getString(R.string.creating_account));
        signUpProgressDialog.show();

        if (!validate()) {
            onSignUpFailed();
            return;
        }

        Log.d(TAG, "signUp: valid");

        if(!addUserToDB()) {
            onSignUpFailed();
            return;
        }

        Log.d(TAG, "signUp: created");

        btnSignUp.setEnabled(true);
        finish();
        signUpProgressDialog.dismiss();
    }

    public boolean validate() {
        boolean valid = true;

        String email = etEmail.getText().toString();
        String fullName = etName.getText().toString();
        String password = etPassword.getText().toString();

        if (!Validations.isEmailValid(email)) {
            valid = false;
            etEmail.setError(getString(R.string.uncorrect_email));
        }
        if (!Validations.isFullNameValid(fullName)) {
            valid = false;
            etName.setError(getString(R.string.uncorrect_name));
        }
        if (!Validations.isPasswordValid(password)) {
            valid = false;
            etPassword.setError(getString(R.string.uncorrect_password));
        }
        return valid;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sign_up:
                signUp();
                break;
            case R.id.link_login_sign_up_activity:
                finish();
                break;
        }
    }

    private void onSignUpFailed() {
        Toast.makeText(getBaseContext(), getString(R.string.sign_up_failed), Toast.LENGTH_LONG).show();
        btnSignUp.setEnabled(true);
        signUpProgressDialog.dismiss();
    }

    private boolean addUserToDB() {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        User newUser = new User(email, name, password);
        return UserDBApi.addNewUser(this, newUser);
    }
}
