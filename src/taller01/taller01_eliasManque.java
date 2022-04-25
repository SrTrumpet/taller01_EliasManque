package Taller01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class taller01_eliasManque {

    /////////////////////////////////////////////// Menu Admin
    public static void menuAdmin(){

    }
    /////////////////////////////////////////////// Menu Usuario
    public static void menuUser(){

    }
    /////////////////////////////////////////////// Busqueda Usuario
    public static void busquedaUser(String user, String pass) throws FileNotFoundException{

        File archCliente = new File("Clientes.txt");
        Scanner arch = new Scanner(archCliente);
        while(arch.hasNext()){
            String[] partes = arch.next().split(",");
            String usuario = partes[0], contrase = partes[1];
            if (user.equals(usuario)){
                System.out.println("Usuario encontrado");
                if(pass.equals(contrase)){
                    System.out.println("Acceso Correcto");
                }else{
                    System.out.println("Contraseña Incorrecta");
                }
            }
        }

    }
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

        boolean confirmacion = true;
        Scanner leer = new Scanner(System.in);

        while(confirmacion){
            System.out.print("Ingrese us usuario ===> ");
            String user = leer.next();
            System.out.print("Ingrese su contraseña ===> ");
            String pass = leer.next();
            busquedaUser(user,pass);
            System.out.print("Desea volver a inciar? SI/NO ==>  ");
            String opcion = leer.next();
            opcion = opcion.toUpperCase();
            if (opcion.equals("SI")){
                confirmacion = true;
            }else{
                confirmacion = false;
            }
        }
    }
}
