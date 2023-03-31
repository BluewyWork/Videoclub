package VIDEOCLUB;

import java.util.Scanner;

public class Videoclub {
    public static void main(String[] args) {

        int respuesta = menuOpciones(false);

        while (respuesta != 5) {
            switch (respuesta) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
            respuesta = menuOpciones(false);
        }
    }
    public static int menuOpciones(boolean error) {

        Scanner sc = new Scanner(System.in);
        if (error) System.out.println("SOLAMENTE UN VALOR ENTRE EL 1 Y EL 5");
        System.out.println("[1] ALTAS");
        System.out.println("[2] ALQUILAR MULTIMEDIA A SOCIO");
        System.out.println("[3] DEVOLVER MULTIMEDIA");
        System.out.println("[4] LISTADOS");
        System.out.println("[5] SALIR");
        System.out.println("INTRODUCE UN VALOR ENTRE EL 1 Y EL 5");
        int respuesta = sc.nextInt();
        while (respuesta < 1 || respuesta > 5) {
            respuesta = menuOpciones(true);
        }
        return respuesta;
    }

    public static int subMenuOpciones(boolean error) {

        Scanner sc = new Scanner(System.in);
        if (error) System.out.println("SOLAMENTE UN VALOR ENTRE EL 1 Y EL 4");
        System.out.println("[1] ALTA DE UNA NUEVA PELICULA");
        System.out.println("[2] ALTA DE UN NUEVO VIDEOJUEGO");
        System.out.println("[3] ALTA DE UN NUEVO SOCIO");
        System.out.println("[4] VOLVER");
        System.out.println("INTRODUCE UN VALOR ENTRE EL 1 Y EL 4");
        int respuesta = sc.nextInt();
        while (respuesta < 1 || respuesta > 4) {
            respuesta = subMenuOpciones(true);
        }
        return respuesta;
    }

    public static int subMenuOpciones2(boolean error) {

        Scanner sc = new Scanner(System.in);
        if (error) System.out.println("SOLAMENTE UN VALOR ENTRE EL 1 Y EL 7");
        System.out.println("[1] LISTADO DE TODOS LOS OBJETOS MULTIMEDIA");
        System.out.println("[2] LISTADO DE LAS PELICULAS ORDENADAS POR TITULO");
        System.out.println("[3] LISTADO DE VIDEOJUEGOS ORDENADOS POR ANIO");
        System.out.println("[4] HISTORICO DE ALQUILERES DE UN SOCIO ORDENADOS POR FECHA DE ALQUILER");
        System.out.println("[5] ALQUILERES ACTUALES DE UN SOCIO");
        System.out.println("[6] SOCIOS CON RECARGOS PENDIENTES");
        System.out.println("[7] VOLVER");
        System.out.println("INTRODUCE UN VALOR ENTRE EL 1 Y EL 7");
        int respuesta = sc.nextInt();
        while (respuesta < 1 || respuesta > 7) {
            respuesta = subMenuOpciones2(true);
        }
        return respuesta;
    }
}
