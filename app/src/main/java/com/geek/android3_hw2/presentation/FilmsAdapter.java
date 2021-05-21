package com.geek.android3_hw2.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geek.android3_hw2.R;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {
   FilmsPresentation films = new FilmsPresentation();
   private Listener listener;
   public FilmsAdapter(Listener listener){
       this.listener = listener;
   }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_films_adapter,parent,false));
    }

    @Override
    public int getItemCount() {
        return films.getFilmsList().size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(films.getFilmsList().get(position).getTitle());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_textView);
            itemView.setOnClickListener(v -> listener.onClick(films.getFilmsList().get(getAdapterPosition()).getId()));
        }

        public void onBind(String title) {
            textView.setText(title);
        }
    }
    public interface Listener{
       void onClick(String id);
    }
}
