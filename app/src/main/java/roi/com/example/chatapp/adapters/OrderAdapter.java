package roi.com.example.chatapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import roi.com.example.chatapp.R;
import roi.com.example.chatapp.activities.ProductDetails;
import roi.com.example.chatapp.models.OrderModel;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.itemsViewHolder> {

    Context context;
    List<OrderModel> itemList;

    public OrderAdapter(Context context, List<OrderModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public itemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items, parent, false);

        return new itemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemsViewHolder holder, final int position) {

        holder.bg.setBackgroundResource(itemList.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(context, ProductDetails.class);
                i.putExtra("name", itemList.get(position).getName());
                i.putExtra("image", itemList.get(position).getBigimageurl());
                i.putExtra("price", itemList.get(position).getPrice());
                i.putExtra("desc", itemList.get(position).getDescription());
                i.putExtra("qty", itemList.get(position).getQuantity());
                i.putExtra("unit", itemList.get(position).getUnit());

                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public  static class itemsViewHolder extends RecyclerView.ViewHolder{

        TextView name, description, price, qty, unit;
        ConstraintLayout bg;

        public itemsViewHolder(@NonNull View itemView) {
            super(itemView);

            bg = itemView.findViewById(R.id.item_layout);

        }
    }
}
