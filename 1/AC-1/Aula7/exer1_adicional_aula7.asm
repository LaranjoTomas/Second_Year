	.data
	.eqv print_int10,1
	.eqv print_string,4
	.eqv read_int,5
str:	.asciiz ", "
str1:	.asciiz "Size of array: "
str2:	.asciiz "array["
str3:	.asciiz "] = "
str4:	.asciiz "Enter the value to be inserted: "
str5:	.asciiz "Enter the position: "
str6:	.asciiz "\nOriginal array: "
str7:	.asciiz "\nModified array: "
array:	.space 200
	.text
	.globl main
insert:
	move $t0,$a0			# t0 = array
	move $t1,$a1			# t1 = value
	move $t2,$a2			# t2 = pos
	move $t3,$a3			# t3 = size
	
if:
	ble $t2,$t3,else
	li $v0,1
	j endif
	
else:
	addiu $t4,$t3,-1		# $t4 = i = size-1
for:	
	blt $t4,$t2,endfor		
	sll $t5,$t4,2			# i*4
	addu $t0,$t0,$t5		# &array[i]
	lw $t6,0($t0)			# $t6 = array[i]
	sw $t6,4($t0)			# array[i+1] = array[i]
	addiu $t4,$t4,-1
	
	j for
	
endfor:
	sll $t5,$t2,2			# pos*4
	addu $t0,$t0,$t5
	sw $t1,-4($t0)			#array[pos] = value
	
	li $v0,0			# return 0
	
endif:
	jr $ra
	
##############################################################################################

print_array:
	move $t0,$a0			#$t0=&a
	move $t1,$a1			#$t1=n
	
	sll $t1,$t1,2			#$t1=n*4
	
	addu $t2,$t1,$t0		#p=&(a+n)
	
for2:
	bge $t0,$t2,endfor2
	
	lw $a0,0($t0)
	li $v0,print_int10
	syscall
	
	la $a0,str
	li $v0,print_string
	syscall
	
	addi $t0,$t0,4			#a++		
	j for
	
endfor2:
	jr $ra
	
###############################################################################################
#Mapa de Registos:
#array: $a0->$s0
#insert_value: $a2->$s2
#insert_pos: $a3->$s3
#array_size: $a1->$s1



main:
	addiu $sp, $sp,-20
	sw $ra,0($sp)
	sw $s0,4($sp)
	sw $s1,8($sp)
	sw $s2,12($sp)
	sw $s3,16($sp)
	
	la $t4,array
	
	la $a0,str1
	li $v0,print_string
	syscall
	
	li $v0,read_int
	syscall
	move $s1,$v0
	
	li $t0,0
	
for3:
	bge $t0,$s1,endfor3
	
	la $a0,str2
	li $v0,print_string
	syscall
	
	move $a0,$t0
	li $v0,print_int10
	syscall
	
	la $a0,str3
	li $v0,print_string
	syscall
	
	li $v0,read_int
	syscall
	
	sll $t1,$t0,2			#i*4
	addu $t2,$t4,$t1
	sw $v0,0($t2)			#array[i] = read_int()
	
	addiu $t0,$t0,1
	j for3
	
endfor3:
	la $a0,str4
	li $v0,print_string
	syscall
	
	li $v0,read_int
	syscall
	move $s2,$v0
	
	la $a0,str5
	li $v0,print_string
	syscall
	
	li $v0,read_int
	syscall
	move $s3,$v0
	
	la $a0,str6
	li $v0,print_string
	syscall
	
	move $a0,$s0
	move $a1,$s1
	jal print_array
	
	
	move $a0,$s0
	move $a1,$s2
	move $a2,$s3
	move $a3,$s1
	jal insert
	
	la $a0,str7
	li $v0,print_string
	syscall
	
	move $a0,$s0
	addi $a1,$s1,1
	jal print_array
	
	li $v0,0
	
	
	lw $ra,0($sp)
	lw $s0,4($sp)
	lw $s1,8($sp)
	lw $s2,12($sp)
	lw $s3,16($sp)
	addiu $sp, $sp,20
	jr $ra