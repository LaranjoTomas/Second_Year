# Mapa de registos
# p: $t0
# pultimo:$t1
# *p $t2
# soma: $t3
# i : $t4
 	.data
array:	.word 7692,23,5,234
 	.eqv print_int10,1
 	.eqv SIZE,4
 	.text
 	.globl main

main: 	li $t3,0 # soma = 0;
 	li $t4,0 #  i = 0
 	

	
while: 	# while(i < SIZE)
 	bgeu $t4,SIZE,endw # {
 	
 	la   $t0, array	# p = array;

 	sll	$t3, $t4, 2	# $t3 = i*4;
	addu	$t3, $t0, $t3	# $t3 = &array[i]

	lw	$t3, 0($t3)	# $t3 = array[i]
	add	$t2, $t2, $t3	# soma = soma + array[i];

	addi	$t4, $t4, 1	# i++;
 	j while

endw:	move $a0,$t2
	li $v0,print_int10 
 	syscall # print_int10(soma);
 	
 	jr $ra # termina o programa 