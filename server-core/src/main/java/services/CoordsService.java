package services;

import jdev.dto.PointDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by epogadaev on 13.11.2018.
 */
@Log4j
@Service
public class CoordsService {

    public void putCoords(List<PointDTO> pointDTOList) throws IOException{
        if (pointDTOList != null && !pointDTOList.isEmpty()) {
            FileWriter fileWriter = new FileWriter("H:\\JavaExampleProject\\server-core\\src\\main\\resources\\coords.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (PointDTO pointDTO : pointDTOList){
                log.warn("Saving point on server: " + pointDTO.toString());
                printWriter.println(pointDTO.toString());
            }
            printWriter.close();
        }

    }
}
