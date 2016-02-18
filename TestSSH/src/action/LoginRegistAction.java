package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;

/**
 * Created by Chris on 2016-02-18.
 */
public class LoginRegistAction extends ActionSupport {
    private String userName = "";
    private String passWord = "";
    private String tip = "";

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

    public String getTip(){
        return this.tip;
    }

    public void setTip(String tip){
        this.tip = tip;
    }

    public String regist()throws Exception{
        ActionContext context = ActionContext.getContext();
        context.getSession().put("user",getUserName());
        setTip("恭喜你，"+getUserName()+"，您已成功注册！");
        return SUCCESS;
    }

    public String execute() throws Exception{
//        ActionContext context = ActionContext.getContext();
//        Integer counter = (Integer)context.getApplication().get("counter");
//        if(counter == null){
//            counter = 1;
//        }else{
//            counter++;
//        }
//        context.getSession().put("user",getUserName());
//        context.getApplication().put("counter",counter);
        if(getUserName().equals("admin") && getPassWord().equals("admin")){
            Cookie c = new Cookie("user",getUserName());
            c.setMaxAge(60 * 60); //一小时
            ServletActionContext.getResponse().addCookie(c);
            setTip("服务器提示：您已成功登录");
            return SUCCESS;
        }else {
            setTip("服务器提示：登录失败");
            return ERROR;
        }
    }
}
