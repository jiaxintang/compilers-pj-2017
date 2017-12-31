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
TESTFILE = test/test.java
CONFIG = 
COMMAND = 

srun:
	$(compile) $(TASK)*.java;$(xrun) $(TASK) $(TESTFILE)

run: $(CLASSFILE)
	$(xrun) $(TASK) $(TESTFILE)

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
	-@rm -rf $(CLASSFILE) $(JAVAFILE) *.tokens *.interp


