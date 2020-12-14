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
            if(G_STATE.equals("S_ADMIN")) {run_ADMIN(args);}
            else if(G_STATE.equals("S_INIT")) {run_INIT(args);}
            else if(G_STATE.equals("S_METHOD")) {run_METHOD(args);}
            else if(G_STATE.equals("S_CHOICE")) {run_CHOICE(args);}
            //
            else if(G_STATE.equals("S_SHOW_TABLES")) {run_SHOW_TABLES(args);}
            //
            else if(G_STATE.equals("S_SAVE")) {run_SAVE(args);}
            else if(G_STATE.equals("S_LOAD")) {run_LOAD(args);}
            else if(G_STATE.equals("S_QUIT")) {run_QUIT(args);}
            else break;
        }
    }        
    //===============================================
    public void run_ADMIN(String[] args) {
        GProcessUi.Instance().run(args);
        G_STATE = "S_END";
    }
    //===============================================
    public void run_INIT(String[] args) {
        System.out.print(String.format("\n"));
        System.out.print(String.format("SQLITE_ADMIN !!!\n"));
        System.out.print(String.format("\t%-2s : %s\n", "-q", "quitter l'application"));
        System.out.print(String.format("\t%-2s : %s\n", "-i", "reinitialiser l'application"));
        System.out.print(String.format("\t%-2s : %s\n", "-a", "redemarrer l'application"));
        System.out.print(String.format("\t%-2s : %s\n", "-v", "valider les configurations"));        
        System.out.print(String.format("\n"));
        G_STATE = "S_LOAD";
    }
    //===============================================
    public void run_METHOD(String[] args) {
        System.out.print(String.format("SQLITE_ADMIN :\n"));
        System.out.print(String.format("\t%-2s : %s\n", "1", "afficher les tables"));
        System.out.print(String.format("\n"));
        G_STATE = "S_CHOICE";
    }
    //===============================================
    public void run_CHOICE(String[] args) {
        String lLast = GConfig.Instance().getData("SQLITE_ADMIN_ID");
        String lAnswer = System.console().readLine(String.format("SQLITE_ADMIN (%s) ? : ", lLast));
        if(lAnswer.equals("")) lAnswer = lLast;
        if(lAnswer.equals("-q")) G_STATE = "S_END";
        //
        else if(lAnswer.equals("1")) {G_STATE = "S_SHOW_TABLES"; GConfig.Instance().setData("SQLITE_ADMIN_ID", lAnswer);} 
        //
    }
    //===============================================
    public void run_SHOW_TABLES(String[] args) {
        System.out.print("run_SHOW_TABLES\n");
        G_STATE = "S_SAVE";
    }
    //===============================================
    public void run_SAVE(String[] args) {
        G_STATE = "S_QUIT";
    }
    //===============================================
    public void run_LOAD(String[] args) {
        G_STATE = "S_METHOD";
    }
    //===============================================
    public void run_QUIT(String[] args) {
        System.out.print(String.format("\n"));
        String lAnswer = System.console().readLine(String.format("JAVA_QUIT (Oui/[N]on) ? : "));
        if(lAnswer.equals("-q")) {G_STATE = "S_END";}
        else if(lAnswer.equals("-i")) {G_STATE = "S_INIT";}
        else if(lAnswer.equals("-a")) {G_STATE = "S_ADMIN";}
        else if(lAnswer.equals("o")) {G_STATE = "S_END";} 
        else if(lAnswer.equals("n")) {G_STATE = "S_INIT";} 
        else if(lAnswer.equals("")) {G_STATE = "S_INIT";}     
    }
    //===============================================
}
//===============================================