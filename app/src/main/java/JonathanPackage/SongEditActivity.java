package JonathanPackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;

import info.pauek.songlist.R;

public class SongEditActivity extends AppCompatActivity {

    TextView yearView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_edit);

        yearView = findViewById(R.id.Year);
        Calendar calendar = new GregorianCalendar();
        yearView.setText(Integer.toString(calendar.get(Calendar.YEAR)));
    }

    public void OnSave(View view) {
        Intent intent = new Intent();
        setResult(1);
        finish();
    }

    public void OnPlus(View view) {
        int tempValue = 0;
        if(yearView.getText().toString().isEmpty())
            tempValue = 1999;
        else
            tempValue = Integer.valueOf(yearView.getText().toString());
        tempValue++;
        yearView.setText(Integer.toString(tempValue));
    }

    public void OnMinus(View view) {
        int tempValue = 0;
        if(yearView.getText().toString().isEmpty())
            tempValue = 2001;
        else
            tempValue = Integer.valueOf(yearView.getText().toString());
        tempValue--;
        yearView.setText(Integer.toString(tempValue));
    }
}
