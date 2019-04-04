package com.gifmyneeds.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.gifmyneeds.R;
import com.gifmyneeds.activities.menus.ChildListActivity;
import com.gifmyneeds.activities.user.SignUpActivity;
import com.gifmyneeds.database.UserDBApi;
import com.gifmyneeds.models.User;
import com.gifmyneeds.utilities.Validations;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button signInBtn;
    private Button signUpBtn;
    private EditText email;
    private EditText userPassword;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInBtn = (Button) findViewById(R.id.signInBtn);
        signUpBtn = (Button) findViewById(R.id.signupBtn);
        email = (EditText) findViewById(R.id.email);
        userPassword = (EditText) findViewById(R.id.userPassword);
        progressDialog = new ProgressDialog(this);


        signInBtn.setOnClickListener(this);
        signUpBtn.setOnClickListener(this);

    }

    private void userLogin(String email ,String password){
        progressDialog.setMessage(getResources().getString(R.string.checking_user_details));
        progressDialog.show();

        //Checking if email and password are valid
        boolean valid = true;

        if(!Validations.isPasswordValid(password)) {
            valid = false;
        }

        if(!Validations.isEmailValid(email)){
            valid = false;
        }

        if (!valid) {
            Toast.makeText(this,R.string.email_not_valid, Toast.LENGTH_LONG).show();
            progressDialog.dismiss();
            return;
        }

        User loginUser = UserDBApi.getUserByEmail(this, email);
        if (loginUser == null) {
            Toast.makeText(this, getString(R.string.user_name_not_exist), Toast.LENGTH_LONG).show();
            progressDialog.dismiss();
            return;
        }

        //TODO Encrypt password with SHA

        Intent intent = new Intent(MainActivity.this, ChildListActivity.class);
        intent.putExtra("loginUser", loginUser);
        startActivity(intent);
    }

    @Override
    public void onClick(View view){
        if(view == signInBtn){
            String email = this.email.getText().toString().trim();
            String password = userPassword.getText().toString().trim();
            userLogin(email ,password);
        }

        if(view == signUpBtn)
        {
            startActivity(new Intent(MainActivity.this, SignUpActivity.class));
        }
    }
}

