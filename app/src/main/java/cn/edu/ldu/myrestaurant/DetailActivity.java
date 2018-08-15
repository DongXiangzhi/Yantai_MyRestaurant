package cn.edu.ldu.myrestaurant;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Locale;

import cn.edu.ldu.myrestaurant.dummy.SampleDataProvider;
import cn.edu.ldu.myrestaurant.model.Product;

public class DetailActivity extends AppCompatActivity {
    private static final String PHOTO_BASE_URL = "http://dayup.xin/restaurant/images/";
    public static final String PRODUCT_KEY = "product_key";
    private Product mProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mProduct = getIntent().getParcelableExtra(MainActivity.PRODUCTID);
        // final Product product = SampleDataProvider.dataItemMap.get(productId);

        TextView nameView =findViewById(R.id.tvItemName);
        nameView.setText(mProduct.getItemName());

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String price = formatter.format(mProduct.getPrice());
        TextView priceView = findViewById(R.id.tvPrice);
        priceView.setText(price);

        TextView descView = findViewById(R.id.tvDescription);
        String oldStr = mProduct.getDescription();
        String newStr = oldStr.replaceAll("\\\\n\\\\n", "\n\n");
        descView.setText(newStr);
        ImageView iv = findViewById(R.id.itemImage);
        String url = PHOTO_BASE_URL + mProduct.getImage();
        Picasso.with(this)
                .load(url)
                .into(iv);
//        Bitmap bitmap = getBitmapFromAsset(product.getImage());
//        iv.setImageBitmap(bitmap);
        FloatingActionButton btnOrder = findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orderIntent = new Intent(DetailActivity.this, OrderActivity.class);
                orderIntent.putExtra(PRODUCT_KEY, mProduct);
                startActivity(orderIntent);
            }
        });
    }
    private Bitmap getBitmapFromAsset(String imageFileName) {
        AssetManager assetManager = getAssets();
        InputStream stream;

        try {
            stream = assetManager.open(imageFileName);
            return BitmapFactory.decodeStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
