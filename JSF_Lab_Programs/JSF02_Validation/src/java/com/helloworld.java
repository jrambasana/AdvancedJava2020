package com;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class helloworld {

private String uname;
private String mobno;

public helloworld(){
        System.out.println("helloworld Started");
}

public String getMobno(){
        return mobno;
}

public void setMobno(String mobno){
        this.mobno=mobno;
}	

public String getUname(){
        return uname;
}

public void setUname(String uname){
        this.uname=uname;
}

}
