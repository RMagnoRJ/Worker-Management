package Services;

import java.util.Random;

public class Employee {
    
     private int registro;

    
    public Employee() {
    }

    public int getRegistro() {
        return registro;
    }
    
    public int addRegistro(){
        Random ram = new Random();

        int a = ram.nextInt(1,9);
        int b = ram.nextInt(1,9);
        int c = ram.nextInt(1,9);
        int d = ram.nextInt(1,9);
        
        String aa = String.valueOf(a);
        String bb = String.valueOf(b);
        String cc = String.valueOf(c);
        String dd = String.valueOf(d);
        
        int reg = Integer.parseInt(aa+bb+cc+dd);
        this.registro = reg;
        return this.registro;
    }
    
}
