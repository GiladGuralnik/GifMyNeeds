package com.gifmyneeds.activities.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gifmyneeds.R;
import com.gifmyneeds.models.ChildGifs;

import java.util.ArrayList;

public class SelectGifsForBoardActivity extends AppCompatActivity {

    private  ChildGifs childGifs;
    //Gif from res
    //String gifPath = findViewById("")


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
        getGifsByCategory(childGifs.getCategory());



    }

    private ArrayList<String> getGifsByCategory(String category){

        return null;
    }
}
