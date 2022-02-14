package com.example.agenda;

import android.app.Application;

import com.example.agenda.dao.AlunoDAO;
import com.example.agenda.model.Aluno;

public class AgendaApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosTeste();
    }

    private void criaAlunosTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.save(new Aluno("Alex", "1122223333", "alex@alura.com.br"));
        dao.save(new Aluno("Fran", "1122223333", "fran@gmail.com"));
    }
}
