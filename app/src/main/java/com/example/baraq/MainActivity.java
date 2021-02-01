package com.example.baraq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView c_sport,c_love,c3_time,c4_live;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c3_time=findViewById(R.id.cardView4);
        c4_live=findViewById(R.id.cardView1);
        c_sport=findViewById(R.id.cardView2);
        c_love=findViewById(R.id.cardView3);
        onclol(c_sport,1);
        onclol(c_love,2);
        onclol(c4_live,3);
        onclol(c3_time,4);





    }



    private void onclol(CardView c,int num){
        Intent intent=new Intent(MainActivity.this,BookdActivity2.class);
        intent.putExtra("num",num);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.munee,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.fav){
            Intent intent=new Intent(MainActivity.this,favourits.class);
            startActivity(intent);
        }
        return true;
    }
}