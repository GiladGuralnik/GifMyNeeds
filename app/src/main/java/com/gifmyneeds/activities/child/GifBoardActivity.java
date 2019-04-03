package com.gifmyneeds.activities.child;

import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import com.gifmyneeds.R;

public class GifBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gif_board_activity_layout);

        getWindow().setFormat(PixelFormat.UNKNOWN);

        VideoView v = (VideoView)findViewById(R.id.videoView1);
        String uriPath = "android.resource://com.gifmyneeds/" + R.raw.agree;
        Uri uri2 = Uri.parse(uriPath);
        v.setVideoURI(uri2);
        v.requestFocus();
        v.start();

    }
}
