import com.example.quest.controller.InitServlet;
import com.example.quest.controller.QuestServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class InitServletTest {

    @Test
    public void doGet() throws ServletException, IOException {
        InitServlet initServlet = new InitServlet();
        ServletConfig servletConfig = mock(ServletConfig.class);
        initServlet.init(servletConfig);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession(true)).thenReturn(session);
        when(request.getParameter("userName")).thenReturn("Test");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        initServlet.doGet(request,response);

        verify(request).getRequestDispatcher("/question");
        verify(session).setAttribute("userName", "Test");
        verify(session).setAttribute("life", 3);
        verify(session).setAttribute("correctAnswers", 0);
    }

}
