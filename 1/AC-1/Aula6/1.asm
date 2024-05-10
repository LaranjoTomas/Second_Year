#Mapa de registos:
# i: $t0
#
 	.eqv SIZE,3
 	.data
array:	.word str1,str2,str3
str1: 	.asciiz "Array\n"
str2: 	.asciiz "de\n"
str3: 	.asciiz "ponteiros\n"
 	.eqv print_string, 4
 	.text
 	.globl main
main:
	li $t0,0 # i = 0
	
for: 	bge $t0, SIZE, end
 	
 	la $t1,array # $t1 = &array[0]
 	sll $t2,$t0,2 #
 	addu $t2,$t2,$t1 # $t2 = &array[i]
 	lw $a0,0($t2) # $a0 = array[i]
 	li $v0,print_string
     	syscall 
    	addi $t0, $t0, 1
    	
 	j for
 	
end:	jr $ra