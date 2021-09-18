package practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteExecution1 {
	@Test
	public void remoteExecutionOnAWS() throws MalformedURLException {
		URL url = new URL("http://192.168.1.21:4444/wd/hub");
		// URL url = new URL("http://18.222.206.59:4444/wd/hub");// remote in aws
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		RemoteWebDriver driver = new RemoteWebDriver(url, cap);
		driver.get("http://gmail.com");
	}
}
