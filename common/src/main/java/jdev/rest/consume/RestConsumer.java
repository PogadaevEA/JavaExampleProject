package jdev.rest.consume;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;

/**
 * Created by epogadaev on 09.11.2018.
 */
public class RestConsumer {
    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            String response = IOUtils.toString(new URL("http://localhost:8080/counter?name=The+Who"), "UTF8");
            System.out.println(response);

            response = IOUtils.toString(new URL("http://localhost:8080/coords?location=lat56.4,lon34.6"), "UTF8");
            System.out.println(response);

            response = IOUtils.toString(new URL("http://localhost:8080/coords?location=lat56.4"), "UTF8");
            System.out.println(response);

            try {
                response = IOUtils.toString(new URL("http://localhost:8080/coords"), "UTF8");
                System.out.println(response);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("======================================================================");
                Thread.sleep(3000);
            }
        }
    }
}
