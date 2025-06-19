package com.project.homework4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WondersActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wonders);

        toolbar = findViewById(R.id.toolbar_wonders);
        tabLayout = findViewById(R.id.tab_layout_wonders);
        viewPager = findViewById(R.id.view_pager_wonders);

        setSupportActionBar(toolbar);

        adapter = new ViewPagerAdapter(this);
        addFragmentsToAdapter();

        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(adapter.getPageTitle(position))
        ).attach();
    }

    private void addFragmentsToAdapter() {
        // Tab 1: The Colosseum
        adapter.addFragment(
                InfoFragment.newInstance(
                        R.drawable.flavian_amphitheatre,
                        getString(R.string.wonder_colosseum_details),
                        getString(R.string.wonder_colosseum_description)
                ),
                getString(R.string.wonder_colosseum_title)
        );

        // Tab 2: The Taj Mahal
        adapter.addFragment(
                InfoFragment.newInstance(
                        R.drawable.the_taj_mahal,
                        getString(R.string.wonder_taj_mahal_details),
                        getString(R.string.wonder_taj_mahal_description)
                ),
                getString(R.string.wonder_taj_mahal_title)
        );

        // Tab 3: Great Wall of China
        adapter.addFragment(
                InfoFragment.newInstance(
                        R.drawable.great_wall_of_china,
                        getString(R.string.wonder_great_wall_details),
                        getString(R.string.wonder_great_wall_description)
                ),
                getString(R.string.wonder_great_wall_title)
        );
    }
}