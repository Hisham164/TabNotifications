package com.example.tabnotification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager2 viewPager2 =findViewById(R.id.viewPager);
        viewPager2.setAdapter(new GPPagerAdaper(this));

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position){
                    case 0: {
                        tab.setText("Résumé");
                        tab.setIcon(R.drawable.ic_pending);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary)
                        );
                        badgeDrawable.setVisible(true);
                        break;
                    }
                    case 1: {
                        tab.setText("Company");
                        tab.setIcon(R.drawable.ic_company);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary)
                        );
                        badgeDrawable.setNumber(8);
                        badgeDrawable.setVisible(true);
                        break;
                    }
                    case 2: {
                        tab.setText("Scholars");
                        tab.setIcon(R.drawable.ic_scholar);
                        BadgeDrawable badgeDrawable =tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary)
                        );
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(100);
                        badgeDrawable.setMaxCharacterCount(3);
                        break;
                    }
                }

            }
        }
        );
        tabLayoutMediator.attach();

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                BadgeDrawable badgeDrawable = tabLayout.getTabAt(position).getOrCreateBadge();
                badgeDrawable.setVisible(false);
            }
        });
    }
}