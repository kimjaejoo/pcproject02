package co.kr.jaejoo.field;

import java.lang.reflect.Field;

public class RefUser {
	
	// 리플렉션을 하기위한 클래스 입니다. 
	// 하나의 클래스에서 다른클래스의 정보를 알아낼수 있는 개념
	// 또한 그 클래스로 만든객체까지 주어준다면 그 객체들의 값을 바꿀수 있는 것
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		// 지도클래스 선언
		Class<?> clazz = RefObject.class;
		
		// 지도에서 필드들을 받아와서 출력
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields){
			System.out.println(field.getName());
		}
			
		// 필드를 받아옴. clazz에서  getDeclaredFields("필드명"); 해도됨.
		Field field = fields[0];
		// 객체를 만들어 객체의 값을 변경
		
		RefObject refObject = new RefObject();
		field.setInt(refObject, 3);
		System.out.println("넘버 아이디는 : " + refObject.getNumId());
	}
}
