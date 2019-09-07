package com.example.renthouseapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.renthouseapplication.adapter.TopCollectionAdapter;
import com.example.renthouseapplication.data.models.RentModel;
import com.example.renthouseapplication.data.vos.RentVO;
import com.example.renthouseapplication.fragment.ForUFragment;
import com.example.renthouseapplication.fragment.TopCollectionFragment;

import java.util.List;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.btn_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navlister);
        goToFragment(new ForUFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlister = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.foru:
                    goToFragment(new ForUFragment());
                    break;
                case R.id.map:
                    goToFragment(new ForUFragment());
                    break;
                case R.id.fav:
                    goToFragment(new ForUFragment());
                    break;
                case R.id.drop:
                    goToFragment(new ForUFragment());
                    break;
                case R.id.profile:
                    goToFragment(new ForUFragment());
                    break;

            }
            return false;
        }
    };

    private void goToFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, fragment).commit();
    }



} /*public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu, menu);
    MenuItem searchViewItem = menu.findItem(R.id.app_bar_search);
    SearchView searchView = (SearchView) searchViewItem.getActionView();
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String s) {
            adapter.getFilter().filter(s);
            return false;
        }

        @Override
        public boolean onQueryTextChange(String s) {
            return false;
        }
    });*/

