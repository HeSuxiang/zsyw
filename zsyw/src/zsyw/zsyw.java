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
	private JComboBox jcbb;  //������  

	private JLabel jlb1, jlb2, jlb3, jlb4;
	
	private String StringsYiChang[] = {
			"����",
			// fog
			"�쳣",
			// return 100;
			"ȱ��",
			// return 101;
			"����",
				// return 102;
			"����",
				// return 103;
			"����",
				// return 104;
			"����",
				// return 105;
			"����",
				// return 106;
			"����",
				// return 107;
			"����",
				// return 108;
			"IC����",
				// return 109;
			"LCD����",
				// return 110;
			"LCD��",
				// return 111;
			"��������",
				// return 112;
			"Һ������",
				// return 113;
			"����/�ʵ�",
				// return 114;
			"��ʾ����",
				// return 115;
			"�ͻ�����",
				// return 116;
			"Mura",
				// return 117;
			"��ʾ�ֲ�",
				// return 118;
			"��Ӱ",
				// return 119;
			"FPC��/����",
				// return 120;
			"��FPC����",
				// return 121;
			"FOG���ۻ�",
				// return 122;
			"����",
				// return 123;
			"ѹ��",
				// return 124;
			"����FOG����",
				// return 125;
			

			// bl
			"BL����",
				// return 200;
			"����",
				// return 201;
			"����",
				// return 202;
			"LED����",
				// return 203;
			"B/Lɫ��",
				// return 204;
			"B/L���",
				// return 205;
			"BL��/��ӡ",
				// return 206;
			"BL����",
				// return 207;
			"BL�ڰ׵�",
				// return 208;
			"©��",
				// return 209;
			"BL�߶�",
				// return 210;
			"Ĥ��",
				// return 211;
			"������",
				// return 212;
			"��ѹ�׵�",
				// return 213;
			"BL����",
				// return 214;
			"BL����",
				// return 215;
			"BL��ʾ����",
				// return 216;
			"����BL����",
				// return 217;
			

			// ��۲���
			"Ƭ��",
				// return 300;
			"����",
				// return 301;
			"Ƭ��",
				// return 302;
			"ƬС",
				// return 303;
			"ë˿",
				// return 304;
			"Ƭ�ڰ�ӡ",
				// return 305;
			"Ƭ����",
				// return 306;
			"Ƭ����",
				// return 307;
			"����©Һ",
				// return 308;
			"����FPC��",
				// return 309;
			"��͹��",
				// return 310;
			"����Ĥ��",
				// return 311;
			"��/ѹ��",
				// return 312;
			"��ۻ���",
				// return 313;
			"������",
				// return 314;
			"�������",
				// return 315;
			"��������",
				// return 316;
			"δ�����½�",
				// return 317;
			"ˮ����",
				// return 318;
			"��ۿ��ۻ�",
				// return 319;
			"©��",
				// return 320;
			"����",
				// return 321;
			"������",
				// return 322;
			"���벻��",
				// return 323;
			"������۲���"
			//return 324;
	};

	// int chuhuoCount = 0;
	// int tuihuoCount = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("test!");
		String FilePath = "D:/yewu.xls";
		File f = new File(FilePath);// Դ�ļ�

		zsyw yw = new zsyw();
		yw.showWindow();

	}

	public void showWindow() {
		this.setTitle("���Ǳ��ɰ�ѽѽ Beta 1.1");// ��������Ϊ�����족
		this.setSize(600, 300);// �����СΪ600*500
		this.setLocation(200, 200);// ����λ�þ���Ļ���Ͻ�Ϊ200*200
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// �رմ�������
		this.setResizable(true);// �����СΪ���ɱ䣬falseΪ���ɱ䣬trueΪ�ɱ�

		jlb1 = new JLabel("�ͻ�");
		jlb2 = new JLabel("�ͺ�");
		jlb3 = new JLabel("�쳣");

		jp1 = new JPanel();// ��������
		jp2 = new JPanel();// ��������
		jp3 = new JPanel();// ��������
		jp4 = new JPanel();// ��������
		jp5 = new JPanel();// ��������
		jp6 = new JPanel();// ��������
		jp7 = new JPanel();// ��������
		
		// jcb=new JComboBox(new String[]{"����1","����2","����3","����4"});//���ö�ѡ��
		jtf1 = new JTextField(50);// ������Ϣ�༭����ʾ����Ϊ20����
		jtf2 = new JTextField(50);// ������Ϣ�༭����ʾ����Ϊ20����
		//jtf3 = new JTextField(50);// ������Ϣ�༭����ʾ����Ϊ20����
		jcbb = new JComboBox(StringsYiChang);
		jb1 = new JButton("Test");// ������ť

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

		jta1 = new JTextArea();// �����ı���
		jta1.setSize(getMaximumSize());
		jta1.setText("����: " + "\n�˻�: " + "\n�˻���: ");
		jta2 = new JTextArea();// �����ı���
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
							jta2.setText("��ȡ�ļ�ʧ��, ��ȷ���ļ�����\nD:\\ͳ��.xls");
							e1.printStackTrace();
							
							
						} 
					}else {
						FilterData();

						ShowResult(); 
					}
				 
