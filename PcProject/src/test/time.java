package test;

import java.util.Calendar;

public class time {
	public static void main(String[] args) {
		/*Calendar date3 = Calendar.getInstance();
		date3.setTimeInMillis(System.currentTimeMillis());

		//시작시간을 저장하고 저장된 값에서 나중 시간의 값을 빼야한다.....
		
		Calendar date4 = Calendar.getInstance();
		date4.setTimeInMillis(System.currentTimeMillis() + 1000 * 60 * 6);
	
		System.out.println("지금시간 : " + date3.get(Calendar.HOUR)+"시"+date3.get(Calendar.MINUTE)+"분");
		
		System.out.println("사용시간부터 지금까지 : " + date4.get(Calendar.HOUR) +"시"+date4.get(Calendar.MINUTE));

		long differ = (date4.getTimeInMillis() - date3.getTimeInMillis()) / 1000;
		
		System.out.println("사용시간부터 지금까지 : " + differ / 60 + "분 지났습니다.");
		
		
		/////////////////////////////////////////////////////////////////////
		long start = System.currentTimeMillis();
		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 ); */

		
		long start1 = System.currentTimeMillis(); // 시작시간 
		System.out.println("시작시간:"+start1);

		//이 안에 내용물들이 들어가면 됩니다.

		long end1 = System.currentTimeMillis(); //종료시간
		System.out.println("종료시간:"+end1);


		System.out.println((end1-start1)+" milliseconds");
	}
}