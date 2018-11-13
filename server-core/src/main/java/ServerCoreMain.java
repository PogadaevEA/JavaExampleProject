import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by epogadaev on 13.11.2018.
 */
@SpringBootApplication
@ComponentScan({"controllers","services"})
public class ServerCoreMain {
    public static void main(String[] args) {
        SpringApplication.run(ServerCoreMain.class, args);
    }
}
