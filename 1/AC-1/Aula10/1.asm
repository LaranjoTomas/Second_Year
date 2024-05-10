#Mapa de Registos:
# x : $t0
# y : $t1
	.data
	.eqv read_int, 5
	.eqv read_float,6
	.eqv print_string, 4
	
k1:	.float 1.0
str:	.asciiz "Introduza a base (float): "
str1:	.asciiz "Introduza o expoente (int): "
str2:	.asciiz "\nResultado: "
	
	.text
xtoy:  	
    	addi $sp,$sp,-4
    	sw $ra,0($sp)
    	
    	
    	l.s $f2,k1
    	jal abs
    	li $t0,0
    	move $t1,$v0
    	
for_xt:	bge $t0,$t1, end_fxt
if1:	ble $t1,0,else_xt
    	mul.s $f2,$f2,$f12
	j xt1
	
else_xt:
	div.s $f2,$f2,$f12
	
xt1:	addi $t0,$t0,1
	j for_xt    
		
end_fxt:
	mov.s $f0,$f2
	
    	lw $ra,0($sp)
    	addi $sp,$sp,4
    	jr $ra
    	
    	
#############################################################
	.text
abs:
	bge $a0,0,elseabs
	sub $v0,$0,$a0
	j fabs
	
elseabs: move $v0,$a0
fabs:	jr $ra
 	
#############################################################

	.text
	.globl main
main:	addi $sp, $sp,-4
    	sw $ra, 0($sp)

	la $a0,str
	li $v0,print_string
	syscall
	
	li $v0,read_float
	syscall
    	mov.s $f12,$f0
    	
    	la $a0,str1
    	li $v0,print_string
    	syscall
    	
    	li $v0,read_int
	syscall
    	
    	move $t0,$a0
    	
    	la $a0,str2
    	li $v0,print_string
    	syscall
    	
    	move $a0,$t0
    	
    	jal xtoy
    	
    	mov.s $f12,$f0
    	li $v0,2
    	syscall
    	
    	lw $ra, 0($sp)
    	addi $sp,$sp,4
    	jr $ra
    	
