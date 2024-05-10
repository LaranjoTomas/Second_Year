# mapa de registos
# i: $t0
# v: $t1
# &(val[0]): $t2
	.data
str:	.asciiz "Result is: "
	.eqv SIZE, 8
aint:	.word 8, 4, 15, -1987, 327, -9, 27, 16
	.text
	.globl main
main:	li $t0, 0
do1:	la $t2, aint
	sll $t1, $t0, 2
	add $t1, $t1, $t2 # primeiro tropa
	
	li $t3, SIZE
	srl $t3, $t3, 1
	add $t3, $t3, $t0
	sll $t3, $t3, 2
	add $t3, $t2, $t3
	lw $t4, 0($t1)
	lw $t5, 0($t3)
	sw $t5, 0($t1)
	sw $t4, 0($t3)
	addi $t0, $t0, 1
	bge $t0, 4, endd1
	j do1
endd1:	
	la $a0, str
	li $v0, 4
	syscall
	li $t0, 0
do2:	la $t2, aint
	sll $t1, $t0, 2
	add $t1, $t2, $t1
	lw $a0, 0 ($t1)
	li $v0, 1
	syscall
	li $a0, ','
	li $v0, 11
	syscall
	addi $t0, $t0, 1
	bge $t0, SIZE, enddo2
	j do2
enddo2:	
	jr $ra
	
	
	
	
	
	
	
