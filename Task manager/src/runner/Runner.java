package runner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.factory.StorageFactory;
import storage.implement.extend.SerialasiableTaskStorage;
import task.alerting.implemet.TaskShowWindowAlerting;
import task.implement.TaskImpl;
import task.interfaces.Task;
import threadPool.ThreadPool;
import ui.addWindow.AddTask;
import ui.mainwindow.tests.MainWindow;

/**
 *
 * @author Дот
 */
public class Runner {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
       /* EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mainWindow = new MainWindow();
                mainWindow.setVisible(true);
            }
        });*/
        //System.out.println(new Date());
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                new AddTask().setVisible(true);
                
            }
        });
        
        String s="Абракадаборарагомтпппп +_+ D::D  aaaaaaaaaaaaaaaaaaaaaaaa";
        Date forT1=new Date();
        forT1.setTime(forT1.getTime()+20000);
        Task t=new TaskImpl(forT1,s+forT1,"Сделать зарядку");
        ThreadPool tp=new ThreadPool();
        //tp.setTaskToPool(t);
        Date forT2=new Date();
        //System.out.println(forT2.getTime());
        forT2.setTime(forT2.getTime()+30000);
        //System.out.println(forT2);
        Task t2=new TaskImpl(forT2,s+forT2,""+forT2);
        Date forT3=new Date();
        forT3.setTime(forT3.getTime()+40000);
        Task t3=new TaskImpl(forT3,s+forT3,""+forT3);
        //tp.setTaskToPool(t2);
        //tp.setTaskToPool(t3);
        /*TaskShowWindowAlerting taswa=new TaskShowWindowAlerting();
        taswa.executeTask(t);*/
        //System.out.println(new Date());
        StorageFactory sf= StorageFactory.getInstance();
        SerialasiableTaskStorage sts=sf.getSerialasiableTaskStorage();
       
        FileOutputStream fos = new FileOutputStream("out.txt");

        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        /*FileInputStream fis = new FileInputStream("out.txt");
        ObjectInputStream oin = new ObjectInputStream(fis);*/
        /*oos.writeObject(t);
        oos.writeObject(t2);
        oos.writeObject(t3);
        oos.flush();
        fos.flush();
        oos.close();
        fos.close();*/
        /*tp.setTaskToPool((Task)oin.readObject());
        tp.setTaskToPool((Task)oin.readObject());
        tp.setTaskToPool((Task)oin.readObject());*/
        sts.saveObject(t);
        sts.flush();
        sts.saveObject(t2);
        sts.flush();
        sts.saveObject(t3);
        sts.flush();
        sts.closeSave();
        /*
        t=sts.loadObject();
        t2=sts.loadObject();
        
        t3=sts.loadObject();
        */
        /*List a=new ArrayList();
        //System.out.println(sts.loadObject().getName());
        a=(List) sts.loadCollectionObject();*/
       // Task tmp=sts.loadObject();
        tp.setTaskToPool(sts.loadObject());
        //tmp=sts.loadObject();
        tp.setTaskToPool(sts.loadObject());
        //tmp=sts.loadObject();
        tp.setTaskToPool(sts.loadObject());
    }
}
