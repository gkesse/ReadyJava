@echo off
::===============================================
set "PATH=C:/cygwin64/bin;%PATH%"
set "PATH=C:/cygwin64/usr/local/bin;%PATH%"
set "PATH=C:/cygwin64/usr/x86_64-w64-mingw32/sys-root/mingw/bin;%PATH%"
set "PATH=C:/Program Files/Java/jdk-11.0.1/bin;%PATH%"
set "PATH=C:/Users/Admin/Downloads/Programs/ReadyJava/jni/cyg/gen/lib;%PATH%"
::===============================================
set "GPROJECT_ROOT=C:/Users/Admin/Downloads/Programs"
set "GPROJECT_PATH=%GPROJECT_ROOT%/ReadyJava"
::===============================================
set "GMAIN_JAR=%GPROJECT_PATH%/jni/cyg/bin/rdjava.jar"
::===============================================
set "CLASSPATH=%GMAIN_JAR%"
::===============================================
set "GDATA_PATH=%GPROJECT_PATH%/data"
set "GSQLITE_DB_PATH=%GDATA_PATH%/sqlite/config.dat"
set "GSTYLE_PATH=%GDATA_PATH%/css/style.css"
set "GFONT_PATH=%GDATA_PATH%/font"
set "GIMG_PATH=%GDATA_PATH%/img"
set "GPDF_PATH=%GDATA_PATH%/pdf/config.pdf"
set "GCMD_PATH=%GDATA_PATH%/cmd/script.bat"
::===============================================
set "GGIT_URL=https://github.com/gkesse/ReadyJava.git"
set "GGIT_NAME=ReadyJava"
::===============================================
set "GCYG_PAT_GET=https://raw.githubusercontent.com/transcode-open/apt-cyg/master/apt-cyg"
set "GCYG_PACKAGE=mingw64-x86-gcc-g++"
::===============================================
