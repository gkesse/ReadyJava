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
            else if(G_STATE.equals("S_CONFIG_JAVA_SHOW_DATA")) {run_CONFIG_JAVA_SHOW_DATA(args);}
            else if(G_STATE.equals("S_CONFIG_JAVA_SHOW_SCHEMA")) {run_CONFIG_JAVA_SHOW_SCHEMA(args);}
            else if(G_STATE.equals("S_CONFIG_JAVA_DELETE")) {run_CONFIG_JAVA_DELETE(args);}            //
            //
            else if(G_STATE.equals("S_CONFIG_JAVA_DELETE_DATA_CONFIG_KEY")) {run_CONFIG_JAVA_DELETE_DATA_CONFIG_KEY(args);}            //
            else if(G_STATE.equals("S_CONFIG_JAVA_DELETE_DATA")) {run_CONFIG_JAVA_DELETE_DATA(args);}            //
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
        System.out.print(String.format("\t%-2s : %s\n", "2", "afficher les donnees CONFIG_JAVA"));
        System.out.print(String.format("\t%-2s : %s\n", "3", "afficher le schema CONFIG_JAVA"));
        System.out.print(String.format("\t%-2s : %s\n", "4", "supprimer la table CONFIG_JAVA"));        
        System.out.print(String.format("\t%-2s : %s\n", "5", "supprimer une donnee CONFIG_JAVA"));        
        System.out.print(String.format("\n"));
        G_STATE = "S_CHOICE";
    }
    //===============================================
    public void run_CHOICE(String[] args) {
        String lLast = GConfig.Instance().getData("G_SQLITE_ID");
        String lAnswer = System.console().readLine(String.format("SQLITE_ADMIN (%s) ? : ", lLast));
        if(lAnswer.equals("")) lAnswer = lLast;
        if(lAnswer.equals("-q")) G_STATE = "S_END";
        else if(lAnswer.equals("-i")) G_STATE = "S_INIT";
        else if(lAnswer.equals("-a")) G_STATE = "S_ADMIN";
        //
        else if(lAnswer.equals("1")) {G_STATE = "S_SHOW_TABLES"; GConfig.Instance().setData("G_SQLITE_ID", lAnswer);} 
        else if(lAnswer.equals("2")) {G_STATE = "S_CONFIG_JAVA_SHOW_DATA"; GConfig.Instance().setData("G_SQLITE_ID", lAnswer);} 
        else if(lAnswer.equals("3")) {G_STATE = "S_CONFIG_JAVA_SHOW_SCHEMA"; GConfig.Instance().setData("G_SQLITE_ID", lAnswer);} 
        else if(lAnswer.equals("4")) {G_STATE = "S_CONFIG_JAVA_DELETE"; GConfig.Instance().setData("G_SQLITE_ID", lAnswer);} 
        else if(lAnswer.equals("5")) {G_STATE = "S_CONFIG_JAVA_DELETE_DATA_CONFIG_KEY"; GConfig.Instance().setData("G_SQLITE_ID", lAnswer);} 
        //
    }
    //===============================================
    public void run_SHOW_TABLES(String[] args) {
        System.out.print(String.format("\n"));
        String lQuery = String.format(""+
        "select name from sqlite_master\n"+
        "where type = 'table'\n"+
        "");
        GSQLite.Instance().queryShow(lQuery, "30", 20);
        G_STATE = "S_SAVE";
    }
    //===============================================
    public void run_CONFIG_JAVA_SHOW_DATA(String[] args) {
        System.out.print(String.format("\n"));
        String lQuery = String.format(""+
        "select * from config_data\n"+
        "");
        GSQLite.Instance().queryShow(lQuery, "30;50", 20);
        G_STATE = "S_SAVE";
    }
    //===============================================
    public void run_CONFIG_JAVA_SHOW_SCHEMA(String[] args) {
        System.out.print(String.format("\n"));
        String lQuery = String.format(""+
        "select sql from sqlite_master\n"+
        "where type = 'table'\n"+
        "and name = 'config_data'\n"+
        "");
        String lValue = GSQLite.Instance().queryValue(lQuery);
        GManager.Instance().showData(lValue);
        G_STATE = "S_SAVE";
    }
    //===============================================
    public void run_CONFIG_JAVA_DELETE(String[] args) {
        System.out.print(String.format("\n"));
        String lQuery = String.format(""+
        "drop table if exists config_data\n"+
        "");
        GSQLite.Instance().queryWrite(lQuery);
        G_STATE = "S_SAVE";
    }
    //===============================================
    public void run_CONFIG_JAVA_DELETE_DATA_CONFIG_KEY(String[] args) {
        String lLast = GConfig.Instance().getData("G_CONFIG_KEY");
        String lAnswer = System.console().readLine(String.format("G_CONFIG_KEY (%s) ? : ", lLast));
        if(lAnswer.equals("")) lAnswer = lLast;
        if(lAnswer.equals("-q")) G_STATE = "S_END";
        else if(lAnswer.equals("-i")) G_STATE = "S_INIT";
        else if(lAnswer.equals("-a")) G_STATE = "S_ADMIN";
        else if(lAnswer.equals("-v")) {G_STATE = "S_CONFIG_JAVA_DELETE_DATA";} 
        else if(!lAnswer.equals("")) {G_STATE = "S_CONFIG_JAVA_DELETE_DATA"; GConfig.Instance().setData("G_CONFIG_KEY", lAnswer);} 
    }
    //===============================================
    public void run_CONFIG_JAVA_DELETE_DATA(String[] args) {
        String lKey = GConfig.Instance().getData("G_CONFIG_KEY");
        String lQuery = String.format(""+
        "delete from config_data\n"+
        "where config_key = '%s'\n"+
        "", lKey);
        GSQLite.Instance().queryWrite(lQuery);
        run_CONFIG_JAVA_SHOW_DATA(args);
        G_STATE = "S_SAVE";
    }
    //===============================================
    public void run_SAVE(String[] args) {
        GConfig.Instance().saveData("G_SQLITE_ID");
        GConfig.Instance().saveData("G_CONFIG_KEY");
        G_STATE = "S_QUIT";
    }
    //===============================================
    public void run_LOAD(String[] args) {
        GConfig.Instance().loadData("G_SQLITE_ID");
        GConfig.Instance().loadData("G_CONFIG_KEY");
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