	.data
	.eqv id_number,0
	.eqv first_name,4
	.eqv last_name,22
	.eqv grade,40
	.eqv read_float,6
	.eqv read_string,8
	.eqv print_intu10,36
	.eqv read_int,5
	.eqv print_float,2
	.eqv print_string,4
max_grade:	.float -20.0
sum:	.float 0.0
str:	.asciiz "nMedia: "
str1:	.asciiz "N. Mec: "
str2:	.asciiz "Primeiro Nome: "
str3:	.asciiz "Ultimo Nome: "
str4:	.asciiz "Nota: "
	.eqv MAX_STUDENTS,4
	.align 2
st_array:	.space 16
media:	.space 4  #média é um ponteiro e como é float é 4
	.text
	.globl main
	
#Mapa de Registos:
#st_array:$a0
#MAX_STUDENTS:$a1
#&media:$a2
#pmax:$s0

main:
	addiu $sp,$sp,-8
	sw $ra,0($sp)
	sw $s0,4($sp)
	
	la $a0,st_array			# $a0=st_array
	li $a1,MAX_STUDENTS		# $a1=MAX_STUDENTS
	
	jal read_data
	
	la $a0,st_array			# $a0=st_array
	li $a1,MAX_STUDENTS		# $a1=MAX_STUDENTS
	la $a2,media			# $a2=&media
	jal max
	move $s0,$v0			# $s0=pmax
	
	la $a0,str
	li $v0,print_string
	syscall
	
	la $t0,media
	l.s $f12,0($t0)
	li $v0,print_float		# $f12 pois print_float é em f12 não $a0
	syscall
	
	move $a0,$s0
	jal print_student
	
	li $v0,0
	
	lw $ra,0($sp)
	lw $s0,4($sp)
	addiu $sp,$sp,8
	jr $ra
	
#############################################################################################
#Mapa de registos:
#st: $a0
#ns: $a1


read_data:
	li $t0,0			#i = 0
	move $t4,$a1
	move $t1,$a0
	
for:
	bge $t0,$t4,endfor
	
	la $a0,str1
	li $v0,print_string
	syscall
	
	
	li $v0,read_int
	syscall				#read_int()
	mul $t2,$t0,44			#i * 44
	addu $t2,$t1,$t2		#$t2=st[i]
	lw $v0,id_number($t2)		#st[i].id_number = read_int()
	
	la $a0,str2
	li $v0,print_string
	syscall
	
	addiu $a0,$t2,first_name		#st[i].first_name
	li $a1,17
	li $v0,read_string
	syscall
	
	la $a0,str3
	li $v0,print_string
	syscall
	
	addiu $a0,$t2,last_name		#st[i].first_name
	li $a1,14
	li $v0,read_string
	syscall
	
	la $a0,str4
	li $v0,print_string
	syscall
	
	li $v0,read_float
	syscall
	
	s.s $f0,grade($t2)
	
	addi $t0,$t0,1			#i++
	
	j for
	
endfor:
	jr $ra
	
	
#############################################################################################
#Mapa de Registos:
#max_grade:$f2
#sum : $f4
#p:$t0
#
max:
	move $t3,$a2			#$t3=media
	move $t0,$a0			#p = st
	addu $a0,$a0,$a1		#st + ns
	
	la $t1,max_grade
	l.s $f2,0($t1)			#mag_grade = -20.0
	
	la $t1,sum
	l.s $f4,0($t1)			#sum = 0.0
	
for2:	
	bge $t0,$a0,endofor2
	l.s $f6,grade($t0)
	add.s $f4,$f4,$f6
	
if:	
	c.le.s $f6,$f2
	bc1t endif1
	
	mov.s $f2,$f6
	move $t1,$t0
	
endif1:
	addi $t1,$t1,44
	j for2
	
endofor2:
	mtc1 $a1,$f8 		#transformar ns para float
	cvt.s.w $f8,$f8		# (float)ns
	div.s $f8,$f4,$f8	#sum /(float)ns
	s.s $f8,0($t3)		#&media = sum/(float)ns
	move $v0,$t1		#return pmax
	jr $ra
	
##############################################################################################

print_student:
	move $t0,$a0
	
	lw $a0,id_number($t0)
	li $v0,print_intu10
	syscall
	
	lw $a0,first_name($t0)
	li $v0,print_string
	syscall
		
	lw $a0,last_name($t0)
	li $v0,print_string
	syscall
	
	l.s $f12,grade($t0)
	li $v0,print_float
	syscall
	
	jr $ra