package com.stayhome.mensajes_app;

import java.util.Scanner;

public class MensajesService {
    
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Tu nombre");
        String nombre = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutorMensaje(nombre);

        //Enviamos la informacion a la capa DAO
        MensajesDAO.crearMensajeDB(registro);
    }

    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB();
    }

    public static void borrarMensaje(){
        //Damos lectura a la insercion por medio de teclado
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe el Id del mensaje que deseas borrar");
        Integer id = sc.nextInt();

        //Enviamos la informacion a la capa DAO
        MensajesDAO.borrarMensajeDB(id);
    }

    public static void editarMensaje(){
        //Damos lectura a la insercion por medio de teclado
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe el mensaje nuevo");
        String mensaje = sc.nextLine();

        System.out.println("Escribe el Id del mensaje que deseas editar");
        Integer id = sc.nextInt();

        Mensajes actualiza = new Mensajes();
        actualiza.setMensaje(mensaje);
        actualiza.setId_mensaje(id);

        MensajesDAO.actualizarMensajeDB(actualiza);

    }

}
