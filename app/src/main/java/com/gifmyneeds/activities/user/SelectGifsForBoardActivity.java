package com.gifmyneeds.activities.user;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.gifmyneeds.R;
import com.gifmyneeds.activities.MainActivity;
import com.gifmyneeds.models.ChildGifs;

import java.util.ArrayList;

public class SelectGifsForBoardActivity extends AppCompatActivity implements View.OnClickListener  {

    private  ChildGifs childGifs;
    //Gif from res
    //String gifPath = findViewById("")


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_gifs_for_board_activity_layout);

        getWindow().setFormat(PixelFormat.UNKNOWN);
        Button buttonPlayVideo1 = (Button)findViewById(R.id.button_Video1_1);
        Button buttonPlayVideo2 = (Button)findViewById(R.id.button_Video1_2);

        buttonPlayVideo1.setOnClickListener(this);
        buttonPlayVideo2.setOnClickListener(this);

        VideoView video1 = (VideoView)findViewById(R.id.video_View1_1);
        String uriPath = "android.resource://com.gifmyneeds/" + R.raw.agree;
        Uri uri2 = Uri.parse(uriPath);
        video1.setVideoURI(uri2);
        video1.requestFocus();
        video1.seekTo(1);
        //video1.start();

        VideoView video2 = (VideoView)findViewById(R.id.video_View1_2);
        uriPath = "android.resource://com.gifmyneeds/" + R.raw.byebye;
        uri2 = Uri.parse(uriPath);
        video2.setVideoURI(uri2);
        video2.requestFocus();
        video2.seekTo(1);
        //v2.start();


//        Intent intent = new Intent(SelectCategoryForBoardActivity.this,
//                SelectGifsForBoardActivity.class);
//        intent.putExtra("key", "value");
//        startActivity(intent);
        //String value = incomingIntent.getStringExtra("key");
        //Intent incomingIntent = getIntent();

        //childGifs = (ChildGifs) incomingIntent.getSerializableExtra("child_gif");
        //getGifsByCategory(childGifs.getCategory());

    }

    private ArrayList<String> getGifsByCategory(String category){

        return null;
    }

    @Override
    public void onClick(View view) {
        String uriPath;
        Uri uri2;
        VideoView video;
        switch(view.getId()) {
            case R.id.button_Video1_1:
                video = (VideoView)findViewById(R.id.video_View1_1);
                uriPath = "android.resource://com.gifmyneeds/" + R.raw.agree;
                uri2 = Uri.parse(uriPath);
                video.setVideoURI(uri2);
                video.requestFocus();
                video.start();
                //video.getDuration();
                //video.seekTo();//no need
                break;

            case R.id.button_Video1_2:
                VideoView v2 = (VideoView)findViewById(R.id.video_View1_2);
                uriPath = "android.resource://com.gifmyneeds/" + R.raw.byebye;
                uri2 = Uri.parse(uriPath);
                v2.setVideoURI(uri2);
                v2.requestFocus();
                v2.start();
                //v2.seekTo(1);
                break;

        }

    }

}
