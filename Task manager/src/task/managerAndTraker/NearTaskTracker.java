/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task.managerAndTraker;

import task.interfaces.Task;
import threadPool.ThreadPool;

/**
 *
 * @author Денис
 */
class NearTaskTracker{
        private Task nearTask;
        ThreadPool trakerPool=new ThreadPool();
        private TaskManager taskManager;
        
        
        public TaskManager getTaskManager() {
            return taskManager;
        }

        
        public void setTaskManager(TaskManager taskManager) {
            this.taskManager = taskManager;
        }

        
        public Task getNearTask() {
            return nearTask;
        }

        
        public void setupNearTask(Task nearTask) {
            this.nearTask = nearTask;
        }
    }
