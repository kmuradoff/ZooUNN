package az.prompt.zoounn.service;

import az.prompt.zoounn.Cell;
import az.prompt.zoounn.Zoo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class JsonService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Zoo zoo;

    public void save() {
        // TODO
    }

    @SneakyThrows
    public void backup() {
        Resource resource = new ClassPathResource("backup.json");

        try (InputStream inputStream = resource.getInputStream()) {
            CollectionType type = objectMapper.getTypeFactory().constructCollectionType(List.class, Cell.class);
            Set<Cell> cellSet = objectMapper.readValue(inputStream, type);

            zoo.addCells(cellSet);
        }
    }
}
