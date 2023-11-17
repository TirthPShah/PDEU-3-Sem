.data

	arr: .space 100																		#Reserving space for 25 integers
	input_n: .asciiz "Enter the number of eleemnts to store in array: "
	input_msg_1: .asciiz "Enter the "
	input_msg_2: .asciiz " element of the array: "
	arr_msg: .asciiz "Given Array: "
	sum_msg: .asciiz "Sum of the given elements of the array is: "
	sqr_msg: .asciiz "Sum of the square of the given elements of the array is: "
	space: .asciiz " "
	newline: .asciiz "\n"
	
.text

	main:
	
		li $v0, 4
		la $a0, input_n
		syscall
		
		li $v0, 5
		syscall
		
		move $s0, $v0																	#Moving the number of elements to $s0 to keep it unchanged during sub routine call
		
		li $v0, 4
		la $a0, newline
		syscall
		
		jal store_arr
		
		jal print_given
		
		jal calc_print_sum
		
		jal calc_print_sqr
		
		jal termination
		
	store_arr:
	
		li $t0, 1																		#Initializing the counter with 1
		la $a1, arr																		#Initializing $a1 with the address of reserved memory of array arr
		
		arr_loop:
		
			bgt $t0, $s0, arr_term													#Branch to arr_term if the counter i.e. t0 exceeds the number of terms i.e. s0
			
			li $v0, 4
			la $a0, input_msg_1
			syscall																		#Prints the first part of taking the input of the element
			
			li $v0, 1
			move $a0, $t0
			syscall																		#Prints the current number of term being taken as input
			
			li $v0, 4
			la $a0, input_msg_2
			syscall																		#Prints the second part of taking the input of element
			
			li $v0, 5
			syscall																		#Reads the integer
			
			sw $v0, ($a1) 																#Storing the value obtained to array
			
			addi $t0, $t0, 1															#Incrementing the counter
			addi $a1, $a1, 4															#Incrementing the base address of array by 4 to store the integer as integer is of 4 bytes
			
			b arr_loop
			
		arr_term:
		
			jr $ra
			
	print_given:
	
		li $t0, 1																		#Initialize the counter with 1
		la $a1, arr																		#Loads the address of arr in a1
		
		li $v0, 4
		la $a0, newline
		syscall
		
		li $v0, 4
		la $a0, arr_msg
		syscall																			#Prints the default message of printing the array
		
		print_loop:
		
			bgt $t0, $s0, print_term												#Branches to print_term when the counter i.e. t0 exceeds the number of elements i.e. s0 
			
			lw $a0, ($a1)
			li $v0, 1
			syscall																		#Loads the element into a0 and print it
			
			li $v0, 4
			la $a0, space
			syscall
			
			addi $t0, $t0, 1															#Increment the counter
			addi $a1, $a1, 4															#Increment the address in a1 by 4 so as to take the next element because 1 integer is of 4 bytes
			
			b print_loop
			
		print_term:
		
			jr $ra
			
	calc_print_sum:
		
		li $v0, 4
		la $a0, newline
		syscall
		
		li $v0, 4
		la $a0, sum_msg
		syscall
		
		li $t2, 1																		#Initialize the counter with 1
		la $a1, arr																		#Loads the address of arr in a1
		
		sum_loop:
		
			bgt $t2, $s0, sum_term													#Branch to sum_term if counter i.e. t2 exceeds the given number of terms i.e. s0
			
			lw $t3, ($a1)																#Loads word in t3
			
			add $t4, $t4, $t3															#t4 = t4 + t3
			
			addi $t2, $t2, 1															#Increment the counter
			
			addi $a1, $a1, 4															#Increment the address in a1 by 4 so as to take the next element because 1 integer is of 4 bytes
			
			b sum_loop
			
		sum_term:
		
			li $v0, 1
			move $a0, $t4
			syscall																		#Prints the sum of all the elements
			
			jr $ra
			
	calc_print_sqr:
	
		li $v0, 4
		la $a0, newline
		syscall
		
		li $v0, 4
		la $a0, sqr_msg
		syscall
		
		li $t2, 1																		#Initialize the counter with 1
		la $a1, arr																		#Loads the address of arr in a1
		
		move $t4, $zero																#Reset the value of t4 to 0
		
		sqr_loop:
			
			bgt $t2, $s0, sqr_term													#Branch to sqr_term if counter i.e. t2 exceeds the given number of elements i.e. s0
			
			lw $t3, ($a1)																#Loads the element in t3
			
			mul $t3, $t3, $t3															#t3 = t3 * t3 (like element = element * element) i.e. calculating square of t3 and then storing it again in t3
			
			add $t4, $t4, $t3															#t4 = t4 + t3
			
			addi $t2, $t2, 1															#Increment the counter
			
			addi $a1, $a1, 4															#Increment the address in a1 by 4 so as to take the next element because 1 integer is of 4 bytes
			
			b sqr_loop
			
		sqr_term:
		
			li $v0, 1
			move $a0, $t4
			syscall																		#Prints the sum of square of elements
			
			jr $ra
			
	termination:
	
			li $v0, 10
			syscall																		#Terminates the program