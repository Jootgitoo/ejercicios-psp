package com.psp.dos.sumador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

//SI HACES ESTE EJERCICIO DE O:
// - classPath = "./files"
// - crear un  directorio llamado files


/**
 * Creador de procesos que ejecuta la clase java com.psp.Multiplicador
 *
 * @author Santa Ar�valo Ar�valo
 *
 */
public class Lanzador {

    public void lanzarSumador(int n1, int n2, String fNombreSalida) throws IOException, InterruptedException{
        String clase = "com.psp.dos.sumador.Sumador";
        ProcessBuilder pb;
        Process process = null;
        int exitValue;
        try {
            String classPath = ".;./target/classes";

            pb = new ProcessBuilder("java", "-cp", classPath, clase, String.valueOf(n1),
                    String.valueOf(n2));
            //
            pb.redirectError(new File("files" + File.separator + "error_"+System.currentTimeMillis()+".log"));
            //Escribir datos generados por sumador en un fichero
            pb.redirectOutput(new File("files" + File.separator + fNombreSalida));

            // Cambia el directorio de trabajo, al directorio donde se encuentran los .class
            //pb.directory(new File("bin"));

            process = pb.start();

            //el proceso padre, espera a que el proceso hijo termine
            //devuelve el valor de salida, del proceso hijo (de process)
            exitValue = process.waitFor();
            System.out.println("Exit Value: "+exitValue);


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw e;
        }


    }


    public void lanzarSumador2(int n1, int n2) throws IOException{
        String clase = "./sumador";
        ProcessBuilder pb;
        Process process = null;
        try {
            pb = new ProcessBuilder("java", clase, String.valueOf(n1),
                    String.valueOf(n2));
            //
            pb.redirectError(new File("files" + File.separator + "error.log"));
            // Cambia el directorio de trabajo, al directorio donde se encuentran los .class
            pb.directory(new File("bin"));
            pb.redirectOutput(new File("files" + File.separator + "salida.log"));

            process = pb.start();

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Se ejecutan dos procesos, que realizan la multiplicaci�n de dos n�meros y
     * devuelven el resultado cada uno por salida est�ndar
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws Exception {
        Lanzador l = new Lanzador();
        l.lanzarSumador(23, 7, "salida.log");
    }
}