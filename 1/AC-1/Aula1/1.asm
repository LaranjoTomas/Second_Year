	.data
	
	.text
	.globl	main
	
main: 	ori	$v0,$0,5
	syscall 		# read_int()
	or	$t0, $0, $v0	# $t0 = $v0 (valor lido anteriormente)
	ori	$t2,$0,8
	
	add	$t1,$t0,$t0 # $t1 = $t0 + $t0 = x + x = 2x
	add	$t1,$t1,$t2 # $t1 = 2x + 8
	
	or	$a0, $0, $t1	# $a0 = y
	ori	$v0, $0, 1
	syscall			# print_int10()
	
	jr	$ra