package cn.teng.jdi;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.teng.jdi.view.JDIFrame;


/**
 *
 */
public final class App {
 
	private App(){}
	
	private static ClassPathXmlApplicationContext ctx;

	@SuppressWarnings("unchecked")
	public static <T extends Object> T getBean(String beanName) {
		return  (T) ctx.getBean(beanName);
	}

	public static ApplicationContext getCtx() {
		return ctx;
	}

	public  static void destroy() {
		ctx.registerShutdownHook();
	}
	
	public static void startup(){
		ctx = new ClassPathXmlApplicationContext("classpath:jdi-mysql-spring-context.xml");
	}
	
	public static void main(String[] args) {
//		App.startup();
//		try {
//			MetaDataSource source = App.getBean("MetaDataSource");
//			source.tableColumn();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		Runnable t  = new Runnable() {
			public void run() {
				JDIFrame f = new JDIFrame();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setTitle("JDC Code Builder");
				f.setVisible(true);
				
			}
		};
		
		EventQueue.invokeLater(t);
		
	}
	
	
}
