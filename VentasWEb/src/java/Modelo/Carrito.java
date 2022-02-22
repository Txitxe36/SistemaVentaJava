
package Modelo;

import java.util.ArrayList;

public class Carrito {
    
    private ArrayList<lineaCarrito> listaLinea = new ArrayList<lineaCarrito>();
    
    //AGREGAR PRODUCTO AL CARRITO
    public void agregar(Producto prod,int cantidad){
        lineaCarrito linea = new lineaCarrito(prod,cantidad);
        listaLinea.add(linea);
        
    }
    
  
    //LISTA DE PRODUCTOS DEL CARRITO
    public ArrayList<lineaCarrito> getListaLinea() {
        return listaLinea;
    }
    
    
}
