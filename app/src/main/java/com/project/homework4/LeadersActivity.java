package com.project.homework4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class LeadersActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaders);

        toolbar = findViewById(R.id.toolbar_leaders);
        tabLayout = findViewById(R.id.tab_layout_leaders);
        viewPager = findViewById(R.id.view_pager_leaders);

        setSupportActionBar(toolbar);

        adapter = new ViewPagerAdapter(this);
        addFragmentsToAdapter();

        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(adapter.getPageTitle(position))
        ).attach();
    }

    private void addFragmentsToAdapter() {
        // Tab 1: Winston Churchill
        adapter.addFragment(
                InfoFragment.newInstance(
                        R.drawable.winston_churchill,
                        getString(R.string.leader_churchill_details),
                        getString(R.string.leader_churchill_description)
                ),
                getString(R.string.leader_churchill_title)
        );

        // Tab 2: Mahatma Gandhi
        adapter.addFragment(
                InfoFragment.newInstance(
                        R.drawable.mahatma_gandhi,
                        getString(R.string.leader_gandhi_details),
                        getString(R.string.leader_gandhi_description)
                ),
                getString(R.string.leader_gandhi_title)
        );

        // Tab 3: Barack Obama
        adapter.addFragment(
                InfoFragment.newInstance(
                        R.drawable.barack_obama,
                        getString(R.string.leader_obama_details),
                        getString(R.string.leader_obama_description)
                ),
                getString(R.string.leader_obama_title)
        );
    }
}