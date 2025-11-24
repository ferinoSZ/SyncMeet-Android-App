package com.example.syncmeet;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class TelaPrincipalActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView menuIcon;
    private TextView navFooterSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        menuIcon = findViewById(R.id.menu_icon);
        navFooterSair = findViewById(R.id.nav_footer_sair);

        // --- Início da atualização do Header ---

        // Obter a referência para o header do navigation view
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.nav_header_username);
        TextView navEmail = headerView.findViewById(R.id.nav_header_email);

        // Obter os dados passados pelo Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");
        String email = intent.getStringExtra("EMAIL");

        // Atualizar os TextViews com os dados do usuário
        if (username != null && !username.isEmpty()) {
            navUsername.setText(username);
        }
        if (email != null && !email.isEmpty()) {
            navEmail.setText(email);
        }

        // --- Fim da atualização do Header ---

        // Abrir o drawer ao clicar no ícone de menu
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
                    drawerLayout.closeDrawer(GravityCompat.END);
                } else {
                    drawerLayout.openDrawer(GravityCompat.END);
                }
            }
        });

        // Lidar com cliques nos itens do menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Lógica para cada item do menu
                int id = item.getItemId();
                if (id == R.id.nav_eventos_agendados) {
                    Toast.makeText(TelaPrincipalActivity.this, "Eventos Agendados Clicado", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_historico) {
                    Toast.makeText(TelaPrincipalActivity.this, "Histórico de Eventos Clicado", Toast.LENGTH_SHORT).show();
                }

                // Fecha o drawer após o clique
                drawerLayout.closeDrawer(GravityCompat.END);
                return true;
            }
        });

        // Lidar com o clique no botão Sair do rodapé
        navFooterSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deslogar e voltar para a tela de login
                Intent logoutIntent = new Intent(TelaPrincipalActivity.this, MainActivity.class);
                // Limpa a pilha de atividades para que o usuário não possa voltar para a tela principal
                logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(logoutIntent);
                finish();
            }
        });
    }

    // Fecha o drawer se estiver aberto ao pressionar o botão voltar
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }
}
