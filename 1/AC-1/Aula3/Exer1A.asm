	# Mapa de registos:
	# $t0 – soma
	# $t1 – value
	# $t2 - i
 	.data
str1:   .asciiz "Introduza um numero: "
str2:   .asciiz "Valor ignorado"
str3:   .asciiz "A soma dos positivos e': "
 	.eqv print_string,4
 	.eqv read_int,5
 	.eqv adicionar1,1
	.text
 	.globl main
main:   li $t0,0 # soma = 0;
 	li $t2,0 # i = 0;
for:    bge $t2, 5 ,endfor # while(i < 5) {
	la $a0, str1
	li $v0,print_string   
   	syscall	     # print_string("...");
 	li $v0,read_int     # ler do teclado
    	syscall	 # value=read_int();
    	or $t1,$0,$v0
 	ble $t1,$0,else # if(value > 0)
 	add $t0,$t0,$t1 # soma += value;
 	j endif #
else:   la $a0, str2	# else  
	li $v0,print_string    
   	syscall	        # print_string("...");
   	addi $t2,$t2,adicionar1 # i++;
 	j for
   	
endif:  addi $t2,$t2,adicionar1 # i++;
 	j for # }
 	 
endfor:
 	la $a0, str3 # print_string("...");
 	li $v0,print_string
 	syscall
 	or $a0, $0,$t0
 	ori $v0,$0,34
 	syscall # print_int10(soma);
 	jr $ra 