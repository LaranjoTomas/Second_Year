	.data
	.text
	.globl atoi
atoi: 	li 	$v0,0 # res = 0;

while: 	lb 	$t0,0($a0) # while(*s >= ...)
 	blt 	$t0,'0', endw# (*s >= '0')
 	bgt 	$t0,'9', endw # (*s <= '9')
 	sub 	$t1,$t0,'0' # digit = *s – '0'
 	addiu 	$a0,$a0,1 # s++;
 	mul   	$v0,$v0,10 # res = 10 * res;
 	addu  	$v0,$v0,$t1 # res = 10 * res + digit;
 	j while # }
 	
endw:	
 	jr $ra # termina sub-rotina