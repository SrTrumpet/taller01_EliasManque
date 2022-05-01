package taller01;

import java.io.File;
import java.util.Scanner;

public class taller01_eliasManque {
    

    ////////////////////////////////////////////////////////////////Lectura de archivo

    public static int[] pasoTXTaLista (File archCliente) throws Exception{
        return null;
        
    }
    ////////////////////////////////////////////////////////////////Conteo de Lineas del Arch

    public static int conteoLineas(File archivoConteo){
        return 0;
    }
    ////////////////////////////////////////////////////////////////Mostrar Catalogo de Stock

    public static void mostrarCAtalogo(File archProductos) throws Exception{
        Scanner arch = new Scanner(archProductos);
        System.out.println("############################");
        System.out.println(" ");
        System.out.println("Lista de Productos en Stock: ");
        System.out.println(" ");
        while (arch.hasNextLine()){
            String linea = arch.nextLine();
            String partes[] = linea.split(",");
            //Definiendo partes para mostrarlas por pantalla
            String  producto    = partes[0],
                    precio      = partes[1],
                    unidadesDis = partes[2];
            //Salida por Pantalla
            System.out.print("""
                    ############################
                    Producto : %s
                    Precio   : $%s USD
                    Unidades : %s
                    """.formatted(producto,precio,unidadesDis));
        }
    }






    public static void main(String[] args) throws Exception {
        
        //Inicializacion de Variables
        //Arch Productos
        File productos = new File("Productos.txt");
        mostrarCAtalogo(productos);





    }
}
