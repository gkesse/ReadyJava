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
    
private:
    static GProcess* m_instance;
};
//===============================================
#endif
//===============================================
