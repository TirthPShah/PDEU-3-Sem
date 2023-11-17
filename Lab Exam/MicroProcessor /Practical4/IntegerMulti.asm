#Limitations of this operation is that it may generate answer which cannot be stored as 32 byte and hence might get overflowed

.data
	inp1: .asciiz "Enter the first number: "
	inp2: .asciiz "Enter the second number: "
	prod: .asciiz "The product of the two numbers is: "


.text
	main:
	
		li $v0,4				#Prints the message to take the first input
		la $a0,inp1
		syscall

		li $v0,5				#Reads the first input
		syscall
		move  $t1,$v0

		li $v0,4				#Prints the message to take the second input
		la $a0,inp2
		syscall

		li $v0,5				#Reads the second input
		syscall
		move  $t2,$v0

		mul $t3,$t1,$t2			#Performs multiplication operation and stores the value in $t3

		li $v0,4				#Prints the final answer message
		la $a0,prod
		syscall

		li $v0,1				#Prints the value of the final answer by moving the value from $t3 to $a0
		move $a0,$t3
		syscall

		li $v0,10				#Terminates the program
		syscall