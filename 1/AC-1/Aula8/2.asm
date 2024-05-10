#Mapa de Registos:
#$s0: val

    .data

str:    .space 33

    .text
    .globl main

main:    addiu $sp, $sp, -4
    sw $ra, 0($sp)




do:    li $v0, 5
    syscall
    move $s0, $v0

    #Print_str(itoa(val, 2,str))
    move $a0, $s0
    li $a1, 2
    la $a2, str

    jal itoa 

    move $a0, $v0

    li $v0, 4
    syscall


    #print_str(itoa(val,2,str))

    beq $s0, 0, enddo
    j do
enddo:

    lw $ra, 0($sp)
    addiu $sp, $sp, 4

    jr $ra