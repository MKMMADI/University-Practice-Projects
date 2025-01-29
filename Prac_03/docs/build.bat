@echo off

SET JAVA_HOME=C:\jdk-21
SET PATH=%JAVA_HOME%\bin;%PATH%

pause
cd ..
jar --help
java -version

SET PRAC_SRC=.\src
SET PRAC_BIN=.\bin
SET PRAC_LIB=.\lib

jar -xf %PRAC_LIB%\models.jar -C %PRAC_SRC%\acsse\csc2a
javac -cp .\lib\models.jar -d %PRAC_BIN% -sourcepath %PRAC_SRC% %PRAC_SRC%\Main.java
java -cp %PRAC_BIN% Main

pause