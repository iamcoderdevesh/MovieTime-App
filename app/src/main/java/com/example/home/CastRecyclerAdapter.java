package com.example.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Objects;


public class CastRecyclerAdapter extends RecyclerView.Adapter<CastRecyclerAdapter.ViewHolder> {
    Context context;
    ArrayList<CastRecycler> arrCast;

    CastRecyclerAdapter(Context context, ArrayList<CastRecycler> arrCast){
        this.context= context;
        this.arrCast = arrCast;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.cast_crew_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        Log.d("movie", "viewholder success: ");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(!Objects.equals(arrCast.get(position).cImg, "Image not available")) {
            Glide.with(context)
                    .load(arrCast.get(position).cImg)
                    .placeholder(R.drawable.no_user_img)
                    .into(holder.castimg);

            Log.d("movie", "Cast glide img success: ");
        }else{
            holder.castimg.setBackgroundResource(R.drawable.no_user_img);
        }
        holder.castname.setText(arrCast.get(position).cName);
        Log.d("movie", "Cast name success: ");
        holder.castrole.setText(arrCast.get(position).cRole);
        Log.d("movie", "Cast role success: ");
    }

    @Override
    public int getItemCount() {
        return arrCast.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView castimg;
        TextView castname, castrole;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            castimg = itemView.findViewById(R.id.charImg);
            castname = itemView.findViewById(R.id.charName);
            castrole = itemView.findViewById(R.id.charRole);
        }
    }
}

