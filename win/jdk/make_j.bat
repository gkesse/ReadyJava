@echo off
::===============================================
set "args="             
setlocal enabledelayedexpansion
set "lArgs=%*"             
set "lArgs=!lArgs:*%1 =!"  
endlocal && ( set "args=%lArgs%" )
echo %args%
::===============================================
mingw32-make -f Makefile.jdk.mak %1 "argv=%args%"
::===============================================
