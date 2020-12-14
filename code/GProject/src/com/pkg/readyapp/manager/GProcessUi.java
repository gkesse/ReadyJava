//===============================================
package com.pkg.readyapp.manager;
//===============================================
public class GProcessUi {
    //===============================================
    private static GProcessUi m_intance = null;
    //===============================================
    private String G_STATE;
    //===============================================
    private GProcessUi() {

    }
    //===============================================
    public static synchronized GProcessUi Instance() {           
        if(m_intance == null) {   
            m_intance = new GProcessUi(); 
        }
        return m_intance;
    }
    //===============================================
    public void run(String[] args) {
        G_STATE = "S_INIT";
        while(true) {
            if(G_STATE == "S_INIT") {run_INIT(args);}
            else if(G_STATE == "S_METHOD") {run_METHOD(args);}
            else if(G_STATE == "S_CHOICE") {run_CHOICE(args);}
            //
            else if(G_STATE == "S_SQLITE") {run_SQLITE(args);}
            //
            else if(G_STATE == "S_SAVE") {run_SAVE(args);}
            else if(G_STATE == "S_LOAD") {run_LOAD(args);}
            else break;
        }
    }        
    //===============================================
    public void run_INIT(String[] args) {
        System.out.print(String.format("\n"));
        System.out.print(String.format("JAVA_ADMIN !!!\n"));
        System.out.print(String.format("\t%-2s : %s\n", "q", "quitter l'application"));
        System.out.print(String.format("\n"));
        G_STATE = "S_LOAD";
    }
    //===============================================
    public void run_METHOD(String[] args) {
        System.out.print(String.format("JAVA_ADMIN :\n"));
        System.out.print(String.format("\t%-2s : %s\n", "1", "S_SQLITE"));
        System.out.print(String.format("\n"));
        G_STATE = "S_CHOICE";
    }
    //===============================================
    public void run_CHOICE(String[] args) {
        String lLast = GConfig.Instance().getData("JAVA_ADMIN_ID");
        String lAnswer = System.console().readLine(String.format("JAVA_ADMIN (%s) ? : ", lLast));
        if(lAnswer.equals("")) lAnswer = lLast;
        if(lAnswer.equals("-q")) G_STATE = "S_END";
        //
        else if(lAnswer.equals("1")) {G_STATE = "S_SQLITE"; GConfig.Instance().setData("JAVA_ADMIN_ID", lAnswer);} 
        //
    }
    //===============================================
    public void run_SQLITE(String[] args) {
        GSQLiteUi.Instance().run(args);
        G_STATE = "S_SAVE";
    }
    //===============================================
    public void run_SAVE(String[] args) {
        System.out.print(String.format("run_SAVE.................\n"));
        GConfig.Instance().saveData("JAVA_ADMIN_ID");
        G_STATE = "S_END";
    }
    //===============================================
    public void run_LOAD(String[] args) {
        GConfig.Instance().loadData("JAVA_ADMIN_ID");
        G_STATE = "S_METHOD";
    }
    //===============================================
}
//===============================================