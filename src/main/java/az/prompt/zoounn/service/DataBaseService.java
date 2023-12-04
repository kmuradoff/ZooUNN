package az.prompt.zoounn.service;

import az.prompt.zoounn.Cell;
import az.prompt.zoounn.Zoo;
import az.prompt.zoounn.mapper.AnimalMapper;
import az.prompt.zoounn.mapper.CellMapper;
import az.prompt.zoounn.model.AnimalJpa;
import az.prompt.zoounn.model.CellJpa;
import az.prompt.zoounn.repository.AnimalJpaRepository;
import az.prompt.zoounn.repository.CellJpaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DataBaseService {
    private final CellJpaRepository cellRepository;
    private final AnimalJpaRepository animalRepository;

    private final CellMapper cellMapper;
    private final AnimalMapper animalMapper;
    private final Zoo zoo;

    @Transactional
    public void save() {
        cellRepository.saveAll(zoo.getCells().stream()
                .map(cellMapper::fromCell)
                .peek(cellJpa -> cellJpa.getAnimals().forEach(animalJpa -> animalJpa.setCell(cellJpa)))
                .toList());
    }

    public void backup() {
        List<Cell> cellList = cellRepository.findAll().stream()
                .map(cellMapper::fromCellJpa)
                .toList();

        zoo.addCells(cellList);
    }

}
