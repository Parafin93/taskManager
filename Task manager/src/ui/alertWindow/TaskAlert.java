/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.alertWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.SpringLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import sun.awt.HorizBagLayout;

/**
 *
 * @author Денис
 */
public class TaskAlert extends JFrame{
    private String name;
    private String description;
    public TaskAlert(String s1, String s2){
        setName(s1);
        setDescription(s2);
        initAlert();
    }
    public void initAlert(){
        /*setTitle("Время приключений");
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel top =new JPanel();
        JPanel cover =new JPanel();
        cover.setLayout(null);
        cover.setSize(300, 300);
        //top.setLayout(new BorderLayout());
        setContentPane(top);
        JTextArea name= new JTextArea();
        name.setName("Задание");
        name.setForeground(Color.RED);
        name.setText(this.name);
        name.setEditable(false);
        name.setLineWrap(true);
        name.setSize(250, 30);
        name.setLocation(30, 30);
        JScrollPane scrollPaneName=new JScrollPane();
        scrollPaneName.setName("Задание");
        scrollPaneName.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneName.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneName.setSize(250, 30);
        scrollPaneName.setLayout(new ScrollPaneLayout());
        scrollPaneName.setBorder(new CompoundBorder(new EmptyBorder(12,12,12,12), new TitledBorder("Задание")));
        scrollPaneName.setLocation(30, 30);
        scrollPaneName.setViewportView(name);
        
        
        JTextArea description= new JTextArea();
        description.setName("Описание");
        description.setForeground(Color.GREEN);
        description.setText(this.description);
        description.setEditable(false);
        description.setLineWrap(true);
        description.setSize(250, 210);
        description.setLocation(30, 70);
        JScrollPane scrollPaneDescription=new JScrollPane();
        scrollPaneDescription.setSize(250, 210);
        scrollPaneDescription.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneDescription.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneDescription.setLayout(new ScrollPaneLayout());
        
        scrollPaneDescription.setBorder(new CompoundBorder(new EmptyBorder(12,12,12,12), new TitledBorder("Описание")));
        scrollPaneName.setLocation(30, 70);
        scrollPaneDescription.setViewportView(description);
        
        cover.add(scrollPaneName);
        cover.add(scrollPaneDescription);
        //add(scrollPaneName,BorderLayout.NORTH);
        //add(scrollPaneDescription,BorderLayout.CENTER);
        //top.setSize(250, 250);
        getContentPane().add(cover);
        //setContentPane(top);
        setSize(500, 500);
        //pack();
        /*/
        
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel top =new JPanel();
        top.setLayout(new GridLayout(2, 1, 10, -10));
        
        JTextArea name= new JTextArea();
        name.setName("Задание");
        name.setForeground(Color.RED);
        name.setText(this.name);
        name.setEditable(false);
        name.setLineWrap(true);
        //top.add(name);
        JScrollPane scrollPaneName=new JScrollPane();
        scrollPaneName.setName("Задание");
        scrollPaneName.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneName.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneName.setLayout(new ScrollPaneLayout());
        scrollPaneName.setBorder(new CompoundBorder(new EmptyBorder(12,12,12,12), new TitledBorder("Задание")));
        scrollPaneName.setViewportView(name);
        top.add(scrollPaneName);
        
        JTextArea description= new JTextArea();
        description.setName("Описание");
        description.setForeground(Color.GREEN);
        description.setText(this.description);
        description.setEditable(false);
        description.setLineWrap(true);
        
        JScrollPane scrollPaneDescription=new JScrollPane();
        scrollPaneDescription.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneDescription.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneDescription.setLayout(new ScrollPaneLayout());
        scrollPaneDescription.setBorder(new CompoundBorder(new EmptyBorder(12,12,12,12), new TitledBorder("Описание")));
        scrollPaneDescription.setViewportView(description);
        top.add(scrollPaneDescription);
        
        setContentPane(top);
        pack();
        setSize(500, 500);
        setResizable(false);
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public void setDescription(String description) {
        this.description = description;
    }
}
