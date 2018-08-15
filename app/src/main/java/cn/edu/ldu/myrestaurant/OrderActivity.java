package cn.edu.ldu.myrestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import cn.edu.ldu.myrestaurant.model.Product;

public class OrderActivity extends AppCompatActivity {
    private static final String PHOTO_BASE_URL = "http://dayup.xin/restaurant/images/";
    private Product mProduct;
    private ImageView productImage;
    private Button btnReduce, btnAdd, btnSubmit;
    private EditText quantityEdit;
    private TextView productTitleText, priceText, subTotalText, realPaidText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        mProduct = getIntent().getParcelableExtra(ProductDetailFragment.PRODUCT_KEY);
        productImage = findViewById(R.id.productImage);
        btnReduce = findViewById(R.id.btnReduce);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubmit = findViewById(R.id.btnSubmit);
        productTitleText = findViewById(R.id.productTitle);
        quantityEdit = findViewById(R.id.productQuantity);
        priceText = findViewById(R.id.productPrice);
        subTotalText = findViewById(R.id.subTotal);
        realPaidText = findViewById(R.id.realPaid);
        //初始化
        String url = PHOTO_BASE_URL + mProduct.getImage();
        Picasso.with(this)
                .load(url)
                .into(productImage);
        productTitleText.setText(mProduct.getItemName());
        priceText.setText(String.valueOf("￥" + mProduct.getPrice()));
        subTotalText.setText(String.valueOf("￥" + mProduct.getPrice()));
        realPaidText.setText(String.valueOf("￥" + mProduct.getPrice()));
        btnSubmit.setText(String.valueOf("￥" + mProduct.getPrice()) + "        提 交 订 单");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(quantityEdit.getText().toString().trim());
                quantity += 1;
                quantityEdit.setText(String.valueOf(quantity));
                double cost = quantity * mProduct.getPrice();
                subTotalText.setText(String.valueOf(cost));
                realPaidText.setText(String.valueOf(cost));
                btnSubmit.setText(String.valueOf("￥" + cost) + "        提 交 订 单");
            }
        });
        btnReduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(quantityEdit.getText().toString().trim());
                if (quantity > 1) {
                    quantity -= 1;
                    quantityEdit.setText(String.valueOf(quantity));
                    double cost = quantity * mProduct.getPrice();
                    subTotalText.setText(String.valueOf(cost));
                    realPaidText.setText(String.valueOf(cost));
                    btnSubmit.setText(String.valueOf("￥" + cost) + "        提 交 订 单");
                }
            }
        });
        quantityEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String numStr = quantityEdit.getText().toString().trim();
                int quantity = 0;
                if (numStr.length() > 0) {
                    quantity = Integer.parseInt(numStr);
                }
                if (numStr.length() == 0 || quantity == 0) {
                    numStr = "1";
                    quantityEdit.setText(numStr);
                }
                quantity = Integer.parseInt(numStr);
                double cost = quantity * mProduct.getPrice();
                subTotalText.setText(String.valueOf(cost));
                realPaidText.setText(String.valueOf(cost));
                btnSubmit.setText(String.valueOf("￥" + cost) + "        提 交 订 单");

            }
        });
    }
}
