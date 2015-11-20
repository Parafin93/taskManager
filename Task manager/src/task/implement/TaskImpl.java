package task.implement;

import java.io.Serializable;
import java.util.Date;
import task.interfaces.Task;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Дот
 */
public class TaskImpl implements Serializable, Task {

    private Date timeOfBeginning;
    private String description;
    private String name;
    private int status = 0;
    public TaskImpl() {
        this(null, null, null);
    }

    public TaskImpl(Date someTime, String someDescription, String someName) {
        setTime(someTime);
        setDescription(someDescription);
        setName(someName);
    }

    public Date getTime() {
        return this.timeOfBeginning;
    }

    public void setTime(Date SomeTime) {
        this.timeOfBeginning = SomeTime;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String someDescription) {
        this.description = someDescription;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String someName) {
        this.name = someName;
    }

    @Override
    public boolean equals(Object o) {//доделать
        if (o == null) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        TaskImpl e = (TaskImpl) o;
        return (this.timeOfBeginning.equals(e.timeOfBeginning) & this.name.equals(e.name) & this.description.equals(e.description));
    }

    @Override
    public int hashCode() { // подумать как сделать
        return (description + name).hashCode() + timeOfBeginning.hashCode();
    }

    @Override
    public void setStatusComplete() {
        this.status=COMPLETE;
    }
    @Override
    public void setStatusOverdue() {
        this.status=OVERDUE;
    }
    @Override
    public void setStatusScheduled() {
        this.status=SCHEDULED;
    }

    @Override
    public int getStatus() {
        return this.status;
    }
}
