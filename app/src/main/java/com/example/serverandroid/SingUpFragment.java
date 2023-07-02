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

public class SingUpFragment extends Fragment {
    private EditText edUserName, edPassWord, edEmail, edAvatar;
    private Button btnSignUp;

    public SingUpFragment() {
        // Required empty public constructor
    }

    public static SingUpFragment newInstance(String param1, String param2) {
        SingUpFragment fragment = new SingUpFragment();
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
        return inflater.inflate(R.layout.fragment_sing_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edUserName = view.findViewById(R.id.id_UserName);
        edPassWord = view.findViewById(R.id.id_PassWord);
        edEmail = view.findViewById(R.id.id_Email);
        btnSignUp = view.findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });


    }

    public void Register() {
        String username=edUserName.getText().toString();
        String Email =edEmail.getText().toString();
        String PassWord=edPassWord.getText().toString();
        UsersModel model=new UsersModel(username,Email,PassWord,"user",false);
        ApiServices.API_SERVICES.PostUser(model).enqueue(new Callback<UsersModel>() {
            @Override
            public void onResponse(Call<UsersModel> call, Response<UsersModel> response) {
                Toast.makeText(getActivity(), "Thanh Cong", Toast.LENGTH_SHORT).show();
                getActivity().startActivity(new Intent(getActivity(),MainActivity.class));
            }
            @Override
            public void onFailure(Call<UsersModel> call, Throwable t) {
                Toast.makeText(getActivity(), "Thanh cong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}