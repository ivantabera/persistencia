package com.stayhome.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    }

    public static void borrarMensajeDB(int id_mensaje){

    }

    public static void actualizarMensajeDB(Mensajes mensaje){

    }
}
