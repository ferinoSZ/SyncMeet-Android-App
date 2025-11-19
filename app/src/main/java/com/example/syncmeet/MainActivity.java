// C:/Users/wesll/AndroidStudioProjects/SyncMeet/app/src/main/java/com/example/syncmeet/MainActivity.java

package com.example.syncmeet;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Paint; // Importe a classe Paint
import android.os.Bundle;
import android.view.MotionEvent; // Importe a classe MotionEvent
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView forgotPasswordTextView;
    // ... suas outras declarações

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Encontre o TextView pelo ID
        forgotPasswordTextView = findViewById(R.id.esqueceu_senha);

        // 2. Configure o "Ouvinte de Toque"
        // O JEITO NOVO (E SEM AVISOS)
        forgotPasswordTextView.setOnTouchListener((v, event) -> {
            // Converte a View 'v' de volta para um TextView para facilitar
            TextView textView = (TextView) v;

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    // AÇÃO QUANDO O USUÁRIO PRESSIONA O DEDO:
                    // Adiciona a "flag" de sublinhado ao texto
                    textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                    break;

                case MotionEvent.ACTION_UP:
                    // AÇÃO QUANDO O USUÁRIO SOLTA O DEDO:
                    // Remove a "flag" de sublinhado
                    textView.setPaintFlags(textView.getPaintFlags() & (~Paint.UNDERLINE_TEXT_FLAG));

                    // Execute a ação de clique aqui, quando o usuário solta o dedo
                    Toast.makeText(MainActivity.this, "Função desativada pelos desenvolvedores do aplicativo SyncMeet", Toast.LENGTH_SHORT).show();
                    break;

                case MotionEvent.ACTION_CANCEL:
                    // AÇÃO SE O TOQUE FOR CANCELADO (ex: arrastar o dedo para fora):
                    // Garante que o sublinhado seja removido
                    textView.setPaintFlags(textView.getPaintFlags() & (~Paint.UNDERLINE_TEXT_FLAG));
                    break;
            }
            // Retorna 'true' para indicar que o evento de toque foi consumido aqui
            return true;
        });

    }
}
