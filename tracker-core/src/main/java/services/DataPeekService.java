package services;

import de.micromata.opengis.kml.v_2_2_0.Coordinate;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Point;
import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

/**
 * Created by epogadaev on 09.11.2018.
 * Реализует сбор данных и последующую отправку
 */
public class DataPeekService {

    private DataSentService dataSentService;

    public DataPeekService(DataSentService dataSentService){
        this.dataSentService = dataSentService;
    }
    final Kml kml = Kml.unmarshal(new File("Tomsk_Moscow.kml"));

    public PointDTO getCoorinates() {
        final Placemark placemark = (Placemark) kml.getFeature();
        Point point = (Point) placemark.getGeometry();
        List<Coordinate> coordinates = point.getCoordinates();
        return new PointDTO();


    }

}
