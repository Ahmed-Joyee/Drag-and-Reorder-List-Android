package app.android.drag_and_reorder_list;

import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> implements MoveItemCallback.ItemTouchHelperContract {

    private ArrayList<String> data;

    private final DragListener mAdapter;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle;
        View row;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            row = itemView;
            mTitle = itemView.findViewById(R.id.title);
            imageView = itemView.findViewById(R.id.pan);
        }
    }

    public RVAdapter(ArrayList<String> data, DragListener Adapter) {
        mAdapter = Adapter;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.mTitle.setText(data.get(position));

        holder.imageView.setOnTouchListener((v, event) -> {
            if (event.getAction() ==
                    MotionEvent.ACTION_DOWN) {
                mAdapter.requestDrag(holder);
            }
            return false;
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    @Override
    public void onRowMoved(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(data, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(data, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onRowSelected(RVAdapter.MyViewHolder myViewHolder) {
        myViewHolder.row.setBackgroundColor(Color.GRAY);
    }

    @Override
    public void onRowClear(RVAdapter.MyViewHolder myViewHolder) {
        myViewHolder.row.setBackgroundColor(Color.WHITE);
    }
}