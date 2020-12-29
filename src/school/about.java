/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Parveen
 */
public class about extends JFrame implements ActionListener{
    JLabel backl,titlel;
    JTextArea descl;
    JButton backb;
    about(){
        super("About");
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Font f=new Font("Arial",Font.BOLD,50);
        
        backl=new JLabel();
        titlel=new JLabel("About");
        titlel.setFont(f);                
        
        f=new Font("Arial",Font.BOLD,30);
        descl=new JTextArea("The title of the project is” School Management System ”.\n\n\n" 
                +"SCHOOL MANAGEMENT SYSTEM that allows owner to manipulates the information related \n"
                + " to school like add new student,books in library and add new teachers in school.\n"
                + "The system is an application that can be used to manage the records of the schools.\n" 
                +"It consists of an admin module.\n"
                + "The admin module leads to admin dashboard which is accessible through admin id and \n password.\n" 
                +"So now whenever user wants to login then he may login using registered username and \n password of the admin.\n"
                + "After login he or she can manipulate information of the schools.\n");
        descl.setFont(f);
        descl.setOpaque(false);
        descl.setEditable(false);
        
        backb=new JButton("Back");
        backb.setFont(f);
                
        getContentPane().add(titlel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550,20,250,50));
        
        getContentPane().add(descl,new org.netbeans.lib.awtextra.AbsoluteConstraints(10,100,1400,500));
        
        getContentPane().add(backb,new org.netbeans.lib.awtextra.AbsoluteConstraints(550,600,250,50));
        
        backl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school/icon/student.png")));
        getContentPane().add(backl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1));
        
        backb.addActionListener(this);                
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    public static void main(String args[]){
        new about().setVisible(true);
        
    }
    

    
}
