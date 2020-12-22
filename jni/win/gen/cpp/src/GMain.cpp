//===============================================
#include "com_pkg_readyapp_GMain.h" 
//===============================================
#include <jni.h> 
#include <stdio.h> 
//===============================================
JNIEXPORT void JNICALL 
Java_com_pkg_readyapp_GMain_run(JNIEnv *env, jobject obj) { 
    printf("Bonjour tout le monde\n");
    return;
}
//===============================================
