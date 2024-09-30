package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private Map<String, Contact> agenda;

    public Phonebook() {
        this.agenda = new HashMap<>();
    }

    public Map<String, Contact> getData() {
        return agenda;
    }

    public void addContact(Contact contacto) {
        agenda.put(contacto.getCode(), contacto);
    }

    public void showPhonebook() {
        for (Contact c : agenda.values()) {
            c.showContactDetails();
        }
    }

    public void deleteContact(String codigo) {
        if (agenda.containsKey(codigo)) {
            agenda.remove(codigo);
        } else {
            System.err.println("Contacto no encontrado");
        }
    }

    public Contact selectContact(String codigo) {
        if (agenda.containsKey(codigo)) {
            Contact contactoSeleccionado = agenda.get(codigo);
            return contactoSeleccionado;
        } else {
            System.err.println("Contacto no encontrado");
            return null;
        }
    }
}