//				 if (listChuhuo == null) {
//					 jta1.setText("��ȡ�ļ�ʧ��, ��ȷ���ļ�����\nD:\\\\ͳ��.xls");
//					}else {
//						
//					}
//					
				

				
				// jta1.setText("����: " + "\n�˻�: " + "\n�˻���: " ) ;

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
		jta1.setText("�ͻ�: " + jtf1.getText() +
				"\n�ͺ�: " + jtf2.getText() +
				"\n����: " + ResultChuHuo + 
				"\n�˻�: " + ResultTuiHuo + 
				"\n�쳣����: " + jcbb.getSelectedItem() +
				 "\n�˻���: "+ (float) ResultTuiHuo / (float) ResultChuHuo);
		 
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
		boolean hasNotXianxiang = xianxiang.equals("����"); //jtf3.getText().isEmpty() || jtf3.getText().toString().equals("");
		
		
		
		// 3����,��������
		if (hasNotCostem == true && hasNotType == true && hasNotXianxiang == true) {
			for (Chuhuo item1 : listChuhuo) {
				ResultChuHuo += item1.getCount();

			}

			for (Tuihuo item2 : listTuihuo) {
				ResultTuiHuo += item2.getTotalCount();
			}

			return;
		}

		// ��ʼ����
		// һ�ι��˿ͻ�
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

		System.out.println("һ�ι���!" + " listChuhuoFilter1.size()=" + listChuhuoFilter1.size());
		System.out.println("һ�ι���!" + " listTuihuoFilter1.size()=" + listTuihuoFilter1.size());

		// ���ι����ͺ�
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
		
		System.out.println("���ι���!" + " listChuhuoFilter2.size()=" + listChuhuoFilter2.size());
		System.out.println("���ι���!" + " listTuihuoFilter2.size()=" + listTuihuoFilter2.size());

		// ���ι����쳣
		if (hasNotXianxiang == false) {
			int xianxiangId = GetXianxiangID(xianxiang);
			System.out.println("���ι���!" + " �쳣=" + xianxiang + " xianxiangId=" + xianxiangId);
			
			ResultTuiHuo = 0;
			for (Tuihuo item : listTuihuoFilter2) {

				switch (xianxiangId) {

				// δ�ҵ��쳣���� ,����
				case 0:
					jta2.append ("\n���ι����쳣 δ�ҵ��쳣���� ,����");
					
					System.out.println(" ���ι����쳣 δ�ҵ��쳣���� ,����");
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
		if (xianxiang.equals("�쳣")) {
			return 100;
		} else if (xianxiang.equals("ȱ��")) {
			return 101;
		} else if (xianxiang.equals("����")) {
			return 102;
		} else if (xianxiang.equals("����")) {
			return 103;
		} else if (xianxiang.equals("����")) {
			return 104;
		} else if (xianxiang.equals("����")) {
			return 105;
		} else if (xianxiang.equals("����")) {
			return 106;
		} else if (xianxiang.equals("����")) {
			return 107;
		} else if (xianxiang.equals("����")) {
			return 108;
		} else if (xianxiang.equals("IC����")) {
			return 109;
		} else if (xianxiang.equals("LCD����")) {
			return 110;
		} else if (xianxiang.equals("LCD��")) {
			return 111;
		} else if (xianxiang.equals("��������")) {
			return 112;
		} else if (xianxiang.equals("Һ������")) {
			return 113;
		} else if (xianxiang.equals("����/�ʵ�") || xianxiang.equals("����") || xianxiang.equals("�ʵ�")) {
			return 114;
		} else if (xianxiang.equals("��ʾ����")) {
			return 115;
		} else if (xianxiang.equals("�ͻ�����")) {
			return 116;
		} else if (xianxiang.equals("Mura")) {
			return 117;
		} else if (xianxiang.equals("��ʾ�ֲ�")) {
			return 118;
		} else if (xianxiang.equals("��Ӱ")) {
			return 119;
		} else if (xianxiang.equals("FPC��/����") || xianxiang.equals("FPC��") || xianxiang.equals("FPC����")) {
			return 120;
		} else if (xianxiang.equals("��FPC����")) {
			return 121;
		} else if (xianxiang.equals("FOG���ۻ�")) {
			return 122;
		} else if (xianxiang.equals("����")) {
			return 123;
		} else if (xianxiang.equals("ѹ��")) {
			return 124;
		} else if (xianxiang.equals("����FOG����")) {
			return 125;
		}

		// bl
		if (xianxiang.equals("BL����")) {
			return 200;
		} else if (xianxiang.equals("����")) {
			return 201;
		} else if (xianxiang.equals("����")) {
			return 202;
		} else if (xianxiang.equals("LED����")) {
			return 203;
		} else if (xianxiang.equals("B/Lɫ��") || xianxiang.equals("Bɫ��") || xianxiang.equals("Lɫ��")) {
			return 204;
		} else if (xianxiang.equals("B/L���") || xianxiang.equals("B���") || xianxiang.equals("L���")) {
			return 205;
		} else if (xianxiang.equals("BL��/��ӡ") || xianxiang.equals("BL��ӡ") || xianxiang.equals("BL��ӡ")) {
			return 206;
		} else if (xianxiang.equals("BL����")) {
			return 207;
		} else if (xianxiang.equals("BL�ڰ׵�")) {
			return 208;
		} else if (xianxiang.equals("©��")) {
			return 209;
		} else if (xianxiang.equals("BL�߶�")) {
			return 210;
		} else if (xianxiang.equals("Ĥ��")) {
			return 211;
		} else if (xianxiang.equals("������")) {
			return 212;
		} else if (xianxiang.equals("��ѹ�׵�")) {
			return 213;
		} else if (xianxiang.equals("BL����")) {
			return 214;
		} else if (xianxiang.equals("BL����")) {
			return 215;
		} else if (xianxiang.equals("BL��ʾ����")) {
			return 216;
		} else if (xianxiang.equals("����BL����")) {
			return 217;
		}

		// ��۲���
		if (xianxiang.equals("Ƭ��")) {
			return 300;
		} else if (xianxiang.equals("����")) {
			return 301;
		} else if (xianxiang.equals("Ƭ��")) {
			return 302;
		} else if (xianxiang.equals("ƬС")) {
			return 303;
		} else if (xianxiang.equals("ë˿")) {
			return 304;
		} else if (xianxiang.equals("Ƭ�ڰ�ӡ")) {
			return 305;
		} else if (xianxiang.equals("Ƭ����")) {
			return 306;
		} else if (xianxiang.equals("Ƭ����")) {
			return 307;
		} else if (xianxiang.equals("����©Һ")) {
			return 308;
		} else if (xianxiang.equals("����FPC��")) {
			return 309;
		} else if (xianxiang.equals("��͹��")) {
			return 310;
		} else if (xianxiang.equals("����Ĥ��")) {
			return 311;
		} else if (xianxiang.equals("��/ѹ��") || xianxiang.equals("�ۺ�") || xianxiang.equals("ѹ��")) {
			return 312;
		} else if (xianxiang.equals("��ۻ���")) {
			return 313;
		} else if (xianxiang.equals("������")) {
			return 314;
		} else if (xianxiang.equals("�������")) {
			return 315;
		} else if (xianxiang.equals("��������")) {
			return 316;
		} else if (xianxiang.equals("δ�����½�")) {
			return 317;
		} else if (xianxiang.equals("ˮ����")) {
			return 318;
		} else if (xianxiang.equals("��ۿ��ۻ�")) {
			return 319;
		} else if (xianxiang.equals("©��")) {
			return 320;
		} else if (xianxiang.equals("����")) {
			return 321;
		} else if (xianxiang.equals("������")) {
			return 322;
		} else if (xianxiang.equals("���벻��")) {
			return 323;
		} else if (xianxiang.equals("������۲���")) {
			return 324;
		}

		else{
			jta2.setText("��ȡ�쳣���ͳ���, ��ȷ���������� ,����");
			System.out.println(" ��ȡ�쳣���ͳ���, ��ȷ���������� ,����");
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
