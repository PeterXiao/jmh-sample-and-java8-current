package versions.java8.concurrence.jdk;

import static java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE;

import java.lang.reflect.Field;

public final class Unsafe {

	private static native void registerNatives();

	static {
		registerNatives();
	}

	private Unsafe() {
	}

	private static final Unsafe theUnsafe = new Unsafe();
	private static StackWalker walker = StackWalker.getInstance(RETAIN_CLASS_REFERENCE);

	public static Unsafe getUnsafe_old() {
		Class<?> caller = walker.getCallerClass();// Reflection.getCallerClass();
//		if (!VM.isSystemDomainLoader(caller.getClassLoader()))
//			throw new SecurityException("Unsafe");
		return theUnsafe;
	}

	private static Unsafe getUnsafe() throws Exception {
		Field f = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
		f.setAccessible(true);
		return (Unsafe) f.get(null);
	}

	public final native boolean compareAndSwapInt(Object o, long offset, int expected, int x);

	public final native boolean compareAndSwapLong(Object o, long offset, long expected, long x);

	public final native boolean compareAndSwapObject(Object o, long offset, Object expected, Object x);

	public native void park(boolean isAbsolute, long time);

	public native void unpark(Object thread);

}
