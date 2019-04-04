package com.gifmyneeds.activities.child;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.gifmyneeds.R;
import com.gifmyneeds.activities.menus.ChildListActivity;
import com.gifmyneeds.database.ChildDBApi;
import com.gifmyneeds.models.Child;
import com.gifmyneeds.models.ChildGifs;
import com.gifmyneeds.models.User;
import com.gifmyneeds.utilities.Validations;
import com.google.gson.Gson;

import java.util.ArrayList;


public class AddChildActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etName;
    private EditText etAge;
    private EditText etID;
    private Spinner genderSpinner;
    private SharedPreferences table_childes_gif;
    private Button btnSubChild;
    private static final String TAG = "Main";
    private ArrayList<ChildGifs> list_gif;
    User parent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_child_activity_layout);

        etID = (EditText) findViewById(R.id.etID);
        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        btnSubChild = (Button) findViewById(R.id.btnSubChild);
        genderSpinner = (Spinner) findViewById(R.id.GenderSpinner);
        table_childes_gif = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        list_gif = new ArrayList<ChildGifs>();
        Intent incomingIntent = getIntent();
        parent = (User) incomingIntent.getSerializableExtra("parent");

        btnSubChild.setOnClickListener(this);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(AddChildActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.genderList));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(myAdapter);
    }

    @Override
    public void onBackPressed(){
        finish();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnSubChild:
                if(addChild()) {
                    finish();
                }
                break;
        }
    }

    private boolean addChild() {
        String name = etName.getText().toString();
        String gender = genderSpinner.getSelectedItem().toString();
        String age = etAge.getText().toString();
        String id = etID.getText().toString();

        if (!Validations.isFullNameValid(name)) {
            etName.setError(getString(R.string.uncorrect_name));
            return false;
        }

        if (!Validations.isValidGender(gender)) {
            return false;
        }

        if (!Validations.isAgeValid(age)) {
            etAge.setError(getString(R.string.incorrect_age));
            return false;
        }

        if (!Validations.isIdValid(id)) {
            etID.setError(getString(R.string.incorrect_id));
            return false;
        }
        Child newChild = new Child(id,name, age, gender, parent.getEmail());
        if (!ChildDBApi.addNewChild(this, newChild)) {
            Toast.makeText(AddChildActivity.this, getString(R.string.error_while_add_new_child), Toast.LENGTH_LONG).show();
            return false;
        }

        SharedPreferences.Editor prefsEditor = table_childes_gif.edit();
        Gson gson = new Gson();
        String jsonGifs = gson.toJson(list_gif);
        prefsEditor.putString(id, jsonGifs);
        prefsEditor.commit();

        Intent intent = new Intent(AddChildActivity.this, ChildListActivity.class);
        intent.putExtra("child", newChild);
        setResult(RESULT_OK, intent);



        return true;
    }
}
