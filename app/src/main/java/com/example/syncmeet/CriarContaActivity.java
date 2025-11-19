// C:/Users/wesll/AndroidStudioProjects/SyncMeet/app/src/main/java/com/example/syncmeet/CriarContaActivity.java

package com.example.syncmeet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.text.TextUtils; // Importante para verificar strings vazias
import android.view.MenuItem;

import android.widget.Toast; // Para mostrar mensagens

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class CriarContaActivity extends AppCompatActivity {

    // 1. Declare as variáveis para os componentes do layout
    private TextInputLayout emailLayout, usuarioLayout, senhaLayout, confirmarSenhaLayout;
    private TextInputEditText emailEditText, usuarioEditText, senhaEditText, confirmarSenhaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.criar_conta);

        // --- Configuração da Toolbar (flecha de voltar) ---
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        // --- Fim da configuração da Toolbar ---

        // 2. Encontre os componentes no layout usando findViewById
        emailLayout = findViewById(R.id.email_layout_create);
        usuarioLayout = findViewById(R.id.usuario_layout_create);
        senhaLayout = findViewById(R.id.password_layout_create);
        confirmarSenhaLayout = findViewById(R.id.confirm_password_layout_create);

        emailEditText = findViewById(R.id.email_edittext_create);
        usuarioEditText = findViewById(R.id.usuario_edittext_create);
        senhaEditText = findViewById(R.id.password_edittext_create);
        confirmarSenhaEditText = findViewById(R.id.confirm_password_edittext_create);



        // 3. Configure o "ouvinte" de clique para o botão de cadastrar

    }




    // --- Método para o clique na flecha de voltar ---
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
