/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Дот
 */
public class TaskList implements List_Sortable{
    Unit head;
    Unit tail;
    Unit tmp;

    int size;

    public TaskList() {
        head = null;
        size = 0;
    }

    public void newHead(Task element) {
        if (size == 0) {
            head = new Unit(element);
            tail = head;
            head.next = tail;
            tail.next = head;
            size = 1;
        } else {
            tmp = head;
            head = new Unit(element);
            head.next = tmp;
            tail.next = head;
            size += 1;
        }
    }

    public void newTail(Task element) {
        if (size == 0) {
            newHead(element);
        } else {
            tmp = tail;
            tail = new Unit(element);
            tail.next = head;
            tmp.next = tail;
            size += 1;
        }
    }

    public void removeHead() { //потом проверить размер
        if (size == 1) {
            head = null;
            tail = null;
            size = 0;
        } else {
            tmp = head;
            tail.next = head.next;
            head = head.next;
            tmp.next = null;
            size -= 1;
        }
    }

    public void removeTail() {// и тут размер не 0 проверить
        if (size == 1) {
            head = null;
            tail = null;
            size = 0;
        } else {
            tmp = head;
            for (int i = 1; i < this.size - 2; i++) {
                tmp = tmp.next;
            }
            tmp.next = head;
            tail = tmp;
            size -= 1;
        }
    }

    private Task getUnit(int indx) {
        if (indx == 0) {
            return head.element;

        } else {

            tmp = head;
            for (int i = 1; i <= indx; i++) {
                tmp = tmp.next;
            }
            return tmp.element;
        }
    }

    private void setUnit(int indx, Task Task) {
        if (indx == 0) {
            newHead(Task);
        } else if (indx == size - 1) {
            newTail(Task);
        } else {

            tmp = head;
            for (int i = 1; i < indx; i++) {
                tmp = tmp.next;
            }
            Unit x = new Unit(Task);
            x.next = tmp.next;
            tmp.next = x;
            size += 1;
        }
    }

    private void removeUnit(int indx) {
        if (indx == 0) {
            removeHead();
        } else if (indx == size - 1) {
            removeTail();
        } else {
            tmp = head;
            for (int i = 1; i < indx; i++) {
                tmp = tmp.next;
            }

            tmp.next = tmp.next.next;
            size -= 1;
        }
    }
    public void Sort(){
        
    }
    
class Unit {

        Task element;
        Unit next;

        Unit(Task element) {
            this.element = element;
            next = null;
        }

        private boolean compare(Unit firstElement, Unit secondElement) {
            Object F = (Object) firstElement;
            Object S = (Object) secondElement;
            if (F.equals(S)) {
                return true;
            } else {
                return false;
            }
        }
    }
    
}
