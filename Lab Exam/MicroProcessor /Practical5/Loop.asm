.data

	input1: .asciiz "Enter the first number: "
	input2: .asciiz "Enter the second number: "
	ans: .asciiz "Multiples: "
	space: .asciiz " "
	
.text

	main:
		
		li $v0, 4
		la $a0, input1
		syscall																#Prints the prompt for taking the first number
		
		li $v0, 5
		syscall
		move $t0, $v0														#Takes the first number input and stores it in t0 from v0
		
		li $v0, 4
		la $a0, input2
		syscall																#Prints the prompt for taking the second number
		
		li $v0, 5
		syscall
		move $t1, $v0														#Takes the second number input and stores it in t1 from v0
		
		li $v0, 4
		la $a0, ans
		syscall																#Prints the output message
		
		li $v0, 4
		la $a0, space
		syscall																#Prints space
		
		li $t2, 1
		syscall																#Initialize the counter (say i) with 1 i.e., 
		
	loop:
	
		bgt $t2, $t1, end													#Branches to end if the counter exceeds the second number
	
		mul $t3, $t0, $t2													#t3 = t0 * t2 (first * i)
		
		li $v0, 1
		move $a0, $t3
		syscall																#Prints the value of i
		
		li $v0, 4
		la $a0, space
		syscall																#Prints space
		
		addi $t2, $t2, 1													#Increments the counter by 1 (i++)
		
		b loop
		
	end:
	
		li $v0, 10
		syscall																#Terminates the program
