package yieldbook;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class CumRetCalulator {

	private final List<Date> dateList;
	private final List<Double> cumulativeValueList;
	private Map<Date, Double> dailyReturns = new HashMap<Date, Double>();

	public CumRetCalulator(Map<Date, Double> dailyReturns) {
		this.dailyReturns = dailyReturns;
		dateList = new ArrayList<Date>();
		cumulativeValueList = new ArrayList<Double>();
	}

	/*
	 * Return the cumulative return for each date in 'dates' from 'base' date
	 */
	public Map<Date, Double> findCumReturn(final Collection<Date> dates, final Date base) {
		preProcessDailyReturns(base);
		final Map<Date, Double> result = new LinkedHashMap<Date, Double>();

		for (final Date date : dates) {
			result.put(date, findCumReturn(date, base));
		}
		return result;
	}

	/*
	 * Calculate cumulative return for date 'asof', from 'base' date.
	 */
	public double findCumReturn(final Date asof, final Date base) {
		if (asof.before(base))
			return 0.0;
		return getCumulativeReturn(asof);
	}

	/*
	 * This function pre-process the daily returns and creates an
	 * cumulativeValueList for the dates which are greater than the base date.
	 * This way there is no need to sort all the dates and also it avoids
	 * recalculation by maintaining a cumulativeValueList.
	 */
	private void preProcessDailyReturns(final Date base) {
		for (final Date date : dailyReturns.keySet()) {
			if (date.after(base))
				dateList.add(date);
		}

		Collections.sort(dateList);

		Double value = 1.0;
		for (int i = 0; i < dateList.size(); i++) {
			value *= 1 + dailyReturns.get(dateList.get(i));
			cumulativeValueList.add(value - 1);
		}
	}

	private Double getCumulativeReturn(final Date asof) {
		final int a = binarySearch(asof);
		if (a < 0)
			return 0.0;

		return cumulativeValueList.get(a);
	}

	/*
	 * This function uses binarySerach to search an date(key) in the already
	 * maintained sorted dateList
	 */
	private int binarySearch(final Date key) {

		if (dateList == null || dateList.size() < 1)
			return -1;

		int start = 0;
		int end = dateList.size() - 1;

		if (key.before(dateList.get(start)))
			return -1;

		if (key.after(dateList.get(end)))
			return end;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (key.before(dateList.get(mid))) {
				end = mid - 1;
			} else if (key.after(dateList.get(mid))) {
				start = mid + 1;
			} else
				return mid;
		}
		return start - 1;
	}

	public static void main(String[] args) throws ParseException {

		Map<Date, Double> dailyReturns = new HashMap<Date, Double>();
		dailyReturns.put(parseDate("2015-01-10"), .10);
		dailyReturns.put(parseDate("2015-02-10"), .05);
		dailyReturns.put(parseDate("2015-04-10"), .15);
		dailyReturns.put(parseDate("2015-04-15"), -.10);
		dailyReturns.put(parseDate("2015-06-10"), -.10);

		CumRetCalulator c = new CumRetCalulator(dailyReturns);

		List<Date> question = new ArrayList<Date>();
		question.add(parseDate("2015-01-31"));
		question.add(parseDate("2015-02-28"));
		question.add(parseDate("2015-03-30"));
		question.add(parseDate("2015-04-30"));
		question.add(parseDate("2015-06-30"));

		Map<Date, Double> resultMap = c.findCumReturn(question, parseDate("2015-02-01"));
		final DecimalFormat cumulativeValueFormat = new DecimalFormat("#.######");
		final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		for (Date date : resultMap.keySet()) {
			System.out.println(dateFormat.format(date) + " , "
					+ Double.valueOf(cumulativeValueFormat.format(resultMap.get(date))));
		}
	}

	public static Date parseDate(final String date) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	}
}

/*
 * Sample Output: 
 * 2015-01-31 , 0.0 
 * 2015-02-28 , 0.05 
 * 2015-03-30 , 0.05
 * 2015-04-30 , 0.08675 
 * 2015-06-30 , -0.021925
 */
