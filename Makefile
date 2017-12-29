TASK = miniJava
CLASSFILE = $(TASK)*.class
JAVAFILE = $(TASK)*.java
SRC = $(TASK).g4
PROG=goal
EXPR=test.expr
antlr4=java -jar /usr/local/lib/antlr-4.7.1-complete.jar
grun=java org.antlr.v4.gui.TestRig
TESTFILE = test/BinarySearch.java


run: $(CLASSFILE)
	$(grun) $(TASK) $(PROG) $(EXPR)

runx: $(CLASSFILE)
	$(grun) $(TASK) $(PROG) $(EXPR) -gui

test: $(CLASSFILE)
	$(grun) $(TASK) $(PROG) $(TESTFILE) -gui

testx: $(CLASSFILE)
	$(grun) $(TASK) $(PROG) ./test/Wrong.java -gui

$(CLASSFILE): $(JAVAFILE)
	javac $(TASK)*.java

$(JAVAFILE): $(SRC)
	$(antlr4) $(SRC)

gen: $(SRC)
	$(antlr4) $(SRC)

.PHONY: clean
clean:
	-@rm -rf $(CLASSFILE) $(JAVAFILE) *.tokens *.interp


