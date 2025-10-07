package com.labSync.LabSync.persistence;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class MySqlConnection {

    private Connection connection;

    public void openConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String address = "jdbc:mysql://" + DBConstants.IP + ":" + DBConstants.PORT + "/"
                    + DBConstants.BD_NAME;
            this.connection = DriverManager.getConnection(address, DBConstants.LOGIN, DBConstants.PASSWORD);

        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try{
            if(this.connection != null || !this.connection.isClosed()){
                this.connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return this.connection;
    }

}
