/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task.alerting.implemet;

import task.alerting.TaskAlerting;
import task.interfaces.Task;
import ui.alertWindow.TaskAlert;

/**
 *
 * @author Денис
 */
public class TaskShowWindowAlerting implements TaskAlerting{

    @Override
    public void executeTask( Task task) {
        final String name=task.getName();
        final String description =task.getDescription();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                new TaskAlert(name,description).setVisible(true);
                
            }
        });
    }
    
}
