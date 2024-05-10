#Mapa de Registos:
#p:$s0->$a0
#k:$s1->$a1
#n:$s2->$a2
#*p:$t0
	.data
	.text
	.globl	fun2
	
fun2:
	addiu	$sp,$sp,-16
	sw	$ra,0($sp)
	sw	$s0,4($sp)
	sw	$s1,8($sp)
	sw	$s2,12($sp)
	
	move 	$s0,$a0		#$s0=p
	move	$s1,$a1		#$s1=k
	li	$s2,0		#n=0
	
	lw	$t0,0($s0)	#$t0=*p
while:
	beq	$t0,$s1,endwhile	#*p!=k
					
	move	$a0,$s0
	move	$a1,$s1
	jal funk		#funk(*p,k)
	
	add	$s2,$s2,$v0	#n=n+funk(*p,k)
	addi	$s0,$s0,4	#p++
	
	j while

endwhile:
	move	$v0,$s2
	
	lw	$ra,0($sp)
	lw	$s0,4($sp)
	lw	$s1,8($sp)
	lw	$s2,12($sp)
	addiu	$sp,$sp,16
	
	jr	$ra