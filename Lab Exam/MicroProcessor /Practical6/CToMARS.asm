#Convert the given C code to MARS MIPS Assembly Language

#int main() {
	
#				int i;
	
#				for (i = 1; i <=3; i++) {
				
#											printf("%d\n", i);
											
#				}
				
#				return 0;
				
#}
				  

.data

	newline: .asciiz "\n"
	
.text

	main:

		li $t0, 1									#int i = 1
		
		loop:
		
			bgt $t0, 3, termination					#break the loop if i > 3
			
			li $v0, 1								
			move $a0, $t0
			syscall									#Print the value of i
			
			li $v0, 4
			la $a0, newline
			syscall									#Print \n
			
			addi $t0, $t0, 1						#i++
			
			b loop
			
		termination:
		
			li $v0, 10
			syscall									#Terminates the program