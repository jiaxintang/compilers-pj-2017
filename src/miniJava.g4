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

varDecs
	:varDeclaration*
	;

methodDeclaration
	:'public' type ID 
	LPR parameters RPR 
	'{' varDecs body 'return' returnExpr SEMI '}' 
	;

body
	: statement*
	;

parameters
	: (type ID ( COMMA type ID)* )?
	;

returnExpr : expression;

type
	:'int' '['']'
	|'boolean'
	|'int'
	|ID 
	;

statement
	:'{' body '}'														#block
	|'if' condition statement 'else' statement							#select
	|'while' condition statement										#while
	|'System.out.println' LPR expression RPR SEMI						#output
	|ID ASSIGN expression SEMI											#assign
	|ID '[' expression ']' ASSIGN expression SEMI 						#arrayAssign
	;

condition : LPR expression RPR;

expression
	:expression DOT ID LPR ( expression ( COMMA expression )* )? RPR	#method
	|expression DOT 'length'											#length
	|expression '[' expression ']'										#access
	|expression EXP<assoc=right> expression								#exp
	|expression MUL expression											#mul
	|expression (ADD | SUB) expression									#addSub
	|expression EQ expression											#EQ
	|expression LT expression											#LT
	|expression AND expression											#and
	|INT																#int
	|BOOLEAN															#bool
	|ID																	#id
	|'this'																#this
	|'new' 'int' '[' expression ']'										#newInt
	|'new' ID LPR RPR													#newId
	|'!' expression														#not
	|LPR expression RPR													#paren
	;


BOOLEAN : 'true' | 'false' ;
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
EQ : '==';
ASSIGN : '=';
LT : '<';
AND : '&&';
LPR : '(';
RPR : ')';
SEMI : ';';
EXP : '^';
DOT : '.';
COMMA : ',';


LINE_COMMENT : '//' .*? '\r'? '\n' -> skip;
COMMENT : '/*' .*? '*/' -> skip;
WS : [ \t\r\n]+ -> skip;
