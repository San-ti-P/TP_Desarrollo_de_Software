package isi.deso.tpdsw;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Iterator;
import java.util.function.Predicate;

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
        
        // Crear categorías
        Categoria categoriaGaseosas = new Categoria("Cat1", "Gaseosas", TipoItem.BEBIDA);
        Categoria categoriaHamburguesas = new Categoria("Cat2", "Hamburguesas", TipoItem.PLATO);
        Categoria categoriaHelados = new Categoria("Cat3", "Helados", TipoItem.PLATO);
        Categoria categoriaVinos = new Categoria("Cat4", "Vinos", TipoItem.BEBIDA);

        // Crear vendedores
        Vendedor vendedor = new Vendedor();
        vendedor.setId(4);
        vendedor.setNombre("Lo de Nestor");
        vendedor.setDireccion("Pedro de Vega 1423");
        vendedor.setCoordenadas(new Coordenada(10.0, 20.0));
        
        vendedores.add(vendedor);

        vendedor.setId(5);
        vendedor.setNombre("McDonalds");
        vendedor.setDireccion("San Martin 384");
        vendedor.setCoordenadas(new Coordenada(30.0, 40.0));

        vendedores.add(vendedor);
        
        vendedor.setId(6);
        vendedor.setNombre("La Brava");
        vendedor.setDireccion("Almirante Brown 1024");
        vendedor.setCoordenadas(new Coordenada(50.0, 60.0));

        vendedores.add(vendedor);
        
        vendedor.setId(7);
        vendedor.setNombre("El Fogolar");
        vendedor.setDireccion("Salvador del Carril 744");
        vendedor.setCoordenadas(new Coordenada(70.0, 80.0));
        
        vendedores.add(vendedor);

        // Crear bebidas
        Bebida bebida1 = new Bebida("B1", "Coca Cola", "Bebida gaseosa", 1.5f, categoriaGaseosas, 0.0f, 500, true, vendedores.get(2));
        Bebida bebida2 = new Bebida("B2", "Estancia Mendoza Malbec 750 cc.", "Vino Malbec añejado en barriles de roble francés talado a mano por Kilyan Mbappé", 2.5f, categoriaVinos, 14.0f, 750, true, vendedores.get(7));
        Bebida bebida3 = new Bebida("B3", "Sprite", "Muy buena", 1.8f, categoriaGaseosas, 0.0f, 250, true, vendedores.get(3));
        Bebida bebida4 = new Bebida("B4", "Etchart Privado Torrontes", "Vino blanco muy bueno para acompañar pescados y quesos (y para pastas dice uno de los desarrolladores)", 1.0f, categoriaVinos, 12.5f, 750, true, vendedores.get(3));

        // Crear platos
        Plato plato1 = new Plato("P1", "Hamburguesa", "Hamburguesa con queso", 5.0f, categoriaComida, false, vendedor1);
        Plato plato2 = new Plato("P2", "Ensalada", "Ensalada vegana", 4.0f, categoriaComida, true, vendedor2);
        Plato plato3 = new Plato("P3", "Pizza", "Pizza de pepperoni", 6.0f, categoriaComida, false, vendedor3);
        Plato plato4 = new Plato("P4", "Sushi", "Sushi variado", 8.0f, categoriaComida, false, vendedor4);

        // Crear postres
        Plato postre1 = new Plato("P5", "Helado", "Helado de chocolate", 3.0f, categoriaPostre, true, vendedor1);
        Plato postre2 = new Plato("P6", "Tarta", "Tarta de manzana", 4.0f, categoriaPostre, true, vendedor2);

        // Crear snacks
        Plato snack1 = new Plato("P7", "Papas Fritas", "Papas fritas con sal", 2.0f, categoriaSnack, true, vendedor3);
        Plato snack2 = new Plato("P8", "Nachos", "Nachos con queso", 3.5f, categoriaSnack, false, vendedor4);

        // Agregar items al menú de los vendedores
        vendedor1.agregarItemMenu(bebida1);
        vendedor1.agregarItemMenu(plato1);
        vendedor1.agregarItemMenu(postre1);

        vendedor2.agregarItemMenu(bebida2);
        vendedor2.agregarItemMenu(plato2);
        vendedor2.agregarItemMenu(postre2);

        vendedor3.agregarItemMenu(bebida3);
        vendedor3.agregarItemMenu(plato3);
        vendedor3.agregarItemMenu(snack1);

        vendedor4.agregarItemMenu(bebida4);
        vendedor4.agregarItemMenu(plato4);
        vendedor4.agregarItemMenu(snack2);

        // Crear clientes
        Cliente cliente1 = new Cliente();
        cliente1.setId(1);
        cliente1.setNombre("Cliente 1");
        cliente1.setDireccion("Direccion Cliente 1");
        cliente1.setCoordenadas(new Coordenada(15.0, 25.0));

        Cliente cliente2 = new Cliente();
        cliente2.setId(2);
        cliente2.setNombre("Cliente 2");
        cliente2.setDireccion("Direccion Cliente 2");
        cliente2.setCoordenadas(new Coordenada(35.0, 45.0));

        Cliente cliente3 = new Cliente();
        cliente3.setId(3);
        cliente3.setNombre("Cliente 3");
        cliente3.setDireccion("Direccion Cliente 3");
        cliente3.setCoordenadas(new Coordenada(55.0, 65.0));

        Cliente cliente4 = new Cliente();
        cliente4.setId(4);
        cliente4.setNombre("Cliente 4");
        cliente4.setDireccion("Direccion Cliente 4");
        cliente4.setCoordenadas(new Coordenada(75.0, 85.0));

        // Crear pedidos
        Pedido pedido1 = new Pedido();
        pedido1.setId(1);
        pedido1.setCliente(cliente1);
        pedido1.agregarItemPedido(new ItemPedido(bebida1, 2));
        pedido1.agregarItemPedido(new ItemPedido(plato1, 1));
        pedido1.agregarItemPedido(new ItemPedido(postre1, 1));

        Pedido pedido2 = new Pedido();
        pedido2.setId(2);
        pedido2.setCliente(cliente2);
        pedido2.agregarItemPedido(new ItemPedido(bebida2, 3));
        pedido2.agregarItemPedido(new ItemPedido(plato2, 2));
        pedido2.agregarItemPedido(new ItemPedido(postre2, 1));

        Pedido pedido3 = new Pedido();
        pedido3.setId(3);
        pedido3.setCliente(cliente3);
        pedido3.agregarItemPedido(new ItemPedido(bebida3, 1));
        pedido3.agregarItemPedido(new ItemPedido(plato3, 2));
        pedido3.agregarItemPedido(new ItemPedido(snack1, 3));

        Pedido pedido4 = new Pedido();
        pedido4.setId(4);
        pedido4.setCliente(cliente4);
        pedido4.agregarItemPedido(new ItemPedido(bebida4, 2));
        pedido4.agregarItemPedido(new ItemPedido(plato4, 1));
        pedido4.agregarItemPedido(new ItemPedido(snack2, 2));

        // Agregar pedidos a una lista
        ArrayList<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);
        pedidos.add(pedido4);
        
        Categoria hamburguesas = new Categoria();
        hamburguesas.setId("Cat1");
        hamburguesas.setDescripcion("Son Hamburguesas maestro");
        hamburguesas.setTipoItem(TipoItem.PLATO);
        
        ArrayList<ItemMenu> items_vend_1 = new ArrayList<>();
        
        ItemMenu item = new Plato("plato01", "Doble Bacon", "Bacon del bueno", 600, false, 0.15f, 12.0f, hamburguesas, false, vendedores.get(0));
        
        items_vend_1.add(item);
        
                ItemMenu item = new Plato("plato01", "Doble Bacon", "Bacon del bueno", 600, false, 0.15f, 12.0f, hamburguesas, false, vendedores.get(0));

        
        
        ItemsPedidoMemory ipm = new ItemsPedidoMemory();
        PredicateFactory predicados = new PredicateFactory();
        Pedido pedido1 = new Pedido();
        pedido1.setCliente(clientes.get(0));
        pedido1.setId("1");
        
        
        
        ArrayList<ItemMenu> items_id_1;
        
        Predicate<ItemMenu> p_id_1 = predicados.obtenerPredicado("id", "1");
        try{
            items_id_1 = ipm.filtrarPedido(pedido1, p_id_1);
        }catch(ItemNoEncontradoException e){
            items_id_1 = new ArrayList();
        }
        
        
        Iterator<ItemMenu> i = items_id_1.iterator();
        if(i.hasNext()){
            ItemMenu siguiente = i.next();
            System.out.printf("(Id: %s, Nombre: %s)", siguiente.getId(), siguiente.getNombre());
        }
        while(i.hasNext()){
            ItemMenu siguiente = i.next();
            System.out.printf(", (Id: %s, Nombre: %s)", siguiente.getId(), siguiente.getNombre());
        }
        System.out.println();
        
        
    
    
    
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

