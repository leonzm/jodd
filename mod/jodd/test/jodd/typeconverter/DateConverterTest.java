// Copyright (c) 2003-2011, Jodd Team (jodd.org). All Rights Reserved.

package jodd.typeconverter;

import jodd.datetime.JDateTime;
import jodd.typeconverter.impl.DateConverter;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class DateConverterTest extends BaseTestCase {
	
	private static long time = new JDateTime(2011, 11, 1, 9, 10, 12, 567).getTimeInMillis();

	public void testNull() {
		assertNull(DateConverter.valueOf(null));
	}

	public void testCalendar2Date() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		Date date = DateConverter.valueOf(calendar);
		assertEquals(time, date.getTime());
	}

	public void testDate2Date() {
		Date date2 = new Date(time);
		Date date = DateConverter.valueOf(date2);
		assertEquals(time, date.getTime());
	}

	public void testTimestamp2Date() {
		Timestamp timestamp = new Timestamp(time);
		Date date = DateConverter.valueOf(timestamp);
		assertEquals(time, date.getTime());
	}

	public void testSqlDate2Date() {
		java.sql.Date date2 = new java.sql.Date(time);
		Date date = DateConverter.valueOf(date2);
		assertEquals(time, date.getTime());
	}

	public void testSqlTime2Date() {
		Time sqltime = new Time(time);
		Date date = DateConverter.valueOf(sqltime);
		assertEquals(time, date.getTime());
	}

	public void testJDateTime2Date() {
		JDateTime jdt = new JDateTime(time);
		Date date = DateConverter.valueOf(jdt);
		assertEquals(time, date.getTime());
	}
	

	@SuppressWarnings( {"deprecation"})
	public void testConversion() {
		assertNull(DateConverter.valueOf(null));

		assertEquals(new Date(885858), DateConverter.valueOf("885858"));
		assertEquals(new Date(123), DateConverter.valueOf(Integer.valueOf(123)));

		Date date = new Date(111, 0, 1);
		assertEquals(date, DateConverter.valueOf("2011-01-01"));

		date = new Date(111, 0, 1, 10, 59, 55);
		assertEquals(date, DateConverter.valueOf("2011-01-01 10:59:55"));
	}
}

