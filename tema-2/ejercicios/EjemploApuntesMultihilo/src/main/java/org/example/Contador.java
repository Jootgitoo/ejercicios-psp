package org.example;

public class Contador {

    private int cuenta = 0;


    // Método sincronizado para incrementar la cuenta
    public synchronized void incrementar() {
        cuenta++;
    }

    // Método para obtener el valor de la cuenta
    public synchronized int getCuenta() {
        return cuenta;
    }
}
