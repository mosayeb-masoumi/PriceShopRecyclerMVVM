package com.example.priceshoprecyclermvvm.second_activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.priceshoprecyclermvvm.R;
import com.example.priceshoprecyclermvvm.databinding.ActivitySecondBinding;
import com.example.priceshoprecyclermvvm.viewmodel.PriceViewModel;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);

        ActivitySecondBinding secondBinding = DataBindingUtil.setContentView(this,R.layout.activity_second);
        secondBinding.setViewmodel(PriceViewModel.getPriceViewModel());
    }
}
