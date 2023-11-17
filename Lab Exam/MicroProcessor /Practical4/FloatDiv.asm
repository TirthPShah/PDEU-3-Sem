.data
	inp1: .asciiz "Enter the first number: "
	inp2: .asciiz "Enter the second number: "
	ans: .asciiz "The result of the division is: "

.text
	main:
	
	li $v0,4				#Prints the message for taking the first input
	la $a0,inp1
	syscall

	li $v0,6				#Reads the first float input and stores it in $f2
	syscall
	mov.s $f2,$f0

	li $v0,4				#Prints the message for taking the second input
	la $a0,inp2
	syscall

	li $v0,6				#Reads the second float input and stores it in $f4
	syscall
	mov.s $f4,$f0

	div.s $f6,$f2,$f4		#Performs the division operation and stores the result in $f6

	li $v0,4				#Prints the message for final answer
	la $a0,ans
	syscall

	li $v0,2				#Prints the value of the final answer by moving the value from $f6 to $f12
	mov.s $f12,$f6
	syscall

	li $v0,10				#Terminates the program
	syscall