#Mapa de Registos:
#i:$t0
	.data
	.eqv STR_MAX_SIZE 30
str:	.asciiz "I serodatupmoC ed arutetiuqrA"
str1:	.asciiz "String too long: "
strf:	.asciiz "\n "
	.eqv print_string,4
	.eqv print_int10
	.globl main

strcpy:	
	li $t0,0 # i = o
do:	addu $t1,$a1,$t0
	lb $t3,0($t1)
	addu $t2,$a0,$t0
	sb $t3,0($t2)
	beq $t3,'\0',edo
	addi $t0,$t0,1
	j do
	
edo:	move $v0,$a0
	jr $ra
	
##############################################################

strlen: li $t1,0 # len = 0;

while: 	lb $t0,0($a0) # while(*s++ != '\0')
 	addiu $a0,$a0,1 #
 	beq $t0,'\0',endw # {
 	addi $t1,$t1,1 # len++;
 	j while # }
endw: 	move $v0,$t1 # return len;
 	jr $ra # 
#############################################################################################

#############################################################################################
# int strlen(char *s)
# $v0 - len
# $t0 - *s
	.text

main:	
	addiu $sp,$sp,-4
	sw $ra,0($sp)
	la $a0,str1
	jal strlen
	bgt $v0,str
	la $a0,str2
	la $a0,str1
	jal strcpy
	la $v0,str2
	li $v0,print_string
	syscall
	la $a0,saux
	li $v0,print_string
	syscall
	la $a0,str2
	jal strrev
	move $a0,$v0
	li $V0,print_string
	syscall
	li $t0,0
	j else
else:	la $a0,strf
	li $v0,print_string
	syscall
	lw $ra,0($sp)
	addiu $sp,$sp,4
	
	jr $ra
	
	
	
	
	
	