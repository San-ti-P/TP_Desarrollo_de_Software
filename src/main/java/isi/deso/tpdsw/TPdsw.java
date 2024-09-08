package isi.deso.tpdsw;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

public class TPdsw {
    
    public static void main(String[] args) {
        
        //Solucion Vendedores
        
        Scanner scanner = new Scanner(System.in); 
        ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
        ingresarVendedores(scanner, vendedores);
        buscarVendedor(scanner, vendedores);
        eliminarVendedor(scanner, vendedores);
                
        //Solucion Clientes
        
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ingresarClientes(scanner, clientes);
        buscarCliente(scanner, clientes);
        eliminarCliente(scanner, clientes);
        scanner.close();
        
        //Solucion calcular distancia
               
        Random rand = new Random();
        int posVendedor = rand.nextInt(vendedores.size());
        int posCliente = rand.nextInt(clientes.size());
        double distancia = vendedores.get(posVendedor).distancia(clientes.get(posCliente));
        System.out.printf("La distancia entre el vendedor %s y el cliente %s es %f km\n",vendedores.get(posVendedor).getNombre(),clientes.get(posCliente).getNombre(), distancia);
    }
    
    private static void ingresarVendedores(Scanner scanner, ArrayList<Vendedor> vendedores){
        System.out.println("Ingreso de vendedores: ");
        for (int i = 0; i < 3; i++) {
            Vendedor v = new Vendedor();
            //Ingreso de datos por consola
            System.out.print("Ingrese ID: ");
            int idVendedor = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea sobrante

            System.out.print("Ingrese Nombre: ");
            String nombreVendedor = scanner.nextLine();

            System.out.print("Ingrese Direccion: ");
            String direccionVendedor = scanner.nextLine();

            System.out.print("Ingrese latitud: ");
            double latitudVendedor = scanner.nextDouble();
            scanner.nextLine(); // Consumir la nueva línea sobrante
            System.out.print("Ingrese longitud: ");
            double longitudVendedor = scanner.nextDouble();
            scanner.nextLine(); // Consumir la nueva línea sobrante

            //Se setean los valores y se arreglan a la coleccion
            Coordenada coordenadasVendedor = new Coordenada();
            coordenadasVendedor.setLat(latitudVendedor);
            coordenadasVendedor.setLng(longitudVendedor);
            
            v.setId(idVendedor);
            v.setNombre(nombreVendedor);
            v.setDireccion(direccionVendedor);
            v.setCoordenadas(coordenadasVendedor);
            vendedores.add(v);

            System.out.println();
        }
    }
    
    private static void ingresarClientes(Scanner scanner, ArrayList<Cliente> clientes){
        System.out.println("Ingreso de clientes: ");
        for (int i = 0; i < 3; i++) {
            Cliente c = new Cliente();
            //Ingreso de datos por consola
            System.out.print("Ingrese ID: ");
            int idCliente = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ingrese nombre: ");
            String nombreCliente = scanner.nextLine();
            
            System.out.print("Ingrese cuit: ");
            String cuitCliente = scanner.nextLine();
            
            System.out.print("Ingrese email: ");
            String emailCliente = scanner.nextLine();

            System.out.print("Ingrese Direccion: ");
            String direccionCliente = scanner.nextLine();

            System.out.print("Ingrese latitud: ");
            double latitudCliente = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Ingrese longitud: ");
            double longitudCliente = scanner.nextDouble();
            scanner.nextLine();

            //Se setean los valores y se arreglan a la coleccion
            Coordenada coordenadasCliente = new Coordenada();
            coordenadasCliente.setLat(latitudCliente);
            coordenadasCliente.setLng(longitudCliente);
            
            c.setId(idCliente);
            c.setNombre(nombreCliente);
            c.setCuit(cuitCliente);
            c.setDireccion(direccionCliente);
            c.setEmail(emailCliente);
            c.setCoordenadas(coordenadasCliente);
            clientes.add(c);

            System.out.println();
        }
    }
    
