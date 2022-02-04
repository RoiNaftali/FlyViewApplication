package roi.com.example.chatapp.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import roi.com.example.chatapp.R;
import roi.com.example.chatapp.adapters.OrderAdapter;
import roi.com.example.chatapp.models.OrderModel;

public class OrderActivity extends AppCompatActivity {

    RecyclerView orderRecycler;
    OrderAdapter orderAdapter;
    List<OrderModel> itemList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        orderRecycler = findViewById(R.id.list_item);

        // adding data to model
        itemList = new ArrayList<>();
        itemList.add(new OrderModel("Coca Cola", "Cold Coca Cola Can with glass and ice.", "$ 80", "330", "ML", R.drawable.cola, R.drawable.cola));
        itemList.add(new OrderModel("Hamburger", " Hamburger with tomato and pickle", "$ 15", "350", "gr", R.drawable.ham, R.drawable.ham));
        itemList.add(new OrderModel("Chips", "Plate of chips with sauces", "$ 10", "", "", R.drawable.chips, R.drawable.chips));
        itemList.add(new OrderModel("Beer", "glass of beer", "$ 12", "", "", R.drawable.beer, R.drawable.beer));
        itemList.add(new OrderModel("Pillow", "A pair of pillows", "$ 3", "", "", R.drawable.pillow1, R.drawable.pillow1));

        setOrderRecycler(itemList);

    }

    private void setOrderRecycler(List<OrderModel> orderDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        orderRecycler.setLayoutManager(layoutManager);
        orderAdapter = new OrderAdapter(this,orderDataList);
        orderRecycler.setAdapter(orderAdapter);
    }

}
