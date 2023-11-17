.data

	input1: .asciiz "Enter the first number: "						#Print the prompt for getting the first number input
	input2: .asciiz "Enter the second number: "						#Print the prompt for getting the second number input
	result: .asciiz "The sum of the given range of array is: "		#Print the result message
	arr: .space 80													#Stores 80 bits (for storing upto 20 integers), with the label arr, addressing to the starting of the contigous memory location allocated

.text

	main:
	
		li $v0, 4
		la $a0, input1
		syscall														#Prints the first message
		
		li $v0, 5
		syscall														#Reads the first number
			
		move $t0, $v0												#Stores the first number from $v0, to $t0
		
		li $v0, 4
		la $a0, input2
		syscall														#Prints the second message
		
		li $v0, 5
		syscall														#Reads the second number
		
		move $t1, $v0												#Stores the second number from $v0, to $t1
		
		la $a1, arr													#Loads the address of arr in $a1
		
		move $t2, $t0												#Sets $t2 to the value of $t0
		
		jal storearray												#Jumps to storearray subroutine
		
		jal printsum												#Jumps to printsum subroutine
		
		li $v0, 10			
		syscall														#Terminates the program
		
	storearray:
	
		storeloop:
			
			bgt $t2, $t1, storecomplete								#Branch to storecomplete label if contents of $t2 is greater than contents of $t1
			
			sw $t2, ($a1)											#Stores the value of $t2 into arr addressed by $a1
			addi $t2, $t2, 1										#Increments the value of $t2 by 1
			addi $a1, $a1, 4										#Increments the value of $a1 by 4 for storing the next integer
			
			b storeloop												#Unconditional branch to storeloop, i.e. starting of this loop
			
		storecomplete:
			
			move $t2, $t0											#Resets the value of $t2 to $t0
			jr $ra													#Jump to the line, from where it was called
			
	printsum:
	
		la $a1, arr
	
		sumloop:
			
			#lw $t2, ($a1)
			
			beq $t2, $t1, resultprint								#Branch to resultprint label if contents of $t2 is greater than contents of $t1
			
			lw $t2, ($a1)
			
			add $t3, $t2, $t3										#Sum = currval + sum
			
			addi $a1, $a1, 4										#Increments the current value by 1
			
			b sumloop												#Unconditional branch to sumloop, i.e. starting of this loop
			
		resultprint:
		
			li $v0, 4												
			la $a0, result
			syscall													#Prints the result message
			
			li $v0, 1
			move $a0, $t3
			syscall													#Prints the value of the final sum by moving it into $a0, from $t3
			
			jr $ra													#Jump to the line, from where it was called