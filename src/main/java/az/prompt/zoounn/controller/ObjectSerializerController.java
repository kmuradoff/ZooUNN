package az.prompt.zoounn.controller;

import az.prompt.zoounn.service.ObjectSerializerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serialization")
@RequiredArgsConstructor
public class ObjectSerializerController {
    private final ObjectSerializerService objectSerializerService;

    @GetMapping("/save")
    public void save() {
        objectSerializerService.save();
    }

    @GetMapping("/backup")
    public void backup() {
        objectSerializerService.backup();
    }
}
