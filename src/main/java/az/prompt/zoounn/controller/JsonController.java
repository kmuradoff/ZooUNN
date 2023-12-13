package az.prompt.zoounn.controller;

import az.prompt.zoounn.service.JsonService;
import az.prompt.zoounn.service.ObjectSerializerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json")
@RequiredArgsConstructor
public class JsonController {
    private final JsonService jsonService;

    @GetMapping("/save")
    public void save() {
        jsonService.save();
    }

    @GetMapping("/backup")
    public void backup() {
        jsonService.backup();
    }
}
