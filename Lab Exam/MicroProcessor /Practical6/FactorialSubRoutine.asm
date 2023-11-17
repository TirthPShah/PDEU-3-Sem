.data
	input: .asciiz "Enter the number: "
	result: .asciiz "The factorial of the given number is: "
	
.text

	main:
	
		li $v0, 4
		la $a0, input
		syscall
		
		li $v0, 5
		syscall
		
		move $s0, $v0
		
		jal factorial																#jal will go to subroutine, with $ra to the given line address
		
		li $v0, 10
		syscall
		
	factorial:
	
		li $t3, 1																	#t3 is counter
		li $t1, 1																	#t1 is the final ans variable
	
		calcfact:
		
			loop: 
			
				bgt $t3, $s0, printfact												#t1 is the ans and t3 is the counter if t1 exceeds the given number break the loop
				
				mul $t1, $t1, $t3  													#multiply the current value of ans with counter and store it back it into ans
				
				addi $t3, $t3, 1													#increment the counter
				
				b loop
			
			printfact:
			
				li $v0, 4
				la $a0, result
				syscall
				
				li $v0, 1
				move $a0, $t1
				syscall
				
				jr $ra																#Jumps to the caller line, i.e. $ra , from where it was called by issuing the jal command
