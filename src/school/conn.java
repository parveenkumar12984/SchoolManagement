/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import java.sql.*;  

/**
 *
 * @author Parveen
 */
public class conn {
    Connection c;
    Statement s;
    public conn(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");
            c =DriverManager.getConnection("jdbc:mysql:///school","root","root");
            //c =DriverManager.getConnection("jdbc:mysql://db4free.net:3306/school_12984","parveen12984","parveen12984");
            s =c.createStatement();  
            System.out.println("Connected successfully");
            
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
       new conn();
    }
}