    private static void buscarVendedor(Scanner scanner, ArrayList<Vendedor> vendedores){
        int opcion;
        System.out.print("Ingrese 1 si desea buscar por nombre o 2 si desea buscar por id: ");
        opcion = scanner.nextInt();
        scanner.nextLine();
        
        if(opcion == 1){
            String nombre;
            System.out.print("Ingrese el nombre del vendedor a buscar: ");
            nombre = scanner.nextLine();
            int i = 0;
            boolean flag = false;
            
            while(i<vendedores.size() && !flag){
                if(nombre.equals(vendedores.get(i).getNombre())){
                    System.out.println("Vendedor encontrado en la posicion " + (1 + i));
                    flag = true;
                }
                i++;
            }
            if(!flag) System.out.println("El vendedor no fue encontrado");
        }
        else if(opcion == 2){
            int id;
            System.out.print("Ingrese el id del vendedor a buscar: ");
            id = scanner.nextInt();
            scanner.nextLine();
            int i = 0;
            boolean flag = false;
            
            while(i<vendedores.size() && !flag){
                if(vendedores.get(i).getId() == id){
                    System.out.println("Vendedor encontrado en la posicion " + (1 + i));
                    flag = true;
                }
                i++;
            }
            if(!flag) System.out.println("El vendedor no fue encontrado");
        }
        else System.out.println("Opcion invalida");
    }
    
    private static void buscarCliente(Scanner scanner, ArrayList<Cliente> clientes){
        int opcion;
        System.out.print("Ingrese 1 si desea buscar por nombre o 2 si desea buscar por id: ");
        opcion = scanner.nextInt();
        scanner.nextLine();
        
        if(opcion == 1){
            String nombre;
            System.out.print("Ingrese el nombre del cliente a buscar: ");
            nombre = scanner.nextLine();
            int i = 0;
            boolean flag = false;
            
            while(i<clientes.size() && !flag){
                if(nombre.equals(clientes.get(i).getNombre())){
                    System.out.println("Cliente encontrado en la posicion " + (1 + i));
                    flag = true;
                }
                i++;
            }
            if(!flag) System.out.println("El cliente no fue encontrado");
        }
        else if(opcion == 2){
            int id;
            System.out.print("Ingrese el id del cliente a buscar: ");
            id = scanner.nextInt();
            scanner.nextLine();
            int i = 0;
            boolean flag = false;
            
            while(i<clientes.size() && !flag){
                if(clientes.get(i).getId() == id){
                    System.out.println("Cliente encontrado en la posicion " + (1 + i));
                    flag = true;
                }
                i++;
            }
            if(!flag) System.out.println("El cliente no fue encontrado");
        }
        else System.out.println("Opcion invalida");
    }
    
    private static void eliminarVendedor(Scanner scanner, ArrayList<Vendedor> vendedores){
        int pos;
        System.out.print("Ingresar la posicion del vendedor a eliminar: ");
        pos = scanner.nextInt();
        pos--;
        scanner.nextLine();
        System.out.print("Listado de vendedores antes de la eliminacion: ");
        mostrarVendedores(vendedores);
        vendedores.remove(pos);
        System.out.print("Listado de vendedores luego de la eliminacion: ");
        mostrarVendedores(vendedores);
    }
    
    private static void eliminarCliente(Scanner scanner, ArrayList<Cliente> clientes){
        int pos;
        System.out.print("Ingresar la posicion del cliente a eliminar: ");
        pos = scanner.nextInt();
        pos--;
        scanner.nextLine();
        System.out.print("Listado de clientes antes de la eliminacion: ");
        mostrarClientes(clientes);
        clientes.remove(pos);
        System.out.print("Listado de clientes luego de la eliminacion: ");
        mostrarClientes(clientes);
    }
    
    private static void mostrarVendedores(ArrayList<Vendedor> lista){
        Iterator<Vendedor> i = lista.iterator();
        if(i.hasNext()){
            Vendedor siguiente = i.next();
            System.out.printf("(Id: %d, Nombre: %s)", siguiente.getId(), siguiente.getNombre());
        }
        while(i.hasNext()){
            Vendedor siguiente = i.next();
            System.out.printf(", (Id: %d, Nombre: %s)", siguiente.getId(), siguiente.getNombre());
        }
        System.out.println();
    }
    private static void mostrarClientes(ArrayList<Cliente> lista){
        Iterator<Cliente> i = lista.iterator();
        if(i.hasNext()){
            Cliente siguiente = i.next();
            System.out.printf("(Id: %d, Nombre: %s)", siguiente.getId(), siguiente.getNombre());
        }
        while(i.hasNext()){
            Cliente siguiente = i.next();
            System.out.printf(", (Id: %d, Nombre: %s)", siguiente.getId(), siguiente.getNombre());
        }
        System.out.println();
    }
}

