package com.example.spotifyhomeui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private List<Album> albumList;

    public AlbumAdapter(List<Album> albumList) {
        this.albumList = albumList;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.tvType.setText(album.getType());
        holder.tvTitle.setText(album.getTitle());
        holder.ivCover.setImageResource(album.getImageRes());
        if (album.isShowOverlay()) {
            holder.tvOverlay.setVisibility(View.VISIBLE);
            holder.tvOverlay.setText(album.getTitle());
        } else {
            holder.tvOverlay.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    static class AlbumViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCover;
        TextView tvOverlay;
        TextView tvType;
        TextView tvTitle;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCover = itemView.findViewById(R.id.ivAlbumCover);
            tvOverlay = itemView.findViewById(R.id.tvOverlay);
            tvType = itemView.findViewById(R.id.tvAlbumType);
            tvTitle = itemView.findViewById(R.id.tvAlbumTitle);
        }
    }
}