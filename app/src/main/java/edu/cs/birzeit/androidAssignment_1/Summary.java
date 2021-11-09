package edu.cs.birzeit.androidAssignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Summary extends AppCompatActivity {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Gson gson = new Gson();

    String items="Items:";
    int price=0;
    double tax=0.14;
    int totalPrice=0;

    TextView Items, Price, Tax, TotalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String allCartItems = prefs.getString("allCartItems", "");
        Type type = new TypeToken<List<Item>>() {
        }.getType();

        List<Item> itemsList = gson.fromJson(allCartItems, type);

        Items = findViewById(R.id.allItems);
        Price = findViewById(R.id.price);
        Tax = findViewById(R.id.tax);
        TotalPrice = findViewById(R.id.totalPrice);

        for(int i=0;i<itemsList.size();i++){
            System.out.println(itemsList.get(i).getItemName() +"FINAL NAME");
            System.out.println(itemsList.get(i).getItemName()+"ADDED");

            if(!(i==itemsList.size()-1)){
                items=items+" "+itemsList.get(i).getItemName() +",";
            }else {
                items=items+" "+itemsList.get(i).getItemName() ;

            }

            price=price+itemsList.get(i).getPrice();
        }
        System.out.println(price+"price");
//
        Items.setText(items);
        Price.setText("Price: "+price+" ILS");
        Tax.setText("Total Tax Added: "+(int)(tax*price)+" ILS");
        int  finalValue= (int) ((tax*price)+price);
        TotalPrice.setText("Total Price: "+finalValue+" ILS");
        System.out.println(totalPrice+"PRICE");
    }

}