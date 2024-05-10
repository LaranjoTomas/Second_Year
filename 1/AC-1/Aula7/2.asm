# Mapa de registos:
# str: $a0 -> $s0 (argumento é passado em $a0)
# p1: $s1 (registo callee-saved)
# p2: $s2 (registo callee-saved)
#
	.data
str:	.asciiz "ITED - orievA ed edadisrevinU"
	.eqv print_int10,1
	.eqv print_string,4
	.text
	.globl main

main:	addiu $sp,$sp,-4
	sw $ra,0($sp)
	
	la $a0,str
	jal strrev
	la $a0,str
	li $v0,print_string
	syscall
	li $v0,0
	
	lw $ra,0($sp)
	addiu $sp,$sp,4
	
	jr $ra
	
	
exchange:
	lb $t0,0($a0)	#aux = *c1
	lb $t1,0($a1)	#$t1 = *c2
	sb $t1,0($a0)	#*c1 = *c2
	sb $t0,0($a1)	#*c2 = aux
	jr $ra

strrev: addiu $sp,$sp,-16 # reserva espaço na stack
 	sw $ra,0($sp) # guarda endereço de retorno
 	sw $s0,4($sp) # guarda valor dos registos
 	sw $s1,8($sp) # $s0, $s1 e $s2
 	sw $s2,12($sp) #
 	move $s0,$a0 # registo "callee-saved"
 	move $s1,$a0 # p1 = str
 	move $s2,$a0 # p2 = str
while1: # while( *p2 != '\0' ) {
	lb $t1,0($s2)
	beq $t1,'\0',endw1
 	addiu $s2,$s2,1 # p2++;
 	j while1 # }
 	
endw1:	addiu $s2,$s2,-1 # p2--;

while2: # while(p1 < p2) {
 	bge $s1,$s2,endw2
 	move $a0,$s1 #
 	move $a1,$s2 #
 	jal exchange # exchange(p1,p2)
 	addi $s1,$s1,1 # p1++
 	addi $s2,$s2,-1# p2--
 	j while2

endw2:	move $v0,$s0 # return str
	lw $ra,0($sp) # repõe endereço de retorno
 	lw $s0,4($sp)# repõe o valor dos registos
 	lw $s1,8($sp) # $s0, $s1 e $s2
 	lw $s2,12($sp)#
 	addiu $sp,$sp,16 # liberta espaço da stack
 	jr $ra # termina a sub-rotina 