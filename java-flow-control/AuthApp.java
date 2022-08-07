
public class AuthApp {

	public static void main(String[] args) {

		String id = "egoing";
		String inputId = args[0];

		String pass = "1111";
		String inputPass = args[1];

		System.out.println("Hi.");

		//if(inputId == id) {  // "==": 주소를 비교, .equals: 대상의 내용을 비교
//		if(inputId.equals(id)) {
//			if(inputPass.equals(pass)) {
//				System.out.println("Master!");
//			} else {
//				System.out.println("Wrong password!");
//			}
//		} else {
//			System.out.println("Who are you?");
//		}
		
		if(inputId.equals(id) && inputPass.equals(pass)) {
				System.out.println("Master!");
		} else {
			System.out.println("Who are you?");
		}
	}

}
