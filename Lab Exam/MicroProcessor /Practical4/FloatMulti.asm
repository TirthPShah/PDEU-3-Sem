.data
	inp1: .asciiz "Enter the first number: "
	inp2: .asciiz "Enter the second number: "
	prod: .asciiz "The result of multiplication is: "

.text
	main:

		li $v0,4					#Prints the message to take the first input
		la $a0,inp1
		syscall

		li $v0,6					#Reads the input and stores it in $f2 from $f0
		syscall
		mov.s  $f2,$f0

		li $v0,4					#Prints the message to take the second input
		la $a0,inp2
		syscall

		li $v0,6					#Reads the input and stores it in $f4 from $f0
		syscall
		mov.s $f4,$f0

		mul.s $f6,$f2,$f4			#Performs the multiplication operation and stores it in $f6

		li $v0,4					#Prints the final answer message
		la $a0,prod
		syscall

		li $v0,2					#Prints the value of the final answer by moving the value from $f6 to $f12
		mov.s $f12,$f6
		syscall

		li $v0,10					#Terminates the program
		syscall