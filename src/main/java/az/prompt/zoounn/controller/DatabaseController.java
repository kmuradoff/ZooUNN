package az.prompt.zoounn.controller;

import az.prompt.zoounn.service.DataBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/database")
@RequiredArgsConstructor
public class DatabaseController {
    private final DataBaseService dataBaseService;

    @GetMapping("/save")
    public void save() {
        dataBaseService.save();
    }

    @GetMapping("/backup")
    public void backup() {
        dataBaseService.backup();
    }
}
