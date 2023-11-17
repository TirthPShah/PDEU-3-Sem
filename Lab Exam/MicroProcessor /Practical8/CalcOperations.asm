.data

	a: .float 2.5
	b: .float 10.5
	c: .space 4
	d: .space 8
	e: .space 8
	
	cmsg: .asciiz "C = "
	dmsg: .asciiz "D = "
	emsg: .asciiz "E = "
	
	newline: .asciiz "\n"
	
.text

	main:
	
		#We will store the results of all the operations in $f12 for printing them with the syscall of $v0 as 2, to print them as float
		
		lwc1 $f2, a
		lwc1 $f4, b
				
		add.s $f12, $f2, $f4
		
		swc1 $f12, c
		
		li $v0, 4
		la $a0, cmsg
		syscall
		
		li $v0, 2
		syscall
		
		li $v0, 4
		la $a0, newline
		syscall
		
		mul.s $f12, $f2, $f4
		
		swc1 $f12, d
		
		li $v0, 4
		la $a0, dmsg
		syscall
		
		li $v0, 2
		syscall
		
		li $v0, 4
		la $a0, newline
		syscall
		
		swc1 $f12, e
		
		div.s $f12, $f2, $f4
		
		li $v0, 4
		la $a0, emsg
		syscall
		
		li $v0, 2
		syscall
		
		li $v0, 10
		syscall
