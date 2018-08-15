package cn.edu.ldu.myrestaurant.util;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import cn.edu.ldu.myrestaurant.model.Product;


public class JSONHelper {
    public static final String JSON_FILE_NAME = "menu.json";
    private static final String TAG = "JSONHelper";

    public static boolean exportToJSON(Context context, List<Product> dataItemList) {
        Products dataItems = new Products();
        dataItems.setProducts(dataItemList);
        Gson gson = new Gson();
        String jsonString = gson.toJson(dataItems);
        Log.i(TAG, "exportToJSON: " + jsonString);
        Toast.makeText(context, "输出：" + jsonString, Toast.LENGTH_LONG).show();
        FileOutputStream out = null;
        try {
            File file = new File(Environment.getExternalStorageDirectory(), JSON_FILE_NAME);
            out = new FileOutputStream(file);
            out.write(jsonString.getBytes());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public static List<Product> importFromJSON(Context context) {
        FileReader reader = null;
        try {
            File file = new File(Environment.getExternalStorageDirectory(), JSON_FILE_NAME);
            reader = new FileReader(file);
            Gson gson = new Gson();
            Products dataItems = gson.fromJson(reader, Products.class);
            return dataItems.getProducts();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    static class Products {
        List<Product> dataItems;

        public List<Product> getProducts() {
            return dataItems;
        }

        public void setProducts(List<Product> dataItems) {
            this.dataItems = dataItems;
        }
    }
}
