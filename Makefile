TASK = miniJava
CLASSFILE = $(TASK)*.class
JAVAFILE = $(TASK)*.java
SRC = $(TASK).g4
PROG=goal
EXPR=test.expr
antlr4=java -jar /usr/local/lib/antlr-4.7.1-complete.jar
grun=java org.antlr.v4.gui.TestRig
TESTFILE = test.java
CONFIG = 


run: $(CLASSFILE)
	$(grun) $(CONFIG) $(TASK) $(PROG) $(EXPR)

runx: $(CLASSFILE)
	$(grun) $(CONFIG) $(TASK) $(PROG) $(EXPR) -gui

tes: $(CLASSFILE)
	$(grun) $(CONFIG) $(TASK) $(PROG) $(TESTFILE) -gui

$(CLASSFILE): $(JAVAFILE)
	javac $(TASK)*.java

$(JAVAFILE): $(SRC)
	$(antlr4) $(SRC)

gen: $(SRC)
	$(antlr4) $(SRC)

.PHONY: clean
clean:
	-@rm -rf $(CLASSFILE) $(JAVAFILE) *.tokens *.interp


