package com.yc.biz;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.bean.Vote;

public class VoteBizTest {
	IVoteBiz biz;
	static ApplicationContext ctx;
	
	@BeforeClass
	public static void testBeforeClass() {
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Before
	public void testBefore() {
		biz=ctx.getBean(VoteBizImpl.class);
	}
	@Test
	public void testFind() {
		System.out.println("assadd");
	}
	
	@Test
	public void testAdd() {
		Vote vote=new Vote();
		vote.setVname("测试主题1");
		vote.setStartDate("2020-08-10");
		vote.setEndDate("2020-10-10");
		vote.setVtype(1);
		String []options=new String[] {"选项1","选项2","选项3"};
		biz.add(vote, options);
	}
}
