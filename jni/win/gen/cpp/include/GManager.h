//===============================================
#ifndef _GManager_
#define _GManager_
//===============================================
#include "GInclude.h"
//===============================================
typedef struct _sGManager sGManager;
typedef struct _sGApp sGApp;
//===============================================
class GManager {
protected:
    GManager();
    
public:
    virtual ~GManager();
    static GManager* Instance();
    // data
    sGManager* getData();
    // args
    void loadArgs(JNIEnv *env, jobject obj, jobjectArray arr);
    
private:
    static GManager* m_instance;
    sGManager* mgr;
};
//===============================================
struct _sGManager {
    sGApp* app;
};
//===============================================
struct _sGApp {
    // app
    std::string app_name;
    // args
    int argc;
    std::vector args;
};
//===============================================
#endif
//===============================================
