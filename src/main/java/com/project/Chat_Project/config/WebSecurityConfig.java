package com.project.Chat_Project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.Chat_Project.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //모든 final필드, @NonNull로 마크되어있는 모든 필드들에 대한 생성자를 자동으로 생성
@EnableWebSecurity //Spring Security를 활성화한다는 의미의 어노테이션
@Configuration //설정파일을 의미하는 어노테이션
//WebSecurityConfigurerAdapter는 Spring Security의 설정파일로서의 역할을 하기 위해 상속해야 하는 클래스
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	//유저 정보를 가져올 클래스
	private final MemberService memberService;

	//인증을 무시할 경로들을 설정해놓을 수 있음
	//css, js, img 폴더에 접근할 때는 인증을 무시함
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**","/js/**","/img/**");
	}
	
	//Http 관련 인증 설정
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			//접근에 대한 인증설정
			.authorizeRequests()
				.antMatchers("/login","/join","/user","/searchIdForm","/searchId","/resultId").permitAll() //누구나 접근 가능한 부분
				.antMatchers("/main").hasAnyRole("USER") //USER권한을 가진 사람만 접근 가능
				.anyRequest().authenticated() //나머지 요청의 경우는 권한의 종류에 상관 없이 권한이 있어야 접근 가능
			//로그인에 관한 설정
			.and()
				.formLogin()
					.loginPage("/login") //커스텀 로그인 페이지의 경로를 지정
					.defaultSuccessUrl("/main") //로그인 성공 후 리다이렉트 주소
			//로그아웃에 관한 설정
			.and()
				.logout()
					.logoutSuccessUrl("/login") //로그아웃 성공시 리다이렉트 주소
					.invalidateHttpSession(true) //로그아웃시 인증정보를 지우고 세션을 무효화
		;
	}
	
	//로그인할때 필요한 정보를 가져오는 곳
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//유저 정보를 가져오는 서비스 지정
		//해당 서비스(UserService)에서는 UserDetailService를 implements해서 loadUserByUsername()을 구현해야함
		auth.userDetailsService(memberService)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
}