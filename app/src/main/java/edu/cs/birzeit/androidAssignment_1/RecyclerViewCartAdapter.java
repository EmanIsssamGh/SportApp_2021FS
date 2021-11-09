package edu.cs.birzeit.androidAssignment_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewCartAdapter extends RecyclerView.Adapter<RecyclerViewCartAdapter.MyViewHolder> {

    private List<Item> studentsList;

    RecyclerViewCartAdapter(List<Item> item){
        this.studentsList = item;
    }

    @Override
    public RecyclerViewCartAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewCartAdapter.MyViewHolder holder, final int position) {
        final Item item = studentsList.get(position);
        holder.itemName.setText(("Item Name: "+item.getItemName()));
        holder.price.setText(("Price: "+item.getPrice()+" ILS"));
        holder.rating.setText(("Rating: "+item.getRating()));

        holder.description.setText(("Description: "+item.getDescription()));
        holder.category.setText(("Category: "+item.getCategory()));


        holder.image.setImageResource(item.getImage());


    }


    @Override
    public int getItemCount() {
        return studentsList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
//        private String ItemName;
//        private int Price ;
//        private String Rating;
//        private String ItemsRemaining;
//        private String Description;
//        private String Category;
//        private int Image;

        public TextView itemName,price,rating,itemsRemaining,description,category;
        private LinearLayout itemLayout;
        public ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.itemName);
            price = itemView.findViewById(R.id.price);
            rating = itemView.findViewById(R.id.rating);

            description = itemView.findViewById(R.id.description);
            category = itemView.findViewById(R.id.category);



            image=itemView.findViewById(R.id.itemPhoto);
            itemLayout =  itemView.findViewById(R.id.itemLayout);


        }

//        @Override
//        public void onClick(View view) {
//
//            listener.onClick(view,getAdapterPosition());
//        }
    }
}