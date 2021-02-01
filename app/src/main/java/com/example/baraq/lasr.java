package com.example.baraq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

public class lasr extends AppCompatActivity {
Data_base_sql dataBaseSql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lasr);
        Toolbar toolbar=findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        dataBaseSql=new Data_base_sql(this);
        FloatingActionButton button=findViewById(R.id.fb);
        TextView textView=findViewById(R.id.toxo);
        AppCompatImageView imageView1=findViewById(R.id.imm);
        book_Model b= getIntent().getParcelableExtra("oo");
        String image_url=b.getImage_url();
        String decription=b.getDecription();
        Picasso.get().load(b.getImage_url()).fit().centerCrop().into(imageView1);
        textView.setText(decription);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (dataBaseSql.insert(b)){
                   Toast.makeText(lasr.this,"added to fav",Toast.LENGTH_LONG).show();

               }else Toast.makeText(lasr.this,"faild",Toast.LENGTH_LONG).show();


            }
        });





    }
}