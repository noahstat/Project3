import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class MesoAsciiCal extends MesoAsciiAbstract {

	private String STID = "";
	private String NRMN = "NRMN";

	public MesoAsciiCal(MesoStation mesoStation) {
		this.STID = mesoStation.getStID();
	}
	
	public MesoAsciiCal() {
		this.STID = NRMN;
	}

	public MesoAsciiCal(String stId2) {
		this.STID = stId2;
	}

	public String calAsciiEqual() {
		HashMap<String, Integer> equal = new HashMap<String, Integer>();
		int average = calAverage();

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

		String toReturn = "";
		int i = 0;

		for (String key : equal.keySet()) {
			if (i != equal.size() - 1) {
				toReturn += key + equal.get(key) + "\n";
			} else {
				toReturn += key + equal.get(key);
			}
			
			System.out.println(key + ", " + equal.get(key));

			++i;
		}

		return toReturn;
	}

	@Override
	int calAverage() {
		int nAveCeil;
		int nAveFloor;
		int nAveIf;
		int sum = 0;
		for (int i = 0; i < 4; ++i) {
			sum += (int) STID.charAt(i);
		}
		
		// find the average now
		nAveCeil = (int) Math.ceil(sum / 4.0);
		nAveFloor = (int) Math.floor(sum / 4.0);
		
		if ((sum / 4.0) % 1 >= 0.25) {
			nAveIf = (int) Math.ceil(sum / 4.0);
		} else {
			nAveIf = (int) Math.floor(sum / 4.0);
		}

		int NRMNAve = (int) Math.round((nAveCeil + nAveFloor + nAveIf) / 3.0);

		return NRMNAve;

	}
}