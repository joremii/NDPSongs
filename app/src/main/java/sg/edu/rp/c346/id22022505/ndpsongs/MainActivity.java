package sg.edu.rp.c346.id22022505.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView tvTitle, tvSinger, tvYear, tvStars;
    EditText etTitle, etSinger, etYear;
    RadioButton RB1, RB2, RB3, RB4, RB5;
    Button btnInsert, btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        etTitle = findViewById(R.id.etTitle);
        tvSinger = findViewById(R.id.tvSinger);
        etSinger = findViewById(R.id.etSinger);
        tvYear = findViewById(R.id.tvYear);
        etYear = findViewById(R.id.etYear);
        tvStars = findViewById(R.id.tvStars);
        RB1 = findViewById(R.id.Btn1);
        RB2 = findViewById(R.id.Btn2);
        RB3 = findViewById(R.id.Btn3);
        RB4 = findViewById(R.id.Btn4);
        RB5 = findViewById(R.id.Btn5);
        btnInsert = findViewById(R.id.btnUpdate);
        btnShow = findViewById(R.id.btnDelete);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered song information
                String songTitle = etTitle.getText().toString();
                String singer = etSinger.getText().toString();
                String year = etYear.getText().toString();

                // Get the selected rating
                int rating = 0;
                if (RB1.isChecked()) {
                    rating = 1;
                } else if (RB2.isChecked()) {
                    rating = 2;
                } else if (RB3.isChecked()) {
                    rating = 3;
                } else if (RB4.isChecked()) {
                    rating = 4;
                } else if (RB5.isChecked()) {
                    rating = 5;
                }


                // You can display a Toast message to provide feedback to the user
                String message = "Song: " + songTitle + "\nSinger: " + singer + "\nYear: " + year + "\nRating: " + rating;
                Toast.makeText(MainActivity.this, "Song inserted:\n" + message, Toast.LENGTH_SHORT).show();
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {    @Override
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, NDPSongs.class);
            startActivity(i);    }
        });



    }
}