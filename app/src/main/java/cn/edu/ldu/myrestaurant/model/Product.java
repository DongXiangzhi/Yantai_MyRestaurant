package cn.edu.ldu.myrestaurant.model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

import cn.edu.ldu.myrestaurant.database.ItemsTable;

/**
 * ©2017-2018，作者：董相志，upsunny2008@163.com，版权所有.
 */

public class Product implements Parcelable {
    private String itemId;
    private String itemName;
    private String category;
    private String description;
    private int sortPosition;
    private double price;
    private String image;

    public Product() {
    }

    public Product(String itemId, String itemName, String category, String description, int sortPosition, double price, String image) {
        if (itemId == null) {
            itemId= UUID.randomUUID().toString();
        }
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.description = description;
        this.sortPosition = sortPosition;
        this.price = price;
        this.image = image;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSortPosition() {
        return sortPosition;
    }

    public void setSortPosition(int sortPosition) {
        this.sortPosition = sortPosition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public ContentValues toValues() {
        ContentValues values=new ContentValues(7);
        values.put(ItemsTable.COLUMN_ID,itemId);
        values.put(ItemsTable.COLUMN_NAME,itemName);
        values.put(ItemsTable.COLUMN_CATEGORY,category);
        values.put(ItemsTable.COLUMN_POSITION,sortPosition);
        values.put(ItemsTable.COLUMN_PRICE,price);
        values.put(ItemsTable.COLUMN_DESCRIPTION,description);
        values.put(ItemsTable.COLUMN_IMAGE,image);
        return values;
    }
    @Override
    public String toString() {
        return "DataItem{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", sortPosition=" + sortPosition +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.itemId);
        dest.writeString(this.itemName);
        dest.writeString(this.category);
        dest.writeString(this.description);
        dest.writeInt(this.sortPosition);
        dest.writeDouble(this.price);
        dest.writeString(this.image);
    }

    protected Product(Parcel in) {
        this.itemId = in.readString();
        this.itemName = in.readString();
        this.category = in.readString();
        this.description = in.readString();
        this.sortPosition = in.readInt();
        this.price = in.readDouble();
        this.image = in.readString();
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
