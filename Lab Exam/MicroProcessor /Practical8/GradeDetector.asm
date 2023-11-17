.data

	A: .asciiz "A"
	B: .asciiz "B"
	C: .asciiz "C"
	D: .asciiz "D"
	E: .asciiz "E"
	F: .asciiz "F"
	
	input: .asciiz "Enter the marks obtained: "
	output: .asciiz "Obtained grade is: "
	
.text

	main:
		
		li $v0, 4
		la $a0, input
		syscall
		
		li $v0, 5
		syscall
		
		move $t0, $v0
		
		li $v0, 4
		la $a0, output
		syscall
		
		bge $t0, 90, print_A											
		
		bge $t0, 80, print_B
		
		bge $t0, 70, print_C										#Here the interesting point is that if the marks are greater than 90 than the command will not go to the lines below (branching) and will directly go to print_A)
		
		bge $t0, 60, print_D										#Similarly, if it is not greater than 90 it will come down and will check only for greater than 80 and as we already checked that it is less than 90 ( the reason it came down ), it suits our checking scheme for grade B
		
		bge $t0, 40, print_E
		
		b print_F
		
	print_A:
	
		li $v0, 4
		la $a0, A
		syscall
		
		b prog_term
		
	print_B:
	
		li $v0, 4
		la $a0, B
		syscall
		
		b prog_term
		
	print_C:
	
		li $v0, 4
		la $a0, C
		syscall
		
		b prog_term
		
	print_D:
	
		li $v0, 4
		la $a0, D
		syscall
		
		b prog_term
		
	print_E:
	
		li $v0, 4
		la $a0, E
		syscall
		
		b prog_term
		
	print_F:
	
		li $v0, 4
		la $a0, F
		syscall
		
		b prog_term
		
	prog_term:
	
		li $v0, 10
		syscall
