package jdev.dto;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by epogadaev on 08.11.2018.
 */
public class PointDTOTest {
    @Test
    public void toJson() throws Exception {
        PointDTO pointDTO = new PointDTO();
        pointDTO.setLat(56);
        pointDTO.setLon(74);
        pointDTO.setAutoId("к169хр70");
        assertTrue(pointDTO.toJson().contains("\"lat\":56"));
        System.out.println(pointDTO.toString());
    }

}