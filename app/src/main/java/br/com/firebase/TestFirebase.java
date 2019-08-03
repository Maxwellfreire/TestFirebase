package br.com.firebase;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class TestFirebase extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

    }

}
