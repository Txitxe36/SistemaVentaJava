
package Modelo;

public class Cliente {
    
    private int idCliente;
    private String nombres;
    private String dni;
    private String direccion;
    private String estado;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombres, String dni, String direccion, String estado) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.dni = dni;
        this.direccion = direccion;
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
