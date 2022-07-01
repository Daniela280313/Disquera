<%@include file="header.jsp" %>


    <h1  align="center">Registro de Genero</h1>

    <form method="post" action="Sgenero">
        <div class="form-control">
            <label for="descripcion">abrir formulario</label>
            <input type="text" name="id" id="id" class="form-control" style="display: none;" value="${idgenero}">

            <input type="text" name="descripcion" id="descripcion" class="form-control" value="${descripcion}">
        </div>

        <div class="form-check">
            <input type="checkbox" name="chkestado" id="chkestado" checked class="form-check-input">
            <label for="chkestado"> Activo</label>
        </div>

        <div>
            <c:if test="${update == 'SI'}">
                <button type="submit" class="btn btn-warning" name="accion" value="editgenero">Actualizar</button>
            </c:if>
            <c:if test="${update == 'NO'}">
                <button type="submit" class="btn btn-success" name="accion" value="add">Guardar</button>
            </c:if>
        </div>
    </form>

    <%@include file="footer.jsp" %>