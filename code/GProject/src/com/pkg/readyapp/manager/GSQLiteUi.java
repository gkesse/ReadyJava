//===============================================
package com.pkg.readyapp.manager;
//===============================================
public class GSQLiteUi {
    //===============================================
    private static GSQLiteUi m_intance = null;
    //===============================================
    private String G_STATE;
    //===============================================
    private GSQLiteUi() {

    }
    //===============================================
    public static synchronized GSQLiteUi Instance() {           
        if(m_intance == null) {   
            m_intance = new GSQLiteUi(); 
        }
        return m_intance;
    }
    //===============================================
    public void run(String[] args) {
        G_STATE = "S_INIT";
        while(true) {
            if(G_STATE == "S_ADMIN") {run_ADMIN(args);}
            else if(G_STATE == "S_INIT") {run_INIT(args);}
            else if(G_STATE == "S_METHOD") {run_METHOD(args);}
            else if(G_STATE == "S_CHOICE") {run_CHOICE(args);}
            else if(G_STATE == "S_SQLITE") {run_SQLITE(args);}
            else if(G_STATE == "S_SAVE") {run_SAVE(args);}
            else if(G_STATE == "S_LOAD") {run_LOAD(args);}
            else if(G_STATE == "S_QUIT") {run_QUIT(args);}
            else break;
        }
    }        
    //===============================================
    public void run_ADMIN(String[] args) {
        G_STATE = "S_END";
    }
    //===============================================
    public void run_INIT(String[] args) {
        System.out.print("run_INIT\n");
        G_STATE = "S_LOAD";
    }
    //===============================================
    public void run_METHOD(String[] args) {
        System.out.print("run_METHOD\n");
        G_STATE = "S_CHOICE";
    }
    //===============================================
    public void run_CHOICE(String[] args) {
        System.out.print("run_CHOICE\n");
        G_STATE = "S_SQLITE";
    }
    //===============================================
    public void run_SQLITE(String[] args) {
        System.out.print("run_SQLITE\n");
        G_STATE = "S_SAVE";
    }
    //===============================================
    public void run_SAVE(String[] args) {
        System.out.print("run_SAVE\n");
        G_STATE = "S_QUIT";
    }
    //===============================================
    public void run_LOAD(String[] args) {
        System.out.print("run_LOAD\n");
        G_STATE = "S_METHOD";
    }
    //===============================================
    public void run_QUIT(String[] args) {
        System.out.print("run_QUIT\n");
        G_STATE = "S_END";
    }
    //===============================================
}
//===============================================