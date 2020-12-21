//===============================================
package com.pkg.readyapp;
//===============================================
//import com.pkg.readyapp.manager.*;
//===============================================
public class GMain {
    //===============================================
    static {
        System.loadLibrary("hello");
    }
    //===============================================
    private native void sayHello();
    //===============================================
    public static void main(String[] args){
        System.out.print(String.format("%s\n", "Bonjour tout le monde"));
    }
}
//===============================================