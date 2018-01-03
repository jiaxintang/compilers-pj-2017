grammar miniJava;

goal: mainClass (classDeclaration)*;

mainClass
	:'class' ID BLP 
	'public' 'static' 'void' 'main' LPR 'String' '[' ']' ID RPR 
	BLP statement BRP 
	BRP 
	;

classDeclaration
	:'class' ID 
	( 'extends' ID )? 
	BLP 
	( varDeclaration )*
	( methodDeclaration )* 
	BRP
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
	BLP varDecs body RETURN returnExpr SEMI BRP 
	|'public' type ID
	LPR parameters RPR
	BLP varDecs body BRP { notifyErrorListeners("missing 'return' expression");}
	;

body
	: statement*
	;

parameters
	: (type ID ( COMMA type ID)* )?
	;

returnExpr : expr;

type
	:'int' '[' ']'
	|'boolean'
	|'String'
	|'float'
	|'int'
	|ID 
	;

statement
	:BLP body BRP														#block
	|IF condition statement 'else' statement							#select
	|'while' condition statement										#while
	|'System.out.println' LPR expr RPR SEMI						#output
	|ID ASSIGN expr SEMI											#assign
	|ID '[' expr ']' ASSIGN expr SEMI 						#arrayAssign
	;

condition : LPR expr RPR;

expr
	:expression RPR	{ notifyErrorListeners("Too many parentheses"); }
	|LPR expression { notifyErrorListeners("Missing closing ')'"); }
	|expression;


expression
	:expression DOT ID LPR ( expression ( COMMA expression )* )? RPR	#method
	|expression DOT 'length'											#length
	|expression '[' expression ']'										#access
	|expression EXP<assoc=right> expression								#exp
	|expression MUL expression											#mul
	|expression (OP=ADD | OP=SUB) expression							#addSub
	|expression EQ expression											#EQ
	|expression LT expression											#LT
	|expression AND expression											#and
	|INT																#int
	|FLOAT																#float
	|BOOLEAN															#bool
	|STRING																#string
	|ID																	#id
	|'this'																#this
	|'new' 'int' '[' expression ']'										#newInt
	|'new' ID LPR RPR													#newId
	|'!' expression														#not
	|LPR expression RPR													#paren
	;

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
BLP : '{';
BRP : '}';
RETURN : 'return';
IF : 'if';

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


LINE_COMMENT : '//' .*? '\r'? '\n' -> skip;
COMMENT : '/*' .*? '*/' -> skip;
WS : [ \t\r\n]+ -> skip;
