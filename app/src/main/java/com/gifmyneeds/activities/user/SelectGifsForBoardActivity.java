package com.gifmyneeds.activities.user;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.gifmyneeds.R;
import com.gifmyneeds.activities.MainActivity;
import com.gifmyneeds.models.ChildGifs;

import java.util.ArrayList;

public class SelectGifsForBoardActivity extends AppCompatActivity implements View.OnClickListener  {

    private ArrayList<String> str = new ArrayList<String>();
    private  ChildGifs childGifs = new ChildGifs("1234","game",str);

    private static final String TAG = "SelectGifsForBoardActiv";
    //Gif from res
    //String gifPath = findViewById("")


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_gifs_for_board_activity_layout);



        getWindow().setFormat(PixelFormat.UNKNOWN);

        //Set Button------------------------------------------------------
        Button buttonPlayVideo1 = (Button)findViewById(R.id.button_Video1_1);
        Button buttonPlayVideo2 = (Button)findViewById(R.id.button_Video1_2);
        buttonPlayVideo1.setText("Add");
        buttonPlayVideo2.setText("Add");
        //-----------------------------------------------------------------
        buttonPlayVideo1.setOnClickListener(this);
        buttonPlayVideo2.setOnClickListener(this);

        //Set All video
        VideoView video1 = (VideoView)findViewById(R.id.video_View1_1);
        String uriPath = "android.resource://com.gifmyneeds/" + R.raw.agree;
        Uri uri2 = Uri.parse(uriPath);
        video1.setVideoURI(uri2);
        video1.requestFocus();
        video1.seekTo(1);


        VideoView video2 = (VideoView)findViewById(R.id.video_View1_2);
        uriPath = "android.resource://com.gifmyneeds/" + R.raw.byebye;
        uri2 = Uri.parse(uriPath);
        video2.setVideoURI(uri2);
        video2.requestFocus();
        video2.seekTo(1);



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

    private void addPath(String txt){
        if(childGifs.getPathGif() ==null)
            childGifs.setPathGif(new ArrayList<String>());

        childGifs.getPathGif().add(txt);
        Log.d(TAG, "addPath: "+childGifs.getPathGif().toString());
    }
    private void removePath(String txt){
        if(childGifs.getPathGif() ==null)
            childGifs.setPathGif(new ArrayList<String>());

        childGifs.getPathGif().remove(txt);
        Log.d(TAG, "addPath: "+childGifs.getPathGif().toString());
    }
    @Override
    public void onClick(View view) {
        String uriPath;
        Uri uri2;
        VideoView video;
        Button btn;
        switch(view.getId()) {
            case R.id.button_Video1_1:
                btn = (Button) findViewById(R.id.button_Video1_1);

                video = (VideoView)findViewById(R.id.video_View1_1);
                uriPath = "android.resource://com.gifmyneeds/" + R.raw.agree;
                uri2 = Uri.parse(uriPath);
                video.setVideoURI(uri2);
                video.requestFocus();
                video.start();

                if(btn.getText()=="Add"){
                    addPath(uriPath);
                    btn.setText("Remove");

                }
                else{
                    removePath(uriPath);
                    btn.setText("Add");
                }

                //video.getDuration();
                //video.seekTo();//no need


                break;

            case R.id.button_Video1_2:
                btn = (Button) findViewById(R.id.button_Video1_2);

                VideoView v2 = (VideoView)findViewById(R.id.video_View1_2);
                uriPath = "android.resource://com.gifmyneeds/" + R.raw.byebye;
                uri2 = Uri.parse(uriPath);
                v2.setVideoURI(uri2);
                v2.requestFocus();
                v2.start();

                if(btn.getText()=="Add"){
                    addPath(uriPath);
                    btn.setText("Remove");

                }
                else{
                    removePath(uriPath);
                    btn.setText("Add");
                }


                break;

        }

    }

}
