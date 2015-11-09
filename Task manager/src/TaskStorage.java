
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Дот
 */
public class TaskStorage implements Storeable {

    Task TempTask;
    FileOutputStream fos;
    ObjectOutputStream oos;
    FileInputStream fis;
    ObjectInputStream oin;

    public TaskStorage() throws FileNotFoundException, IOException {
        this.fos = new FileOutputStream("Task.log");
        this.oos = new ObjectOutputStream(fos);
        fis = new FileInputStream("Task.log");
        oin = new ObjectInputStream(fis);

    }

    public void SetTask(Task SomeTask) {
        this.TempTask = SomeTask;
    }

    public void Save() {
        SaveTask();
    }

    public void Load() {
        LoadTask();
    }

    public void SaveTask() throws IOException {

        oos.writeObject(this.TempTask);
        oos.flush();
        oos.close();
    }

    public void LoadTask() throws IOException, ClassNotFoundException {
        SetTask((Task) oin.readObject());
    }
}
