/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Parveen
 */
public class forget extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4;
    JTextField passwordtf;
    JButton b1,b2;
    JComboBox schoonamecb;
    
    forget(){
        
        super("Forget Page");
        
        Font f=new Font("SansSerif", Font.BOLD,50);
        
        l1=new JLabel();
        l2=new JLabel("Forget Page"); 
        l2.setFont(f);
        l2.setForeground(Color.BLACK);
        
        f=new Font("SansSerif", Font.BOLD,30);
        l3=new JLabel("Choose School Name ");
        l3.setFont(f);
        l3.setForeground(Color.RED);
        schoonamecb = new JComboBox();
        schoonamecb.setFont(f);
        schoonamecb.setForeground(Color.red);
        try{
            conn c1 = new conn();
            String q1="select * from login";
            ResultSet resultSet = c1.s.executeQuery(q1);
            while (resultSet.next()){
                schoonamecb.addItem(resultSet.getString("schoolname"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        l4=new JLabel("Enter Password");
        l4.setFont(f);
        l4.setForeground(Color.RED);
        passwordtf=new JTextField(20);
        passwordtf.setFont(f);
        passwordtf.setEditable(false);
        passwordtf.setForeground(Color.red);
        
        f=new Font("SansSerif", Font.BOLD,25);
        b1=new JButton("Show Password");
        b1.setFont(f);
        b1.setForeground(Color.BLUE);
        b2=new JButton("Back");
        b2.setFont(f);
        b2.setForeground(Color.BLUE);
        
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        getContentPane().add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550,50,400,60)); 
        
        getContentPane().add(l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500,200));
        getContentPane().add(schoonamecb, new org.netbeans.lib.awtextra.AbsoluteConstraints(900,200));
        getContentPane().add(l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500,300,250,50));
        getContentPane().add(passwordtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(900,300,250,50));
        
        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school/icon/showpassword.png")));
        getContentPane().add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500,410,250,50));
        b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school/icon/back.png")));
        getContentPane().add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900,410,250,50));

        l1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school/icon/forget.jpg")));
        getContentPane().add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1));
        
        b1.addActionListener(this);
        b2.addActionListener(this);               
    }
    public void actionPerformed(ActionEvent ae){
        String str=ae.getActionCommand();        
        String a=schoonamecb.getSelectedItem().toString();
        if(str.equals("Show Password")){
            try{
                if(a.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Plzz Select School Name.");

                }
                else{
                    String q1="select * from login where schoolname='"+a+"'";
                    conn c1=new conn();
                    ResultSet rs=c1.s.executeQuery(q1);
                    while(rs.next()){
                        if(a.equals(rs.getString("schoolname")))
                        {
                            passwordtf.setText(rs.getString("password"));
                        }
                    }
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
        new forget().setVisible(true);
        
    }
    
}
