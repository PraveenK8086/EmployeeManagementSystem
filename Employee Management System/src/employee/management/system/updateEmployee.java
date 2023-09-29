package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateEmployee extends JFrame implements ActionListener {

    TextField teducation, tfname, taddress, tphone, taadhaar, temail, tsalary, tdesignation ;
    JLabel tempid;
    JButton add , back;
    String num;
    updateEmployee(String num){

        this.num= num;
        getContentPane().setBackground(new Color(204, 255, 204));

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("San_Serif", Font.BOLD, 20));
        add(name);

        JLabel tname= new JLabel();
        tname.setBounds(200, 150, 150 ,30);
        tname.setBackground(new Color(177, 252, 197));
        add(tname);


        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(500,150,150,30);
        fname.setFont(new Font("San_Serif", Font.BOLD, 20));
        add(fname);

        tfname= new TextField();
        tfname.setBounds(680, 150, 150 ,30);
        tfname.setBackground(new Color(177, 252, 197));
        add(tfname);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("San_Serif", Font.BOLD, 20));
        add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(tdob);

        JLabel sal = new JLabel("Salary");
        sal.setBounds(500,200,150,30);
        sal.setFont(new Font("San_Serif", Font.BOLD, 20));
        add(sal);

        tsalary= new TextField();
        tsalary.setBounds(680, 200, 150 ,30);
        tsalary.setBackground(new Color(177, 252, 197));
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("San_Serif", Font.BOLD, 20));
        add(address);

        taddress= new TextField();
        taddress.setBounds(200, 250, 150 ,30);
        taddress.setBackground(new Color(177, 252, 197));
        add(taddress);

        JLabel phone = new JLabel("Mobile No.");
        phone.setBounds(500,250,150,30);
        phone.setFont(new Font("San_Serif", Font.BOLD, 20));
        add(phone);

        tphone= new TextField();
        tphone.setBounds(680, 250, 150 ,30);
        tphone.setBackground(new Color(177, 252, 197));
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("San_Serif", Font.BOLD, 20));
        add(email);

        temail= new TextField();
        temail.setBounds(200, 300, 150 ,30);
        temail.setBackground(new Color(177, 252, 197));
        add(temail);

        JLabel aadhaar = new JLabel("Aadhaar No.");
        aadhaar.setBounds(500,300,150,30);
        aadhaar.setFont(new Font("San_Serif", Font.BOLD, 20));
        add(aadhaar);

        JLabel taadhaar= new JLabel();
        taadhaar.setBounds(680, 300, 150 ,30);
        taadhaar.setBackground(new Color(177, 252, 197));
        add(taadhaar);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(50,350,150,30);
        education.setFont(new Font("San_Serif", Font.BOLD, 20));
        add(education);

        teducation= new TextField();
        teducation.setBounds(200, 350, 150 ,30);
        teducation.setBackground(new Color(177, 252, 197));
        add(teducation);


        JLabel designation = new JLabel("Designation");
        designation.setBounds(500,350,150,30);
        designation.setFont(new Font("San_Serif", Font.BOLD, 20));
        add(designation);

        tdesignation= new TextField();
        tdesignation.setBounds(680, 350, 150 ,30);
        tdesignation.setBackground(new Color(177, 252, 197));
        add(tdesignation);

        JLabel empid = new JLabel("Employee ID");
        empid .setBounds(50,400,150,30);
        empid .setFont(new Font("San_Serif", Font.BOLD, 20));
        add(empid );

        tempid = new JLabel();
        tempid.setBounds(200, 400, 150 ,30);
        tempid.setFont(new Font("San_Sarif", Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);

        try{
            conn c = new conn();
            String query = "select * from employee where empId = '"+num+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while(resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                tsalary.setText(resultSet.getString("salary"));
                taddress.setText(resultSet.getString("address"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                taadhaar.setText(resultSet.getString("aadhaar"));
                teducation.setText(resultSet.getString("education"));
                tdesignation.setText(resultSet.getString("designation"));
                tempid.setText(resultSet.getString("empID"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        add = new JButton("Update");
        add.setBounds(250, 530, 150, 30);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("Back");
        back.setBounds(470, 530, 150, 30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);




        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50 );
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String email = temail.getText();
            String phone = tphone.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            try{
                conn c = new conn();
                String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', email = '"+email+"', phone = '"+phone+"', education = '"+education+"', designation = '"+designation+"' where empID = '"+num+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Detail updated successfully");
                setVisible(false);
                new Main_class();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new viewEmployee();
        }
    }

    public static void main(String[] args) {
        new updateEmployee("");
    }
}
