//===============================================
public class GPerson {
    //===============================================
    private String m_name;
    private int m_age;
    //===============================================
    public GPerson() {
        m_name = "_NONE_";
        m_age = -1;
    }
    //===============================================
    public GPerson(String name, int age) {
        m_name = name;
        m_age = age;
    }
    //===============================================
    public void setName(String name) {
        m_name = name;
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
        