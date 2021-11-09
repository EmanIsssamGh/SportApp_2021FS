package edu.cs.birzeit.androidAssignment_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Cart extends AppCompatActivity {
    RecyclerViewCartAdapter recyclerviewItemAdapter;
    RecyclerView recyclerView;


    List<Item> list ;


    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
//        itemsArray[0] = new Item("Nike Sport Bag", 120, "4.5", "3", "NIKE VARSITY GIRL MEDIUM BAG", "Bags", R.drawable.img1);
//        itemsArray[1] = new Item("Puma Water Bottle", 30, "3", "1", "Puma Unisex Sports Water Bottle Water Bottle Workout Sport Classic", "Water Bottles", R.drawable.img2);
//        itemsArray[2] = new Item("Dumbbells", 60, "4", "6", "Yoga Mad Pair of 3Kg Neo Dumbbells - Orange", "Dumbbells", R.drawable.img3);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String allCartItems = prefs.getString("allCartItems", "");
        Type type = new TypeToken<List<Item>>() {
        }.getType();

        list= gson.fromJson(allCartItems, type);


        if(list!=null){
            prepareItems();

        }



    }





    private void prepareItems() {

        recyclerviewItemAdapter = new RecyclerViewCartAdapter(list);
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerviewItemAdapter);


    }


    public void Checkout(View view) {
        if(list!=null){
            Intent displayDataIntent = new Intent(Cart.this, Summary.class);
            startActivity(displayDataIntent);
        }else{
            Toast.makeText(getApplicationContext(),"Your cart is empty",Toast.LENGTH_SHORT).show();

        }

    }
}