package com.example.alibeyk.restaurantbaman;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdapterProdoct extends RecyclerView.Adapter<AdapterProdoct.ViewHolder> {
    private Context context;
    private List<Product> productList;

    public AdapterProdoct(Context context,List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_prodoctlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.BindItem(productList.get(position));

    }

    @Override
    public int getItemCount() {
        return productList.size();

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView prodoctName;
        TextView prodoctPrice;
CardView cardProdoct;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            prodoctName = itemView.findViewById(R.id.prodoct_Name);
            prodoctPrice = itemView.findViewById(R.id.prodoct_Price);
            cardProdoct=itemView.findViewById(R.id.card_prodoct);
        }

        public void BindItem(Product product) {
            prodoctName.setText(product.getName());
            prodoctPrice.setText(product.getPrice());
        }
    }
}
