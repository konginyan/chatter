package simple.action;

import Service.NoticeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.NoticeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class readNoticeAction extends ActionSupport{
    Long id;
    @Autowired
    NoticeService noticeService;

    public void setNoticeService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        NoticeResource noticeResource = noticeService.getNoticeById(id);
        noticeService.addClickCount(id);
        ActionContext actionContext = ActionContext.getContext();
        actionContext.put("noticeTitle",noticeResource.getTitle());
        actionContext.put("noticeAuthor",noticeResource.getAuthor());
        actionContext.put("noticeTime",noticeResource.getCreateTime());
        actionContext.put("noticeContent",noticeResource.getNotice());
        return SUCCESS;
    }
}
