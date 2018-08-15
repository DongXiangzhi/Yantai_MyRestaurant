package cn.edu.ldu.myrestaurant;


import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Locale;

import cn.edu.ldu.myrestaurant.dummy.SampleDataProvider;
import cn.edu.ldu.myrestaurant.model.Product;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailFragment extends Fragment {

    public static final String PRODUCTID = "productid";
    private static final String PHOTO_BASE_URL = "http://dayup.xin/restaurant/images/";
    public static final String PRODUCT_KEY = "product_key";
    private Product mProduct;

    public ProductDetailFragment() {
        // Required empty public constructor
    }

    public static ProductDetailFragment newInstance(Product product) {
        Bundle args = new Bundle();
        ProductDetailFragment fragment = new ProductDetailFragment();
        args.putParcelable(PRODUCTID, product);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mProduct = getArguments().getParcelable(PRODUCTID);
            //mProduct = SampleDataProvider.dataItemMap.get(productId);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_product_detail, container, false);

        TextView nameView =view.findViewById(R.id.tvItemName);
        nameView.setText(mProduct.getItemName());

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String price = formatter.format(mProduct.getPrice());
        TextView priceView = view.findViewById(R.id.tvPrice);
        priceView.setText(price);

        TextView descView = view.findViewById(R.id.tvDescription);

        descView.setText(mProduct.getDescription().replaceAll("\\\\n\\\\n", "\n\n"));

        ImageView iv = view.findViewById(R.id.itemImage);
        String url = PHOTO_BASE_URL + mProduct.getImage();
        Picasso.with(getContext())
                .load(url)
                .into(iv);
//        Bitmap bitmap = getBitmapFromAsset(mProduct.getImage());
//        iv.setImageBitmap(bitmap);

        FloatingActionButton btnOrder = view.findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orderIntent = new Intent(getActivity(), OrderActivity.class);
                orderIntent.putExtra(PRODUCT_KEY, mProduct);
                startActivity(orderIntent);
            }
        });
        return view;
    }
    private Bitmap getBitmapFromAsset(String imageFileName) {
        AssetManager assetManager =getContext().getAssets();
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
