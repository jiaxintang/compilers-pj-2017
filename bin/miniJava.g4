grammar miniJava;

goal: mainClass (classDeclaration)*;

mainClass
	:'class' ID '{' 
	'public' 'static' 'void' 'main' LPR 'String' '[' ']' ID RPR 
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
	:type ID SEMI 
	;

methodDeclaration
	:'public' type ID 
	LPR ( type ID ( COMMA type ID )* )? RPR 
	'{' ( varDeclaration )* ( statement )* 'return' expression SEMI '}' 
	;

type
	:'int' '['']'
	|'boolean'
	|'int'
	|ID 
	;

statement
	:'{' ( statement )* '}'												#block
	|'if' LPR expression RPR statement 'else' statement					#select
	|'while' LPR expression RPR statement								#while
	|'System.out.println' LPR expression RPR SEMI						#output
	|ID ASSIGN expression SEMI											#assign
	|ID '[' expression ']' ASSIGN expression SEMI 						#arrayAssign
	;

expression
	:expression DOT ID LPR ( expression ( COMMA expression )* )? RPR	#method
	|expression DOT 'length'											#length
	|expression '[' expression ']'										#access
	|expression EXP<assoc=right> expression								#exp
	|expression MUL expression											#mul
	|expression (ADD | SUB) expression									#addSub
	|expression LT expression											#LT
	|expression AND expression											#and
	|INT																#int
	|('true' | 'false')													#bool
	|ID																	#id
	|'this'																#this
	|'new' 'int' '[' expression ']'										#newInt
	|'new' ID LPR RPR													#newId
	|'!' expression														#not
	|LPR expression RPR													#paren
	;

LINE_COMMENT : '//' .*? '\r'? '\n' -> skip;
COMMENT : '/*' .*? '*/' -> skip;
WS : [ \t\r\n]+ -> skip;

ID : [a-zA-Z][a-zA-Z0-9_]*;
INT : [0-9]+;
FLOAT 
	: DIGIT+ DOT DIGIT*
	| DOT DIGIT+
	;
STRING : '"' (ESC|.)*? '"' ;

fragment
DIGIT : [0-9] ;

fragment
ESC : '\\"' | '\\\\' ;

MUL : '*';
ADD : '+';
SUB: '-';
ASSIGN : '=';
LT : '<';
AND : '&&';
LPR : '(';
RPR : ')';
SEMI : ';';
EXP : '^';
DOT : '.';
COMMA : ',';


