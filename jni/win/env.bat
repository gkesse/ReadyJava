@echo off
::===============================================
set "PATH=C:\MinGW\bin;%PATH%"
set "PATH=C:\Program Files\Java\jdk-11.0.1\bin;%PATH%"
::===============================================
set "GPROJECT_ROOT=C:\Users\Admin\Downloads\Programs"
set "GPROJECT_PATH=%GPROJECT_ROOT%\ReadyJava"
::===============================================
set "GMAIN_JAR=%GPROJECT_PATH%\jni\win\bin\rdjava.jar"
::===============================================
set "CLASSPATH=%GMAIN_JAR%"
::===============================================
set "GDATA_PATH=%GPROJECT_PATH%\data"
set "GSQLITE_DB_PATH=%GDATA_PATH%\sqlite\config.dat"
set "GSTYLE_PATH=%GDATA_PATH%\css\style.css"
set "GFONT_PATH=%GDATA_PATH%\font"
set "GIMG_PATH=%GDATA_PATH%\img"
set "GPDF_PATH=%GDATA_PATH%\pdf\config.pdf"
set "GCMD_PATH=%GDATA_PATH%\cmd\script.bat"
::===============================================
set "GGIT_URL=https://github.com/gkesse/ReadyJava.git"
set "GGIT_NAME=ReadyJava"
::===============================================
