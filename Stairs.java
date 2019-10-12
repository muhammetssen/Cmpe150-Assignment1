public class Stairs {
	public static void main(String[] args) {
		//int stickmanHeight = Integer.parseInt(args[0]);
		//int stairHeight = Integer.parseInt(args[1]);
		int stickmanHeight = 7, stairHeight = 3;
		stairs(stairHeight,stickmanHeight);
	}
	
	
	public static void stairs(int stairHeight,int stickmanHeight) {
		for (int i = 0; i < stairHeight; i++) {
			System.out.println();
		}
		String head_shape = " O ", torso_shape = "/|\\ ",body_shape = " | ", leg_shape = "/ \\";
		int width = 3*stairHeight + 3 + 3 + 2;// 3*stars + man + step + |
		int current_level = stairHeight; // Top one is 0
		for (int level = 0; level <=stairHeight; level++) { // Top To Bottom 
			String space_on_left = "";
			for (int i = 0; i < stairHeight-current_level; i++) {
				space_on_left +="   ";
			}
			
			// Stickman's height and torso are always higher than the stairs. 
			System.out.println(space_on_left + head_shape);
			System.out.println(space_on_left + torso_shape);
			
			/* Printing the body above stairs*/
			int body_parts = stickmanHeight - 3;
			int above_stairs = body_parts-current_level;
			int printed_body_parts = 0; // Will increase by time
			for (int i = 0; i < above_stairs; i++) { // Printing only body parts "|"
				System.out.println(space_on_left + body_shape);
				printed_body_parts++;
			}
			
			
			/* Printing a body part and a stair at the same line*/
			int remained_body_parts = body_parts - printed_body_parts;
			int drawing_step = 0; //Bottom one = 2
			for (int i = 0; i < remained_body_parts; i++) { // Each loop is a new line
				System.out.print(space_on_left + body_shape);
				for (int j = current_level-drawing_step; j>0 ; j--) {
					System.out.print("   ");
				}
				star_printer(drawing_step);
				drawing_step++;
				
			}
			
			/*Printing legs and a stair*/
			System.out.print(space_on_left + leg_shape);
			for (int j = current_level-drawing_step; j>0 ; j--) {
				System.out.print("   ");
			}
			star_printer(drawing_step);
			drawing_step++;
			
			
			
			/* Printing without any body or leg*/
			for (; drawing_step <=stairHeight ; drawing_step++) { //Each loop is a new line
				
			
			for (int j = stairHeight-drawing_step+1; j>0 ; j--) {
				System.out.print("   ");
			}
			star_printer(drawing_step);
			}
			
			
			for (int i = 0; i < current_level+2; i++) {
				System.out.println();
			}
			
			current_level--;
			
		} 
	}
	
	public static void star_printer(int count) {
		System.out.print("___|");
		for (int i = 0; i < count; i++) {
			System.out.print("***");			
		}
		System.out.println('|');
	}
	










}
