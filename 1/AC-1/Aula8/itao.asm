# Mapa de registos
# n: $a0 -> $s0
# b: $a1 -> $s1
# s: $a2 -> $s2
# p: $s3
# digit: $t0
# *p : $t1
# Sub-rotina intermédia
	.data
	.text
	.globl itao


# Mapa de registos
# n: $a0 -> $s0
# b: $a1 -> $s1
# s: $a2 -> $s2
# p: $s3
# digit: $t0

# Sub-rotina intermédia
    .data
    .text
    .globl itao

itao:     addiu $sp,$sp, -16 # reserva espaço na stack
     sw $s0,0($sp) # guarda registos $sx e $ra
    sw $s1,4($sp)
    sw $s2,8($sp)
    sw $s3,12($sp)
    sw $ra,16($sp)


     move $s0,$a0 # copia n, b e s para registos
     move $s1,$a1 #b
     move $s2,$a2 #s


     move $s3,$a2 # p = s;
do: # do {
    rem $t0, $s0, $s1
     div $s0, $s0, $s1 #

     move $a0, $t0
     jal toascii

     sb $v0, 0($s3)
     addi $s3, $s3, 1

     bgt $s0,$0, do
     # } while(n > 0);

endw:     sb $0,0($s3) # *p = 0;

     move $a0, $s2 #
     jal strrev # strrev( s );
    #move $v0, $v0 # return s;
    move $v0, $s2



     lw $s0,0($sp) # guarda registos $sx e $ra
    lw $s1,4($sp)
    lw $s2,8($sp)
    lw $s3,12($sp)
    lw $ra,16($sp) # liberta espaço na stack
    addiu $sp,$sp, 16
     jr $ra #
