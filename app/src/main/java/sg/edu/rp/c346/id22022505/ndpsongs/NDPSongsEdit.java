package sg.edu.rp.c346.id22022505.ndpsongs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    EditText etSongID;
    EditText etTitle;
    EditText etSinger;
    EditText etYear;
    RadioGroup rg;
    Button btnUpdate;
    Button  btnDelete;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.NDPSongsEdit);

        etSongID = findViewById(R.id.etSongID);
        etTitle = findViewById(R.id.etTitle);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);
        rg = findViewById(R.id.rg);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        Intent intent = getIntent();
        Songs data = (Songs) intent.getSerializableExtra("song");
        etSongID.setText(String.valueOf(data.getId()));
        etTitle.setText(data.getTitle());
        etSinger.setText(data.getSinger());
        etYear.setText(String.valueOf(data.getYear()));

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(NDPSongsEdit.this);
                if (rg.getCheckedRadioButtonId() == R.id.b1){
                    data.setSongTitle(etTitle.getText().toString());
                    data.setSinger(etSinger.getText().toString());
                    data.setYear(Integer.parseInt(etYear.getText().toString()));
                    data.setStars(1);
                    db.updateSong(data);
                    db.close();
                    finish();
                } else if (rg.getCheckedRadioButtonId() == R.id.b2){
                    data.setSongTitle(etTitle.getText().toString());
                    data.setSinger(etSinger.getText().toString());
                    data.setYear(Integer.parseInt(etYear.getText().toString()));
                    data.setStars(2);
                    db.updateSong(data);
                    db.close();
                    finish();
                } else if (rg.getCheckedRadioButtonId() == R.id.b3){
                    data.setSongTitle(etTitle.getText().toString());
                    data.setSinger(etSinger.getText().toString());
                    data.setYear(Integer.parseInt(etYear.getText().toString()));
                    data.setStars(3);
                    db.updateSong(data);
                    db.close();
                    finish();
                } else if (rg.getCheckedRadioButtonId() == R.id.b4){
                    data.setSongTitle(etTitle.getText().toString());
                    data.setSinger(etSinger.getText().toString());
                    data.setYear(Integer.parseInt(etYear.getText().toString()));
                    data.setStars(4);
                    db.updateSong(data);
                    db.close();
                    finish();
                } else if (rg.getCheckedRadioButtonId() == R.id.b5){
                    data.setSongTitle(etTitle.getText().toString());
                    data.setSinger(etSinger.getText().toString());
                    data.setYear(Integer.parseInt(etYear.getText().toString()));
                    data.setStars(5);
                    db.updateSong(data);
                    db.close();
                    finish();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(NDPSongsEdit.this);
                db.deleteSong(data.getId());
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}