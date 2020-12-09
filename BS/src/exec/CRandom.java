package exec;

//�������
public class CRandom {
	// ����������Χֵ
	private int maxNumber = 0;

	// �����
	private int rand = 0;

	// ���캯��
	public CRandom() {
	}

	// ���ع��캯��������һ�������
	public CRandom(int init) {
		setMaxNumber(init);
	}

	// ��������Χֵ�����ú���
	public void setMaxNumber(int num) {
		if (num < 0)
			maxNumber = 0;
		else
			maxNumber = num;

		// ���������
		generateRandom();
	}

	// ����һ���������ֵλ��1�����Χֵ֮��
	public void generateRandom() {
		rand = (int) (Math.random() * maxNumber) + 1;
	}

	// ������Ķ�ȡ����
	public int getRandom() {
		return rand;
	}
}
