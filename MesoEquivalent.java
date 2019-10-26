import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class MesoEquivalent {

	private String stId = "";

	public MesoEquivalent(String stId) {
		this.stId = stId;
	}

	public HashMap<String, Integer> calAsciiEqual() {
		HashMap<String, Integer> equal = new HashMap<String, Integer>();
		MesoAsciiCal getAvg = new MesoAsciiCal(this.stId);
		int average = getAvg.calAverage();

		try {
			File given = new File("Mesonet.txt");
			Scanner in = new Scanner(given);

			boolean hasNext = in.hasNext();
			int i = 0;
			boolean hasInt = false;

			while (hasNext) {
				String station = in.next();
				int sum = 0;

				for (Integer j = 0; j < 10; ++j) {
					// find out if the string has a number in it
					if (station.contains(j.toString())) {
						hasInt = true;
					}
				}

				if (!hasInt) {
					for (int j = 0; i < 4; ++i) {
						sum += (int) station.charAt(j);
					}

					int avg = (int) Math.round(sum / 4.0);

					if (avg == average) {
						equal.put(station, avg);
					}

				}

				// find out if theres more to be read
				hasNext = in.hasNext();
				// increase the counter for key
				++i;
			}

			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("SOmeThIng WenT WroNg");
		}

		return equal;
	}

}
