package com.example.syncmeet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView criarContaTextView = findViewById(R.id.criar_nova_conta);
        Button loginButton = findViewById(R.id.login_button);
        TextInputEditText emailEditText = findViewById(R.id.email_edit_text);

        criarContaTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CriarContaActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obter o texto do campo de e-mail/usuário
                String emailOrUsername = emailEditText.getText().toString();

                // Criar o Intent para a próxima tela
                Intent intent = new Intent(MainActivity.this, TelaPrincipalActivity.class);

                // Aqui, quando a pessoa logar, o nome daquele Drawer vai ser substituído automaticamente pelo e-mail e usuário cadastrado
                // Passar os dados para a TelaPrincipalActivity
                // Usaremos o mesmo valor para nome de usuário e e-mail, como placeholder
                intent.putExtra("USERNAME", emailOrUsername); // Você pode ajustar para um nome de usuário real
                intent.putExtra("EMAIL", emailOrUsername);

                startActivity(intent);
            }
        });
    }
}
