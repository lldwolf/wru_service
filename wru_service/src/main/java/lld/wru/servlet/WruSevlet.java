package lld.wru.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.google.gson.Gson;

import lld.wru.dao.DaoConfig;
import lld.wru.dao.interfaces.FriendDao;
import lld.wru.model.LocationQueryResult;

@ContextConfiguration(classes=DaoConfig.class)
public class WruSevlet extends HttpServlet {

    private static final long serialVersionUID = 6632866339300534028L;

    @Autowired
    private FriendDao friendDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String myPhoneNum = req.getParameter("myPhoneNum");
        String friendPhoneNum = req.getParameter("friendPhoneNum");
        LocationQueryResult result = new LocationQueryResult();
        
        if (!friendDao.hasFriend(myPhoneNum, friendPhoneNum)) {
            result.setErrorMessage(String.format("%s isn't %s's friend!", myPhoneNum, friendPhoneNum));
        } else {
            
        }
        
        ServletOutputStream stream = resp.getOutputStream();
        String jsonString = new Gson().toJson(result);
        stream.print(jsonString);
        
        
    }
}
