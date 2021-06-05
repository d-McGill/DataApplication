package dataPackage;


public class Application {

	public static void main(String[] args) {
		new Frame();
		Reader reader = new Reader();
		
		try {
			reader.loadData(Frame.getPath());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
