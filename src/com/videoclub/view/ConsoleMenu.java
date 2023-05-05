package com.videoclub.view;

import com.videoclub.lib.Input;
import com.videoclub.controller.*;
import com.videoclub.model.Multimedia;
import com.videoclub.model.Socio;

import java.util.ArrayList;

public class ConsoleMenu {
    GestorSocioController myGestorSocioController;
    GestorAlquilerController myGestorAlquilerController;
    InventarioController inventarioController;


    public ConsoleMenu() {
        myGestorAlquilerController = new GestorAlquilerController();
        myGestorSocioController = new GestorSocioController();
        inventarioController = new InventarioController();
    }


    public void menuPrincipal() {

        boolean exit = false;

        while (!exit) {
            System.out.println("### MENU ###");
            System.out.println("[1] Altas");
            System.out.println("[2] Alquilar Multimedia a Socio");
            System.out.println("[3] Devolver Multimedia a Socio");
            System.out.println("[4] Listar");
            System.out.println("[0] Salir");
            System.out.println("--- ---- ---");

            int userAnswer = Input.readInput("Option: ", "int");

            switch (userAnswer) {
                default:
                    System.out.println("Valor no Valido!");
                    break;
                case 0:
                    exit = true;
                    break;
                case 1:
                    menuAltas();
                    break;
                case 2:
                    alquilarMultimediaSocio();
                    break;
                case 3:
                    break;
                case 4:
                    menuListar();
                    break;
            }
        }
    }


    public void menuAltas() {
        System.out.println("### ALTAS MENU ###");
        System.out.println("[1] Alta a Socio");
        System.out.println("[2] Alta a Pelicula");
        System.out.println("[3] Alta a Videojuego");
        System.out.println("[0] Salir");
        System.out.println("--- ---- ---- ---");

        int userAnswer = Input.readInput("Option: ", "int");

        switch (userAnswer) {
            default:
                System.out.println("Valor No Valido!");
                break;
            case 0:
                break;
            case 1:
                String nif = Input.readInput("NIF: ", "String");
                String nombre = Input.readInput("Nombre: ", "String");
                String fechaNac = Input.readInput("Fecha Nac (dd/mm/yyyy): ", "String");
                String poblacion = Input.readInput("Poblacion: ", "String");

                myGestorSocioController.crearSocio(nif, nombre, fechaNac, poblacion);
                break;
            case 2:
                promptMultimedia(userAnswer);
                break;
            case 3:
                promptMultimedia(userAnswer);
                break;
        }
    }


    public void promptMultimedia(int userAnswer) {
        if (userAnswer == 2 || userAnswer == 3) {
            String titulo = Input.readInput("Titulo: ", "String");
            String autor = Input.readInput("Autor: ", "String");
            String formato = Input.readInput("Formato: ", "String");
            int anyo = Input.readInput("Año: ", "int");
            int duracion = Input.readInput("Duracion: ", "int");

            if (userAnswer == 2) {
                String actorPrincipal = Input.readInput("Actor Principal: ", "String");
                String atrizPrincipal = Input.readInput("Actriz Principal: ", "String");

                inventarioController.createMultimedia("pelicula", titulo, autor, formato, anyo, duracion, actorPrincipal, atrizPrincipal, formato);
            } else if (userAnswer == 3) {
                String plataforma = Input.readInput("Plataforma: ");

                inventarioController.createMultimedia("videojuego", titulo, autor, formato, anyo, duracion, null, null, plataforma);
            }
        }
    }

    public void menuListar() {
        System.out.println("### LISTAR MENU ###");
        System.out.println("[1] Listado de todos los objetos multimedia");
        System.out.println("[2] Listado de todas las películas ordenadas por título");
        System.out.println("[3] Listado de todas las canciones de un disco por duración");
        System.out.println("[4] Listado de todos los videojuegos ordenados por año");
        System.out.println("[5] Listado de los alquileres actuales de un socio");
        System.out.println("[6] Listado de los socios con recargos pendientes");
        System.out.println("[7] Salir");
        System.out.println("--- ------ ---- ---");
    }


    public void alquilarMultimediaSocio() {
        String nif = Input.readInput("Introduzca su nif: ", "String");
        String respuesta;
        if (myGestorSocioController.existeSocio(nif)) {
            if (!myGestorAlquilerController.tieneDeudas(myGestorSocioController.buscarSocio(nif))) {
                respuesta = Input.readInput("Desea alquilar una pelicula, un videojuego o un disco?", "String");
                switch (respuesta) {
                    case "pelicula" -> inventarioController.mostrarPeliculas(myGestorSocioController.buscarSocio(nif));

                    case "videojuego" ->
                            inventarioController.mostrarVideojuegos(myGestorSocioController.buscarSocio(nif));

                    case "disco" -> inventarioController.mostrarDiscos(myGestorSocioController.buscarSocio(nif));
                }
            } else {
                System.out.println("Tienes una deuda pendiente, tienes que pagar para poder seguir alquilando");
            }
        } else {
            System.out.println("Introduzca un DNI valido que exista en la base de datos");
        }
    }

    public void listarAlquileresSocio() {
        String nif = Input.readInput("Introduzca su nif: ", "String");
        Socio socio = null;

        try {
            socio = myGestorSocioController.buscarSocio(nif);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}



