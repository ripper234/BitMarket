@echo off

set FILE=%1
set GROUP_ID=%2
set ARTIFACT_ID=%3
set VERSION=%4

if "%VERSION%" == "" goto usage

mvn org.apache.maven.plugins:maven-install-plugin:2.3.1:install-file -Dfile=%FILE% -DgroupId=%GROUP_ID% -DartifactId=%ARTIFACT_ID% -Dversion=%VERSION% -Dpackaging=jar -DlocalRepositoryPath=.\mvn-repo

goto end

:usage
echo Usage: install-jar FILE GROUP_ID ARTIFACT_ID VERSION
echo.
echo Group should be "com.mashlife.external...."

:end