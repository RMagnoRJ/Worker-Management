package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroGeral {
    
    List <CadastroWorker> cadGeral = new ArrayList<>();

    Scanner inn = new Scanner (System.in); 

    public CadastroGeral() {
    }


    public List<CadastroWorker> getCadGeral() {
        return cadGeral;
    }



    public void addCadastro (CadastroWorker cadWorker){
        cadGeral.add(cadWorker);
    }

    public void renovarCadWorker( CadastroWorker cadWorker){
        cadWorker.removeWorker();
        cadGeral.removeLast();
    }

    public void removerCadastroWorker(int registro) {
        boolean error = true;

        for (int i = 0; i < cadGeral.size(); i++) {

            if (cadGeral.get(i).finderReg(registro) == registro){
                cadGeral.remove(i);
                error = false;
            }
        }

        if (error == true) {
            System.out.println("\n ### Registro não localizado ### \n");
        }

    }


    public void showSingleWorker() {
        for (CadastroWorker cad : cadGeral){
            cad.showCadWorker();
        }
    }

    public void showCadastroGeral () {
        @SuppressWarnings("unused")
        String wait;
        System.out.println("TOTAL de CADASTROS: " + cadGeral.size() + "\n");
        int cont = 1;
        for (CadastroWorker cad : cadGeral){
            System.out.println("\n=+=+=+=+=+=+=+=");
            System.out.println("      # " + cont);
            System.out.println("=+=+=+=+=+=+=+=\n");
            cad.showCadastroDeNomes();
            System.out.print("Pressione qualquer tecla para continuar >>>   "); wait = inn.nextLine(); 
            System.out.println("\n\n-----------------------------------\n");
            cont +=1;
        }
    }

    public void showCadastroFuncionarios () {

        for (CadastroWorker cad : cadGeral){
            cad.showCadastroDeNomes();
        }
    }

    public void showCadastroDeContratos () {

        for (CadastroWorker cad : cadGeral){
            cad.showCadastroDeContratos();
        }
    }

    public int findRegistroWorker(int busca){
        int resultado=0;
        for (CadastroWorker cad : cadGeral){
            if (busca ==  cad.finderReg(busca)){
                resultado = busca;
            } else {
                resultado = -1;
            }
        }
        return resultado;
    }

    public void findNameWorker(String nome){
        boolean showError = true; 
        for (CadastroWorker cad : cadGeral){
            if (cad.finderName(nome) == true){
                showError = false;
            }
        }

        if (showError == true){
            System.out.println("\n*************************************");
            System.out.println("  ### FUNCIONÁRIO NÃO LOCALIZADO ###");
            System.out.println("*************************************\n");
        }
    }
}
