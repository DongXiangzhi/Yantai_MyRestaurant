package cn.edu.ldu.myrestaurant;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import cn.edu.ldu.myrestaurant.ProductListFragment.OnListFragmentInteractionListener;
import cn.edu.ldu.myrestaurant.model.Product;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 列表视图适配器：ProductListAdapter
 * {@link RecyclerView.Adapter}显示菜品清单
 * {@link Product} 并且调用接口
 * {@link OnListFragmentInteractionListener}实现交互操作
 * ©2017-2018，作者：董相志，upsunny2008@163.com，版权所有.
 */
public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {
    private static final String PHOTO_BASE_URL = "http://dayup.xin/restaurant/images/";
    public static final String ITEM_KEY = "item_key";
    private final List<Product> mValues;
    private final OnListFragmentInteractionListener mListener;
    private Context mContext;
    private SharedPreferences.OnSharedPreferenceChangeListener prefsListener;
    private Map<String, Bitmap> mBitmaps = new HashMap<>();
    public ProductListAdapter(Context context, List<Product> items, OnListFragmentInteractionListener listener) {
        mContext=context;
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(mContext);
        prefsListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                boolean grid = settings.getBoolean(mContext.getString(R.string.pref_dispaly_grid), false);
                Toast.makeText(mContext, "你刚才改变了首先项：" + key + "当前值为：" + grid, Toast.LENGTH_LONG).show();
            }
        };
        settings.registerOnSharedPreferenceChangeListener(prefsListener);
        boolean grid = settings.getBoolean(mContext.getString(R.string.pref_dispaly_grid), false);
        int layoutId = grid ? R.layout.fragment_product_grid_item : R.layout.fragment_product;

        View view = LayoutInflater.from(parent.getContext())
                .inflate(layoutId, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        String imageFile=mValues.get(position).getImage();
        InputStream inputStream=null;
        try {
//            String imageFile=item.getImage();
//            inputStream = mContext.getAssets().open(imageFile);
//            Drawable d=Drawable.createFromStream(inputStream,null);
//            holder.imageView.setImageDrawable(d);
//            if (mBitmaps.containsKey(item.getItemId())){
//                Bitmap bitmap=mBitmaps.get(item.getItemId());
//                holder.imageView.setImageBitmap(bitmap);
//            }else {
//                ImageDownloadTask task=new ImageDownloadTask();
//                task.setViewHolder(holder);
//                task.execute(item);
//            }
            String url = PHOTO_BASE_URL + holder.mItem.getImage();
            Picasso.with(mContext)
                    .load(url)
                    .resize(100, 100)
                    .into(holder.mImageView);

//            Bitmap bitmap= ImageCacheHelper.getBitmap(mContext,item);
//            if (bitmap == null) {
//                ImageDownloadTask task=new ImageDownloadTask();
//                task.setViewHolder(holder);
//                task.execute(item);
//            }else {
//                holder.imageView.setImageBitmap(bitmap);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext, "你点击了："+item.getItemName(), Toast.LENGTH_SHORT).show();
                //String itemId=item.getItemId();

                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(ITEM_KEY, holder.mItem);
                mContext.startActivity(intent);


            }
        });
        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext, "你长点击了：" + holder.mItem.getItemName(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
//        InputStream inputStream=null;
//        try {
//            inputStream = mContext.getAssets().open(imageFile);
//            Drawable d= Drawable.createFromStream(inputStream,null);
//            holder.mImageView.setImageDrawable(d);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if (inputStream != null) {
//                    inputStream.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        holder.mNameView.setText(mValues.get(position).getItemName());
        holder.mPriceView.setText(String.valueOf(mValues.get(position).getPrice()));
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mImageView;
        public final TextView mNameView;
        public final TextView mPriceView;
        public  Product mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = view.findViewById(R.id.imageView);
            mNameView =  view.findViewById(R.id.nameView);
            mPriceView=view.findViewById(R.id.priceView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNameView.getText() + "'";
        }
    }


    //    private class ImageDownloadTask extends AsyncTask<DataItem,Void,Bitmap> {
//        private static final String PHOTO_BASE_URL="http://dayup.xin:8080/restaurant/images/";
//        private DataItem mDataItem;
//        private ViewHolder mHolder;
//
//        public void setViewHolder(ViewHolder holder) {mHolder=holder;}
//        @Override
//        protected Bitmap doInBackground(DataItem... dataItems) {
//            mDataItem=dataItems[0];
//            String imageUrl=PHOTO_BASE_URL+mDataItem.getImage();
//            InputStream in=null;
//            try {
//                in=(InputStream) new URL(imageUrl).getContent();
//                return BitmapFactory.decodeStream(in);
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    if (in != null) {
//                        in.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Bitmap bitmap) {
//            super.onPostExecute(bitmap);
//            mHolder.imageView.setImageBitmap(bitmap);
//            //mBitmaps.put(mDataItem.getItemId(),bitmap);
//            ImageCacheHelper.putBitmap(mContext,mDataItem,bitmap);
//        }
//    }
}
