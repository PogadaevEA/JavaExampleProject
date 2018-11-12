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

    private DataSaveService dataSaveService;

    public DataSentService (
            DataSaveService dataSaveService
    ) {
        this.dataSaveService = dataSaveService;
    }

    private static Logger log = Logger.getLogger(DataSentService.class.getName());

    @Scheduled(cron = "${cron.prop.30sec}")
    public void sentPointDTOToServerCore(){

        if(dataSaveService.pointDTOList != null && !dataSaveService.pointDTOList.isEmpty()) {
            for (PointDTO pointDTO : dataSaveService.pointDTOList){
                log.info("Sending point to server: " + pointDTO.toString());
            }
        }
    }
}
