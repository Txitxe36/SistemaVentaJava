package Controlador;

import Config.GenerarSerie;
import Modelo.Carrito;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    Empleado emple = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    int idEmple;
    Producto prod = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    int idProd;
    Cliente cli = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    int idCli;
    Venta venta = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item;
    int codProd;
    String descripcion;
    double precio;
    int cantidad;
    double subtotal;
    double totalAPagar;
    String numeroSerie;
    VentaDAO vdao = new VentaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //CAPTURAMOS EL MENU Y LA ACCION
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        switch (accion) {
            case "Principal":
                request.getRequestDispatcher("Principal.jsp").forward(request, response);

                break;

        }
        //LLEVA AL MENU PRINCIPAL
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }

        if (menu.equals("Empleado")) {
            switch (accion) {
                //LISTA EMPLEADO
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                    //AGREGA EMPLEADO
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nombre = request.getParameter("txtNombres");
                    String telefono = request.getParameter("txtTelefono");
                    String estado = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUsuario");
                    emple.setDni(dni);
                    emple.setNombre(nombre);
                    emple.setTelefono(telefono);
                    emple.setEstado(estado);
                    emple.setUser(user);
                    edao.agregar(emple);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                    //EDITA EMPLEADO
                case "Editar":
                    idEmple = Integer.parseInt(request.getParameter("idEmp"));
                    Empleado emp = edao.listarID(idEmple);
                    request.setAttribute("empleado", emp);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                    //ACTUALIZA EMPLEADO
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nombre1 = request.getParameter("txtNombres");
                    String telefono1 = request.getParameter("txtTelefono");
                    String estado1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUsuario");
                    emple.setDni(dni1);
                    emple.setNombre(nombre1);
                    emple.setTelefono(telefono1);
                    emple.setEstado(estado1);
                    emple.setUser(user1);
                    emple.setId(idEmple);
                    edao.actualizar(emple);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                    //BORRAR EMPLEADO
                case "Delete":
                    idEmple = Integer.parseInt(request.getParameter("idEmp"));
                    edao.delete(idEmple);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }

        if (menu.equals("Producto")) {
            switch (accion) {
                //LISTAR PRODUCTOS
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar":
                    //AGREGAR PRODUCTOS
                    String nombre = request.getParameter("txtNombres");
                    Double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock = Integer.parseInt(request.getParameter("txtStock"));
                    String estado = request.getParameter("txtEstado");

                    prod.setNombres(nombre);
                    prod.setPrecio(precio);
                    prod.setEstado(estado);
                    prod.setStock(stock);
                    pdao.agregar(prod);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    //EDITAR PRODUCTOS
                    idProd = Integer.parseInt(request.getParameter("id"));
                    Producto produ = pdao.listarID(idProd);
                    request.setAttribute("producto", produ);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    //ACTUALIZAR DATOS DE PRODUCTOS
                    String nombre1 = request.getParameter("txtNombres");
                    Double precio1 = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock1 = Integer.parseInt(request.getParameter("txtStock"));
                    String estado1 = request.getParameter("txtEstado");

                    prod.setNombres(nombre1);
                    prod.setPrecio(precio1);
                    prod.setEstado(estado1);
                    prod.setStock(stock1);
                    prod.setIdProd(idProd);
                    pdao.actualizar(prod);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    //BORRAR PRODUCTOS
                    idProd = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(idProd);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }

        if (menu.equals("Cliente")) {
            switch (accion) {
                //LISTAR CLIENTES
                case "Listar":
                    List lista = cdao.listar();
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    //AGREGAR CLIENTE
                    String dni = request.getParameter("txtDni");
                    String nombre = request.getParameter("txtNombres");
                    String direccion = request.getParameter("txtDireccion");
                    String estado = request.getParameter("txtEstado");

                    cli.setDni(dni);
                    cli.setNombres(nombre);
                    cli.setDireccion(direccion);
                    cli.setEstado(estado);

                    cdao.agregar(cli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    //EDITAR CLIENTE
                    idCli = Integer.parseInt(request.getParameter("idCli"));
                    Cliente cliente = cdao.listarID(idCli);
                    request.setAttribute("cli", cliente);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    //ACTUALIZAR CLIENTE
                    String dni1 = request.getParameter("txtDni");
                    String nombre1 = request.getParameter("txtNombres");
                    String direccion1 = request.getParameter("txtDireccion");
                    String estado1 = request.getParameter("txtEstado");

                    cli.setDni(dni1);
                    cli.setNombres(nombre1);
                    cli.setDireccion(direccion1);
                    cli.setEstado(estado1);
                    cli.setIdCliente(idCli);
                    cdao.actualizar(cli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    //BORRAR CLIENTE
                    idCli = Integer.parseInt(request.getParameter("idCli"));
                    cdao.delete(idCli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }

        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    //BUSCA AL CLIENTE QUE HACE LA COMPRA
                    String dni = request.getParameter("codigocliente");
                    cli.setDni(dni);
                    cli = cdao.buscar(dni);
                    request.setAttribute("cliente", cli);
                    request.setAttribute("nSerie", numeroSerie);

                    break;
                case "BuscarProducto":
                   //BUSCA EL PRODUCTO SELECCIONADO
                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    prod = pdao.listarID(id);
                    request.setAttribute("cliente", cli);
                    request.setAttribute("producto", prod);
                    request.setAttribute("totalAPagar", totalAPagar);
                    request.setAttribute("nSerie", numeroSerie);
                     
                    request.setAttribute("lista", lista);
                    break;
                case "Agregar":
                    //AGREGA LOS DATOS OBTENIDOS AL CARRITO
                    request.setAttribute("cliente", cli);
                    totalAPagar = 0.0;
                    Carrito carrito = (Carrito) request.getSession().getAttribute("carrito");
                    if (carrito == null) {
                        carrito = new Carrito();
                        request.getSession().setAttribute("carrito", carrito);
                    }
                    int idProducto = Integer.parseInt(request.getParameter("codigoproducto"));
                    int cantProd = Integer.parseInt(request.getParameter("cant"));
                    ProductoDAO pdao = new ProductoDAO();
                    Producto prod = pdao.listarID(idProducto);
                    carrito.agregar(prod, cantProd);
                    for (int i = 0; i < carrito.getListaLinea().size(); i++) {
                        totalAPagar = totalAPagar + carrito.getListaLinea().get(i).getSubtotal();

                    }
                    request.setAttribute("totalAPagar", totalAPagar);
                    request.setAttribute("lista", carrito.getListaLinea());
                    request.setAttribute("nSerie", numeroSerie);
                    break;

                case "GenerarVenta":
                    //SE GENERA LA VENTA
                    carrito = (Carrito) request.getSession().getAttribute("carrito");
                    //actualizamos el stock
                    for (int i = 0; i < carrito.getListaLinea().size(); i++) {
                        Producto pr = new Producto();
                        int cant = carrito.getListaLinea().get(i).getCantidad();
                        int idProdu = carrito.getListaLinea().get(i).getArticulo().getIdProd();
                        ProductoDAO prodao = new ProductoDAO();
                        pr = prodao.buscar(idProdu);
                        int stockActual = pr.getStock() - cant;
                        prodao.actualizarStock(idProdu, stockActual);
                    }

                    //guardar venta
                    totalAPagar=0.0;
                    venta.setIdCliente(cli.getIdCliente());
                    venta.setIdEmpleado(8);
                    venta.setNumSerie(numeroSerie);
                    venta.setFecha("2021/12/02");
                    venta.setMonto(totalAPagar);
                    venta.setEstado("1");
                    vdao.guardarVenta(venta);

                    //guardar detalle ventas
                    int idVentas = Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i < carrito.getListaLinea().size(); i++) {
                        venta = new Venta();
                        venta.setId(idVentas);
                        venta.setIdProducto(carrito.getListaLinea().get(i).getArticulo().getIdProd());
                        venta.setCantidad(carrito.getListaLinea().get(i).getCantidad());
                        venta.setPrecio(carrito.getListaLinea().get(i).getSubtotal());
                        vdao.guardarDetalleVentas(venta);

                    }
                    
                    break;
                /* case "Agregar":
                    //se agrega una venta
                    totalAPagar = 0.0;
                    item = item + 1;
                    codProd = prod.getIdProd();
                    descripcion = request.getParameter("nombresproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cantidad = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cantidad;
                    venta = new Venta();
                    venta.setItem(item);
                    venta.setIdProducto(codProd);
                    venta.setDescripcionP(descripcion);
                    venta.setPrecio(precio);
                    venta.setCantidad(cantidad);
                    venta.setSubTotal(subtotal);
                    lista.add(venta);
                    for (int i = 0; i < lista.size(); i++) {
                        totalAPagar = totalAPagar + lista.get(i).getSubTotal();
                    }
                    request.setAttribute("totalAPagar", totalAPagar);
                    request.setAttribute("lista", lista);

                    request.setAttribute("cliente", cli);
                    request.setAttribute("nSerie", numeroSerie);
                    break;

                case "GenerarVenta":
                    
                     //actualizamos el stock
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr = new Producto();
                        int cant = lista.get(i).getCantidad();
                        int idProdu = lista.get(i).getIdProducto();
                        ProductoDAO prodao = new ProductoDAO();
                        pr = prodao.buscar(idProdu);
                        int stockActual = pr.getStock() - cant;
                        prodao.actualizarStock(idProdu, stockActual);
                    }

                    //guardar venta
                   
                    venta.setIdCliente(cli.getIdCliente());
                    venta.setIdEmpleado(8);
                    venta.setNumSerie(numeroSerie);
                    venta.setFecha("2021/12/02");
                    venta.setMonto(totalAPagar);
                    venta.setEstado("1");
                    vdao.guardarVenta(venta);
                    
                    //guardar detalle ventas
                    int idVentas = Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        venta = new Venta();
                        venta.setId(idVentas);
                        venta.setIdProducto(lista.get(i).getIdProducto());
                        venta.setCantidad(lista.get(i).getCantidad());
                        venta.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleVentas(venta);
                        
                    }
                    
                    break; */
                default:
                    //se crea el numero de serie
                    numeroSerie = vdao.GenerarSerie();
                    if (numeroSerie == null) {
                        numeroSerie = "00000001";
                        request.setAttribute("nSerie", numeroSerie);
                    } else {
                        int incrementar = Integer.parseInt(numeroSerie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroSerie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nSerie", numeroSerie);
                    }

                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);

            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
    }

    /*  
                    item = item +1;
                    codProd = prod.getIdProd();
                    descripcion = request.getParameter("nombresproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cantidad =Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cantidad;
                    venta.setItem(item);
                    venta.setId(codProd);
                    venta.setDescripcionP(descripcion);
                    venta.setPrecio(precio);
                    venta.setCantidad(cantidad);
                    venta.setSubTotal(subtotal);
                    lista.add(venta);*/
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
