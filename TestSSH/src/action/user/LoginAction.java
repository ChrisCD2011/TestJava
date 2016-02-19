package action.user;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.Cookie;
import java.io.IOException;

/**
 * Created by Chris on 2016-02-17.
 */
public class LoginAction extends ActionSupport{
    private String userName = "";
    private String passWord = "";

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassWord(){
        return this.passWord;
    }

    public void setPassWord(String passWord){
        this.passWord = passWord;
    }

    public String execute() throws IOException{
//        ActionContext context = ActionContext.getContext();
//        context.put("error","Test Error");
//        throw new IOException("Test Error");

        ActionContext context = ActionContext.getContext();
        Integer counter = (Integer)context.getApplication().get("counter");
        if(counter == null){
            counter = 1;
        }else{
            counter++;
        }
        context.getSession().put("user",getUserName());
        context.getApplication().put("counter",counter);
        if(getUserName().equals("admin") && getPassWord().equals("admin")){
            Cookie c = new Cookie("user",getUserName());
            c.setMaxAge(60 * 60); //一小时
            ServletActionContext.getResponse().addCookie(c);
            context.put("tip","服务器提示：您已成功登录");
            return SUCCESS;
        }else {
            context.put("tip","服务器提示：登录失败");
            return ERROR;
        }
    }
}
