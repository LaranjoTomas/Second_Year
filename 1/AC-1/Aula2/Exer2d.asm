	.data
str1:   .asciiz "Tomás Laranjo"
	.eqv print_string,4
	.text
	.globl main 
  main: li $t0,2 # instrução virtual (decomposta em duas instruções nativas)
 	srl $t1,$t0,4 # Deslocamento á direita lógico de t0 a 1 bit
 	xor $t2,$t0,$t1 # t1= (t0 >> 4) || t0= num = gray
 	srl $t3,$t2,2 # t3=  (t2 >> 2) || t2=  t0 ^ (t0 >> 4)
 	xor $t4,$t3,$t2 # t4 = (t2 ^ (t2 >> 2) || t5 =  (t4 >> 1)
 	srl $t5,$t4,1 # t6 = t4 ^ (t4 >> 1)
 	xor $t6,$t4,$t5 # formula for binary from gray
 	jr $ra # fim do programa