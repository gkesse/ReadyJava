@echo off
::===============================================
set "args=%*"             
setlocal enabledelayedexpansion
set "lArgs=%*"             
set "lArgs=!lArgs:*%1 =!"  
endlocal && ( set "args=%lArgs%" )
::===============================================
make -f Makefile.git.mak %1 argv="%args%"
::===============================================
