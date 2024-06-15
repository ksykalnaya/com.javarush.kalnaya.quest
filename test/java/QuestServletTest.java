import com.example.quest.controller.QuestServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class QuestServletTest {
    QuestServlet questServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher dispatcher;
    private HttpSession session;


    @BeforeEach
    void setUp() throws ServletException {
        questServlet = new QuestServlet();
        ServletConfig servletConfig = mock(ServletConfig.class);
        questServlet.init(servletConfig);
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
        session = mock(HttpSession.class);
    }

    @Test
    public void doGet_Start() throws ServletException, IOException {

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("life")).thenReturn(3);
        when(session.getAttribute("correctAnswers")).thenReturn(0);
        when(request.getParameter("questNumber")).thenReturn("1");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        questServlet.doGet(request,response);

        verify(request).getRequestDispatcher("/question.jsp");
        verify(request).setAttribute("questNumber", 1);
        verify(session).setAttribute("life", 2);
    }

    @Test
    public void doGet_Finish_Fail() throws ServletException, IOException {

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("life")).thenReturn(1);
        when(session.getAttribute("correctAnswers")).thenReturn(0);
        when(request.getParameter("questNumber")).thenReturn("2");
        when(request.getParameter("answerId")).thenReturn("21");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        questServlet.doGet(request,response);

        verify(request).getRequestDispatcher("/finish.jsp");
        verify(request).setAttribute("result", "Fail");
        verify(session).setAttribute("life", 0);
    }
}
