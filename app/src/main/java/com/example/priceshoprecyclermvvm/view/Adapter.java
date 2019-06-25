package com.example.priceshoprecyclermvvm.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.priceshoprecyclermvvm.R;
import com.example.priceshoprecyclermvvm.databinding.ItemPriceBinding;
import com.example.priceshoprecyclermvvm.viewmodel.PriceViewModel;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<PriceViewModel> arrayList;
    Context context;
    private LayoutInflater layoutInflater;

    public Adapter(ArrayList<PriceViewModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        if(layoutInflater == null)
            layoutInflater = LayoutInflater.from(parent.getContext());

        ItemPriceBinding userBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item , parent,false);
        return  new ViewHolder(userBinding);
    }


    int total = 0;

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        PriceViewModel priceViewModel = arrayList.get(position);
        holder.bind(priceViewModel);

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemPriceBinding itemPriceBinding;
        public ViewHolder(ItemPriceBinding itemPriceBinding) {
            super(itemPriceBinding.getRoot());
            this.itemPriceBinding=itemPriceBinding;
        }

        private void bind(PriceViewModel priceViewModel){
            this.itemPriceBinding.setItem(priceViewModel);
            this.itemPriceBinding.executePendingBindings();
        }

        public ItemPriceBinding getItemPriceBinding() {
            return itemPriceBinding;
        }
    }
}
