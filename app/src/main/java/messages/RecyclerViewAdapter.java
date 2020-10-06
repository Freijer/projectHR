package messages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import freijer.app.projecthr.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder>{

    private ArrayList<RecyclerViewItem> arrayLIst;

    public static class RecyclerViewViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView textViewOne;
        public TextView textViewTwo;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewOne= itemView.findViewById(R.id.textViewOne);
            textViewTwo= itemView.findViewById(R.id.textViewTwo);
        }
    }

    public RecyclerViewAdapter (ArrayList<RecyclerViewItem> arrayLIst ) {
        this.arrayLIst = arrayLIst;
    }

    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        RecyclerViewViewHolder recyclerViewViewHolder = new RecyclerViewViewHolder(view);
        return recyclerViewViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder holder, int position) {
        RecyclerViewItem  recyclerViewItem = arrayLIst.get(position);
        holder.imageView.setImageResource(recyclerViewItem.getImageResource());
        holder.textViewOne.setText(recyclerViewItem.getText1());
        holder.textViewTwo.setText(recyclerViewItem.getText2());
    }

    @Override
    public int getItemCount() {
        return arrayLIst.size();
    }
}
