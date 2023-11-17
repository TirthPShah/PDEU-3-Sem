.data

	arr: .space 100																	#Reserving space for 25 integers
	freq_arr: .space 400
	term_condition: .word 1111
	input_n: .asciiz "Enter the number of elements to store in array: "
	input_msg_1: .asciiz "Enter the "
	input_msg_2: .asciiz " element of the array: "
	arr_msg: .asciiz "Given Array: "
	mean_msg: .asciiz "Mean: "
	median_msg: .asciiz "Median: "
	mode_msg: .asciiz "Mode: "
	space: .asciiz " "
	newline: .asciiz "\n"
	
.text

	main:
		
		li $v0, 4
		la $a0, newline
		syscall
		
		jal store_arr
		
		beq $s0, $zero, termination
		
		jal bubble_sort
		
		jal print_sorted
		
		jal calc_mean
		
		jal calc_median
		
		jal calc_mode
		
		jal termination
		
		
	store_arr:
	
		li $t0, 1
		move $t1, $zero
		lw $t2, term_condition
		
		
		store_loop:
			
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
			
			beq $v0, $t2, store_term
			
			addi $s0, $s0, 1
			
			mul $t3, $t1, 4
			
			sw $v0, arr($t3)
			
			addi $t0, $t0, 1
			addi $t1, $t1, 1
			
			b store_loop
			
		store_term:
		
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
		la $a0, arr_msg
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
        
	calc_mean:
	
		li $t0, 1
		la $a1, arr
		move $t2, $zero
		
		mean_loop:
			
			bgt $t0, $s0, mean_term
			
			lw $t1, ($a1)
			
			add $t2, $t2, $t1
			
			addi $t0, $t0, 1
			addi $a1, $a1, 4
			
			b mean_loop
			
		mean_term:
			
			li $v0, 4
			la $a0, newline
			syscall
			
			li $v0, 4
			la $a0, mean_msg
			syscall
			
			mtc1 $t2, $f1
			mtc1 $s0, $f2
			
			div.s $f12, $f1, $f2
			
			li $v0, 2
			syscall
			
			jr $ra
			
	calc_median:
	
		move $t2, $zero
		
		li $t1, 2
		
		div $s0, $t1
		
		mfhi $t1
		
		beq $t1, $zero, median_n_even
		b median_n_odd
		
		median_n_even:
			
			li $t1, 2
			
			div $s0, $t1
		
			mflo $t2
			
			sub $t3, $t2, 1
			
			mul $t3, $t3, 4
			mul $t2, $t2, 4
			
			lw $t2, arr($t2)
			lw $t3, arr($t3)
			
			mtc1 $t2, $f2
			mtc1 $t3, $f3
			
			add.s $f2, $f2, $f3
			
			li $t2, 2
			mtc1 $t2, $f1
			
			div.s $f12, $f2, $f1
			
			li $v0, 4
			la $a0, newline
			syscall
			
			li $v0, 4
			la $a0, median_msg
			syscall
			
			li $v0, 2
			syscall
			
			jr $ra
		
		median_n_odd:
			
			li $t2, 2
			
			div $s0, $t2
			
			mflo $t2
			
			mul $t2, $t2, 4
			
			li $v0, 4
			la $a0, newline
			syscall
			
			li $v0, 4
			la $a0, median_msg
			syscall
			
			lw $a0, arr($t2)
			
			li $v0, 1
			syscall
			
			jr $ra
			
	calc_mode:
	
		init_freq_arr:
		
			la $a1, arr
			
			sub $t1, $s0, 1
			move $t0, $zero
			
			init_freq_arr_loop:
			
				bgt $t0, $t1, freq_arr_find_max
				
				mul $t2, $t0, 4
				
				lw $t3, arr($t2)
				
				mul $t4, $t3, 4
				
				move $t5, $t4
				
				lw $t4, freq_arr($t4)
				
				addi $t4, $t4, 1
				
				sw $t4, freq_arr($t5)
				
				addi $t0, $t0, 1
				
				b init_freq_arr_loop
				
			freq_arr_find_max:
			
				li $s1, 99
				la $a1, freq_arr
				move $t4, $zero
				move $t5, $zero
				move $t7, $zero
				move $t8, $zero
				
				find_max_loop:
				
				lw $t6, ($a1)
				
				bgt $t5, $s1, mode_term
				
				bgt $t6, $t4, is_greater
				
				cont:
				
				addi $a1, $a1, 4
				addi $t7, $t7, 1
				addi $t5, $t5, 1
				
				b find_max_loop
				
				is_greater:
				
					move $t8, $t7
					move $t4, $t6
					b cont	
					
				mode_term:
				
					li $v0, 4
					la $a0, newline
					syscall
				
					li $v0, 4
					la $a0, mode_msg
					syscall
					
					li $v0, 1
					move $a0, $t8
					syscall
					
					jr $ra
			
	termination:
	
		li $v0, 10
		syscall