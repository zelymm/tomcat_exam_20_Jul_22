package com.ll.exam;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rq rq = new Rq(req, resp);

        int dan = rq.getIntParam("dan", 2);
        int limit = rq.getIntParam("limit", 9);

        //변수 int dan과 limit을 gugudan2.jsp에서 사용가능하도록 <-available on request. 그니까 Request 객체한테 담기*
        req.setAttribute("dan", dan);
        req.setAttribute("limit", limit);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/gugudan2.jsp"); // gugudan2.jsp한테 나머지 작업 toss
        requestDispatcher.forward(req, resp);
    }
}
