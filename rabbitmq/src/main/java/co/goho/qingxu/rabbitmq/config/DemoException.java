package co.goho.qingxu.rabbitmq.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoException extends RuntimeException {
    private String msg;
    private String code;
}
