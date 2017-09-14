//===============================================
public class GMain {
    //===============================================
    public static void main(String[] args) {
        System.out.print("--------------------------------------------------\n");
        
        GPerson m_pers1 = new GPerson("Gerard KESSE", 30);
        m_pers1.print("m_pers1");
        System.out.print("Static : Count : " + GPerson.Count() + "\n");
        
        System.out.print("--------------------------------------------------\n");
        
        GPerson m_pers2 = new GPerson("Deborah YOBOUE", 20);
        m_pers2.print("m_pers2");
        System.out.print("Static : Count : " + GPerson.Count() + "\n");
        
        System.out.print("--------------------------------------------------\n");
        
        GPerson m_pers3 = new GPerson("Bryan KESSE", 10);
        m_pers3.print("m_pers3");
        System.out.print("Static : Count : " + GPerson.Count() + "\n");
        
        System.out.print("--------------------------------------------------\n");
    }
    //===============================================
}
//===============================================
