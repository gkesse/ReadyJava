//===============================================
package com.pkg.readyapp;
//===============================================
public class GMain {
    //===============================================
    static {
        System.loadLibrary("rdcpp");
    }
    //===============================================
    private native void run(String[] args);
    //===============================================
    public static void main(String[] args){
        new GMain().run(args);
    }
    //===============================================
}
//===============================================