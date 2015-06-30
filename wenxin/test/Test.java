package wenxin.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

import com.github.sardine.DavResource;
import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;

public class Test {
	public static void main(String[] args) {


		try {
			URL url = new URL("http://10.1.51.26:8080/opencms/webdav/overview/text.txt");
			String encoding = Base64.encodeBase64String("Admin:admin".getBytes());
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", "Basic " + encoding);
			InputStream content = (InputStream) connection.getInputStream();

			BufferedReader in = new BufferedReader(new InputStreamReader(content));
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}

			Sardine sardine = SardineFactory.begin("Admin", "admin");
			List<DavResource> resources = null;
			try {
				// sardine.createDirectory("http://10.1.51.26:8080/opencms/webdav/login");
				// sardine.get("http://10.1.51.26:8080/opencms/webdav/overview/text.txt");
				// sardine.createDirectory("http://10.1.51.26:8080/opencms/webdav/overview/created");
				// System.out.println(sardine.exists("http://10.1.51.26:8080/opencms/webdav/overview/created/3.txt"));
				// sardine.createDirectory("http://10.1.51.26:8080/opencms/webdav/RTCM/");
				// sardine.createDirectory("http://10.1.51.26:8080/opencms/webdav/RTCM/fileUpload");
				// System.out.println(sardine.exists("http://10.1.51.26:8080/opencms/webdav/overview/created/3.txt"));
				// sardine.delete("http://localhost:8080/RTCM-Server/a.txt");
				/*
				 * sardine.copy("http://localhost:8080/RTCM-Server/a.txt",
				 * "http://10.1.51.26:8080/opencms/webdav/overview/created/3.txt"
				 * , true);
				 */
				// sardine.move("http://10.1.51.26:8080/opencms/webdav/overview/created/3.txt",
				// "http://localhost:8080/examples/a.txt");
				// sardine.put("http://localhost:8080/examples/a.txt", data);
				// sardine.move("http://localhost:8080/examples/a.txt",
				// "http://10.1.51.26:8080/opencms/webdav/overview/created/4.txt");
				byte[] data = { 'a', 'b' };
				sardine.put("http://10.1.51.26:8080/opencms/webdav/RTCM/fileUpload/ab.txt", data);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}