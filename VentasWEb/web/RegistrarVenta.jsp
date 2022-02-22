
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <style>
            @media print{
                .parte01,.btn,.accion{
                    display:none;
                }
                
            }   
        </style>
    </head>
    <body>
         <!--FORMULARIO PARA AGREGAR UN PRODUCTO AL CARRITO-->
        <div class="d-flex">
            <div class="col-sm-5 parte01">
                <div  class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del cliente</label>
                            </div>
                            <div class="form-group d-flex ">
                                <div class="col-sm-4 m-1 d-flex">
                                    <input type="text" value="${cliente.getDni()}" name="codigocliente"  class="form-control" placeholder="DNI">
                                </div>                                 
                                        <button type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info col-sm-3 m-1">Buscar Cliente</button>                                  

                                <div class="col-sm-4 m-1">
                                    <input type="text" name="nombrescliente" value="${cliente.getNombres()}" class="form-control">
                                </div>
                            </div>
                                    
                            <!-- datos del producto-->
                            <div class="form-group">
                                <label>Datos Producto</label>
                            </div>
                            <div class="form-group d-flex ">
                                <div class="col-sm-4 m-1 d-flex">
                                    <input type="text" value="${producto.getIdProd()}"  name="codigoproducto" class="form-control" placeholder="codigo">
                                   

                                </div>
                                     <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info col-sm-3 m-1">Buscar Producto</button>
                                <div class="col-sm-4 m-1">
                                    <input type="text" name="nombresproducto" value="${producto.getNombres()}" class="form-control">

                                </div>
                            </div>
                                    <br>
                            <div class="form-group d-flex ">
                                <div class="col-sm-4 d-flex m-1">
                                    <input type="text" value="${producto.getPrecio()}" name="precio" class="form-control" placeholder="$/ 0.00">

                                </div>
                                <div class="col-sm-3 m-1">
                                    <input type="number" value="1" name="cant" class="form-control">

                                </div>
                                <div class="col-sm-3 m-1">
                                    <input type="text" value="${producto.getStock()}" name="stock" class="form-control" placeholder="stock">

                                </div>
                            </div>
                                    <br>
                            <div class="form-group ">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info col-sm-4">Agregar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
                                     <!--CARRITO-->
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-4 ml-auto">
                            <label>Numero Serie</label>
                            <input type="text" name="numeroSerie" value="${nSerie}" class="form-control">
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                  
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                   <!-- <th class="accion">Acciones</th>-->
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="list" items="${lista}">
                                <tr>
                                    <td>${list.getArticulo().getIdProd()}</td>
                                    <td>${list.getArticulo().getNombres()}</td>
                                     <td>${list.getArticulo().getPrecio()}</td>
                                 <!--   <td>{list.getItem()}</td>
                                    <td>{list.getDescripcionP()}</td>
                                    <td>{list.getPrecio()}</td>-->
                                    
                                      <td>${list.getCantidad()}</td>
                                     <!-- <td>{list.getSubTotal()}</td>-->
                                      <td>${list.getSubtotal()}</td>
                                   <!--   <td>
                                          <a href=""  class="btn btn-warning">Editar</a>
                                          <a href=""  class="btn btn-danger">Borrar</a>
                                      </td>-->
                                        
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>
                    
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>                      
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                        <div class="col-sm-3 ml-auto">
                            <input type="text" name="txtTotal" value="$/. ${totalAPagar}0" class="form-control">
                        </div>
                    </div>

                </div>

            </div>
        </div>



        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
