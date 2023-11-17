.data
    
    input_name: .asciiz "Enter your name: "
    input_enroll_id: .asciiz "Enter your Enrollment ID: "
    
    name: .space  50  
    enroll_id: .space  12
    
    output_name: .asciiz "Entered name is: "
    output_enroll_id: .asciiz "Entered enrollment ID is: "
    
    enter: .asciiz "\n"

.text

    main:
    
        li $v0, 4
        la $a0, input_name
        syscall																					#Prints the prompt for taking input for name

        li $v0, 8 																				#Takes input as string and stores it to address mentioned in a0 with a max character limit of content of a1
        la $a0, name																			#Loads a0 with the address of name i.e. where the read string should be stored
        li $a1, 50																				#Loads a1 with 50 which shows the max number of characters allowed
        syscall

        li $v0, 4
        la $a0, input_enroll_id
        syscall																					#Prints the prompt for taking input for enrollment id

        li $v0, 8																				#Takes input as string and stores it to address mentioned in a0 with a max character limit of content of a1
        la $a0, enroll_id																		#Loads a0 with the address of enroll_id i.e. where the read string should be stored
        li $a1, 12																				#Loads a1 with 12 which shows the max number of characters allowed
        syscall
        
        li $v0, 4
        la $a0, enter
        syscall																					#Prints newline

        li $v0, 4
        la $a0, output_name
        syscall																					#Prints the message for printing the name

        li $v0, 4
        la $a0, name
        syscall																					#Prints the name taken as input by loading v0 with 4 and a0 with the address of name

        li $v0, 4
        la $a0, output_enroll_id
        syscall																					#Prints the message for printing the enrollment id

        li $v0, 4
        la $a0, enroll_id
        syscall																					#Prints the enrollment id taken as input by loading v0 with 4 and a0 with the address of enroll_id

        li $v0, 10
        syscall																					#Terminates the program