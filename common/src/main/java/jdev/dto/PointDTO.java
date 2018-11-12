package jdev.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.micromata.opengis.kml.v_2_2_0.Coordinate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by epogadaev on 07.11.2018.
 */
@NoArgsConstructor
@AllArgsConstructor
public class PointDTO {
    @Getter @Setter private double lat;
    @Getter @Setter private double lon;
    @Getter @Setter private String autoId = "K169XP70";

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    @Override
    public String toString() {
        return "PointDTO{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", autoId='" + autoId + '\'' +
                '}';
    }

    public PointDTO(Coordinate coordinate){
        this.lat = coordinate.getLatitude();
        this.lon = coordinate.getLongitude();
    }

}
