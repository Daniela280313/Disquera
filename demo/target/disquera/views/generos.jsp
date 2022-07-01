<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <%@include file="header.jsp" %>

        <div class="flex-fill flex-grow-1 ms-3">

            <h1 align="center" >Lista de Roles</h1>
            <a type="button" class="btn btn-success" href="Sgenero?accion=abrirForm">
                <i class="bi bi-plus-circle"></i>
                Agregar Rol
            </a>

            <table class="table table-dark">

                <tr>
                    <th>Id</th>
                    <th>Descripción</th>
                    <th>
                        <center>Estado</center>
                    </th>
                    <th colspan="2">
                        <center>Acciones </center>
                    </th>
                </tr>
                <c:forEach var="Sgenero" items="${roles}">
                    <tr>
                        <td>${Sgenero.getidGenero()}</td>
                        <td>${Sgenero.getnombreGenero()}</td>
                        <c:if test="${Sgenero.getestadoGenero() == true}">
                            <td><span class="badge bg-success active">Rol Activo</span></td>
                        </c:if>
                        <c:if test="${Sgenero.getestadoGenero() == false}">
                            <td><span class="badge bg-danger active">Rol Inactivo</span></td>
                        </c:if>

                        <td>
                            <c:if test="${Sgenero.getestadoGenero() == true}">
                                <a rol="button" class="btn btn-danger btn-sm" href="Sgenero?accion=inactivar&id=${Sgenero.getidGenero()}&estado=${Sgenero.getestadoGenero()}">
                                    Inactivar
                                </a>
                            </c:if>
                            <c:if test="${Sgenero.getestadoGenero() == false}">
                                <a rol="button" class="btn btn-success btn-sm" href="Sgenero?accion=inactivar&id=${Sgenero.getidGenero()}&estado=${Sgenero.getestadoGenero()}">
                                    Activar
                                </a>
                            </c:if>
                        </td>


                        <td>
                            <a rol="button" class="btn btn-warning" href="Sgenero?accion=editar&id=${Sgenero.getidGenero()}&estado=${Sgenero.getestadoGenero()}&descripcion=${Sgenero.getnombreGenero()}">
                               Editar <i class="bi bi-pencil"></i>
                            </a>
                            <a rol="button" class="btn btn-danger" onclick="borrar(event,'${Sgenero.getidGenero()}','Sgenero')">
                               Eliminar <i class="bi bi-trash"></i>
                            </a>

                        </td>
                    <tr>

                </c:forEach>


            </table>


        </div>
        </div>


        <%@include file="footer.jsp" %>