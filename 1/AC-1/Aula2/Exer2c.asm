	.data
str1:   .asciiz "Tomás Laranjo"
	.eqv print_string,4
	.text
	.globl main 
  main: li $t0,0x862A5C1B # instrução virtual (decomposta em duas instruções nativas)
 	srl $t1,$t0,1 # Deslocamento á direita lógico de t0 a 1 bit
 	xor $t2,$t0, $t1 # formua for gray
 	jr $ra # fim do programa