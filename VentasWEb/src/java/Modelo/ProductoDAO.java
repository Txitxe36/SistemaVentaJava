
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    
     Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;
    
    //buscar producto por id
    public Producto buscar(int id){
        Producto prod = new Producto();
                
        String sql= "select * from producto where idproducto="+id;
        
        try {
              con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                prod.setIdProd(rs.getInt(1));
                prod.setNombres(rs.getString(2));
               prod.setPrecio(rs.getDouble(3));
               prod.setStock(rs.getInt(4));
               prod.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return prod;
    }
    
    //ACTUALIZAR STOCK
    public int actualizarStock(int id, int stock){
        String sql = "update producto set Stock=? where idproducto=?";
        try {
            con = cn.Conexion();
             ps = con.prepareStatement(sql);
            ps.setInt(1,stock);
            ps.setInt(2,id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
            return respuesta;
    }
    
    
     //listar productos
    public List listar() {
        String sql = "select * from producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setIdProd(rs.getInt(1));
                prod.setNombres(rs.getString(2));
                prod.setPrecio(rs.getDouble(3));
                prod.setStock(rs.getInt(4));
                prod.setEstado(rs.getString(5));
                
                lista.add(prod);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    //agregar producto
    public int agregar(Producto prod) {
        String sql = "insert into producto(Nombres,Precio,Stock,Estado)values(?,?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
           
            ps.setString(1, prod.getNombres());
            ps.setDouble(2,prod.getPrecio());
            ps.setInt(3, prod.getStock());
            ps.setString(4, prod.getEstado());

            ps.executeUpdate();
        } catch (Exception e) {
        }
        return respuesta;
    }
    
    //listar producto por id
    public Producto listarID(int id) {
        Producto prod = new Producto();
        String sql = "select * from producto where IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                prod.setIdProd(rs.getInt(1));
                prod.setNombres(rs.getString(2));
                prod.setPrecio(rs.getDouble(3));
                prod.setStock(rs.getInt(4));
                prod.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return prod;
    }
    
    //actulaizar producto
     public int actualizar(Producto prod) {
        String sql = "update producto set Nombres=?, Precio=? ,Stock=?, Estado=? where IdProducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, prod.getNombres());
            ps.setDouble(2, prod.getPrecio());
           ps.setInt(3, prod.getStock());
           ps.setString(4,prod.getEstado());
            ps.setInt(5, prod.getIdProd());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return respuesta;
    }
    
     //eliminar producto
      public void delete(int id) {
        String sql = "delete from producto where IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
