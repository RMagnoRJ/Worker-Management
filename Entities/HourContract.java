package Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HourContract {
    
    
    private LocalDate data_contrato;

    private int dia;

    private int mes;

    private int ano;

    private DateTimeFormatter data_out = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Double valorDaHora;

    private Integer horas_trabalhadas;

    Scanner inn = new Scanner (System.in);

    

    // =====================================================================
    //                              CONSTRUTOR
    // =====================================================================

    public HourContract() {
    }


    // =====================================================================
    //                             GETs SETs
    // =====================================================================

    public LocalDate getData_contrato() {
        return data_contrato;
    }


    public int getDia() {
        return dia;
    }


    public int getMes() {
        return mes;
    }


    public int getAno() {
        return ano;
    }


    public Double getValorDaHora() {
        return valorDaHora;
    }


    public Integer getHoras_trabalhadas() {
        return horas_trabalhadas;
    }


     
    // =====================================================================
    //                              MÉTODOS
    // =====================================================================

    public Double valorDoContrato(){
        return horas_trabalhadas * valorDaHora;
    }
  
    public void Calendario() {
        
        System.out.print("DIA: ");
        this.dia = inn.nextInt(); inn.nextLine();
        System.out.print("\nEscolha o MÊS: \n"+
        "\n[1]  JANEIRO    [2]  FEVEREIRO    [3]  MARÇO \n" +
        "[4]  ABRIL      [5]  MAIO         [6]  JUNHO \n" +
        "[7]  JULHO      [8]  AGOSTO       [9]  SETEMBRO \n" +
        "[10] OUTUBRO    [11] NOVEMBRO     [12] DEZEMBRO \n" +
        "\n> ");
        this.mes = inn.nextInt(); inn.nextLine();
        System.out.print("\nANO: ");
        this.ano = inn.nextInt(); inn.nextLine();
        data_contrato = LocalDate.of(ano, mes, dia);
        System.out.println("\n\nDATA >>> " + this.data_contrato.format(data_out) + " <<<\n");
    }

    public void valorDaHora () {
        System.out.print("\nValor da hora R$ (0.00): \n"+
                         "> ");
        this.valorDaHora = inn.nextDouble(); inn.nextLine();
    }

    public void horasTrabalhadas() {
        System.out.print("\nDuração do contrato (horas): \n"+
                         "> ");
        this.horas_trabalhadas = inn.nextInt(); inn.nextLine();
        int dia = 0;
        int total = this.horas_trabalhadas;
        while (total >= 8) {
            total = total - 8;
            dia = dia + 1;
        } 
        System.out.println("\n" +
        "DIAS: " + dia +
        "\nHORAS: " + total);
    }


    public String Calendar(int mes){
        String mes_do_ano = "";

        if (mes == 1) {
            mes_do_ano = "JANEIRO";
        } else if (mes == 2) {
            mes_do_ano = "FEVEREIRO";
        } else if (mes == 3) {
            mes_do_ano = "MARÇO";
        } else if (mes == 4) {
            mes_do_ano = "ABRIL";
        } else if (mes == 5) {
            mes_do_ano = "MAIO";
        } else if (mes == 6) {
            mes_do_ano = "JUNHO";
        } else if (mes == 7) {
            mes_do_ano = "JULHO";
        } else if (mes == 8) {
            mes_do_ano = "AGOSTO";
        } else if (mes == 9) {
            mes_do_ano = "SETEMBRO";
        } else if (mes == 10) {
            mes_do_ano = "OUTUBRO";
        } else if (mes == 11) {
            mes_do_ano = "NOVEMBRO";
        } else if (mes == 12) {
            mes_do_ano = "DEZEMBRO";
        }
        return mes_do_ano;
    }
    
    public void Conversor(int horas){
        int dia = 0;
        int total = horas;

        while (total >= 8) {
        total = total - 8;
        dia = dia + 1;
        } 
        System.out.println("\n\t>>> DURAÇÃO <<<\n");
        System.out.println("DIAS: " + dia + "  ||  HORAS: " + total);
    }

    public void showContract(){

        System.out.println("DATA: " + getData_contrato().format(data_out));
        System.out.println("VALOR DA HORA (R$): " + getValorDaHora());
        Conversor(getHoras_trabalhadas());
        System.out.print("\nPressione qualquer tecla para continuar >>>   ");
        @SuppressWarnings("unused")
        String wait = inn.nextLine(); 
        System.out.println("\n-------------------------------------\n");

    }

    public void escolheContrato () {

        System.out.println("DATA: " + getData_contrato().format(data_out));
        System.out.println("VALOR DA HORA (R$): " + getValorDaHora());
        Conversor(getHoras_trabalhadas());
        

    }


}
