package az.prompt.zoounn.service;

import az.prompt.zoounn.Cell;
import az.prompt.zoounn.Zoo;
import az.prompt.zoounn.mapper.CellMapper;
import az.prompt.zoounn.model.CellJpa;
import az.prompt.zoounn.repository.AnimalJpaRepository;
import az.prompt.zoounn.repository.CellJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DataBaseService {
    private final CellJpaRepository cellRepository;
    private final AnimalJpaRepository animalRepository;

    private final CellMapper cellMapper;
    private final Zoo zoo;

    public void save() {
        Set<Cell> cellList = zoo.getCells();

        List<CellJpa> cellJpas = new ArrayList<>();
        for (Cell cell : cellList)
            cellJpas.add(cellMapper.fromCell(cell));

        cellRepository.saveAll(cellJpas);
    }

    public void backup() {
        List<Cell> cellList = cellRepository.findAll().stream()
                .map(cellMapper::fromCellJpa)
                .toList();

        zoo.addCells(cellList);
    }

}
