package com.zhang.springboot.druid;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * druid 配置.
 * <p>
 * <p>
 * <p>
 * 这样的方式不需要添加注解：@ServletComponentScan
 *启动应用就可以访问：http://127.0.0.1:8080/druid2/index.html输入账号和密码：admin2/123456 就可以访问了。
 * @author Administrator
 */

@Configuration
@ConfigurationProperties("spring.druid.listener")
public class DruidConfiguration {
    private String allow;
    private String deny;
    private String loginUsername;
    private String loginPassword;
    private String resetEnable;

    /**
     * 注册一个StatViewServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean DruidStatViewServle2() {
        //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid2/*");
        //添加初始化参数：initParams
        //白名单：
        servletRegistrationBean.addInitParameter("allow", this.getAllow());
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.addInitParameter("deny", this.getDeny());

        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername", this.getLoginUsername());
        servletRegistrationBean.addInitParameter("loginPassword", this.getLoginUsername());

        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable", this.getResetEnable());
        return servletRegistrationBean;
    }


    /**
     * 注册一个：filterRegistrationBean
     *
     * @return
     */

    @Bean
    public FilterRegistrationBean druidStatFilter2() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid2/*");
        return filterRegistrationBean;

    }

    public String getAllow() {
        return allow;
    }

    public void setAllow(String allow) {
        this.allow = allow;
    }

    public String getDeny() {
        return deny;
    }

    public void setDeny(String deny) {
        this.deny = deny;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getResetEnable() {
        return resetEnable;
    }

    public void setResetEnable(String resetEnable) {
        this.resetEnable = resetEnable;
    }
}