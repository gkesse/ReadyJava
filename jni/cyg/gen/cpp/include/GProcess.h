//===============================================
#ifndef _GProcess_
#define _GProcess_
//===============================================
#include "GInclude.h"
//===============================================
class GProcess {
private:
    GProcess();
    
public:
    ~GProcess();
    static GProcess* Instance();
    void run();
    void runTest();
    void runUi();
    void runQt();
    
private:
    static GProcess* m_instance;
};
//===============================================
#endif
//===============================================
