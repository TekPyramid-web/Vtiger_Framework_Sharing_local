package practicePom;

import java.util.Date;

public class practie {

	public static void main(String[] args) {

		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		System.out.println(time);
	}

}
