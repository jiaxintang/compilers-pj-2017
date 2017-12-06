grammar MiniJava;

// lexer
fragment Digit :    [0-9];
fragment Digits :   Digit*;
fragment Letter :   [a-zA_Z];
fragment Letters    :   Letter*;
fragment LetterOrDigit  :   [a-zA-Z0-9$_];
Identifier  :   Letter LetterOrDigit*;

WS  :   [ \r\t\n]+ -> skip;



// operator
AND :   '&&';
LT  :   '<';
PLUS    :   '+';
MINUS   :   '-';
TIMES   :   '*';
LP  :   '(';
RP  :   ')';



// parser
goal    :   mainClass classDeclaration* EOF;
mainClass   :   'class' Identifier '{' 'public' 'static' 'void' 'main' LP 'String' '[' ']' Identifier RP '{' statement '}' '}';
classDeclaration    :   'class' Identifier ( 'extends' Identifier )? '{' varDeclaration* methodDeclaration* '}';
varDeclaration  :   type Identifier ';';
methodDeclaration   :   'public' type Identifier LP ( type Identifier (',' type Identifier)*  )? RP '{' varDeclaration* statement* 'return' expression ';' '}';
type    :   'int' '[' ']' | 'boolean' | 'int' | Identifier;
statement   :   '{' statement* '}'
              | 'if' LP expression RP statement 'else' statement
              | 'while' LP expression RP statement
              | 'System.out.println' LP expression RP ';'
              | Identifier '=' expression ';'
              | Identifier '[' expression ']' '=' expression ';';
expression  :   expression (AND | LT | PLUS | MINUS | TIMES) expression
              | expression '[' expression ']'
              | expression '.' 'length'
              | expression '.' Identifier LP ( expression (',' expression )* )? RP
              | <INTERGER_LITERAL>
              | 'true'
              | 'false'
              | Identifier
              | 'this'
              | 'new' 'int' '[' expression ']'
              | 'new' Identifier LP RP
              | '!' expression
              | LP expression RP;
