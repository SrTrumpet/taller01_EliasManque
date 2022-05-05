package Taller01;

import java.io.*;

public class txt {

    
    public static void borrar(String ruta) throws IOException{
        File arch = new File(ruta);
        arch.delete();
        File archProducto = new File(ruta);
    }
    public static void añadirATxtProductos(File productos, String [] nomProductos, int[] precio, int[] stock) throws IOException{
        String ruta = productos.getAbsolutePath();
        FileWriter arch = new FileWriter(ruta);
        
        int ultimaLinea = 0;
        ultimaLinea = nomProductos.length - 1;

        for (int i = 0; i < nomProductos.length; i++){
            
            if (ultimaLinea == i){
                arch.write(nomProductos[i]+","+precio[i]+","+stock[i]);
            }else{
                arch.write(nomProductos[i]+","+precio[i]+","+stock[i]+"\n");
            }
        }
        arch.close();
        }
        public static void añadirATxtClientes(File clientes, String [] nomClientes, String[] password, int[] slado, String[] correos) throws IOException{
            String ruta = clientes.getAbsolutePath();
            FileWriter arch = new FileWriter(ruta);
            
            int ultimaLinea = 0;
            ultimaLinea = nomClientes.length - 1;
    
            for (int i = 0; i < nomClientes.length; i++){
                
                if (ultimaLinea == i){
                    arch.write(nomClientes[i]+","+password[i]+","+slado[i]+","+correos[i]);
                }else{
                    arch.write(nomClientes[i]+","+password[i]+","+slado[i]+","+correos[i]+"\n");
                }
            }
            arch.close();
            }
    }

