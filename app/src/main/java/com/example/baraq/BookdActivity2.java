package com.example.baraq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

public class BookdActivity2 extends AppCompatActivity implements oncolick_inter {
    ArrayList<book_Model>arrayList;
    Rec_Adapter adapter;
    RecyclerView recyclerView;
    RequestQueue requestQueue;
    private static final String url_sport="https://run.mocky.io/v3/f393cb45-4081-4e33-a45e-c2966a90f2f8";
    private static final String url_love="https://run.mocky.io/v3/a1f58cce-5dc9-44e7-a5a8-1daa0824250e";
    private static final String url_live="https://run.mocky.io/v3/b5adf54a-9e8a-47eb-a055-7ba3249aae9c";
    private static final String url_time="https://run.mocky.io/v3/e36cc68e-5e78-4f11-950b-fc6570bc5d03";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookd2);
        GridLayoutManager lm=new GridLayoutManager(BookdActivity2.this,2,RecyclerView.VERTICAL,false);
        recyclerView=findViewById(R.id.rec);
        arrayList=new ArrayList<>();
        requestQueue= Volley.newRequestQueue(BookdActivity2.this);
        adapter=new Rec_Adapter(arrayList,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);
        load_sport();


    }



    private void load_sport(){
    //    String url;

        JsonObjectRequest objectRequest=new JsonObjectRequest(Request.Method.GET, url_sport, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray ja=response.getJSONArray("items");
                    for (int i=0;i<ja.length();i++){
                        JSONObject object=ja.getJSONObject(i);
                        String title= object.getJSONObject("volumeInfo").getString("title");
                        String decription=object.getJSONObject("volumeInfo").getString("description");
                        String  puplsher_name =object.getJSONObject("volumeInfo").getString("publisher");
                       int puplish_date=object.getJSONObject("volumeInfo").getInt("publishedDate");
                        String image_url=object.getJSONObject("volumeInfo").getJSONObject("imageLinks").getString("thumbnail");
                       // int  rating=object.getJSONObject("volumeInfo").getInt("averageRating");
                        arrayList.add(new book_Model(title,image_url,decription,puplsher_name,puplish_date,1));
                        adapter.notifyDataSetChanged();


                    }




                } catch (JSONException e) {
                    Toast.makeText(BookdActivity2.this,"errrrroooorr",Toast.LENGTH_SHORT).show();

                    e.printStackTrace();
                }

            }
        }, error -> Toast.makeText(BookdActivity2.this,"eeerrroorr",Toast.LENGTH_LONG).show());

           requestQueue.add(objectRequest);

    }


    @Override
    public void onitemclickme(int postion) {
       book_Model b= arrayList.get(postion);
        Intent intent=new Intent(this,lasr.class);
        intent.putExtra("oo",b);
        startActivity(intent);
    }
}