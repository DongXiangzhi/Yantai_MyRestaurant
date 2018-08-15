package cn.edu.ldu.myrestaurant;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import cn.edu.ldu.myrestaurant.dummy.SampleDataProvider;
import cn.edu.ldu.myrestaurant.model.Product;
import cn.edu.ldu.myrestaurant.service.MyService;
import cn.edu.ldu.myrestaurant.service.MyWebService;
import cn.edu.ldu.myrestaurant.util.CustomDialog;
import cn.edu.ldu.myrestaurant.util.JSONHelper;
import cn.edu.ldu.myrestaurant.util.NetworkHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 程序入口：MainActivity，实现主界面
 * ©2017-2018，作者：董相志，upsunny2008@163.com，版权所有.
 */
//public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Map<String,Bitmap>> {
public class MainActivity extends AppCompatActivity implements ProductListFragment.OnListFragmentInteractionListener, CustomDialog.CustomDialogListener {

    private static final int REQUEST_CODE = 1001;
    private static final int REQUEST_PERMISSION_WRITE = 1002;
    private static final int DETAIL_REQUEST = 1003;

    public static final String MY_GLOBAL_PREFS = "my_global_prefs";
    private static final String INTER_FILE_NAME = "inter.txt";
    private static final String OUTER_FILE_NAME = "out.txt";
    private static final String TAG = "MainActivity";
    public static final String PRODUCTID = "productid";
    public static final String PRODUCTLIST = "productlist";

    private List<String> itemNames = new ArrayList<>();
    private boolean permissionGranted;
    //private DataSource mDataSource;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private String[] mCategories;
    //List<Product> listFromDB;
    private List<Product> dataItemList = SampleDataProvider.dataItemList;
    private List<Product> mProductList;
    private ArrayList<Product> pagerList;
    private Product[] mDataItems;
    private ProductListAdapter adapter;
    private RecyclerView recyclerView;
    //public static final String JSON_URL="http://dayup.xin:8080/restaurant/api/items";
    private boolean networkOk;
    private Map<String, Bitmap> mBitmaps;
    private ProductListFragment.OnListFragmentInteractionListener mListener;
    private boolean mIsTablet;
    private boolean mYesNo;
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //String message=intent.getStringExtra(MyService.MY_SERVICE_FINISHED);
            //output.append(message+"\n");
            mDataItems = (Product[]) intent.getParcelableArrayExtra(MyService.MY_SERVICE_FINISHED);
            mProductList = Arrays.asList(mDataItems);
            Toast.makeText(context, "获取的菜单数：" + mDataItems.length, Toast.LENGTH_SHORT).show();
//            getSupportLoaderManager().initLoader(0,null,MainActivity.this).forceLoad();
            displayProducts(null);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout fragmentContainer =
                findViewById(R.id.detail_fragment_container);
        mIsTablet = (fragmentContainer != null);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mCategories = getResources().getStringArray(R.array.categories);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerList.setAdapter(new ArrayAdapter<>(this, R.layout.drawer_list_item, mCategories));

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String category = mCategories[i];
                Toast.makeText(MainActivity.this, "你选择了：" + category, Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawer(mDrawerList);
                //displayProducts(category);
                requestData(category);
            }
        });

//        mDataSource=new DataSource(this);
//        mDataSource.open();
//        mDataSource.seedDatabase(dataItemList);

        checkPermissions();


//        recyclerView = findViewById(R.id.viewList);
//        if (grid) {
//            recyclerView.setLayoutManager(new GridLayoutManager(this,3));
//        }
        networkOk = NetworkHelper.hasNetworkAcess(this);
        if (networkOk) {
            Intent intent = new Intent(this, MyService.class);
            //intent.setData(Uri.parse(JSON_URL));
            startService(intent);
        } else {
            Toast.makeText(this, "手机网络没有开启！", Toast.LENGTH_SHORT).show();
        }
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(mBroadcastReceiver, new IntentFilter(MyService.MY_SERVICE_MESSAGE));

    }

    private void displayProducts(String category) {
        //listFromDB = mDataSource.getAllItems(category);
        if (mProductList != null) {
            SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
            boolean grid = settings.getBoolean(getString(R.string.pref_dispaly_grid), false);
            ProductListFragment listFragment;
            if (grid) {
                listFragment = ProductListFragment.newInstance(3, (Product[]) mProductList.toArray());
            } else {
                listFragment = ProductListFragment.newInstance(1, (Product[]) mProductList.toArray());
            }

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, listFragment)
                    .commit();
        }
