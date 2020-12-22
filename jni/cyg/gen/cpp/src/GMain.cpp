//===============================================
#include "com_pkg_readyapp_GMain.h" 
//===============================================
#include <jni.h>
#include <iostream>
//===============================================
JNIEXPORT void JNICALL 
Java_com_pkg_readyapp_GMain_run(JNIEnv *env, jobject obj, jobjectArray arr) {
    //GManager::Instance()->loadArgs(env, arr);
    printf("Bonjour tout le monde\n");
}
//===============================================
