package taller01;

import java.io.*;
import java.util.*;

public class taller01_eliasManque {
    
    ////////////////////////////////////////////////////////////////Lectura de archivo int

    public static int[] pasoTXTaListaint (File archCliente, int[] lista, int index) throws Exception{
        Scanner arch = new Scanner(archCliente);
        for (int i = 0; i < lista.length; i++){
            String linea = arch.nextLine();
            String partes[] = linea.split(",");
            int valor = Integer.parseInt(partes[index]);
            lista[i] = valor;
        }
        return lista;
    }
    ////////////////////////////////////////////////////////////////Lectura de archivo STR

    public static String[] pasoTXTaListaStr (File archCliente, String[] lista, int index) throws Exception{
        Scanner arch = new Scanner(archCliente);
        for (int i = 0; i < lista.length; i++){
            String linea = arch.nextLine();
            String partes[] = linea.split(",");
            String valor = partes[index];
            lista[i] = valor;
        }
        return lista;
    }
    ////////////////////////////////////////////////////////////////Conteo de Lineas del Arch

    public static int conteoLineas(File archivoConteo) throws FileNotFoundException{
        Scanner arch = new Scanner(archivoConteo);
        int conteo = 0;
        while(arch.hasNext()){
            String partes [] = arch.next().split(",");
            conteo++;
        }
        return conteo;
    }
    ////////////////////////////////////////////////////////////////Int Respuesta Opciones

    public static int opcion(){
        return 0;
    }
    ////////////////////////////////////////////////////////////////Inicio Sesion

    public static void inicioSesion(Scanner leer,String user, String pass, String[] personas){
        System.out.println("Bienvenido");
        System.out.println("Ingrese su nombre de Usuario y Contraseña");
        user = leer.next();


        

    }
    ////////////////////////////////////////////////////////////////Boolean para detener el while del main

    public static boolean detener(){
        Scanner leer = new Scanner(System.in);
        String respuesta;
        System.out.println("Desea iniciar nuevamente el programa? SI/NO ");
        respuesta = leer.next();
        respuesta = respuesta.toUpperCase();
        while(!respuesta.equals("SI") && !respuesta.equals("NO")){
            System.out.println("Ingrese una opcion valida!");
            System.out.println("Desea iniciar nuevamente el programa? SI/NO ");
            respuesta = leer.next();
            respuesta = respuesta.toUpperCase();
        }if (respuesta.equals("SI")){
            return true;
        }else{
            return false;
        }
    }
    ////////////////////////////////////////////////////////////////Mostrar Catalogo de Stock

    public static void mostrarCAtalogo(File archProductos) throws Exception{
        @SuppressWarnings("resource") // Se usa solo para retirar el aviso del Scanner
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
        // Arch Clientes
        File archClientes = new File("Clientes.txt");

        //Inicializacion de Variables
        boolean vueltaWhile = true;
        int tamañoArch = conteoLineas(archClientes);
        String user = " ", pass = " ";

        //Variables para Arch Cliente
        String usuario[] = new String[tamañoArch];
        String password[] = new String[tamañoArch];
        int saldo[] = new int[tamañoArch];

        usuario = pasoTXTaListaStr(archClientes, usuario, 0);
        password = pasoTXTaListaStr(archClientes, password, 1);
        saldo = pasoTXTaListaint(archClientes,saldo,2);

        //Inicializar Scanner
        Scanner leer = new Scanner(System.in);

        //Ingreso While
        while(vueltaWhile){
            inicioSesion(leer,user,pass,usuario);
            vueltaWhile = detener();
        }
    }
}
