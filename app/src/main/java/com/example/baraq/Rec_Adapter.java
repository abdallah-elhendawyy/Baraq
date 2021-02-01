package com.example.baraq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Rec_Adapter extends RecyclerView.Adapter <Rec_Adapter.vovo>{
        ArrayList<book_Model>arrayList=new ArrayList<>();
        oncolick_inter onclocko;


    public Rec_Adapter(ArrayList<book_Model> arrayList, oncolick_inter onclocko) {
        this.arrayList = arrayList;
        this.onclocko = onclocko;
    }

    @NonNull
    @Override
    public vovo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom,null);

        return new vovo(v,onclocko);
    }

    @Override
    public void onBindViewHolder(@NonNull vovo holder, int position) {
        book_Model b=arrayList.get(position);
        holder.textView.setText(b.getPuplsher_name());
        Picasso.get().load(b.getImage_url()).fit().centerInside().into(holder.imageView);

        ////////////////
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }







    class vovo extends RecyclerView.ViewHolder  {
        ImageView imageView;
        TextView textView;
        public vovo(@NonNull View itemView,oncolick_inter onclocko) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView0);
            textView=itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onclocko.onitemclickme(getAdapterPosition());
                }
            });
        }


    }








}
