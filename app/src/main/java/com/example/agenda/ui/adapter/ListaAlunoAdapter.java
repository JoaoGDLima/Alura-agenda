package com.example.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.agenda.R;
import com.example.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class ListaAlunoAdapter extends BaseAdapter {

    private final List<Aluno> alunos = new ArrayList<>();
    private Context context;

    public ListaAlunoAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Aluno getItem(int posicao) {
        return alunos.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return alunos.get(posicao).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewCriada = LayoutInflater
                .from(context)
                .inflate(R.layout.item_aluno, viewGroup, false);

        TextView nome = viewCriada.findViewById(R.id.item_aluno_nome);
        TextView telefone = viewCriada.findViewById(R.id.item_aluno_telefone);

        nome.setText(this.alunos.get(i).getNome());
        telefone.setText(this.alunos.get(i).getNome());

        return viewCriada;
    }

    public void clear() {
        this.alunos.clear();
    }

    public void addAll(List<Aluno> alunos) {
        this.alunos.addAll(alunos);
    }

    public void remove(Aluno aluno) {
        this.remove(aluno);
    }
}
