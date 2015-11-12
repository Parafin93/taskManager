/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task.factory;


import task.implement.TaskImpl;
import task.interfaces.Task;

/**
 *
 * @author Денис
 */
public class TaskFactory {

    private static volatile TaskFactory instance;

    private TaskFactory() {
    }

    public static TaskFactory getInstance() {
        if (instance == null) {
            synchronized (TaskFactory.class) {
                if (instance == null) {
                    instance = new TaskFactory();
                }
            }
        }
        return instance;
    }

    public Task getDummyTask() {
        

        return new TaskImpl();
    }
}
