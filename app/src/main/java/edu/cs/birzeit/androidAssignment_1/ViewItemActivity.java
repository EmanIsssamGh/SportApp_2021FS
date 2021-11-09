package edu.cs.birzeit.androidAssignment_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ViewItemActivity extends AppCompatActivity {
    TextView ItemName, Price, Rating, ItemsRemaining, Description, Category;
    Item currentItem;
    ImageView image;

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String allItemsJson = prefs.getString("allItems", "");
        Type type = new TypeToken<List<Item>>() {
        }.getType();


        final List<Item> itemsList = gson.fromJson(allItemsJson, type);
        String itemIndexJson = prefs.getString("itemIndex", "");
        currentItem = itemsList.get(Integer.parseInt(itemIndexJson));


        ItemName = findViewById(R.id.itemName);
        Price = findViewById(R.id.price);
        Rating = findViewById(R.id.Rating);
        ItemsRemaining = findViewById(R.id.ItemsRemaining);
        Description = findViewById(R.id.Description);
        Category = findViewById(R.id.Category);
        image = findViewById(R.id.imageView);


        ItemName.setText("Item Name: "+currentItem.getItemName());
        Price.setText("Price: "+currentItem.getPrice()+" ILS");
        Rating.setText("Rating: "+currentItem.getRating());
        ItemsRemaining.setText("Items Remaining: "+currentItem.getItemName());
        Description.setText("Description: "+currentItem.getDescription());
        Category.setText("Category: "+currentItem.getCategory());
        image.setImageResource(currentItem.getImage());
    }

    public void addToCart_OnClick(View view) {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String allCartItems = prefs.getString("allCartItems", "");
        Type type = new TypeToken<List<Item>>() {
        }.getType();

        List<Item> itemsList = gson.fromJson(allCartItems, type);


        if(itemsList!=null){
            itemsList.add(currentItem);

        }else {
            itemsList= new ArrayList<>();
            itemsList.add(currentItem);

        }
        System.out.println(itemsList+"LIST");
        Toast.makeText(getApplicationContext(), "item " + "added to cart", Toast.LENGTH_SHORT).show();
//

        prefs=PreferenceManager.getDefaultSharedPreferences(ViewItemActivity.this);
        editor= prefs.edit();
        String items = gson.toJson(itemsList);
        editor.putString("allCartItems", items);
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_ui,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.item1) {
            Intent displayDataIntent = new Intent(ViewItemActivity.this, Cart.class);

            startActivity(displayDataIntent);
        }
        return super.onOptionsItemSelected(item);
    }

}