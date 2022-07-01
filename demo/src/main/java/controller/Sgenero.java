package controller;

import java.util.List;
import java.io.IOException;
//servlet
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//importar modelo
import model.generoDao;
import model.generoVo;

public class Sgenero extends HttpServlet {

    generoDao rdao = new generoDao();
    generoVo r = new generoVo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String accion = req.getParameter("accion");

        switch (accion) {
            case "abrirForm":
                abrirForm(req, resp);
                break;

            case "listar":
                listar(req, resp);
                break;

            case "inactivar":
                inactivarGenero(req, resp);
                break;

            case "editar":
                abrirFormEdit(req, resp);
                break;
            case "eliminar":
                eliminar(req, resp);
                break;

        }

        // generar metodo doget y post de mis vistas
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String accion = req.getParameter("accion");
        System.out.println(accion);

        switch (accion) {
            case "add":
                addgenero(req, resp);
                break;
                case "editgenero":
                editgenero(req, resp);
                break;
            }
            
        }
        
        private void abrirForm(HttpServletRequest req, HttpServletResponse resp) {
            try {
            req.setAttribute("update", "NO");
            req.getRequestDispatcher("views/addgenero.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        } catch (Exception e) {
            System.out.println("El formulario NO ha sido abierto" + e.getMessage().toString());
        }
    }

    private void abrirFormEdit(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.println("El id" + req.getParameter("id"));
            generoVo r = new generoVo();
            if (req.getParameter("id") != null) {
                r.setidGenero(Integer.parseInt(req.getParameter("id")));
            }
            boolean estado = Boolean.valueOf(req.getParameter("estado"));

            if (req.getParameter("estado") != null && estado) {
                r.setestadoGenero(false);
            } else {
                r.setestadoGenero(true);
            }
            if (req.getParameter("descripcion") != null) {
                r.setnombreGenero(req.getParameter("descripcion"));
            }

            System.out.println("El id" + r.getnombreGenero());
            req.setAttribute("update", "SI");
            req.setAttribute("idgenero", r.getidGenero());
            req.setAttribute("descripcion", r.getnombreGenero());

            req.getRequestDispatcher("views/addgenero.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        } catch (Exception e) {
            System.out.println("El formulario NO ha sido abierto" + e.getMessage().toString());
        }
    }

    private void inactivarGenero(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("Entró al addGenero");

        generoDao rdao = new generoDao();
        generoVo r = new generoVo();
        if (req.getParameter("id") != null) {
            r.setidGenero(Integer.parseInt(req.getParameter("id")));
        }
        System.out.println(req.getParameter("estado"));

        boolean estado = Boolean.valueOf(req.getParameter("estado"));

        if (req.getParameter("estado") != null && estado) {
            r.setestadoGenero(false);
        } else {
            r.setestadoGenero(true);
        }

        try {
            rdao.inactivar(r);
            resp.sendRedirect("Sgenero?accion=listar");
            System.out.println("Registro insertado correctamente");
        } catch (Exception e) {
            req.setAttribute("msje", "no se pudo registrar el Rol" + e.getMessage());
            System.out.println("Error en la inserción del registro " + e.getMessage().toString());
        }
    }

    private void addgenero(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("Entró al addGenero");

        generoDao rdao = new generoDao();
        generoVo r = new generoVo();
        if (req.getParameter("descripcion") != null) {
            r.setnombreGenero(req.getParameter("descripcion"));
        }
        if (req.getParameter("chkestado") != null) {
            r.setestadoGenero(true);
        } else {
            r.setestadoGenero(false);
        }
        try {
            rdao.registrar(r);
            resp.sendRedirect("Sgenero?accion=listar");
            System.out.println("Registro insertado correctamente");
        } catch (Exception e) {
            req.setAttribute("msje", "no se pudo registrar el Rol" + e.getMessage());
            System.out.println("Error en la inserción del registro " + e.getMessage().toString());
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) {
        generoDao rdao = new generoDao();
        try {
            List<generoVo> genero = rdao.listar();
            req.setAttribute("roles", genero);
            req.getRequestDispatcher("views/generos.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente 8");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }

    private void editgenero(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("Entró al editGenero");

        generoDao rdao = new generoDao();
        generoVo r = new generoVo();
        if (req.getParameter("id") != null) {
            r.setidGenero(Integer.parseInt(req.getParameter("id")));
        }

        if (req.getParameter("descripcion") != null) {
            r.setnombreGenero(req.getParameter("descripcion"));
        }
        if (req.getParameter("chkestado") != null) {
            r.setestadoGenero(true);
        } else {
            r.setestadoGenero(false);
        }
        try {
            rdao.actualizar(r);
            resp.sendRedirect("Sgenero?accion=listar");
            System.out.println("Registro actualizado correctamente");
        } catch (Exception e) {
            req.setAttribute("msje", "no se pudo actualizar el genero" + e.getMessage());
            System.out.println("Error en la inserción del registro " + e.getMessage().toString());
        }
    }

    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
   
        if(req.getParameter("id")!=null) {
            r.setidGenero(Integer.parseInt(req.getParameter("id")));
        }
        try{
            rdao.eliminar(r.getidGenero());
            resp.sendRedirect("Sgenero?accion=listar");
            System.out.println("Eliminado");
        }catch(Exception e){
            req.setAttribute("msje", "No se pudo eliminar el registro" + e.getMessage());
            System.out.println("No se pudo eliminar el registro" + e.getMessage());
        }finally{
            
        }
    }
}
