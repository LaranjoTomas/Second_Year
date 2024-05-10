# Mapa de registos
	# i: $t0
	# num: $t1
	# str: $t2
	# str+i: $t3
	# str[i]: $t4
	.data
	.eqv SIZE,20
	.eqv SIZEmais1,21
	.eqv read_string,8
	.eqv print_int10,36
str:	.space SIZEmais1
	.text
	.globl main
main:	la $a0,str # $a0=&str[0] (endereço da posição 0 do array, i.e., endereço inicial do array)
	li $a1,SIZE # $a1=SIZE
	li $v0,read_string
	syscall # read_string(str,SIZE)
	li $t0, 0 #  i=0; 
	li $t1, 0 #  num=0;
	la $t2,str
while:  addu $t3,$t2,$t1# while(str[i] != '\0')
	lb $t4,0($t3) # 
	beq  $t4,$0,endw # {
	bgt $t4,'0',if
	bgt $t4,'9',if
	addi $t0,$t0,1
	
if:	addi $t1,$t1,1 # i++;
	j while

endw:   move $a0,$t1	# else  
	li $v0,print_int10    
   	syscall	  # print_int10(num);
	jr $ra # termina o programa 
