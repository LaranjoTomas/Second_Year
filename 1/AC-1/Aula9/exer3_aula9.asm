	.data
	.eqv read_int,5
	.eqv print_double,3
	.eqv SIZE,10
k1:	.double 0.0
a:	.space 80
	.text
	.globl average
	
#Mapa de Registos:
#&array:$s0->$f0
#n:$s1->$a1
#i:$t0
#sum:$f2

average:
	la 	$t0,k1
	l.d	$f0,0($t0)
	move	$t0,$a0
	move 	$t1,$a1			#$t0=n
	
for:
	blez 	$t1,endfor
	
	addiu 	$t3,$t1,-1
	sll 	$t3,$t3,3
	
	addu	$t2,$t0,$t3
	l.d	$f2,0($t2)
	add.d	$f0,$f0,$f2
	
	addi 	$t1,$t1,-1
	j for

endfor:
	mtc1	$a1,$f4
	cvt.d.w	$f4,$f4
	div.d 	$f0,$f0,$f4
	jr	$ra

##############################################################################################
#Mapa de Registos:
#$t0:i
#$a1:SIZE
#a:$a0
	.globl main	
main:
	addiu 	$sp,$sp,-4
	sw	$ra,0($sp)
	
	li 	$t0,0
	la 	$t1,a
for1:
	bge	$t0,SIZE,endfor1
	sll	$t2,$t0,3
	addu	$t3,$t1,$t2
	li 	$v0,read_int
	syscall
	
	mtc1	$v0,$f2
	cvt.d.w	$f2,$f2
	
	s.d	$f2,0($t3)
	
	addiu	$t0,$t0,1
	j for1
	
endfor1:
	la	$a0,a
	li	$a1,SIZE
	jal	average
	
	mov.d	$f12,$f0
	li	$v0,print_double
	syscall
	
	li	$v0,0
	lw	$ra,0($sp)
	addiu 	$sp,$sp,4
	jr $ra