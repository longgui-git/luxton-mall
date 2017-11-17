package com.luxton.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 各种id生成策略
 * @author	whao
 */
public class IDUtils {

	/**
	 * 图片名生成
	 */
	public static String getImageName() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
//		Random random = new Random();
//		int end3 = random.nextInt(999);
//		//如果不足三位前面补0
//		String str = millis + String.format("%03d", end3);
		
		return millis+"";
	}
	
	public static String getFileMillisNum(int start) {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
//		Random random = new Random();
//		int end3 = random.nextInt(999);
//		//如果不足三位前面补0
//		String str = millis + String.format("%03d", end3);
		
		return (millis+"").substring(start);
	}
	
	/**
	 * 商品id生成
	 */
	public static long getItemId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
	
	public static void main(String[] args) {
		for(int i=0;i< 100;i++)
		System.out.println(getItemId());
	}
	
	public static String getRandom6() {
	
		Random random = new Random();
		int end2 = random.nextInt(999999);
		//如果不足两位前面补0
		String str = String.format("%06d", end2);
		return str;
	}
	
	public static Integer getRandom6(int max) {
		
		Random random = new Random();
		int end2 = random.nextInt(max);
		
		return end2;
	}
	
	public static String getRandom4() {
		
		Random random = new Random();
		int end2 = random.nextInt(9999);
		
		//如果不足两位前面补0
		String str = String.format("%04d", end2);
		return str;
	}
	
	
	public static String getNonceStr() {
		// 随机数
		String currTime = getCurrTime();
		// 8位日期
		
		String strTime = currTime.substring(7, currTime.length());
		// 四位随机数
		String strRandom = buildRandom(4) + "";
		// 10位序列号,可以自行调整。
		return strTime + strRandom;
	}
	
	public static String getCurrTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}
	
	/**
	 * 取出一个指定长度大小的随机正整数.
	 * 
	 * @param length
	 *            int 设定所取出随机数的长度。length小于11
	 * @return int 返回生成的随机数。
	 */
	public static int buildRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}
	
}
