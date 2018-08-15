package cn.edu.ldu.myrestaurant.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import cn.edu.ldu.myrestaurant.model.Product;


public class ImageCacheHelper {
    public static Bitmap getBitmap(Context context, Product dataItem) {
        String fileName = context.getCacheDir() + "/" + dataItem.getImage();
        File file = new File(fileName);
        if (file.exists()) {
            try {
                return BitmapFactory.decodeStream(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void putBitmap(Context context, Product dataItem, Bitmap bitmap) {
        String fileName = context.getCacheDir() + "/" + dataItem.getImage();
        File file = new File(fileName);
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
