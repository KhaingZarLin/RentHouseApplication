package com.example.renthouseapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.renthouseapplication.data.vos.RentVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RentDetailActivity extends BaseActivity {

    public static final String Rent_EXTRA_ID="rentID";

    public static Intent newIntent(Context context, int hotelIdExtra){
        Intent intent = new Intent(context, RentDetailActivity.class);
        intent.putExtra(Rent_EXTRA_ID, hotelIdExtra);
        return intent;
    }


    @BindView(R.id.dollar)
    TextView price;

    @BindView(R.id.txt_location)
    TextView address;

    @BindView(R.id.txt_sqft)
    TextView square;

    @BindView(R.id.txt_roomno)
    TextView name;

    @BindView(R.id.txt_detail)
    TextView detail_dev;

    @BindView(R.id.map_fab)
    FloatingActionButton map_fb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_detail);

        ButterKnife.bind(this);

        ImageView back_iv = findViewById(R.id.back);
        back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final int rentID = getIntent().getIntExtra(Rent_EXTRA_ID, 0);

        final RentVO rentVO = rentModel.findRentById(rentID);
        bindData(rentVO);

        map_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  lattitude = String.valueOf(rentVO.getLattitude());
                String  longitude = String.valueOf(rentVO.getLongitude());
                String openInMapPrefix = "google.navigation:q=" + lattitude + "," + longitude;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(openInMapPrefix));
                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });
    }
    private void bindData(RentVO rentVO){

        price.setText("$"+String.valueOf(rentVO.getPrice()));
        address.setText(rentVO.getAddress());
        square.setText(String.valueOf(rentVO.getSquare_feet()));
        name.setText(rentVO.getName());
        detail_dev.setText(rentVO.getDescription());
    }
}
