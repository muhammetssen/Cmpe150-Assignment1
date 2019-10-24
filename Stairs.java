public class Stairs {
	public static void main(String[] args) {
		//int stickmanHeight = Integer.parseInt(args[0]);
		//int stairHeight = Integer.parseInt(args[1]);
		int stickmanHeight = 12, stairHeight = 10;	
		multiplier(stairHeight, "\n");
		String head_shape = " O ", torso_shape = "/|\\ ",body_shape = " | ", leg_shape = "/ \\";
		String space_on_left = "";
		for (int level = 0; level <=stairHeight; level++) { // Top To Bottom. Printing every stair of a frame.
			System.out.println(space_on_left + head_shape);
			System.out.println(space_on_left + torso_shape);

			multiplier(stickmanHeight-3-(stairHeight-level), space_on_left + body_shape + "\n");	

			line(stairHeight,level, space_on_left+" | ",0);

			System.out.print(space_on_left + leg_shape);
			star_printer(stairHeight-level);

			bottom(stairHeight, level-1,"");
			//System.out.println("------------------");
			//line(level+stairHeight,stairHeight,"",stairHeight-level+1); // first - second = level+1

			multiplier(stairHeight-level + 2, "\n");
			space_on_left +="   ";
		} 
	}
		
	public static void line( int stairHeight,int level,String part ,int space) {
		for (int i = 0; i < stairHeight-level; i++) {  // stair-level times
			//System.out.println("j "+i);
			//System.out.println("line : stair "+stairHeight + " level "+level+" i "+i);

			System.out.print(part);
			//System.out.println(stairHeight-i+1 + "spaces and " +i+"stars" );

			multiplier(stairHeight-level-i,"   ");
			star_printer(i+space);
		}	
	}
	
	public static void bottom (int stairHeight, int level,String part) {		
		for (int i = stairHeight-level; i <=stairHeight ; i++) { // level + 1 times iterates
			//System.out.println("i "+i);
			//System.out.println("bottom : stair "+stairHeight + " level "+level+" i "+i);
			System.out.print(part);
			//System.out.println(stairHeight-i+1 + "spaces and " +i+"stars");
			multiplier(stairHeight - i + 1, "   "); //level+1,level
			star_printer(i);
		}	
		/*for (int i = 0; i < stairHeight-level; i++) {
			System.out.print(part);
			System.out.println(stairHeight-i+1 + "spaces and " +i+"stars" );
			multiplier(stairHeight-level-i,"   ");
			star_printer(i);
			
		}*/
		
	}

	public static void star_printer(int count) {
		System.out.print("___|");
		multiplier(count, "***");
		System.out.println('|');
	}
	
	public static void multiplier(int count, String text){
		String result = "";
		for (; count >0 ; count --) 
			result += text;
		System.out.print(result);;
	}
}
