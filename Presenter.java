package com.example.appb;

import android.content.ContentResolver;

public class Presenter {
    SendResolver resolver;
    private int cnt;

    public Presenter(ContentResolver contentResolver){
        resolver = new SendResolver(contentResolver);
        cnt=0;
    }

    protected void insert(){
        if(cnt<3) {
            cnt++;
            resolver.insert();
        }
    }

    protected void delete(){
        cnt=0;
        resolver.delete();
    }

    protected void setCnt(int num){
         cnt = num;
    }

    protected int getCnt(){
        return cnt;
    }

    protected void update(){
        resolver.update();
    }

    protected String select(){
        return resolver.select();
    }

    protected void destroy(){
        resolver.destroy();
        resolver = null;
    }
}
