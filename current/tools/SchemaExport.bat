@echo off

rem -------------------------------------------------------------------
rem Execute SchemaExport tool
rem -------------------------------------------------------------------

set JDBC_DRIVER=..\lib\hibernate\pg80b1.308.jdbc3.jar
set HIBERNATE_HOME=..
set LIB=%HIBERNATE_HOME%\lib\hibernate
set PROPS=%HIBERNATE_HOME%\classes
set CP=%JDBC_DRIVER%;%PROPS%;%LIB%\hibernate2.jar;%LIB%\commons-logging-1.0.4.jar;%LIB%\commons-collections-2.1.1.jar;%LIB%\commons-lang-1.0.1.jar;%LIB%\cglib-full-2.0.2.jar;%LIB%\dom4j-1.4.jar;%LIB%\odmg-3.0.jar;%LIB%\xml-apis.jar;%LIB%\xerces-2.4.0.jar;%LIB%\xalan-2.4.0.jar

rem java -cp %CP% net.sf.hibernate.tool.hbm2ddl.SchemaExport --config=%PROPS%\hibernate.cfg.xml %*

java -cp %CP% net.sf.hibernate.tool.hbm2ddl.SchemaExport --properties=hibernate.properties ..\src\data.hbm.xml %*
