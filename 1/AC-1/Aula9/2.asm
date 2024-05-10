#Mapa de Registos:
#$f0 :  ft
#$f2 :  k1
#$f4 :  k2
#$f6 :  k3
#$f8 :  res


       	.data
k1:    	.double 5.0
k2:    	.double 9.0
k3:    	.double 32.0
       	.eqv read_double, 7
    	.eqv print_double,3
    	.text
    	.globl main

f2c:    l.d $f2, k1 #5.0
    	l.d $f4, k2 #9.0
    	l.d $f6, k3 #32.0

    	div.d $f8, $f2, $f4
    	sub.d $f0, $f0, $f6
    	mul.d $f0, $f0, $f8
    	jr $ra

main:   addi $sp, $sp, -4
    	sw $ra, 0($sp)
    	li $v0, read_double
    	syscall
    	jal f2c
    	mov.d $f12, $f0
    	li $v0, print_double
    	syscall
    	lw $ra, 0($sp)
    	addi $sp, $sp, 4
    	jr $ra