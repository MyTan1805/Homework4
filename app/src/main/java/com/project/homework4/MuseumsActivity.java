package com.project.homework4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MuseumsActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museums);

        toolbar = findViewById(R.id.toolbar_museums);
        tabLayout = findViewById(R.id.tab_layout_museums);
        viewPager = findViewById(R.id.view_pager_museums);

        setSupportActionBar(toolbar);

        adapter = new ViewPagerAdapter(this);
        addFragmentsToAdapter();

        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(adapter.getPageTitle(position))
        ).attach();
    }

    private void addFragmentsToAdapter() {
        // Tab 1: The Louvre
        adapter.addFragment(
                InfoFragment.newInstance(
                        R.drawable.louvre_museum,
                        getString(R.string.museum_louvre_details),
                        getString(R.string.museum_louvre_description)
                ),
                getString(R.string.museum_louvre_title)
        );

        // Tab 2: The British Museum
        adapter.addFragment(
                InfoFragment.newInstance(
                        R.drawable.british_museum,
                        getString(R.string.museum_british_details),
                        getString(R.string.museum_british_description)
                ),
                getString(R.string.museum_british_title)
        );

        // Tab 3: The Met
        adapter.addFragment(
                InfoFragment.newInstance(
                        R.drawable.met_museum,
                        getString(R.string.museum_met_details),
                        getString(R.string.museum_met_description)
                ),
                getString(R.string.museum_met_title)
        );
    }
}