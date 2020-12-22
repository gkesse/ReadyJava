//===============================================
#include "com_pkg_readyapp_GMain.h" 
//===============================================
#include "GManager.h"
#include "GProcess.h"
//===============================================
JNIEXPORT void JNICALL 
Java_com_pkg_readyapp_GMain_run(JNIEnv *env, jobject obj, jobjectArray arr) {
    sGApp* lApp = GManager::Instance()->getData()->app;
    GManager::Instance()->loadArgs(env, arr);
    GProcess::Instance()->run();
}
//===============================================
