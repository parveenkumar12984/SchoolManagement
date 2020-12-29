/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author Parveen
 */
public class update_book extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,backl,regl;
    JTextField nametf,pricetf;
    JComboBox idcb,countrycb;
    JDateChooser purdc;
    JButton backb,updateb;
    
    update_book(){
        super("Update Book Detail");
        setExtendedState(MAXIMIZED_BOTH);
        Font f=new Font("Arial",Font.BOLD,40);        
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        backl=new JLabel();
        regl=new JLabel("Book Update Portal");
        regl.setOpaque(true);
        regl.setFont(f);
        
        f=new Font("Arial",Font.BOLD,25);
        l1=new JLabel("Book ID");
        l1.setFont(f);
        idcb=new JComboBox();
        idcb.setFont(f);
        idcb.addItem("Select Book ID");
        try{
            conn c1=new conn();
            String q1="select * from library";
            ResultSet rs=c1.s.executeQuery(q1);
            while(rs.next()){
                idcb.addItem(rs.getString("bookid"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
                
        l2=new JLabel("Book Name ");
        l2.setFont(f);
        nametf=new JTextField(20);
        nametf.setFont(f);
        
        l3=new JLabel("Price");
        l3.setFont(f);
        pricetf=new JTextField(20);
        pricetf.setFont(f);
                
        l4=new JLabel("Purchasing Date");
        l4.setFont(f);
        purdc=new JDateChooser();
        purdc.setFont(f);
        purdc.setDateFormatString("yyyy-MM-dd");
        ((JTextField)purdc.getDateEditor().getUiComponent()).setEditable(false);                        
        
        l5=new JLabel("Country");
        l5.setFont(f);
        countrycb=new JComboBox();
        countrycb.setFont(f);
        countrycb.addItem("India");
        countrycb.addItem("other");
        
        f= new Font("Arial",Font.BOLD,35);
        
        updateb=new JButton("Update Book");
        updateb.setFont(f);
        
        backb=new JButton("Back");
        backb.setFont(f);
                        
        getContentPane().add(regl, new org.netbeans.lib.awtextra.AbsoluteConstraints(500,30));
        
        getContentPane().add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70,200,250,50));
        getContentPane().add(idcb,new org.netbeans.lib.awtextra.AbsoluteConstraints(280,200,250,50));
        
        getContentPane().add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70,300,250,50));
        getContentPane().add(nametf,new org.netbeans.lib.awtextra.AbsoluteConstraints(280,300,250,50));
        
        getContentPane().add(l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70,400,250,50));
        getContentPane().add(pricetf,new org.netbeans.lib.awtextra.AbsoluteConstraints(280,400,250,50));
        
        getContentPane().add(l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700,200,250,50));
        getContentPane().add(purdc,new org.netbeans.lib.awtextra.AbsoluteConstraints(960,200,250,50));
                        
        getContentPane().add(l5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700,300,250,50));
        getContentPane().add(countrycb,new org.netbeans.lib.awtextra.AbsoluteConstraints(960,300,250,50));               
        
        getContentPane().add(updateb,new org.netbeans.lib.awtextra.AbsoluteConstraints(400,580,250,50));
        getContentPane().add(backb,new org.netbeans.lib.awtextra.AbsoluteConstraints(800,580,250,50));
                        
        backl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school/icon/update-lib.jpg")));
        getContentPane().add(backl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1));
        
        updateb.addActionListener(this);
        backb.addActionListener(this);
        idcb.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent ae){
        String str=ae.getActionCommand();
        if(str.equals("comboBoxChanged")){
            try{
                conn c1=new conn();
                String q1="select * from library where bookid='"+(String)idcb.getSelectedItem()+"'";
                ResultSet rs=c1.s.executeQuery(q1);
                while(rs.next()){
                    nametf.setText(rs.getString("name"));
                    pricetf.setText(rs.getString("price"));
                    ((JTextField)purdc.getDateEditor().getUiComponent()).setText(rs.getString("purdate"));
                    countrycb.setSelectedItem(rs.getString("country"));
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else if(str.equals("Update Book")){            
            
            String name=nametf.getText();            
            String pur=((JTextField)purdc.getDateEditor().getUiComponent()).getText();
            String price=pricetf.getText();
            String country=(String)countrycb.getSelectedItem();            
            
            try{
                if(name.isEmpty()||pur.isEmpty()||price.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Plzz Enter All Details");
                    
                }
                else{
                    conn c1=new conn();
                    String q1="update library set name='"+name+"',price='"+price+"',purdate='"+pur+"',country='"+country+"' where id='"+(String)idcb.getSelectedItem()+"'";
                    c1.s.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null,"Book Updated Successfully");
                    idcb.setSelectedItem("Select Book ID");nametf.setText(""); ((JTextField)purdc.getDateEditor().getUiComponent()).setText("");
                    pricetf.setText("");
                }
                
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex);
            }
            
        }
        else{
            this.setVisible(false);
        }
    }
    public static void main(String args[]){
        new update_book().setVisible(true);
    }
    
}
