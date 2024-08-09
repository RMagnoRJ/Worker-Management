package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroWorker {
    
    int registro;
    
    WorkerClass worker = new WorkerClass();

    List <HourContract> cadContracts = new ArrayList<>();

    Scanner inn = new Scanner (System.in);

    
    public CadastroWorker() {
    }

    public int getRegistro() {
        return registro;
    }

    public WorkerClass getWorker() {
        return worker;
    }
    
    public void addWorker (WorkerClass worker){
       this.worker = worker;
    }

    public void removeWorker (){
        worker.cleanWorker();
        cadContracts.removeAll(cadContracts);
    }

    public void addRegistro (int registro){
        this.registro = registro;
        
    }

    public void addContract (HourContract contract){
        cadContracts.add(contract);
    }

    public void removeLastContract (){
        cadContracts.removeLast();
    }

    public void removeContract () {
        int contrato = 0;
        System.out.println("\n*************************************");
        System.out.println("              CONTRATOS             ");
        System.out.println("*************************************\n");
        System.out.println("REGISTRO: " + this.registro);
        System.out.println("\n-----------------------------------\n");
        for (HourContract show : cadContracts){
            System.out.println("Contrato nº " + (contrato+1));
            show.escolheContrato();
            System.out.print("\nDigite: \n" + 
            "\n[1] para CONTINUAR; ou," + 
            "\n[2] para ESCOLHER o contrato exibido\n" + 
            "\n>>>  ");
            int op = inn.nextInt(); inn.nextLine(); 
            if (op == 1){
                contrato += 1;
                System.out.println("\n-------------------------------------\n");
            } else {
                System.out.println("\n-------------------------------------");
                System.out.println("\n### ATENÇÃO ### " + 
                                   "\nContrato nº " + (contrato+1) + " será removido!");
                System.out.println("-------------------------------------\n");
                System.out.print("\nDigite: \n" + 
                "\n[1] para CONFIRMAR; ou, "+ 
                "\n[2] para ESCOLHER outro contrato \n" +
                "\n> ");
                int confirma = inn.nextInt(); inn.nextLine();
                if (confirma == 1){
                    cadContracts.remove(contrato);
                    System.out.println("\n-------------------------------------");
                    System.out.println("\nContrato nº " + (contrato+1) + " removido com sucesso!");
                    break;
                }
            }
        }
    }


    public void showCadWorker() {
        System.out.println("\n*************************************");
        System.out.println("              CADASTRO             ");
        System.out.println("*************************************\n");
        System.out.println("REGISTRO: " + this.registro);
        System.out.println("\n-----------------------------------\n");
        worker.showWorker();
        System.out.println("\n-----------------------------------\n");
    }

    public void showCadastroWorker() {
        
        System.out.println("\n*************************************");
        System.out.println("              CADASTRO             ");
        System.out.println("*************************************\n");
        System.out.println("REGISTRO: " + this.registro);
        System.out.println("\n-----------------------------------\n");
        worker.showWorker();
        System.out.println("\n*************************************");
        System.out.println("              CONTRATOS             ");
        System.out.println("*************************************\n");
        
        for (HourContract show : cadContracts){
            show.showContract();
        }
        
    }
   
    public void showCadastroCompleto() {
        
        
        
        System.out.println("\n*************************************");
        System.out.println("              CADASTRO             ");
        System.out.println("*************************************\n");
        System.out.println("REGISTRO: " + this.registro);
        System.out.println("\n-----------------------------------\n");
        worker.showWorker();
        System.out.println("\n*************************************");
        System.out.println("              CONTRATOS             ");
        System.out.println("*************************************\n");
        
        for (HourContract show : cadContracts){
            show.showContract();
        }
      
    }

    public void showCadastroDeNomes() {

        System.out.println("\n*************************************");
        System.out.println("              CADASTRO             ");
        System.out.println("*************************************\n");
        System.out.println("REGISTRO: " + this.registro);
        System.out.println("\n-----------------------------------\n");
        worker.showWorker();
        System.out.println("\n-----------------------------------\n");
    }

    public void showCadastroDeContratos() {

        System.out.println("\n*************************************");
        System.out.println("              CONTRATOS             ");
        System.out.println("*************************************\n");
        System.out.println("REGISTRO: " + this.registro);
        System.out.println("\n-----------------------------------\n");
        for (HourContract show : cadContracts){
            show.showContract();
        }
    }

    public void showNovoContrato() {

        System.out.println("\n*************************************");
        System.out.println("              CONTRATOS             ");
        System.out.println("*************************************\n");
        System.out.println("REGISTRO: " + this.registro);
        System.out.println("\n-----------------------------------\n");
        cadContracts.getLast().showContract();
    }

    public void showReceita (int ano, int mes){
        HourContract hour = new HourContract();
        double total_receita = worker.getBaseSalary();
        int alerta = 0;
        System.out.println("\n-------------------------------------\n");
        for (int i = 0; i < cadContracts.size(); i++){

            if (cadContracts.get(i).getAno() == ano && cadContracts.get(i).getMes() == mes) {
                alerta +=1;
                System.out.println("CONTRATO # " + (i+1));
                System.out.println("SALÁRIO-BASE = R$ " + worker.getBaseSalary());
                System.out.println("MES: " + hour.Calendar(cadContracts.get(i).getMes()) + "  ||  " + "ANO: " + cadContracts.get(i).getAno());
                hour.Conversor(cadContracts.get(i).getHoras_trabalhadas());
                System.out.println("VALOR DA HORA: " + cadContracts.get(i).getValorDaHora());
                double total_dia = cadContracts.get(i).getHoras_trabalhadas() * cadContracts.get(i).getValorDaHora();
                System.out.println("VALOR DO CONTRATO = R$ " + String.format("%.2f", total_dia));
                total_receita = total_receita + total_dia;
                System.out.println("\n-------------------------------------\n");
            } 
        }
        if (alerta >= 1){
            System.out.println("TOTAL DA RECEITA APURADA = R$ " + String.format("%.2f", total_receita));
            System.out.println("\n-------------------------------------\n");
        } else {
            System.out.println("\n### ERROR ### \nDados inválidos para realizar esta operação\n");
        }
        
        
        
    }

    public int finderReg(int search){

        if (getRegistro() == search){
            return search;
        } else {
            return -1;
        }
    }

    public boolean finderName(String nome){
        boolean encontrado = false;
        if (worker.getName().charAt(0) == nome.charAt(0)){
            if (worker.getName().charAt(1) == nome.charAt(1)){
                if (worker.getName().charAt(2) == nome.charAt(2)){
                    System.out.println("\n*************************************");
                    System.out.println("        FUNCIONÁRIO LOCALIZADO       ");
                    System.out.println("*************************************\n");
                    System.out.println("REGISTRO: " + this.registro);
                    worker.showWorker();
                    System.out.println("\n*************************************\n");
                    encontrado = true;

                }
            }
        } 
        return encontrado;
    }


}
