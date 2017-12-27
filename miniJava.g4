grammar miniJava;

goal: mainClass (classDeclaration)*;

mainClass :
	'class' identifier '{' 
	'public' 'static' 'void' 'main' '(' 'String' '[' ']' identifier ')' '{' statement '}' '}' 
	;

classDeclaration :
	'class' identifier 
	( 'extends' identifier )? 
	'{' ( varDeclaration )* ( methodDeclaration )* '}'
	;

varDeclaration :
	type identifier ';' 
	;

methodDeclaration :
	'public' type identifier 
	'(' ( type identifier ( ',' type identifier )* )? ')' 
	'{' ( varDeclaration )* ( statement )* 'return' expression ';' '}' 
	;

type : 
	'int' '['']'
	|'boolean'
	|'int'
	|identifier 
	;

statement : 
	'{' ( statement )* '}'
	|'if' '(' expression ')' statement 'else' statement
	|'while' '(' expression ')' statement
	|'System.out.println' '(' expression ')' ';'
	|identifier '=' expression ';'
	|identifier '[' expression ']' '=' expression ';' 
	;

extendexp : 
	expression
	|expression ')' {notifyErrorListeners("too many ')'");}
	|'(' expression {notifyErrorListeners("too many '('");}
	;

expression : 
	expression ('&&'|'<'|'+'|'-'|'*') expression   
	| expression '[' expression ']'
	| expression '.' 'length'
	| expression '.' identifier '(' ( expression ( ',' expression )* )? ')'
	| INT
	| 'true'
	| 'false'
	| identifier
	| 'this'
	| 'new' 'int' '[' expression ']'
	| 'new' identifier '(' ')'
	| '!' expression
	| '(' expression ')'
	;

identifier : 
	ID
	;

LINE_COMMENT : '//' .*? '\r'? '\n' -> skip;
COMMENT : '/*' .*? '*/' -> skip;
WS : [ \t\r\n]+ -> skip;

ID : [a-zA-Z][a-zA-Z0-9_]*;
INT : [0-9]+;
WRONG_INT : [0-9][^ \t\r\n]+;
WRONG_ID : [a-zA-Z][^ \t\r\n]+;
UNAVALIABLE : .+;
