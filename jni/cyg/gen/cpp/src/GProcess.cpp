//===============================================
#include "GProcess.h"
#include "GManager.h"
//===============================================
GProcess* GProcess::m_instance = 0;
//===============================================
GProcess::GProcess() {
    
}
//===============================================
GProcess::~GProcess() {
    
}
//===============================================
GProcess* GProcess::Instance() {
    if(m_instance == 0) {
        m_instance = new GProcess;
    }
    return m_instance;
}
//===============================================
void GProcess::run() {
    sGApp* lApp = GManager::Instance()->getData()->app;
    std::string lKey = "test";
    int lArgc = lApp->args.size();
    if(lArgc > 0) {lKey = lApp->args[0];}
    if(lKey == "test") {runTest(); return;}
    if(lKey == "ui") {runUi(); return;}
    if(lKey == "qt") {runQt(); return;}
    runTest();
}
//===============================================
void GProcess::runTest() {
    printf("runTest.......\n");
}
//===============================================
void GProcess::runUi() {
    printf("runUi.......\n");
}
//===============================================
void GProcess::runQt() {
    printf("runQt.......\n");
}
//===============================================
