package com.project.homework4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CountriesActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        toolbar = findViewById(R.id.toolbar_countries);
        tabLayout = findViewById(R.id.tab_layout_countries);
        viewPager = findViewById(R.id.view_pager_countries);

        // Thiết lập Toolbar
        setSupportActionBar(toolbar);

        // Khởi tạo Adapter
        adapter = new ViewPagerAdapter(this);

        // Thêm các Fragment vào Adapter
        addFragmentsToAdapter();

        // Gán Adapter cho ViewPager
        viewPager.setAdapter(adapter);

        // Kết nối TabLayout với ViewPager2
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(adapter.getPageTitle(position))
        ).attach();
    }

    private void addFragmentsToAdapter() {
        // Tạo dữ liệu cho từng quốc gia từ strings.xml
        // 1. United Kingdom
        String ukDetails = "Capital: " + getString(R.string.uk_capital) +
                "\nLargest City: " + getString(R.string.uk_capital) +
                "\nNational Language: " + getString(R.string.uk_language) +
                "\nTotal Area: " + getString(R.string.uk_area) +
                "\nCurrency: " + getString(R.string.uk_currency);
        adapter.addFragment(
                InfoFragment.newInstance(R.drawable.uk_flag, ukDetails, getString(R.string.uk_description)),
                getString(R.string.uk_title)
        );

        // 2. France
        String franceDetails = "Capital: " + getString(R.string.france_capital) +
                "\nNational Language: " + getString(R.string.france_language) +
                "\nTotal Area: " + getString(R.string.france_area) +
                "\nCurrency: " + getString(R.string.france_currency);
        adapter.addFragment(
                InfoFragment.newInstance(R.drawable.france_flag, franceDetails, getString(R.string.france_description)),
                getString(R.string.france_title)
        );

        // 3. Italy
        String italyDetails = "Capital: " + getString(R.string.italy_capital) +
                "\nNational Language: " + getString(R.string.italy_language) +
                "\nTotal Area: " + getString(R.string.italy_area) +
                "\nCurrency: " + getString(R.string.italy_currency);
        adapter.addFragment(
                InfoFragment.newInstance(R.drawable.italy_flag, italyDetails, getString(R.string.italy_description)),
                getString(R.string.italy_title)
        );
    }
}