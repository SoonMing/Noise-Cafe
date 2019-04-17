package com.a0519.willson.test_cafe2.ViewHolder;

import android.content.ClipData;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.a0519.willson.test_cafe2.Interface.ItemClickListener;
import com.a0519.willson.test_cafe2.R;


 /* Created by Willson Leow on 23/11/2017.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtMenuName;
    public ImageView imageView;
    private ItemClickListener itemClickListener;

    public MenuViewHolder(View itemview){
        super(itemview);
        txtMenuName = (TextView)itemview.findViewById(R.id.menu_name);
        imageView = (ImageView)itemview.findViewById(R.id.menu_image);
        itemview.setOnClickListener(this);
    }
    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}
