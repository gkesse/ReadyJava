GSRC = ../code/readyapp/src
GBIN = bin
GBUILD = build
GGEN = gen
GGEN_CLASS = $(GGEN)/class
GGEN_CPP_SRC = $(GGEN)/cpp/src
GGEN_CPP_INC = $(GGEN)/cpp/include
GGEN_CPP_INC_GEN = $(GGEN)/cpp/include/gen
GGEN_LIB_PATH = $(GGEN)/lib
GGEN_LIB_NAME = $(GGEN_LIB_PATH)/rdcpp.dll
GGEN_BUILD = $(GGEN)/build
GTARGET = $(GMAIN_JAR)

GMAIN_JAVA = $(GSRC)/com/pkg/readyapp/GMain.java
GMAIN_CLASS = com.pkg.readyapp.GMain
GMANIFEST = MANIFEST

GINCS =\
    -I$(GGEN_CPP_INC) \
    -I$(GGEN_CPP_INC_GEN) \
    -I"C:/Program Files/Java/jdk-11.0.1/include" \
    -I"C:/Program Files/Java/jdk-11.0.1/include/win32" \

GOBJS_GEN =\
    $(patsubst $(GGEN_CPP_SRC)/%.cpp, $(GGEN_BUILD)/%.o, $(wildcard $(GGEN_CPP_SRC)/*.cpp)) \

GCFLAGS =\
    -std=gnu++11 \
    
all: cpp clean compile jar run
cpp: cpp_clean cpp_gen cpp_compile

cpp_gen:
	javac -h $(GGEN_CPP_INC_GEN) -d $(GGEN_CLASS) $(GMAIN_JAVA)
cpp_compile: $(GOBJS_GEN)
	@if ! [ -d $(GGEN_LIB_PATH) ] ; then mkdir -p $(GGEN_LIB_PATH) ; fi
	x86_64-w64-mingw32-g++ -shared -o $(GGEN_LIB_NAME) $(GOBJS_GEN)
$(GGEN_BUILD)/%.o: $(GGEN_CPP_SRC)/%.cpp
	@if ! [ -d $(GGEN_BUILD) ] ; then mkdir -p $(GGEN_BUILD) ; fi
	x86_64-w64-mingw32-g++ $(GCFLAGS) -c $< -o $@ $(GINCS)
cpp_clean: 
	@if ! [ -d $(GGEN) ] ; then mkdir -p $(GGEN) ; fi
	@if ! [ -d $(GGEN_CPP_INC_GEN) ] ; then mkdir -p $(GGEN_CPP_INC_GEN) ; fi
	find $(GGEN_CPP_INC_GEN) -iname *.h -delete
	find $(GGEN) -iname *.o -delete
	find $(GGEN) -iname *.dll -delete
compile:
	@if ! [ -d $(GBUILD) ] ; then mkdir -p $(GGEN) ; fi
	javac $(GMAIN_JAVA) -d $(GBUILD) -sourcepath $(GSRC)
jar: 
	@if ! [ -d $(GBIN) ] ; then mkdir -p $(GBIN) ; fi
	jar cfm $(GTARGET) $(GMANIFEST) -C $(GBUILD) .
run: 
	java $(GMAIN_CLASS) $(argv)
clean: 
	@if ! [ -d $(GBUILD) ] ; then mkdir -p $(GGEN) ; fi
	@if ! [ -d $(GBIN) ] ; then mkdir -p $(GBIN) ; fi
	find $(GBUILD) -iname *.class -delete
	find $(GBIN) -iname *.jar -delete
