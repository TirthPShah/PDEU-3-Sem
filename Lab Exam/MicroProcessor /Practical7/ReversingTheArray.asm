.data

	arr: .space 100																		#Reserving the space for 25 integers
	input_n: .asciiz "Enter the number of elements to store in array: "
	input_msg_1: .asciiz "Enter the "
	input_msg_2: .asciiz " element of the array: "
	given_msg: .asciiz "Elements of the array in the given order: "
	reverse_msg: .asciiz "Elements of the array in the reversed order: "
	space: .asciiz " "
	newline: .asciiz "\n"
	
.text

	main:
		
		li $v0, 4																		#Printing the message for taking number of integers to store
		la $a0, input_n
		syscall
		
		li $v0, 5
		syscall
		
		move $s0, $v0																	#Storing the answer in an register which stays unchanged with respect to function calls
		
		li $v0, 4
		la $a0, newline
		syscall
		
		jal store_arr
		
		jal print_given
		
		jal print_reverse
		
		jal prog_term
		
	store_arr:
	
		li $t0, 1																		#Initializing the counter with 1
		la $a1, arr																		#Initializing $a1 with the address of reserved memory of array arr
		
		arr_loop:
		
			bgt $t0, $s0, arr_term
			
			li $v0, 4
			la $a0, input_msg_1
			syscall
			
			li $v0, 1
			move $a0, $t0
			syscall
			
			li $v0, 4
			la $a0, input_msg_2
			syscall
			
			li $v0, 5
			syscall
			
			sw $v0, ($a1) 																#Storing the value obtained to array
			
			addi $t0, $t0, 1															#Incrementing the counter
			addi $a1, $a1, 4															#Incrementing the base address of array by 4 to store the integer as integer is of 4 bytes
			
			b arr_loop
			
		arr_term:
		
			jr $ra
			
	print_given:
	
		li $t0, 1
		la $a1, arr
		
		li $v0, 4
		la $a0, newline
		syscall
		
		li $v0, 4
		la $a0, given_msg
		syscall
		
		print_loop:
		
			bgt $t0, $s0, print_term
			
			lw $a0, ($a1)
			li $v0, 1
			syscall
			
			li $v0, 4
			la $a0, space
			syscall
			
			addi $t0, $t0, 1
			addi $a1, $a1, 4
			
			b print_loop
			
		print_term:
		
			jr $ra
			
	print_reverse:
	
		li $v0, 4
		la $a0, newline
		syscall
		
		li $v0, 4
		la $a0, reverse_msg
		syscall
		
		li $t0, 1
		
		subi $a1, $a1, 4																	#Subtracting the value of $a1 for getting the last element of the array because it was incremented to the next step vefore checking the condition in the print_loop
		
		reverse_loop:
		
			bgt $t0, $s0, reverse_term
			
			lw $a0, ($a1)
			li $v0, 1
			syscall
			
			li $v0, 4
			la $a0, space
			syscall
			
			addi $t0, $t0, 1
			subi $a1, $a1, 4
			
			b reverse_loop
			
		reverse_term:
		
			jr $ra
						
	prog_term:
	
		li $v0, 10
		syscall