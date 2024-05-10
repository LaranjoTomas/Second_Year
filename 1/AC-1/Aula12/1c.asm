.text
.globl read_data
read_data:
    # st is in $a0, ns is in $a1
    addi $t0, $zero, 0 # Initialize loop counter to 0

loop:
    # Check if loop counter has reached ns
    bge $t0, $a1, exit # If yes, go to exit
    
    # Print "N. Mec: "
    la $a0, str1
    jal print_string
    
    # Read id_number
    jal read_int
    # Store result in st[i].id_number
    sll $t1, $t0, 2 # Multiply i by 4 (size of student struct)
    add $t1, $t1, $a0 # Add offset to st
    sw $v0, 0($t1) # Store read value in id_number field
    
    # Print "Primeiro Nome: "
    la $a0, str2
    jal print_string
    
    # Read first_name
    add $a1, $t1, 4 # Set second argument to address of first_name field
    jal read_string
    
    # Print "Ultimo Nome: "
    la $a0, str3
    jal print_string
    
    # Read last_name
    add $a1, $t1, 18 # Set second argument to address of last_name field
    jal read_string
    
    # Print "Nota: "
    la $a0, str4
    jal print_string
    
    # Read grade
    add $a1, $t1, 32 # Set second argument to address of grade field
    jal read_float
    swc1 $f0, 0($a1) # Store read value in grade field
    
    addi $t0, $t0, 1 # Increment loop counter
    j loop # Go back to start of loop

exit:
    jr $ra # Return

.data
str1: .asciiz "N. Mec: "
str2: .asciiz "Primeiro Nome: "
str3: .asciiz "Ultimo Nome: "
str4: .asciiz "Nota: "