//===============================================
#include "GManager.h"
//===============================================
GManager* GManager::m_instance = 0;
//===============================================
// constructor
//===============================================
GManager::GManager() {
    // manager
    mgr = new sGManager;
    // app
    mgr->app = new sGApp;
    mgr->app->app_name = "ReadyApp";
}
//===============================================
GManager::~GManager() {
    
}
//===============================================
GManager* GManager::Instance() {
    if(m_instance == 0) {
        m_instance = new GManager;
    }
    return m_instance;
}
//===============================================
// data
//===============================================
sGManager* GManager::getData() {
    return mgr;
}
//===============================================
// args
//===============================================
void GManager::loadArgs(JNIEnv *env, jobjectArray arr) {
    jsize lArgc = env->GetArrayLength(arr);
    for(int i = 0; i < lArgc; i++) {
        jstring lData = (jstring)env->GetObjectArrayElement(arr, i);
        std::string lArgv = env->GetStringUTFChars(lData, NULL);
        mgr->app->args.push_back(lArgv);
    }
    mgr->app->argc = (int)lArgc;
}
//===============================================
