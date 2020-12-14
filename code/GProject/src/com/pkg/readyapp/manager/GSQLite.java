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
        Connection lConnect = null;
        try {
            lConnect = DriverManager.getConnection(lDbPath);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return lConnect;
    }
    //===============================================
    public void queryShow(String sqlQuery) {
        try {
            Connection lConnect = open();
            
            lConnect.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //===============================================
}
//===============================================