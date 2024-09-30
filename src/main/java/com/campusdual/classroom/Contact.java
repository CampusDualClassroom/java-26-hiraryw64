package com.campusdual.classroom;

import java.text.Normalizer;

public class Contact implements ICallActions {
    private String nombre, apellidos, numTel, codigo;

    public Contact(String nombre, String apellidos, String numTel) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numTel = numTel;
        this.codigo = generarCodigo(nombre, apellidos);
    }

    public String getName() {
        return nombre;
    }

    public String getSurnames() {
        return apellidos;
    }

    public String getPhone() {
        return numTel;
    }

    public String getCode() {
        return codigo;
    }

    public String generarCodigo(String nombre, String apellidos) {
        StringBuilder codigo = new StringBuilder();
        String nombreEditado = editarString(nombre);
        String apellidosEditados = editarString(apellidos);

        codigo.append(nombreEditado.charAt(0));

        if (apellidosEditados.contains(" ")) {
            String[] apellidosSeparados = apellidosEditados.split(" ");
            for (int i = 0; i < apellidosSeparados.length; i++) {
                if (i == 0) {
                    codigo.append(apellidosSeparados[i].charAt(0));
                } else {
                    codigo.append(apellidosSeparados[i]);
                }
            }
            apellidosEditados = apellidosEditados.replaceAll(" ", "-");

        } else {
            codigo.append(apellidosEditados);
        }
        System.out.println(codigo.toString());
        return codigo.toString();
    }

    private String editarString(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
    }

    @Override
    public void callMyNumber() {
        System.out.println("Llamando a " + this.nombre + " " + this.apellidos + " con número " + this.numTel);
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println("Llamando al número " + number + " desde el móvil de " + this.nombre + " " + this.apellidos);
    }

    @Override
    public void showContactDetails() {
        System.out.println(this.codigo);
        System.out.println(this.nombre + " " + this.apellidos);
        System.out.println("Teléfono: " + this.numTel);
    }
}
