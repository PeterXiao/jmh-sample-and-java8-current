package versions.java8.concurrence;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class CLHLock {
	private static Unsafe unsafe = null;
	private static final long valueOffset;
	private volatile CLHNode tail;
	public class CLHNode {
		private boolean isLocked = true;
	}
	static {
		try {
			unsafe = getUnsafeInstance();
			valueOffset = unsafe.objectFieldOffset(CLHLock.class.getDeclaredField("tail"));
		} catch (Exception ex) {
			throw new Error(ex);
		}
	}
	public void lock(CLHNode currentThreadNode) {
		CLHNode preNode = null;
		for (;;) {
			preNode = tail;
			if (unsafe.compareAndSwapObject(this, valueOffset, tail, currentThreadNode))
				break;
		}
		if (preNode != null)
			while (preNode.isLocked) {}
	}
	public void unlock(CLHNode currentThreadNode) {
		if (!unsafe.compareAndSwapObject(this, valueOffset, currentThreadNode, null))
			currentThreadNode.isLocked = false;
	}
	private static Unsafe getUnsafeInstance()
			throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
		theUnsafeInstance.setAccessible(true);
		return (Unsafe) theUnsafeInstance.get(Unsafe.class);
	}
}
