import java.util.Scanner;

public class SnackMeet {

	public static void main(String[] args) {
		String name = null;
		String snackMileOne = "";
		String snackFinalLap = "";
		String burritoFlavor = "";
		String chipsFlavor = "";
		String gatoradeFlavor = "";
		String choice = "";
		String keepPlaying = "y";
		Scanner scan = new Scanner(System.in);

		boolean running = true;
		String state = "start";

		while (running) {
			switch (state) {
			case "start":
	 			System.out.print("Welcome to the Annual Snack Meet Track Meet! "
	 					+ "\n\nWhat is your name: ");
	 			name = scan.nextLine();
	 			state = "mileOne";
				break;
			case "mileOne":
				if(runRace(scan)) {
					System.out.println("\nGreat! Head over to the starting line and get ready to race.");
					state = "snackOneBreak";
				} else {
					state = "end";
				}
				break;
			case "snackOneBreak":
				for (int i = 0; i <= 200; i++) {
					System.out.print("=");
				}
				System.out.print("\n\n**Mile One** \n\nThe starter pistol sounds off, and you get off to a good running start."
						+ " As you approach the one mile mark, you have a choice of a snack. Would you like a \"burrito\" or \"chips\": ");
				snackMileOne = scan.nextLine();
				if(snackMileOne.equalsIgnoreCase("burrito")) {
					System.out.print("Chicken or Steak? ");
					burritoFlavor = scan.nextLine();
					state = "burritoEaten";
				} else {
					System.out.print("regular of bbq? ");
					chipsFlavor = scan.nextLine();
					state = "chipsEaten";
				}
				break;
			case "burritoEaten":
				System.out.println("\nYum! A delicious " + burritoFlavor + " " + snackMileOne + ". Eat up and go finish your final mile.");
				state = "finalMile";
				break;
			case "chipsEaten":
				System.out.println("\nMmm! " + chipsFlavor + " " + snackMileOne + ", my favorite! Finish up your snack, and go run your final mile.");
				state = "FinalMile";
			case "finalMile":
				for (int i = 0; i <= 200; i++) {
					System.out.print("=");
				}
				System.out.print("\n\n**Mile Two**\n\nAs you approach your final mile, you are given the option to take a drink.\n\n"
						+ "Which would you like, \"water\" or \"gatorade\" : ");
				snackFinalLap = scan.nextLine();
				if(snackFinalLap.equalsIgnoreCase("gatorade")) {
					System.out.print("Which flavor, \"Red\" or \"Blue\" : ");
					gatoradeFlavor = scan.nextLine();
					if (gatoradeFlavor.equalsIgnoreCase("red")) {
						System.out.println("\nRed gatorade will have you dancing across the finish line.");
					} else {
						System.out.println("\nBlue is the bomb! Okay, great. Drink up and get back to running.");
					}
					state = "finish";
				} else {
					System.out.println("\nHere yo go! A cold bottle of water to keep you hydrated and cool you off before you finish your final mile.");
					state = "finish";
				}
			case "finish":
				for (int i = 0; i <= 200; i++) {
					System.out.print("=");
				}
				System.out.println("\n\n**Finish Line**\n\nAfter taking your final pit to grab a drink before the final lap, you run and finish your "
						+ "final mile, using the energy that you've gained from the snacks and drinks consumed throughout the race.");
				if(snackMileOne.equalsIgnoreCase("burrito")) {
					System.out.println("\nSorry " + name + ", you lost! Looks like while you were eating that burrito, your opponents got far out ahead of you.");
					state = "end";
				} else if (snackMileOne.equalsIgnoreCase("chips")) {
					System.out.println("Hooray! You won the race " + name + ". Opting not to eat that burrito really gave you an advantage. Now go celebrate "
							+ "and eat as many burritos as you'd like!");
					state = "end";
				}
				
			case "end":
				System.out.println("\nPlease join us next year. Goodbye!");
				System.out.print("\nContinue playing? (Enter \"y\" to continue, or \"n\" to quit): ");
				keepPlaying = scan.nextLine();
				if(keepPlaying.equalsIgnoreCase("y")) {
					state = "start";
				} else {
					System.out.println("\nThanks for playing!");
					state = "null";
					running = false;
				}
				break;
			}
			
		}
		scan.close();
	}

	private static boolean runRace(Scanner scan) {
		
		System.out.print("\nAre you ready to race? (Enter \"y\" for yes, or \"n\" for no): ");
		String choice = scan.nextLine();
		return choice.equalsIgnoreCase("y");
	}
}
