package com.example.renthouseapplication.view.holder;

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



    public TopCollectionViewHolder(View itemView, final FragmentDelegateOne delegateOne) {
        super(itemView);
        fragmentDelegateOne=delegateOne;

        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegateOne.onTapDElegate();
            }
        });
    }


    @Override
    public void bindData(RentVO mData) {
        rate.setText(String.valueOf(mData.getPrice()));
        hottelnaem.setText(mData.getName());
        square.setText(String.valueOf(mData.getSquare_feet()));
        Glide.with(itemView).load(mData.getImage()).into(imageView);
    }
}
