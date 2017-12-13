package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class Test11 {

	@Test
	public void test(){

	
	}
	public static String getCurrTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}
}
