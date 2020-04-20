package pc.example.facebook.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pc.example.facebook.R;
import pc.example.facebook.pojo.Model;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Model> models = new ArrayList<>();
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.mUser_id.setText(models.get(position).getUserId());
        holder.mTitle.setText(models.get(position).getTitle());
        holder.mBody.setText(models.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void setModels(List<Model> models) {
        this.models = models;
        notifyDataSetChanged();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        TextView mUser_id ;
        TextView mTitle ;
        TextView mBody;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            mUser_id = itemView.findViewById(R.id.user_id);
            mTitle = itemView.findViewById(R.id.titile);
            mBody = itemView.findViewById(R.id.body);
        }
    }
}
