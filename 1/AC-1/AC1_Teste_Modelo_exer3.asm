	.data
oldg:	.float -1.0
g:	.float -1.0
s:	.float 0.0
	.text
	.globl func3
# Mapa de registos
# a:    $a0
# t:    $f12
# n:    $a1
# oldg: $f0
# g:    $f2
# s:    $f4
# k:	$f6
	
func3:
	la	$t1,oldg
	l.s	$f0,0($t1)		#float oldg = -1.0
	
	la	$t1,g
	l.s	$f2,0($t1)		#float g = 1.0
	
	la	$t1,s
	l.s	$f4,0($t1)		#float s = 0.0
	
	li 	$t0,0			#k = 0
	
for:
	bgt	$t0,$a1,endfor		#k < n
	
while:
	sub.s 	$f8,$f2,$f0		#(g - oldg)
	
	c.le.s	$f8,$f12
	bc1t	endw
	
	mov.s	$f0,$f2
	
	sll	$t1,$t0,2		#k*4
	addu	$t1,$a0,$t1		#&a[k]
	
	l.s	$f8,0($t1)		#$f8=a[k]
	
	div.s	$f8,$f8,$f12		#a[k] / t
	add.s	$f2,$f2,$f8		#g = (g + a[k] / t);
        
        j while
        
endw:
	add.s	$f4,$f4,$f2		#s = s + g;
	
	s.s	$f2,0($t1)		#a[k] = g;
	
	j for
	
endfor:
	mtc1	$a1,$f0
	cvt.s.w	$f0,$f0			#(float) n;
	
	div.s	$f0,$f4,$f0		#s / (float) n;
	
	jr $ra