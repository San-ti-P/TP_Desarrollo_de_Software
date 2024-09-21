package isi.deso.tpdsw;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Iterator;
import java.util.function.Predicate;


public class TPdsw {
    
    public static void main(String[] args) {
        
        /* 
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
        
        */

        // Crear categorías
        Categoria categoriaGaseosas = new Categoria("Cat1", "Gaseosas", TipoItem.BEBIDA);
        Categoria categoriaHamburguesas = new Categoria("Cat2", "Hamburguesas", TipoItem.PLATO);
        Categoria categoriaHelados = new Categoria("Cat3", "Helados", TipoItem.PLATO);
        Categoria categoriaVinos = new Categoria("Cat4", "Vinos", TipoItem.BEBIDA);
        Categoria categoriaPastas = new Categoria("Cat5", "Pastas", TipoItem.PLATO);
        Categoria categoriaCarnes = new Categoria("Cat6", "Carnes", TipoItem.PLATO);
        Categoria categoriaVerduras = new Categoria("Cat7", "Verduras", TipoItem.PLATO);
        Categoria categoriaHarinas = new Categoria("Cat8", "Harinas", TipoItem.PLATO);
        Categoria categoriaCervezas = new Categoria("Cat9", "Cervezas", TipoItem.BEBIDA);
        
        // Crear vendedores
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        
        Vendedor vendedor1 = new Vendedor();
        vendedor1.setId(4);
        vendedor1.setNombre("Lo de Nestor");
        vendedor1.setDireccion("Pedro de Vega 1423");
        vendedor1.setCoordenadas(new Coordenada(10.0, 20.0));
        vendedores.add(vendedor1);

        Vendedor vendedor2 = new Vendedor();
        vendedor2.setId(5);
        vendedor2.setNombre("McDonalds");
        vendedor2.setDireccion("San Martin 384");
        vendedor2.setCoordenadas(new Coordenada(30.0, 40.0));
        vendedores.add(vendedor2);
        
        Vendedor vendedor3 = new Vendedor();
        vendedor3.setId(6);
        vendedor3.setNombre("La Brava");
        vendedor3.setDireccion("Almirante Brown 1024");
        vendedor3.setCoordenadas(new Coordenada(50.0, 60.0));
        vendedores.add(vendedor3);
        
        Vendedor vendedor4 = new Vendedor();
        vendedor4.setId(7);
        vendedor4.setNombre("El Fogolar");
        vendedor4.setDireccion("Salvador del Carril 744");
        vendedor4.setCoordenadas(new Coordenada(70.0, 80.0));
        vendedores.add(vendedor4);

        // Crear bebidas
        Bebida bebida1 = new Bebida(
            "B1", 
            "Coca Cola", 
            "Bebida gaseosa", 
            1.5f, 
            categoriaGaseosas, 
            0.0f, 
            500, 
            true, 
            vendedores.get(2)
        );

        Bebida bebida2 = new Bebida(
            "B2", 
            "Estancia Mendoza Malbec 750 cc.", 
            "Vino Malbec añejado en barriles de roble francés talado a mano por Kylian Mbappé", 
            2.5f, 
            categoriaVinos, 
            14.0f, 
            750, 
            true, 
            vendedores.get(3)
        );

        Bebida bebida3 = new Bebida(
            "B3", 
            "Sprite", 
            "Muy buena", 
            1.8f, 
            categoriaGaseosas, 
            0.0f, 
            250, 
            true, 
            vendedores.get(3)
        );

        Bebida bebida4 = new Bebida(
            "B4", 
            "Etchart Privado Torrontes", 
            "Vino blanco muy bueno para acompañar pescados y quesos (y para pastas dice uno de los desarrolladores)", 
            1.0f, 
            categoriaVinos, 
            12.5f, 
            750, 
            true, 
            vendedores.get(3)
        );

        // Bebidas adicionales
        Bebida bebida5 = new Bebida(
            "B5", 
            "Pepsi", 
            "Bebida gaseosa con sabor a cola", 
            1.6f, 
            categoriaGaseosas, 
            0.0f, 
            600, 
            true, 
            vendedores.get(0) // Lo de Nestor
        );

        Bebida bebida6 = new Bebida(
            "B6", 
            "Fernet con Coca", 
            "Trago típico argentino de Fernet con Coca Cola", 
            2.0f, 
            categoriaVinos, 
            0.0f, 
            500, 
            false, 
            vendedores.get(3) // El Fogolar
        );

        Bebida bebida7 = new Bebida(
            "B7", 
            "Agua Mineral", 
            "Agua mineral sin gas", 
            1.0f, 
            categoriaGaseosas, 
            0.0f, 
            500, 
            true, 
            vendedores.get(1) // McDonalds
        );

        Bebida bebida8 = new Bebida(
            "B8", 
            "Cerveza Artesanal IPA", 
            "Cerveza artesanal con un toque amargo", 
            2.8f, 
            categoriaCervezas, 
            5.0f, 
            600, 
            true, 
            vendedores.get(2) // La Brava
        );

        // Crear platos
        Plato plato1 = new Plato(
            "P1", 
            "Hamburguesa Doble", 
            "Doble medallón de carne vacuna con queso cheddar, lechuga y tomate", 
            850, 
            false, 
            300.0f, 
            4.5f, 
            categoriaHamburguesas, 
            false, 
            vendedores.get(1) // McDonalds
        );

        Plato plato2 = new Plato(
            "P2", 
            "Ravioles de Ricota", 
            "Ravioles de ricota con salsa boloñesa", 
            700, 
            false, 
            250.0f, 
            3.2f, 
            categoriaPastas, 
            false, 
            vendedores.get(0) // Lo de Nestor
        );

        Plato plato3 = new Plato(
            "P3", 
            "Ensalada Verde", 
            "Ensalada fresca con lechuga, rúcula, espinaca y aderezo de oliva", 
            150, 
            true, 
            180.0f, 
            2.8f, 
            categoriaVerduras, 
            true, 
            vendedores.get(2) // La Brava
        );

        Plato plato4 = new Plato(
            "P4", 
            "Helado de Chocolate", 
            "Helado artesanal de chocolate amargo con chips", 
            350, 
            true, 
            200.0f, 
            2.5f, 
            categoriaHelados, 
            true, 
            vendedores.get(3) // El Fogolar
        );

        Plato plato5 = new Plato(
            "P5", 
            "Asado Completo", 
            "Asado de tira con chorizo, morcilla y papas al horno", 
            1200, 
            false, 
            600.0f, 
            6.0f, 
            categoriaCarnes, 
            false, 
            vendedores.get(0) // Lo de Nestor
        );

        Plato plato6 = new Plato(
            "P6", 
            "Milanesa Napolitana", 
            "Milanesa de ternera con jamón, queso, salsa de tomate y papas fritas", 
            950, 
            false, 
            400.0f, 
            5.0f, 
            categoriaCarnes, 
            false, 
            vendedores.get(1) // McDonalds
        );

        Plato plato7 = new Plato(
            "P7", 
            "Fideos con Pesto", 
            "Fideos caseros con salsa de pesto y nueces", 
            600, 
            true, 
            350.0f, 
            3.8f, 
            categoriaPastas, 
            true, 
            vendedores.get(2) // La Brava
        );
        
        Plato plato8 = new Plato(
            "P8", 
            "Ñoquis de Papa", 
            "Ñoquis de papa caseros con salsa de tomate y albahaca", 
            500, 
            true, 
            400.0f, 
            3.5f, 
            categoriaHarinas, 
            true, 
            vendedores.get(0) // Lo de Nestor
        );

        Plato plato9 = new Plato(
            "P9", 
            "Milanesa de Pollo", 
            "Milanesa de pollo con ensalada mixta", 
            750, 
            false, 
            350.0f, 
            4.5f, 
            categoriaCarnes, 
            false, 
            vendedores.get(1) // McDonalds
        );

        Plato plato10 = new Plato(
            "P10", 
            "Pizza Margarita", 
            "Pizza a la piedra con salsa de tomate, mozzarella y albahaca fresca", 
            900, 
            true, 
            500.0f, 
            6.0f, 
            categoriaHarinas, 
            true, 
            vendedores.get(3) // El Fogolar
        );

        Plato plato11 = new Plato(
            "P11", 
            "Ensalada de Pollo y Palta", 
            "Ensalada fresca con pechuga de pollo a la plancha, palta y aderezo de limón", 
            300, 
            false, 
            250.0f, 
            3.0f, 
            categoriaVerduras, 
            false, 
            vendedores.get(2) // La Brava
        );

        // Agregar bebidas al menú de los vendedores
        vendedor1.agregarItemMenu(bebida5); // Lo de Nestor
        vendedor2.agregarItemMenu(bebida1); // McDonalds
        vendedor2.agregarItemMenu(bebida7); // McDonalds
        vendedor3.agregarItemMenu(bebida3); // La Brava
        vendedor3.agregarItemMenu(bebida8); // La Brava (Cerveza IPA)
        vendedor4.agregarItemMenu(bebida2); // El Fogolar
        vendedor4.agregarItemMenu(bebida4); // El Fogolar
        vendedor4.agregarItemMenu(bebida6); // El Fogolar (Fernet con Coca)

        // Agregar platos al menú de los vendedores
        vendedor1.agregarItemMenu(plato2); // Lo de Nestor (Ravioles)
        vendedor1.agregarItemMenu(plato5); // Lo de Nestor (Asado)
        vendedor1.agregarItemMenu(plato8); // Lo de Nestor (Ñoquis de Papa)

        vendedor2.agregarItemMenu(plato1); // McDonalds (Hamburguesa Doble)
        vendedor2.agregarItemMenu(plato6); // McDonalds (Milanesa Napolitana)
        vendedor2.agregarItemMenu(plato9); // McDonalds (Milanesa de Pollo)

        vendedor3.agregarItemMenu(plato3); // La Brava (Ensalada Verde)
        vendedor3.agregarItemMenu(plato7); // La Brava (Fideos con Pesto)
        vendedor3.agregarItemMenu(plato11); // La Brava (Ensalada de Pollo y Palta)

        vendedor4.agregarItemMenu(plato4); // El Fogolar (Helado de Chocolate)
        vendedor4.agregarItemMenu(plato10); // El Fogolar (Pizza Margarita)

        // Crear clientes
        Cliente cliente1 = new Cliente();
        cliente1.setId(1);
        cliente1.setNombre("Juan Perez");
        cliente1.setCuit("20-12345678-9");
        cliente1.setEmail("juan.perez@gmail.com");
        cliente1.setDireccion("Av. Siempreviva 742");
        cliente1.setCoordenadas(new Coordenada(12.0, 25.0));

        Cliente cliente2 = new Cliente();
        cliente2.setId(2);
        cliente2.setNombre("Maria Lopez");
        cliente2.setCuit("27-98765432-1");
        cliente2.setEmail("maria.lopez@gmail.com");
        cliente2.setDireccion("Calle Falsa 123");
        cliente2.setCoordenadas(new Coordenada(15.0, 30.0));

        Cliente cliente3 = new Cliente();
        cliente3.setId(3);
        cliente3.setNombre("Carlos Diaz");
        cliente3.setCuit("20-87654321-0");
        cliente3.setEmail("carlos.diaz@hotmail.com");
        cliente3.setDireccion("Ruta Nacional 1 Km 50");
        cliente3.setCoordenadas(new Coordenada(18.0, 35.0));

        Cliente cliente4 = new Cliente();
        cliente4.setId(4);
        cliente4.setNombre("Laura Garcia");
        cliente4.setCuit("23-56789012-3");
        cliente4.setEmail("laura.garcia@yahoo.com");
        cliente4.setDireccion("Bv. Gálvez 1250");
        cliente4.setCoordenadas(new Coordenada(10.0, 22.0));

        Cliente cliente5 = new Cliente();
        cliente5.setId(5);
        cliente5.setNombre("Lucas Martinez");
        cliente5.setCuit("24-34567890-5");
        cliente5.setEmail("lucas.martinez@outlook.com");
        cliente5.setDireccion("Calle San Juan 2050");
        cliente5.setCoordenadas(new Coordenada(20.0, 40.0));

        Cliente cliente6 = new Cliente();
        cliente6.setId(6);
        cliente6.setNombre("Silvia Fernandez");
        cliente6.setCuit("25-01234567-4");
        cliente6.setEmail("silvia.fernandez@gmail.com");
        cliente6.setDireccion("Mitre 1985");
        cliente6.setCoordenadas(new Coordenada(5.0, 15.0));

        // Crear pedidos
        ArrayList<ItemPedido> itemsPedido1 = new ArrayList<>();
        itemsPedido1.add(new ItemPedido(bebida1, 2)); // Coca Cola
        itemsPedido1.add(new ItemPedido(plato1, 1));  // Hamburguesa Doble

        Pedido pedido1 = new Pedido();
        pedido1.setId("P001");
        pedido1.setCliente(cliente1);
        pedido1.setItems(itemsPedido1);
        pedido1.setVendedor(vendedores.get(1)); // McDonalds

        ArrayList<ItemPedido> itemsPedido2 = new ArrayList<>();
        itemsPedido2.add(new ItemPedido(bebida2, 1)); // Estancia Mendoza Malbec
        itemsPedido2.add(new ItemPedido(plato2, 2));  // Ravioles de Ricota

        Pedido pedido2 = new Pedido();
        pedido2.setId("P002");
        pedido2.setCliente(cliente2);
        pedido2.setItems(itemsPedido2);
        pedido2.setVendedor(vendedores.get(0)); // Lo de Nestor

        ArrayList<ItemPedido> itemsPedido3 = new ArrayList<>();
        itemsPedido3.add(new ItemPedido(bebida3, 3)); // Sprite
        itemsPedido3.add(new ItemPedido(plato5, 1));  // Asado Completo

        Pedido pedido3 = new Pedido();
        pedido3.setId("P003");
        pedido3.setCliente(cliente3);
        pedido3.setItems(itemsPedido3);
        pedido3.setVendedor(vendedores.get(2)); // La Brava

        ArrayList<ItemPedido> itemsPedido4 = new ArrayList<>();
        itemsPedido4.add(new ItemPedido(bebida5, 2)); // Pepsi
        itemsPedido4.add(new ItemPedido(plato6, 1));  // Milanesa Napolitana

        Pedido pedido4 = new Pedido();
        pedido4.setId("P004");
        pedido4.setCliente(cliente4);
        pedido4.setItems(itemsPedido4);
        pedido4.setVendedor(vendedores.get(1)); // McDonalds

        ArrayList<ItemPedido> itemsPedido5 = new ArrayList<>();
        itemsPedido5.add(new ItemPedido(bebida6, 1)); // Fernet con Coca
        itemsPedido5.add(new ItemPedido(plato4, 1));  // Helado de Chocolate

        Pedido pedido5 = new Pedido();
        pedido5.setId("P005");
        pedido5.setCliente(cliente5);
        pedido5.setItems(itemsPedido5);
        pedido5.setVendedor(vendedores.get(3)); // El Fogolar

        ArrayList<ItemPedido> itemsPedido6 = new ArrayList<>();
        itemsPedido6.add(new ItemPedido(bebida8, 2)); // Cerveza Artesanal IPA
        itemsPedido6.add(new ItemPedido(plato7, 2));  // Fideos con Pesto

        Pedido pedido6 = new Pedido();
        pedido6.setId("P006");
        pedido6.setCliente(cliente6);
        pedido6.setItems(itemsPedido6);
        pedido6.setVendedor(vendedores.get(2)); // La Brava
        
        ArrayList<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);
        pedidos.add(pedido4);
        pedidos.add(pedido5);
        pedidos.add(pedido6);
        
