package net.javaguides.swing;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class user
{
  public static void main(String[] args) 
  {
    try 
  {
      String url = "jdbc:mysql://localhost:3306/LMS";
      String user = "root";
      String password = "system";
    
      Connection con = DriverManager.getConnection(url, user, password);
    
      String query = "SELECT * FROM users";
    
      Statement stm = con.createStatement();
      ResultSet res = stm.executeQuery(query);
    
      String columns[] = { "uid", "uname", "password" };
      String data[][] = new String[8][3];
    
      int i = 0;
      while (res.next()) {
        int id = res.getInt("uid");
        String nom = res.getString("uname");
        String price = res.getString("password");
        data[i][0] = id + "";
        data[i][1] = nom;
        data[i][2] = price ;
        i++;
      }
    
      DefaultTableModel model = new DefaultTableModel(data, columns);
      JTable table = new JTable(model);
      table.setShowGrid(true);
      table.setShowVerticalLines(true);
     
      JScrollPane pane = new JScrollPane(table);
      JFrame f = new JFrame("Users List");
      JPanel panel = new JPanel();
      panel.add(pane);
      f.add(panel);
      f.setBounds(200,80,500, 200);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
    
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }
}
