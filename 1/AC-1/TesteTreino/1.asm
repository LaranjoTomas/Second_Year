#Mapa de Regeistos:
# val : $t0
# n: $t1
# min : $t2
# max : $t3
	.data
	.eqv
	.eqv
	.eqv
str:	.asciiz "Digite ate 20 inteiros (zero para terminar) : "
str1:	.asciiz "Maximo/minimo sao: "
str2:	.asciiz " : "
	.text
	.globl main
main:
	li $t0,0 # val = 0
	li $t1,0 # n = 0
	li $t2,0x7FFFFFFF # min = 0x7FFFFFFF
	li $t3,0x80000000 # max = 0x80000000
	
	
while:	la $a0,str
	li $v0,4
	syscall
	
	li $v0,5
	syscall
	move $t0,$v0
		
if: 	beqz $t0,endw
	
if1:	ble $t0,$t3,if2
	move $t3,$t0
	
if2:	bge $t0, $t2,endif
	move $t2,$t0
	
endif:
	addi $t1,$t1,1
	j while
	
endw:	bge $t1,20,end
	beqz $t0,end
	j while
	
end:
	la $a0,str1
	li $v0,4
	syscall
	
	move $a0,$t3
	li $v0,1
	syscall
	
	la $a0,str2
	li $v0,4
	syscall
	
	move $a0,$t2
	li $v0,1
	syscall
	
	
	jr $ra
	
