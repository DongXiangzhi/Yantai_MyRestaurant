package cn.edu.ldu.myrestaurant.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import cn.edu.ldu.myrestaurant.model.Product;


public class DataSource {
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private SQLiteOpenHelper mDbHelper;

    public DataSource(Context context) {
        this.mContext = context;
        mDbHelper = new DBHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void open() {
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close() {
        mDbHelper.close();
    }

    public Product createItem(Product item) {
        ContentValues values = item.toValues();
        mDatabase.insert(ItemsTable.TABLE_NAME, null, values);
        return item;
    }

    public long getProductsCount() {
        return DatabaseUtils.queryNumEntries(mDatabase, ItemsTable.TABLE_NAME);
    }

    public void seedDatabase(List<Product> dataItemList) {
        long itemNums = getProductsCount();
        if (itemNums == 0) {
            for (Product item :
                    dataItemList) {
                try {
                    createItem(item);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }//end for
        }//end if
    }//end seedDatabase

    public List<Product> getAllItems(String category) {
        List<Product> dataItems = new ArrayList<>();
        Cursor cursor = null;
        if (category == null) {
            cursor = mDatabase.query(ItemsTable.TABLE_NAME, ItemsTable.ALL_COLUMNS,
                    null, null, null, null, ItemsTable.COLUMN_NAME);
        } else {
            String[] categories = {category};
            cursor = mDatabase.query(ItemsTable.TABLE_NAME, ItemsTable.ALL_COLUMNS,
                    ItemsTable.COLUMN_CATEGORY + "=?", categories, null, null, ItemsTable.COLUMN_NAME);
        }

        while (cursor.moveToNext()) {
            Product item = new Product();
            item.setItemId(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_ID)));
            item.setItemName(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_NAME)));
            item.setCategory(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_CATEGORY)));
            item.setSortPosition(cursor.getInt(cursor.getColumnIndex(ItemsTable.COLUMN_POSITION)));
            item.setPrice(cursor.getDouble(cursor.getColumnIndex(ItemsTable.COLUMN_PRICE)));
            item.setDescription(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_DESCRIPTION)));
            item.setImage(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_IMAGE)));
            dataItems.add(item);
        }
        cursor.close();
        return dataItems;
    }
}
