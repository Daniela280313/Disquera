<%@include file="header.jsp" %>


  <h1>Actualizar generos</h1>

  <form method="post" action="Sgenero">

      <input type="text" class="form-control" name="id" value="${Sgenero.idGenero}"/>

      <div class="form-group">
          <label for="descripcion">Descripci�n</label>
          <input type="text" class="form-control" name="descripcion" id="descripcion" placeholder="Ingrese la descripci�n" value="${Sgenero.getnombreGenero()}">
      </div>

      <div class="form-check">

  <input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" 
  <c:out value="${Sgenero.getestadoGenero() == false} 'unchecked':'checked'}" default=""/> </div>>
  <label class="form-check-label" for="flexCheckChecked">
    ${Sgenero.getestadoGenero() == false} 'Marca la casilla para activar':'Desmarca la casilla para Inactivar'}
  </label>
</div>

<div>
  <button type="submit" class="btn btn-primary" name="accion" value="editgenero">Guardar</button>
</div>

  </form> 

<%@include file="footer.jsp" %>