package Taller01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class taller01_eliasManque {

    /////////////////////////////////////////////// Lectura archivo Productos
    public static String[] productos(File arch) throws FileNotFoundException{
        String[] stock;
        Scanner leerArch = new Scanner(arch);
        int veces = 0;
        while(leerArch.hasNext()){
            String[] partes = leerArch.next().split(",");
            String producto = partes[0];
            System.out.println(producto);
            veces++;
        }
        System.out.println(veces);
        return null;
        
    }

    public static void main(String[] args) throws Exception {
        /////////////////////////////////////////////// Lectura archivo Clientes
        Scanner leer = new Scanner(System.in);
        File archCliente = new File("Clientes.txt");
        File archProducto = new File("Productos.txt");
        Scanner arch = new Scanner(archCliente);
        int contador = 0;
        String[] productosStock;

        while (arch.hasNext()){
            String [] partes = arch.next().split(",");
            String User = partes[0], Pass = partes[1];
            int saldo = Integer.parseInt(partes[2]);
            String Email = partes[3];

            contador++;
        }
        productos(archProducto);
    }
    
}
