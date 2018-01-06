TASK = miniJava
CLASSFILE = $(TASK)*.class
JAVAFILE = $(TASK)*.java
TESTCLASSFILE = Test*.class
TESTFILE = Test*.java
SRC = $(TASK).g4
PROG=goal
EXPR=test.expr
antlr4=java -jar ./antlr-4.7.1-complete.jar
compile=javac -cp .:./antlr-4.7.1-complete.jar:$(CLASSPATH)
grun=java -cp .:./antlr-4.7.1-complete.jar:$(CLASSPATH) org.antlr.v4.gui.TestRig
xrun=java -cp .:./antlr-4.7.1-complete.jar:$(CLASSPATH)
TESTFILE = errorTest/test.java
CONFIG = 
COMMAND = 

all:
	$(antlr4) $(TASK).g4;$(compile) $(TASK)*.java

srun:
	$(compile) $(TASK)*.java;$(xrun) $(TASK) $(TESTFILE)

run: $(CLASSFILE)
	$(xrun) $(TASK) $(TESTFILE) gui

tes: $(CLASSFILE) $(TESTCLASSFILE)
	$(xrun) TestMiniJava $(TESTFILE)

rig: $(CLASSFILE)
	$(grun) $(CONFIG) $(TASK) $(PROG) $(TESTFILE) -gui

compile:
	$(compile) $(COMMAND)

xrun:
	$(xrun) $(COMMAND)

grun:
	$(grun) $(COMMAND)

$(CLASSFILE): $(JAVAFILE)
	$(compile) $(TASK)*.java

$(JAVAFILE): $(SRC)
	$(antlr4) $(SRC)

$(TESTCLASSFILE): $(TESTFILE)
	$(compile) Test*.java

gen: $(SRC)
	$(antlr4) $(SRC)

.PHONY: clean
clean:
	cp miniJava.java ..
	cp miniJavaLoader.java ..
	-@rm -rf $(CLASSFILE) $(JAVAFILE) *.tokens *.interp
	mv ../miniJava.java .
	mv ../miniJavaLoader.java .



