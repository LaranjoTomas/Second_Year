
# p : $t1
# pultimo: $t2
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
	la $t1,array # $t1 = p = &array[0] = array
 	li $t0,SIZE # i = size
 	sll $t0,$t0,2 # size * 4 
 	addu $t2,$t1,$t0 # $t2 = pultimo = array + SIZE


for:  	bge $t1, $t2,end
	
	
	lw $a0,0($t1)
	li $v0,print_string
     	syscall 
    	addiu $t1, $t1, 4
    	j for
    	
end:	jr $ra