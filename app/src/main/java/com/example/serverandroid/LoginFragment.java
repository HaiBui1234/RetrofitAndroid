package com.example.serverandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.serverandroid.API.ApiServices;
import com.example.serverandroid.Model.UsersModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {
    private List<UsersModel> usersModels;
    Button btn_Login;
    UsersModel us;
    EditText edtUsersName,edtPasswoed;
    public LoginFragment() {
        // Required empty public constructor
    }
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_Login=view.findViewById(R.id.btn_Login);
        edtPasswoed=view.findViewById(R.id.id_PaswordL);
        edtUsersName=view.findViewById(R.id.id_UserNameL);
        usersModels=new ArrayList<>();
        getdataUser();
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CHeckLogin();

            }


        });

    }
    public void getdataUser(){
        ApiServices.API_SERVICES.getListUser().enqueue(new Callback<List<UsersModel>>() {
            @Override
            public void onResponse(Call<List<UsersModel>> call, Response<List<UsersModel>> response) {
                usersModels=response.body();
                Log.d("TAG", "onResponse: "+usersModels.size());
            }

            @Override
            public void onFailure(Call<List<UsersModel>> call, Throwable t) {

            }
        });
    }
    private void CHeckLogin() {
        String Username=edtUsersName.getText().toString().trim();
        String Pass=edtPasswoed.getText().toString().trim();
        boolean ischeck=false;

        for (UsersModel usersModel:usersModels) {
        if (usersModel.getUsername().equals(Username)&&usersModel.getPassWord().equals(Pass)&&usersModel.getRole().equals("user")){
            ischeck=true;
            us=usersModel;
            break;
        }
        }
        if (ischeck){
            Intent intent=new Intent(getActivity(),MainActivity.class);
            Bundle bundle=new Bundle();
            bundle.putSerializable("user",us);
            intent.putExtras(bundle);
            getActivity().startActivity(intent);
        }else {
            Toast.makeText(getActivity(), "Kiểm tra lại thông tin", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        getdataUser();
    }
}