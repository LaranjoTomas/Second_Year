	.data
	.text
	.globl main

main:	li $t0,2 # instrução virtual
	srl $t1,$t0,4 # (num >> 4)
	xor $t0,$t0,$t1 # num = num ^ (num >> 4); 
	srl $t1,$t0,2 # (num >> 2)
	xor $t0,$t0,$t1 #gray = bin ^ (bin >> 2)
	srl $t1,$t0,1 # (num >> 1)
	xor $t0,$t0,$t1 # num = num ^ (num >> 1);
	move $t2,$t0 # bin = num
	jr $ra # fim do programa