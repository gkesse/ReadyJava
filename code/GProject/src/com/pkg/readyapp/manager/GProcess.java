//===============================================
package com.pkg.readyapp.manager;
//===============================================
public class GProcess {
    //===============================================
    private static GProcess m_intance = null;
    //===============================================
    private String G_STATE;
    //===============================================
    private GProcess() {

    }
    //===============================================
    public static synchronized GProcess Instance() {           
        if(m_intance == null) {   
            m_intance = new GProcess(); 
        }
        return m_intance;
    }
    //===============================================
    public void run(String[] args) {
        String lKey = "test";
        if(args.length > 0) lKey = args[0];
        if(lKey == "test") {runTest(args); return;}
        if(lKey == "ui") {runUi(args); return;}
    }        
    //===============================================
    public void runTest(String[] args) {
        System.out.print("runTest\n");
    }        
    //===============================================
    public void runUi(String[] args) {
        System.out.print("runUi\n");
    }        
    //===============================================
}
//===============================================