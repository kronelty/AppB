package com.example.appb;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SendResolver {

    String URL = "content://com.example.appa.MyContentProvider";
    String sqlresult;
    ContentResolver contentResolver;

    public SendResolver(ContentResolver contentResolver){
        this.contentResolver = contentResolver;
        contentResolver.registerContentObserver(Uri.parse(URL), true, contentObserver);
    };

    ContentObserver contentObserver = new ContentObserver(new Handler()) {
        @Override
        public boolean deliverSelfNotifications() {
            return super.deliverSelfNotifications();
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
        }

        @Override
        public void onChange(boolean selfChange, Uri uri) {
            super.onChange(selfChange, uri);
            Log.e("change", uri.getLastPathSegment());
        }
    };

    protected void insert() {
        ContentValues values1 = new ContentValues();
        values1.put("name", "imggukjung");
        contentResolver.insert(Uri.parse(URL), values1);
    }

    protected void delete() {
        contentResolver.delete(Uri.parse(URL), "name=?", new String[]{"imggukjung"});
    }

    protected void update() {
        ContentValues values2 = new ContentValues();
        values2.put("name", "G-Dragon");
        contentResolver.update(Uri.parse(URL), values2, "name=?", new String[]{"honggilDDong"});
    }

    protected String select() {
        Cursor c = contentResolver.query(Uri.parse(URL), null, null, null, null);
        List<String> list = new ArrayList<>();
        while (c.moveToNext()) {
            list.add(c.getString(c.getColumnIndex("name")));
        }
        sqlresult = list.toString();
        return sqlresult;
    }

    protected void destroy() {
        contentResolver.unregisterContentObserver(contentObserver);
    }
}
