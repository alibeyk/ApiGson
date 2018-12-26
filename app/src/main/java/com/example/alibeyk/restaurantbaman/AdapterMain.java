package com.example.alibeyk.restaurantbaman;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolder> {
    private Context context;
    private List<Category>categoryList;

    public AdapterMain(Context context, List<Category> categoryList) {
        this.context = context;

        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_card_restaurant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.BindItem(categoryList.get(position));
        holder.cardCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,ProdoctList_Activity.class);
                intent.putExtra("cat",categoryList.get(holder.getAdapterPosition()));
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount()
    {
        return categoryList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

    TextView textCat;
    CardView cardCat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textCat=itemView.findViewById(R.id.text_cat);
            cardCat=itemView.findViewById(R.id.Card_cat);
        }
public void BindItem(Category category){
        textCat.setText(category.getName());

}
    }
}
