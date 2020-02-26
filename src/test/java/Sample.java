import java.io.IOException;
import java.util.ArrayList;

public class Sample {

	public static void main(String[] args) throws IOException {
		
		DataDriven d = new DataDriven();
		ArrayList a =d.getData("purchase");
		System.out.println(a.get(1));
		a.get(1);
		
		// TODO Auto-generated method stub

	}

}
