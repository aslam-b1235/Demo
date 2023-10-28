package testPack;

import org.testng.annotations.DataProvider;

public class DemoDataProvider {
	@DataProvider(name="DemoData")
	public String[][] userNamePassword()
	{
		String data[][]= {{"abc","abc123"},{"pqr","pqr123"},{"stuv","stuv123"}};
		return data;
	}
	

}
