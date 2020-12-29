/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Parveen
 */
public class homepage extends JFrame implements ActionListener{
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    homepage(){
        super("HomePage");
        setExtendedState(MAXIMIZED_BOTH);        
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Font f=new Font("Arial",Font.BOLD,40);
        
        l1=new JLabel();
        l2=new JLabel("Homepage");
        l2.setFont(f);
        l2.setForeground(Color.BLACK);
        
        f=new Font("Arial",Font.BOLD,20);
        b1=new JButton("New Student");
        b1.setFont(f);
        b1.setForeground(Color.red);
        b2=new JButton("Update Student Detail");
        b2.setFont(f);
        b2.setForeground(Color.red);
        b3=new JButton("Non Teaching Staff");
        b3.setFont(f);
        b3.setForeground(Color.red);
        b4=new JButton("Teacher");
        b4.setFont(f);
        b4.setForeground(Color.red);
        b5=new JButton("Library");
        b5.setFont(f);
        b5.setForeground(Color.red);
        b6=new JButton("Details");
        b6.setFont(f);
        b6.setForeground(Color.red);
        b7=new JButton("Contact Us");
        b7.setFont(f);
        b7.setForeground(Color.red);
        b8=new JButton("About");
        b8.setFont(f);
        b8.setForeground(Color.red);
        b9=new JButton("Exit");
        b9.setFont(f);
        b9.setForeground(Color.red);
        
        getContentPane().add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570,80,250,50));
        
        getContentPane().add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250,200,250,50));
        getContentPane().add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550,200,250,50));
        getContentPane().add(b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850,200,250,50));
        getContentPane().add(b4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250,300,250,50));
        getContentPane().add(b5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550,300,250,50));
        getContentPane().add(b6, new org.netbeans.lib.awtextra.AbsoluteConstraints(850,300,250,50));
        getContentPane().add(b7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250,400,250,50));
        getContentPane().add(b8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550,400,250,50));
        getContentPane().add(b9, new org.netbeans.lib.awtextra.AbsoluteConstraints(850,400,250,50));
        
        l1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school/icon/4.jpg")));
        getContentPane().add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1));
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        String str=ae.getActionCommand();
        if(str.equals("New Student")){
            new new_student().setVisible(true);
        }
        else if(str.equals("Update Student Detail")){
            new update_detail().setVisible(true);
        }
        else if(str.equals("Non Teaching Staff")){
            new non_teaching_staff().setVisible(true);
        }
        else if(str.equals("Teacher")){
            new teacher().setVisible(true);            
        }
        else if(str.equals("Library")){
            new library().setVisible(true);            
        }
        else if(str.equals("Details")){
            new detail().setVisible(true);            
        }
        else if(str.equals("Contact Us")){
            new contact().setVisible(true);
        }
        else if(str.equals("About")){
            new about().setVisible(true);
        }
        else{
            System.exit(0);
        }
        
    }
    public static void main(String args[]){
        new homepage().setVisible(true);
    }
    
}
