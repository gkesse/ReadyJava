//===============================================
public class GPerson {
    //===============================================
    private String m_name;
    private int m_age;
    private static int m_count = 0;
    //===============================================
    public GPerson() {
        m_name = "_NONE_";
        m_age = -1;
        m_count++;
    }
    //===============================================
    public GPerson(String name, int age) {
        m_name = name;
        m_age = age;
        m_count++;
    }
    //===============================================
    public void setName(String name) {
        m_name = name;
    }
    //===============================================
    public static int Count() {
        return m_count;
    }
    //===============================================
    public void setAge(int age) {
        m_age = age;
    }
    //===============================================
    public String getName() {
        return m_name;
    }
    //===============================================
    public int getAge() {
        return m_age;
    }
    //===============================================
    public void print(String name) {
        String m_data = "";
        if(name != "") m_data += name + " : ";
        m_data += "(" + m_name + " ; " + m_age + ")\n";
        System.out.print(m_data);
    }
    //===============================================
}
//===============================================
        