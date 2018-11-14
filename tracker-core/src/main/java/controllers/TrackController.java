package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by epogadaev on 09.11.2018.
 */
@RestController
public class TrackController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/relay")
    public Country relay() {
        Country country = restTemplate.getForObject("http://services.groupkt.com/country/get/iso2code/RU", Country.class);
        return country;
    }
}
