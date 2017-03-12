package simple.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class myPageAction extends ActionSupport{

    public String Page(){
        return "Page";
    }

    public String Personal(){
        return "Personal";
    }

    public String Follow(){
        return "Follow";
    }

    public String Collection(){
        return "Collection";
    }

    public String Article(){
        return "Article";
    }

    public String Comment(){
        return "Comment";
    }

    public String Setting(){
        return "Setting";
    }

    public String ArticleEdit(){
        return "ArticleEdit";
    }
}
