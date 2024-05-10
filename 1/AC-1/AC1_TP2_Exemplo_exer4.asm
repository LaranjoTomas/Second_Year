# typedef struct {       Align  	SIZE		OFFset
# char name [50];	   1		 50		   0
# int num;		   4		 4		50->52
# float grade;		   4		 4		  56
# char type		   1		 1		  60
# } student;		   4	        61 -> 64   ////////////////

	.data
	.eqv print_string,4
	.eqv print_float,2
std:	.asciiz "Rei Eusebio"
	.space 40 # 52-11-1
	.word 12345
	.float 17.2
	.byte 'F'
	.space 3
	.asciiz "Rainha Amalia"
	.space 38   #52-13-1
	.word 23450
	.float 12.5
	.byte 'C'
	
k1:	.float 2.0
	.text
	.globl main
#Mapa de Registos:
#std : $s0->$a0
#n   : $s1->$a1
#i   : $t0
#sum : $f0

fun3:
	sub.s $f0,$f0,$f0                 #float sum = 0.0;
	li    $t0,0                       # int i = 0;
	
	move $t2,$a0
for:
        bge $t0,$a1,endfor                #for ( i < n);
        sll $t1,$t0,6			   # i é multiplicado pelo offset 64 = 2^6
        addu $t1,$a0,$t1		   #&std[i];
        
        addiu $a0,$t1,0
        li $v0,print_string
        syscall                           #print_string(std[i].name);
        
        l.s $f12,56($t1)
        li  $v0,print_float
        syscall                            #print_float(std[i].grade);
        
        add.s $f0,$f0,$f12
        
        addi $t0,$t0,1			    #i++;
        j for
        
        
endfor: 

	la    $t0,k1
	l.s   $f2,0($t0)
	div.s $f0,$f0,$f2
	
	jr $ra
	
	
##############################################################################################

main:
	addiu $sp,$sp,-4
	sw $ra,0($sp)
	
	la $a0,std
	li $a1,2
	jal fun3
	mov.s $f12,$f0
	li $v0,print_float
	syscall
	
	li $v0,-1
	
	lw $ra,0($sp)
	addiu $sp,$sp,-4
	jr $ra