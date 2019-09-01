package com.example.renthouseapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.renthouseapplication.adapter.TabPagerAdapter;
import com.example.renthouseapplication.fragment.TopCollectionFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout=findViewById(R.id.tab);
//        ViewPager viewPager=findViewById(R.id.fragmentcontainer);
//        TabPagerAdapter tabPagerAdapter=new TabPagerAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(tabPagerAdapter);
//        tabLayout.setupWithViewPager(viewPager);


        BottomNavigationView bottomNavigationView=findViewById(R.id.btn_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navlister);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer,new TopCollectionFragment()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navlister=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment=null;
            switch (menuItem.getItemId())
            {
                case R.id.foru:
                    selectedFragment=new TopCollectionFragment();
                    break;
                case R.id.map:
                    selectedFragment=new TopCollectionFragment();
                    break;
                case R.id.fav:
                    selectedFragment=new TopCollectionFragment();
                    break;
                case R.id.drop:
                    selectedFragment=new TopCollectionFragment();
                    break;
                case R.id.profile:
                    selectedFragment=new TopCollectionFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer,selectedFragment).commit();
            return true;
        }
    };
}

