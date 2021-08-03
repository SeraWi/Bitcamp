package member.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import member.dao.Dao;
import member.dao.MemberDao;
import member.domain.RegRequest;
import member.service.ChangePasswordService;
import member.service.MemberRegService;

public class SpringMain2 {
	
	//static MemberDao dao =new MemberDao();
	//static Assembler assembler = new Assembler();
	static ApplicationContext ctx;
	
	public static void main(String[] args) {
		
		//ctx = new GenericXmlApplicationContext("classpath:appCtx1.xml");
		//ctx = new GenericXmlApplicationContext("classpath:appCtx2.xml");
		ctx = new GenericXmlApplicationContext("classpath:appCtx4.xml");
		
		//MemberRegService 객체를 컨테이너로부터 받아온다. 
		Dao dao1 =ctx.getBean("memberDao",Dao.class); 
		Dao dao2 =ctx.getBean("memberDao",Dao.class); 
		System.out.println("==========================================");
		System.out.println("dao1 == dao2 :"+ (dao1 == dao2)); //true : 기본값==singleton 컨테이너에서 가져온 인스턴스가 같은 인스턴스다!!! 즉 싱글톤
		
		MemberRegService regService1 = ctx.getBean("regService", MemberRegService.class);
		MemberRegService regService2 = ctx.getBean("regService", MemberRegService.class);
		
		System.out.println(regService1 == regService2); //false: prototype은  요청할 때 새로운 객체 만든다
		
		
		ChangePasswordService passwordService1 = ctx.getBean("changePwService",ChangePasswordService.class);
		ChangePasswordService passwordService2 = ctx.getBean("changePwService",ChangePasswordService.class);

		System.out.println(passwordService1==passwordService2); //scope = singleton
	}
	

	
}

