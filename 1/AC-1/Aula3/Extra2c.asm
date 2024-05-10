# Mapa de registos:
# $t0 – res
# $t1 – i
# $t2 - mdor
# $t3 - mdo
 	.data
str: 	.asciiz "Introduza um numero:\n "
str1: 	.asciiz "Resultado:  "
 	.eqv print_string,4
 	.eqv print_int10,1
 	.eqv read_int,5
 	.text
 	.globl main
 	
main:	li $t0,0 # res = 0
	li $t1,0 # i = 0
	
	la $a0,str
	li $v0,print_string
	syscall
	
	li $v0,read_int
	syscall
	
	andi $t2,$v0,0xFFFF # mdor = read_int() & 0x0F; 
	
	la $a0,str
	li $v0,print_string
	syscall
	
	li $v0,read_int
	syscall
	
	andi $t3,$v0,0xFFFF # mdo = read_int() & 0x0F; 
	
while:	beqz $t2,end # (mdor != 0)
	bge  $t1,16,end #  (i++ < 4)
	
	andi $t4,$t2,0x1 # $t4 = mdor & 0x00000001
if:	beqz $t4,endif #  (mdor & 0x00000001) != 0
	add $t0,$t0,$t3 #res = res + mdo; 

endif:	sll $t3,$t3,1
	srl $t2,$t2,1
	
	addi $t1,$t1,1
	j while
	
end:	la $a0,str1
	li $v0,print_string
	syscall
	
	move $a0,$t0
	li $v0,print_int10
	syscall
	
	jr $ra