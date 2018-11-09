package jdev.controllers;

import jdev.dto.PointDTO;
import jdev.rest.consume.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by epogadaev on 09.11.2018.
 */
@RestController
public class CounterController {
    private static final String template = "It's yours, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/counter")
    public CurrentState greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new CurrentState(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/coords")
    public ResponseEntity setCoords(@RequestParam(value = "location") String location) {
        System.out.println(location);
        PointDTO pointDTO = new PointDTO();
        if (location.split(",").length == 2) {
            pointDTO.setLat(54.2);
            pointDTO.setLon(35.7);
            pointDTO.setAutoId("k169xp70");
            return ResponseEntity.ok().body(pointDTO);
        }
        else {
            pointDTO.setLat(54.2);
            pointDTO.setAutoId("k169xp70");
            return ResponseEntity.ok().body(pointDTO);
        }
    }

    @RequestMapping(value = "/relay")
    public Country relay() {
        Country country = restTemplate.getForObject("http://services.groupkt.com/country/get/iso2code/RU", Country.class);
        return country;
    }
}
