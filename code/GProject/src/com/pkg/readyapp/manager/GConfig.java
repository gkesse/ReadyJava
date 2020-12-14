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
}
//===============================================