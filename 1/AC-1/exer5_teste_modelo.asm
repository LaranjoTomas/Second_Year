#Mapa de Registos
#p:$a0-> $s0
#k:$a1-> $s1
#n:$s2
#*p:$a2
	.data
	.text
	.globl fun2


fun2:
	addiu $sp,$sp,-16
	lw $ra,0($sp)
	lw $s0,4($sp)
	lw $s1,8($sp)
	lw $s2,12($sp)
		
	move $a0,$s0 #$a0 = p
	move $a1,$s1 #$a1 = k
	
	li $s2,0 # n = 0
	
while:
	sll $t2,$t2,2
	lw $t2,0($a0) # $t2 = *p
	beq $t2,$a1,endwhile
	
	jal funk #funk(*p,k)
	move $t1,$v0 #$t1= funk(*p,k)
	add $s2,$s2,$t1 # n = n + funk(*p,k)
	addi $a0,$a0,1 # p++
	
	j while
endwhile:

	move $v0,$t0
	
	sw $ra,0($sp)
	sw $s0,4($sp)
	sw $s1,8($sp)
	sw $s2,12($sp)
	addiu $sp,$sp,16
	
	jr $ra
