.data

    ans: .asciiz "The larger number is: "

.text

    main:

        li $t0, 42
        li $t1, 24 

        bgt $t0, $t1, first_large									#If t0 > t1 then branch to first_large
        b second_large												#Else branch to second_large

    first_large:
    
        li $v0, 4
        la $a0, ans
        syscall														#Prints the output message
        
        li $v0, 1
        move $a0, $t0
        syscall														#Prints the value of t0 as t0 > t1
       	
       	li $v0, 10
       	syscall

    second_large:

        li $v0, 4
        la $a0, ans
        syscall														#Prints the output message
        
        li $v0, 1
        move $a0, $t1
        syscall														#Prints the value of t1 as t1 > t0
        
        li $v0, 10
        syscall														#Terminates the program
