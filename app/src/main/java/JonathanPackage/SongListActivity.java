package JonathanPackage;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import info.pauek.songlist.R;

public class SongListActivity extends AppCompatActivity {

    private static int RESULT = 0;

    private List<Song> songs;
    private RecyclerView song_list_view;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        songs = new ArrayList<>();
        songs.add(new Song("...And Justice For All", "RandomOnes", 1989));

        adapter = new Adapter();

        song_list_view = findViewById(R.id.song_list_view);
        song_list_view.setLayoutManager(new LinearLayoutManager(this));
        song_list_view.setAdapter(adapter);
    }

    public void OnNewSong(MenuItem item) {
        Toast.makeText(this, "You clicked New Song", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, SongEditActivity.class);


        startActivity(intent);
        startActivityForResult(intent, RESULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode)
        {



            default:
                super.onActivityResult(requestCode, resultCode, data);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.songslistmenu, menu);

        return true;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title_view;
        private TextView group_view;
        private TextView year_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_view = itemView.findViewById(R.id.title_view);
            group_view = itemView.findViewById(R.id.band_view);
            year_view = itemView.findViewById(R.id.year_view);
        }
    }

    class Adapter extends RecyclerView.Adapter<ViewHolder> {
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = getLayoutInflater().inflate(R.layout.song_item, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
            holder.title_view.setText(songs.get(i).getTitle());
            holder.group_view.setText(songs.get(i).getGroup());
            holder.year_view.setText(Integer.toString(songs.get(i).getYear()));
        }

        @Override
        public int getItemCount() {
            return songs.size();
        }
    }
}
