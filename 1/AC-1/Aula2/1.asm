.data
 .text
 .globl main
main:	
	ori	$v0,$0,5
	syscall 		# read_int()
	or	$t0, $0, $v0	# $t0 = $v0 (valor lido anteriormente) substituir val_1 valores de entrada desejados

	ori	$v0,$0,5
	syscall 		# read_int()
	or	$t1, $0, $v0	# $t0 = $v0 (valor lido anteriormente) substituir val_2 valores de entrada desejados

	and $t2,$t0,$t1 # $t2 = $t0 & $t1 (and bit a bit)
	or $t3, $t0, $t1 # $t3 = $t0 | $t1 (or bit a bit)
	nor $t4,$t0,$t1  # $t4 = ~($t0 | $t1)
	xor $t5,$t0,$t1 #  $t5 = $t0 xor $t1
 jr $ra # fim do programa
