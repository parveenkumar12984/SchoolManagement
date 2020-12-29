/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author Parveen
 */
public class update_non_teaching_staff extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,backl,regl;
    JTextField nametf,addtf,mobiletf,emailtf;
    JComboBox idcb,maritialcb,countrycb,qualificb,deptcb;
    JRadioButton malerb,femalerb;
    ButtonGroup bg1;
    JButton backb,updateb;
    
    update_non_teaching_staff(){
        super("Update non_teaching_staff Detail");
        setExtendedState(MAXIMIZED_BOTH);
        Font f=new Font("Arial",Font.BOLD,40);        
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        backl=new JLabel();
        regl=new JLabel("Non_Teaching_Staff Update Portal");
        regl.setFont(f);
        regl.setForeground(Color.BLACK);
        
        
        f=new Font("Arial",Font.BOLD,20);
        l1=new JLabel("Registration ID");
        l1.setFont(f);
        idcb=new JComboBox();
        idcb.setFont(f);
        idcb.addItem("Select ID");
        try{
            conn c1=new conn();
            String q1="select * from staff";
            ResultSet rs=c1.s.executeQuery(q1);
            while(rs.next()){
                idcb.addItem(rs.getString("id"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
                   
        l2=new JLabel("Name");
        l2.setFont(f);
        nametf=new JTextField(20);
        nametf.setFont(f);               
        
        l3=new JLabel("Sex");
        l3.setFont(f);
        malerb=new JRadioButton("Male");        
        femalerb=new JRadioButton("Female");
        malerb.setFont(f);
        femalerb.setFont(f);
        bg1=new ButtonGroup();
        bg1.add(malerb);
        bg1.add(femalerb);        
        
        l4=new JLabel("Maritial Status");
        l4.setFont(f);
        maritialcb=new JComboBox();
        maritialcb.setFont(f);
        maritialcb.addItem("Select Status");
        maritialcb.addItem("Single");
        maritialcb.addItem("Married");        
        
        l5=new JLabel("Address");
        l5.setFont(f);
        addtf=new JTextField(20);
        addtf.setFont(f);
        
        l10=new JLabel("Country");
        l10.setFont(f);
        countrycb=new JComboBox();
        countrycb.setFont(f);
        countrycb.addItem("Select Country");
        countrycb.addItem("India");
        countrycb.addItem("Other");
        
        l6=new JLabel("Qualifiaction");
        l6.setFont(f);
        qualificb=new JComboBox();
        qualificb.setFont(f);
        qualificb.addItem("Select Qualification");
        qualificb.addItem("B.A");
        qualificb.addItem("B.Sc");
        qualificb.addItem("BBA");
        qualificb.addItem("BCA");
        qualificb.addItem("B.Tech");
        qualificb.addItem("M.A");
        qualificb.addItem("M.Sc");
        qualificb.addItem("MBA");
        qualificb.addItem("MCA");
        qualificb.addItem("M.Tech");
        qualificb.addItem("Phd");
        
        l7=new JLabel("Department");
        l7.setFont(f);
        deptcb=new JComboBox();
        deptcb.setFont(f);
        deptcb.addItem("Select Department");
        deptcb.addItem("Select Department");
        deptcb.addItem("Clerk");
        deptcb.addItem("Accountent");
        deptcb.addItem("Typiest");
        deptcb.addItem("Sports Teacher");
        
        l8=new JLabel("Mobile No.");
        l8.setFont(f);
        mobiletf=new JTextField(20);
        mobiletf.setFont(f);
        
        l9=new JLabel("Email ID");
        l9.setFont(f);
        emailtf=new JTextField(20);
        emailtf.setFont(f);
        
        f= new Font("Arial",Font.BOLD,30);
        updateb=new JButton("Update");
        updateb.setFont(f);
        
        backb=new JButton("Back");
        backb.setFont(f);
        
        getContentPane().add(regl, new org.netbeans.lib.awtextra.AbsoluteConstraints(500,30));
        
        getContentPane().add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70,100,250,50));
        getContentPane().add(idcb,new org.netbeans.lib.awtextra.AbsoluteConstraints(280,100,250,50));
        
        getContentPane().add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70,200,250,50));
        getContentPane().add(nametf,new org.netbeans.lib.awtextra.AbsoluteConstraints(280,200,250,50));        
        
        getContentPane().add(l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70,300,250,50));
        getContentPane().add(malerb,new org.netbeans.lib.awtextra.AbsoluteConstraints(280,300,100,50));
        getContentPane().add(femalerb,new org.netbeans.lib.awtextra.AbsoluteConstraints(425,300,100,50));       
        
        getContentPane().add(l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70,400,250,50));
        getContentPane().add(maritialcb,new org.netbeans.lib.awtextra.AbsoluteConstraints(280,400,250,50));        
        
        getContentPane().add(l5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70,500,250,50));
        getContentPane().add(addtf,new org.netbeans.lib.awtextra.AbsoluteConstraints(280,500,250,50));
        
        getContentPane().add(l10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700,100,250,50));
        getContentPane().add(countrycb,new org.netbeans.lib.awtextra.AbsoluteConstraints(960,100,250,50));
        
        getContentPane().add(l6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700,200,250,50));
        getContentPane().add(qualificb,new org.netbeans.lib.awtextra.AbsoluteConstraints(960,200,250,50));
        
        getContentPane().add(l7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700,300,250,50));
        getContentPane().add(deptcb,new org.netbeans.lib.awtextra.AbsoluteConstraints(960,300,250,50));
        
        getContentPane().add(l8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700,400,250,50));
        getContentPane().add(mobiletf,new org.netbeans.lib.awtextra.AbsoluteConstraints(960,400,250,50));
        
        getContentPane().add(l9, new org.netbeans.lib.awtextra.AbsoluteConstraints(700,500,250,50));
        getContentPane().add(emailtf,new org.netbeans.lib.awtextra.AbsoluteConstraints(960,500,250,50));
        
        getContentPane().add(updateb,new org.netbeans.lib.awtextra.AbsoluteConstraints(300,600,300,50));
        getContentPane().add(backb,new org.netbeans.lib.awtextra.AbsoluteConstraints(800,600,300,50));
                        
        backl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school/icon/student.png")));
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
                String q1="select * from staff where id='"+(String)idcb.getSelectedItem()+"'";
                ResultSet rs=c1.s.executeQuery(q1);
                while(rs.next()){
                    nametf.setText(rs.getString("name"));                    
                    String sexx=rs.getString("sex");
                    if(sexx.equals("Male"))malerb.setSelected(true);
                    else femalerb.setSelected(true);
                    maritialcb.setSelectedItem(rs.getString("maritial_status"));
                    addtf.setText(rs.getString("address"));
                    countrycb.setSelectedItem(rs.getString("country"));
                    qualificb.setSelectedItem(rs.getString("qualification"));
                    deptcb.setSelectedItem(rs.getString("department"));
                    mobiletf.setText(rs.getString("mobile"));
                    emailtf.setText(rs.getString("email"));
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else if(str.equals("Update")){            
            
            String name=nametf.getText();
            String sex=null;
            if(malerb.isSelected())sex="Male";
            else sex="Female";        
            String maritial=(String)maritialcb.getSelectedItem();
            String address=addtf.getText();
            String country=(String)countrycb.getSelectedItem();
            String qualifi=(String)qualificb.getSelectedItem();
            String dept=(String)deptcb.getSelectedItem();
            String mobile=mobiletf.getText();
            String email=emailtf.getText();                                    
            try{
                if(name.isEmpty()||sex.isEmpty()||maritial.isEmpty()||address.isEmpty()||country.isEmpty()||
                        qualifi.isEmpty()||dept.isEmpty()||mobile.isEmpty()||email.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Plzz Enter All Details");
                    
                }
                else{
                    conn c1=new conn();
                    String q1="update staff set name='"+name+"',sex='"+sex+"',maritial_status='"+maritial+"',"
                            + "address='"+address+"',country='"+country+"',qualification='"+qualifi+"',"
                            + "department='"+dept+"',mobile='"+mobile+"',email='"+email+"' where id='"+(String)idcb.getSelectedItem()+"'";
                    c1.s.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null,"Record Updated Successfully");
                    idcb.setSelectedItem("Select ID");nametf.setText("");maritialcb.setSelectedItem("Select Status");
                    addtf.setText(""); countrycb.setSelectedItem("Select Country");qualificb.setSelectedItem("Select Qualification");
                    deptcb.setSelectedItem("Select Department"); mobiletf.setText("");emailtf.setText("");                    
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
        new update_non_teaching_staff().setVisible(true);
    }
    
}
