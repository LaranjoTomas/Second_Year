#Mapa de Registos:
#a:$a0
#N:$a1
#b:$a2
#k:$t0
#p:$t1
	.data
k1:	.double 2.0
	.text
	.globl fun1
fun1:
	li 	$t0,0			#k = 0
	move 	$t1,$a0			#p = a
	sll     $t2,$a1,3
	addu	$t2,$a0,$t2		# a + N
	lw	$t4,0($t2)		# *p
for:
	bge 	$t1,$t2,endfor
	l.d	$f2,k1
	l.d	$f0,0($t1)
	div.d	$f4,$f0,$f2		#*p/2.0
	
	sub.d	$f6,$f6,$f6 		#$F6 = 0

if:
	c.eq.d	$f4,$f6
	bc1t else                      # if (( *p/2.0)!=0.0);
	
	s.d     $f0,0($a2)             #*b = *p;
	addiu   $a2,$a2,8              #b++;
	
	j endif	
else:
	addiu 	$t0,$t0,1			#k++
endif:
	addi	$t1,$t1,8			#p++
	j for
endfor:
	sub	$v0,$a1,$t0
	jr $ra
