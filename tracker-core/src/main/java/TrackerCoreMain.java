import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import services.DataPeekService;

/**
 * Created by epogadaev on 09.11.2018.
 */
@SpringBootApplication
@ComponentScan({"controllers","services"})
public class TrackerCoreMain {
    public static void main(String[] args) {
        SpringApplication.run(TrackerCoreMain.class, args);
    }

}
