package taller01;

import java.io.*;
import java.util.*;

public class taller01_eliasManque {
    
    ////////////////////////////////////////////////////////////////Admin

    public static void admin(Scanner leer){


    }
    ////////////////////////////////////////////////////////////////USUARIO

    public static void userMenu (String usuario, Scanner leer){
        System.out.println("Bienvenido [%s]".formatted(usuario));
        System.out.println("");
        System.out.println("#####################");
        boolean confirmacionWhile = true;
        int opcion;
        while(confirmacionWhile){
            System.out.println("""
                Ingresa tu opcion: 
                1)Elige un Producto
                2)Cambia tu contraseña
                3)Ver catalogo de Productos
                4)Ver tu Saldo [USD]
                5)Recargar Saldo
                6)Ver Carrito
                7)Quitar productos del Carrito
                8)Pagar Carrito
                9)Cerrar Sesion
                """);
                System.out.print("===> ");
                opcion = leer.nextInt();
                if (opcion >= 1 && opcion<=9){
                    if(opcion == 1){}
                    if(opcion == 2){}
                    if(opcion == 3){}
                    if(opcion == 4){}
                    if(opcion == 5){}
                    if(opcion == 6){}
                    if(opcion == 7){}
                    if(opcion == 8){}
                    if(opcion == 9){
                        confirmacionWhile = false;
                    }
                }else{
                    System.out.println("Opcion no Valida! intenta denuevo");
                }

        }
    }
    ////////////////////////////////////////////////////////////////Lectura de archivo int

    public static int[] pasoTXTaListaint (File archCliente, int[] lista, int index) throws Exception{
        @SuppressWarnings("resource")
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
        @SuppressWarnings("resource")
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
        @SuppressWarnings("resource")
        Scanner arch = new Scanner(archivoConteo);
        int conteo = 0;
        while(arch.hasNext()){
            arch.next().split(",");
            conteo++;
        }
        return conteo;
    }
    ////////////////////////////////////////////////////////////////Int Respuesta Opciones

    public static int opcion(){
        return 0;
    }
    ////////////////////////////////////////////////////////////////Registro

    public static void Registro(){
        
    }
    ////////////////////////////////////////////////////////////////Inicio Sesion

    public static void inicioSesion(Scanner leer, String[] personas, String[] password){
        String user;
        String pass;
        boolean validarWhile = true;
        boolean encontrado = false;
        System.out.println("################");
        System.out.println("");
        System.out.println("Bienvenido");
        System.out.println("");
        System.out.println("################");
        while (validarWhile){
            System.out.println("Ingrese su nombre de Usuario");
            user = leer.next();
            for (int i = 0; i < personas.length; i++){
                if (user.equals(personas[i]) || user.equals("ADMIN")){
                    encontrado = true;
                    System.out.println("Ingrese su Contraseña");
                    pass = leer.next();
                    if (pass.equals("NYAXIO")){
                        admin(leer);
                        validarWhile = false;
                    }else if (pass.equals(password[i])){
                        userMenu(user,leer);
                        validarWhile = false;
                    }else{
                        System.out.println("Contraseña incorrecta!");
                        validarWhile = detener();
                    }
                }
            }
            if (!encontrado){
                validarWhile = false;
            }
        }
        if (!encontrado) {
            System.out.println("Usuario no encontrado");
            Registro();
        }
    }
    ////////////////////////////////////////////////////////////////Boolean para detener el while del main

    public static boolean detener(){
        @SuppressWarnings("resource")
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
        // Arch Productos
        File archProductos = new File("Productos.txt");
        // Arch Ventas
        File arhVentas = new File("Ventas.txt");

        //Inicializacion de Variables
        boolean vueltaWhile = true;
        int tamañoArch = conteoLineas(archClientes);

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
            //mostrarCAtalogo(archProductos);
            inicioSesion(leer,usuario,password);
            vueltaWhile = detener();
        }
    }
}
