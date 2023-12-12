package az.prompt.zoounn.service;

import az.prompt.zoounn.Cell;
import az.prompt.zoounn.Zoo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class JsonService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Zoo zoo;

    @SneakyThrows
    public void save() {
        Gson gson = new Gson();
        String json = gson.toJson(zoo.getCells());

        FileOutputStream fileOutputStream = new FileOutputStream("backup.json");
        fileOutputStream.write(json.getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    @SneakyThrows
    public void backup() {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("backup.json"));
        List<Cell> cells = gson.fromJson(reader, new TypeToken<List<Cell>>() {}.getType());
        zoo.addCells(cells);
    }
}
