//===============================================
#include "com_pkg_readyapp_GMain.h" 
//===============================================
#include "GInclude.h"
#include "GManager.h"
//===============================================
JNIEXPORT void JNICALL 
Java_com_pkg_readyapp_GMain_run(JNIEnv *env, jobject obj, jobjectArray arr) {
    std::string lKey = "test";
    jsize lLength = env->GetArrayLength(arr);
    if(lLength > 0) {
        jstring lString = (jstring)env->GetObjectArrayElement(arr, 0);
        lKey = env->GetStringUTFChars(lString, NULL);
    }
    const char *inCStr = env->GetStringUTFChars(lString, NULL);
    printf("Bonjour tout le monde %d : %s\n", (int)lLength, inCStr);
}
//===============================================
