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

    public Date getTime();

    public void setTime(Date someTime);

    public String getName();

    public String getDescription();

    public void setName(String someName);

    public void setDescription(String someDescription);
}
