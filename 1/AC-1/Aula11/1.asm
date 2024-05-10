	.eqv print_string,4
	.eqv print_intu10,36
        .eqv print_char,11
	.eqv print_float,2
	.eqv read_int,5
	.eqv read_string,8
	.eqv of_id,0
    	.eqv of_fn,4
    	.eqv of_ln,22
    	.eqv of_gr,40
    	
    	.data
    	.align    2
    	
stg:    .word 72343    
    .asciiz "Napoleao"        #Napoleao só ocupa 9 espaçoes, temos que completar todos os outros espaços disponiveis
    .space 9        #Usando o space
    .asciiz "Bonaparte"
    .space 5
    .align 2
    .float 5.1
str1:	.asciiz "\nN. Mec: "
str2:	.asciiz "\nNome: "
str3:	.asciiz "\nNota: "
str4:	.asciiz "N. Mec: "
str5:	.asciiz "Primeiro Nome: "
	.text
	.globl main
main:	la $t0, stg

	la $a0,str4 # print_str("N. Mec: ");  
	li $v0,print_string
	syscall
	
	li $v0,read_int
	syscall # stg.id_number = read_int(); 
	move $t0,$v0

	la $a0,str5 # print_string("Primeiro Nome: ");
	li $v0,print_string
	syscall

	li $v0,read_string
	syscall # stg.id_number = read_int(); 
	move $t0,$v0

	li $v0,read_string
	syscall #read_string(stg.first_name, 17); 
	move $a0,$v0
	addiu $a0,$a0,of_fn

	la $a0,str1 # print_string("\nN. Mec: "); 
	li $v0,print_string
	syscall
	 
	la $t0,stg #print_intu10(stg.id_number);
	lw $a0,of_id($t0)
	li $v0,print_intu10
	syscall
	
	la $a0,str2
	li $v0,print_string
	syscall
	
	la $a0,stg
	addiu $a0,$a0,of_ln
	li $v0,print_string
	syscall
	
	li $a0,','
	li $v0,print_char
	syscall
	
	la $a0,stg
	addiu $a0,$a0,of_fn
	li $v0,print_string
	syscall
	
	la $a0,str3
	li $a0,print_string
	syscall
	
	l.s $f12,of_gr($t0)
	li $v0,print_float
	syscall
	li $v0,0
	
	jr $ra