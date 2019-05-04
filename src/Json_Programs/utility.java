package Json_Programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONObject;
	import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

	public class utility {
		static Scanner sc = new Scanner(System.in);
	    
		public static int inputInt() {

			int a = sc.nextInt();
	           
			return a;

		}
		
		public static String inputString() {

			String a = sc.next();

			return a;

		}
		
		public static String inputStringLong() {
			Scanner sout=new Scanner(System.in);
			String b = sout.nextLine();

			return b;

		}

		public static double inputDouble() {

			double a = sc.nextDouble();

			return a;
		}
		
		
		public static long inputLong() {

			long a = sc.nextLong();

			return a;
		}
		
		public static boolean inputBoolean() {

			boolean a = sc.nextBoolean();

			return a;
		}

	

	
		
		

		public static <T extends Comparable<T>> void printsArray(T[][] array,int row ,int column){
			
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					System.out.println(array[i][j]+" ");
				}
				System.out.println( );
					}
		
		}
		
		
		


	

		//object oriented
		
		/**Function read the json file and content of json to object 
		 * @param file json file 
		 * @return json object
		 * @throws ParseException 
		 * @throws IOException 
		 */
		public JSONObject ObjectReading(String file) throws IOException, ParseException {

			JSONParser parser = new JSONParser();
			JSONObject jsonobject = null;
			
				FileReader read = new FileReader(
						"/home/admin1/eclipse-workspace/ObjectOriented_json/clinicmanagementnew/" + file + ".json");
				Object object = parser.parse(read);
				jsonobject = (JSONObject) object;
			

			return jsonobject;

		}
		
		
		
		

	}


