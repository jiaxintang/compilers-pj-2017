grammar miniJava;

goal: mainClass (classDeclaration)*;

mainClass
	:'class' ID '{' 
	'public' 'static' 'void' 'main' '(' 'String' '[' ']' ID ')' 
	'{' statement '}' 
	'}' 
	;

classDeclaration
	:'class' ID 
	( 'extends' ID )? 
	'{' 
	( varDeclaration )*
	( methodDeclaration )* 
	'}'
	;

varDeclaration
	:type ID ';' 
	;

methodDeclaration
	:'public' type ID 
	'(' ( type ID ( ',' type ID )* )? ')' 
	'{' ( varDeclaration )* ( statement )* 'return' expression ';' '}' 
	;

type
	:'int' '['']'
	|'boolean'
	|'int'
	|ID 
	;

statement
	:'{' ( statement )* '}'												#block
	|'if' '(' expression ')' statement 'else' statement					#select
	|'while' '(' expression ')' statement								#while
	|'System.out.println' '(' expression ')' ';'						#output
	|ID '=' expression ';'												#assign
	|ID '[' expression ']' '=' expression ';' 							#arrayAssign
	;

expression
	:expression '.' ID '(' ( expression ( ',' expression )* )? ')'		#method
	|expression '.' 'length'											#length
	|expression '[' expression ']'										#access
	|expression '^'<assoc=right> expression								#exp
	|expression '*' expression											#mul
	|expression ('+' | '-') expression									#addSub
	|expression '<' expression											#LT
	|expression '&&' expression											#and
	|INT																#int
	|('true' | 'false')													#bool
	|ID																	#id
	|'this'																#this
	|'new' 'int' '[' expression ']'										#newInt
	|'new' ID '(' ')'													#newId
	|'!' expression														#not
	|'(' expression ')'													#paren
	;


LINE_COMMENT : '//' .*? '\r'? '\n' -> skip;
COMMENT : '/*' .*? '*/' -> skip;
WS : [ \t\r\n]+ -> skip;

ID : [a-zA-Z][a-zA-Z0-9_]*;
INT : [0-9]+;
FLOAT 
	: DIGIT+ '.' DIGIT*
	| '.' DIGIT+
	；
STRING : '"' (ESC|.)*? '"' ;

fragment
DIGIT : [0-9] ;

fragment
END : '\\"' | '\\\\' ;

