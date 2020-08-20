GSRC = ..\code\GProject\src
GBIN = bin
GBUILD = build
GTARGET = $(GBIN)\gp_java.exe

GMAIN = $(GSRC)\GMain.java
GMANAGER = $(GSRC)\manager
    
all: javac java

javac:
	@if not exist "$(GBUILD)" @mkdir $(GBUILD)
	javac $(GMAIN) -d $(GBUILD) -sourcepath $(GMANAGER)
	@echo.
java:
	@java GMain
run: 
	@$(GTARGET)
