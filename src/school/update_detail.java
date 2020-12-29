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
public class update_detail extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,backl,regl;
    JTextField nametf,fnametf,mnametf,addtf,mobiletf,emailtf;
    JComboBox idcb,classcb,maritialcb,countrycb;
    JRadioButton malerb,femalerb;
    JDateChooser dobdc;
    JButton saveb,backb;
    ButtonGroup bg1;
    
    update_detail(){
        super("Update Detail");
        setExtendedState(MAXIMIZED_BOTH);
        Font f=new Font("Arial",Font.BOLD,40);        
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        backl=new JLabel();
        regl=new JLabel("Update Detail Form");
        regl.setFont(f);
        regl.setForeground(Color.BLACK);
        
        f=new Font("Arial",Font.BOLD,20);
        l1=new JLabel("Registration ID");
        l1.setFont(f);
        idcb=new JComboBox();
        idcb.addItem("Select Registration ID");
        idcb.setFont(f);
        try{
            conn c1=new conn();
            String q1="select * from student";
            ResultSet rs=c1.s.executeQuery(q1);
            while(rs.next()){
                idcb.addItem(rs.getString("id"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        l2=new JLabel("Name ");
        l2.setFont(f);
        nametf=new JTextField(20);
        nametf.setFont(f);
        
        l3=new JLabel("Class");
        l3.setFont(f);
        classcb=new JComboBox();
        classcb.setFont(f);
        classcb.addItem("Select Class");
        classcb.addItem("LKG");
        classcb.addItem("UKG");
        classcb.addItem("1");
        classcb.addItem("2");
        classcb.addItem("3");
        classcb.addItem("4");
        classcb.addItem("5");
        classcb.addItem("6");
        classcb.addItem("7");
        classcb.addItem("8");
        classcb.addItem("9");
        classcb.addItem("10");
        classcb.addItem("11");
        classcb.addItem("12");
        
        l4=new JLabel("Sex");
        l4.setFont(f);
        malerb=new JRadioButton("Male");        
        femalerb=new JRadioButton("Female");
        malerb.setFont(f);
        femalerb.setFont(f);
        bg1=new ButtonGroup();
        bg1.add(malerb);
        bg1.add(femalerb);
        
        l5=new JLabel("Date of Birth");
        l5.setFont(f);
        dobdc=new JDateChooser();
        dobdc.setFont(f);
        dobdc.setDateFormatString("yyyy-MM-dd");
        ((JTextField)dobdc.getDateEditor().getUiComponent()).setEditable(false);
        
        l6=new JLabel("Maritial Status");
        l6.setFont(f);
        maritialcb=new JComboBox();
        maritialcb.setFont(f);
        maritialcb.addItem("Select Status");
        maritialcb.addItem("Single");
        maritialcb.addItem("Married");
        
        l7=new JLabel("Father Name");
        l7.setFont(f);
        fnametf=new JTextField(20);
        fnametf.setFont(f);
        
        l8=new JLabel("Mother Name");
        l8.setFont(f);
        mnametf=new JTextField(20);
        mnametf.setFont(f);
        
        l9=new JLabel("Address");
        l9.setFont(f);
        addtf=new JTextField(20);
        addtf.setFont(f);
        
        l10=new JLabel("Country");
        l10.setFont(f);
        countrycb=new JComboBox();
        countrycb.setFont(f);
        countrycb.addItem("India");
        countrycb.addItem("other");
        
        l11=new JLabel("Mobile No.");
        l11.setFont(f);
        mobiletf=new JTextField(20);
        mobiletf.setFont(f);
        
        l12=new JLabel("Email ID");
        l12.setFont(f);
        emailtf=new JTextField(20);
        emailtf.setFont(f);
        
        f= new Font("Arial",Font.BOLD,30);
        saveb=new JButton("Update");
        saveb.setFont(f);
        
        backb=new JButton("Back");
        backb.setFont(f);
        
        getContentPane().add(regl, new org.netbeans.lib.awtextra.AbsoluteConstraints(500,30));
        
        getContentPane().add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70,100,250,50));
        getContentPane().add(idcb,new org.netbeans.lib.awtextra.AbsoluteConstraints(280,100,250,50));
        
        getContentPane().add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70,170,250,50));
        getContentPane().add(nametf,new org.netbeans.lib.awtextra.AbsoluteConstraints(280,170,250,50));
        
        getContentPane().add(l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70,240,250,50));
        getContentPane().add(classcb,new org.netbeans.lib.awtextra.AbsoluteConstraints(280,240,250,50));
        
        getContentPane().add(l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70,310,250,50));
        getContentPane().add(malerb,new org.netbeans.lib.awtextra.AbsoluteConstraints(280,310,100,50));
        getContentPane().add(femalerb,new org.netbeans.lib.awtextra.AbsoluteConstraints(425,310,100,50));
        
        getContentPane().add(l5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70,380,250,50));
        getContentPane().add(dobdc,new org.netbeans.lib.awtextra.AbsoluteConstraints(280,380,250,50));
        
        getContentPane().add(l6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70,450,250,50));
        getContentPane().add(maritialcb,new org.netbeans.lib.awtextra.AbsoluteConstraints(280,450,250,50));
        
        getContentPane().add(l7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700,100,250,50));
        getContentPane().add(fnametf,new org.netbeans.lib.awtextra.AbsoluteConstraints(960,100,250,50));
        
        getContentPane().add(l8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700,170,250,50));
        getContentPane().add(mnametf,new org.netbeans.lib.awtextra.AbsoluteConstraints(960,170,250,50));
        
        getContentPane().add(l9, new org.netbeans.lib.awtextra.AbsoluteConstraints(700,240,250,50));
        getContentPane().add(addtf,new org.netbeans.lib.awtextra.AbsoluteConstraints(960,240,250,50));
        
        getContentPane().add(l10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700,310,250,50));
        getContentPane().add(countrycb,new org.netbeans.lib.awtextra.AbsoluteConstraints(960,310,250,50));
        
        getContentPane().add(l11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700,380,250,50));
        getContentPane().add(mobiletf,new org.netbeans.lib.awtextra.AbsoluteConstraints(960,380,250,50));
        
        getContentPane().add(l12, new org.netbeans.lib.awtextra.AbsoluteConstraints(700,450,250,50));
        getContentPane().add(emailtf,new org.netbeans.lib.awtextra.AbsoluteConstraints(960,450,250,50));
        
        getContentPane().add(saveb,new org.netbeans.lib.awtextra.AbsoluteConstraints(400,580,250,50));
        getContentPane().add(backb,new org.netbeans.lib.awtextra.AbsoluteConstraints(800,580,250,50));
        
        backl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school/icon/update.jpg")));
        getContentPane().add(backl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1));
        
        saveb.addActionListener(this);
        backb.addActionListener(this);
        idcb.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent ae){
        String str=ae.getActionCommand();
        if(str.equals("comboBoxChanged")){
            try{
                conn c1=new conn();
                String q1="select * from student where id='"+(String)idcb.getSelectedItem()+"'";
                ResultSet rs=c1.s.executeQuery(q1);
                while(rs.next()){
                    nametf.setText(rs.getString("name"));
                    classcb.setSelectedItem(rs.getString("class"));
                    String sexx=rs.getString("sex");
                    if(sexx.equals("Male"))malerb.setSelected(true);
                    else femalerb.setSelected(true);
                    ((JTextField)dobdc.getDateEditor().getUiComponent()).setText(rs.getString("DOB"));
                    maritialcb.setSelectedItem(rs.getString("maritial_status"));
                    fnametf.setText(rs.getString("fname"));
                    mnametf.setText(rs.getString("mname"));
                    addtf.setText(rs.getString("address"));
                    countrycb.setSelectedItem(rs.getString("country"));
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
            String classs=(String)classcb.getSelectedItem();
            String sex=null;
            if(malerb.isSelected())sex="Male";
            else sex="Female";
            String dob=((JTextField)dobdc.getDateEditor().getUiComponent()).getText();
            String maritial=(String)maritialcb.getSelectedItem();
            String fname=fnametf.getText();
            String mname=mnametf.getText();
            String address=addtf.getText();
            String country=(String)countrycb.getSelectedItem();
            String mobile=mobiletf.getText();
            String email=emailtf.getText();
            
            try{
                if(name.isEmpty()||classs.equals("Select Class")||sex.isEmpty()||dob.isEmpty()||maritial.equals("Select Status")||
                        fname.isEmpty()||mname.isEmpty()||address.isEmpty()||country.isEmpty()||mobile.isEmpty()||
                        email.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Plzz Enter All Details");
                    
                }
                else{
                conn c1=new conn();
                String q1="update student set name='"+name+"',class='"+classs+"',sex='"+sex+"',DOB='"+dob+"',"
                        + "maritial_status='"+maritial+"',fname='"+fname+"',mname='"+mname+"',address='"+address+"',"
                        + "country='"+country+"',mobile='"+mobile+"',email='"+email+"' where id='"+(String)idcb.getSelectedItem()+"'";
                c1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Record Updated Successfully");
                idcb.setSelectedItem("Select Registration ID");nametf.setText("");classcb.setSelectedIndex(0);((JTextField)dobdc.getDateEditor().getUiComponent()).setText("");
                maritialcb.setSelectedIndex(0);fnametf.setText("");mnametf.setText("");addtf.setText("");
                mobiletf.setText("");emailtf.setText("");
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
        new update_detail().setVisible(true);
    }
    
}
