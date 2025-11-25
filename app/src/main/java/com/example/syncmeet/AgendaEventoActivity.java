package com.example.syncmeet;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AgendaEventoActivity extends AppCompatActivity {

    private ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agenda_evento);

        backArrow = findViewById(R.id.back_arrow);

        backArrow.setOnClickListener(v -> {
            // Fecha a activity atual e retorna para a anterior (TelaPrincipalActivity)
            finish();
        });
    }
}
