.data

	input: .asciiz "Enter the temperature in celcius: "
	output: .asciiz "The temperature in farenheit: "
	nine: .double 9
	five: .double 5
	thirty_two: .double 32
	
.text

	main:
	
		li $v0, 4
		la $a0, input
		syscall															#Printing the prompt for input
		
		li $v0, 7														#Taking input of celcius
		syscall

		l.d $f2, nine													#Loading double in $f2, via label nine
		mul.d  $f0, $f0, $f2											#f0 = f0 * 9
		
		l.d $f2, five
		div.d $f0, $f0, $f2												#f0 = f0 / 5
		
		l.d $f2, thirty_two
		add.d $f0, $f0, $f2												#f0 = f0 + 32
																		
		# F = ((9 * C) / 5) + 32
																		
		mov.d $f12, $f0													#moving the result from $f0 to 4f12 for printing
		
		li $v0, 4
		la $a0, output
		syscall															#Printing the output message
		
		li $v0, 3
		syscall															#Printing the result
		
		li $v0, 10														#Terminating the program
		syscall
