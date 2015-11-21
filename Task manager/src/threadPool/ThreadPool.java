/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadPool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import task.alerting.implemet.TaskShowWindowAlerting;
import task.implement.TaskImpl;
import task.interfaces.Task;

/**
 *
 * @author Денис
 */
public class ThreadPool {

    static ScheduledExecutorService pool = Executors.newScheduledThreadPool(30);
    
    public ThreadPool() {
    }

    public void setTaskToPool(Task task) {

        task.setStatusScheduled();

        this.pool.submit(new TaskRun(task));

    }

    class TaskRun implements Runnable {

        private Task task;

        public TaskRun(Task task) {
            this.task = task;
            this.task.setStatusScheduled();
        }

        @Override
        public void run() {
            Date currentDate = new Date();
            while (currentDate.before(this.task.getTime())) {
                currentDate = new Date();
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println(Thread.currentThread().getName());

                }
            }
            task.setStatusComplete();
            System.out.println(task.getTime());
            TaskShowWindowAlerting taswa = new TaskShowWindowAlerting();
            taswa.executeTask(task);

        }
    }
}
