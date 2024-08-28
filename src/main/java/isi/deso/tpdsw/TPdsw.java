/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package isi.deso.tpdsw;

import java.util.Scanner;
import java.util.ArrayList;

public class TPdsw {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        /*ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            Vendedor v = new Vendedor();
            
            System.out.print("Ingrese ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea sobrante

            System.out.print("Ingrese Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese Direccion: ");
            String direccion = scanner.nextLine();

            System.out.print("Ingrese latitud: ");
            double latitud = scanner.nextDouble();

            System.out.print("Ingrese longitud: ");
            double longitud = scanner.nextDouble();
            scanner.nextLine(); // Consumir la nueva línea sobrante

            Coordenada coordenadas = new Coordenada();
            coordenadas.setLat(latitud);
            coordenadas.setLng(longitud);
            
            v.setId(id);
            v.setNombre(nombre);
            v.setDireccion(direccion);
            vendedores.add(v);

            System.out.println();
        }

        int opcion;
        System.out.print("Ingrese 1 si desea buscar por nombre o 2 si desea buscar por id: ");
        opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea sobrante
        
        if(opcion == 1){
            String nombre;
            System.out.print("Ingrese el nombre del vendedor a buscar: ");
            nombre = scanner.nextLine();
            int i = 0;
            boolean flag = false;
            
            while(i<3 && !flag){
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
            System.out.println("Ingrese el id del vendedor a buscar: ");
            id = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea sobrante
            int i = 0;
            boolean flag = false;
            
            while(i<3 && !flag){
                if(vendedores.get(i).getId() == id){
                    System.out.println("Vendedor encontrado en la posicion " + (1 + i));
                    flag = true;
                }
                i++;
            }
        }
        else System.out.println("Opcion invalida");
    
        
        int pos;
        System.out.println("Ingresar la posicion del vendedor a eliminar: ");
        pos = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea sobrante
        
        vendedores.remove(pos);
        
        scanner.close(); // Cerrar el scanner al final*/
        Vendedor v = new Vendedor();
        Cliente c = new Cliente();
        Coordenada cv = new Coordenada();
        cv.setLat(0.00);
        cv.setLng(10.00);
        Coordenada cc = new Coordenada();
        cc.setLat(0.00);
        cc.setLng(11.00);
        v.setId(1);
        v.setNombre("yo");
        v.setDireccion("aaa");
        v.setCoordenadas(cv);
        c.setId(2);
        c.setCuit("222222");
        c.setDireccion("bbb");
        c.setEmail("ccc@mail.com");
        c.setCoordenadas(cc);
        double d = v.distancia(c);
        System.out.println(d);
    }
}

