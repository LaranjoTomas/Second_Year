#Mapa de Registos:
#res->$f2
#val->$t0
#0.0->$f4
	.data
k1:	.float 2.59375
	.eqv print_float,2
	.eqv read_int,5
	.text
	.globl main
	
main:
	
do:
	li $v0,read_int
	syscall
	move $t0,$v0
	
	l.s	$f0,k1
	mtc1	$t0,$f6
	cvt.s.w $f6,$f6
	mul.s	$f12,$f6,$f0
	li $v0,print_float
	syscall
	
	sub.s $f4,$f4,$f4
	
enddo:
	c.eq.s $f12,$f4
	bc1f do
	
	
	
end:
	li $v0,0
	jr $ra
	