//        if (mProductList!=null) {
//            //adapter = new ProductAdapter(this,mProductList,mBitmaps);
//            adapter = new ProductListAdapter(this,mProductList,mListener);
//            recyclerView.setAdapter(adapter);
//        }
    }

    private void requestData() {
//        Intent intent=new Intent(this,MyService.class);
//        startService(intent);
        MyWebService webService = MyWebService
                .retrofit
                .create(MyWebService.class);
        Call<Product[]> call = webService.dataItems();

        sendRequest(call);
    }

    private void requestData(String category) {
        MyWebService webService = MyWebService
                .retrofit
                .create(MyWebService.class);
        Call<Product[]> call = webService.dataItems(category);

        sendRequest(call);
    }

    private void sendRequest(Call<Product[]> call) {
        call.enqueue(new Callback<Product[]>() {
            @Override
            public void onResponse(Call<Product[]> call, Response<Product[]> response) {
                Product[] dataItems = response.body();
                mProductList = Arrays.asList(dataItems);
                Toast.makeText(MainActivity.this, "获取的菜单数：" + dataItems.length, Toast.LENGTH_SHORT).show();
                displayProducts(null);
            }

            @Override
            public void onFailure(Call<Product[]> call, Throwable t) {

            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        // mDataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //mDataSource.open();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_login:
                Intent intent = new Intent(this, LoginActivity.class);
                // startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE);
                return true;
            case R.id.action_settings:
                Intent settingsIntent = new Intent(this, PrefsActivity.class);
                startActivity(settingsIntent);
                return true;
            case R.id.action_interSave:
                interSave();
                return true;
            case R.id.action_interRead:
                interRead();
                return true;
            case R.id.action_interDelete:
                showDialog("删除文件提醒", "确定要删除内部文件吗？");
                //if interDelete();
                return true;
            case R.id.action_outerSave:
                outerSave();
                return true;
            case R.id.action_outerRead:
                outerRead();
                return true;
            case R.id.action_outerDelete:
                outerDelete();
                return true;
            case R.id.action_exportJson:
                boolean result = JSONHelper.exportToJSON(this, dataItemList);
                if (result) {
                    Toast.makeText(this, "json文件导出成功！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "json文件导出失败！", Toast.LENGTH_SHORT).show();
                }
                return true;
            case R.id.action_importJson:
                List<Product> items = JSONHelper.importFromJSON(this);
                if (items != null) {
                    for (Product data : items) {
                        Log.i(TAG, "onOptionsItemSelected: " + data.getItemName());
                    }
                }
                return true;
            case R.id.action_displayAll:
                //displayProducts(null);
                requestData();
                return true;
            case R.id.action_displayByCategory:
                mDrawerLayout.openDrawer(mDrawerList);
                return true;
            case R.id.action_about:
                Intent about = new Intent(this, AboutActivity.class);
                startActivity(about);
                return true;
            case R.id.action_pager:
                Intent pager = new Intent(this, PagerActivity.class);
                pagerList = new ArrayList(mProductList);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(PRODUCTLIST, pagerList);

                pager.putExtras(bundle);
                startActivity(pager);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showDialog(String title, String info) {
        CustomDialog dialog = CustomDialog.newInstance(title, info);
        dialog.show(getSupportFragmentManager(), "DELETE_DIALOG");
    }

    private void outerDelete() {
        if (!permissionGranted) {
            if (!checkPermissions()) {
                return;
            }
        }
        // File file=new File(getFilesDir(),INTER_FILE_NAME);
        File file = getFile();
        if (file.exists()) {
            //deleteFile(INTER_FILE_NAME);
            file.delete();
            Toast.makeText(this, "文件已被删除！", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "文件不存在！", Toast.LENGTH_SHORT).show();
        }
    }


    private void outerRead() {
        if (!permissionGranted) {
            if (!checkPermissions()) {
                return;
            }
        }
        FileInputStream in = null;
        try {
            //in=openFileInput(INTER_FILE_NAME);
            File file = getFile();
            in = new FileInputStream(file);
            byte[] readBuf = new byte[1024];
            in.read(readBuf);
            String readContent = new String(readBuf, "UTF-8");
            Toast.makeText(this, "读取的文件内容：" + readContent, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void outerSave() {
        if (!permissionGranted) {
            if (!checkPermissions()) {
                return;
            }
        }
        String savedContent = "";
        for (Product item : dataItemList) {
            savedContent += item.getItemId() + ","
                    + item.getItemName() + ","
                    + item.getCategory() + ","
                    + item.getPrice() + ","
                    + item.getImage() + "\r\n";
        }
        FileOutputStream out = null;
        try {
            //out = openFileOutput(INTER_FILE_NAME,MODE_PRIVATE);
            File file = getFile();
            out = new FileOutputStream(file);
            out.write(savedContent.getBytes());
            Toast.makeText(this, "外部文件保存成功！", Toast.LENGTH_SHORT).show();
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
    }

    private File getFile() {
        return new File(Environment.getExternalStorageDirectory(), OUTER_FILE_NAME);
    }

    private void interDelete() {
        File file = new File(getFilesDir(), INTER_FILE_NAME);
        if (file.exists()) {
            deleteFile(INTER_FILE_NAME);
            Toast.makeText(this, "文件已被删除！", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "文件不存在！", Toast.LENGTH_SHORT).show();
        }
    }

    private void interRead() {
        FileInputStream in = null;
        try {
            in = openFileInput(INTER_FILE_NAME);
            byte[] readBuf = new byte[1024];
            in.read(readBuf);
            String readContent = new String(readBuf, "UTF-8");
            Toast.makeText(this, "读取的文件内容：" + readContent, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void interSave() {
        String savedContent = "";
        for (Product item : dataItemList) {
            savedContent += item.getItemId() + ","
                    + item.getItemName() + ","
                    + item.getCategory() + ","
                    + item.getPrice() + ","
                    + item.getImage() + "\r\n";
        }
        FileOutputStream out = null;
        try {
            out = openFileOutput(INTER_FILE_NAME, MODE_PRIVATE);
            out.write(savedContent.getBytes());
            Toast.makeText(this, "内部文件保存成功！", Toast.LENGTH_SHORT).show();
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
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            String email = data.getStringExtra(LoginActivity.EMAIL_KEY);
            Toast.makeText(this, "您的登录邮箱是：" + email, Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor prefs = getSharedPreferences(MY_GLOBAL_PREFS, MODE_PRIVATE).edit();
            prefs.putString(LoginActivity.EMAIL_KEY, email);
            prefs.apply();
        }
    }

    private boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    private boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state));
    }

    private boolean checkPermissions() {
        if (!isExternalStorageWritable() || !isExternalStorageReadable()) {
            Toast.makeText(this, "当前App不允许读写外部存储空间", Toast.LENGTH_SHORT).show();
            return false;
        }
        int checkPemission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (checkPemission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSION_WRITE);
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_WRITE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    permissionGranted = true;
                    Toast.makeText(this, "用户同意读写权限", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "用户拒绝了读写权限！", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(mBroadcastReceiver);
    }

//    @Override
//    public Loader<Map<String,Bitmap>> onCreateLoader(int id, Bundle args) {
//        return new ImageDownloader(this,mProductList);
//    }
//
//    @Override
//    public void onLoadFinished(Loader<Map<String,Bitmap>> loader, Map<String,Bitmap> data) {
//        mBitmaps=data;
//        displayProducts(null);
//    }
//
//    @Override
//    public void onLoaderReset(Loader<Map<String,Bitmap>> loader) {
//
//    }

    //    private  static class  ImageDownloader extends AsyncTaskLoader<Map<String,Bitmap>> {
//        private static List<Product> mProducts;
//        private static final String PHOTO_BASE_URL="http://dayup.xin:8080/restaurant/images/";
//        public ImageDownloader(Context context,List<Product> itemList) {
//            super(context);
//            mProducts=itemList;
//        }
//
//        @Override
//        public Map<String, Bitmap> loadInBackground() {
//            Map<String,Bitmap> map=new HashMap<>();
//            for (Product item :
//                    mProducts) {
//                String imageUrl=PHOTO_BASE_URL+item.getImage();
//                InputStream in=null;
//
//                try {
//                    in=(InputStream) new URL(imageUrl).getContent();
//                    Bitmap bitmap= BitmapFactory.decodeStream(in);
//                    map.put(item.getItemId(),bitmap);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }finally {
//                    try {
//                        in.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//            return map;
//        }
//    }
    @Override
    public void onListFragmentInteraction(Product item) {

        if (mIsTablet) {
            ProductDetailFragment fragment =
                    ProductDetailFragment.newInstance(item);
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.detail_fragment_container, fragment)
                    .commit();
        } else {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra(PRODUCTID, item);
            startActivityForResult(intent, DETAIL_REQUEST);
        }

    }

    @Override
    public void onCustomDialogComplete(boolean ok) {
        if (ok) interDelete();
    }

}
