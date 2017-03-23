/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roic.projectd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author ruben.impa
 */
public class DatosDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public void save() {
        
        String sql = "INSERT INTO employee " + "(ID, NAME, AGE) VALUES (?, ?, ?)";
        Connection conn = null;

        try {

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, employee.getId());
//            ps.setString(2, employee.getName());
//            ps.setInt(3, employee.getAge());
            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }

    }
    
}
