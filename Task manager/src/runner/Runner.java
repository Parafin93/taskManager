package runner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.EventQueue;
import java.util.Date;
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

    public static void main(String[] args) {
       /* EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mainWindow = new MainWindow();
                mainWindow.setVisible(true);
            }
        });*/
        System.out.println(new Date());
        String s="Абракадаборарагомтпппп +_+ D::D  lkkhjhjhjkhggkhjkg =,...,=  =///= sssssssssssssssssssssssssssssssssssssssssssdhjaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        Task t=new TaskImpl(new Date(),s,"Сделать зарядку");
        ThreadPool tp=new ThreadPool();
        tp.setTaskToPool(t);
        Date forT2=new Date();
        System.out.println(forT2.getTime());
        forT2.setTime(forT2.getTime()+60000);
        System.out.println(forT2);
        Task t2=new TaskImpl(forT2,s,"22");
        tp.setTaskToPool(t2);
        /*TaskShowWindowAlerting taswa=new TaskShowWindowAlerting();
        taswa.executeTask(t);*/

    }
}
