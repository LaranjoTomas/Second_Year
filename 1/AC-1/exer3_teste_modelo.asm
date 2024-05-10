# Mapa de registos
# a:    $a0
# t:    $f12
# n:    $a1
# oldg: $f2
# g:    $f4
# s:    $f6
# k:	  $t0

	.data
oldg:	.float -1.0
g:	.float 1.0
s:	.float 0.0
	.text
	.globl func3
	
	
func3:
	l.s $f2,oldg
	l.s $f4,g
	l.s $f6,s
	li $t0,0
	
for:
	bge $t0,$a1,endfor
	add.s $f8,$f4,$f2

while:	c.le.s $f8,$f12,
	bc1t endwhile

	mov.s $f2,$f4              #oldg = g;
	sll $t1,$t0,2
	addu $t1,$a0,$t1         #a[k]
	lw $t1,0($t1)             #$t1 = a[k]
	add.s $f4,$f4,$f3         # g + a[k]
	div.s $f4,$f4,$f12        #g = (g + a[k] / t);
	
	j while
	
endwhile:
	add.s $f6,$f6,$f4         #s = s + g;
	s.s $f4,0($t1)            #a[k] = g;
	addi $t0,$t0,1            #k++
	j for

endfor:
	move $t3,$a1
	mtc1 $t3,$f2		   #
	cvt.s.w	$f2,$f2		   #(float) n;
	div.s $f0,$f6,$f2
	
	jr $ra





	.globl main
main:
	jr $ra