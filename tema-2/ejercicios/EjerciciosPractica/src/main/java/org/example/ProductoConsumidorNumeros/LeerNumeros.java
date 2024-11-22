package org.example.ProductoConsumidorNumeros;


public class LeerNumeros extends Thread {

    ColaNumeros colaNumeros;

    public LeerNumeros(){
        colaNumeros = ColaNumeros.getInstance();
    }

    @Override
    public void run(){
        while (true){
            try {
                colaNumeros.leerNumero();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
