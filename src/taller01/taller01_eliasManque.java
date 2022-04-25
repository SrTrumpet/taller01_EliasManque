package Taller01;

import java.io.File;
import java.util.Scanner;

public class taller01_eliasManque {
    public static void main(String[] args) throws Exception {
        /////////////////////////////////////////////// Lectura archivo Clientes
        Scanner leer = new Scanner(System.in);
        File archCliente = new File("Clientes.txt");
        Scanner arch = new Scanner(archCliente);
        while (arch.hasNext()){
            String [] partes = arch.next().split(",");
            String User = partes[0], Pass = partes[1];
            int saldo = Integer.parseInt(partes[2]);
            String Email = partes[3];
        }
    }
    
}
