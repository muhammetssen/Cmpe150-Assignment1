public class Stairs {
	public static void main(String[] args) {
		//int stickmanHeight = Integer.parseInt(args[0]);
		//int stairHeight = Integer.parseInt(args[1]);
		int stickmanHeight = 10, stairHeight = 6;
		stairs(stairHeight,stickmanHeight);
	}
	
	
	public static void stairs(int stairHeight,int stickmanHeight) {
		multiple_print(stairHeight,"\n");
		String head_shape = " O ", torso_shape = "/|\\ ",body_shape = " | ", leg_shape = "/ \\";
		int current_level = stairHeight; // Top stair's index is 0. At the begining, stickman is at the bottom whose index equals to stairHeight
		for (int level = 0; level <=stairHeight; level++) { // Top To Bottom. Printing every stair of a frame.
			String space_on_left = "";
			space_on_left = multiplier(stairHeight-current_level, "   ");
			
			// Stickman's height and torso are always higher than the stairs. We don't need to adjust these according to variables. 
			System.out.println(space_on_left + head_shape);
			System.out.println(space_on_left + torso_shape);
			
			/* I will use 3 separate for loops. 
			   First situation is that there are no stairs at the right of the '|' part. Printing spaces and ' I ' is enough.
			   Second situation is that there are both a body part, underscores and stars in a line. Printing order is spaces, " | ", underscores, stars and '|'.
			   Third situation is that stickman has already climbed those stairs so printing only the stair structure is enough. There is no need to evaulate stickman's position. */
			   

			//First Situation - Printing the body only
			int body_parts = stickmanHeight - 3; // Number of the '|' parts .   Total Height - 1(for head) - 1(for torso) - 1(for legs). 
			int above_stairs = body_parts-current_level; // How many of '|' parts satisfy the condition for the first situation
			int printed_body_parts = 0; // Number of  '|' parts I have printed
			/*for (int i = 0; i < above_stairs; i++) { // Printing adequate spaces on left and the body itself. 
				System.out.println(space_on_left + body_shape);
				//printed_body_parts++; // Every line means one more '|' has printed. 
			}*/
			multiple_print(above_stairs, space_on_left + body_shape + "\n");
			printed_body_parts += above_stairs;
			
			/* Printing a body part and a stair at the same line*/
			int remained_body_parts = body_parts - printed_body_parts;
			int drawing_step = 0; //Bottom one = 2
			for (int i = 0; i < remained_body_parts; i++) { // Each loop is a new line
				System.out.print(space_on_left + body_shape);
				/*for (int j = current_level-drawing_step; j>0 ; j--) {
					System.out.print("   ");
				}*/
				multiple_print(current_level-drawing_step,"   ");
				star_printer(drawing_step);
				drawing_step++;
				
			}
			/*Printing legs and a stair*/
			System.out.print(space_on_left + leg_shape);
			multiple_print(current_level-drawing_step,"   ");
			star_printer(drawing_step);
			drawing_step++;
			
			
			
			/* Printing without any body or leg*/
			for (; drawing_step <=stairHeight ; drawing_step++) { //Each loop is a new line
				
			/*
			for (int j = stairHeight-drawing_step+1; j>0 ; j--) {
				System.out.print("   ");
			}*/
			multiple_print(stairHeight-drawing_step+1, "   ");

			star_printer(drawing_step);
			}
			
			/*
			for (int i = 0; i < current_level+2; i++) {
				System.out.println();
			}*/
			multiple_print(current_level+2, "\n");
			
			current_level--;
			
		} 
	}
	
	public static void star_printer(int count) {
		System.out.print("___|");
		multiple_print(count, "***");
		System.out.println('|');
	}

	public static void multiple_print(int count, String text){
		System.out.print(multiplier(count, text));
	}
	
	public static String multiplier(int count, String text){
		String result = "";
		for (; count >0 ; count --) 
			result += text;
		return result;
	}
}
