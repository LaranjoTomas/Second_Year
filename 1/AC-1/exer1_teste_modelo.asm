# Mapa de registos
# rv : $t0
# n  : $t1
# sum: $t2
# nit: $t3
# pt : $t4
	.data
str:	.asciiz "Media invalida!\n"
	.align 2
list:	.space 32
	.text
	.eqv SIZE,8
	.eqv read_int,5
	.eqv print_int10,1
	.eqv print_string,5
	.globl main
	
main:	
	li $t2,0 #sum = 0
	li $t1,0 #nit = 0
	la $t4,list # pt = list
	li $t5,SIZE # $t5 = size
	addiu $t6,$t4,32 # list + SIZE
	
for:	bge $t4,$t6,endfor
	
	li $v0,read_int
	syscall
	sw $v0,0($t4)
	addi $t4,$t4,4 #pt++
	j for

endfor:	li $t1,0
	la $t4,list

for1:
	bge $t1,SIZE,if1
	sll $t5,$t1,2
	add $t6,$t4,$t0
	lw $t6,0($t6) #list[n]
	
if:	bltz $t6,endif # list[n] >= 0
	add $t2,$t2,$t6 #sum += list[n]
	addi $t4,$t4,1 # nit++

endif:	addi $t1,$t1,1	

if1:	
	blez $t3,elseif # nit > 0
	div $t6,$t2,$t4 # sum / nit
	move $a0,$t6
	li $v0,print_int10
	syscall #print_int10(sum / nit);
	li $t0,0 # rv = 0
	j end

elseif:
	la $a0,str
	li $v0,print_string
	syscall
	li $t0,-1
	
end:
	move $v0,$t0
	
	move $a0,$v0
	li $v0,print_int10
	syscall
	
	move $v0,$t0
	
	jr $ra