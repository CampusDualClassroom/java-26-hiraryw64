package com.campusdual.classroom;


import com.campusdual.util.Utils;

import java.util.Scanner;

public class Exercise26 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Phonebook agenda = new Phonebook();
        int num = 0;
        do {
            opcionesMenuPrincipal();
            num = scanner.nextInt();
            menuPrincipal(num, agenda);
        } while (num != 0);
    }

    public static void opcionesMenuPrincipal() {
        System.out.println("Selecciona una acción:");
        System.out.println("1. Añadir un nuevo contacto");
        System.out.println("2. Mostrar todos los contactos");
        System.out.println("3. Seleccionar a un contacto");
        System.out.println("4. Eliminar a un contacto");
        System.out.println("0. Salir");
    }

    public static void opcionesMenuContacto() {
        System.out.println("Selecciona una acción:");
        System.out.println("1. Llamar al número");
        System.out.println("2. Llamar a otro número");
        System.out.println("3. Mostrar detalles");
        System.out.println("0. Salir");
    }

    public static void menuPrincipal(int num, Phonebook agenda) {
        switch (num) {
            case 1:
                agenda.addContact(datosNuevoContacto());
                break;
            case 2:
                agenda.showPhonebook();
                break;
            case 3:
                scanner.nextLine();
                System.out.println("Escribe el código del contacto para buscarlo");
                String codigoABuscar = scanner.nextLine();
                Contact contacto = agenda.selectContact(codigoABuscar);
                if (contacto != null) {
                    do {
                        opcionesMenuContacto();
                        num = scanner.nextInt();
                        menuContacto(num, contacto);
                    } while (num != 0);
                }
                break;
            case 4:
                scanner.nextLine();
                System.out.println("Escribe el código del contacto para borrarlo");
                String codigoParaBorrar = scanner.nextLine();
                agenda.deleteContact(codigoParaBorrar);
                break;
            case 0:
                break;
            default:
                System.err.println("Escribe una opción válida");
        }
    }

    public static void menuContacto(int num, Contact contacto) {
        switch (num) {
            case 1:
                contacto.callMyNumber();
                break;
            case 2:
                scanner.nextLine();
                System.out.println("Escribe el número de teléfono al que quieres llamar");
                String otroNum = scanner.nextLine();
                contacto.callOtherNumber(otroNum);
                break;
            case 3:
                contacto.showContactDetails();
                break;
            case 0:
                break;
            default:
                System.err.println("Escribe una opción válida");
        }
    }

    public static Contact datosNuevoContacto() {
        scanner.nextLine();
        System.out.println("Escribe el nombre del nuevo contacto");
        String nombre = scanner.nextLine();
        System.out.println("Ahora sus apellidos");
        String apellidos = scanner.nextLine();
        System.out.println("Y finalmente su número de teléfono");
        String telf = scanner.nextLine();

        return new Contact(nombre, apellidos, telf);
    }
}