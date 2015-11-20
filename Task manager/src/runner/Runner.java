package runner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.implement.extend.SerialasiableTaskStorage;
import task.alerting.implemet.TaskShowWindowAlerting;
import task.implement.TaskImpl;
import task.interfaces.Task;
import threadPool.ThreadPool;
import ui.mainwindow.tests.MainWindow;

/**
 *
 * @author Дот
 */
public class Runner {

    public static void main(String[] args) throws IOException {
       /* EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mainWindow = new MainWindow();
                mainWindow.setVisible(true);
            }
        });*/
        //System.out.println(new Date());
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
        SerialasiableTaskStorage sts=new SerialasiableTaskStorage();
        
        sts.saveObject(t);
        sts.saveObject(t2);
        sts.saveObject(t3);
        sts.closeS();
        
        t=sts.loadObject();
        t2=sts.loadObject();
        
        t3=sts.loadObject();
        sts.closeL();
        /*List a=new ArrayList();
        //System.out.println(sts.loadObject().getName());
        a=(List) sts.loadCollectionObject();
        tp.setTaskToPool(sts.loadObject());
        tp.setTaskToPool(sts.loadObject());
        tp.setTaskToPool(sts.loadObject());*/
    }
}
