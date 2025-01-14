package com.example.mynotes;

import android.content.Intent;
import android.os.Bundle;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText etDob;
    private ImageView ivCalendar;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDob = findViewById(R.id.et_dob);
        ivCalendar = findViewById(R.id.icalendar);
        signupButton = findViewById(R.id.btn_create);


        ivCalendar.setOnClickListener(view -> {
            // Get the current date
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
     \       int day = calendar.get(Calendar.DAY_OF_MONTH);

            // Date Picker Dialog
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                    (view1, selectedYear, selectedMonth, selectedDay) -> {
                        // Formatting date and setting it in EditText
                        String selectedDate = selectedDay + "-" + (selectedMonth + 1) + "-" + selectedYear;
                        etDob.setText(selectedDate);
                    }, year, month, day);

            datePickerDialog.show();
        });


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
