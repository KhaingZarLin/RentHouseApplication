package com.example.renthouseapplication.view.holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.renthouseapplication.R;
import com.example.renthouseapplication.data.vos.RentVO;
import com.example.renthouseapplication.delegate.FragmentDelegateOne;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopCollectionViewHolder extends BaseViewHolder<RentVO>  {
    private FragmentDelegateOne fragmentDelegateOne;
    public Context context;

    @BindView(R.id.imageView)
    ImageView imageView;

    @BindView(R.id.txtrate)
    TextView rate;

    @BindView(R.id.hotelname)
    TextView hottelnaem;

    @BindView(R.id.bedno)
    TextView bednumber;

    @BindView(R.id.square)
    TextView square;



    public TopCollectionViewHolder(@NonNull View itemView,FragmentDelegateOne delegateOne) {
        super(itemView);

        ButterKnife.bind(this,itemView);
        fragmentDelegateOne=delegateOne;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentDelegateOne.onTapDElegate(mData.getId());
            }
        });
    }

    @Override
    public void bindData(RentVO data) {
        mData=data;
        rate.setText("$"+String.valueOf(data.getPrice()));
        hottelnaem.setText(data.getName());
        square.setText(String.valueOf(data.getSquare_feet()));
        Glide.with(itemView).load(data.getImage()).into(imageView);
    }
}
