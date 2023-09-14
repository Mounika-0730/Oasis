package net.javaguides.swing;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class issued
{
  public static void main(String[] args) 
  {
    try 
  {
      String url = "jdbc:mysql://localhost:3306/LMS";
      String user = "root";
      String password = "system";
    
      Connection con = DriverManager.getConnection(url, user, password);
    
      String query = "SELECT * FROM ISSUE";
    
      Statement stm = con.createStatement();
      ResultSet res = stm.executeQuery(query);
    
      String columns[] = { "bid", "uid", "period","date" };
      String data[][] = new String[8][4];
    
      int i = 0;
      while (res.next()) {
        int id = res.getInt("bid");
        int nom = res.getInt("uid");
        int price = res.getInt("period");
        String qty=res.getString("idate");
        data[i][0] = id + "";
        data[i][1] = nom + "";
        data[i][2] = price + "";
        data[i][3] = qty;
        i++;
      }
    
      DefaultTableModel model = new DefaultTableModel(data, columns);
      JTable table = new JTable(model);
      table.setShowGrid(true);
      table.setShowVerticalLines(true);
     
      JScrollPane pane = new JScrollPane(table);
      JFrame f = new JFrame("Issued Books");
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
