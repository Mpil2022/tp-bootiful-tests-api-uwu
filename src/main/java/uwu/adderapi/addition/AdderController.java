package uwu.adderapi.addition;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uwu.adderapi.addition.AdderService;

@RequestMapping(value = "/adder", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class AdderController {

    private AdderService adderService;

    public AdderController(AdderService adderService) {
        this.adderService = adderService;
    }

    @GetMapping("/current")
    public int currentNum() {
        return adderService.currentBase();
    }

    @PostMapping
    public int add(@RequestParam int num) {
        return adderService.add(num);
    }
}