package cn.teng.jdi.view;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JDIMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7222421886398111049L;

	public JDIMenu() {
		super();
		
		JMenu set = new JMenu("设置");
		
		JMenuItem set_add_database = new JMenuItem("添加	数据库连接池");
		set.add(set_add_database);
		JMenuItem set_add_output_path = new JMenuItem("添加	输出位置");
		set.add(set_add_output_path);
		
		JMenu code_template = new JMenu("code模板");
		JMenu build = new JMenu("编译");
		JMenuItem build_run = new JMenuItem("运行");
		build.add(build_run);
		
		this.add(set);
		this.add(code_template);
		this.add(build);
		
		this.setBackground(new Color(81, 81, 79));
	}

}
