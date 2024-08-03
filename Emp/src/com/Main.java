package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setId(123);
        emp.setEname("Ajai");
        emp.setSal(10000000);
        emp.setDoj(Date.valueOf(LocalDate.of(2024, Month.DECEMBER, 29)));
        emp.setDob(Date.valueOf(LocalDate.of(1999, Month.FEBRUARY, 19)));
        emp.setDes("karur");
        emp.setDept("CSE");
        emp.setAddress("karur");
        emp.setPhoto("img.jpg");

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsbdb", "root", "root");
             PreparedStatement pst = con.prepareStatement("INSERT INTO Emp (Address, Dept, Des, Ename, Photo, Dob, Doj, Id, Sal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            pst.setString(1, emp.getAddress());
            pst.setString(2, emp.getDept());
            pst.setString(3, emp.getDes());
            pst.setString(4, emp.getEname());
            pst.setString(5, emp.getPhoto());
            pst.setDate(6, emp.getDob());
            pst.setDate(7, emp.getDoj());
            pst.setInt(8, emp.getId());
            pst.setFloat(9, emp.getSal());

            pst.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
