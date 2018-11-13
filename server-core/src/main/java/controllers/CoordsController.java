package controllers;

import jdev.dto.PointDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import services.CoordsService;

import java.util.List;

/**
 * Created by epogadaev on 13.11.2018.
 */
@Log4j
@RestController
public class CoordsController {
    private CoordsService coordsService;

    public CoordsController (
            CoordsService coordsService
    ) {
        this.coordsService = coordsService;
    }

    @PostMapping("/coords")
    public ResponseEntity getAllCoords(@RequestBody List<PointDTO> pointDTOList) {
        try {
            coordsService.putCoords(pointDTOList);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            log.error("Can't save points: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
