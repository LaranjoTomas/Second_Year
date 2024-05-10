# typedef struct
# {
#  unsigned int id_number;
#  char first_name[18];
#  char last_name[15];
#  float grade;
# } student;
#define MAX_STUDENTS 4

#define MAX_FIRST_NAME_LEN 18
#define MAX_LAST_NAME_LEN 15

#define student_size (4 + MAX_FIRST_NAME_LEN + MAX_LAST_NAME_LEN + 4)

.data
    .eqv MAX_STUDENTS,4
    .eqv MAX_FIRST_NAME_LEN, 18
    .eqv MAX_LAST_NAME_LEN, 15
    .eqv stidof, 0
    .eqv stmxfn, 4
    .eqv stfnof, 22
    .eqv MAX_GRADE,-20.0
    .eqv sizest, 44
student_struct:
    .word 0            # id_number
    .asciiz ""         # first_name
    .space MAX_FIRST_NAME_LEN, 18
    .asciiz ""         # last_name
    .space MAX_LAST_NAME_LEN, 15
    .float 0.0         # grade

.globl read_data
read_data:
    # student *, int
    # arguments are passed in $a0 and $a1
    # $s0 = student *
    # $s1 = int
    
    la $a0,str1
    li $v0,print_string
    syscall
    move $t0,$s0
    li $t2,sizest
    mulu $t2,$s2,$t2
    addu $t0,$t0,$t2
    li $v0,read_integer
    syscall
    sw $v0,stidof($t0)
    
    la $a0,str2
    li $v0,print_string
    syscall
    move $t0,$a0
    li $t2,sizest
    mul $t2,$s2,$t2
    addu $t0,$t0,$t2
    addiu $a0,$t0,stfnof
    li $a1,stmxfn
    li $v0,read_string
    syscall
    
    move $s0, $a0
    move $s1, $a1
    jr $ra
###########################################################
.globl max
max:
    # student *, int, float *
    # arguments are passed in $a0, $a1 and $a2
    # $s0 = student *
    # $s1 = int
    # $s2 = float *
    l.s $f2,max_grade
    mtc1 $a0,$f4
    cvt.s.w $f4,$f4
    move $t0,$a0
    move $s1,$a1
    li $t3,sizest
    mul $t3,$t3,$s1
    addu $t2,$t0,$t3
    bge $t0,$t2,end_fmx
    l.s $f6,stgrof($t0)
    add.s $f4,$f4,$f6
    c.le.s $f2,$f6
    bc1f end_if_mx
    mov.s $f2,$f6
    move $s1,$t0
end_if_mx:
    addiu $t0,$t0,sizest
    j f_mx
end_fmx: mtc1 $a1,$f8
    cvt.s.w $f8,$f8
    div.s $f4,$f4,$f8
    s.s $f4,0($a2)
    move $v0,$t1 
    move $s0, $a0
    move $s1, $a1
    move $s2, $a2

    jr $ra
    jr $ra
  
###########################################################
.globl print_student
print_student:
    # student *
    # argument is passed in $a0
    # $s0 = student *
    move $a0,$t0
    
    move $s0, $a0
    # TODO: implement print_student
    jr $ra
###########################################################
.text
.globl main
main:
    # static student st_array[MAX_STUDENTS];
    # static float media;
    # student *pmax;
    addi $sp, $sp, -4
    sw $zero, 0($sp)
    addi $sp, $sp, -student_size*MAX_STUDENTS
    sw $zero, 0($sp)

    # read_data( st_array, MAX_STUDENTS );
    add $a0, $sp, 4
    li $a1, MAX_STUDENTS
    jal read_data

    # pmax = max( st_array, MAX_STUDENTS, &media );
    add $a0, $sp, 4
    li $a1, MAX_STUDENTS
    add $a2, $sp, 0
    jal max
    move $s3, $v0

    # print_string("\nMedia: ");
    # print_float( media );
    li $v0, 4
    la $a0, newline
    syscall
    li $v0, 4
    la $a0, media_str
    syscall
    lwc1 $f12, 0($sp)
    li $v0