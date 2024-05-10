   	     .data 
   	     .text 
    	     .globl main
    main:    ori $v0,$0,5      # definir syscall como "read_int()"
   	     syscall      # chamada do syscall
  	     or $t0,$0,$v0      # armazenar valor em $t0
       	     nor $t1,$t0,$t0 # nor com o proprio numero
    	     addi $t2,$t1,1  # +1 para complementar o 2 (c2)
    	     or $a0,$0, $t2  # magia negra
    	     ori $v0,$0,34   #definir syscall como "print_int()"
   	     syscall     # chamada ao syscall "print_int()"
   	     jr $ra