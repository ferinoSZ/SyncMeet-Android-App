package com.example.syncmeet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditarEventoDetailActivity extends AppCompatActivity {

    private ImageView backArrow;
    private EditText nomeEvento, local, data, horarioInicio, horarioTermino;
    private Button salvarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_evento_detail);

        backArrow = findViewById(R.id.back_arrow);
        nomeEvento = findViewById(R.id.detalhe_nome_evento);
        local = findViewById(R.id.detalhe_local);
        data = findViewById(R.id.detalhe_data);
        horarioInicio = findViewById(R.id.detalhe_horario_inicio);
        horarioTermino = findViewById(R.id.detalhe_horario_termino);
        salvarButton = findViewById(R.id.salvar_edicao_button);

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

        // Lógica para salvar as alterações
        salvarButton.setOnClickListener(v -> {
            // Aqui você adicionaria a lógica para salvar os dados no banco de dados ou onde quer que eles estejam armazenados.
            // Por enquanto, apenas exibimos uma mensagem e fechamos a tela.

            Toast.makeText(EditarEventoDetailActivity.this, "Alterações salvas!", Toast.LENGTH_SHORT).show();
            finish(); // Volta para a lista de eventos
        });
    }
}
