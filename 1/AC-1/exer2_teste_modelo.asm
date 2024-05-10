	.data
str:	.asciiz "Invalid argc"
	.align 2
av:	.space 60
	.text
	.eqv SIZE,15
	.eqv print_string,5
	.eqv print_int10,1
	.globl func2
	
#Mapa de Registos
#f1:$a0
#k:$a1
#av:$a2
#i:$s3
#res:$t0

func2:	
	addiu $sp,$sp,-20
	sw $ra,0($sp)
	sw $s0,4($sp)
	sw $s1,8($sp)
	sw $s2,12($sp)
	sw $s3,16($sp)
	
	move $s0,$a0
	move $s1,$a1
	move $s2,$a2
	li $t0,-1 #res =-1
	
if:	blt $s1,2,elseif
	bgt $s1,SIZE,elseif
	
	li $s3,2 # i = 2

do:
	sll $t1,$s3,2 #i*4
	addu $t1,$s2,$t1 #$t1=av[i]
	lw $a0,0($t1) # $a0=av[i]
	jal toi
	
	sll $t1,$s3,2 # i*4
	addu $t1,$s0,$t1 # $t1=fl[i]
	sw $v0,0($t1) #$fl[i]=toi(av[i])
	
	addi $t1,$t1,1 # i++
	bge $s3,$s1,elseif # while (i<k)
	j do

enddo:	
	move $a0,$s0
	move $a1,$s1
	jal avz #avz(fl, k)
	
	move $t0,$v0 #res = avz(fl, k)
	
	move $a0,$t0
	li $v0,print_int10
	syscall
	
	
elseif:
	la $a0,str
	li $v0,print_string
	syscall
	
end:
	move $v0,$t0
	
	lw $ra,0($sp)
	lw $s0,4($sp)
	lw $s1,8($sp)
	lw $s2,12($sp)
	lw $s3,16($sp)
	addiu $sp,$sp,20
	
	jr $ra
	
	
	