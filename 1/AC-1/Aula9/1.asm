# res-$f2: val-$t0
	.eqv read_int,5
	.eqv print_float,2
	
	.data
k1:	.float 2.59375
k2:	.float 0.0
	.text
	.globl doublef2c
doublef2c:

do: 	li $v0,read_int
	syscall
	move $t0,$v0
	l.s $f2,k1
	mtc1 $t0,$f0
	cvt.s.w $f0,$f0
	mul.s $f2,$f2,$f0
	mov.s $f12,$f2
	li $v0,print_float
	syscall
	l.s $f4,k2
	c.eq.s $f4,$f2
	bc1t fin
	j do
	
	
fin:	li $v0,0
	jr $ra
	