package az.prompt.zoounn.service;

import az.prompt.zoounn.Cell;
import az.prompt.zoounn.Zoo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ObjectSerializerService {
    private final Zoo zoo;

    public void save() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("cells.txt");
            ObjectOutputStream objectOutputStream
                    = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(zoo.getCells());
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void backup() {
        Set<Cell> cells;
        try {
            FileInputStream fileInputStream = new FileInputStream("cells.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            cells = (Set<Cell>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        zoo.addCells(cells);
    }

}
