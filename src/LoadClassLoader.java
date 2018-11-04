import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadClassLoader extends ClassLoader {
	public LoadClassLoader() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		System.out.println("load:" + name);
		byte[] bytes = paraseClassByName(name);
		if (bytes == null) {
			System.out.println("load failed:" + name);
			return null; // 其实这里返回super.loadClass(name)也可以work，这样就会调用父的ClassLoader
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
