# Mapa de registos
# res: $v0
# s: $a0
# *s: $t0
# digit: $t1
# Sub-rotina terminal: não devem ser usados registos $sx 
	.data
str:	.asciiz "2020 e 2024 sao anos bissextos"
	.eqv print_int10,1
	.globl main2
	.text
main2:
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
