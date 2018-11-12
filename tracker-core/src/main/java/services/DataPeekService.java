package services;

import de.micromata.opengis.kml.v_2_2_0.*;
import jdev.dto.PointDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * Created by epogadaev on 09.11.2018.
 * Реализует сбор данных и последующую отправку
 */
@Service
public class DataPeekService {

    private DataSentService dataSentService;

    public DataPeekService(DataSentService dataSentService){
        this.dataSentService = dataSentService;
    }
    final Kml kml = Kml.unmarshal(new File("/Users/egor/Работа/StudyProjects/Projects/JavaExampleProject/tracker-core/src/test/resources/Tomsk_Moscow.kml"));

    public PointDTO getCoorinates() {

        final Placemark placemark = (Placemark) kml.getFeature();
        LineString lineString = (LineString) placemark.getGeometry();
        List<Coordinate> coordinates = lineString.getCoordinates();

        return new PointDTO();


    }

}
