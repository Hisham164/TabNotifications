package com.example.tabnotification;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class GPPagerAdaper extends FragmentStateAdapter {
    public GPPagerAdaper(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ResumeFragment();
            case 1:
                return new CompanyFragment();
            default:
                return new ScholarFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
