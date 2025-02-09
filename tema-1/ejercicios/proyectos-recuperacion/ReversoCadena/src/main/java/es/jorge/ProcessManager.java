package es.jorge;

import java.io.File;
import java.io.IOException;

public class ProcessManager {

    public void lanzadorProceso(String cadena) throws IOException, InterruptedException {

        Process process;

        String classPath = ".;./target/classes";

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath, "es.jorge.ReversoCadena", cadena);

        pb.redirectError(new File("files" +File.separator+ "error.txt"));
        pb.redirectOutput(new File("files" +File.separator+ "solucion.txt"));

        process = pb.start();

        int exitValue = process.waitFor();

        if(exitValue == 0 ){
            System.out.println("Proceso terminado correctamente");
        } else {
            System.out.println("Codigo error: " +exitValue);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessManager l = new ProcessManager();
        l.lanzadorProceso("hola");
    }
}