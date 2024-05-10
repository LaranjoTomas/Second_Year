# Mapa de registos:
# $t0 – gray
# $t1 – bin
# $t2 - mask
 	.data
str: 	.asciiz "Introduza um numero:\n"
str1: 	.asciiz "\nValor em código Gray: "
str2:	.asciiz "\nValor em binario: "
 	.eqv print_string,4
 	.eqv read_int,5
 	.eqv print_char,11
 	.eqv print_int16,34
 	.text
 	.globl main
 	
main:	li $t0,0 # gray = 0
	li $t1,0 # bin = 0
	li $t2,0 # mask = 0
	
	la $a0,str
	li $v0,print_char
	syscall
	
	li $v0,read_int
	syscall
	move $t0,$v0 # t0 = gray
	
	srl $t2,$t0,1 # mask = gray >> 1
	move $t1,$t0 # bin = gray

while:	bnez $t2,end
	xor $t1,$t1,$t2
	srl $t2,$t2,1
	j while
	
	
	
end:	
	la $a0,str1
	li $v0,print_string
	syscall
	
	move $a0,$t0
	li $v0,print_int16
	syscall
	
	la $a0,str2
	li $v0,print_string
	syscall
	
	move $a0,$t1
	li $v0,print_int16
	syscall
	