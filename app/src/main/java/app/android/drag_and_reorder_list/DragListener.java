package app.android.drag_and_reorder_list;
import androidx.recyclerview.widget.RecyclerView;

public interface DragListener {
    void requestDrag(RecyclerView.ViewHolder viewHolder);
}