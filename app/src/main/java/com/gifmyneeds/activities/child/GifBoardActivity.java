package com.gifmyneeds.activities.child;

import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.gifmyneeds.R;



public class GifBoardActivity extends AppCompatActivity {



    final static int LIMIT = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gif_board_activity_layout);

        getWindow().setFormat(PixelFormat.UNKNOWN);


        Button buttonPlayVideo1 = (Button)findViewById(R.id.buttonVideo1);
        Button buttonPlayVideo2 = (Button)findViewById(R.id.buttonVideo2);
        Button buttonPlayVideo3 = (Button)findViewById(R.id.buttonVideo3);
        Button buttonPlayVideo4 = (Button)findViewById(R.id.buttonVideo4);
        Button buttonPlayVideo5 = (Button)findViewById(R.id.buttonVideo5);
        Button buttonPlayVideo6 = (Button)findViewById(R.id.buttonVideo6);

        //Buttons Array
        Button[] buttons = new Button[6];
        buttons[0] = buttonPlayVideo1;
        buttons[1] = buttonPlayVideo2;
        buttons[2] = buttonPlayVideo3;
        buttons[3] = buttonPlayVideo4;
        buttons[4] = buttonPlayVideo5;
        buttons[5] = buttonPlayVideo6;



        //TESTS TETSTSTST TETSTS

        int one = R.raw.agree;
        int two = R.raw.byebye;
        int three = R.raw.disagree;
        int four = R.raw.drink_coke;
        int five = R.raw.drink_tea;
        int six = R.raw.eat_bamba;


        final int frameOne = R.id.videoView1;
        final int frameTwo = R.id.videoView2;
        final int frameThree = R.id.videoView3;
        final int frameFour = R.id.videoView4;
        final int frameFive = R.id.videoView5;
        final int frameSix = R.id.videoView6;


        final int arr [] = {one,two,three,four,five};


        final int frameArr [] = {frameOne,frameTwo,frameThree,frameFour,frameFive,frameSix};



        //On seek Loop
        for(int i = 0; i<arr.length && i<LIMIT;i++)
        {

            VideoView v = (VideoView)findViewById(frameArr[i]);
            String uriPath = "android.resource://com.gifmyneeds/" + arr[i];
            Uri uri2 = Uri.parse(uriPath);
            v.setVideoURI(uri2);
            v.requestFocus();
            v.seekTo(1);
        }


        int index = 0;



        buttonPlayVideo1.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                VideoView v2 = (VideoView) findViewById(frameOne);
                if(arr.length>0 && arr[0] != 0) {
                    String uriPath = "android.resource://com.gifmyneeds/" + arr[0];
                    Uri uri2 = Uri.parse(uriPath);
                    v2.setVideoURI(uri2);
                    v2.requestFocus();
                    v2.start();
                }

            }
        });

        buttonPlayVideo2.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                VideoView v2 = (VideoView) findViewById(frameTwo);
                if(arr.length>1 && arr[1] != 0) {
                    String uriPath = "android.resource://com.gifmyneeds/" + arr[1];
                    Uri uri2 = Uri.parse(uriPath);
                    v2.setVideoURI(uri2);
                    v2.requestFocus();
                    v2.start();
                }

            }
        });

        buttonPlayVideo3.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                VideoView v2 = (VideoView) findViewById(frameThree);
                if(arr.length>2 && arr[2] != 0){
                     String uriPath = "android.resource://com.gifmyneeds/" + arr[2];
                     Uri uri2 = Uri.parse(uriPath);
                      v2.setVideoURI(uri2);
                     v2.requestFocus();
                     v2.start();
                }

            }
        });

        buttonPlayVideo4.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                VideoView v2 = (VideoView) findViewById(frameFour);

                if(arr.length>3 && arr[3] != 0) {
                    String uriPath = "android.resource://com.gifmyneeds/" + arr[3];
                    Uri uri2 = Uri.parse(uriPath);
                    v2.setVideoURI(uri2);
                    v2.requestFocus();
                    v2.start();
                }

            }
        });

        buttonPlayVideo5.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                VideoView v2 = (VideoView) findViewById(frameFive);
                if(arr.length>4 && arr[4] != 0) {
                    String uriPath = "android.resource://com.gifmyneeds/" + arr[4];
                    Uri uri2 = Uri.parse(uriPath);
                    v2.setVideoURI(uri2);
                    v2.requestFocus();
                    v2.start();
                }

            }
        });

        buttonPlayVideo6.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                VideoView v2 = (VideoView) findViewById(frameSix);
                if(arr.length>5 && arr[5] != 0) {
                    String uriPath = "android.resource://com.gifmyneeds/" + arr[5];
                    Uri uri2 = Uri.parse(uriPath);
                    v2.setVideoURI(uri2);
                    v2.requestFocus();
                    v2.start();
                }

            }
        });


    }
}
