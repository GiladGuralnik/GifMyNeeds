package com.gifmyneeds.activities.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gifmyneeds.R;
import com.gifmyneeds.models.ChildGifs;

public class SelectGifsForBoardActivity extends AppCompatActivity {

    private  ChildGifs childGifs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_gifs_for_board_activity_layout);

//        Intent intent = new Intent(SelectCategoryForBoardActivity.this,
//                SelectGifsForBoardActivity.class);
//        intent.putExtra("key", "value");
//        startActivity(intent);
        Intent incomingIntent = getIntent();
        //String value = incomingIntent.getStringExtra("key");
        childGifs = (ChildGifs) incomingIntent.getSerializableExtra("category");



    }
}
