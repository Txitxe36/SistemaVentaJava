package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

        //CONEXION
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;
    
    //BUSCAR CLIENTE
    public Cliente buscar(String dni){
        Cliente cli = new Cliente();
        String sql = "select * from cliente where Dni="+dni;
        try {
             con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cli.setIdCliente(rs.getInt(1));
                cli.setDni(rs.getString(2));
                cli.setNombres(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setEstado(rs.getString(5)); 
            }
        } catch (Exception e) {
        }
        return cli;
    }

    //LISTAR CLIENTES
    public List listar() {
        String sql = "select * from cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setIdCliente(rs.getInt(1));
                cli.setDni(rs.getString(2));
                cli.setNombres(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setEstado(rs.getString(5));

                lista.add(cli);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    //AGREGAR UN CLIENTE
    public int agregar(Cliente cli) {
        String sql = "insert into cliente(Dni,Nombres,Direccion,Estado)values(?,?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNombres());
            ps.setString(3, cli.getDireccion());
            ps.setString(4, cli.getEstado());

            ps.executeUpdate();
        } catch (Exception e) {
        }
        return respuesta;
    }

    //LISTAR CLIENTE POR ID
    public Cliente listarID(int id) {
        Cliente cli = new Cliente();
        String sql = "select * from cliente where IdCliente="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
               
                cli.setDni(rs.getString(2));
                cli.setNombres(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setEstado(rs.getString(5));
                
            }
        } catch (Exception e) {
        }
        return cli;
    }

    //ACTUALIZAR CLIENTE
    public int actualizar(Cliente cli) {
        String sql = "update cliente set Dni=?, Nombres=?, Direccion=?, Estado=? where IdCliente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNombres());
            ps.setString(3, cli.getDireccion());
            ps.setString(4, cli.getEstado());
            ps.setInt(5, cli.getIdCliente());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return respuesta;
    }

    //BORRAR CLIENTE
    public void delete(int id) {
        String sql = "delete from cliente where IdCliente="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
