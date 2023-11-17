.data
	asciiofnum: .byte 49, 50, 51, 52, 0  # The last 0 represents the null terminator

.text
	main:
    	la $a1, asciiofnum  # Load the address of the string into $a1
    	li $t0, 0          # Initialize $t0 to 0

loop:

    lb $t1, ($a1)     # Load the ASCII character at the address in $a1 #Ascii Digit
    
    li $t2, 48          # Load the ASCII value of '0' (48) into $t2
    
    beq $t1, $zero, termination  # Check if $t1 is the null terminator (end of the string)
    
    mul $t0, $t0, 10    # Multiply the accumulator by 10 # Ans = Ans * 10
    
    sub $t1, $t1, $t2   # Convert ASCII character to its integer value # Digit = AScii digit - ascii value of 0

    add $t0, $t0, $t1  # Add the integer value to the accumulator	# Ans = Ans + Digit

    addi $a1, $a1, 1    # Move to the next character
    
    j loop

termination:

    # Print the result
    li $v0, 1
    move $a0, $t0
    syscall

    # Exit
    li $v0, 10
    syscall
