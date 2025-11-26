package com.example.syncmeet;

import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ExcluirEventoActivity extends AppCompatActivity {

    private ImageView backArrow;
    private Button excluirButton;
    private List<CheckBox> checkBoxes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.excluir_evento);

        backArrow = findViewById(R.id.back_arrow);
        excluirButton = findViewById(R.id.excluir_button);

        // Adiciona as checkboxes à lista para verificação
        checkBoxes.add(findViewById(R.id.checkbox_1));
        checkBoxes.add(findViewById(R.id.checkbox_2));
        checkBoxes.add(findViewById(R.id.checkbox_3));

        // Lógica do botão voltar
        backArrow.setOnClickListener(v -> finish());

        // Lógica do botão excluir com verificação
        excluirButton.setOnClickListener(v -> {
            if (isAnyCheckBoxChecked()) {
                showConfirmacaoDialog();
            } else {
                Toast.makeText(ExcluirEventoActivity.this, "Nenhum evento selecionado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isAnyCheckBoxChecked() {
        for (CheckBox checkBox : checkBoxes) {
            if (checkBox.isChecked()) {
                return true;
            }
        }
        return false;
    }


    private void showConfirmacaoDialog() {
        View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_confirmacao, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        final AlertDialog dialog = builder.create();

        Button btnSim = dialogView.findViewById(R.id.dialog_button_sim);
        Button btnCancelar = dialogView.findViewById(R.id.dialog_button_cancelar);

        btnSim.setOnClickListener(simView -> {
            Toast.makeText(ExcluirEventoActivity.this, "Eventos selecionados excluídos!", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
            // Aqui você coloca a lógica para remover os itens da lista e do banco de dados
        });

        btnCancelar.setOnClickListener(cancelarView -> dialog.dismiss());

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }

        dialog.show();
    }
}
