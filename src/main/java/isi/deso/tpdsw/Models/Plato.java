package isi.deso.tpdsw.Models;

import isi.deso.tpdsw.Models.ItemMenu;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Models.Categoria;

public class Plato extends ItemMenu implements Comparable<ItemMenu>{

    private static final double FACTOR_ENVASE = 1.1;
    private int calorias;
    private boolean aptoCeliaco;
    private float peso;

    public Plato(int id, String nombre, String descripcion, int calorias, boolean aptoCeliaco, float peso, float precio, Categoria categoria, boolean aptoVegano, Vendedor vendedor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.calorias = calorias;
        this.aptoCeliaco = aptoCeliaco;
        this.peso = peso;
        this.precio = precio;
        this.categoria = categoria;
        this.aptoVegano = aptoVegano;
        this.vendedor = vendedor;
    }
    
    @Override
    public int getId() {
        return id;
    }
    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public String getDescripcion() {
        return descripcion;
    }
    @Override
    public float getPrecio() {
        return precio;
    }
    @Override
    public Categoria getCategoria() {
        return categoria;
    }
    @Override
    public boolean getAptoVegano() {
        return aptoVegano;
    }
    public int getCalorias() {
        return calorias;
    }

    public boolean getAptoCeliaco() {
        return aptoCeliaco;
    }
    
    public float getPeso() {
        return peso;
    }
    
    @Override
    public Vendedor getVendedor(){
        return vendedor;
    }
    
    @Override
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    @Override
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    @Override
    public void setAptoVegano(boolean aptoVegano) {
        this.aptoVegano = aptoVegano;
    }
    
    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public void setAptoCeliaco(boolean aptoCeliaco) {
        this.aptoCeliaco = aptoCeliaco;
    }
    
    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    @Override
    public void setVendedor(Vendedor vendedor){
        this.vendedor = vendedor;
    }
     
    @Override
    public float peso(){
        return (float)(peso*FACTOR_ENVASE);
    }
    @Override
    public boolean esComida(){
        return true;
    }
    @Override
    public boolean esBebida(){
        return false;
    }
    @Override
    public boolean aptoVegano(){
        return aptoVegano;
    }
    @Override
    public int compareTo(ItemMenu item) {
        return this.id - item.getId();
    }
    
    @Override
    public String toString() {
        return "[Id=" + id + ", nombre=" + nombre + ']';
    }
    
    public boolean equals(Object o){
        ItemMenu otro = (ItemMenu) o;
        return id == otro.getId();
    }
}
