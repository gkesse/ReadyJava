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
    void showData(std::vector<std::string> data);
    // args
    void loadArgs(JNIEnv *env, jobjectArray arr);
    
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
    std::vector<std::string> args;
};
//===============================================
#endif
//===============================================
