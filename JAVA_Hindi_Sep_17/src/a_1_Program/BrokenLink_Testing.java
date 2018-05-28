package a_1_Program;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLink_Testing {

	public static void main(String[] args) {
		WebDriver dr=new FirefoxDriver();
		dr.get("http://facebook.com");
		dr.manage().window().maximize();
		List<WebElement> link=dr.findElements(By.tagName("a"));
		for(int i=0;i<link.size();i++){
			System.out.println(link.get(i).getText());
			String linkUR=link.get(i).getAttribute("href");
			//url_Test_OK(linkUR);
			URL_Test(linkUR);
		}
		dr.quit();
	}
	
	public static void URL_Test(String u){
		try{
			URL url_=new URL(u);
			HttpURLConnection con=(HttpURLConnection)url_.openConnection();
			con.setConnectTimeout(2000);
			con.connect();
			if(con.getResponseCode()==200){
				System.out.println(url_+" "+con.getResponseMessage());
			}
			if(con.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
				System.out.println(url_+" "+con.getResponseMessage() +"  " +HttpURLConnection.HTTP_NOT_FOUND);
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	public static void url_Test_OK(String urllink_Test){
		try{
			URL u=new URL(urllink_Test);
			HttpURLConnection con=(HttpURLConnection)u.openConnection();
			con.setConnectTimeout(2000);
			con.connect();
			if(con.getResponseCode()==200){
				System.out.println(urllink_Test +" "+con.getResponseMessage());
			}
			if(con.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
				System.out.println(urllink_Test+" "+con.getResponseMessage()+ "   "+HttpURLConnection.HTTP_NOT_FOUND);
			}
		}catch(Exception ex){
			
		}
	}

}
