package com.example.serverandroid.API;

import com.example.serverandroid.Model.ProductsModel;
import com.example.serverandroid.Model.UsersModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiServices {
    //http://apilayer.net/api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=USD&format=1
    //http://localhost:3000/api/product
    Gson GSON=new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:ss:ss")
            .create();
    ApiServices API_SERVICES=new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/api/")
            .addConverterFactory(GsonConverterFactory.create(GSON))
            .build()
            .create(ApiServices.class);
//    ApiServices API_SERVICEStest= new Retrofit.Builder()
//            .baseUrl("http://apilayer.net/")
//            .addConverterFactory(GsonConverterFactory.create(GSON))
//            .build()
//            .create(ApiServices.class);

    @GET("products")
    Call<List<ProductsModel>> getListProducts();
//    @GET("api/live")
//    Call<Test> getListProductstest(@Query("access_key") String access_key,
//                                   @Query("currencies") String currencies,
//                                   @Query("source") String source,
//                                   @Query("format") int format);
    @GET("users")
    Call<List<UsersModel>> getListUser();

    @POST("addUser")
    Call<UsersModel> PostUser(@Body UsersModel model);

    @PUT("addUser")
    Call<UsersModel> PutUser(@Body UsersModel model);
}
