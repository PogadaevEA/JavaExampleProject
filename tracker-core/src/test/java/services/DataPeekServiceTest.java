package services;

import de.micromata.opengis.kml.v_2_2_0.*;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by epogadaev on 09.11.2018.
 */
public class DataPeekServiceTest {
    @Test
    public void getCoorinates() throws Exception {
        final Kml kml = Kml.unmarshal(new File("H:\\JavaExampleProject\\tracker-core\\src\\test\\resources\\Tomsk_Moscow.kml"));
        final Placemark placemark = (Placemark) kml.getFeature();
        LineString lineString = (LineString) placemark.getGeometry();
        List<Coordinate> coordinates = lineString.getCoordinates();
    }

}