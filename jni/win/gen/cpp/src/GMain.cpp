//===============================================
#include <jni.h> 
#include <stdio.h> 
#include "com_pkg_readyapp_GMain.h" 
//===============================================
JNIEXPORT void JNICALL 
Java_com_pkg_readyapp_GMain_run(JNIEnv *env, jobject obj) { 
    printf(" Bonjour\n"); 
}
//===============================================
