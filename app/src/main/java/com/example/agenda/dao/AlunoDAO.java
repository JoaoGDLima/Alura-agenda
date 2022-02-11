package com.example.agenda.dao;

import androidx.annotation.Nullable;

import com.example.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contID = 1;

    public void save(Aluno aluno) {
        aluno.setId(contID);
        alunos.add(aluno);
        atualizaIds();
    }

    private void atualizaIds() {
        contID++;
    }

    public static void edit(Aluno aluno) {
        Aluno alunoEncontrado = buscaAlunoPeloId(aluno);
        if (alunoEncontrado != null) {
            int pos = alunos.indexOf(alunoEncontrado);
            alunos.set(pos, aluno);
        }
    }

    @Nullable
    private static Aluno buscaAlunoPeloId(Aluno aluno) {
        for (Aluno a : alunos) {
            if (a.getId() == aluno.getId()) {
                return a;
            }
        }
        return null;
    }

    public List<Aluno> all() {
        return new ArrayList<>(alunos);
    }

    public void remove(Aluno alunoEscolhido) {
        Aluno alunoEncontrado = buscaAlunoPeloId(alunoEscolhido);
        if (alunoEncontrado != null) {
            alunos.remove(alunoEncontrado);
        }
    }
}
