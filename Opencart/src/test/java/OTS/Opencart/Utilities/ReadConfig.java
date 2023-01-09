package OTS.Opencart.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	Properties prop;

	public ReadConfig() {
		File src = new File(System.getProperty("user.dir") + "\\Configuration\\Config.Properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception message is" + e.getMessage());
		}

	}

	public String getFirstName() {
		String firstName = prop.getProperty("firstname");
		return firstName;
	}

	public String getLastName() {
		String lastName = prop.getProperty("Lastname");
		return lastName;
	}

	public String getEmail() {
		String email = prop.getProperty("emaildomain");
		return email;
	}

	public String getNumber() {
		String number = prop.getProperty("number");
		return number;
	}

	public String getPassword() {
		String password = prop.getProperty("pswrd");
		return password;
	}

	public String confirmPassword() {
		String confirmedpassword = prop.getProperty("psswrd");
		return confirmedpassword;
	}

	public String getURL() {
		String url = prop.getProperty("baseURL");
		return url;
	}
}
