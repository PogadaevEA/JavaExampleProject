package services;

import de.micromata.opengis.kml.v_2_2_0.*;
import jdev.dto.PointDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by epogadaev on 09.11.2018.
 * Реализует сбор данных и последующую отправку
 */
@Log4j
@Service
public class DataPeekService {

    private DataSaveService dataSaveService;

    public DataPeekService(
            DataSaveService dataSaveService
            )
    {
        this.dataSaveService = dataSaveService;
    }

    final Kml kml = Kml.unmarshal(new File("/Users/egor/Работа/StudyProjects/Projects/JavaExampleProject/tracker-core/src/test/resources/Tomsk_Moscow.kml"));


    private int i = 0;

    @Scheduled(cron = "${cron.prop.get}") //каждые 5 cек
    public void getPointDTOFromKmlFile() {

        final Placemark placemark = (Placemark) kml.getFeature();
        LineString lineString = (LineString) placemark.getGeometry();
        List<Coordinate> coordinates = lineString.getCoordinates();
        if (coordinates.get(i) != null) {
            log.info("Getting new point: lat = " + coordinates.get(i).getLatitude() + ", lon = " + coordinates.get(i));
            dataSaveService.savePointDTO(new PointDTO(coordinates.get(i)));
            i++;
        } else {
            i = 0;
            dataSaveService.savePointDTO(new PointDTO(coordinates.get(i)));
        }

    }

}
