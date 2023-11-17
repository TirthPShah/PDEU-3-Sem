.data
	inp1: .asciiz "Enter the first number: "
	inp2: .asciiz "Enter the second number: "
	sum: .asciiz "The sum of the two numbers is: "


.text
	main:
		li $v0,4			#Prints the message for taking input of the first number
		la $a0,inp1
		syscall

		li $v0,6			#Reads the first input
		syscall
		mov.s  $f2,$f0		#Stores the input in $f2 from $f0

		li $v0,4			#Prints the message for taking input of the second number
		la $a0,inp2
		syscall

		li $v0,6			#Reads the second input
		syscall
		mov.s  $f4,$f0		#Stores the input in $f4 from $f0

		add.s $f6,$f2,$f4	#Performs the addition and stores the sum in $f6


		li $v0,4			#Prints the sum message
		la $a0,sum
		syscall

		li $v0,2			#Prints the value of sum by moving the answer from $f6 to $f12 for printing
		mov.s $f12,$f6
		syscall

		li $v0,10			#Terminates the program
		syscall