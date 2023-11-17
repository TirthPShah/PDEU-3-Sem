.data

    input1:    .asciiz "Enter the first number: "
    input2:    .asciiz "Enter the second number: "
    ans:     .asciiz "The larger number is: "

.text

    main:
        li $v0, 4
        la $a0, input1
        syscall																#Prints the prompt for taking the first input

        li $v0, 5
        syscall
        move $t0, $v0														#Takes the first input and stores it to t0 from v0

        li $v0, 4
        la $a0, input2
        syscall																#Prints the prompt for taking the second input

        li $v0, 5
        syscall
        move $t1, $v0														#Takes the second input and stores it to t1 from v0

        bgt $t0, $t1, first_large											#If t0 > t1 then branch to first_large
        b second_large														#Else branch to second_large

    first_large:
		
		li $v0, 4
		la $a0, ans
		syscall																#Prints the output message
		
        li $v0, 1
        move $a0, $t0
        syscall																#Prints the value of t0 as t0 > t1
        
        li $v0, 10
        syscall																#Terminates the program

    second_large:
		
		li $v0, 4
		la $a0, ans
		syscall																#Prints the output message
		
        li $v0, 1
        move $a0, $t1
        syscall																#Prints the value of t1 as t1 > t0
        
        li $v0, 10
        syscall																#Terminates the program
