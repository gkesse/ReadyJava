GSRC = ..\..\code\GProject\src
GBIN = bin
GBUILD = build
GTARGET = $(GBIN)\gp_java.jar

GMAINJAVA = $(GSRC)\com\pkg\readyapp\GMain.java
GMAINCLASS = com.pkg.readyapp.GMain
GMANIFEST = MANIFEST

GSRCPATH =\
    $(GSRC) \
    
all: clean compile java

compile:
	@if not exist $(GBUILD) @mkdir $(GBUILD)
	@javac $(GMAINJAVA) -d $(GBUILD) -sourcepath $(GSRCPATH)
java:
	@java -cp $(GBUILD) $(GMAINCLASS) $(argv)
jar: 
	@if not exist $(GBIN) @mkdir $(GBIN)
	@jar cfm $(GTARGET) $(GMANIFEST) -C $(GBUILD)
run: 
	@$(GTARGET) $(argv)
clean: 
	@if not exist $(GBIN) @mkdir $(GBIN)
	@if not exist $(GBUILD) @mkdir $(GBUILD)
	@del /s /q $(GBUILD)\*.class $(GBIN)\*.jar