package com.empiretech.userservice.VO;

import com.empiretech.userservice.entity.Department;
import com.empiretech.userservice.entity.User;

public class ResponseTemplateVO {
    
    private User user;
    private Department department;

    public ResponseTemplateVO() {
    }

    public ResponseTemplateVO(User user, Department department) {
        this.user = user;
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
