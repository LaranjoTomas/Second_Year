#Mapa de Registos:
# n_even : $t0
# n_odd : $t1
# p1 : $t2
# p2 : $t4

       .data
       .eqv N,35
       .eqv read_int,5
       .eqv print_int10,1
a:     .space N
B:     .space N
       .text
       .globl main
       
main:  
       li $t0,0 # n_even = 0
       li $t1,0 # n_odd = 0
       
       la $t2, a # p1=a
       
       
       addi $t3,$t2,N # a + N
       
for:   bge $t2,$t3,endfor # p1 < (a + N)

       li $v0,read_int
       syscall 
       sb $v0,0($t2) # *p1 = read_int 
       
       addi $t2,$t2,1
       j for
       
endfor:
       la $t2,a # p1 = a
       la $t4, B # p2=B
       addi $t3,$t2,N # a + N
       
for2:  bge $t2,$t3,endfor2 # p2 < (a + N)
       
       lb $t5,0($t2) # $t5 = *p1
       rem $t6,$t5,2 # *p1 % 2
       lb $t7, 0($t4) # $t7 = *p2
       
if:    beqz $t6,else # (*p1 % 2)) != 0
       sb $t5,0($t4) # *p2 = *p1
       addi $t4,$t4,1 # *p2++
       addi $t1,$t1,1 #n_odd++
       j endif
else:  addi $t0,$t0,1 # n_even++

endif: addi $t2,$t2,1 # p1++
       j for2

       
endfor2: la $t4,B #p2=B   
         add $t5,$t4,$t1 # $t5 = b + n_odd
         
for3:    bge $t4,$t5,endfor3 # p2 < (b + n_odd)
         lb $t7,0($t4) # $t7 = *p2
         
         move $a0,$t7
         li $v0,print_int10    
         syscall # print_int10(*p2)
         addi $t4,$t4,1 # p2++
         j for3

endfor3: 
         j end
         
end:     jr $ra # end
   