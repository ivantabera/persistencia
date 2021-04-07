package com.stayhome.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {

    public static void crearMensajeDB(Mensajes mensaje){

        //Se invoca el objeto Conexion
        Conexion dbConnect = new Conexion();

        //Nos conectamos a la BD
        try (Connection conexion = dbConnect.get_connection()){

            PreparedStatement ps = null;

            //Insercion de los datos a la BD
            try{

                String query =  "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES ( ?, ?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("El mensaje fue creado correctamente");

            } catch (SQLException ex){
                System.out.println(ex);
            }

            //Mostramos la excepcion si es que no nos podemos conectar a la BD
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void leerMensajesDB(){
        //Se invoca el objeto Conexion
        Conexion dbConnect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        //Nos conectamos a la BD
        try (Connection conexion = dbConnect.get_connection()){
            String query = "Select * from mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println("ID: " + rs.getInt("id_mensaje") );
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha"));
                System.out.println("");
            }

        //Mostramos la excepcion si es que no nos podemos conectar a la BD
        } catch (SQLException e){
            System.out.println("No se pudieron recuperar los mensajes");
            System.out.println(e);
        }
    }

    public static void borrarMensajeDB(int id_mensaje){
        //Se invoca el objeto Conexion
        Conexion dbConnect = new Conexion();

        //Nos conectamos a la BD
        try (Connection conexion = dbConnect.get_connection()){

            PreparedStatement ps = null;

            try {

                String query =  "DELETE FROM mensajes WHERE id_mensaje  = ? ";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("El mensaje fue borrado con exito");

            } catch (SQLException ex){
                System.out.println(ex);
            }

        //Mostramos la excepcion si es que no nos podemos conectar a la BD
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void actualizarMensajeDB(Mensajes mensaje){

    }
}
