//===============================================
package com.pkg.readyapp.manager;
//===============================================
import java.sql.*;
//===============================================
public class GSQLite {
    //===============================================
    private static GSQLite m_intance = null;
    //===============================================
    private GSQLite() {
        String lQuery;
        // tables
        lQuery = String.format(""+
        "select * from sqlite_master\n"+
        "where type = 'table'\n"+
        "");
        queryShow(lQuery);
    }
    //===============================================
    public static synchronized GSQLite Instance() {           
        if(m_intance == null) {   
            m_intance = new GSQLite(); 
        }
        return m_intance;
    }
    //===============================================
    public Connection open() {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        String lDbPath = String.format("jdbc:sqlite:%s", lApp.sqlite_db_path);
        Connection lConnection = null;
        try {
            lConnection = DriverManager.getConnection(lDbPath);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return lConnection;
    }
    //===============================================
    public void queryShow(String sqlQuery) {
        try {
            Connection lConnection = open();
            Statement lStatement = lConnection.createStatement();
            ResultSet lResultSet = lStatement.executeQuery(sqlQuery);
            ResultSetMetaData lResultSetMetaData = lResultSet.getMetaData();
            int lColCount = lResultSetMetaData.getColumnCount();
            while (lResultSet.next()) {
                for(int i = 0; i < lColCount; i++) {
                    String lName = lResultSetMetaData.getColumnName(i);
                    System.out.print(String.format("%s\n", lName));
                }
            }
            lResultSet.close();
            lStatement.close();
            lConnection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //===============================================
}
//===============================================