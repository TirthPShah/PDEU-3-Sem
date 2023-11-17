.data
	inp1: .asciiz "Enter the first number: "
	inp2: .asciiz "Enter the second number: "
	quo: .asciiz "The quotient of the division of the two numbers is: "
	rem: .asciiz "The remainder of the division of the two numbers is: "

.text
	main:
		li $v0,4				#Prints the message for taking the first input
		la $a0,inp1
		syscall

		li $v0,5				#Reads the first input
		syscall
		move $t1,$v0

		li $v0,4				#Prints the message for taking the second input
		la $a0,inp2
		syscall

		li $v0,5				#Reads the second input
		syscall
		move $t2,$v0

		div $t3,$t1,$t2			#Performs the division and stores the value in $t3
		mfhi $t4				#Moves the remainder(higher bits) to $t4
		mflo $t5				#Moves the quotient(lower bits) to $t5

		li $v0,4				#Prints the message for printing the quotient
		la $a0,quo
		syscall

		li $v0,1				#Prints the value of quotient by moving its value from $t5 to $a0
		move $a0,$t5
		syscall

		li $v0,4				#Prints the message for printing the remainder
		la $a0,rem
		syscall

		li $v0,1				#Prints the value of remainder by moving its value from $t4 to $a0
		move $a0,$t4
		syscall

		li $v0,10				#Terminates the program
		syscall