        System.out.println("Los Pedidos existentes son: ");
        System.out.println(pedido1);
        System.out.println(pedido2);
        System.out.println(pedido3);
        System.out.println(pedido4);
        System.out.println(pedido5);
        System.out.println(pedido6);
        System.out.println("\n");
        
        
        ArrayList<Pedido> filtrados_usuario = filtrarPedidos(pedidos);
        
        
    } // -- CIERRE MAIN --
    
    private static ArrayList<Pedido> filtrarPedidos(ArrayList<Pedido> pedidos){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Como le gustaria filtrar? ");
        System.out.println("Las opciones son: ID, NOMBRE, APTOVEGANO, CATEGORIA");
        String entradaPredicado = scanner.nextLine().toLowerCase().strip();
        
        System.out.println("Que valor le gustaria filtrar?: ");
        String entradaValor = scanner.nextLine().toLowerCase().strip();
        PredicateFactory predicado = new PredicateFactory();
        Predicate<ItemPedido> pred1 = predicado.obtenerPredicado(entradaPredicado, entradaValor);
        
        ItemsPedidoMemory ipm = new ItemsPedidoMemory();
        ArrayList<Pedido> filtrados = new ArrayList<>();
        ArrayList<ItemPedido> items_filtrados = new ArrayList<>();
        
        for (Pedido p : pedidos) {
            try{
                items_filtrados = ipm.filtrarPedido(p, pred1);
                filtrados.add(p);
            }catch(ItemNoEncontradoException e){
                continue;
            }   
        }
        
        if (filtrados.isEmpty()) { System.out.println("No hay pedidos"); }
        else {
                System.out.println("Los pedidos filtrados son");
                for (Pedido p: filtrados) { System.out.println(p);  }
            }
        return filtrados;
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
    