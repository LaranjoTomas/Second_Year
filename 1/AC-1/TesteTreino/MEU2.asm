#Mapa de registos:
# i: $t0
# v: $t1
# &(val[0]): $t2
	.data
	.eqv print_char,11
	.eqv print_string,4
	.eqv print_int10,1
	.eqv SIZE,8
val:	.word 8,4,15,-1987,327,-9,27,16
str:	.asciiz "\nResult is: "
	.text
	.globl main
main:	li $t0,0 # i = 0

while:
	la $t2,val
	sll $t1,$t0,2 # v = i << 2
	addu $t1,$t1,$t2 
	
	li $t3,SIZE # $t3 = 8
	srl $t3,$t3,1 # $t3 = 4
	add  $t3,$t3,$t0 # $t3 = indice da lista
	sll $t3,$t3,2 # $t3 = indice * 4
	add $t3,$t3,$t2 # $t3 = numero da lista
	
	lw $t4,0($t1) # $t4 = numero da lista
	lw $t5,0($t3) # $t5 = numero da lista
	sw $t5,0($t1) # salvar numero posição x
	sw $t4,0($t3) # salvar numero posição x
	
	addi $t0,$t0,1 # $t0(i) = i + 1
endw:	bge $t0,4,beggindo
	j while
	
beggindo:	la $a0,str
		li $v0,print_string
		syscall #print_string("Result is: ")
		
		li $t0,0 # i = 0
	
do:
	la $t2,val
	sll $t6,$t0,2
	addu $t6,$t6,$t2
	lw $t7,0($t6)
	
	move $a0,$t7
	li $v0,print_int10
	syscall #print_int10(val[i++])
	
	li $a0,','
	li $v0,print_char
	syscall #print_char(',')
	
	addi $t0,$t0,1 # i + 1

enddo:	bge $t0,8,end # i < SIZE
	
	j do

end:
	jr $ra