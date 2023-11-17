.data 
	
	tea_individual_unit: .space 4
	burger_individual_unit: .space 4
	panipuri_individual_unit: .space 4
	goal: .space 4
	
	tea_unit_msg: .asciiz "Enter units of tea sold: "
	panipuri_unit_msg: .asciiz "Enter units of panipuri sold: "
	burger_unit_msg: .asciiz "Enter units of burger sold: "
	goal_msg: .asciiz "Enter the amount you want to set as the goal for the net profit after all sales: "
	
	tea_cost_price: .word 10
	tea_sell_price: .word 12
	
	burger_cost_price: .word 50
	burger_sell_price: .word 75
	
	panipuri_cost_price: .word 30
	panipuri_sell_price: .word 42
	
	net_prof_msg: .asciiz "Net Profit: "
	
	true_msg: .asciiz "Net Profit is equal to goal of "
	false_msg: .asciiz "Net Profit is not equal to goal of "
	
	full_stop: .asciiz "."
	newline: .asciiz "\n"

.text

	main:
	
	li $v0, 4																	#Prints the prompt for taking the number of individual tea units sold
	la $a0, tea_unit_msg
	syscall
	
	li $v0, 5																	#Takes the number of individual teas sold
	syscall
	
	move $t0, $v0
	sw $t0, tea_individual_unit
	
	li $v0, 4
	la $a0, burger_unit_msg
	syscall
	
	li $v0, 5
	syscall
	
	move $t1, $v0
	sw $t1, burger_individual_unit
	
	li $v0, 4
	la $a0, panipuri_unit_msg
	syscall
	
	li $v0, 5
	syscall
	
	move $t2, $v0
	sw $t2, panipuri_individual_unit
	
	li $v0, 4
	la $a0, goal_msg
	syscall
	
	li $v0, 5
	syscall
	
	sw $v0, goal
	
	lw $t3, tea_cost_price														#t3 = C.P. of tea
	
	mul $t3, $t3, $t0															#t3 = Total cost of making tea for given units of tea
	
	lw $t4, tea_sell_price														#t4 = S.P.of tea
	
	mul $t4, $t4, $t0															#t4 = Total amount obtained by selling the given units of tea
	
	sub $t6, $t4, $t3															#t6 = Net Profit from tea
	
	add $t5, $t5, $t6															#t5 = Net Profit from all sales so far
	
	lw $t3, burger_cost_price													#t3 = C.P. of Burger
	
	mul $t3, $t3, $t1															#t3 = Total C.P. of all Burger units sold
	
	lw $t4, burger_sell_price													#t4 = S.P. of Burger
	
	mul $t4, $t4, $t1															#t4 = Total amount obtained by selling the given units of burger
	
	sub $t6, $t4, $t3															#t6 = Net Profit from all Burger Sales
	
	add $t5, $t5, $t6															#t5 = Net Profit from all sales so far 
	
	lw $t3, panipuri_cost_price													#t3 = C.P. of Panipuri
	
	mul $t3, $t3, $t2															#t3 = Total C.P. of all Panipuri Sold
	
	lw $t4, panipuri_sell_price													#t4 = S.P. of Panipuri
	
	mul $t4, $t4, $t2															#t4 = Total amount obtained by selling the given units of Panipuri
	
	sub $t6, $t4, $t3															#t6 = Net Profit from all Panipuri sells
	
	add $t5, $t5, $t6															#t5 = Net Profit from all sales so far
	
	li $v0, 4
	la $a0, net_prof_msg
	syscall
	
	li $v0, 1
	move $a0, $t5
	syscall
	
compare:
	
	la $a1, goal
	lw $t7, ($a1)
	
	li $v0, 4
	la $a0, newline
	syscall
	
	beq $t7, $t5, printtrue														#IF t7 == t5 then branch to print true
	b printfalse																#else branch to print false
	
printfalse:
	
	li $v0, 4
	la $a0, false_msg
	syscall
	
	li $v0, 1
	lw $a0, goal
	syscall
	
	li $v0, 4
	la $a0, full_stop
	syscall
	
	j exit 

printtrue:

	li $v0, 4
	la $a0, true_msg
	syscall
	
	li $v0, 1
	lw $a0, goal
	syscall
	
	li $v0, 4
	la $a0, full_stop
	syscall
	
	j exit
	
exit:

	li $v0, 10
	syscall
