package cn.edu.ldu.myrestaurant.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.IOException;

import cn.edu.ldu.myrestaurant.model.Product;
import retrofit2.Call;

public class MyService extends IntentService {
    public static final String MY_SERVICE_MESSAGE = "MyServiceMessage";
    public static final String MY_SERVICE_FINISHED = "MyServiceFinished";
    public static final String TAG = "MyService";

    public MyService() {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
//        Uri uri=intent.getData();
//
//        Log.i(TAG, "onHandleIntent: "+uri.toString());
//        String response;
//        try {
//
//            response = HttpHelper.downloadUrl(uri.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//            return;
//        }
//
//        Gson gson=new Gson();
//        Product[] dataItems=gson.fromJson(response,Product[].class);
        MyWebService webService = MyWebService
                .retrofit
                .create(MyWebService.class);
        Call<Product[]> call = webService.dataItems();
        Product[] dataItems;
        try {
            dataItems = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            Log.i(TAG, "onHandleIntent: " + e.getMessage());
            return;
        }

        Intent messageIntent = new Intent(MY_SERVICE_MESSAGE);
        messageIntent.putExtra(MY_SERVICE_FINISHED, dataItems);
        LocalBroadcastManager manager = LocalBroadcastManager.getInstance(getApplicationContext());
        manager.sendBroadcast(messageIntent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");

    }
}
