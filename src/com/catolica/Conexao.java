package com.catolica;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.collections.ArrayList4;

import java.util.ArrayList;
import java.util.List;

public class Conexao {
    private ObjectContainer db = null;

    private void openDb(){
        db = Db4o.openFile("banco");
    }
    private void closeDb(){
        db.close();
    }

    // insert
    public void insertPessoa(Pessoa p){
        openDb();
        db.store(p);
        closeDb();
    }
    //select trazendo todos os dados
    public List<Pessoa> selectAllPessoa() {
        openDb();
        //procura e lista todos os registros da classe pessoa
        ObjectSet listPessoa = db.queryByExample(Pessoa.class);
        List<Pessoa> lp = new ArrayList<Pessoa>();
        //armazena na lista
        for (Object listPessoa1: listPessoa) {
            lp.add((Pessoa)listPessoa1);
        }
        closeDb();
        return lp;
    }
    //trazendo uma pessoa só
    public Pessoa selectPessoa(Pessoa p){
        openDb();
        ObjectSet result = db.queryByExample(p);
        Pessoa pessoa = (Pessoa) result.next();
        closeDb();
        return pessoa;
    }
    //update de dados
    public void updatePessoa(int rg, String nName, int nIdade){
        openDb();
        Pessoa p = new Pessoa();
        p.setRg(rg);
        ObjectSet result = db.queryByExample(p);
        Pessoa pResult = (Pessoa) result.next();
        pResult.setName(nName);
        pResult.setIdade(nIdade);

        db.store(pResult);
        closeDb();

    }
    //delete
    public void deletePessoa(int rg){
        openDb();
        Pessoa p = new Pessoa();
        p.setRg(rg);
        ObjectSet result = db.queryByExample(p);
        Pessoa pResult = (Pessoa) result.next();
        db.delete(pResult);
        closeDb();

    }
}
