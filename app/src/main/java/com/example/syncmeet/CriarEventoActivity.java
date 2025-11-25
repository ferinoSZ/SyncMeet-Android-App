package com.example.syncmeet;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CriarEventoActivity extends AppCompatActivity {

    private EditText nomeEventoEditText;
    private EditText localEventoEditText;
    private EditText dataEventoEditText;
    private EditText horaEventoEditText;
    private final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.criar_evento);

        nomeEventoEditText = findViewById(R.id.nome_evento);
        localEventoEditText = findViewById(R.id.local_evento);
        dataEventoEditText = findViewById(R.id.data_evento);
        horaEventoEditText = findViewById(R.id.hora_evento);

        // --- Configuração do DatePickerDialog ---
        DatePickerDialog.OnDateSetListener date = (view, year, month, dayOfMonth) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateDateLabel();
        };

        dataEventoEditText.setOnClickListener(v -> {
            new DatePickerDialog(CriarEventoActivity.this,
                    date,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        // --- Configuração do TimePickerDialog ---
        TimePickerDialog.OnTimeSetListener time = (view, hourOfDay, minute) -> {
            myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            myCalendar.set(Calendar.MINUTE, minute);
            updateTimeLabel();
        };

        horaEventoEditText.setOnClickListener(v -> {
            new TimePickerDialog(CriarEventoActivity.this,
                    time,
                    myCalendar.get(Calendar.HOUR_OF_DAY),
                    myCalendar.get(Calendar.MINUTE),
                    true).show();
        });
    }

    private void updateDateLabel() {
        String myFormat = "dd/MM/yyyy"; // Formato da data
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
        dataEventoEditText.setText(sdf.format(myCalendar.getTime()));
    }

    private void updateTimeLabel() {
        String myFormat = "HH:mm"; // Formato da hora
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
        horaEventoEditText.setText(sdf.format(myCalendar.getTime()));
    }
}
