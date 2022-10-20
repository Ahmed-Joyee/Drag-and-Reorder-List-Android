package app.android.drag_and_reorder_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements DragListener {

    RecyclerView recyclerView;
    RVAdapter Adapter;
    ArrayList<String> stringArrayList = new ArrayList<>();
    ItemTouchHelper touchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        Adapter = new RVAdapter(stringArrayList,this);

        ItemTouchHelper.Callback callback =
                new MoveItemCallback(Adapter);
        touchHelper  = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        recyclerView.setAdapter(Adapter);
    }

    @Override
    public void requestDrag(RecyclerView.ViewHolder viewHolder) {
        touchHelper.startDrag(viewHolder);
    }
}