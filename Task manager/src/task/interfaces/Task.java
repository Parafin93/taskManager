package task.interfaces;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Дот
 */
public interface Task {
//    public static final int EMPTY=0;

    public static final int SCHEDULED = 1;
    public static final int OVERDUE = 2;
    public static final int COMPLETE = 3;
    //public int status = 0;

    public Date getTime();

    public void setTime(Date someTime);

    public String getName();

    public String getDescription();

    public void setName(String someName);

    public void setDescription(String someDescription);

    public void setStatusScheduled();
    public void setStatusOverdue();
    public void setStatusComplete();
    public int getStatus();
}
