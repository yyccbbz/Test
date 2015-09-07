package cc.zizou.springmvc.pojo;

import java.util.List;

/**
 * 接收表单提交的集合对象
 * 
 * @author yyccb_000
 *
 */
public class UserForm {
    
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserForm [users=" + users + "]";
    }
    
    
    
}
