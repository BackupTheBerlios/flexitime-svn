#!/bin/bash
export JDBC_DRIVER=../lib/hibernate/pg80b1.308.jdbc3.jar
export HIBERNATE_HOME=..
export LIB=$HIBERNATE_HOME/lib/hibernate
export PROPS=$HIBERNATE_HOME/classes
export CP=$JDBC_DRIVER:$PROPS:$LIB/hibernate2.jar:$LIB/commons-logging-1.0.4.jar:$LIB/commons-collections-2.1.1.jar:$LIB/commons-lang-1.0.1.jar:$LIB/cglib-full-2.0.2.jar:$LIB/dom4j-1.4.jar:$LIB/odmg-3.0.jar:$LIB/xml-apis.jar:$LIB/xerces-2.4.0.jar:$LIB/xalan-2.4.0.jar



java -cp $CP net.sf.hibernate.tool.hbm2ddl.SchemaExport --properties=hibernate.properties ../src/data.hbm.xml $*
