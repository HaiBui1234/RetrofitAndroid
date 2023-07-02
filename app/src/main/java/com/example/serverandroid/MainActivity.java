package com.example.serverandroid;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.serverandroid.API.ApiServices;
import com.example.serverandroid.AllViewPager.ViewPagerproduct;
import com.example.serverandroid.Model.ProductsModel;
import com.example.serverandroid.Model.UsersModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<ProductsModel> productsModels;
    RecyclerView recyclerView;
    EditText edSearch;
    UsersModel model1;
    ImageView imgSearch,imgaccout;
//    CategoryModel categoryModel=new CategoryModel("434","434");
    ViewPagerproduct viewPagerproduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recyView);
        edSearch=findViewById(R.id.id_Search);
        imgSearch=findViewById(R.id.Search);
        imgaccout=findViewById(R.id.accout);
        productsModels=new ArrayList<>();
        savedInstanceState=getIntent().getExtras();
        model1= (UsersModel) savedInstanceState.getSerializable("user");
        Log.d("TAG", "onCreate: "+model1.getUsername());
//        productsModels.add(new ProductsModel("rweq","dwe","eee","wew",323,categoryModel));
        LinearLayoutManager manager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        getdata();
         imgSearch.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
             String tvSearch=edSearch.getText().toString();
             List<ProductsModel> searchmodel=new ArrayList<>();
                 for (ProductsModel productsModel:productsModels
                      ) {
                     if (productsModel.getName().equalsIgnoreCase(tvSearch)){
                         searchmodel.add(productsModel);
                     }
                 }
                 viewPagerproduct=new ViewPagerproduct(searchmodel,MainActivity.this);
                 recyclerView.setAdapter(viewPagerproduct);
             }
         });
         imgaccout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(MainActivity.this,DetailAcoout.class);
                 Bundle bundle=new Bundle();
                 bundle.putSerializable("user",model1);
                 intent.putExtras(bundle);
                 startActivity(intent);
             }
         });
    }

    public void getdata() {
        ApiServices.API_SERVICES.getListProducts().enqueue(new Callback<List<ProductsModel>>() {
            @Override
            public void onResponse(Call<List<ProductsModel>> call, Response<List<ProductsModel>> response) {
                Toast.makeText(MainActivity.this, "Thanh cong", Toast.LENGTH_SHORT).show();
                productsModels = response.body();
                if (productsModels != null) {
                    Log.d("TAG", "onResponse: "+productsModels.get(0).getId_Category().getName());
                    viewPagerproduct=new ViewPagerproduct(productsModels,MainActivity.this);
                    recyclerView.setAdapter(viewPagerproduct);
                } else {
                    Log.d("TAG", "onResponse: " + "Trong");

                }
            }

            @Override
            public void onFailure(Call<List<ProductsModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Faill", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getdata();
    }
}
