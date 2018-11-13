package services;

import jdev.dto.PointDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Logger;

@Service
public class DataSaveService {
    private static Logger log = Logger.getLogger(DataSaveService.class.getName());

    public BlockingDeque<PointDTO> pointDTOList = new LinkedBlockingDeque<>();


    public void savePointDTO (PointDTO pointDTO) {
        if (pointDTO != null) {
            pointDTOList.add(pointDTO);
            log.info("Adding new point in deque: " + pointDTO.toString());
        }

    }
}
