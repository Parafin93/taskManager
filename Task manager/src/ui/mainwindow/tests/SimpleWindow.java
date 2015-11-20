/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.mainwindow.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class SimpleWindow extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleWindow SimpleWindow = new SimpleWindow();
                SimpleWindow.setVisible(true);
            }
        });


    }
    private ExitAction exitAction;

    SimpleWindow() {
        super("Окно с меню");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        exitAction = new ExitAction();
        DeactivateAction deactivateAction = new DeactivateAction();
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
        fileMenu.add(new JMenuItem("Новый"));
        fileMenu.addSeparator();
        fileMenu.add(deactivateAction);
        fileMenu.add(exitAction);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        JToolBar toolBar = new JToolBar("Панель инструментов");
        toolBar.add(exitAction);
        toolBar.add(deactivateAction);
        getContentPane().add(toolBar, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        panel.add(new JButton(exitAction));
        panel.add(new JButton(deactivateAction));
        getContentPane().add(panel);
        setSize(250, 250);
    }

    class ExitAction extends AbstractAction {

        ExitAction() {
            putValue(Action.NAME, "Выйти");
            putValue(Action.SHORT_DESCRIPTION, "Программа перестанет работать, а окно исчезнет с экрана.");
            putValue(Action.SMALL_ICON, new ImageIcon("2.gif"));
        }

        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }

    class DeactivateAction extends AbstractAction {

        DeactivateAction() {
            putValue(Action.NAME, "Запретить выход");
            putValue(Action.SMALL_ICON, new ImageIcon("1.gif"));
        }

        public void actionPerformed(ActionEvent event) {
            if (exitAction.isEnabled()) {
                exitAction.setEnabled(false);
                putValue(Action.NAME, "Разрешить выход");

            } else {
                exitAction.setEnabled(true);
                putValue(Action.NAME, "Запретить выход");
            }
        }
    }
}