@echo off

set PATH=C:\Program Files (x86)\Java\jdk1.8.0_77\bin

set GBUILD=build
set GBIN=bin
set GTARGET=%GBIN%/GProject.jar
set GLIBS=

jar cfm %GTARGET% GManifest -C %GBUILD% %GLIBS% .
