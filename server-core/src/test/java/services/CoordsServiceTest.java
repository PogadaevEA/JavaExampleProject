package services;

import org.junit.Test;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static org.junit.Assert.*;

/**
 * Created by epogadaev on 13.11.2018.
 */
public class CoordsServiceTest {
    @Test
    public void putCoords() throws Exception {
        FileWriter fileWriter = new FileWriter("H:\\JavaExampleProject\\server-core\\src\\main\\resources\\coords.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        String[] array = {"Hello", "world", "!"};
        for (String entry : array){
            printWriter.println(entry);
        }
        printWriter.close();
//        String[] array = {"Hello", "world", "!"};
//        for (String entry : array) {
//            Files.write(Paths.get("H:\\JavaExampleProject\\server-core\\src\\main\\resources\\coords.txt"), entry.getBytes(), StandardOpenOption.APPEND);
//        }

    }

}