# Mapa de registos
# f1 :  $a0->$s0
# k  :  $a1->$s1
# av :  $a2->$s2
# i  :  $s3
# res:  $t0
	.data
	.eqv print_int10,1 
	.eqv print_string,4
	.eqv SIZE,15
str:	.asciiz "Invalid argc"
av:	.space 60
	.text
	.globl	func2
	
func2:
	addiu $sp,$sp,-20
	sw $ra,0($sp)
	sw $s0,4($sp)
	sw $s1,8($sp)
	sw $s2,12($sp)
	sw $s3,16($sp)
	li $t0,-1			#int res = -1;
	
	move $s0,$a0
	move $s1,$a1
	move $s2,$a2
	
	
if:	
	blt $s1,2,elseif		#(k >= 2)
	bgt $s1,15,elseif		#(k <= SIZE)
	li $s3,2			#i = 2
	
do:
	sll $t1,$s3,2			#i*4
	addu $t1,$s2,$t1		#&av[i]
	
	lw $a0,0($t1)
	jal toi
	
	sll $t1,$s3,2			#i*4
	addu $t1,$s0,$t1		#&fl[i]
	
	sw $v0,0($t1)
	
	addi $s3,$s3,1			#i++
	
	blt $s3,$s1,do
	
enddo:
	move $a0,$s0
	move $a1,$s1
	jal avz				# avz(fl, k);
	
	move $t0,$v0			#res = avz(fl, k);
	
	move $a0,$t0
	li $v0,print_int10
	syscall				#print_int10(res);
	
	j end
	
elseif:
	la $a0,str
	li $v0,print_string
	syscall				#print_string("Invalid argc");
	
	
end:
	move $v0,$t0
	
	lw $ra,0($sp)
	lw $s0,4($sp)
	lw $s1,8($sp)
	lw $s2,12($sp)
	lw $s3,16($sp)
	addiu $sp,$sp,20
	
	jr $ra