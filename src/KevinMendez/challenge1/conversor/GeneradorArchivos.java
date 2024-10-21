package KevinMendez.challenge1.conversor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeneradorArchivos {

    public void generador(ConverterAndDates c ) throws IOException {
        Gson gson= new GsonBuilder().create();

        FileWriter archivo = new FileWriter("Datos.txt");
        archivo.write(gson.toJson(c));
        archivo.close();

    }
}
