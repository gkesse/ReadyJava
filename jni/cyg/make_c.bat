@echo off
::===============================================
set "args=%*"             
setlocal enabledelayedexpansion
set "lArgs=%*"             
set "lArgs=!lArgs:*%1 =!"  
endlocal && ( set "args=%lArgs%" )
::===============================================
make -f Makefile.cyg.mak %1 argv="%args%"
::===============================================
