@echo off

set PATH=C:\Program Files (x86)\Java\jdk1.8.0_77\bin

set GSRC=../src
set GBUILD=build

set GLIBS=

set GSCRS=^
    %GSRC%/GMain.java

javac -d %GBUILD% -sourcepath %GSCR% -cp %GLIBS% %GSCRS%
