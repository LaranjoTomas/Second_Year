#Mapa de registos:
#i:$t0
#lista:$t1
#lista+i:$t2
#houve_troca : $t4
# p: $t5
# lista : $t6
# lista+i: $t7 s
	.data
	.eqv FALSE,0
	.eqv TRUE,1
	.eqv SIZE,10
	.eqv print_string,4
	.eqv print_int10,1
	.eqv read_int,5
	.eqv SIZEless1,9
	.eqv print_char,11
str:	.asciiz "\nDigite o seu numero\n"
str1:	.asciiz ","
	.align 2
str2:	.ascii "\nConteudo do array: \n"
lista:	.space SIZE
	.text
	.globl main
main:
	li $t0,0 #i = 0

for:	bge $t0,SIZE,endfor # i < size-1
	
	la $a0, str
    	li $v0, print_string
    	syscall # print_string("digite o seu numero")

    	li $v0,read_int
    	syscall #read_int()
	
	la $t1, lista # lista=lista
	sll $t2,$t0,2 # i * 4
	addu $t2,$t2,$t1 # $t2 = lista 
	sw $v0, 0($t2) # $v0 = lista (i)

    	addi $t0,$t0,1 # i++
    	j for
    	
endfor:	la $t6,lista


do:
	li $t4, FALSE #houve troca = false
    	li $t5, 0 # p = 0
    	li $t3, SIZE # $t3 = size
    	addiu $t3,$t3,1 # $t3= size-1
	

for2:	bge $t5,$t3,endwhile #  i < SIZE-1

if:	sll $t7,$t5,2 # p *4
	addu $t7,$t7,$t6 #lista(i+1)
	
	lw $t8,0($t7) # aux = lista(i)
	lw $t9,4($t7) # lista[i] = lista[i+1]
	ble $t8,$t9,endif #lista[i] > lista[i+1
	sw $t9,0($t7) # lista[i+1] = aux; 
	sw $t8,4($t7) #
	li $t4,TRUE #houveTroca = TRUE; 
	j endif

endif:
	addi $t5,$t5,1
	j for2

endwhile:
	bne $t4,TRUE,while2
	j do
	
while2:
	la $a0,str2
	li $v0,print_string	
	syscall
	
	la $t0, lista # $t0 = lista
    	li $t2, SIZE # $t2=SIZE
    	sll $t2, $t2, 2
    	addu $t2,$t2,$t0 

for3:	bgeu $t0,$t2,end # i < SIZE
	
	lw $t1,0($t0)
	
	move $a0,$t1
	li $v0,print_int10
	syscall
	
	#li $v0,print_string
	#la $a0,str1
	li $v0, print_char
	li $a0, ','
	syscall
	
	addiu $t0,$t0,4 # i++
	j for3


end:	jr $ra	
