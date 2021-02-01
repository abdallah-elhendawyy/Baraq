package com.example.baraq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class favourits extends AppCompatActivity implements oncolick_inter {
    RecyclerView recyclerView_fav;
    Rec_Adapter adapter_fav;
    Data_base_sql dataBaseSql=new Data_base_sql(favourits.this);
    ArrayList<book_Model>arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourits);
        GridLayoutManager lm=new GridLayoutManager(favourits.this,2,RecyclerView.VERTICAL,false);
        recyclerView_fav=findViewById(R.id.rorrr);
        arrayList=dataBaseSql.getalldata();
        adapter_fav=new Rec_Adapter(arrayList,this);
        recyclerView_fav.setHasFixedSize(true);
        recyclerView_fav.setLayoutManager(lm);
        recyclerView_fav.setAdapter(adapter_fav);

    }






    @Override
    public void onitemclickme(int postion) {
        book_Model b= arrayList.get(postion);
        Intent intent=new Intent(this,lasr.class);
        intent.putExtra("oo",b);
        startActivity(intent);
    }
}