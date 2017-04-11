package com.bmpl.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MediaActivity extends AppCompatActivity implements View.OnClickListener{

    Button play, pause, stop;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);

        play = (Button)findViewById(R.id.playButton);
        pause = (Button)findViewById(R.id.pauseButton);
        stop = (Button)findViewById(R.id.stopButton);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.playButton:
                if(mediaPlayer==null)
                {
                    mediaPlayer = MediaPlayer.create(this, R.raw.song);
                    mediaPlayer.start();
                }else
                    {
                        mediaPlayer.start();
                    }

                break;

            case R.id.pauseButton:
                try {
                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.pause();
                    }
                }
                catch (NullPointerException e){
                    Toast.makeText(this,"Play song first", Toast.LENGTH_SHORT).show();
                }
                 /*else if(mediaPlayer==null){
                    Toast.makeText(this,"Play song first", Toast.LENGTH_SHORT).show();
                }*/

                break;

            case R.id.stopButton:
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=null;
                break;

        }

    }
}
