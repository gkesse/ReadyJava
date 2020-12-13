GSRC = $(GJDK_PROJECT_SRC)
GBIN = bin
GBUILD = build
GTARGET = $(GBIN)\gp_java.exe

GMAIN = $(GSRC)\GMain.java

GSRCPATH = \
    $(GSRC)\manager \
    
all: clean compile java

compile:
	@if not exist $(GBUILD) @mkdir $(GBUILD)
	@javac $(GMAIN) -d $(GBUILD) -sourcepath $(GSRCPATH)
java:
	@java -cp $(GBUILD) GMain $(argv)
run: 
	@$(GTARGET)
clean: 
	@if not exist $(GBUILD) @mkdir $(GBUILD)
	@del /q $(GBUILD)\*.class
