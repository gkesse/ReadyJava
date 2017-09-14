//===============================================
public class GMain {
    //===============================================
    public static void main(String[] args) {
        overload();
        overload("Deborah");
    }
    //===============================================
    public static void overload() {
        String m_data = "Overload1 : Hello Gerard !\n";
        System.out.print(m_data);
    }
    //===============================================
    public static void overload(String data) {
        String m_data = "Overload2 : Hello " + data + " !\n";
        System.out.print(m_data);
    }
    //===============================================
}
//===============================================
