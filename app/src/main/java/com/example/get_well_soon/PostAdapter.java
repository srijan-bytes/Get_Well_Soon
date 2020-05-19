package com.example.get_well_soon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class PostAdapter extends FirebaseRecyclerAdapter<post,PostAdapter.PostViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public PostAdapter(@NonNull FirebaseRecyclerOptions<post> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PostViewHolder holder, int position, @NonNull post model) {
        holder.name.setText(post.getName());

        holder.degree.setText(post.getDegree());


    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post, parent, false);

        return new PostViewHolder(view);

    }

    class PostViewHolder extends RecyclerView.ViewHolder{

        TextView name,degree;
        ImageView img;





        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name_doctor);
            degree=itemView.findViewById(R.id.degree_doctor);
            img=(ImageView) itemView.findViewById(R.id.imageView2);
        }
    }
}
