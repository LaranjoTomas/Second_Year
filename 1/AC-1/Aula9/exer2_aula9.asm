#Mapa de Registos:
#$f2:5.0
#$f4:9.0
#$f6:32.0
#ft:$f12
	.data
k1:	.double 5.0
k2:	.double 9.0
k3:	.double 32.0
str:	.asciiz "\nIntroduza um valor em fahrenheit: "
str1:	.asciiz "\nO valor em celsius e`: "
	.eqv read_double,7
	.eqv print_double,3
	.eqv print_string,4
	.text
	.globl f2c
	
f2c:
	l.d 	$f2,k1
	l.d 	$f4,k2
	l.d 	$f6,k3
	
	div.d 	$f2,$f2,$f4	#$f2=(5.0/9.0)
	sub.d	$f12,$f12,$f6	#$f12=(ft-32.0)
	
	mul.d	$f0,$f2,$f12	#return (5.0/9.0)*(ft-32.0)
	
	jr	$ra
	
##############################################################################################

	.globl main
main:	
	addiu $sp,$sp,-8
	sw $ra,0($sp)
	sw $s0,4($sp)
	
	la $a0,str
	li $v0,print_string
	syscall
	
	li $v0,read_double
	syscall
	    
	mov.d $f12,$f0
	jal f2c
	
	la $a0,str1
	li $v0,print_string
	syscall
	
	mov.d $f12,$f0 
	li $v0,print_double
	syscall
	          
	li $v0,0     
	              
	lw $ra,0($sp)
	lw $s0,4($sp)
	addiu $sp,$sp,8
	jr $ra