	.data
	.text
	.globl main

main:	li $t0,0x12345678 # instrução virtual (decomposta
	# em duas instruções nativas)
	srl $t1,$t0,1 # (bin >> 1)
	xor $t2, $t0,$t1 #gray = bin ^ (bin >> 1)
	jr $ra # fim do programa