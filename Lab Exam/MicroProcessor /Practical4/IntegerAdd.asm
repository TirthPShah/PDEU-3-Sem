.data
	inp1: .asciiz "Enter the first number: "
	inp2: .asciiz "Enter the second number: "
	sum: .asciiz "The sum of the two number is: "

.text
	main:

		li $v0,4				#Prints the output message for taking the first input
		la $a0,inp1
		syscall

		li $v0,5				#Reads the first integer
		syscall
		move $t1,$v0

		li $v0,4				#Prints the output message for taking the second input
		la $a0,inp2
		syscall

		li $v0,5				#Reads the second integer
		syscall
		move $t2,$v0

		add $t3,$t1,$t2			#Performs the addition

		li $v0, 4				#Prints the sum message
		la $a0, sum
		syscall

		li $v0,1				#Prints the value of sum
		move $a0,$t3
		syscall

		li $v0,10				#Terminates the program
		syscall