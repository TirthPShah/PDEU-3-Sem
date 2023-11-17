.data
	inp1: .asciiz "Enter the first number: "
	inp2: .asciiz "Enter the second number: "
	diff: .asciiz "The difference of the two numbers is: "

.text
	main:
	
		li $v0,4				#Prints the message inp1 to take input of first number
		la $a0,inp1
		syscall

		li $v0,6				#Reads the first number
		syscall
		mov.s $f2,$f0

		li $v0,4				#Prints the message inp2 to take input of second number
		la $a0,inp2
		syscall

		li $v0,6				#Reads the second number
		syscall
		mov.s  $f4,$f0

		sub.s $f6,$f2,$f4		#Performs the substraction operation and stores teh value in $f6

		li $v0,4				#Prints the final answer message
		la $a0,diff
		syscall

		li $v0,2				#Prints the value of the final answer by moving the value from $f6 to $f12
		mov.s $f12,$f6
		syscall

		li $v0,10				#Terminates the program
		syscall