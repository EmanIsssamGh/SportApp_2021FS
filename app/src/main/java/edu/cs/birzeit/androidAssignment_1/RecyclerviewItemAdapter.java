package edu.cs.birzeit.androidAssignment_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerviewItemAdapter extends RecyclerView.Adapter<RecyclerviewItemAdapter.MyViewHolder> {

    private final List<Item> studentsList;
    private final ClickListener listener;

    RecyclerviewItemAdapter(List<Item> item,ClickListener listener){
        this.studentsList = item;
        this.listener=listener;
    }

    @Override
    public RecyclerviewItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerviewItemAdapter.MyViewHolder holder, final int position) {
        final Item item = studentsList.get(position);
        holder.itemName.setText(("Item Name: "+item.getItemName()));
        holder.price.setText(("Price: "+ item.getPrice()+" ILS"));
        holder.rating.setText(("Rating:"+ item.getRating()));



        holder.image.setImageResource(item.getImage());


    }


    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public interface ClickListener<T> {

        void onClick(View view, int position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView itemName,price,rating;
        private final LinearLayout itemLayout;
        public ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.itemName);
            price = itemView.findViewById(R.id.price);
            rating = itemView.findViewById(R.id.rating);
            image=itemView.findViewById(R.id.itemPhoto);
            itemLayout =  itemView.findViewById(R.id.itemLayout);

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {

            listener.onClick(view,getAdapterPosition());
        }
    }
}