package net.javaguides.swing;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Library extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblPassword;
    private JLabel lblUsername;
    private JLabel lblPassword2;
    private JLabel lblUsername2;
    private JLabel lblPassword3;
    private JLabel lblUsername3;
    private JLabel email;
    private JTextField username;
    private JTextField username2;
    private JTextField username3;
    private JTextField gmail;
    private JPasswordField passwordField;
    private JPasswordField passwordField2;
    private JPasswordField passwordField3;
    private JButton btnNewButton;
    private JButton btnNewButton1;
    private JButton btnNewButton2;
    private JButton btnNewButton3;
    private JButton btnNewButton4;
    private JButton btnNewButton5;
    private JButton btnNewButton6;
    private JButton btnNewButton7;
 
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Library frame = new Library();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Library() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(20,20,1000,700);
        setResizable(false);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);       
        
        lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(50,400,150,50);
        lblUsername.setVisible(false);
        
        lblUsername2 = new JLabel("Username");
        lblUsername2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername2.setBounds(50,400,150,50);
        lblUsername2.setVisible(false);
        
        lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(50,470,150,50);
        lblPassword.setVisible(false);
        
        lblPassword2 = new JLabel("Password");
        lblPassword2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword2.setBounds(50,540,150,50);
        lblPassword2.setVisible(false);
        
        email = new JLabel("Email");
        email.setFont(new Font("Tahoma", Font.PLAIN, 20));
        email.setBounds(50,470,150,50);
        email.setVisible(false);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(150,480,228,30);
        passwordField.setVisible(false);
        
        passwordField2 = new JPasswordField();
        passwordField2.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField2.setBounds(150,540,228,30);
        passwordField2.setVisible(false);
        
        btnNewButton3 = new JButton("Submit");
        btnNewButton3.setFont(new Font("Tahoma", Font.PLAIN,20));
        btnNewButton3.setBounds(120,550,150,50);
        btnNewButton3.setVisible(false);
        
        btnNewButton4 = new JButton("Submit");
        btnNewButton4.setFont(new Font("Tahoma", Font.PLAIN,20));
        btnNewButton4.setBounds(120,580,150,50);
        btnNewButton4.setVisible(false);
                                
        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(150,410, 228,30);
        username.setColumns(10);
        username.setVisible(false);
        
        username2 = new JTextField();
        username2.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username2.setBounds(150,410, 228,30);
        username2.setColumns(10);
        username2.setVisible(false);
        
        gmail = new JTextField();
        gmail.setFont(new Font("Tahoma", Font.PLAIN, 32));
        gmail.setBounds(150,480,228,30);
        gmail.setColumns(10);
        gmail.setVisible(false);
        
        contentPane.add(passwordField);
        contentPane.add(btnNewButton3);
        contentPane.add(username);
        contentPane.add(lblPassword);
        contentPane.add(lblUsername);
        contentPane.add(passwordField2);
        contentPane.add(btnNewButton4);
        contentPane.add(username2);
        contentPane.add(lblPassword2);
        contentPane.add(lblUsername2);
        contentPane.add(email);
        contentPane.add(gmail);
        
        btnNewButton2 = new JButton("SignUp");
        btnNewButton2.setFont(new Font("Tahoma", Font.PLAIN,20));
        btnNewButton2.setBounds(210,300,150,50);
        btnNewButton2.setVisible(false);
        contentPane.add(btnNewButton2);
        
        btnNewButton1 = new JButton("SignIn");
    	btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN,20));
        btnNewButton1.setBounds(50,300,150,50);
        btnNewButton1.setVisible(false);
        contentPane.add(btnNewButton1);
               
        JLabel lblNewUserRegister = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(150,20,800,50);
        contentPane.add(lblNewUserRegister);
        
        btnNewButton = new JButton("ADMIN");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN,50));
        btnNewButton.setBounds(100,150,200,100);
        contentPane.add(btnNewButton);
               
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	btnNewButton2.setVisible(true);
            	btnNewButton1.setVisible(true);
            	
            	 btnNewButton1.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent e) {
                    	 if (e.getSource() == btnNewButton1) {
                    		 username.setVisible(true);
                             passwordField.setVisible(true);
                             lblUsername.setVisible(true);
                             btnNewButton3.setVisible(true);
                             lblPassword.setVisible(true);
                             username2.setVisible(false);
                             passwordField2.setVisible(false);
                             lblUsername2.setVisible(false);
                             btnNewButton4.setVisible(false);
                             lblPassword2.setVisible(false);
                             email.setVisible(false);
                             gmail.setVisible(false);
                             
                             btnNewButton3.addActionListener(new ActionListener() {
                                 public void actionPerformed(ActionEvent e) {
                                	 String userName1 = username.getText();
                                     String passWord1 = passwordField.getText();
                                    
                                     try {
                                         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LMS", "root", "system");                                         
                                         String query1="Select * from library1 where user_name='"+userName1+"' AND password='"+passWord1+"'";
                                         Statement sta = connection.createStatement();                     
                                         ResultSet y=sta.executeQuery(query1);
                                         if (y.next()) {
                                        	 Library2 lib=new Library2();
                                        	 lib.setVisible(true);
                                         } else {
                                        	 JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                                        	 
                                         }
                                         connection.close();
                                     } catch (Exception exception) {
                                         exception.printStackTrace();
                                     }
                                	
                                 }
                             });
                             
                            }
                    	 
                     }
            	 });
            	 btnNewButton2.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent e) {
                    	 if (e.getSource() == btnNewButton2) {
                    		 username2.setVisible(true);
                             passwordField2.setVisible(true);
                             lblUsername2.setVisible(true);
                             btnNewButton4.setVisible(true);
                             lblPassword2.setVisible(true);
                             email.setVisible(true);
                             gmail.setVisible(true);
                             btnNewButton3.setVisible(false);
                             username.setVisible(false);
                             passwordField.setVisible(false);
                             lblUsername.setVisible(false);
                             lblPassword.setVisible(false);
                             
                             btnNewButton4.addActionListener(new ActionListener() {
                                 public void actionPerformed(ActionEvent e) {
                                	 String userName = username2.getText();
                                     String Gmail = gmail.getText();
                                     String passWord = passwordField2.getText();
                                     String msg = "" + userName;
                                     msg += " \n";                                    

                                     try {
                                         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LMS", "root", "system");
                                         String query = "INSERT INTO library1 values('" + userName + "','" + Gmail + "','"+ passWord + "')";
                                         Statement sta = connection.createStatement();
                                         int x = sta.executeUpdate(query);
                                         if (x == 0) {
                                             JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                                         } else {
                                             JOptionPane.showMessageDialog(btnNewButton,
                                                 "Welcome, " + msg + "Your account is sucessfully created.Now you can SignIn into your account");
                                         }
                                         connection.close();
                                     } catch (Exception exception) {
                                         exception.printStackTrace();
                                     }
                                     
                                 }
                             });                               	                             
                            }                   	 
                     }
            	 });                           	
            }
        });
        
        lblUsername3 = new JLabel("Username");
        lblUsername3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername3.setBounds(600,400,150,50);
        lblUsername3.setVisible(false);
        
        lblPassword3 = new JLabel("Password");
        lblPassword3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword3.setBounds(600,470,150,50);
        lblPassword3.setVisible(false);
        
        username3 = new JTextField();
        username3.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username3.setBounds(700,410, 228,30);
        username3.setColumns(10);
        username3.setVisible(false);
        
        passwordField3 = new JPasswordField();
        passwordField3.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField3.setBounds(700,480,228,30);
        passwordField3.setVisible(false);
        
        btnNewButton7 = new JButton("Submit");
        btnNewButton7.setFont(new Font("Tahoma", Font.PLAIN,20));
        btnNewButton7.setBounds(670,550,150,50);
        btnNewButton7.setVisible(false);
        
        contentPane.add(passwordField3);
        contentPane.add(btnNewButton7);
        contentPane.add(username3);
        contentPane.add(lblPassword3);
        contentPane.add(lblUsername3);
        
        btnNewButton6 = new JButton("LogIn");
    	btnNewButton6.setFont(new Font("Tahoma", Font.PLAIN,20));
        btnNewButton6.setBounds(720,300,150,50);
        btnNewButton6.setVisible(false);
        contentPane.add(btnNewButton6);
       
        btnNewButton5 = new JButton("USER");
        btnNewButton5.setFont(new Font("Tahoma", Font.PLAIN,50));
        btnNewButton5.setBounds(700,150,200,100);
        contentPane.add(btnNewButton5);
        
        btnNewButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	btnNewButton6.setVisible(true);
            	btnNewButton6.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                   	 if (e.getSource() == btnNewButton6) {
                   		 username3.setVisible(true);
                            passwordField3.setVisible(true);
                            lblUsername3.setVisible(true);
                            btnNewButton7.setVisible(true);
                            lblPassword3.setVisible(true);                           
                            
                           }                   	 
                    }
           	 });
            }
        });
    }
}