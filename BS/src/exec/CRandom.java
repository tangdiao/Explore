package exec;

//随机数类
public class CRandom {
	// 随机数的最大范围值
	private int maxNumber = 0;

	// 随机数
	private int rand = 0;

	// 构造函数
	public CRandom() {
	}

	// 重载构造函数，产生一个随机数
	public CRandom(int init) {
		setMaxNumber(init);
	}

	// 随机数最大范围值的设置函数
	public void setMaxNumber(int num) {
		if (num < 0)
			maxNumber = 0;
		else
			maxNumber = num;

		// 产生随机数
		generateRandom();
	}

	// 产生一个随机数，值位于1到最大范围值之间
	public void generateRandom() {
		rand = (int) (Math.random() * maxNumber) + 1;
	}

	// 随机数的读取函数
	public int getRandom() {
		return rand;
	}
}
