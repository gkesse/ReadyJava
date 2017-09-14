//===============================================
public class GMain {
    //===============================================
    public static void main(String[] args) {
        method1();
        method2("Hello World !");
        System.out.print(method3());
        System.out.print(method4("Hello World !"));
    }
    //===============================================
    public static void method1() {
        String m_data = "Method1 : Hello World !\n";
        System.out.print(m_data);
    }
    //===============================================
    public static void method2(String data) {
        String m_data = "Method2 : " + data + "\n";
        System.out.print(m_data);
    }
    //===============================================
    public static String method3() {
        String m_data = "Method3 : Hello World !\n";
        return m_data;
    }
    //===============================================
    public static String method4(String data) {
        String m_data = "Method4 : " + data + "\n";
        return m_data;
    }
    //===============================================
}
//===============================================
