package isi.deso.tpdsw;

import java.sql.Statement;
import isi.deso.tpdsw.Services.ItemNoEncontradoException;
import isi.deso.tpdsw.Services.PredicateFactory;
import isi.deso.tpdsw.Daos.ItemsPedidoMemory;
import isi.deso.tpdsw.Models.Plato;
import isi.deso.tpdsw.Models.Pedido;
import isi.deso.tpdsw.Models.ItemPedido;
import isi.deso.tpdsw.Models.Coordenada;
import isi.deso.tpdsw.Models.EstadoPedido;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Models.TipoItem;
import isi.deso.tpdsw.Models.Cliente;
import isi.deso.tpdsw.Models.Bebida;
import isi.deso.tpdsw.Models.Categoria;
import isi.deso.tpdsw.Views.MenuJFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Iterator;
import java.util.function.Predicate;
import javax.swing.JFrame;


public class TPdsw { 
    
    public static void main(String[] args) throws Exception {

        MenuJFrame.main(args);

    } // -- CIERRE MAIN --
//
//    private static ArrayList<Pedido> filtrarPedidos(ArrayList<Pedido> pedidos){
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Como le gustaria filtrar? ");
//        System.out.println("Las opciones son: ID, NOMBRE, APTOVEGANO, CATEGORIA");
//        String entradaPredicado = scanner.nextLine().toLowerCase().strip();
//
//        System.out.println("Que valor le gustaria filtrar?: ");
//        String entradaValor = scanner.nextLine().toLowerCase().strip();
//        PredicateFactory predicado = new PredicateFactory();
//        Predicate<ItemPedido> pred1 = predicado.obtenerPredicado(entradaPredicado, entradaValor);
//
//        ItemsPedidoMemory ipm = new ItemsPedidoMemory();
//        ArrayList<Pedido> filtrados = new ArrayList<>();
//        ArrayList<ItemPedido> items_filtrados = new ArrayList<>();
//
//        for (Pedido p : pedidos) {
//            try{
//                items_filtrados = ipm.filtrarPedido(p, pred1);
//                filtrados.add(p);
//            }catch(ItemNoEncontradoException e){
//                continue;
//            }
//        }
//
//        if (filtrados.isEmpty()) { System.out.println("No hay pedidos"); }
//        else {
//                System.out.println("Los pedidos filtrados son");
//                for (Pedido p: filtrados) { System.out.println(p);  }
//            }
//        return filtrados;
//    }
//
//
//    private static void ingresarVendedores(Scanner scanner, ArrayList<Vendedor> vendedores){
//        System.out.println("Ingreso de vendedores: ");
//        for (int i = 0; i < 3; i++) {
//            Vendedor v = new Vendedor();
//            //Ingreso de datos por consola
//            System.out.print("Ingrese ID: ");
//            int idVendedor = scanner.nextInt();
//            scanner.nextLine(); // Consumir la nueva línea sobrante
//
//            System.out.print("Ingrese Nombre: ");
//            String nombreVendedor = scanner.nextLine();
//
//            System.out.print("Ingrese Direccion: ");
//            String direccionVendedor = scanner.nextLine();
//
//            System.out.print("Ingrese latitud: ");
//            double latitudVendedor = scanner.nextDouble();
//            scanner.nextLine(); // Consumir la nueva línea sobrante
//            System.out.print("Ingrese longitud: ");
//            double longitudVendedor = scanner.nextDouble();
//            scanner.nextLine(); // Consumir la nueva línea sobrante
//
//            //Se setean los valores y se arreglan a la coleccion
//            Coordenada coordenadasVendedor = new Coordenada();
//            coordenadasVendedor.setLat(latitudVendedor);
//            coordenadasVendedor.setLng(longitudVendedor);
//
//            v.setId(idVendedor);
//            v.setNombre(nombreVendedor);
//            v.setDireccion(direccionVendedor);
//            v.setCoordenadas(coordenadasVendedor);
//            vendedores.add(v);
//
//            System.out.println();
//        }
//    }
//
//    private static void ingresarClientes(Scanner scanner, ArrayList<Cliente> clientes){
//        System.out.println("Ingreso de clientes: ");
//        for (int i = 0; i < 3; i++) {
//            Cliente c = new Cliente();
//            //Ingreso de datos por consola
//            System.out.print("Ingrese ID: ");
//            int idCliente = scanner.nextInt();
//            scanner.nextLine();
//
//            System.out.print("Ingrese nombre: ");
//            String nombreCliente = scanner.nextLine();
//
//            System.out.print("Ingrese cuit: ");
//            String cuitCliente = scanner.nextLine();
//
//            System.out.print("Ingrese email: ");
//            String emailCliente = scanner.nextLine();
//
//            System.out.print("Ingrese Direccion: ");
//            String direccionCliente = scanner.nextLine();
//
//            System.out.print("Ingrese latitud: ");
//            double latitudCliente = scanner.nextDouble();
//            scanner.nextLine();
//            System.out.print("Ingrese longitud: ");
//            double longitudCliente = scanner.nextDouble();
//            scanner.nextLine();
//
//            //Se setean los valores y se arreglan a la coleccion
//            Coordenada coordenadasCliente = new Coordenada();
//            coordenadasCliente.setLat(latitudCliente);
//            coordenadasCliente.setLng(longitudCliente);
//
//            c.setId(idCliente);
//            c.setNombre(nombreCliente);
//            c.setCuit(cuitCliente);
//            c.setDireccion(direccionCliente);
//            c.setEmail(emailCliente);
//            c.setCoordenadas(coordenadasCliente);
//            clientes.add(c);
//
//            System.out.println();
//        }
//    }
//
//    private static void buscarVendedor(Scanner scanner, ArrayList<Vendedor> vendedores){
//        int opcion;
//        System.out.print("Ingrese 1 si desea buscar por nombre o 2 si desea buscar por id: ");
//        opcion = scanner.nextInt();
//        scanner.nextLine();
//
//        if(opcion == 1){
//            String nombre;
//            System.out.print("Ingrese el nombre del vendedor a buscar: ");
//            nombre = scanner.nextLine();
//            int i = 0;
//            boolean flag = false;
//
//            while(i<vendedores.size() && !flag){
//                if(nombre.equals(vendedores.get(i).getNombre())){
//                    System.out.println("Vendedor encontrado en la posicion " + (1 + i));
//                    flag = true;
//                }
//                i++;
//            }
//            if(!flag) System.out.println("El vendedor no fue encontrado");
//        }
//        else if(opcion == 2){
//            int id;
//            System.out.print("Ingrese el id del vendedor a buscar: ");
//            id = scanner.nextInt();
//            scanner.nextLine();
//            int i = 0;
//            boolean flag = false;
//
//            while(i<vendedores.size() && !flag){
//                if(vendedores.get(i).getId() == id){
//                    System.out.println("Vendedor encontrado en la posicion " + (1 + i));
//                    flag = true;
//                }
//                i++;
//            }
//            if(!flag) System.out.println("El vendedor no fue encontrado");
//        }
//        else System.out.println("Opcion invalida");
//    }
//
//    private static void buscarCliente(Scanner scanner, ArrayList<Cliente> clientes){
//        int opcion;
//        System.out.print("Ingrese 1 si desea buscar por nombre o 2 si desea buscar por id: ");
//        opcion = scanner.nextInt();
//        scanner.nextLine();
//
//        if(opcion == 1){
//            String nombre;
//            System.out.print("Ingrese el nombre del cliente a buscar: ");
//            nombre = scanner.nextLine();
//            int i = 0;
//            boolean flag = false;
//
//            while(i<clientes.size() && !flag){
//                if(nombre.equals(clientes.get(i).getNombre())){
//                    System.out.println("Cliente encontrado en la posicion " + (1 + i));
//                    flag = true;
//                }
//                i++;
//            }
//            if(!flag) System.out.println("El cliente no fue encontrado");
//        }
//        else if(opcion == 2){
//            int id;
//            System.out.print("Ingrese el id del cliente a buscar: ");
//            id = scanner.nextInt();
//            scanner.nextLine();
//            int i = 0;
//            boolean flag = false;
//
//            while(i<clientes.size() && !flag){
//                if(clientes.get(i).getId() == id){
//                    System.out.println("Cliente encontrado en la posicion " + (1 + i));
//                    flag = true;
//                }
//                i++;
//            }
//            if(!flag) System.out.println("El cliente no fue encontrado");
//        }
//        else System.out.println("Opcion invalida");
//    }
//
//    private static void eliminarVendedor(Scanner scanner, ArrayList<Vendedor> vendedores){
//        int pos;
//        System.out.print("Ingresar la posicion del vendedor a eliminar: ");
//        pos = scanner.nextInt();
//        pos--;
//        scanner.nextLine();
//        System.out.print("Listado de vendedores antes de la eliminacion: ");
//        mostrarVendedores(vendedores);
//        vendedores.remove(pos);
//        System.out.print("Listado de vendedores luego de la eliminacion: ");
//        mostrarVendedores(vendedores);
//    }
//
//    private static void eliminarCliente(Scanner scanner, ArrayList<Cliente> clientes){
//        int pos;
//        System.out.print("Ingresar la posicion del cliente a eliminar: ");
//        pos = scanner.nextInt();
//        pos--;
//        scanner.nextLine();
//        System.out.print("Listado de clientes antes de la eliminacion: ");
//        mostrarClientes(clientes);
//        clientes.remove(pos);
//        System.out.print("Listado de clientes luego de la eliminacion: ");
//        mostrarClientes(clientes);
//    }
//
//    private static void mostrarVendedores(ArrayList<Vendedor> lista){
//        Iterator<Vendedor> i = lista.iterator();
//        if(i.hasNext()){
//            Vendedor siguiente = i.next();
//            System.out.printf("(Id: %d, Nombre: %s)", siguiente.getId(), siguiente.getNombre());
//        }
//        while(i.hasNext()){
//            Vendedor siguiente = i.next();
//            System.out.printf(", (Id: %d, Nombre: %s)", siguiente.getId(), siguiente.getNombre());
//        }
//        System.out.println();
//    }
//    private static void mostrarClientes(ArrayList<Cliente> lista){
//        Iterator<Cliente> i = lista.iterator();
//        if(i.hasNext()){
//            Cliente siguiente = i.next();
//            System.out.printf("(Id: %d, Nombre: %s)", siguiente.getId(), siguiente.getNombre());
//        }
//        while(i.hasNext()){
//            Cliente siguiente = i.next();
//            System.out.printf(", (Id: %d, Nombre: %s)", siguiente.getId(), siguiente.getNombre());
//        }
//        System.out.println();
//    }
//
}
    