@echo off

call "%M2_HOME%\bin\mvn.bat" clean package -am -pl %1 %2
