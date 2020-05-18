package com.example.get_well_soon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class programmingAdapter extends RecyclerView.Adapter<programmingAdapter.ProgrammingViewHolder>{
    @NonNull

    private String[] data;

    public programmingAdapter(String[] data)
    {

        this.data=data;
    }
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list_item_layout,parent,false);
        return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder holder, int position) {
        String title=data[position];
        holder.txtTitle.setText(title);

    }

    @Override
    public int getItemCount() {

        return data.length;
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder{
        ImageView imgIcon;
        TextView  txtTitle;
        public ProgrammingViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imgIcon=(ImageView) itemView.findViewById(R.id.imgIcon);
            txtTitle=(TextView) itemView.findViewById(R.id.textTitle);
        }
    }
}
