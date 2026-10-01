package com.example.spotifyhomeui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0); // Handle bottom padding manually if needed, but nav bar is pinned to bottom.
            
            // Apply bottom padding to bottomNav so it doesn't overlap the system nav bar
            View bottomNav = findViewById(R.id.bottomNav);
            bottomNav.setPadding(0, 0, 0, systemBars.bottom);
            
            return insets;
        });

        setupFilters();
        setupStartListening();
        setupAlbums();
        setupMiniPlayer();
        setupBottomNavigation();
    }

    private void setupFilters() {
        // ChipGroup handles the single selection automatically along with ColorStateLists
    }

    private void setupStartListening() {
        RecyclerView rvStartListening = findViewById(R.id.rvStartListening);
        
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Cho Tôi Lang Thang", "Ngọt, Đen", R.drawable.cover_cho_toi_lang_thang));
        songs.add(new Song("Dù Cho Mai Về Sau", "buitruonglinh", R.drawable.cover_du_cho_mai_ve_sau));
        songs.add(new Song("Thích Quá Rùi Nà", "tlinh, Trung Trần", R.drawable.cover_thich_qua_rui_na));
        songs.add(new Song("Mơ", "Vũ Cát Tường", R.drawable.cover_mo));
        songs.add(new Song("Thanh Xuân", "Da LAB", R.drawable.cover_thanh_xuan));
        songs.add(new Song("Thằng Điên", "JustaTee, Phương Ly", R.drawable.cover_thang_dien));

        SongAdapter adapter = new SongAdapter(songs);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3, RecyclerView.HORIZONTAL, false);
        
        rvStartListening.setLayoutManager(layoutManager);
        rvStartListening.setAdapter(adapter);

        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(rvStartListening);
    }

    private void setupAlbums() {
        RecyclerView rvAlbums = findViewById(R.id.rvAlbums);
        
        List<Album> albums = new ArrayList<>();
        albums.add(new Album("Playlist", "Vũ. Mix", R.drawable.vu_mix, true));
        albums.add(new Album("EP", "Tình Ca Hoàng Dũng", R.drawable.tinh_ca_hoang_dung, false));
        albums.add(new Album("Single", "Bất Chấp", R.drawable.bat_chap, false));
        albums.add(new Album("Album", "Một Vạn Năm", R.drawable.mot_van_nam, false));

        AlbumAdapter adapter = new AlbumAdapter(albums);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        
        rvAlbums.setLayoutManager(layoutManager);
        rvAlbums.setAdapter(adapter);
    }

    private void setupMiniPlayer() {
        ImageView ivPlayPause = findViewById(R.id.ivPlayPause);
        ivPlayPause.setOnClickListener(v -> {
            isPlaying = !isPlaying;
            if (isPlaying) {
                ivPlayPause.setImageResource(R.drawable.ic_pause);
            } else {
                ivPlayPause.setImageResource(R.drawable.ic_play);
            }
        });
    }

    private void setupBottomNavigation() {
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnItemSelectedListener(item -> {
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        });
    }
}