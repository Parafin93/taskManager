/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.addWindow;

import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Денис
 */
public class AddTask extends JFrame{
    private String name;
    private String description;
    JPanel panelForTextArea;
    public AddTask(){
        init();
    }
    public void init(){
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        panelForTextArea =new JPanel();
        panelForTextArea.setLayout(new GridLayout(2, 1, 10, -10));
        
        JTextArea name= new JTextArea();
        name.setName("Задание");
        name.setForeground(Color.RED);
        name.setText(this.name);
        //name.setEditable(false);
        name.setLineWrap(true);
        JScrollPane scrollPaneName=new JScrollPane();
        scrollPaneName.setName("Задание");
        scrollPaneName.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneName.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneName.setLayout(new ScrollPaneLayout());
        scrollPaneName.setBorder(new CompoundBorder(new EmptyBorder(12,12,12,12), new TitledBorder("Задание")));
        scrollPaneName.setViewportView(name);
        panelForTextArea.add(scrollPaneName);
        
        JTextArea description= new JTextArea();
        description.setName("Описание");
        description.setForeground(Color.GREEN);
        description.setText(this.description);
        //description.setEditable(false);
        description.setLineWrap(true);
        JScrollPane scrollPaneDescription=new JScrollPane();
        scrollPaneDescription.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneDescription.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneDescription.setLayout(new ScrollPaneLayout());
        scrollPaneDescription.setBorder(new CompoundBorder(new EmptyBorder(12,12,12,12), new TitledBorder("Описание")));
        scrollPaneDescription.setViewportView(description);
        panelForTextArea.add(scrollPaneDescription);
        JPanel top=new JPanel();
        top.setLayout(null);
        setContentPane(top);
        panelForTextArea.setSize(this.getWidth()-100, this.getHeight()-100);
        getContentPane().add(panelForTextArea).setLocation(50, 50);
        JButton ok =new JButton("Добавить");
        ok.setSize(120, 30);
        ok.setLocation(55, 10);
        getContentPane().add(ok);
        setResizable(false);
        /*addComponentListener(new ComponentAdapter() {
        @Override
            public void componentResized(ComponentEvent ce) {
            BaselineResizeBehavior a=ce.getComponent().getBaselineResizeBehavior();
            
                panelForTextArea.setSize(ce.getComponent().getWidth()-100, ce.getComponent().getHeight()-100);
                Component[] c=panelForTextArea.getComponents();
                
                panelForTextArea.doLayout();
                panelForTextArea.repaint();
                for(Component t:c){
                    t.doLayout();
                    t.repaint();
                }
                panelForTextArea.doLayout();
                panelForTextArea.repaint();
            }});*/
    }
    
}
