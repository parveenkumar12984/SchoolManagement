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
public class login extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5, schoolname;
    JComboBox schoolnamecb;
    JPasswordField pf1;
    JButton b1,b2;

    
    login(){
        super("Login Page");
        Font f=new Font("SansSerif", Font.BOLD,50);
        
        schoolname = new JLabel("<HTML><u><b>R.E.D. Sr. Sec. School<br>Chhuchhakwas(Jhajjar)</b></u></HTML>");
        schoolname.setFont(f);
        schoolname.setForeground(Color.black);
        
        l1=new JLabel();
        l2=new JLabel("Login Page"); 
        l2.setFont(f);
        l2.setForeground(Color.BLACK);
        
        Font ff=new Font("SansSerif", Font.BOLD,30);
        l3=new JLabel("Choose School Name:");
        l3.setFont(ff);
        l3.setForeground(Color.RED);
        schoolnamecb=new JComboBox();
        schoolnamecb.setFont(ff);
        schoolnamecb.setForeground(Color.RED);
        try{
            conn c1 = new conn();
            String q1="select * from login";
            ResultSet resultSet = c1.s.executeQuery(q1);
            while (resultSet.next()){
                schoolnamecb.addItem(resultSet.getString("schoolname"));
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        l4=new JLabel("Enter Password");
        l4.setFont(ff);
        l4.setForeground(Color.RED);
        pf1=new JPasswordField(20);
        pf1.setFont(ff);
        pf1.setForeground(Color.RED);
        Font fff=new Font("SansSerif", Font.BOLD,15);
        l5=new JLabel("<HTML><U>Forget Password.....!!</U></HTML>");
        l5.setFont(fff);
        l5.setForeground(Color.YELLOW);
        
        Font btnf=new Font("SansSerif", Font.BOLD,25);
        b1=new JButton("Sign In");
        b1.setFont(btnf);
        b1.setForeground(Color.BLUE);
        b2=new JButton("Cancel");
        b2.setFont(btnf);
        b2.setForeground(Color.BLUE);
        
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        getContentPane().add(schoolname, new org.netbeans.lib.awtextra.AbsoluteConstraints(400,20));
        
        //getContentPane().add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550,50,400,60));
        
        getContentPane().add(l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550,200));
        getContentPane().add(schoolnamecb, new org.netbeans.lib.awtextra.AbsoluteConstraints(900,200));
        getContentPane().add(l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550,300,250,50));
        getContentPane().add(pf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900,300,250,50));
        
        getContentPane().add(l5, new org.netbeans.lib.awtextra.AbsoluteConstraints(900,370,250,40));
        
        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school/icon/logo.png")));
        getContentPane().add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550,410,250,50));
        b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school/icon/cancel.jpg")));
        getContentPane().add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900,410,250,50));

        l1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school/icon/login.jpg")));
        getContentPane().add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1));
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        l5.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                new forget().setVisible(true);
            }
        });                
    }
    public void actionPerformed(ActionEvent ae){
        String str=ae.getActionCommand();

        String a=schoolnamecb.getSelectedItem().toString();
        String b=pf1.getText();
        if(str.equals("Sign In")){
            try{
                if(b.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Plzz Enter Password");
                    pf1.setText("");
                }
                else{
                    int flag=0;
                    String q1="select * from login";
                    conn c1=new conn();
                    ResultSet rs=c1.s.executeQuery(q1);
                    while(rs.next()){
                        if(rs.getString("schoolname").equals(a) && rs.getString("password").equals(b)){
                            new homepage().setVisible(true);
                            this.setVisible(false);
                            flag=1;
                            break;
                        
                        }
                    }
                    if(flag==0){
                        JOptionPane.showMessageDialog(null,"Plzz Enter Correct Password!!");
                        pf1.setText("");
                    }
                }
            }
            catch(Exception e){
                
            }
        }
        else if(str.equals("Cancel")){
            System.exit(0);
        }        
    }
    public static void main(String args[]){
        new login().setVisible(true);
        
    }
    
}
