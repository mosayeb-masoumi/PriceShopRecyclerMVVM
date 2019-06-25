package com.example.priceshoprecyclermvvm.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.priceshoprecyclermvvm.App;
import com.example.priceshoprecyclermvvm.R;
import com.example.priceshoprecyclermvvm.databinding.ActivityMainBinding;
import com.example.priceshoprecyclermvvm.model.Totality;
import com.example.priceshoprecyclermvvm.viewmodel.PriceViewModel;

import static com.example.priceshoprecyclermvvm.viewmodel.PriceViewModel.priceViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        PriceViewModel priceViewModel = new PriceViewModel(this);
        mainBinding.setViewmodel(priceViewModel);



        mainBinding.setTotality(PriceViewModel.getPriceViewModel());

    }
}
