package OTS.Opencart.Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	
	int count=0;
	int maxcount=2;
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxcount)
		{
			count++;
			return true;
		}
		return false;
	}

}
