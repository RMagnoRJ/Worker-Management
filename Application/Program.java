package Application;

import java.util.Locale;
import java.util.Scanner;

import Entities.CadastroGeral;
import Entities.CadastroWorker;
import Entities.HourContract;
import Entities.WorkerClass;
import Enums.DepartmentLevel;
import Enums.WorkerLevel;
import Services.Employee;

public class Program {
    
    public static void main(String[] args) {
        
        
        System.out.println();
        System.out.println();
        System.out.println("\n");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("                     Worker v 2.0                    ");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("\n");

        Scanner inn = new Scanner (System.in);
        Locale.setDefault(Locale.US);
        WorkerClass worker = new WorkerClass();
        CadastroGeral cad_Geral = new CadastroGeral();
        CadastroWorker cadContrato = new CadastroWorker();
        
        int num;
        int menu;
        boolean programa = true;
        while (programa){

            System.out.println("\n\t       ************");
            System.out.println("\t           MENU    ");
            System.out.println("\t       ************\n");
            System.out.print("\n[1] CADASTRAR NOVO FUNCIONÁRIO \n" +
                             "\n[2] INSERIR NOVO CONTRATO\n" +
                             "\n[3] BUSCAR RECEITA\n" +
                             "\n[4] BUSCAR REGISTRO DE FUNCIONÁRIO\n" +
                             "\n[5] DELETAR FUNCIONÁRIO\n" +
                             "\n[6] REMOVER CONTRATO\n" +
                             "\n[7] CADASTRO GERAL\n" +
                             "\n[8] SAIR\n" +
                             "\n> ");
            menu = inn.nextInt(); inn.nextLine();
            
            switch (menu) {
                case 1:
    // CADASTRAR NOVO FUNCIONÁRIO
                    cadContrato = new CadastroWorker();
                    Employee reg = new Employee();
                    System.out.println("\n********************************");
                    System.out.println("  CADASTRO DE NOVO FUNCIONÁRIO  ");
                    System.out.println("********************************\n");

                    boolean confirma = false;

                    while (confirma == false){
                        int regg = reg.addRegistro();
                        cadContrato.addRegistro(regg);
                        System.out.println("\nSelecione o departamento do funcionário: \n");
                        int con = 1;
                        for (DepartmentLevel level : DepartmentLevel.values()){
                            System.out.println("[" + con + "] " + level);
                            con+=1;
                        }
                        System.out.print("\n> ");
                        num = inn.nextInt(); inn.nextLine();

                        DepartmentLevel depart;
                        depart = DepartmentLevel.COMERCIAL;
                        if (num == 1){
                            depart = DepartmentLevel.COMERCIAL;
                        } else if (num == 2){
                            depart = DepartmentLevel.JURIDICO;
                        } else if (num == 3){
                            depart = DepartmentLevel.ADMINISTRATIVO;
                        } else if (num == 4){
                            depart = DepartmentLevel.FINANCEIRO;
                        } else if (num == 5){
                            depart = DepartmentLevel.TECNOLOGIA;
                        } else if (num == 6){
                            depart = DepartmentLevel.RH;
                        }   
                    
                        System.out.print("\nDigite o nome: ");
                        String workerName = inn.nextLine();

                        System.out.println("\nSelecione o nível do funcionário: \n");
                        con = 1;
                        for (WorkerLevel w : WorkerLevel.values()){
                            System.out.println("["+ con + "] " + w);
                            con+=1;
                        }
                        System.out.print("\n> ");
                        num = 0;
                        num = inn.nextInt(); inn.nextLine();
                        WorkerLevel work;
                        if (num == 1){
                            work = WorkerLevel.JUNIOR;
                        } else if (num == 2){
                            work = WorkerLevel.PLENO;
                        } else {
                            work = WorkerLevel.SENIOR;
                        }

                        System.out.print("\nDigite o cargo: ");
                        String cargo = inn.nextLine();

                        System.out.print("\nDigite o salário-base (R$ 0,00): ");
                        double baseSalary = inn.nextDouble(); inn.nextLine();


                        worker = new WorkerClass(
                            workerName,
                            work,
                            cargo,
                            baseSalary,
                            depart
                            );
                        cadContrato.addWorker(worker);

                        // CADASTRAR CONTRATO
                        boolean contrato = true;
                        int cont = 1;
                        //cadContrato = new CadastroWorker();
                        while (contrato){
                            
                            HourContract contract = new HourContract();
                            System.out.println("\n# " + cont + "º contrato: \n");
                            contract.Calendario();
                            contract.valorDaHora();
                            contract.horasTrabalhadas();
                            cadContrato.addContract(contract);
                            
                            System.out.print("\n\nDeseja cadastrar novo contrato? \n" +
                            "[1] SIM \n" +
                            "[2] NÃO \n" +
                            "> ");
                            int contt = inn.nextInt(); inn.nextLine();
                            if (contt == 2){
                                contrato = false;
                            } else {
                                System.out.println("\n-------------------------------------\n");
                                cont+=1;
                            }
                        }
                        cad_Geral.addCadastro(cadContrato);
                        
                        System.out.println();
                        for (int i = 0; i < cad_Geral.getCadGeral().size(); i++){
                            if (cad_Geral.getCadGeral().get(i).finderReg(regg) == regg){
                                cad_Geral.getCadGeral().get(i).showCadastroWorker();
                            } 
                        }
                        System.out.print("Confirma os dados digitados? \n" +
                        "[1] SIM \n" +
                        "[2] NÃO \n" +
                        "> ");
                        int grava = inn.nextInt(); inn.nextLine();
                        if (grava == 1){
                            confirma = true;
                        } else {
                            cad_Geral.renovarCadWorker(cadContrato);
                        }
                    }
                    System.out.println("\nDados gravados com sucesso!");
                    break;
            
                case 2:
    // CADASTRAR NOVO CONTRATO
                    System.out.println("\n***************************");
                    System.out.println("  CADASTRAR NOVO CONTRATO  ");
                    System.out.println("***************************\n");

                    boolean newcontract = true;

                    if (cad_Geral.getCadGeral().isEmpty()){
                        System.out.println("\n### ERROR ### \nNão há funcionários cadastrados!");
                        newcontract = false;
                        System.out.print("\nPressione qualquer tecla para continuar >>>   ");
                        @SuppressWarnings("unused")
                        String wait = inn.nextLine(); 

                    } else {
                       
                        while (newcontract == true) {

                            System.out.print("Digite o registro do funcionário: ");
                            int busca = inn.nextInt(); inn.nextLine();
                            boolean found = false;
                            for (int i = 0; i < cad_Geral.getCadGeral().size(); i++){
                                  
                                if (cad_Geral.getCadGeral().get(i).finderReg(busca) == busca){
                                    found = true;
                                    cad_Geral.getCadGeral().get(i).showCadWorker();
                                    boolean contrato = true;
                                    confirma = false;
                
                                    while (contrato == true){
                
                                        while (confirma == false){
                
                                            HourContract new_contract = new HourContract();
                                            System.out.println("\n>>> NOVO CONTRATO <<<\n");
                                            new_contract.Calendario();
                                            new_contract.valorDaHora();
                                            new_contract.horasTrabalhadas();
                                            cadContrato.addContract(new_contract);
                
                                            for (i = 0; i < cad_Geral.getCadGeral().size(); i++){
                                                if (cad_Geral.getCadGeral().get(i).finderReg(busca) == busca){
                                                    cad_Geral.getCadGeral().get(i).showNovoContrato();
                                                } 
                                            }
                                            System.out.print("Confirma os dados digitados? \n" +
                                            "[1] SIM \n" +
                                            "[2] NÃO \n" +
                                            "> ");
                                            int grava = inn.nextInt(); inn.nextLine();
                
                                            if (grava == 1){
                                                confirma = true;
                                            } else {
                                                for (i = 0; i < cad_Geral.getCadGeral().size(); i++){
                                                    if (cad_Geral.getCadGeral().get(i).finderReg(busca) == busca){
                                                        cad_Geral.getCadGeral().get(i).removeLastContract();
                                                    } 
                                                }
                                            }
                                        }
                                        
                                        System.out.print("\n\nDeseja cadastrar novo contrato? \n" +
                                        "[1] SIM \n" +
                                        "[2] NÃO \n" +
                                        "> ");
                                        int contt = inn.nextInt(); inn.nextLine();
                                        if (contt == 2){
                                            contrato = false;
                                            System.out.println("\nCadastro atualizado com sucesso!");
                                            newcontract = false;
                                            break;
                                        } else {
                                            contrato = true;
                                            confirma = false;
                                            System.out.println("\n-------------------------------------\n");
                                        }
                                    }
                                } 
                            }
                            if (found == false){
                            
                                System.out.println("\n### ERROR ### \nRegistro não encontrado\n\n");
                                System.out.print("Selecione uma opção: \n"+
                                "\n[1] TENTAR NOVAMENTE \n" +
                                "[2] VOLTAR AO MENU \n" +
                                "\n> ");
                                int op = inn.nextInt(); inn.nextLine();
                                if (op == 1){
                                    newcontract = true;
                                } else {
                                    newcontract = false;
                                    break;
                                }
                            }
                        } 
                    }
                    break;

                case 3:
    // BUSCAR RECEITA
                    System.out.println("\n***********************");
                    System.out.println("  RECEITA POR PERÍODO  ");
                    System.out.println("***********************\n");

                    newcontract = true;

                    if (cad_Geral.getCadGeral().isEmpty()){
                        System.out.println("\n### ERROR ### \nNão há funcionários cadastrados!");
                        newcontract = false;
                        System.out.print("\nPressione qualquer tecla para continuar >>>   ");
                        @SuppressWarnings("unused")
                        String wait = inn.nextLine(); 

                    } else {

                        while (newcontract == true) {
                            int busca;
                            boolean found = false;
                            System.out.print("Digite o registro do funcionário: ");
                            busca = inn.nextInt(); inn.nextLine();
                            
                            for (int i = 0; i < cad_Geral.getCadGeral().size(); i++){
    
                                if (cad_Geral.getCadGeral().get(i).finderReg(busca) == busca){
                                    found = true;
                                    cad_Geral.getCadGeral().get(i).showCadWorker();
                                    
                                    System.out.print("\n\nPara calcular a receita, digite o mês: \n"+
                                    "\n[1]  JANEIRO    [2]  FEVEREIRO    [3]  MARÇO \n" +
                                    "[4]  ABRIL      [5]  MAIO         [6]  JUNHO \n" +
                                    "[7]  JULHO      [8]  AGOSTO       [9]  SETEMBRO \n" +
                                    "[10] OUTUBRO    [11] NOVEMBRO     [12] DEZEMBRO \n" +
                                    "\n> ");
                                    int mes = inn.nextInt(); inn.nextLine();
                                    System.out.print("\nDigite o ano: \n"+
                                    "> ");
                                    int ano = inn.nextInt(); inn.nextLine();
                                    cad_Geral.getCadGeral().get(i).showReceita(ano, mes);
                                    
                                    int cal = 0;
                                    System.out.print("\nDeseja calcular nova receita? \n" +
                                    "[1] SIM \n" +
                                    "[2] NÃO \n" +
                                    "> ");
                                    cal = inn.nextInt(); inn.nextLine();
                                    if (cal == 1){
                                        newcontract = true;
                                    } else {
                                        newcontract = false;
                                        break;
                                    }
                                } 
                            }                                
                            if (found == false){
                                int op = 0;
                                System.out.println("\n### ERROR ### \nRegistro não encontrado\n\n");
                                System.out.print("Selecione uma opção: \n"+
                                "\n[1] TENTAR NOVAMENTE \n" +
                                "[2] VOLTAR AO MENU \n" +
                                "\n> ");
                                op = inn.nextInt(); inn.nextLine();
                                if (op == 1){
                                    newcontract = true;
                                    busca = 0;
                                } else {
                                    newcontract = false;
                                    break;
                                }
                            }
                        }
                    }
                    break;

                case 4:
    // BUSCAR REGISTRO DE FUNCIONÁRIO
                    boolean finder = true;
                    String nome;
                    System.out.println("\n**********************************");
                    System.out.println("  BUSCAR REGISTRO DE FUNCIONÁRIO  ");
                    System.out.println("**********************************\n");
                    
                    while (finder){
                        System.out.print("Digite as três ( 03 ) primeiras \nLETRAS do nome do funcionário: ");
                        nome = inn.nextLine();
                        while (nome.length() < 3){
                            System.out.println("\n**********************************\n");
                            System.out.println("\t### ERROR ###\n" + 
                            "\nVocê deve digitar no MÍNIMO \n03 (três) LETRAS!");
                            System.out.println("\n**********************************\n");
                            System.out.print("Digite as três ( 03 ) primeiras \nLETRAS do nome do funcionário: ");
                            nome = inn.nextLine();
                        }
                        cad_Geral.findNameWorker(nome);
                        System.out.print("\nSelecione uma opção: \n" +
                        "\n[1] REALIZAR NOVA BUSCA \n" +
                        "[2] VOLTAR AO MENU \n" +
                        "\n> ");
                        int contt = inn.nextInt(); inn.nextLine();
                        if (contt == 2){
                            finder = false;
                        } else {
                            System.out.println();
                        }
                    }
                    break;
                    
                case 5:
    // REMOVER FUNCIONÁRIO
                    System.out.println("\n***********************");
                    System.out.println("  DELETAR FUNCIONÁRIO  ");
                    System.out.println("***********************\n");
                    newcontract = true;

                    while (newcontract == true){
                        boolean found = false;
                        System.out.print("Digite o registro do funcionário: ");
                        int busca = inn.nextInt(); inn.nextLine();
                        
                        for (int i = 0; i < cad_Geral.getCadGeral().size(); i++){
    
                            if (cad_Geral.getCadGeral().get(i).finderReg(busca) == busca){
                                found = true;
                                cad_Geral.getCadGeral().get(i).showCadWorker();
                                System.out.print("Selecione uma opção: \n"+
                                "\n[1] CONFIRMAR FUNCIONÁRIO \n" +
                                "[2] DIGITAR NOVO REGISTRO \n" +
                                "\n> ");
                                int op = inn.nextInt(); inn.nextLine();

                                if (op == 1){
                                    cad_Geral.removerCadastroWorker(busca);
                                    System.out.println("\n-------------------------------------\n");
                                    System.out.println("Funcionário removido com sucesso!");
                                    System.out.println("\n-------------------------------------\n");
                                    newcontract = false;
                                    break;
                                } else {
                                    newcontract = true;
                                    break;
                                } 
                            }
                        }
                        if (found == false){
                            System.out.println("\n### ERROR ### \nRegistro não encontrado\n\n");
                            System.out.print("Selecione uma opção: \n"+
                            "\n[1] TENTAR NOVAMENTE \n" +
                            "[2] VOLTAR AO MENU \n" +
                            "\n> ");
                            int op = inn.nextInt(); inn.nextLine();
                            if (op == 1){
                                newcontract = true;
                            } else {
                                newcontract = false;
                                break;
                            }
                        }
                    }
                    break;

                case 6:
    // REMOVER CONTRATO
                    System.out.println("\n********************");
                    System.out.println("  REMOVER CONTRATO  ");
                    System.out.println("********************\n");
                    
                    newcontract = true;
                    
                    while (newcontract == true){
                        boolean found = false;
                        System.out.print("Digite o registro do funcionário: ");
                        int busca = inn.nextInt(); inn.nextLine();
                        
                        for (int i = 0; i < cad_Geral.getCadGeral().size(); i++){
    
                            if (cad_Geral.getCadGeral().get(i).finderReg(busca) == busca){
                                found = true;
                                cad_Geral.getCadGeral().get(i).showCadWorker();
                                System.out.print("Selecione uma opção: \n"+
                                "\n[1] CONFIRMAR FUNCIONÁRIO \n" +
                                "[2] DIGITAR NOVO REGISTRO \n" +
                                "\n> ");
                                int op = inn.nextInt(); inn.nextLine();

                                if (op == 1){
                                    cad_Geral.getCadGeral().get(i).removeContract();
                                    System.out.println("\n-------------------------------------\n");
                                    newcontract = false;
                                    break;
                                } else {
                                    newcontract = true;
                                }
    
                            } 
                        }
                        if (found == false){
                            System.out.println("\n### ERROR ### \nRegistro não encontrado\n\n");
                            System.out.print("Selecione uma opção: \n"+
                            "\n[1] TENTAR NOVAMENTE \n" +
                            "[2] VOLTAR AO MENU \n" +
                            "\n> ");
                            int op = inn.nextInt(); inn.nextLine();
                            if (op == 1){
                                newcontract = true;
                                break;
                            } else {
                                newcontract = false;
                                break;
                            }
                        }
                    }
                    break;

                case 7:
    // CADASTRO GERAL
                    System.out.println("\n******************");
                    System.out.println("  CADASTRO GERAL  ");
                    System.out.println("******************\n");
                    boolean continua = true;
                    while (continua){
                        cad_Geral.showCadastroGeral();
                        System.out.print("\n\nSelecione uma opção: \n" +
                        "\n[1] VER NOVAMENTE O CADASTRO GERAL \n" +
                        "[2] VOLTAR AO MENU \n" +
                        "\n> ");
                        int contt = inn.nextInt(); inn.nextLine();
                        if (contt == 2){
                            continua = false;
                        } 
                    }
                    break;

                case 8:
    // SAIR
                    programa = false;
                    break;

            }
            

            
            

        }
        
        
        
         System.out.println("\n\n");

        inn.close();



    }
}
