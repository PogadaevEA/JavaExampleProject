package jdev.service;

import org.springframework.stereotype.Service;

/**
 * Created by epogadaev on 08.11.2018.
 */
@Service
public class FortuneService {
    public double tryFortune() {
        return Math.random();
    }
}
