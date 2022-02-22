
package Modelo;


public class lineaCarrito {
    private Producto articulo;
    private int cantidad;

    public lineaCarrito() {
    }

    public lineaCarrito(Producto articulo, int cantidad) {
        this.articulo = articulo;
        this.cantidad = cantidad;
    }

    public Producto getArticulo() {
        return articulo;
    }

    public void setArticulo(Producto articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public Double getSubtotal(){
        
        return this.getArticulo().getPrecio() * this.cantidad;
    }
    
}
