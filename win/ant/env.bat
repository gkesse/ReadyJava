@echo off
::===============================================
set "PATH=C:\MinGW\bin;%PATH%" 
set "PATH=C:\Users\Admin\Downloads\apache-maven-3.6.3-bin\apache-maven-3.6.3\bin;%PATH%"
set "PATH=C:\Users\Admin\Downloads\Compressed\jakarta-ant-1.4.1-bin\jakarta-ant-1.4.1\bin;%PATH%"
::===============================================
set "JAVA_HOME=C:\Program Files\Java\jdk-11.0.1"
::===============================================
set "GPROJECT_ROOT=C:\Users\Admin\Downloads\Programs"
set "GPROJECT_PATH=%GPROJECT_ROOT%\ReadyJava"
set "GPROJECT_SRC=%GPROJECT_PATH%\code"
::===============================================
set "GMVN_ARTIFACT=src"
set "GMVN_PATH=%GPROJECT_SRC%\%GMVN_ARTIFACT%"
::===============================================
set "GANT_BUILD_FILE=build.ant.xml"
::===============================================
