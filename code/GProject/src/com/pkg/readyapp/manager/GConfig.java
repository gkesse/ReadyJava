//===============================================
package com.pkg.readyapp.manager;
//===============================================
import java.util.*;
//===============================================
public class GConfig {
    //===============================================
    private static GConfig m_intance = null;
    //===============================================
    private HashMap<String, String> m_dataMap;
    //===============================================
    private GConfig() {
        m_dataMap = new HashMap<String, String>();
    }
    //===============================================
    public static synchronized GConfig Instance() {           
        if(m_intance == null) {   
            m_intance = new GConfig(); 
        }
        return m_intance;
    }
    //===============================================
    public void setData(String key, String value) {
        m_dataMap.put(key, value);
    }
    //===============================================
    public String getData(String key) {
        return m_dataMap.getOrDefault(key, "");
    }
    //===============================================
    public void saveData(String key) {
        String lValue = getData(key);
        int lCount = countData(key);
        if(lCount == 0) insertData(key, getData(key));
        else updateData(key, getData(key));
    }
    //===============================================
    public void loadData(String key) {
        String lQuery = String.format(""+
        "select config_value from config_data\n"+
        "where config_key = '%s'\n"+
        "", key);
        String lValue = GSQLite.Instance().queryValue(lQuery);
        setData(key, lValue);
    }
    //===============================================
    public int countData(String key) {
        String lQuery = String.format(""+
        "select count(*) from config_data\n"+
        "where config_key = '%s'\n"+
        "", key);
        int lCount = Integer.parseInt(GSQLite.Instance().queryValue(lQuery));
        return lCount;
    }
    //===============================================
    public void insertData(String key, String valueId) {
        key = key.replace("'", "''");
        valueId = valueId.replace("'", "''");
        String lQuery = String.format(""+
        "insert into config_data (config_key, config_value)\n"+
        "values ('%s', '%s')\n"+
        "", key, valueId);
        GSQLite.Instance().queryWrite(lQuery);
    }
    //===============================================
    public void updateData(String key, String valueId) {
        key = key.replace("'", "''");
        valueId = valueId.replace("'", "''");
        String lQuery = String.format(""+
        "update config_data\n"+
        "set config_value = '%s'\n"+
        "where config_key = '%s'\n"+
        "", valueId, key);
        GSQLite.Instance().queryWrite(lQuery);
    }
    //===============================================
}
//===============================================