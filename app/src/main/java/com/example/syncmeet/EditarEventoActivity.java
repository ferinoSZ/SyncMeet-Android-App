package com.example.syncmeet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class EditarEventoActivity extends AppCompatActivity {

    private ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_evento);

        backArrow = findViewById(R.id.back_arrow);
        Button evento1 = findViewById(R.id.evento_1);
        Button evento2 = findViewById(R.id.evento_2);

        backArrow.setOnClickListener(v -> {
            // Fecha a activity atual e retorna para a anterior (TelaPrincipalActivity)
            finish();
        });

        // --- Lógica para abrir a tela de detalhes para edição ---

        evento1.setOnClickListener(v -> {
            Intent intent = new Intent(EditarEventoActivity.this, EditarEventoDetailActivity.class);
            intent.putExtra("NOME_EVENTO", "Reunião de Equipe");
            intent.putExtra("LOCAL_EVENTO", "Sala de Conferências 1");
            intent.putExtra("DATA_EVENTO", "25/12/2024");
            intent.putExtra("HORARIO_INICIO", "10:00");
            intent.putExtra("HORARIO_TERMINO", "11:00");
            startActivity(intent);
        });

        evento2.setOnClickListener(v -> {
            Intent intent = new Intent(EditarEventoActivity.this, EditarEventoDetailActivity.class);
            intent.putExtra("NOME_EVENTO", "Apresentação de Projeto");
            intent.putExtra("LOCAL_EVENTO", "Auditório Principal");
            intent.putExtra("DATA_EVENTO", "30/11/2024");
            intent.putExtra("HORARIO_INICIO", "15:00");
            intent.putExtra("HORARIO_TERMINO", "16:30");
            startActivity(intent);
        });
    }
}
