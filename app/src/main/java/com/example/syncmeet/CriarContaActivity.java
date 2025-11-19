// C:/Users/wesll/AndroidStudioProjects/SyncMeet/app/src/main/java/com/example/syncmeet/CriarContaActivity.java

package com.example.syncmeet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.text.TextUtils; // Importante para verificar strings vazias
import android.view.MenuItem;
import android.view.View; // Importante para o OnClickListener
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

        MaterialButton registerButton = findViewById(R.id.register_button);

        // 3. Configure o "ouvinte" de clique para o botão de cadastrar

    }

    private void validarCampos() {
        // Pega o texto de cada campo e remove espaços em branco no início e no fim
        String email = Objects.requireNonNull(emailEditText.getText()).toString().trim();
        String usuario = Objects.requireNonNull(usuarioEditText.getText()).toString().trim();
        String senha = Objects.requireNonNull(senhaEditText.getText()).toString().trim();
        String confirmarSenha = Objects.requireNonNull(confirmarSenhaEditText.getText()).toString().trim();

        // Variável de controle para saber se todos os campos são válidos
        boolean isValid = true;

        // --- Início das Validações ---

        // Validação do E-mail
        if (TextUtils.isEmpty(email)) {
            emailLayout.setError("Este campo é obrigatório");
            isValid = false;
        } else {
            emailLayout.setError(null); // Limpa o erro se o campo for preenchido
        }

        // Validação do Usuário
        if (TextUtils.isEmpty(usuario)) {
            usuarioLayout.setError("Este campo é obrigatório");
            isValid = false;
        } else {
            usuarioLayout.setError(null);
        }

        // Validação da Senha
        if (TextUtils.isEmpty(senha)) {
            senhaLayout.setError("Este campo é obrigatório");
            isValid = false;
        } else {
            senhaLayout.setError(null);
        }

        // Validação da Confirmação de Senha
        if (TextUtils.isEmpty(confirmarSenha)) {
            confirmarSenhaLayout.setError("Este campo é obrigatório");
            isValid = false;
        } else if (!senha.equals(confirmarSenha)) { // Validação extra: as senhas coincidem?
            confirmarSenhaLayout.setError("As senhas não coincidem");
            isValid = false;
        } else {
            confirmarSenhaLayout.setError(null);
        }

        // --- Fim das Validações ---

        // Se todos os campos passaram na validação (isValid continuou true)
        if (isValid) {
            // Ação de sucesso!
            // Aqui você colocaria o código para salvar o usuário no banco de dados, etc.
            // Por enquanto, vamos apenas mostrar uma mensagem de sucesso.
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
        }
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
