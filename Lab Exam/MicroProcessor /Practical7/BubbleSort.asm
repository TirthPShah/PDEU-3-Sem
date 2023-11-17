.data

	arr: .space 100																		#Reserving space for 25 integers
	input_n: .asciiz "Enter the number of eleemnts to store in array: "
	input_msg_1: .asciiz "Enter the "
	input_msg_2: .asciiz " element of the array: "
	arr_msg: .asciiz "Given Array: "
	sorted_msg: .asciiz "Sorted Array: "
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
		
		jal bubble_sort
		
		jal print_sorted
		
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
		la $a0, arr_msg
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
			
	bubble_sort:
    
    li $t0, 0																			#int i = 0
    
   	sub $t1, $s0, 1																		#n-1
   	
   	outer_loop:
   	
   		bge $t0, $t1, bubble_sort_term													#for i < n-1
   		
   		li $t2, 0																		#int j = 0
   		
   		sub $t3, $s0, $t0																#n-i
   		sub $t3, $t3, 1																	#n-i-1
   		
   		inner_loop:
   		
   			bge $t2, $t3, outer_cont													#for j < n-i-1
   			
   			add $t4, $t2, 1																#j+1
   			
   			mul $t5, $t2, 4																#multiplying by 4, because the integers occupy 4 bytes of memory in the space assigned to arr
   			mul $t6, $t4, 4
   			
   			lw $t7, arr($t5)															#arr[j]
   			lw $t8, arr($t6)															#arr[j+1]		
   			
   			bgt $t7, $t8, swap															#if (arr[j] > arr[j+1] branch towards swap
   			b inner_cont																#else go to inner_cont
   			
   			swap:
   			
   				move $t9, $t7															#temp = arr[j]
   				move $t7, $t8															#arr[j] = arr[j+1]
   				move $t8, $t9															#arr[j+1] = temp
   				
   				sw $t7, arr($t5)														#we swapped the value in the registers, not in the array, so we need to store them in the array
   				sw $t8, arr($t6)
   				
   				b inner_cont
   			
   			inner_cont:
   			
   				add $t2, $t2, 1															#j++
   				
   				b inner_loop
   			
   		outer_cont:
   		
   			addi $t0, $t0, 1															#i++
   			
   			b outer_loop

    bubble_sort_term:
    
        jr $ra

				
	print_sorted:
	
		li $t0, 1
		la $a1, arr
		
		li $v0, 4
		la $a0, newline
		syscall
		
		li $v0, 4
		la $a0, sorted_msg
		syscall
		
		print_sorted_loop:
		
			bgt $t0, $s0, print_sorted_term
			
			lw $a0, ($a1)
			li $v0, 1
			syscall
			
			li $v0, 4
			la $a0, space
			syscall
			
			addi $t0, $t0, 1
			addi $a1, $a1, 4
			
			b print_sorted_loop
			
		print_sorted_term:
		
			jr $ra
		
	prog_term:
	
		li $v0, 10
		syscall