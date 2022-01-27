package com.company;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class console extends Formula1ChampionshipManager {

    public console() {
        JFrame frame = new JFrame();
        JLabel label = new JLabel("Select Your Option ");
        Font font1 = new Font(Font.DIALOG_INPUT,Font.BOLD,25);
        Font menu_font = new Font(Font.MONOSPACED,Font.PLAIN,20);
        JButton displ_List = new JButton("Display list");
        JButton viewAsc    = new JButton("Display List(Ascending to points)");

        frame.setTitle("Formula1 Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application
        frame.setResizable(false);//stop this from being resized
        frame.setSize(1000, 700);
        frame.setVisible(true);//makes the this visible
        frame.setLocationRelativeTo(null);//make this appear in the middle of the screen

        //label for the heading
        label.setSize(500,40);
        label.setLocation(370,10);
        label.setFont(font1);

        //label for the button 1(To diplay to driver table)
        displ_List.setSize(500,50);
        displ_List.setLocation(250,60);
        displ_List.setFont(menu_font);
        displ_List.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                displayTable();
            }
        });

        //label for the button 1(To diplay to driver table(in ascending order to points))
        viewAsc.setSize(500,50);
        viewAsc.setLocation(250,115);
        viewAsc.setFont(menu_font);
        viewAsc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                displayTable();
            }
        });

        frame.add(label);
        frame.add(displ_List);
        frame.add(viewAsc);

        frame.setLayout(null);
    }

    public void displayTable(){
        loadData();

        JFrame f=new JFrame();

        String column[] = {"Driver Name", "Location", "Team", "1st Place Count", "2nd Place Count", "3rd Place Count", "Race Count", "Points"};//Set column names
        DefaultTableModel tableModel1 = new DefaultTableModel(column,0);
        JTable jt = new JTable(tableModel1);

        ArrayList<Formula1ChampionshipManager> drivertableData = new ArrayList<Formula1ChampionshipManager>();
        for (int i=0;i<fDriver.size();i++){
            String TdriverName= fDriver.get(i).driver_fullName;
            String TdriverLoc = fDriver.get(i).driver_location;
            String TdriverTeam = fDriver.get(i).driver_team;
            int TnumOf1st = fDriver.get(i).firstplaces;
            int TnumOf2nd = fDriver.get(i).secondplaces;
            int TnumOf3rd = fDriver.get(i).thirdplaces;
            int TnumOfRaces = fDriver.get(i).numOfRaces;
            int Tpoints = fDriver.get(i).points;

            Object data[] ={TdriverName,TdriverLoc,TdriverTeam,TnumOf1st,TnumOf2nd,TnumOf3rd,TnumOfRaces,Tpoints};
            tableModel1.addRow(data);

        }

        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);


            f.setSize(1000,700);
            f.setVisible(true);

    }

    //display table in ascending order to points
    public void displayAscToPoints(){
        loadData();



        Comparator<Formula1Driver> comparator = new Comparator<Formula1Driver>() {
            public int compare(Formula1Driver a, Formula1Driver b) {
                if (a.points == b.points) {
                    if (a.firstplaces> b.firstplaces){
                        return 1;
                    }else {
                        return -1;
                    }
                }
                else if (a.points > b.points) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        };
        JFrame f=new JFrame();

        String column[] = {"Driver Name", "Location", "Team", "1st Place Count", "2nd Place Count", "3rd Place Count", "Race Count", "Points"};//Set column names
        DefaultTableModel tableModel2 = new DefaultTableModel(column,0);
        JTable table2 = new JTable(tableModel2);
        table2.setAutoCreateRowSorter(true);

        ArrayList<Formula1ChampionshipManager> drivertableData = new ArrayList<Formula1ChampionshipManager>();

        
        for (int i=0;i<fDriver.size();i++){
            String TdriverName= fDriver.get(i).driver_fullName;
            String TdriverLoc = fDriver.get(i).driver_location;
            String TdriverTeam = fDriver.get(i).driver_team;
            int TnumOf1st = fDriver.get(i).firstplaces;
            int TnumOf2nd = fDriver.get(i).secondplaces;
            int TnumOf3rd = fDriver.get(i).thirdplaces;
            int TnumOfRaces = fDriver.get(i).numOfRaces;
            int Tpoints = fDriver.get(i).points;

           // Comparator<? super Formula1Driver> Formula1ChampionshipManager = null;
            Comparator<? super com.company.Formula1ChampionshipManager> Formula1Driver=null;
            Collections.sort(drivertableData,Formula1Driver);

            Object data[] ={TdriverName,TdriverLoc,TdriverTeam,TnumOf1st,TnumOf2nd,TnumOf3rd,TnumOfRaces,Tpoints};
            tableModel2.addRow(data);

        }

        table2.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(table2);
        f.add(sp);


        f.setSize(1000,700);
        f.setVisible(true);
    }

    public static void main(String[] args) {

        console obj = new console();

    }

}
