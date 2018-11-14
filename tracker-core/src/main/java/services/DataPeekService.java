package services;

import de.micromata.opengis.kml.v_2_2_0.*;
import jdev.dto.PointDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

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

    private  List<Coordinate> coordinates;
    private int i = 0;

    @Scheduled(fixedDelay = 60*60*1000) //каждый час
    private  void getCoordinates(){
        Kml kml = unmarshalKmlFile();
        Placemark placemark;
        placemark = (Placemark) kml.getFeature();
        LineString lineString = (LineString) placemark.getGeometry();
        coordinates = lineString.getCoordinates();
    }

    @Scheduled(cron = "${cron.prop.get}") //каждые 5 cек
    public void getPointDTOFromKmlFile() {
        if (coordinates.get(i) != null) {
            log.info("Getting new point: lat = " + coordinates.get(i).getLatitude() + ", lon = " + coordinates.get(i));
            dataSaveService.savePointDTO(new PointDTO(coordinates.get(i)));
            i++;
        } else {
            i = 0;
            dataSaveService.savePointDTO(new PointDTO(coordinates.get(i)));
        }

    }

    private Kml unmarshalKmlFile() {
//        return Kml.unmarshal(new File("H:\\JavaExampleProject\\tracker-core\\src\\main\\resources\\kmls\\Tomsk_Moscow.kml"));
        return Kml.unmarshal(new File("/Users/egor/Работа/StudyProjects/Projects/JavaExampleProject/tracker-core/src/test/resources/Tomsk_Moscow.kml"));
    }

}
