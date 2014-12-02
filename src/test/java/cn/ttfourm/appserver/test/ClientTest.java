package cn.ttfourm.appserver.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.annotation.Reference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import cn.chinattclub.izou7AppServer.dto.ConstantsDto;

import cn.chinattclub.izou7AppServer.entity.Activity;
import cn.chinattclub.izou7AppServer.entity.City;
import cn.chinattclub.izou7AppServer.entity.User;
import cn.chinattclub.izou7AppServer.entity.UserInfo;
import cn.chinattclub.izou7AppServer.service.UserService;
import cn.chinattclub.izou7AppServer.util.HmacSHA256Utils;



/**
 * 
 * 测试类
 *
 * @author zhangying.
 *         Created 2014-11-12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {
				"classpath:spring-config-shiro.xml",
				"classpath:applicationContext-mysql.xml",
				"classpath:applicationContext-common.xml"
		}
)
@TransactionConfiguration(defaultRollback = false)
public class ClientTest {
	
    private RestTemplate restTemplate = new RestTemplate();
    
    @Reference
    private UserService userServiceImpl;

    private void testUser(){
    	
    }
    @Test
    public void testServiceHelloSuccess() {
        String username = "zhang";
        String param11 = "param11";
        String param12 = "param12";
        String param2 = "param2";
        String key = "68e8146ab906c133811bacc91c47787c75fe0d9e90b28f1617d131bdcc21029e";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add(ConstantsDto.PARAM_USERNAME, username);
//        params.add("param1", param11);
//        params.add("param1", param12);
//        params.add("param2", param2);
        params.add("param","FUCK　YOU!!");	
        params.add(ConstantsDto.PARAM_DIGEST, HmacSHA256Utils.digest(key, params));

        String url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/service/hello")
                .queryParams(params).build().toUriString();

        ResponseEntity responseEntity = restTemplate.getForEntity(url, String.class);
        System.out.println(responseEntity);
//        Assert.assertEquals("hello" + param11 + param12 + param2, responseEntity.getBody());
    }

    @Test
    public void testServiceHelloFail() {
        String username = "admin";
        String param11 = "param11";
        String param12 = "param12";
        String param2 = "param2";
        String key = "68e8146ab906c133811bacc91c47787c75fe0d9e90b28f1617d131bdcc21029e";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add(ConstantsDto.PARAM_USERNAME, username);
        params.add("param1", param11);
        params.add("param1", param12);
        params.add("param2", param2);
        params.add(ConstantsDto.PARAM_DIGEST, HmacSHA256Utils.digest(key, params));
        params.set("param2", param2 + "1");

        String url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/izou7AppServer/hello")
                .queryParams(params).build().toUriString();

        try {
            ResponseEntity responseEntity = restTemplate.getForEntity(url, String.class);
        } catch (HttpClientErrorException e) {
            Assert.assertEquals(HttpStatus.UNAUTHORIZED, e.getStatusCode());
            Assert.assertEquals("login error", e.getResponseBodyAsString());
        }
    }

}
