	.data
	.eqv	SIZE,8
	.eqv	read_int,5
	.eqv	print_string,4
	.eqv	print_int10,1
list:	.space	32
str:	.asciiz	"Media invalida!\n"
	.text
	.globl	main
# Mapa de registos
#  rv : $v0
#  n  : $t1
#  sum: $t2
#  nit: $t3
#  pt : $t4
# *pt : $t5
# list+SIZE: $t6

main:
	li	$t2,0		#sum=0
	li	$t3,0		#nit=0
	la	$t4,list	#$t4=list
	addiu	$t6,$t4,32	#$t6=List+SIZE	

for:
	bge	$t4,$t6,endfor	#pt < (list + SIZE)
	
	li $v0,read_int
	syscall
	sw	$v0,0($t4)	#*pt = read_int()
	
	addi	$t4,$t4,4	#pt++
	j for
	
endfor:
	li	$t1,0		#n=0
	la	$t4,list	#$t4=list
	
for2:
	bge	$t1,SIZE,endfor2	#n < SIZE
	sll	$t5,$t1,2		#n*4
	addu	$t5,$t4,$t5		#&list[n]
	lw	$t6,0($t5)		#$t6 = list[n]
if:
	blez	$t6,endif		#if (list[n] >= 0)
	add	$t2,$t2,$t6		#sum += list[n];
	addi	$t3,$t3,1		#nit++
	
endif:
	addi	$t1,$t1,1		#n++
	j for2
	
endfor2:
	
if2:
	blez	$t3,elseif		#if (nit > 0)
	div	$a0,$t2,$t3
	li	$v0,print_int10
	syscall				#print_int10(sum / nit)
	
	li $v0,0			#rv = 0
	
	j end
	
elseif:
	la	$a0,str
	li	$v0,print_string
	syscall				#print_string("Media invalida!\n");
	
	li $v0,-1			#rv = -1
end:
	jr $ra
