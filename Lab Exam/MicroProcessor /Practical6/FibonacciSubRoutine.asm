.data

	input_msg: .asciiz "Enter the number of terms of Fibonacci series you want to print: "
	result: .asciiz "Fibonacci Series: "
	space: .asciiz " "
	
.text

	main:
	
		li $v0, 4
		la $a0, input_msg
		syscall
		
		li $v0, 5
		syscall
		
		move $s0, $v0
		
		jal printfibo																					#Goes to printfibo sub routine with current line address stored in $ra for returning back here
		
		li $v0, 10
		syscall																							#Terminates the programme after returning from the printfibo sub routine
		
	printfibo:
		
		li $v0, 4
		la $a0, result
		syscall
		
		li $t1, 0
		
		li $v0, 1
		move $a0, $t1
		syscall
		
		beq $s0, 1, termination																			# Goes to termination if only one term is meant to be printed, i.e., after printing 0
		
		li $v0, 4
		la $a0, space
		syscall
		
		li $t2, 1
		
		li $v0, 1
		move $a0, $t2
		syscall
		
		beq $s0, 2, termination																			#Goes to termination if two terms are meant to be printed, i.e., after printing 0, 1
		
		li $v0, 4
		la $a0, space
		syscall
		
		li $t3, 3																						#Shows the current number of term being printed
		
		loop:
			
			bgt $t3, $s0, termination																	#If the current number of term being printed exceeds total number of term to be printed then break the loop and go for termination
			
			add $t4, $t1, $t2																			# c = a + b
			
			li $v0, 1
			move $a0, $t4
			syscall																						#print c
				
			li $v0, 4
			la $a0, space
			syscall
			
			move $t1, $t2																				# a = b
			move $t2, $t4																				# b = c
			
			addi $t3, $t3, 1																			#Increase the counter showing the current number of term being printed
			
			b loop																						#Branch again to the starting of the loop
		
	termination:

		jr $ra
