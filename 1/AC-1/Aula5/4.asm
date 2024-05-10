# Mapa de registos
# ...
# houve_troca: $t4
# p: $t5
# pUltimo: $t6
# p*:$t7
# pUltimo*:$t8
	.data
lista:	.word 8,-4, 3, 5, 124, -15, 87, 9, 27, 15	# a diretiva ".word" alinha num endereço
 							# múltiplo de 4
str1: 	.asciiz "; "
str2: 	.asciiz "\nConteudo do array:\n"
str3:	.asciiz "\n"
	.eqv FALSE,0
 	.eqv TRUE,1
	.eqv print_int10,1
 	.eqv print_string,4
	.eqv SIZE,10
	.eqv SIZEless1,9
	.text
	.globl main
main:	
	la $a0, str2 # print_string("Conteudo do array: ")
 	li $v0, print_string
 	syscall # codigo para leitura de valores
	
	la $t5,lista # $t5 = &lista[0]
	li $t6,SIZE # $t6 = SIZE
	
	subu $t6,$t6,1 # $t6 = SIZE – 1
	sll $t6,$t6,2 # $t6 = (SIZE – 1) * 4
	addu  $t6,$t5,$t6 # $t6 = lista + (SIZE – 1)
	lb $t7,0($t5) #*P

while1: bgeu $t5,$t6,do # while(p < lista+(SIZE-1)) {
 	lb $t7,0($t5) #*P
 	
 	
 	move $a0, $t7 # print_int10( *p );
 	li $v0, print_int10
 	syscall
 	la $a0, str1 # print_string(...);
 	li $v0, print_string
 	syscall
 	addiu $t7,$t7, 4 # p++;
 	addiu $t5,$t5, 4
 	j while1 # }		


do:	li $t4,FALSE   # do {
	la $t5,lista # $t5 = &lista[0]
	
for:	bgeu $t5,$t6,end#  p < pUltimo
	
	
if:	bgeu $t5,$t6,end
 	addu $t7,$t7,$t6 # $t7 = *p = aux
 	lw $t8,0($t6) # $t8 = *p
 	lw $t9,4($t6) # $t9 = *(p+1)
 	ble $t8,$t9,endif # if(*p > *(p+1=){
 	sw $t8,4($t6) # *(p+1) = $t8
 	sw $t9,0($t6) # *p = $t9
 	li $t4,TRUE #

endif: 	addi $t5, $t5, 1 # p++;
 	addi $t6, $t6, 4 # }
	j for
	
pint:	
 	bgeu $t5,$t6,end # while(p < lista+SIZE) {
 	lb $t7,0($t5) #*P

 	move $a0, $t7 # print_int10( *p );
 	li $v0, print_int10
 	syscall
 	la $a0, str1 # print_string(...);
 	li $v0, print_string
 	syscall
 	addiu $t5,$t5, 4 # p++;
 	j pint # }
	
end: jr $ra
