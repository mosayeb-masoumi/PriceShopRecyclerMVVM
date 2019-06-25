package com.example.priceshoprecyclermvvm;

import android.app.Application;
import android.content.Context;


public class App extends Application {

    Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static int total_unit = 0;
    public static int total_price = 0;

}
