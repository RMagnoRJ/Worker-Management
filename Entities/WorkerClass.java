package Entities;

import Enums.DepartmentLevel;
import Enums.WorkerLevel;

public class WorkerClass {
    
    private String name;

    private WorkerLevel level;
    
    private Double baseSalary;

    private DepartmentLevel department;

    private String cargo;
    


    // ===============================================================
    //                       CONSTRUTORES
    // ===============================================================

    
    public WorkerClass(String name, 
                WorkerLevel level, 
                String cargo, 
                Double baseSalary, 
                DepartmentLevel department) {
        this.name = name;
        this.level = level;
        this.cargo = cargo;
        this.baseSalary = baseSalary;
        this.department = department;
    }

 
    public WorkerClass(){

    }

    // ==================================================================
    //                      GETTERS E SETTERS
    // ==================================================================

    public String getName() {
        return name;
    }

    public WorkerLevel getLevel() {
        return level;
    }
   
    public Double getBaseSalary() {
        return baseSalary;
    }

     public DepartmentLevel getDepartment() {
        return department;
    }
   
    public String getCargo(){
        return cargo;
    }
        
    // =====================================================================
    //                              MÉTODOS
    // =====================================================================


    public void showWorker() {

        System.out.println("DEPARTAMENTO: " + getDepartment());
        System.out.println("NOME: " + getName().toUpperCase());
        System.out.println("NÍVEL: " + getLevel());
        System.out.println("CARGO: " + getCargo().toUpperCase());

    }

    public void cleanWorker(){
        this.name = "";
        this.level = null;
        this.cargo = "";
        this.baseSalary = 0.0;
        this.department = null;
        
    }

}
