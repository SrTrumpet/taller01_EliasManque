package Taller01;

import java.io.*;
import java.util.*;

public class taller01_eliasManque {
    

    // Arch Clientes
    public static File archClientes = new File("Clientes.txt");
    // Arch Productos
    public static File archProductos = new File("Productos.txt");
    // Arch Ventas
    public static File arhVentas = new File("Ventas.txt");


    //Variable que nos sirven para darle tamaño a las listas que contendran los datos del arch txt
    public static int tamañoArch;//tamaño de lista usuario
    public static int tamañoArchProductos;//tamaño de lista producto
    public static int tamañoArchVentas;//tamaño de lista ventas
    

    //Listas dediacadas para el arch txt Productos
    public static String productosStock [];
    public static int precioProducto[];
    public static int unidadesDisponibles[];

    public static String productosStockaux [];
    public static int precioProductoaux[];
    public static int unidadesDisponiblesaux[];

    public static int tamañoFijoProductos;
    public static int tamAnteriorCliente ;


    //Listas dediacadas para el arch txt Clientes
    public static String usuario [];
    public static String usuarioAux[];
    public static String password [];
    public static String passwordAux[];
    public static int saldo [];
    public static int saldoAux[];
    public static String correos [];
    public static String correosAux[];

    //Listas dediacadas para el arch txt Ventas
    public static String productosVentas [];
    public static int unidadesVendidas [];



    ////////////////////////////////////////////////////////////////Admin
    //Procedimiento para el menu de admin

    public static void admin(Scanner leer, File productos, 
                            String[] nomProductos, int[] totalStock, int[] precio) throws Exception{

        int opcion;
        boolean ciclo = true;//Boolean que sirve para detener el while
        int tamAnteriorProducto = tamañoArchProductos;//variable para verificar si se hicieron cambios en el arch y asi actualizar los datos


        System.out.println("################");
        System.out.println("Bienvenido Admin");
        System.out.println("################");

        while(ciclo){
            System.out.println("""

                Opciones Disponibles
                1) Bloquear Usuario
                2) Ver Historial de Compras
                3) Agregar Producto
                4) Agregar Stock
                5) Actualizar Datos
                6) Actualizar Precios
                7) Salir

                """);
                System.out.print("Ingrese su opcion ===> ");
            opcion = leer.nextInt();

            if (opcion == 1){


            }
            else if (opcion == 2){
                ventas();
            }
            else if (opcion == 3){
                tamañoArchProductos++;
                agregarProducto(leer, productos);
                tamañoFijoProductos++;
            }
            else if (opcion == 4){
                addStock(leer);
            }
            else if (opcion == 5){
                if(tamAnteriorProducto < precioProducto.length){
                    txt.añadirATxtProductos(archProductos, productosStock, precioProducto, unidadesDisponibles);
                    tamañoFijoProductos = tamañoArchProductos;
                }
            }
            else if (opcion == 6){
                updatePrice(leer);
                System.out.println(Arrays.toString(precioProducto));
            }
            else if (opcion == 7){
                ciclo = false;
            }
            else{
                System.out.println("Opcion no valida!");
            }
        }
    }
    ////////////////////////////////////////////////////////////////USUARIO

