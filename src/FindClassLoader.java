import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FindClassLoader extends ClassLoader {

	public FindClassLoader() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		System.out.println("find:" + name);
		byte[] bytes = paraseClassByName(name);
		if (bytes == null) {
			System.out.println("find failed:" + name);
			return null;
		}
		return defineClass(name, bytes, 0, bytes.length);
	}

	private byte[] paraseClassByName(String name) {
		File file = new File(name + ".class");
		if (!file.exists()) {
			return null;
		}
		byte[] bytes = new byte[(int) file.length()];
		try {
			FileInputStream fis = new FileInputStream(file);
			fis.read(bytes);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytes;
	}

}
