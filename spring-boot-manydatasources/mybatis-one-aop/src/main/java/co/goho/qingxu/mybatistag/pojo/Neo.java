package co.goho.qingxu.mybatistag.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Neo {
    @Value("${qingxu.title}")
    private String title;
    @Value("${qingxu.description}")
    private String description;
}
