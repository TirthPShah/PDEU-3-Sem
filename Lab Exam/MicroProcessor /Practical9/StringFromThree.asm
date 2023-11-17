.data
	
	str: .space 120																								#Reserves 120 bytes for the string
	input_msg: .asciiz "Enter the string: "
	output_msg: .asciiz "Formatted string: "
	
.text

	li $v0, 4
	la $a0, input_msg
	syscall																											#Print the prompt for taking the string as input
	
	li $v0, 8
	la $a0, str
	li $a1, 120
	syscall																											#v0 to take input as string with a0, loaded with the address of whree to store the string and a1 with the limits of characters
	
	la $v0, 4
	la $a0, output_msg
	syscall																											#Prints the default output message
	
	la $a0, str																										#Loads the address of the stored string in a0
	
	add $a0, $a0, 3																								#Incrementing 3 bytes to the address of the string so as to skip the first three characters as one character is of one byte
	
	li $v0, 4
	syscall																											#Prints the formatted string as its address is already stored in a0
	
	li $v0, 10
	syscall																											#Terminates the program