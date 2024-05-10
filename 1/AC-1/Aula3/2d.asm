# Mapa de registos:
# $t0 – value
# $t1 – bit
# $t2 - i
# $t3 - flag
 	.data
str1: 	.asciiz "Introduza um numero:\n"
str2: 	.asciiz "\nO valor em binário e': "
 	.eqv print_string,4
 	.eqv read_int,5
 	.eqv print_char,11
 	.text
 	.globl main
 	
 	
main:	li	$t0, 0			# value = 0
	li	$t1, 0			# bit = 0
	li	$t2, 0			# i = 0
	li	$t3,0

	la $a0,str1
 	li $v0,print_string # (instrução virtual)
 	syscall # print_string(str1);

	ori $v0,$0,read_int
 	syscall
 	move $t0,$v0 # value=read_int();

 	la $a0,str2
 	li $v0,print_string # (instrução virtual)
 	syscall# print_string("...");
 	
for: 	bge $t2,32,endfor # while(i < 32) {

 	srl $t1,$t0,31 # bit = value >> 31
 	
if:	beq $t3,1,then # flag == 1
	beq $t1,0,endif # bit != 0
  	
then:	li $t3,1  # flag = 1
 
if1:	rem $t4,$t2,4 # $t4=i%4
	bne $t4,$0,endif1 # if((i % 4) == 0)
 	
 	li $a0,' '
 	li $v0,print_char # (instrução virtual)
 	syscall# print_char(' ')
 

endif1:	addi $a0,$t1,0x30
	li $v0,print_char
	syscall
	j endif
   
endif:	
	sll $t0,$t0,1 # value = value << 1;
 	addi $t2,$t2,1# i++;
 	j for
 	

             
endfor:	#
 	jr $ra # fim do programa