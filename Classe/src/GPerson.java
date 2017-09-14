//===============================================
public class GPerson {
    //===============================================
    private String m_name;
    private int m_age;
    //===============================================
    public GPerson() {
        m_name = "_NONE_";
        m_age = 0;
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
}
//===============================================
        