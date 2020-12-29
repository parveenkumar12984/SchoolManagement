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
import com.toedter.calendar.JDateChooser;
/**
 *
 * @author Parveen
 */
public class library extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,backl,regl;
    JTextField idtf,nametf,pricetf;
    JComboBox countrycb;
    JDateChooser purdc;
    JButton saveb,backb,updateb;
    
    library(){
        super("Library Registration");
        setExtendedState(MAXIMIZED_BOTH);
        Font f=new Font("Arial",Font.BOLD,40);        
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        backl=new JLabel();
        regl=new JLabel("Library Management");
        regl.setFont(f);
        regl.setForeground(Color.BLACK);
        
        f=new Font("Arial",Font.BOLD,20);
        l1=new JLabel("Book ID");
        l1.setFont(f);
        idtf=new JTextField(20);
        idtf.setFont(f);
        
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
        
        f= new Font("Arial",Font.BOLD,30);
        saveb=new JButton("Save Book");
        saveb.setFont(f);
        
        updateb=new JButton("Update Book");
        updateb.setFont(f);
        
        backb=new JButton("Back");
        backb.setFont(f);
                        
        getContentPane().add(regl, new org.netbeans.lib.awtextra.AbsoluteConstraints(500,30));
        
        getContentPane().add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70,200,250,50));
        getContentPane().add(idtf,new org.netbeans.lib.awtextra.AbsoluteConstraints(280,200,250,50));
        
        getContentPane().add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70,300,250,50));
        getContentPane().add(nametf,new org.netbeans.lib.awtextra.AbsoluteConstraints(280,300,250,50));
        
        getContentPane().add(l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70,400,250,50));
        getContentPane().add(pricetf,new org.netbeans.lib.awtextra.AbsoluteConstraints(280,400,250,50));
        
        getContentPane().add(l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700,200,250,50));
        getContentPane().add(purdc,new org.netbeans.lib.awtextra.AbsoluteConstraints(960,200,250,50));
                        
        getContentPane().add(l5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700,300,250,50));
        getContentPane().add(countrycb,new org.netbeans.lib.awtextra.AbsoluteConstraints(960,300,250,50));               
        
        getContentPane().add(saveb,new org.netbeans.lib.awtextra.AbsoluteConstraints(300,580,250,50));
        getContentPane().add(updateb,new org.netbeans.lib.awtextra.AbsoluteConstraints(600,580,250,50));
        getContentPane().add(backb,new org.netbeans.lib.awtextra.AbsoluteConstraints(900,580,250,50));
                        
        backl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school/icon/libb.jpg")));
        getContentPane().add(backl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1));
        
        saveb.addActionListener(this);
        updateb.addActionListener(this);
        backb.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        String str=ae.getActionCommand();
        String id=idtf.getText();
        String name=nametf.getText();
        String price=pricetf.getText();
        String purdate=((JTextField)purdc.getDateEditor().getUiComponent()).getText();
        String country=(String)countrycb.getSelectedItem();
        
        if(str.equals("Save Book")){
            try{
                if(id.isEmpty()||name.isEmpty()||price.isEmpty()||purdate.isEmpty()||country.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Plzz Enter All Details");                    
                }
                else{
                conn c1=new conn();
                String q1="insert into library values('"+id+"','"+name+"','"+price+"','"+purdate+"','"+country+"')";
                c1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Book Added Successfully");
                idtf.setText(""); nametf.setText(""); pricetf.setText("");
                ((JTextField)purdc.getDateEditor().getUiComponent()).setText("");               
                }
                
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex);
            }
            
        }
        else if(str.equals("Update Book")){
            new update_book().setVisible(true);
        }
        else{
            this.setVisible(false);
        }
        
    }
    public static void main(String args[]){
        new library().setVisible(true);
        
    }
    
}
