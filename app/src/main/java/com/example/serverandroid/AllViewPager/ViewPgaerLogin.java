package com.example.serverandroid.AllViewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.serverandroid.LoginFragment;
import com.example.serverandroid.SingUpFragment;

public class ViewPgaerLogin extends FragmentStateAdapter {
    public ViewPgaerLogin(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new LoginFragment();
            case 1:
                return new SingUpFragment();
            default:
                return new LoginFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
