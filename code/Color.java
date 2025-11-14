import java.util.Scanner;

/**
 * console color management
 * methods can be staticly imported
 *
 * @author YBZ
 * @version 2.0.1
 */
public class Color
{
	private static Scanner s = new Scanner(System.in);

	public static final String RESET = "\u001B[0m";
	
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	
	public static final String BRIGHT_BLACK = "\u001B[90m";
	public static final String BRIGHT_RED = "\u001B[91m";
	public static final String BRIGHT_GREEN = "\u001B[92m";
	public static final String BRIGHT_YELLOW = "\u001B[93m";
	public static final String BRIGHT_BLUE = "\u001B[94m";
	public static final String BRIGHT_PURPLE = "\u001B[95m";
	public static final String BRIGHT_CYAN = "\u001B[96m";
	public static final String BRIGHT_WHITE = "\u001B[97m";
	
	public static final String BLACK_BG = "\u001B[40m";
	public static final String RED_BG = "\u001B[41m";
	public static final String GREEN_BG = "\u001B[42m";
	public static final String YELLOW_BG = "\u001B[43m";
	public static final String BLUE_BG = "\u001B[44m";
	public static final String PURPLE_BG = "\u001B[45m";
	public static final String CYAN_BG = "\u001B[46m";
	public static final String WHITE_BG = "\u001B[47m";
	
	public static final String BRIGHT_BLACK_BG = "\u001B[100m";
	public static final String BRIGHT_RED_BG = "\u001B[101m";
	public static final String BRIGHT_GREEN_BG = "\u001B[102m";
	public static final String BRIGHT_YELLOW_BG = "\u001B[103m";
	public static final String BRIGHT_BLUE_BG = "\u001B[104m";
	public static final String BRIGHT_PURPLE_BG = "\u001B[105m";
	public static final String BRIGHT_CYAN_BG = "\u001B[106m";
	public static final String BRIGHT_WHITE_BG = "\u001B[107m";
	
	public static final String CLEAR = "\033[H\033[2J";
	
	
	/**
	 * resets the color and background color of console
	 * 
	 * @since 1.0.0
	 */
	public static void reset()
	{
		System.out.print(Color.RESET);
	}

	/**
	 * clears console screen
	 * 
	 * @since 1.0.0
	 */
	public static void clearScreen()
	{
		System.out.println(Color.CLEAR);
	}

	/**
	 * changes screen color
	 * 
	 * @since 2.0.0
	 */
	public static void color(String color)
	{
		System.out.println(color);
	}

	/**
	 * pauses the screen
	 * 
	 * @since 2.0.1
	 */
	public static void pause()
	{
		s.nextLine();
	}
}