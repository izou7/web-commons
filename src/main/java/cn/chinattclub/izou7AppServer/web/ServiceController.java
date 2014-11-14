package cn.chinattclub.izou7AppServer.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;

/**
 * 
 * @author ZY
 *
 */
@Controller
@RequestMapping("service")
public class ServiceController {

    @RequestMapping("/hello")
    @ResponseBody
    public RestResponse hello1(String param) {
    	RestResponse response = new RestResponse();
    	response.setMessage("FUCK YOU !");
    	response.setStatusCode(ResponseStatusCode.OK);
    	response.getBody().put("param",param);
        return response;
    }
}