    public static void userMenu (String usuarioEntrada, Scanner leer, File productos, String[] pass, File clientes, int indice) throws Exception{
        System.out.println("Bienvenido [%s]".formatted(usuarioEntrada));
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
                    if(opcion == 1){

                    }
                    if(opcion == 2){
                        cambiaContraseña(leer,indice);
                    }
                    if(opcion == 3){
                        mostrarCAtalogo(productos);
                    }
                    if(opcion == 4){
                        System.out.println("Tu saldo es: $"+saldo[indice]);
                    }
                    if(opcion == 5){
                        saldo = recargarSaldo(leer, saldo, indice);
                        System.out.println("Saldo recargado");
                    }
                    if(opcion == 6){}
                    if(opcion == 7){}
                    if(opcion == 8){}
                    if(opcion == 9){
                        txt.añadirATxtClientes(archClientes, usuario, password, saldo, correos);
                        confirmacionWhile = false;
                    }
                }else{
                    System.out.println("#####################");
                    System.out.println("Opcion no Valida! intenta denuevo");
                    System.out.println("#####################");
                }
        }
    }
    ////////////////////////////////////////////////////////////////Veces vendidos
    //Recibe la lista de los nombres de los productos
    public static void ventas(){
        System.out.println("");
        System.out.println("Nombre Producto | Veces vendido");
        for (int i = 0; i< productosVentas.length;i++){
            System.out.println("#################");
            System.out.println(productosVentas[i]+":    "+unidadesVendidas[i]);
        }
    }
    ////////////////////////////////////////////////////////////////Agregar Stock

    public static void addStock(Scanner leer) throws Exception {
        
        System.out.println("Ingrese el nombre del producto");
        leer.nextLine();
        String nameProducto = leer.nextLine();
        int canti = 0, suma;
        for (int i = 0; i < productosStock.length; i++){
            if(nameProducto.equals(productosStock[i])){
                System.out.println("Ingrese cuanto quiere agregar: ");
                canti = leer.nextInt();
                suma = canti + unidadesDisponibles[i];
                unidadesDisponibles[i] = suma;
                break;
            }
        }
    }
    ////////////////////////////////////////////////////////////////Agregar Producto

    public static void agregarProducto(Scanner leer, File productos) throws Exception{
        System.out.println("Ingrese el nombre del producto: ");
        String debugg = leer.nextLine();
        String nomProducto = leer.nextLine();
        System.out.println("Ingrse el precio (USD) del producto: ");
        int precio = leer.nextInt();
        System.out.println("Ingrese el stock: ");
        int stock = leer.nextInt();

        /////////////////////////
        productosStockaux = new String[tamañoFijoProductos - 1];
        productosStockaux = productosStock;
        /////////////////////////
        precioProductoaux = new int[tamañoFijoProductos - 1];
        precioProductoaux = precioProducto;
        /////////////////////////
        unidadesDisponiblesaux = new int[tamañoFijoProductos - 1];
        unidadesDisponiblesaux = unidadesDisponibles;
        /////////////////////////

        productosStock = new String[tamañoArchProductos];
        precioProducto = new int[tamañoArchProductos];
        unidadesDisponibles = new int[tamañoArchProductos];

        productosStock = pasoTXTSts(productosStockaux,productosStock);
        precioProducto = pasoTXTint(precioProductoaux,precioProducto);
        unidadesDisponibles = pasoTXTint(unidadesDisponiblesaux,unidadesDisponibles);

        productosStock[tamañoArchProductos-1] = nomProducto;
        precioProducto[tamañoArchProductos-1] = precio;
        unidadesDisponibles[tamañoArchProductos-1] = stock;
    }

    ////////////////////////////////////////////////////////////////Actualizar precio

    public static void updatePrice(Scanner leer) throws Exception {
        
        //aer borrrar = new aer();
        System.out.println("Ingrese el nombre del producto");
        leer.nextLine();
        String nameProducto = leer.nextLine();
        int nuevoPrecio = 0;
        for (int i = 0; i < productosStock.length; i++){
            if(nameProducto.equals(productosStock[i])){
                System.out.println("Ingrese el nuevo Precio: ");
                nuevoPrecio = leer.nextInt();
                precioProducto[i] = nuevoPrecio;
                break;
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
    public static String[] pasoTXTSts (String[] anterior, String[] listaNueva) throws Exception{
        
        for (int i = 0; i < anterior.length; i++){
            listaNueva[i] = anterior[i];
        }
        return listaNueva;
    }
    ////////////////////////////////////////////////////////////////Conteo de Lineas del Arch
    public static int[] pasoTXTint (int[] anterior, int[] listaNueva) throws Exception{
        
        for (int i = 0; i < anterior.length; i++){
            listaNueva[i] = anterior[i];
        }
        return listaNueva;
    }
    ////////////////////////////////////////////////////////////////Conteo de Lineas del Arch

    public static int conteoLineas(File archivoConteo) throws FileNotFoundException{
        @SuppressWarnings("resource")
        Scanner arch = new Scanner(archivoConteo);
        int conteo = 0;
        while(arch.hasNextLine()){
            arch.nextLine();
            conteo++;
        }
        return conteo;
    }

    ////////////////////////////////////////////////////////////////Registro

    public static void Registro(Scanner leer, File archCliente) throws IOException{

        System.out.println("#####################");
        System.out.println("Registro: ");
        System.out.println("#####################");
        boolean finCiclo = true;
        String contra =" ", user, correo;
        System.out.println("Cree su combre de usuario: ");
        user = leer.next();
        System.out.println("Cree su contraseña (Maximo 10 caracteres)");

        while(finCiclo){
            contra = leer.next();
            if (contra.length() > 0 && contra.length() <= 10){
                System.out.println("Contraseña Designada");
                finCiclo = false;
            }else{
                System.out.println("Contraseña no valida ingrese una nuevamente!!");
                System.out.println("Cree su contraseña (Maximo 10 caracteres)");
            }
        }
        BufferedWriter addUSer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archCliente,true)));
        System.out.println("Por ultimo ingrese su correo electronico: ");
        correo = leer.next();
        addUSer.write("\n");
        addUSer.write(user + "," + contra  + ",0," + correo );
        addUSer.close();
    }
    ////////////////////////////////////////////////////////////////Inicio Sesion

    public static void inicioSesion(Scanner leer  , String[] password             , 
                                    File productos, File clientes    , String[] nombProductosVendidos, int [] vecesVendidos,
                                    String [] nomProductos           , int[] stockProducto           , int [] precio) throws Exception{
        String user;
        String pass;
        boolean validarWhile = true;
        boolean encontrado = false;
        int indice = 0;
        System.out.println("################");
        System.out.println("");
        System.out.println("Bienvenido");
        System.out.println("");
        System.out.println("################");
        while (validarWhile){
            System.out.println("Ingrese su nombre de Usuario");
            user = leer.next();
            if(user.equals("ADMIN")){
                System.out.println("Ingrese su Contraseña");
                    pass = leer.next();
                if(pass.equals("NYAXIO")){
                    encontrado = true;
                    admin(leer,productos,nomProductos,stockProducto, precio);
                    break;
                }else{
                    System.out.println("Contraseña incorrecta!");
                    validarWhile = detener();
                }
            }else{
            for (int i = 0; i < usuario.length; i++){
                if (user.equals(usuario[i])){
                    encontrado = true;
                    System.out.println("Ingrese su Contraseña");
                    pass = leer.next();
                    if (pass.equals(password[i])){
                        System.out.println("################");
                        System.out.println(" ");
                        indice = i;
                        userMenu(user, leer, productos, password, clientes, indice);
                        validarWhile = false;
                    }else{
                        System.out.println("Contraseña incorrecta!");
                        validarWhile = detener();
                    }
                }
            }
        }
            if (!encontrado){
                validarWhile = false;
            }
        }
        if (!encontrado) {
            System.out.println("Usuario no encontrado");
            Registro(leer,clientes);
            System.out.println("Para hacer efectivo el Registro cierre el programa y vuelvalo a Abrir");
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
    ////////////////////////////////////////////////////////////////Recargar Saldo

    public static int[] recargarSaldo (Scanner leer, int[] saldo,int indice){
        int agregar;
        System.out.println("Cuanto quiere recargar? ");
        agregar = leer.nextInt();
        saldo[indice] += agregar;
        return saldo;
    }
    ////////////////////////////////////////////////////////////////Cambiar contraseña

    public static void cambiaContraseña(Scanner leer,int indice){
        boolean valorTrue = true;
        String anteriorPASS="", nuevaContra = "";
        System.out.println(Arrays.toString(password));
        while(valorTrue){
            System.out.println("Ingrese su anterior contraseña: ");
            anteriorPASS = leer.next();
            if(anteriorPASS.equals(password[indice])){
                System.out.println("Ingrese la nueva contraseña (Menor a 10 carcateres) ");
                nuevaContra = leer.next();
                if(nuevaContra.length() > 0 && nuevaContra.length() <= 10){
                    password[indice] = nuevaContra;
                    System.out.println("Contraseña guardada ");
                    valorTrue = false;
                }else{
                    System.out.println("Contraseña no valida, intentalo denuevo");
                }
            }else{
                System.out.println("Contraseña no coincide con la anterior!!");
            }
        }
        System.out.println(Arrays.toString(password));
    }
        //////////////////////////////////////////////////////////////// main
    public static void main(String[] args) throws Exception {
        

        //Inicializacion de Variables
        boolean vueltaWhile = true;
        tamañoArch = conteoLineas(archClientes);
        tamañoArchProductos = conteoLineas(archProductos);
        tamañoArchVentas = conteoLineas(arhVentas);

        //Variables para Arch Ventas
        productosVentas = new String[tamañoArchVentas];
        unidadesVendidas = new int[tamañoArchVentas];

        productosVentas = pasoTXTaListaStr(arhVentas, productosVentas, 0);
        unidadesVendidas = pasoTXTaListaint(arhVentas, unidadesVendidas, 1);

        //Variables para Arch Productos
        productosStock = new String[tamañoArchProductos];
        precioProducto = new int[tamañoArchProductos];
        unidadesDisponibles = new int[tamañoArchProductos];

        tamañoFijoProductos = productosStock.length; 

        productosStock = pasoTXTaListaStr(archProductos,productosStock,0);
        precioProducto = pasoTXTaListaint(archProductos,precioProducto,1);
        unidadesDisponibles = pasoTXTaListaint(archProductos,unidadesDisponibles,2);

        //Variables para Arch Cliente
        usuario = new String[tamañoArch];
        password = new String[tamañoArch];
        saldo = new int[tamañoArch];
        correos = new String[tamañoArch];

        tamAnteriorCliente = usuario.length;

        usuario = pasoTXTaListaStr(archClientes, usuario, 0);
        password = pasoTXTaListaStr(archClientes, password, 1);
        saldo = pasoTXTaListaint(archClientes,saldo,2);
        correos = pasoTXTaListaStr(archClientes, correos, 3);

        //Inicializar Scanner
        Scanner leer = new Scanner(System.in);

        //Ingreso While
        while(vueltaWhile){
            //mostrarCAtalogo(archProductos);
            inicioSesion(leer,password,archProductos,archClientes,productosVentas,unidadesVendidas,
                        productosStock,unidadesDisponibles,precioProducto);
            vueltaWhile = detener();
        }
    }
}
