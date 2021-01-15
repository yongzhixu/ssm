package Configuration;

import javax.servlet.*;
import java.io.IOException;

public class GmIotSecurity implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String name = "";
        String age = "";
        name = request.getParameter("name");
        age = request.getParameter("age");
//        RequestDispatcher dispatch = request.getRequestDispatcher("erroroutput.jsp");
        if (name == null || name == "" || name == " " || age == null) {
//            JOptionPane.showMessageDialog(null, "用户名和年龄输入错误！");
//            dispatch.forward(request, response);
            return;
        } else {
            try {
                Integer.parseInt(age);
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null,"年龄必须为数字！");
//                dispatch.forward(request, response);
                return;//如果是错误页面就到erroroutput.jsp中
            }
        }
        //这里表示是正确的，也就是说，他回去找下一个链，但是它下面已经没有了，所以就会去跳转页面了，此跳转的页面就是action="output.jsp"了
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
