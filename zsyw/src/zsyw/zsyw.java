package zsyw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class zsyw extends JFrame {
	private static int ResultChuHuo = 0;
	private static int ResultTuiHuo = 0;
	private static int ResultPercent = 0;

	private static ArrayList<Chuhuo> listChuhuo = null;
	private static ArrayList<Tuihuo> listTuihuo = null;

	private static ArrayList<Chuhuo> listChuhuoFilter1 = null;
	private static ArrayList<Tuihuo> listTuihuoFilter1 = null;

	private static ArrayList<Chuhuo> listChuhuoFilter2 = null;
	private static ArrayList<Tuihuo> listTuihuoFilter2 = null;

	private static ArrayList<Chuhuo> listChuhuoFilter3 = null;
	private static ArrayList<Tuihuo> listTuihuoFilter3 = null;

	private static ArrayList<Chuhuo> listChuhuoFilter4 = null;
	private static ArrayList<Tuihuo> listTuihuoFilter4 = null;

	private JPanel jp1;
	private JPanel jp2;
	private JPanel jp3;
	private JPanel jp4;
	private JPanel jp5;
	private JPanel jp6;
	private JPanel jp7;
	
	private JTextArea jta1;
	private JTextArea jta2;
	private JComboBox jcb;
	private JTextField jtf1;
	private JTextField jtf2;
	private JTextField jtf3;
	private JButton jb1;
	private JComboBox jcbb;  //下拉框  

	private JLabel jlb1, jlb2, jlb3, jlb4;
	
	private String StringsYiChang[] = {
			"所有",
			// fog
			"异常",
			// return 100;
			"缺划",
			// return 101;
			"白屏",
				// return 102;
			"花屏",
				// return 103;
			"闪屏",
				// return 104;
			"黑屏",
				// return 105;
			"无显",
				// return 106;
			"分屏",
				// return 107;
			"反屏",
				// return 108;
			"IC破损",
				// return 109;
			"LCD发黄",
				// return 110;
			"LCD点",
				// return 111;
			"来料破屏",
				// return 112;
			"液晶不良",
				// return 113;
			"亮点/彩点",
				// return 114;
			"显示不稳",
				// return 115;
			"客机画异",
				// return 116;
			"Mura",
				// return 117;
			"显示粗糙",
				// return 118;
			"残影",
				// return 119;
			"FPC坏/不良",
				// return 120;
			"动FPC画异",
				// return 121;
			"FOG卡扣坏",
				// return 122;
			"破屏",
				// return 123;
			"压白",
				// return 124;
			"其它FOG不良",
				// return 125;
			

			// bl
			"BL不亮",
				// return 200;
			"灯眼",
				// return 201;
			"死灯",
				// return 202;
			"LED灯闪",
				// return 203;
			"B/L色差",
				// return 204;
			"B/L脏点",
				// return 205;
			"BL黑/白印",
				// return 206;
			"BL划伤",
				// return 207;
			"BL黑白点",
				// return 208;
			"漏光",
				// return 209;
			"BL线断",
				// return 210;
			"膜拱",
				// return 211;
			"干涉纹",
				// return 212;
			"按压白点",
				// return 213;
			"BL混料",
				// return 214;
			"BL发黄",
				// return 215;
			"BL显示不稳",
				// return 216;
			"其它BL不良",
				// return 217;
			

			// 外观不良
			"片伤",
				// return 300;
			"气泡",
				// return 301;
			"片脏",
				// return 302;
			"片小",
				// return 303;
			"毛丝",
				// return 304;
			"片黑白印",
				// return 305;
			"片脏污",
				// return 306;
			"片贴歪",
				// return 307;
			"来料漏液",
				// return 308;
			"来料FPC坏",
				// return 309;
			"凹凸点",
				// return 310;
			"保护膜脏",
				// return 311;
			"折/压痕",
				// return 312;
			"外观混料",
				// return 313;
			"铁框脏",
				// return 314;
			"铁框变形",
				// return 315;
			"铁框生锈",
				// return 316;
			"未贴高温胶",
				// return 317;
			"水波纹",
				// return 318;
			"外观卡扣坏",
				// return 319;
			"漏胶",
				// return 320;
			"异物",
				// return 321;
			"胶不良",
				// return 322;
			"喷码不良",
				// return 323;
			"其它外观不良"
			//return 324;
	};

	// int chuhuoCount = 0;
	// int tuihuoCount = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("test!");
		String FilePath = "D:/yewu.xls";
		File f = new File(FilePath);// 源文件

		zsyw yw = new zsyw();
		yw.showWindow();

	}

	public void showWindow() {
		this.setTitle("我是薄荷啊呀呀 Beta 1.1");// 窗体名称为“聊天”
		this.setSize(600, 300);// 窗体大小为600*500
		this.setLocation(200, 200);// 窗体位置距屏幕左上角为200*200
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// 关闭窗口命令
		this.setResizable(true);// 窗体大小为不可变，false为不可变，true为可变

		jlb1 = new JLabel("客户");
		jlb2 = new JLabel("型号");
		jlb3 = new JLabel("异常");

		jp1 = new JPanel();// 创建容器
		jp2 = new JPanel();// 创建容器
		jp3 = new JPanel();// 创建容器
		jp4 = new JPanel();// 创建容器
		jp5 = new JPanel();// 创建容器
		jp6 = new JPanel();// 创建容器
		jp7 = new JPanel();// 创建容器
		
		// jcb=new JComboBox(new String[]{"姓名1","姓名2","姓名3","姓名4"});//设置多选框
		jtf1 = new JTextField(50);// 创建信息编辑框，显示文字为20个。
		jtf2 = new JTextField(50);// 创建信息编辑框，显示文字为20个。
		//jtf3 = new JTextField(50);// 创建信息编辑框，显示文字为20个。
		jcbb = new JComboBox(StringsYiChang);
		jb1 = new JButton("Test");// 创建按钮

		//this.setLayout(new GridLayout(6, 1));
		this.setLayout(new FlowLayout());
		// jp1.add(jcb);
		jp1.add(jlb1);
		jp1.add(jtf1);

		jp2.add(jlb2);
		jp2.add(jtf2);

		jp3.add(jlb3);
		jp3.add(jcbb);
		//jp3.add(jtf3);

		jta1 = new JTextArea();// 创建文本区
		jta1.setSize(getMaximumSize());
		jta1.setText("出货: " + "\n退货: " + "\n退货率: ");
		jta2 = new JTextArea();// 创建文本区
		jta1.setSize(getMaximumSize());
		jta2.setBackground(Color.red);
		jp4.add(jb1);

		jp5.add(jta1);
		jp6.add(jta2);
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("addActionListener!");

				ResultChuHuo = 0;
				ResultTuiHuo = 0;
			//
				 listChuhuoFilter1=new ArrayList<Chuhuo>();
				 listTuihuoFilter1 =new ArrayList<Tuihuo>();

				 listChuhuoFilter2=new ArrayList<Chuhuo>();
				 listTuihuoFilter2 =new ArrayList<Tuihuo>();

				 listChuhuoFilter3=new ArrayList<Chuhuo>();
				 listTuihuoFilter3 =new ArrayList<Tuihuo>();

				 listChuhuoFilter4=new ArrayList<Chuhuo>();
				 listTuihuoFilter4 =new ArrayList<Tuihuo>();
				
				 if (listChuhuo == null) {
						try {
							ReadDataToList();
							
							FilterData();

							ShowResult(); 
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							listChuhuo = null;
							jta2.setText("读取文件失败, 请确认文件存在\nD:\\统计.xls");
							e1.printStackTrace();
							
							
						} 
					}else {
						FilterData();

						ShowResult(); 
					}
				 
//				 if (listChuhuo == null) {
//					 jta1.setText("读取文件失败, 请确认文件存在\nD:\\\\统计.xls");
//					}else {
//						
//					}
//					
				

				
				// jta1.setText("出货: " + "\n退货: " + "\n退货率: " ) ;

			}

		});
		// this.add(jp1, BorderLayout.NORTH);
		// this.add(jp2, BorderLayout.SOUTH);

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		this.add(jp6);
		this.setVisible(true);
	}

	protected void ShowResult() {
		System.out.println("ShowResult!");

		// TODO Auto-generated method stub
		jta1.setText("客户: " + jtf1.getText() +
				"\n型号: " + jtf2.getText() +
				"\n出货: " + ResultChuHuo + 
				"\n退货: " + ResultTuiHuo + 
				"\n异常类型: " + jcbb.getSelectedItem() +
				 "\n退货率: "+ (float) ResultTuiHuo / (float) ResultChuHuo);
		 
		jta1.setBackground(Color.cyan);

	}

	protected void FilterData() {
		System.out.println("FilterData!");
		// TODO Auto-generated method stub

		String costemName = jtf1.getText();
		boolean hasNotCostem = jtf1.getText().isEmpty() || jtf1.getText().toString().equals("");

		String typeName = jtf2.getText();
		boolean hasNotType = jtf2.getText().isEmpty() || jtf2.getText().toString().equals("");

		
		
		
		
		
		
		
	

		
		
		
		
		
		String xianxiang = (String) jcbb.getSelectedItem();//jtf3.getText();
		boolean hasNotXianxiang = xianxiang.equals("所有"); //jtf3.getText().isEmpty() || jtf3.getText().toString().equals("");
		
		
		
		// 3个空,计算所有
		if (hasNotCostem == true && hasNotType == true && hasNotXianxiang == true) {
			for (Chuhuo item1 : listChuhuo) {
				ResultChuHuo += item1.getCount();

			}

			for (Tuihuo item2 : listTuihuo) {
				ResultTuiHuo += item2.getTotalCount();
			}

			return;
		}

		// 开始过滤
		// 一次过滤客户
		if (hasNotCostem == false) {
			for (Chuhuo item : listChuhuo) {
				if (costemName.equals(item.getCostem())) {
					listChuhuoFilter1.add(item);
				}
			}

			for (Tuihuo item : listTuihuo) {
				if (costemName.equals(item.getCostem())) {
					listTuihuoFilter1.add(item);
				}
			}

		} else {
			listChuhuoFilter1 = listChuhuo;
			listTuihuoFilter1 = listTuihuo;
		}

		System.out.println("一次过滤!" + " listChuhuoFilter1.size()=" + listChuhuoFilter1.size());
		System.out.println("一次过滤!" + " listTuihuoFilter1.size()=" + listTuihuoFilter1.size());

		// 二次过滤型号
		if (hasNotType == false) {
			for (Chuhuo item : listChuhuoFilter1) {
				if (typeName.equals(item.getType())) {
					listChuhuoFilter2.add(item);
				}
			}

			for (Tuihuo item : listTuihuoFilter1) {
				if (costemName.equals(item.getCostem())) {
					listTuihuoFilter2.add(item);
				}
			}
		} else {
			listChuhuoFilter2 = listChuhuoFilter1;
			listTuihuoFilter2 = listTuihuoFilter1;
		}

		for (Chuhuo item : listChuhuoFilter2) {
			ResultChuHuo += item.getCount();
		}
		
		for (Tuihuo item : listTuihuoFilter2) {
			ResultTuiHuo += item.getTotalCount();
		}
		
		System.out.println("二次过滤!" + " listChuhuoFilter2.size()=" + listChuhuoFilter2.size());
		System.out.println("二次过滤!" + " listTuihuoFilter2.size()=" + listTuihuoFilter2.size());

		// 三次过滤异常
		if (hasNotXianxiang == false) {
			int xianxiangId = GetXianxiangID(xianxiang);
			System.out.println("三次过滤!" + " 异常=" + xianxiang + " xianxiangId=" + xianxiangId);
			
			ResultTuiHuo = 0;
			for (Tuihuo item : listTuihuoFilter2) {

				switch (xianxiangId) {

				// 未找到异常类型 ,报错
				case 0:
					jta2.append ("\n三次过滤异常 未找到异常类型 ,报错");
					
					System.out.println(" 三次过滤异常 未找到异常类型 ,报错");
					ResultTuiHuo = 0;
					return;

				case 100:
					ResultTuiHuo += item.getYichangCount();
					break;
				case 101:
					ResultTuiHuo += item.getQuehuaCount();
					break;
				case 102:
					ResultTuiHuo += item.getBaipingCount();
					break;
				case 103:
					ResultTuiHuo += item.getHuapingCount();
					break;
				case 104:
					ResultTuiHuo += item.getShanpingCount();
					break;
				case 105:
					ResultTuiHuo += item.getHeipingCount();
					break;
				case 106:
					ResultTuiHuo += item.getWuxiangCount();
					break;
				case 107:
					ResultTuiHuo += item.getFengpingCount();
					break;
				case 108:
					ResultTuiHuo += item.getFangpingCount();
					break;
				case 109:
					ResultTuiHuo += item.getIdBrokeCount();
					break;
				case 110:
					ResultTuiHuo += item.getLcdfahuangCount();
					break;
				case 111:
					ResultTuiHuo += item.getLcddianCount();
					break;
				case 112:
					ResultTuiHuo += item.getLailiaopopingCount();
					break;
				case 113:
					ResultTuiHuo += item.getYejingbuliangCount();
					break;
				case 114:
					ResultTuiHuo += item.getLiangdianOrCaidianCount();
					break;
				case 115:
					ResultTuiHuo += item.getXianshibuwengCount();
					break;
				case 116:
					ResultTuiHuo += item.getKejihuayiCount();
					break;
				case 117:
					ResultTuiHuo += item.getMuraCount();
					break;
				case 118:
					ResultTuiHuo += item.getXianshichuchaoCount();
					break;
				case 119:
					ResultTuiHuo += item.getCangyingCount();
					break;
				case 120:
					ResultTuiHuo += item.getFpchuaOrBuliangCount();
					break;
				case 1201:
					ResultTuiHuo += item.getDongFpcHuayiCount();
					break;
				case 122:
					ResultTuiHuo += item.getKakouhuaiCount();
					break;
				case 123:
					ResultTuiHuo += item.getPopingCount();
					break;
				case 124:
					ResultTuiHuo += item.getYabaiCount();
					break;
				case 125:
					ResultTuiHuo += item.getQitaFogCount();
					break;

				// bl
				case 200:
					ResultTuiHuo += item.getBlbuliangCount();
					break;
				case 201:
					ResultTuiHuo += item.getDengyangCount();
					break;
				case 202:
					ResultTuiHuo += item.getSidengCount();
					break;
				case 203:
					ResultTuiHuo += item.getLedDengshanCount();
					break;
				case 204:
					ResultTuiHuo += item.getbOrLshechaCount();
					break;
				case 205:
					ResultTuiHuo += item.getbOrLzhangdianCount();
					break;
				case 206:
					ResultTuiHuo += item.getBlHeiOrBaiyingCount();
					break;
				case 207:
					ResultTuiHuo += item.getBlHuashanCount();
					break;
				case 208:
					ResultTuiHuo += item.getBlHeibaidianCount();
					break;
				case 209:
					ResultTuiHuo += item.getLouguanCount();
					break;
				case 210:
					ResultTuiHuo += item.getBlDuanxianCount();
					break;
				case 211:
					ResultTuiHuo += item.getMogongCount();
					break;
				case 212:
					ResultTuiHuo += item.getGanshewenCount();
					break;
				case 213:
					ResultTuiHuo += item.getAnyabaidianCount();
					break;
				case 214:
					ResultTuiHuo += item.getHunliaoCount();
					break;
				case 215:
					ResultTuiHuo += item.getBlFahuangCount();
					break;
				case 216:
					ResultTuiHuo += item.getXianshibuwengCount();
					break;
				case 217:
					ResultTuiHuo += item.getBacklightQitaCount();
					break;

				case 300:
					ResultTuiHuo += item.getPianshanCount();
					break;
				case 301:
					ResultTuiHuo += item.getQipaoCount();
					break;
				case 302:
					ResultTuiHuo += item.getPianzhangCount();
					break;
				case 303:
					ResultTuiHuo += item.getPianxiaoCount();
					break;
				case 304:
					ResultTuiHuo += item.getMaoshiCount();
					break;
				case 305:
					ResultTuiHuo += item.getPaiheibaiyingCount();
					break;
				case 306:
					ResultTuiHuo += item.getPianzhangwuCount();
					break;
				case 307:
					ResultTuiHuo += item.getPianwaitieCount();
					break;
				case 308:
					ResultTuiHuo += item.getLailiaolouyeCount();
					break;
				case 309:
					ResultTuiHuo += item.getLailiaoFpcHuaiCount();
					break;
				case 310:
					ResultTuiHuo += item.getAotudianCount();
					break;
				case 311:
					ResultTuiHuo += item.getBaohumozhangCount();
					break;
				case 312:
					ResultTuiHuo += item.getZheyahengCount();
					break;
				case 313:
					ResultTuiHuo += item.getHunliao2Count();
					break;
				case 314:
					ResultTuiHuo += item.getTiekuanzhangCount();
					break;
				case 315:
					ResultTuiHuo += item.getTiekuanbianxingCount();
					break;
				case 316:
					ResultTuiHuo += item.getTiekuanshenxiuCount();
					break;
				case 317:
					ResultTuiHuo += item.getWeitiegaowenjiaoCount();
					break;
				case 318:
					ResultTuiHuo += item.getShuibowenCount();
					break;
				case 319:
					ResultTuiHuo += item.getKakouhuai2Count();
					break;
				case 320:
					ResultTuiHuo += item.getLoujiaoCount();
					break;
				case 321:
					ResultTuiHuo += item.getYiwuCount();
					break;
				case 322:
					ResultTuiHuo += item.getJiaobuliangCount();
					break;
				case 323:
					ResultTuiHuo += item.getPenmabuliangCount();
					break;
				case 324:
					ResultTuiHuo += item.getQitaCount();
					break;
				default:
					ResultTuiHuo = 0;
					return;

				}

			}
		}

		

		// listChuhuo = null;
		// listTuihuo = null;

	}

	private int GetXianxiangID(String xianxiang) {
		// TODO Auto-generated method stub

		// fog
		if (xianxiang.equals("异常")) {
			return 100;
		} else if (xianxiang.equals("缺划")) {
			return 101;
		} else if (xianxiang.equals("白屏")) {
			return 102;
		} else if (xianxiang.equals("花屏")) {
			return 103;
		} else if (xianxiang.equals("闪屏")) {
			return 104;
		} else if (xianxiang.equals("黑屏")) {
			return 105;
		} else if (xianxiang.equals("无显")) {
			return 106;
		} else if (xianxiang.equals("分屏")) {
			return 107;
		} else if (xianxiang.equals("反屏")) {
			return 108;
		} else if (xianxiang.equals("IC破损")) {
			return 109;
		} else if (xianxiang.equals("LCD发黄")) {
			return 110;
		} else if (xianxiang.equals("LCD点")) {
			return 111;
		} else if (xianxiang.equals("来料破屏")) {
			return 112;
		} else if (xianxiang.equals("液晶不良")) {
			return 113;
		} else if (xianxiang.equals("亮点/彩点") || xianxiang.equals("亮点") || xianxiang.equals("彩点")) {
			return 114;
		} else if (xianxiang.equals("显示不稳")) {
			return 115;
		} else if (xianxiang.equals("客机画异")) {
			return 116;
		} else if (xianxiang.equals("Mura")) {
			return 117;
		} else if (xianxiang.equals("显示粗糙")) {
			return 118;
		} else if (xianxiang.equals("残影")) {
			return 119;
		} else if (xianxiang.equals("FPC坏/不良") || xianxiang.equals("FPC坏") || xianxiang.equals("FPC不良")) {
			return 120;
		} else if (xianxiang.equals("动FPC画异")) {
			return 121;
		} else if (xianxiang.equals("FOG卡扣坏")) {
			return 122;
		} else if (xianxiang.equals("破屏")) {
			return 123;
		} else if (xianxiang.equals("压白")) {
			return 124;
		} else if (xianxiang.equals("其它FOG不良")) {
			return 125;
		}

		// bl
		if (xianxiang.equals("BL不亮")) {
			return 200;
		} else if (xianxiang.equals("灯眼")) {
			return 201;
		} else if (xianxiang.equals("死灯")) {
			return 202;
		} else if (xianxiang.equals("LED灯闪")) {
			return 203;
		} else if (xianxiang.equals("B/L色差") || xianxiang.equals("B色差") || xianxiang.equals("L色差")) {
			return 204;
		} else if (xianxiang.equals("B/L脏点") || xianxiang.equals("B脏点") || xianxiang.equals("L脏点")) {
			return 205;
		} else if (xianxiang.equals("BL黑/白印") || xianxiang.equals("BL黑印") || xianxiang.equals("BL白印")) {
			return 206;
		} else if (xianxiang.equals("BL划伤")) {
			return 207;
		} else if (xianxiang.equals("BL黑白点")) {
			return 208;
		} else if (xianxiang.equals("漏光")) {
			return 209;
		} else if (xianxiang.equals("BL线断")) {
			return 210;
		} else if (xianxiang.equals("膜拱")) {
			return 211;
		} else if (xianxiang.equals("干涉纹")) {
			return 212;
		} else if (xianxiang.equals("按压白点")) {
			return 213;
		} else if (xianxiang.equals("BL混料")) {
			return 214;
		} else if (xianxiang.equals("BL发黄")) {
			return 215;
		} else if (xianxiang.equals("BL显示不稳")) {
			return 216;
		} else if (xianxiang.equals("其它BL不良")) {
			return 217;
		}

		// 外观不良
		if (xianxiang.equals("片伤")) {
			return 300;
		} else if (xianxiang.equals("气泡")) {
			return 301;
		} else if (xianxiang.equals("片脏")) {
			return 302;
		} else if (xianxiang.equals("片小")) {
			return 303;
		} else if (xianxiang.equals("毛丝")) {
			return 304;
		} else if (xianxiang.equals("片黑白印")) {
			return 305;
		} else if (xianxiang.equals("片脏污")) {
			return 306;
		} else if (xianxiang.equals("片贴歪")) {
			return 307;
		} else if (xianxiang.equals("来料漏液")) {
			return 308;
		} else if (xianxiang.equals("来料FPC坏")) {
			return 309;
		} else if (xianxiang.equals("凹凸点")) {
			return 310;
		} else if (xianxiang.equals("保护膜脏")) {
			return 311;
		} else if (xianxiang.equals("折/压痕") || xianxiang.equals("折痕") || xianxiang.equals("压痕")) {
			return 312;
		} else if (xianxiang.equals("外观混料")) {
			return 313;
		} else if (xianxiang.equals("铁框脏")) {
			return 314;
		} else if (xianxiang.equals("铁框变形")) {
			return 315;
		} else if (xianxiang.equals("铁框生锈")) {
			return 316;
		} else if (xianxiang.equals("未贴高温胶")) {
			return 317;
		} else if (xianxiang.equals("水波纹")) {
			return 318;
		} else if (xianxiang.equals("外观卡扣坏")) {
			return 319;
		} else if (xianxiang.equals("漏胶")) {
			return 320;
		} else if (xianxiang.equals("异物")) {
			return 321;
		} else if (xianxiang.equals("胶不良")) {
			return 322;
		} else if (xianxiang.equals("喷码不良")) {
			return 323;
		} else if (xianxiang.equals("其它外观不良")) {
			return 324;
		}

		else{
			jta2.setText("获取异常类型出错, 请确认输入无误 ,报错");
			System.out.println(" 获取异常类型出错, 请确认输入无误 ,报错");
		return 0;
		}

	}

	protected void ReadDataToList() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ReadDataToList!");
		 
			listChuhuo = ExcelReadChuhuo.exportListFromExcel();
			listTuihuo = ExcelReadTuihuo.exportListFromExcel();
		 

	}

}
