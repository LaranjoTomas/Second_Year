	.data
	.text
 	.globl main
  main: ori $v0,$0,5     # ler do teclado
    	syscall     # chamada ao syscall "read_int()"
    	or $t0,$0,$v0     # $t0 = $v0 = valor lido do teclado (valor de x pretendido)
    	add $t1,$t0,$t0 # 
    	sub $t2,$t0,$t1 # 
    	or $a0,$0,$t2     # $a0 = y
   	ori $v0,$0,34     #
   	syscall     # chamada ao syscall "print_int10()"
    	jr $ra      # fim do programa