GSRC = ..\code\readyapp\src
GBIN = bin
GBUILD = build
GGEN = gen
GGEN_CLASS = $(GGEN)\class
GGEN_CPP_SRC = $(GGEN)\cpp\src
GGEN_CPP_INC = $(GGEN)\cpp\include
GGEN_LIB_PATH = $(GGEN)\lib
GGEN_LIB_NAME = $(GGEN_LIB_PATH)\rdcpp.dll
GGEN_BUILD = $(GGEN)\build
GGEN_DEF = $(GGEN)\gen.def
GTARGET = $(GMAIN_JAR)

GMAIN_JAVA = $(GSRC)\com\pkg\readyapp\GMain.java
GMAIN_CLASS = com.pkg.readyapp.GMain
GMANIFEST = MANIFEST

GINCS =\
    -I$(GGEN_CPP_INC) \
    -I"C:\Program Files\Java\jdk-11.0.1\include" \
    -I"C:\Program Files\Java\jdk-11.0.1\include\win32" \

GOBJS_GEN =\
    $(patsubst $(GGEN_CPP_SRC)/%.cpp, $(GGEN_BUILD)/%.o, $(wildcard $(GGEN_CPP_SRC)/*.cpp)) \

GCFLAGS =\
    -std=gnu++11 \
    
all: clean_all cpp_gen compile jar run

cpp_gen:
	@javac -h $(GGEN_CPP_INC) -d $(GGEN_CLASS) $(GMAIN_JAVA)
cpp_compile: $(GOBJS_GEN)
	@if not exist $(GGEN_LIB_PATH) ( mkdir $(GGEN_LIB_PATH) )
	@g++ -shared -o $(GGEN_LIB_NAME) $(GOBJS_GEN) $(GGEN_DEF)
$(GGEN_BUILD)/%.o: $(GGEN_CPP_SRC)/%.cpp
	@if not exist $(GGEN_BUILD) ( mkdir $(GGEN_BUILD) )
	g++ $(GCFLAGS) -c $< -o $@ $(GINCS)
compile:
	@if not exist $(GBUILD) ( mkdir $(GBUILD) )
	@javac $(GMAIN_JAVA) -d $(GBUILD) -sourcepath $(GSRC)
jar: 
	@if not exist $(GBIN) ( mkdir $(GBIN) )
	@jar cfm $(GTARGET) $(GMANIFEST) -C $(GBUILD) .
run: 
	@java $(GMAIN_CLASS) $(argv)
clean: 
	@if not exist $(GBIN) ( mkdir $(GBIN) )
	@if not exist $(GBUILD) mkdir $(GBUILD) )
	@del /s /q $(GTARGET)
clean_all: 
	@if not exist $(GBUILD) ( mkdir $(GBUILD) )
	@if not exist $(GBIN) ( mkdir $(GBIN) )
	@if not exist $(GGEN) ( mkdir $(GGEN) )
	@del /s /q $(GBUILD)\*.class $(GBIN)\*.jar $(GGEN)\*
