package com.example.agenda.ui.activity;

import static com.example.agenda.ui.activity.ConstantesActivities.CHAVE_ALUNO;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.model.Aluno;
import com.example.agenda.ui.ListaAlunosView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaAlunoActivity extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Lista de alunos";

    private final ListaAlunosView listaAlunosView = new ListaAlunosView(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_aluno);
        setTitle(TITULO_APPBAR);
        configuraFabNovoAluno();
        configuraLista();
    }

    @Override
    protected void onResume() {
        super.onResume();
        listaAlunosView.atualizaAlunos();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_lista_alunos_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();
        if (itemId == R.id.activity_lista_alunos_menu_remover) {
            listaAlunosView.confirmaRemocao(item);
        }

        return super.onContextItemSelected(item);
    }


    private void abreFormularioAlunoModoInsereAluno() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.lista_alunos_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener(view -> abreFormularioAlunoModoInsereAluno());
    }


    private void configuraLista() {
        ListView listaDeAlunos = findViewById(R.id.lista_alunos_listview);
        listaAlunosView.configuraAdapter(listaDeAlunos);
        configuraListenerCliqueItem(listaDeAlunos);
        registerForContextMenu(listaDeAlunos);
    }


    private void configuraListenerCliqueItem(ListView listaDeAlunos) {
        listaDeAlunos.setOnItemClickListener((adapterView, view, posicao, id) -> {
            Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(posicao);
            abreFormularioModoEditaAluno(alunoEscolhido);
        });
    }

    private void abreFormularioModoEditaAluno(Aluno alunoEscolhido) {
        Intent vaiParaFormularioActivity = new Intent(ListaAlunoActivity.this, FormularioAlunoActivity.class);
        vaiParaFormularioActivity.putExtra(CHAVE_ALUNO, alunoEscolhido);
        startActivity(vaiParaFormularioActivity);
    }


}

