import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) {
		// 双亲委派模型，加载自己编好的Class文件和加载父ClassLoader已经加载过的类都没有问题
		// 其中加载父ClassLoader加载过的类，并没有通过自定义加载器进行加载

		findClassLoadHello(); //删掉注释即可测试

		// findClassLoadObject(); //删掉注释即可测试

		// 非双亲委派模型

		/*
		 * 由于Hello依赖Object，在加载Object时无法加载导致NoClassDefFoundError
		 */
		// loadClassLoadHello(); //删掉注释即可测试

		/*
		 * 直接没有找到Object的方法
		 */
		// loadClassLoadObject(); //删掉注释即可测试
	}

	// 双亲委派，加载已经编好的Class文件
	private static void findClassLoadHello() {
		FindClassLoader findClassLoader = new FindClassLoader();
		try {
			Class<?> helloClazz = Class.forName("Hello", true, findClassLoader);
			Method method = helloClazz.getMethod("getMessage");
			System.out.println("findClassLoader,Hello->getMessage:" + method.invoke(null) + ",ClassLoader:"
					+ helloClazz.getClassLoader());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 双亲委派，加载已经系统已经载入的Class文件：java.lang.Object
	private static void findClassLoadObject() {
		FindClassLoader findClassLoader = new FindClassLoader();
		try {
			Class<?> objClazz = Class.forName("java.lang.Object", true, findClassLoader);
			Method method = objClazz.getMethod("toString");
			System.out.println("findClassLoader,Object->toString:" + method.invoke(objClazz.newInstance())
					+ ",ClassLoader:" + objClazz.getClassLoader());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void loadClassLoadHello() {
		LoadClassLoader loadClassLoader = new LoadClassLoader();
		try {
			Class<?> helloClazz = Class.forName("Hello", true, loadClassLoader);
			Method method = helloClazz.getMethod("getMessage");
			System.out.println("loadClassLoader,Hello->getMessage:" + method.invoke(null) + ",ClassLoader:"
					+ helloClazz.getClassLoader());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void loadClassLoadObject() {
		LoadClassLoader loadClassLoader = new LoadClassLoader();
		try {
			Class<?> objClazz = Class.forName("java.lang.Object", true, loadClassLoader);
			Method method = objClazz.getMethod("toString");
			System.out.println("findClassLoader,Object->toString:" + method.invoke(objClazz.newInstance())
					+ ",ClassLoader:" + objClazz.getClassLoader());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
