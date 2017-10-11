package com.example.user1.socialappaut;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tvItemName;
    public ImageView imgItem;
    public TextView tvPrice;

    private ItemClickListener itemClickListener;

    public MenuViewHolder(View itemView){
        super(itemView);

        imgItem = (ImageView) itemView.findViewById(R.id.item_image);
        tvItemName = (TextView) itemView.findViewById(R.id.tvGetItemDescription);
        tvPrice = (TextView) itemView.findViewById(R.id.tvGetPrice);

    }

    //setItemClickListener Constructor
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void onClick(View view){

        itemClickListener.onClick(view,getAdapterPosition(),false);
    }


}
