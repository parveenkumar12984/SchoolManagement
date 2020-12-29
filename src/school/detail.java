/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Parveen
 */
public class detail extends JFrame implements ActionListener{
    JLabel titlel;
    JTable t1;
    JButton studentb,teacherb,backb;
    String x[] = {"ID", "Name","Sex","Maritial_Status","Address","Mobile","Email"};
    String y[][] = new String[30][7];
    int i=0, j=0;

    detail(){
        super("Details");
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.ORANGE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Font f=new Font("Arial",Font.BOLD,30);
        
        titlel=new JLabel("All Details");
        titlel.setFont(f);
        
        studentb=new JButton("Student Detail");        
        studentb.setFont(f);
        
        teacherb=new JButton("Teacher Detail");
        teacherb.setFont(f);
        
        backb=new JButton("Back");
        backb.setFont(f);
        
        t1=new JTable();
        JScrollPane sp=new JScrollPane(t1);                
        
        getContentPane().add(titlel,new org.netbeans.lib.awtextra.AbsoluteConstraints(570,2,300,40));
        
        getContentPane().add(sp,new org.netbeans.lib.awtextra.AbsoluteConstraints(5,50,1350,550));
        
        getContentPane().add(studentb,new org.netbeans.lib.awtextra.AbsoluteConstraints(200,650,300,50));
        getContentPane().add(teacherb,new org.netbeans.lib.awtextra.AbsoluteConstraints(550,650,300,50));
        getContentPane().add(backb,new org.netbeans.lib.awtextra.AbsoluteConstraints(900,650,300,50));
        
        studentb.addActionListener(this);
        teacherb.addActionListener(this);
        backb.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent ae){
        String str=ae.getActionCommand();
        if(str.equals("Student Detail")){
            try{
                DefaultTableModel model=new DefaultTableModel();
                model.setColumnIdentifiers(x);
                t1.setModel(model);
                conn c1=new conn();
                String s1 = "select * from student";
                ResultSet rs  = c1.s.executeQuery(s1);
                while(rs.next()){                    
                    String id=rs.getString("id");
                    String name=rs.getString("name");
                    String sex=rs.getString("sex");
                    String maritial=rs.getString("maritial_status");
                    String address=rs.getString("address");
                    String mobile=rs.getString("mobile");
                    String email=rs.getString("email");
                    i++;
                    j=0;  
                    model.addRow(new Object[]{id,name,sex,maritial,address,mobile,email});
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }            
        }
        else if(str.equals("Teacher Detail")){
            try{
                DefaultTableModel model=new DefaultTableModel();
                model.setColumnIdentifiers(x);
                t1.setModel(model);
                conn c1=new conn();
                String s1 = "select * from teacher";
                ResultSet rs  = c1.s.executeQuery(s1);
                while(rs.next()){                    
                    String id=rs.getString("id");
                    String name=rs.getString("name");
                    String sex=rs.getString("sex");
                    String maritial=rs.getString("maritial_status");
                    String address=rs.getString("address");
                    String mobile=rs.getString("mobile");
                    String email=rs.getString("email");
                    i++;
                    j=0;  
                    model.addRow(new Object[]{id,name,sex,maritial,address,mobile,email});
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
        new detail().setVisible(true);
    }
    
}
