// C:/Users/wesll/AndroidStudioProjects/SyncMeet/app/src/main/java/com/example/syncmeet/MainActivity.java

package com.example.syncmeet;

import android.content.Intent; // Importe a classe Intent
import android.os.Bundle;
import android.view.View;
import android.widget.TextView; // Importe a classe TextView
import androidx.appcompat.app.AppCompatActivity;

// ... outros imports

public class MainActivity extends AppCompatActivity {

    private TextView criarContaTextView; // Declare a variável

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Garanta que este é o layout da tela de login

        // ... (seu código existente para injetar o layout, etc.)

        // 1. Encontre o TextView pelo ID que você acabou de adicionar
        criarContaTextView = findViewById(R.id.criar_nova_conta);

        // 2. Defina a ação de clique
        criarContaTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Este código será executado quando o texto for clicado

                // Crie uma "intenção" (Intent) para ir da tela atual para a CriarContaActivity
                Intent intent = new Intent(MainActivity.this, CriarContaActivity.class);

                // Inicie a nova Activity
                startActivity(intent);
            }
        });

        // ... (seu outro código para o botão de senha, etc.)
    }
}
