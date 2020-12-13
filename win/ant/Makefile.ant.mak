all:

version:
	@ant -version
help:
	@ant -help
build:
	@ant -buildfile $(GANT_BUILD_FILE) $(argv)
