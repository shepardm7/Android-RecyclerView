package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.phoenix.recyclerviewdemo.DetailsActivity;
import com.phoenix.recyclerviewdemo.R;

import java.util.List;

import Model.ListItem;

/**
 * Created by Phoenix on 11-Mar-18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<ListItem> listItems;

    public MyAdapter(Context context, List listItems){
        this.context = context;
        this.listItems = listItems;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.name.setText(listItems.get(position).getTitle());
        holder.description.setText(listItems.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView description;
        public ViewHolder(final View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    String title = listItems.get(position).getTitle();
                    String description = listItems.get(position).getDescription();

                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("name", title);
                    intent.putExtra("description", description);
                    context.startActivity(intent);
                    Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
                }
            });

            name = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
        }
    }
}
