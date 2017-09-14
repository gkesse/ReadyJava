//===============================================
public class GMain {
    //===============================================
    public static void main(String[] args) {
        class1();
    }
    //===============================================
    public static void class1() {
        System.out.print("--------------------------------------------------\n");
        GPerson m_pers1 = new GPerson();
        GPerson m_pers2 = new GPerson("Gerard", 20);
        m_pers1.print("m_pers1");
        m_pers2.print("m_pers2");
        System.out.print("--------------------------------------------------\n");
        m_pers1.setName("Deborah YOBOUE");
        m_pers2.setName("Gerard KESSE");        
        m_pers1.print("m_pers1");
        m_pers2.print("m_pers2");        
        System.out.print("--------------------------------------------------\n");
        m_pers1.setAge(15);
        m_pers2.setAge(25);        
        m_pers1.print("m_pers1");
        m_pers2.print("m_pers2");        
        System.out.print("--------------------------------------------------\n");
    }
    //===============================================
}
//===============================================
