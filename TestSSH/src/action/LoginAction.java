package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

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

    public String index()throws Exception{
        return INPUT;
    }

    public String execute() throws Exception{
        if(userName.equals("admin") && passWord.equals("admin")){
            ActionContext.getContext().getSession().put("user",userName);
            return SUCCESS;
        }else {
            return ERROR;
        }
    }
}
