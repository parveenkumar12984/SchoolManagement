/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sql.*;

/**
 *
 * @author Parveen
 */
public class contact extends JFrame implements ActionListener{
    JLabel titlel,backl,namel,maill,mobilel,queryl;
    JTextField nametf,mailtf,mobiletf;
    JTextArea queryta;
    JButton submitb,backb;
    contact(){
        super("Contact Us");
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Font f=new Font("Arial",Font.BOLD,40);
        
        backl=new JLabel();
        titlel=new JLabel("Contact Us");
        titlel.setFont(f);
                
        f=new Font("Arial",Font.BOLD,25);
        namel=new JLabel("Name");
        namel.setFont(f);
        nametf=new JTextField(20);
        nametf.setFont(f);
        
        maill=new JLabel("E-Mail");
        maill.setFont(f);
        mailtf=new JTextField(20);
        mailtf.setFont(f);
        
        mobilel=new JLabel("Mobile Number");
        mobilel.setFont(f);
        mobiletf=new JTextField(20);
        mobiletf.setFont(f);
        
        queryl=new JLabel("Enter Query");
        queryl.setFont(f);
        queryta=new JTextArea();
        queryta.setFont(f);
        
        submitb=new JButton("Submit");
        submitb.setFont(f);
        
        backb=new JButton("Back");
        backb.setFont(f);
        
        
        getContentPane().add(titlel,new org.netbeans.lib.awtextra.AbsoluteConstraints(580,20,250,50));
        
        getContentPane().add(namel,new org.netbeans.lib.awtextra.AbsoluteConstraints(100,100,250,50));
        getContentPane().add(nametf,new org.netbeans.lib.awtextra.AbsoluteConstraints(350,100,250,50));
        
        getContentPane().add(maill,new org.netbeans.lib.awtextra.AbsoluteConstraints(100,200,250,50));
        getContentPane().add(mailtf,new org.netbeans.lib.awtextra.AbsoluteConstraints(350,200,250,50));
        
        getContentPane().add(mobilel,new org.netbeans.lib.awtextra.AbsoluteConstraints(100,300,250,50));
        getContentPane().add(mobiletf,new org.netbeans.lib.awtextra.AbsoluteConstraints(350,300,250,50));
        
        getContentPane().add(queryl,new org.netbeans.lib.awtextra.AbsoluteConstraints(100,400,250,50));
        getContentPane().add(queryta,new org.netbeans.lib.awtextra.AbsoluteConstraints(350,400,250,150));
        
        getContentPane().add(submitb,new org.netbeans.lib.awtextra.AbsoluteConstraints(500,600,250,50));
        getContentPane().add(backb,new org.netbeans.lib.awtextra.AbsoluteConstraints(800,600,250,50));
        
        backl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school/icon/student.png")));
        getContentPane().add(backl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1));
        
        submitb.addActionListener(this);
        backb.addActionListener(this);
                
    }
    public void actionPerformed(ActionEvent ae){
        String str=ae.getActionCommand();
        String name=nametf.getText();
        String mail=mailtf.getText();
        String mobile=mobiletf.getText();
        String query=queryta.getText();
        if(str.equals("Submit")){
            try{
                if(name.isEmpty()||mail.isEmpty()||mobile.isEmpty()||query.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Plzz Enter Details.");
                }
                else{
                    conn c1=new conn();
                    String q1="insert into contact values('"+name+"','"+mail+"','"+mobile+"','"+query+"')";
                    c1.s.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null,"Your Query Submitted Successfully.");
                    nametf.setText("");mailtf.setText("");mobiletf.setText("");queryta.setText("");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            this.setVisible(false);
        }
    }
    public static void main(String args[]){
        new contact().setVisible(true);
    }
}
