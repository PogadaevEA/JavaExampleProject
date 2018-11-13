package services;

import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

import java.util.logging.Logger;

/**
 * Created by epogadaev on 09.11.2018.
 * Реализует отравку данных
 */
@Service
public class DataSentService {


    @Autowired
    RestTemplate restTemplate;

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
            restTemplate.postForLocation("http://localhost:8080/coords", dataSaveService.pointDTOList);
        }
    }
}
