package com.example.user1.socialappaut;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class EventMenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tvEvent;
    public TextView tvDate;
    public TextView tvTime;
    public TextView tvDescription;
    public ImageView eventBackground;
    private ItemClickListener itemClickListener;

    public EventMenuViewHolder(View itemView){
        super(itemView);

        eventBackground = (ImageView) itemView.findViewById(R.id.eventBackground);
        tvEvent = (TextView) itemView.findViewById(R.id.tvEvent);
        tvDate = (TextView) itemView.findViewById(R.id.tvDate);
        tvTime = (TextView) itemView.findViewById(R.id.tvTime);
        tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);

    }

    //setItemClickListener Constructor
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void onClick(View view){

        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
