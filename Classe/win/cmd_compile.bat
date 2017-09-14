@echo off

set PATH=C:\Program Files (x86)\Java\jdk1.8.0_77\bin

set GSRC=../src
set GManager=../src/manager
set GBUILD=build

set GLIBS=

set GSCRS=^
    %GSRC%/GMain.java ^
    %GManager%/GPerson.java

javac -d %GBUILD% -sourcepath %GSCR% -cp %GLIBS% %GSCRS%
