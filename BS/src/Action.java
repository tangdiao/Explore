import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//�жϲ����Ƿ���ȷ��Servlet��
public class Action extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {

	// ���캯��
	public Action() {
		super();
	}

	// ����GET����
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// ���÷��͵��ͻ��˵���������
		response.setContentType("text/html;charset=GB2312");

		// ��ȡ�ͻ���д����
		PrintWriter out = response.getWriter();

		// ��ȡ�ͻ���������Ϣ�е�guessNumber����ֵ
		String s1 = request.getParameter("guessNumber");

		// �õ�����
		int num1 = Integer.parseInt(s1);

		// ��ȡ��ǰ�Ự
		HttpSession session = request.getSession(true);

		// ��ȡ�Ự��Ϣ�е�cr����
		exec.CRandom cr = (exec.CRandom) session.getAttribute("cr");

		// �õ�ϵͳ���ɵĳ�ʼ�����
		int num2 = cr.getRandom();

		// ��ȡ�Ự��Ϣ�е�ci����
		exec.CInfo ci = (exec.CInfo) session.getAttribute("ci");

		// ���������ϵͳ���ɵĳ�ʼ��������
		if (num1 == num2) {
			// ��ת���ɹ�ҳ��
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("success.jsp");
			dispatcher.forward(request, response);

			// ������ǰ�Ự
			session.invalidate();
		}
		// �������С��ϵͳ���ɵĳ�ʼ�����
		else if (num1 < num2) {
			// ������ʾ����ʾ��Ϣ
			ci.setInfo("����");

			// ��ת������ҳ��
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		// �����������ϵͳ���ɵĳ�ʼ�����
		else {
			// ������ʾ����ʾ��Ϣ
			ci.setInfo("����");

			// ��ת������ҳ��
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	// ����POST����ִ�кʹ���GET����һ���ķ���
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}