package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentaDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int resultado;

    //GENERA NUMERO DE SERIE PARA LA VENTA
    public String GenerarSerie() {
        String numeroSerie = "";
        String sql = "select max(NumeroSerie) from ventas";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                numeroSerie = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return numeroSerie;
    }

    //OBTIENE EL ID DE VENTA
    public String IdVentas() {
        String idVentas = "";
        String sql = "select max(IdVentas) from ventas";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idVentas = rs.getString(1);
            }

        } catch (Exception e) {
        }
        return idVentas;
    }

    //GUARDAR VENTA
    public int guardarVenta(Venta ven) {
        String sql = "insert into ventas(IdCliente, IdEmpleado, NumeroSerie, FechaVentas, Monto, Estado)values(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ven.getIdCliente());
            ps.setInt(2, ven.getIdEmpleado());
            ps.setString(3, ven.getNumSerie());
            ps.setString(4, ven.getFecha());
            ps.setDouble(5, ven.getMonto());
            ps.setString(6, ven.getEstado());

            ps.executeUpdate();

        } catch (Exception e) {
        }
        return resultado;
    }

    //GUARDAR DETALLE DE VENTA
    public int guardarDetalleVentas(Venta venta) {
        String sql = "insert into detalle_ventas(IdVentas, IdProducto, Cantidad, PrecioVenta)values(?,?,?,?) ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getId());
            ps.setInt(2, venta.getIdProducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecio());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return resultado;
    }

}
