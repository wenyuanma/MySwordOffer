package q2_singleton;

public class LazySingleton {
	//将instance声明为 volatile，这样就不会使得instance = new LazySingleton() 这个初始化操作重排导致的问题
	//对于一个 volatile 变量的写操作都先行发生于后面对这个变量的读操作（这里的“后面”是时间上的先后顺序）
	private volatile static LazySingleton instance;

	private LazySingleton(){}
	//double-check + 同步锁
	public LazySingleton getInstance(){
		if(instance==null){
			synchronized(LazySingleton.class){
				if(instance==null){
					instance = new LazySingleton();
				}
			}
		}
		return instance;
	}
	
}
