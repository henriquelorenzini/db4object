package com.catolica;


import java.util.List;

public class Main {

    public static void main(String[] args) {

        Conexao c = new Conexao();
        Pessoa p = new Pessoa();

       p.setName("Henrique");
        p.setIdade(19);
        p.setRg(1);

        c.insertPessoa(p);

        Pessoa p1 = new Pessoa();
        p1.setName("Jessica");
        p1.setIdade(15);
        p1.setRg(2);
        c.insertPessoa(p1);


        List<Pessoa> lp = c.selectAllPessoa();
        for (Pessoa lp1 : lp) {
            System.out.println(lp1);

      }

        p.setRg(1);
        Pessoa p1 = c.selectPessoa(p);
        System.out.println(p1);

        System.out.println("Depois de alterado");
        int rg = 1;
        String nName = "Guilherme";
        int nIdade = 30;

        c.updatePessoa(rg, nName, nIdade);

         lp = c.selectAllPessoa();
        for (Pessoa lp1 : lp) {
            System.out.println(lp1);

      }

        System.out.println("depois da exclusão");
        int rg = 1;
        c.deletePessoa(rg);
        lp = c.selectAllPessoa();
        for (Pessoa lp1 : lp) {
            System.out.println(lp1);
        }
    }
}


