package com.example.syncmeet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HistoricoEventoDetailActivity extends AppCompatActivity {

    private ImageView backArrow;
    private TextView nomeEvento, local, data, horarioInicio, horarioTermino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historico_evento_detail);

        backArrow = findViewById(R.id.back_arrow);
        nomeEvento = findViewById(R.id.detalhe_nome_evento);
        local = findViewById(R.id.detalhe_local);
        data = findViewById(R.id.detalhe_data);
        horarioInicio = findViewById(R.id.detalhe_horario_inicio);
        horarioTermino = findViewById(R.id.detalhe_horario_termino);

        // Lógica do botão voltar
        backArrow.setOnClickListener(v -> finish());

        // --- Preencher os dados do evento ---
        Intent intent = getIntent();
        if (intent != null) {
            nomeEvento.setText(intent.getStringExtra("NOME_EVENTO"));
            local.setText(intent.getStringExtra("LOCAL_EVENTO"));
            data.setText(intent.getStringExtra("DATA_EVENTO"));
            horarioInicio.setText(intent.getStringExtra("HORARIO_INICIO"));
            horarioTermino.setText(intent.getStringExtra("HORARIO_TERMINO"));
        }
    }
}
