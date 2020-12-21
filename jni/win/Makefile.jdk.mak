GSRC = ..\code\readyapp\src
GBIN = bin
GBUILD = build
GTARGET = $(GMAIN_JAR)

GMAIN_JAVA = $(GSRC)\com\pkg\readyapp\GMain.java
GMAIN_CLASS = com.pkg.readyapp.GMain
GMANIFEST = MANIFEST

all: clean compile jar run

compile:
	@if not exist $(GBUILD) @mkdir $(GBUILD)
	@javac $(GMAIN_JAVA) -d $(GBUILD) -sourcepath $(GSRC)
jar: 
	@if not exist $(GBIN) @mkdir $(GBIN)
	@jar cfm $(GTARGET) $(GMANIFEST) -C $(GBUILD) .
run: 
	@java $(GMAIN_CLASS) $(argv)
clean: 
	@if not exist $(GBIN) @mkdir $(GBIN)
	@if not exist $(GBUILD) @mkdir $(GBUILD)
	@del /s /q $(GTARGET)
clean_all: 
	@if not exist $(GBIN) @mkdir $(GBIN)
	@if not exist $(GBUILD) @mkdir $(GBUILD)
	@del /s /q $(GBUILD)\*.class $(GTARGET)
