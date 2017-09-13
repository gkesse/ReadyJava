//===============================================
public class GMain {
    public static void main(String[] args) {
        byte m_byte = 1;
        short m_short = 2;
        int m_int = 4;
        long m_long = 8;
        float m_float = 4;
        double m_double = 8;
        char m_char = '1';
        boolean m_boolean = true;
        String m_string = ""; 
        
        m_string += "m_byte : " + String.valueOf(m_byte) + " octet(s)\n";
        m_string += "m_short : " + String.valueOf(m_short) + " octet(s)\n";
        m_string += "m_int : " + String.valueOf(m_int) + " octet(s)\n";
        m_string += "m_long : " + String.valueOf(m_long) + " octet(s)\n";
        m_string += "m_float : " + String.valueOf(m_float) + " octet(s)\n";
        m_string += "m_double : " + String.valueOf(m_double) + " octet(s)\n";
        m_string += "m_char : " + String.valueOf(m_char) + " octet(s)\n";
        m_string += "m_boolean : " + String.valueOf(m_boolean) + " octet(s)\n";
        
        System.out.print(m_string + "\n");
    }
}
//===============================================
