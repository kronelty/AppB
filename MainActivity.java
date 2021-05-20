package com.example.appb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ContentResolver contentResolver;
    TextView result;
    Presenter presenter;
    Animation tick, fadeOut, animTestUpdate, animTestSelect;
    Button insert,delete,update,select;
    private static boolean IsMusicPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentResolver = getContentResolver();
        result = (TextView) findViewById(R.id.result);
        presenter = new Presenter(contentResolver);
        tick = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.tick);
        fadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.del);
        animTestUpdate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_test);
        animTestSelect = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_test);
        insert=findViewById(R.id.insert);
        delete=findViewById(R.id.delete);
        update=findViewById(R.id.update);
        select=findViewById(R.id.select);
    }

    public void mOnClick(View v){
        try {
            switch (v.getId()) {
                case R.id.insert:
                    insert.startAnimation(tick);
                    presenter.insert();
                    break;
                case R.id.delete:
                    delete.startAnimation(fadeOut);
                    presenter.delete();
                    break;
                case R.id.update:
                    update.startAnimation(animTestUpdate);
                    presenter.update();
                    break;
                case R.id.select:
                    select.startAnimation(animTestSelect);
                    Intent intent = new Intent(
                            getApplicationContext(),
                            MusicPlayService.class);
                    if(!IsMusicPlaying) {
                        startService(intent);
                        IsMusicPlaying = true;
                    }else{
                        stopService(intent);
                        IsMusicPlaying = false;
                    }
                    result.setText(presenter.select());
                    break;
            }
        }catch(Exception e){}
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        presenter.destroy();
        contentResolver = null;
    }
}