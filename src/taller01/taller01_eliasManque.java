package taller01;

import java.io.*;
import java.util.*;

public class taller01_eliasManque {
    

    // Arch Clientes
    public static File archClientes = new File("Clientes.txt");
    // Arch Productos
    public static File archProductos = new File("Productos.txt");
    // Arch Ventas
    public static File arhVentas = new File("Ventas.txt");

    public static int tamañoArch;
    public static int tamañoArchProductos;
    public static int tamañoArchVentas;
    
    public static String productosStock [];
    public static int precioProducto[];
    public static int unidadesDisponibles[];



    ////////////////////////////////////////////////////////////////Admin

    public static void admin(Scanner leer, String[] nombProductosVendidos, int [] vecesVendidos, File productos, 
                            String[] nomProductos, int[] totalStock, int[] precio) throws Exception{

        int opcion;
        boolean ciclo = true;
        int tamAnteriorProducto = tamañoArchProductos;
        int tamAnteriorCliente = tamañoArch;

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
                """);
            opcion = leer.nextInt();

            if (opcion == 1){

            }
            else if (opcion == 2){
                ventas(nombProductosVendidos,vecesVendidos);
            }
            else if (opcion == 3){
                agregarProducto(leer, productos);
            }
            else if (opcion == 4){
                addStock(leer,nomProductos,totalStock,precio);
            }
            else if (opcion == 5){
                if(tamAnteriorProducto < precioProducto.length){
                    txt.añadirATxtProductos(archProductos, productosStock, precioProducto, unidadesDisponibles);
                }
                
            }else{
                System.out.println("Opcion no valida!");
            }
        }
    }
    ////////////////////////////////////////////////////////////////USUARIO

    public static void userMenu (String usuario, Scanner leer, File productos, int[] saldo, String[] pass, File clientes, int indice) throws Exception{
        System.out.println("Bienvenido [%s]".formatted(usuario));
        System.out.println("");
        System.out.println("#####################");
        boolean confirmacionWhile = true;
        int opcion;
        String password = pass[indice];
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
                        pass = cambiaContraseña(leer,pass,indice,password);
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

    public static void ventas(String[] nomProductos, int[] vecesVendidos){
        System.out.println("");
        System.out.println("Nombre Producto | Veces vendido");
        for (int i = 0; i< nomProductos.length;i++){
            System.out.println("#################");
            System.out.println(nomProductos[i]+":    "+vecesVendidos[i]);
        }
    }
    ////////////////////////////////////////////////////////////////Agregar Stock

    public static void addStock(Scanner leer, String [] productosNombre, int [] stockProducto, int [] precio) throws Exception {
        
        //aer borrrar = new aer();
        String ruta = archProductos.getAbsolutePath();
        System.out.println("Ingrese el nombre del producto");
        leer.nextLine();
        String nameProducto = leer.nextLine();
        
        int indice=0;

        boolean encontrado = false;

        for (int i = 0; i < productosNombre.length; i++){
            if(nameProducto.equals(productosNombre[i])){
                indice = i;
                encontrado = true;
                txt.borrar(ruta);
                break;
            }
        }
        if (encontrado){

            System.out.println("Ingrese el stock que desea añadir: ");
            int stock = leer.nextInt();
            int sumaStock = unidadesDisponibles[indice] + stock;
            unidadesDisponibles[indice] = sumaStock;
            
            txt.añadirATxtProductos(archProductos, productosStock, precioProducto, unidadesDisponibles);
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
        /** 
        BufferedWriter archProductosNuevo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(productos, true)));
        archProductosNuevo.write("\r"+nomProducto+","+precio+","+stock);
        archProductosNuevo.close();
*/
        tamañoArchProductos++;

        productosStock = new String[tamañoArchProductos];
        precioProducto = new int[tamañoArchProductos];
        unidadesDisponibles = new int[tamañoArchProductos];
        System.out.println(productosStock.length);
        System.out.println(precioProducto.length);
        System.out.println(unidadesDisponibles.length);

        productosStock = pasoTXTSts(archProductos,productosStock,0);
        System.out.println(Arrays.toString(productosStock));
        precioProducto = pasoTXTInt(archProductos,precioProducto,1);
        unidadesDisponibles = pasoTXTInt(archProductos,unidadesDisponibles,2);

        productosStock[tamañoArchProductos-1] = nomProducto;
        precioProducto[tamañoArchProductos-1] = precio;
        unidadesDisponibles[tamañoArchProductos-1] = stock;

        System.out.println(Arrays.toString(productosStock));


            
        System.out.println(Arrays.toString(productosStock));

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
    public static String[] pasoTXTSts (File archCliente, String[] lista, int index) throws Exception{
        @SuppressWarnings("resource")
        Scanner arch = new Scanner(archCliente);
        for (int i = 0; i < lista.length-1; i++){
            String linea = arch.nextLine();
            String partes[] = linea.split(",");
            String valor = partes[index];
            lista[i] = valor;
        }
        return lista;
    }
    ////////////////////////////////////////////////////////////////Conteo de Lineas del Arch
    public static int[] pasoTXTInt (File archCliente, int[] lista, int index) throws Exception{
        @SuppressWarnings("resource")
        Scanner arch = new Scanner(archCliente);
        for (int i = 0; i < lista.length-1; i++){
            String linea = arch.nextLine();
            String partes[] = linea.split(",");
            int valor = Integer.parseInt(partes[index]);
            lista[i] = valor;
        }
        return lista;
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

    public static void inicioSesion(Scanner leer  , String[] personas, String[] password             , int [] saldo        , 
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
                    admin(leer,nombProductosVendidos,vecesVendidos,productos,nomProductos,stockProducto, precio);
                    break;
                }else{
                    System.out.println("Contraseña incorrecta!");
                    validarWhile = detener();
                }
            }else{
            for (int i = 0; i < personas.length; i++){
                if (user.equals(personas[i])){
                    encontrado = true;
                    System.out.println("Ingrese su Contraseña");
                    pass = leer.next();
                    if (pass.equals(password[i])){
                        System.out.println("################");
                        System.out.println(" ");
                        indice = i;
                        userMenu(user, leer, productos, saldo, password, clientes, indice);
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

    public static String[] cambiaContraseña(Scanner leer, String pass[], int indice, String bPass){
        boolean valorTrue = true;
        String contra;
        String anteriorContra;
        System.out.println("Ingrese su contraseña anterior ");
        while(valorTrue){
            anteriorContra = leer.next();
            if (anteriorContra.equals(bPass)){
                System.out.println("Ingrese su nueva contraseña (Contraseña menor a 10 caracteres) ");
                while (valorTrue){
                    contra = leer.next();
                    if (contra.length() > 0 && contra.length() <= 10){
                        pass[indice] = contra;
                        valorTrue = false;
                        System.out.println("Nueva Contraseña Designada");
                    }else{
                        System.out.println("Contraseña no valida, intentalo nuevamente");
                        System.out.println("Ingrese su nueva contraseña (Contraseña menor a 10 caracteres) ");
                    }
                }
            }
            else{
                System.out.println("Contraseña no coincide con la anterior, intentalo nuevamente");
                System.out.println("Ingrese su contraseña anterior ");
            }
        }
    return pass;
    }

        //////////////////////////////////////////////////////////////// main
    public static void main(String[] args) throws Exception {
        

        //Inicializacion de Variables
        boolean vueltaWhile = true;
        tamañoArch = conteoLineas(archClientes);
        tamañoArchProductos = conteoLineas(archProductos);
        tamañoArchVentas = conteoLineas(arhVentas);

        //Variables para Arch Ventas
        String productosVentas [] = new String[tamañoArchVentas];
        int unidadesVendidas [] = new int[tamañoArchVentas];

        productosVentas = pasoTXTaListaStr(arhVentas, productosVentas, 0);
        unidadesVendidas = pasoTXTaListaint(arhVentas, unidadesVendidas, 1);

        //Variables para Arch Productos
        productosStock = new String[tamañoArchProductos];
        precioProducto = new int[tamañoArchProductos];
        unidadesDisponibles = new int[tamañoArchProductos];

        productosStock = pasoTXTaListaStr(archProductos,productosStock,0);
        precioProducto = pasoTXTaListaint(archProductos,precioProducto,1);
        unidadesDisponibles = pasoTXTaListaint(archProductos,unidadesDisponibles,2);

        //Variables para Arch Cliente
        String usuario [] = new String[tamañoArch];
        String password [] = new String[tamañoArch];
        int saldo [] = new int[tamañoArch];

        usuario = pasoTXTaListaStr(archClientes, usuario, 0);
        password = pasoTXTaListaStr(archClientes, password, 1);
        saldo = pasoTXTaListaint(archClientes,saldo,2);

        //Inicializar Scanner
        Scanner leer = new Scanner(System.in);

        //Ingreso While
        while(vueltaWhile){
            //mostrarCAtalogo(archProductos);
            inicioSesion(leer,usuario,password,saldo,archProductos,archClientes,productosVentas,unidadesVendidas,
                        productosStock,unidadesDisponibles,precioProducto);
            vueltaWhile = detener();
        }
    }
}
