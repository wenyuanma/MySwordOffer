package q2_singleton;

public class HungerSingleton {
	//注意声明成final类型的
	private static final HungerSingleton instance = new HungerSingleton();
	
	private HungerSingleton(){};
	
	public HungerSingleton getInstance(){
		return instance;
	}

}
