/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.mainwindow.tests;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.plaf.basic.BasicBorders;

/**
 *
 * @author Денис
 */
public class MainWindow extends JFrame{
    public MainWindow() {
        
        initUI();
    }

    private void initUI() {
        
        setTitle("Task manager");
        
        ActionNewWindow anw=new ActionNewWindow();
        ActionDel ad=new ActionDel();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel top =new JPanel();
        top.setBackground(Color.red);
        top.setLayout(null);
        setContentPane(top);
        panelForButtons=new JPanel();
        panelForButtons.setSize(500, 350);
        addTask=new JButton(anw);
        panelForButtons.setLayout(null);
        panelForButtons.add(addTask);
        panelForButtons.add(new JButton(anw));
        panelForButtons.setBackground(Color.yellow);
        panelForButtons.setLocation(200, 150);
        panelForButtons.setBorder(new BasicBorders.FieldBorder(Color.yellow, Color.darkGray, Color.lightGray, Color.lightGray));
        //top.add(panelForButtons);
        //setContentPane(top);
        panelForButtons.setVisible(true);
        addTask.setSize(60, 60);
        addTask.setLocation(100, 10);
        getContentPane().add(panelForButtons);
        deleteTask=new JButton(ad);
        deleteTask.setSize(65, 15);
        deleteTask.setLocation(300, 50);
        getContentPane().add(deleteTask);
        //panelForButtons.setSize(200, 200);
        
        //Object[] a=new Object[2];
        //a[0]=new lal("s","f");
        //a[1]=new lal("sds","fgf");
        
        
        listModel.addElement(new lal("jbfbh","sd"));
        listModel.addElement(new lal("s","f"));
        //listModel.addElement("adds");
        //listModel.addElement("adds");
        
        list=new JList(listModel);
        list.setCellRenderer(new CellRenderer());
        //list.setSize(85,50);
        list.setSelectedIndex(0);
        //list.setFocusable(false);
       // list.setLocation(100, 130);
        JScrollPane jsp=new JScrollPane();
        list.ensureIndexIsVisible(0);
        list.ensureIndexIsVisible(2);
        list.ensureIndexIsVisible(3);
        list.ensureIndexIsVisible(1);
        
        jsp.setSize(300, 255);
        jsp.setLocation(50, 50);
        jsp.setLayout(new ScrollPaneLayout());
        jsp.setViewportView(list);
        
        
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        panelForButtons.add(jsp, BorderLayout.CENTER);
        System.out.println(panelForButtons.getComponentAt(100, 130).getClass());
        PopupMenu pm =new PopupMenu("12");
        pm.setName("ffd");
        pm.add(new MenuItem("old"));
         list.addMouseListener(new MouseAdapter()
    {
      @Override
      public void mouseClicked(MouseEvent event)
      {
        clickButtonAt(event.getPoint());
        
        
      }
    });   
            list.add(pm);
            list.add(new JTextField("565",5));
        panelForButtons.add(pm);    
        setSize(800, 600);
    }
    private void clickButtonAt(Point point)
  {
    System.out.println(point.x+" "+point.y);
    int index = list.locationToIndex(point);
    
    lal lal = (lal) list.getModel().getElementAt(index);
    //Arrays.sort(listModel);
    //System.out.println(cellHeight);
    //System.out.println(lal.jb.getHeight());
    if((lal.jb.getLocation().x<point.x&&point.x<lal.jb.getLocation().x+lal.jb.getSize().width)&&(index*36+lal.jb.getLocation().y<point.y&&point.y<index*36+lal.jb.getLocation().y+lal.jb.getSize().height)){
        lal.jb.doClick();
    }
    //System.out.println(lal.jb.getLocation().x+" "+lal.jb.getLocation().y);
    //lal.jb.getSize().width;
//    jlist.repaint(jlist.getCellBounds(index, index));
  }
JList list;
JButton addTask;
JButton deleteTask;
JPanel panelForButtons;
 DefaultListModel listModel=new DefaultListModel();
class ActionNewWindow extends AbstractAction{

         
        public ActionNewWindow(){
            putValue(Action.NAME, "Новое окно");
                putValue(Action.SHORT_DESCRIPTION, "Создадим окошечко");
        }

        
        public void actionPerformed(ActionEvent ae) {
            PopupMenu pm =new PopupMenu("12");
            
            
            if (listModel.size() == 0) {
            
            listModel.addElement(new lal("as","tadam"));
            list.setSelectedIndex(0);
            deleteTask.setEnabled(true);
                    }else{
                lal u=new lal("as", "tadam");
                listModel.addElement(u);
                
                Object[] ajh = listModel.toArray();
                Arrays.sort(ajh);
                listModel.removeAllElements();
                for (Object o : ajh) {
                    listModel.addElement(o);
                }
                
                list.setSelectedIndex(listModel.indexOf(u));
            }
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new JFrame("Тапок").setVisible(true);
                
            }
        });
        }
    
}

class ActionDel extends AbstractAction{

         
        public ActionDel(){
            putValue(Action.NAME, "Del");
            putValue(Action.SHORT_DESCRIPTION, "Del окошечко");
        }

        
        public void actionPerformed(ActionEvent ae) {
        
            int i = list.getSelectedIndex();
            listModel.remove(i);
            if (listModel.size() == 0) {
                deleteTask.setEnabled(false);
            }
            if (i > listModel.size() - 1) {
                list.setSelectedIndex(listModel.size() - 1);
            } else {
                list.setSelectedIndex(i);

            }
            

            
            
        }
   
}
class lal  implements Comparable<lal> {
    int magic;
    Random r=new Random();
    
    JPanel j;
    JTextField t1;
    JTextField t2;
    JButton jb;
    ActionNewWindow anw=new ActionNewWindow();
    lal(String s1, String s2){
        magic=r.nextInt(50);
        j=new JPanel();
        j.setLayout(new FlowLayout());
        t1=new JTextField(s1);
        t2=new JTextField(s2);
        j.add(t1);
        j.add(t2);
        jb=new JButton(anw);
        j.add(new JLabel(""+magic));
        j.add(jb);
        //j.setSize(20, 20);
        
    }
    public JPanel getJ(){
        return j;
    }

        
        

        @Override
        public int compareTo(lal t) {
            Integer i1=new Integer(this.magic);
            Integer i2=new Integer(t.magic);
            return i1.compareTo(i2);
        }
    }
class CellRenderer implements ListCellRenderer{

        @Override
        public Component getListCellRendererComponent(JList jlist, Object value, int i, boolean isSelected, boolean cellHasFocus) {
            Component c = null;
            
            if(value instanceof lal){
                lal a=(lal)value;
                JPanel a2=a.getJ();
                c=a2;
                if (isSelected) {
        c.setBackground(Color.ORANGE);
        
        a.t1.setBackground(Color.CYAN);
        a.t2.setBackground(Color.CYAN);
      } else {
        c.setBackground(Color.GRAY);
        a.t1.setBackground(Color.WHITE);
        a.t2.setBackground(Color.WHITE);
      }
              
            }
            
            
        return c;
        }
    
}
}
