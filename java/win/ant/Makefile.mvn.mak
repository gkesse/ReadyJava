all:

version:
	@mvn -version
new:
	@cd $(GPROJECT_SRC) && mvn archetype:generate \
	-DarchetypeArtifactId=maven-archetype-quickstart \
	-DgroupId=com.pkg.readyapp \
	-DpackageName=com.pkg.readyapp \
	-DartifactId=$(GMVN_ARTIFACT) \
	-Dversion=1.0.0 \
	-DinteractiveMode=false
pkg:
	@cd $(GMVN_PATH) && mvn package
