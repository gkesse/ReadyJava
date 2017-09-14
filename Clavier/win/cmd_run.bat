@echo off

set PATH=C:\Program Files (x86)\Java\jdk1.8.0_77\bin

set GBUILD=build

set GLIBS=

echo.
java -cp %GBUILD%;%GLIBS% GMain
echo.
