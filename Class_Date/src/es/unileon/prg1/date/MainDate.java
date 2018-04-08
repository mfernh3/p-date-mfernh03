package es.unileon.prg1.date;

public class MainDate {

	public static void main(String[] args) {

		Date today;

		try {
			today = new Date(16, 2, 2018);
			System.out.println(today.toString());
			System.out.println(today.getMonthName());
			System.out.println(today.isDayRight(31));
			System.out.println(today.isDayRight(32));
			System.out.println(today.getSeasonName());
			System.out.println(today.getMonthsLeft());
			System.out.println(today.toString());
			System.out.println(today.getDaysLeftOfMonth());
			System.out.println(today.toString());
			System.out.println(today.daysPast());
			System.out.println(today.toString());
			System.out.println(today.getMonthsSameDays());
			System.out.println(today.toString());
			System.out.println(today.numRandomTriesEqualDate1());
			System.out.println(today.toString());
			System.out.println(today.numRandomTriesEqualDate2());
			System.out.println(today.toString());
			System.out.println(today.dayOfWeek(1));
			System.out.println(today.dayOfWeek(3));
			System.out.println(today.dayOfWeek(4));
			System.out.println(today.dayOfWeek(7));
			today.setDay(4);
			System.out.println(today.toString());
			today.setMonth(7);
			System.out.println(today.toString());
			today.setYear(20174);
			System.out.println(today.toString());
			today.setDay(56);
			System.out.println(today.toString());
			today.setMonth(13);
			System.out.println(today.toString());
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}

	}

}
