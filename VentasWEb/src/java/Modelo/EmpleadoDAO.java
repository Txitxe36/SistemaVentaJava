package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;

    //VALIDACION DE EMPLEADO
    public Empleado validar(String user, String dni) {
        Empleado emple = new Empleado();
        String sql = "SELECT * FROM empleado WHERE User=? AND Dni=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                // emple.setId(rs.getInt("IdEmpleado"));
                emple.setUser(rs.getString("User"));
                emple.setDni(rs.getString("Dni"));
                //  emple.setNombre(rs.getString("Nombres"));
            }
        } catch (Exception e) {
        }
        return emple;
    }

    //LISTAR EMPLEADO
    public List listar() {
        String sql = "select * from empleado";
        List<Empleado> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado emple = new Empleado();
                emple.setId(rs.getInt(1));
                emple.setDni(rs.getString(2));
                emple.setNombre(rs.getString(3));
                emple.setTelefono(rs.getString(4));
                emple.setEstado(rs.getString(5));
                emple.setUser(rs.getString(6));
                lista.add(emple);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    //AGREGAR EMPLEADO
    public int agregar(Empleado emple) {
        String sql = "insert into empleado(Dni ,Nombres ,Telefono ,Estado ,User )values(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, emple.getDni());
            ps.setString(2, emple.getNombre());
            ps.setString(3, emple.getTelefono());
            ps.setString(4, emple.getEstado());
            ps.setString(5, emple.getUser());

            ps.executeUpdate();
        } catch (Exception e) {
        }
        return respuesta;
    }

    //LISTAR EMPLEADO POR ID
    public Empleado listarID(int id) {
        Empleado emple = new Empleado();
        String sql = "select * from empleado where IdEmpleado="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                emple.setDni(rs.getString(2));
                emple.setNombre(rs.getString(3));
                emple.setTelefono(rs.getString(4));
                emple.setEstado(rs.getString(5));
                emple.setUser(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return emple;
    }

    //ACTUALIZAR EMPLEADO
    public int actualizar(Empleado emple) {
        String sql = "update empleado set Dni=?, Nombres=? ,Telefono=?, Estado=?, User=? where IdEmpleado=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, emple.getDni());
            ps.setString(2, emple.getNombre());
            ps.setString(3, emple.getTelefono());
            ps.setString(4, emple.getEstado());
            ps.setString(5, emple.getUser());
            ps.setInt(6, emple.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return respuesta;
    }

    //BORRAR EMPLEADO
    public void delete(int id) {
        String sql = "delete from empleado where IdEmpleado="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
