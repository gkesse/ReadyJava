//===============================================
package com.pkg.readyapp.manager;
//===============================================
import java.util.*;
import java.sql.*;
//===============================================
public class GSQLite {
    //===============================================
    private static GSQLite m_intance = null;
    //===============================================
    private GSQLite() {
        String lQuery;
        // config_data
        lQuery = String.format(""+
        "create table if not exists config_data (\n"+
        "config_key text,\n"+
        "config_value text\n"+
        ")");
        queryWrite(lQuery);
        // tables
        lQuery = String.format(""+
        "select type, name, tbl_name, rootpage\n"+
        "from sqlite_master\n"+
        "where type = 'table'\n"+
        "");
        queryShow(lQuery, "10", 20);
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
    public void queryShow(String sqlQuery, String widthMap, int defaultWidth) {
        try {
            Connection lConnection = open();
            Statement lStatement = lConnection.createStatement();
            ResultSet lResultSet = lStatement.executeQuery(sqlQuery);
            ResultSetMetaData lResultSetMetaData = lResultSet.getMetaData();
            int lColCount = lResultSetMetaData.getColumnCount();
            // sep
            System.out.print(String.format("+-"));
            for(int i = 0; i < lColCount; i++) {
                if(i != 0) System.out.print(String.format("-+-"));
                int lWidth = GManager.Instance().getWidth(widthMap, i, defaultWidth);
                for(int j = 0; j < lWidth; j++) {
                    System.out.print(String.format("-"));
                }
            }
            System.out.print(String.format("-+"));
            System.out.print(String.format("\n"));
            // header
            System.out.print(String.format("| "));
            for(int i = 1; i <= lColCount; i++) {
                if(i != 1) System.out.print(String.format(" | "));
                String lName = lResultSetMetaData.getColumnName(i);
                int lWidth = GManager.Instance().getWidth(widthMap, (i-1), defaultWidth);
                System.out.print(String.format("%" + (-lWidth) + "s", lName));
            }
            System.out.print(String.format(" |"));
            System.out.print(String.format("\n"));
            // sep
            System.out.print(String.format("+-"));
            for(int i = 0; i < lColCount; i++) {
                if(i != 0) System.out.print(String.format("-+-"));
                int lWidth = GManager.Instance().getWidth(widthMap, i, defaultWidth);
                for(int j = 0; j < lWidth; j++) {
                    System.out.print(String.format("-"));
                }
            }
            System.out.print(String.format("-+"));
            System.out.print(String.format("\n"));
            // data
            System.out.print(String.format("| "));
            while (lResultSet.next()) {
                for(int i = 1; i <= lColCount; i++) {
                    if(i != 1) System.out.print(String.format(" | "));
                    String lData = lResultSet.getString(i);
                    int lWidth = GManager.Instance().getWidth(widthMap, (i-1), defaultWidth);
                    System.out.print(String.format("%" + (-lWidth) + "s", lData));
                }
            }
            System.out.print(String.format(" |"));
            System.out.print(String.format("\n"));
            // sep
            System.out.print(String.format("+-"));
            for(int i = 0; i < lColCount; i++) {
                if(i != 0) System.out.print(String.format("-+-"));
                int lWidth = GManager.Instance().getWidth(widthMap, i, defaultWidth);
                for(int j = 0; j < lWidth; j++) {
                    System.out.print(String.format("-"));
                }
            }
            System.out.print(String.format("-+"));
            System.out.print(String.format("\n"));
            //
            lResultSet.close();
            lStatement.close();
            lConnection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //===============================================
    public void queryWrite(String sqlQuery) {
        try {
            Connection lConnection = open();
            Statement lStatement = lConnection.createStatement();
            lStatement.executeUpdate(sqlQuery);
            lStatement.close();
            lConnection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //===============================================
    public String queryValue(String sqlQuery) {
        String lData = "";

        try {
            Connection lConnection = open();
            Statement lStatement = lConnection.createStatement();
            ResultSet lResultSet = lStatement.executeQuery(sqlQuery);
            
            while (lResultSet.next()) {
                lData = lResultSet.getString(1);
                break;
            }
            
            lResultSet.close();
            lStatement.close();
            lConnection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lData;
    }
    //===============================================
    public List<String> queryCol(String sqlQuery) {
        List<String> lDataMap = new ArrayList<String>();
        
        try {
            Connection lConnection = open();
            Statement lStatement = lConnection.createStatement();
            ResultSet lResultSet = lStatement.executeQuery(sqlQuery);

            while (lResultSet.next()) {
                String lData = lResultSet.getString(1);
                lDataMap.add(lData);
            }
            
            lResultSet.close();
            lStatement.close();
            lConnection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lDataMap;
    }
    //===============================================
    public List<String> queryRow(String sqlQuery) {
        List<String> lDataMap = new ArrayList<String>();
        
        try {
            Connection lConnection = open();
            Statement lStatement = lConnection.createStatement();
            ResultSet lResultSet = lStatement.executeQuery(sqlQuery);
            ResultSetMetaData lResultSetMetaData = lResultSet.getMetaData();
            int lColCount = lResultSetMetaData.getColumnCount();

            while (lResultSet.next()) {
                for(int i = 1; i <= lColCount; i++) {
                    String lData = lResultSet.getString(i);
                    lDataMap.add(lData);
                }
                break;
            }
            
            lResultSet.close();
            lStatement.close();
            lConnection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lDataMap;
    }
    //===============================================
    public List<List<String>> queryMap(String sqlQuery) {
        List<List<String>> lDataMap = new ArrayList<List<String>>();;
        
        try {
            Connection lConnection = open();
            Statement lStatement = lConnection.createStatement();
            ResultSet lResultSet = lStatement.executeQuery(sqlQuery);
            ResultSetMetaData lResultSetMetaData = lResultSet.getMetaData();
            int lColCount = lResultSetMetaData.getColumnCount();

            while (lResultSet.next()) {
                List<String> lDataRow = new ArrayList<String>();
                for(int i = 1; i <= lColCount; i++) {
                    String lData = lResultSet.getString(i);
                    lDataRow.add(lData);
                }
                lDataMap.add(lDataRow);
            }
            
            lResultSet.close();
            lStatement.close();
            lConnection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lDataMap;
    }
    //===============================================
}
//===============================================