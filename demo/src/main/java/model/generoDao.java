package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class generoDao {
    // atributos
    Connection con; // objeto para la conexion
    PreparedStatement ps; // objeto para las sentencias preparadas como insert,update,select,delete
    ResultSet rs; // Objeto para almacenar los resultador de las cosultas
    String sql = null; // Variable para almacenar las sentencias de SQL
    int r;

    public int registrar(generoVo genero) throws SQLException {
        sql = "INSERT INTO genero(nombreGenero,estadoGenero) values(?,?)";
        try {
            con = conexion.conectar(); // abrir conexión
            ps = con.prepareStatement(sql); // preparar sentencia
            ps.setString(1, genero.getnombreGenero());
            ps.setBoolean(2, genero.getestadoGenero());
            System.out.println(ps);
            ps.executeUpdate(); // Ejecutar sentencia
            ps.close(); // cerrar sentencia
            System.out.println("Se registró el rol correctamente");
        } catch (Exception e) {
            System.out.println("Error en el regisro " + e.getMessage().toString());
        } finally {
            con.close();// cerrando conexión
        }
        return r;
    }

    public int actualizar(generoVo genero) throws SQLException {
        sql = "UPDATE genero set estadoGenero=" + genero.getestadoGenero() + ",nombreGenero='" + genero.getnombreGenero()
                + "'  where idGenero=" + genero.getidGenero();
        // sql = "UPDATE INTO genero(estadoGenero) values(?)";
        try {
            con = conexion.conectar(); // abrir conexión
            ps = con.prepareStatement(sql); // preparar sentenci
            System.out.println(ps);
            ps.executeUpdate(); // Ejecutar sentencia
            ps.close(); // cerrar sentencia
            System.out.println("Se actualizo el rol correctamente");
        } catch (Exception e) {
            System.out.println("Error en el regisro " + e.getMessage().toString());
        } finally {
            con.close();// cerrando conexión
        }
        return r;
    }

    public int inactivar(generoVo genero) throws SQLException {
        sql = "UPDATE genero set estadoGenero=" + genero.getestadoGenero() + " where idGenero=" + genero.getidGenero();
        // sql = "UPDATE INTO genero(estadoGenero) values(?)";
        try {
            con = conexion.conectar(); // abrir conexión
            ps = con.prepareStatement(sql); // preparar sentenci
            System.out.println(ps);
            ps.executeUpdate(); // Ejecutar sentencia
            ps.close(); // cerrar sentencia
            System.out.println("Se actualizo el rol correctamente");
        } catch (Exception e) {
            System.out.println("Error en el regisro " + e.getMessage().toString());
        } finally {
            con.close();// cerrando conexión
        }
        return r;
    }

    public List<generoVo> listar() throws SQLException {
        List<generoVo> genero = new ArrayList<>();
        sql = "SELECT * from genero";
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                generoVo r = new generoVo();
                // Escribir en el setter cada valor encontrado
                System.out.println(rs.getInt("idGenero"));
                r.setidGenero(rs.getInt("idGenero"));
                r.setnombreGenero(rs.getString("nombreGenero"));
                r.setestadoGenero(rs.getBoolean("estadoGenero"));
                genero.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa 1");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado " + e.getMessage().toString());
        } finally {
            con.close();
        }

        return genero;
    }

    public void eliminar (int idGenero) throws SQLException {
        sql="DELETE FROM genero WHERE idGenero="+idGenero;
        System.out.println(sql);
        try {
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se eliminó el genero");
        }catch(Exception e) {
            System.out.println("Error en la eliminación del registro "+e.getMessage());
        }
        finally {
            con.close();
        }
    }

}