# Mapa de registos
# res: $v0
# s: $a0
# *s: $t0
# digit: $t1
# Sub-rotina terminal: não devem ser usados registos $sx
	.text
atoi: 	li 	$v0,0 # res = 0;

while: 	lb 	$t0,0($a0) # while(*s >= ...)
 	blt 	$t0,'0', endw# (*s >= '0')
 	bgt 	$t0,'9', endw # (*s <= '9')
 	sub 	$t1,$t0,'0' # digit = *s – '0'
 	addiu 	$a0,$a0,1 # s++;
 	mul   	$v0,$v0,2 # res = 10 * res;
 	addu  	$v0,$v0,$t1 # res = 10 * res + digit;
 	j while # }
 	
endw:	
 	jr $ra # termina sub-rotina
 
 
	.data
str:	.asciiz "101101"
	.eqv print_int10,1
	.globl main4
	.text
main4:
	addiu $sp,$sp,-4
	sw $ra,0($sp)
	
	la $a0,str # $t2=str
	
	jal atoi
	
	move $a0,$v0
	li $v0,print_int10
	syscall
	
	lw $ra, 0($sp)
	addiu $sp,$sp,4
	
 	
	jr $ra 
 
