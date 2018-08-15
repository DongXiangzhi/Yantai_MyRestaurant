package cn.edu.ldu.myrestaurant.service;


import cn.edu.ldu.myrestaurant.model.Product;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyWebService {
    String BASE_URL = "http://dayup.xin/";
    String FEED = "restaurant/api/items";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET(FEED)
    Call<Product[]> dataItems();

    @GET("restaurant/api/items/category={category}")
    Call<Product[]> dataItems(@Path("category") String category);
}
