#!/bin/bash
 
mvn org.apache.maven.plugins:maven-install-plugin:2.4:install-file \
-DgroupId=com.google.android.gms \
-DartifactId=google-play-services-jar \
-Dversion=3 \
-Dpackaging=jar \
-Dfile=libs/google-play-services.jar
 
# To deploy to a remote repository use:
#
# mvn org.apache.maven.plugins:maven-deploy-plugin:2.7:deploy-file \
# -DgroupId=com.google.android.gms \
# -DartifactId=google-play-services-jar \
# -Dversion=3 \
# -Dpackaging=jar \
# -Durl=http://example.com/nexus/content/repositories/releases \
# -DrepositoryId=example-nexus \
# -Dfile=libs/google-play-services.jar