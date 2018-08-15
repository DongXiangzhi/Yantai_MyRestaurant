package cn.edu.ldu.myrestaurant;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.edu.ldu.myrestaurant.model.Product;
import cn.edu.ldu.myrestaurant.service.MyService;

public class PagerActivity extends AppCompatActivity {

    private ViewPager mPager;
    private List<Product> mProductList;
    private Product[] mDataItems;
    private int mNumPages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        Bundle bundle = getIntent().getExtras();
        mProductList = bundle.getParcelableArrayList(MainActivity.PRODUCTLIST);

        mNumPages = mProductList.size();
        mPager = findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ProductDetailFragment.newInstance(mProductList.get(position));
        }

        @Override
        public int getCount() {
            return mNumPages;
        }
    }
}
