package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import model.BMI;

/**
 * Servlet implementation class Calc
 */
@WebServlet("/Calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/main.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String height=request.getParameter("height");
		String weight=request.getParameter("weight");

		URL url=new URL("http://localhost:8080/HttpLesson/CalcBMI?height="+height+"&weight="+weight);
		HttpURLConnection con=(HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		InputStream is=con.getInputStream();
		InputStreamReader isr=new InputStreamReader(is,"utf-8");
		JsonReader reader=new JsonReader(isr);
		Gson gson=new Gson();
		BMI bmi=gson.fromJson(reader, BMI.class);

		request.setAttribute("bmi", bmi);
		doGet(request,response);
	}
}
