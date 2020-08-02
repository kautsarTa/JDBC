package jdbc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CourseController
 */
@WebServlet("/CourseController")
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String code = request.getParameter("code");
		String courseName = request.getParameter("courseName");
		
		if(code != null && courseName != null) {
			
			Course course = new Course();
			
			course.setCode(code);
			course.setCourseName(courseName);
			
			
			if(request.getParameter("id")!= null && !request.getParameter("id").isEmpty()) {
				int id = Integer.parseInt(request.getParameter("id"));
				
				if(course.updateData(id)==true) {
					RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
					rd.forward(request, response);
				}else {
					RequestDispatcher rd = request.getRequestDispatcher("editCourse.jsp");
					rd.forward(request, response);
				}
				
				
			}else {
				if(course.storeData()==true) {
					RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
					rd.forward(request, response);
				}else {
					RequestDispatcher rd = request.getRequestDispatcher("form.jsp");
					rd.forward(request, response);
				}
				
			}
			
			
			
			
		}
	}

}
