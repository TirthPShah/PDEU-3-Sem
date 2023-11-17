.data
	inp1: .asciiz "Enter the first number: "
	inp2: .asciiz "Enter the second number: "
	diff: .asciiz "The difference of the two numbers is: "


.text
	main:
		
		li $v0,4			#Prints the input1 message to take the first input
		la $a0,inp1
		syscall

		li $v0,5			#Takes the first input and moves it to $t1 from $v0
		syscall
		move $t1,$v0

		li $v0,4			#Prints the input2 message to take the second input
		la $a0,inp2
		syscall

		li $v0,5			#Takes the second input and moves it to $t2 from $v0
		syscall
		move $t2,$v0

		sub $t3,$t1,$t2		#Performs the subtraction and stores the answer in $t3

		li $v0,4			#Prints the final answer message
		la $a0,diff
		syscall

		li $v0,1			#Prints the value of final answer by moving the data from $t3 to $a0
		move $a0,$t3
		syscall

		li $v0,10			#Terminates the program
		syscall