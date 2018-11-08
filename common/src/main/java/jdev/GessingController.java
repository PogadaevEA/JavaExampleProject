package jdev;

import jdev.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by epogadaev on 08.11.2018.
 */
@Controller
public class GessingController {

    @Autowired
    private FortuneService fortuneService;

    @RequestMapping("/gess")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "Noname") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("num", fortuneService.tryFortune());
        return "gessing";
    }
}
