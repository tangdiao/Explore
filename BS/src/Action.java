import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//判断猜数是否正确的Servlet类
public class Action extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {

	// 构造函数
	public Action() {
		super();
	}

	// 处理GET请求
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 设置发送到客户端的内容类型
		response.setContentType("text/html;charset=GB2312");

		// 获取客户端写入器
		PrintWriter out = response.getWriter();

		// 获取客户端请求信息中的guessNumber属性值
		String s1 = request.getParameter("guessNumber");

		// 得到猜数
		int num1 = Integer.parseInt(s1);

		// 获取当前会话
		HttpSession session = request.getSession(true);

		// 获取会话信息中的cr属性
		exec.CRandom cr = (exec.CRandom) session.getAttribute("cr");

		// 得到系统生成的初始随机数
		int num2 = cr.getRandom();

		// 获取会话信息中的ci属性
		exec.CInfo ci = (exec.CInfo) session.getAttribute("ci");

		// 如果猜数与系统生成的初始随机数相等
		if (num1 == num2) {
			// 跳转到成功页面
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("success.jsp");
			dispatcher.forward(request, response);

			// 结束当前会话
			session.invalidate();
		}
		// 如果猜数小于系统生成的初始随机数
		else if (num1 < num2) {
			// 设置显示的提示信息
			ci.setInfo("低了");

			// 跳转到猜数页面
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		// 如果猜数大于系统生成的初始随机数
		else {
			// 设置显示的提示信息
			ci.setInfo("高了");

			// 跳转到猜数页面
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	// 处理POST请求，执行和处理GET请求一样的方法
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}