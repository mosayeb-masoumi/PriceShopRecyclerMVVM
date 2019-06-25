package com.example.priceshoprecyclermvvm.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.priceshoprecyclermvvm.App;
import com.example.priceshoprecyclermvvm.BR;
import com.example.priceshoprecyclermvvm.model.PriceModel;
import com.example.priceshoprecyclermvvm.model.Totality;
import com.example.priceshoprecyclermvvm.second_activity.SecondActivity;
import com.example.priceshoprecyclermvvm.view.Adapter;

import java.util.ArrayList;

public class PriceViewModel extends BaseObservable {

    ArrayList<PriceViewModel> arrayList = new ArrayList<>();

//    ArrayList<Totality> totalityArrayList = new ArrayList<>();


    int total;

    private int fixed_price;
    private int unit_price;
    private int total_price;


    private int all_totalPrice;
    private int all_unit_price;

    Context context;


    public PriceViewModel(PriceModel priceModel) {
        this.fixed_price = priceModel.getFixed_price();
        this.unit_price = priceModel.getUnit_price();
        this.total_price = priceModel.getTotal_price();
    }


    public PriceViewModel(Totality totality) {
        this.all_totalPrice = totality.getAll_totalPrice();
        this.all_unit_price = totality.getAll_unit_price();

//        this.all_totalPrice = getAll_totalPrice();
//        this.all_unit_price = getAll_unit_price();

    }

    //to send data to next activity
    public static PriceViewModel priceViewModel;


    public PriceViewModel(Context context) {
        this.context = context;
        //dasty
        for (int i = 0; i < 10; i++) {
            PriceModel priceModel = new PriceModel();
            PriceViewModel priceViewModel = new PriceViewModel(priceModel);
            arrayList.add(priceViewModel);

        }


        int totalPrice = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            totalPrice += arrayList.get(i2).getTotal_price();
            int a = totalPrice;
        }

    }


    @BindingAdapter("bind:recyclerPrice")
    public static void recyclerViewBindingAdapter(final RecyclerView recyclerView, ArrayList<PriceViewModel> arrayList) {
        Adapter adapter = new Adapter(arrayList, recyclerView.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

    }


    public void btnNextClicked() {
        context.startActivity(new Intent(context, SecondActivity.class));
    }

    @Bindable
    public int getFixed_price() {
        return fixed_price;
    }

    public void setFixed_price(int fixed_price) {
        this.fixed_price = fixed_price;
        notifyPropertyChanged(BR.fixed_price);
    }

    @Bindable
    public int getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(int unit_price) {
        this.unit_price = unit_price;
        notifyPropertyChanged(BR.unit_price);
    }

    @Bindable
    public int getTotal_price() {
        return total_price;
    }


    public void setTotal_price(int total_price) {
        this.total_price = total_price;
        notifyPropertyChanged(BR.total_price);
    }

    @Bindable
    public ArrayList<PriceViewModel> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<PriceViewModel> arrayList) {
        this.arrayList = arrayList;
        notifyPropertyChanged(BR.arrayList);
    }

    //to send data to next activity
    public static PriceViewModel getPriceViewModel() {
        return priceViewModel;
    }


    //////////////////////related to Totality model
    @Bindable
    public int getAll_totalPrice() {
        return all_totalPrice;
    }

    public void setAll_totalPrice(int all_totalPrice) {
        this.all_totalPrice = all_totalPrice;
        notifyPropertyChanged(BR.all_totalPrice);
    }

    @Bindable
    public int getAll_unit_price() {
        return all_unit_price;
    }

    public void setAll_unit_price(int all_unit_price) {
        this.all_unit_price = all_unit_price;
        notifyPropertyChanged(BR.all_unit_price);
    }


    int unit = 0;

    public void addBtnPressed() {
//        Toast.makeText(context, "fff", Toast.LENGTH_SHORT).show();
        unit++;
        setUnit_price(unit);
        total = getUnit_price() * 1500;
        setTotal_price(total);
//        int c = getTotal_price();


        App.total_unit = +App.total_unit + 1;
        App.total_price = App.total_unit * getFixed_price();


        // set kardim total_unit va total price ra darune model Totality

        setAll_totalPrice(App.total_price);
        setAll_unit_price(App.total_unit);


        //   ******************important******************
        // por kardan priceViewModel ba this (nabayad anra dar    public PriceViewModel(Context context) {priceViewModel=this;} por konim)
        //to send data to next activity
        priceViewModel = this;

    }

    public void btnMinusPressed() {
        if (unit == 0) {
            unit = 0;
        } else {
            unit--;
        }
        setUnit_price(unit);
        total = getUnit_price() * 1500;
        setTotal_price(total);


        if (App.total_unit > 0)
            App.total_unit = +App.total_unit - 1;
        else
            App.total_unit = +App.total_unit;


        App.total_price = App.total_unit * getFixed_price();


        // set kardim total_unit va total price ra darune model Totality

        setAll_totalPrice(App.total_price);
        setAll_unit_price(App.total_unit);

        //   ******************important******************
        // por kardan priceViewModel ba this (nabayad anra dar    public PriceViewModel(Context context) {priceViewModel=this;} por konim)
        //to send data to next activity

        
        priceViewModel = this;

    }

}
