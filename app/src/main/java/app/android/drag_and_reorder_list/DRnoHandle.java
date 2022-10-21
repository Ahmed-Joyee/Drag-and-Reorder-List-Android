package app.android.drag_and_reorder_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;


public class DRnoHandle extends AppCompatActivity {

    RecyclerView recyclerView;
    RVAdapterWH Adapter;
    ArrayList<String> stringArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recyclerView);

        populateRecyclerView();
    }

    private void populateRecyclerView() {
        stringArrayList.add("Red");
        stringArrayList.add("Orange");
        stringArrayList.add("Yellow");
        stringArrayList.add("Blue");
        stringArrayList.add("Green");
        stringArrayList.add("Indigo");
        stringArrayList.add("Violet");
        stringArrayList.add("Pink");
        stringArrayList.add("Black");
        stringArrayList.add("White");

        Adapter = new RVAdapterWH(stringArrayList);

        ItemTouchHelper.Callback callback =
                new MoveItemCallback1(Adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        recyclerView.setAdapter(Adapter);
    }
}
