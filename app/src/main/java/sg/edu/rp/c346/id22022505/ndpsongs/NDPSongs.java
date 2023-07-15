package sg.edu.rp.c346.id22022505.ndpsongs;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Calendar;

public class DisplayActivity extends AppCompatActivity {

    Button btn5Stars;
    ListView lv;

    @Override
    protected void onResume() {
        super.onResume();
        btn5Stars.performClick();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btn5Stars = findViewById(R.id.btn5Stars);

        lv = findViewById(R.id.lv);

        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1900; i <= thisYear; i++) {
            years.add(Integer.toString(i));
        }

        DBHelper db = new DBHelper(NDPSongs.this);
        ArrayList<Songs> songList = db.getSongs();
        db.close();
        //ArrayList<Song> song = db.getSongs();
        ArrayAdapter aaSongs = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songList);
        lv.setAdapter(aaSongs);

        btn5Stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Songs> filteredSongList = new ArrayList<>();
                for (int i = 0; i < songList.size(); i++) {
                    if (songList.get(i).getStar() == 5) {
                        filteredSongList.add(songList.get(i));
                    }
                }
                ArrayAdapter<Songs> aaFilteredSongs = new ArrayAdapter<>(DisplayActivity.this, android.R.layout.simple_list_item_1, filteredSongList);
                lv.setAdapter(aaFilteredSongs);
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Songs song = songList.get(position);
                Intent intent = new Intent(DisplayActivity.this, NDPSongsEdit.class);
                intent.putExtra("song", (CharSequence) song);
                startActivity(intent);
            }
        });
    }
}
