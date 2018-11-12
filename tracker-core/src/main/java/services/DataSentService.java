package services;

import jdev.dto.PointDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by epogadaev on 09.11.2018.
 * Реализует отравку данных
 */
@Service
public class DataSentService {

    private static Logger log = Logger.getLogger(DataSentService.class.getName());

    @Scheduled(fixedDelay = 2000)
    public void sentPointDTOToServerCore(List<PointDTO> pointDTOList){
        if(pointDTOList != null && !pointDTOList.isEmpty()) {
            for (PointDTO pointDTO : pointDTOList){
                log.info(pointDTO.toString());
            }
        }
    }
}
