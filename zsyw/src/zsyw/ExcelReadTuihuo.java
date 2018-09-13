package zsyw;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadTuihuo {
	private static final String FilePath = "D:/统计.xls";
	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";
	
	private static final int fogBase = 19;
	private static final int backlightBase = 46;
	private static final int waiguanBase = 63;

	private static ArrayList<Tuihuo> list = new ArrayList<Tuihuo>();
	
	
	// 判断Excel的版本,获取Workbook
	public static Workbook getWorkbok(InputStream in, File file) throws IOException {
		Workbook wb = null;
		if (file.getName().endsWith(EXCEL_XLS)) { // Excel 2003
			wb = new HSSFWorkbook(in);
		} else if (file.getName().endsWith(EXCEL_XLSX)) { // Excel 2007/2010
			wb = new XSSFWorkbook(in);
		}
		return wb;
	}

	// 判断文件是否是excel
	public static void checkExcelVaild(File file) throws Exception {
		if (!file.exists()) {
			throw new Exception("文件不存在");
		}
		if (!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))) {
			throw new Exception("文件不是Excel");
		}
	}

	// 获取cell value
	public static String getCellValue(Cell cell) {

		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		int cellType = cell.getCellType();
		String cellValue = "0";
		switch (cellType) {
		case Cell.CELL_TYPE_STRING: // 文本
			cellValue = cell.getRichStringCellValue().getString() ;
			break;
		case Cell.CELL_TYPE_NUMERIC: // 数字、日期
			if (DateUtil.isCellDateFormatted(cell)) {
				cellValue = fmt.format(cell.getDateCellValue());
			} else {
				cell.setCellType(Cell.CELL_TYPE_STRING);
				cellValue = String.valueOf(cell.getRichStringCellValue().getString());
			}
			break;
		case Cell.CELL_TYPE_BOOLEAN: // 布尔型
			cellValue = String.valueOf(cell.getBooleanCellValue()) ;
			break;
		case Cell.CELL_TYPE_BLANK: // 空白
			cellValue = cell.getStringCellValue() ;
			break;
		case Cell.CELL_TYPE_ERROR: // 错误
			cellValue = "999999999999";
			break;
		case Cell.CELL_TYPE_FORMULA: // 公式
			// 得到对应单元格的公式
			// cellValue = cell.getCellFormula() + "#";
			// 得到对应单元格的字符串
			cell.setCellType(Cell.CELL_TYPE_STRING);
			cellValue = String.valueOf(cell.getRichStringCellValue().getString()) ;
			break;
		default:
			cellValue = "#";
		}
		
		if (cellValue.equals("") || cellValue.equals(" ") ||cellValue.isEmpty()) {
			return "0";
		}

//		System.out.print(cellValue);
		return cellValue;
	}

	// 由指定的Sheet导出至List
	public static ArrayList<Tuihuo> exportListFromExcel() throws Exception {  

    
 
            // 同时支持Excel 2003、2007  
            File excelFile = new File(FilePath); // 创建文件对象  
            FileInputStream is = new FileInputStream(excelFile); // 文件流  
            checkExcelVaild(excelFile);  
            Workbook workbook = getWorkbok(is,excelFile);  
            //Workbook workbook = WorkbookFactory.create(is); // 这种方式 Excel2003/2007/2010都是可以处理的  

            int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量  
            /** 
             * 设置当前excel中sheet的下标：0开始 
             */  
            Sheet sheet = workbook.getSheetAt(0);   // 遍历第一个Sheet
            

            
            //读取出货表
            for(int i = 1; i < sheetCount; i++) {
            	String sheetName= sheet.getSheetName();
            	if(sheetName.equals("客退")) {
            		break;
            	}
            		
            	 
            	sheet = workbook.getSheetAt(i);
            }
            
            list = new ArrayList<Tuihuo>();
            
            // 为跳过第一行目录设置count  
            int count = 0; 

            for (Row row : sheet) {  
                // 跳过第N行 
                if(count < 11){  
                	count++;  
                    continue;  
                }  
                count++; 
                
                // 如果当前行没有数据，跳出循环  
               
                if(row.getCell(0) == null){  
                    return list;  
                }  
                if(row.getCell(0).toString().equals("")){  
                    return list;  
                }  
                
                if(row.getCell(0).toString().isEmpty()){  
                    return list;  
                }  
               // String rowValue = "";  //
                
                //   String cellValue = "";  
                
                 
                	String costem = getCellValue(row.getCell(4));
                	//System.out.println("costem is " + costem);  
                	
                	String type = getCellValue(row.getCell(5));
                	//System.out.println("type is " + type);  
                	
                	int yichangCount = Integer.parseInt( getCellValue(row.getCell(fogBase + 1 )) );
                	//System.out.println("yichangCount is " + yichangCount);  
                	int quehuaCount = Integer.parseInt( getCellValue(row.getCell(fogBase + 2)) );
                	//System.out.println("quehuaCount is " + quehuaCount);  
                	int baipingCount = Integer.parseInt( getCellValue(row.getCell(fogBase +3 )) );
                	//System.out.println("baipingCount is " + baipingCount);  
                	int huapingCount = Integer.parseInt( getCellValue(row.getCell( fogBase +4)) );
                	int shanpingCount = Integer.parseInt( getCellValue(row.getCell(fogBase +5 )) );
                	int heipingCount = Integer.parseInt( getCellValue(row.getCell(fogBase +6 )) );
                	int wuxiangCount = Integer.parseInt( getCellValue(row.getCell(fogBase +7 )) );
                	int fengpingCount = Integer.parseInt( getCellValue(row.getCell(fogBase +8 )) );
                	int fangpingCount = Integer.parseInt( getCellValue(row.getCell(fogBase +9 )) );
                	int idBrokeCount = Integer.parseInt( getCellValue(row.getCell( fogBase +10)) );
                	int lcdfahuangCount = Integer.parseInt( getCellValue(row.getCell(fogBase +11 )) );
                	int lcddianCount = Integer.parseInt( getCellValue(row.getCell(fogBase +12 )) );
                	int lailiaopopingCount = Integer.parseInt( getCellValue(row.getCell(fogBase +13 )) );
                	int yejingbuliangCount = Integer.parseInt( getCellValue(row.getCell(fogBase +14 )) );
                	int liangdianOrCaidianCount = Integer.parseInt( getCellValue(row.getCell(fogBase +15 )) );
                 	int xianshibuwengCount = Integer.parseInt( getCellValue(row.getCell( fogBase +16)) );
                	int kejihuayiCount = Integer.parseInt( getCellValue(row.getCell(fogBase +17 )) );
                	int muraCount = Integer.parseInt( getCellValue(row.getCell(fogBase +18 )) );
                	int xianshichuchaoCount = Integer.parseInt( getCellValue(row.getCell( fogBase +19)) );
                	int cangyingCount = Integer.parseInt( getCellValue(row.getCell( fogBase +20)) );
                	int fpchuaOrBuliangCount = Integer.parseInt( getCellValue(row.getCell(fogBase +21 )) );
                	int dongFpcHuayiCount = Integer.parseInt( getCellValue(row.getCell(fogBase +22 )) );
                	int kakouhuaiCount = Integer.parseInt( getCellValue(row.getCell(fogBase +23 )) );
                	int popingCount = Integer.parseInt( getCellValue(row.getCell( fogBase +24)) );
                	int yabaiCount = Integer.parseInt( getCellValue(row.getCell( fogBase +25)) );
                	int qitaFogCount = Integer.parseInt( getCellValue(row.getCell(fogBase +26 )) );
                	//System.out.println("qitaFogCount is " + qitaFogCount); 
                	
                	int BlbuliangCount = Integer.parseInt( getCellValue(row.getCell(backlightBase + 0 )) );
                	//System.out.println("BlbuliangCount is " + BlbuliangCount); 
                	int dengyangCount = Integer.parseInt( getCellValue(row.getCell( backlightBase +1)) );
                	//System.out.println("dengyangCount is " + dengyangCount); 
                	int sidengCount = Integer.parseInt( getCellValue(row.getCell(backlightBase +2 )) );
                	int ledDengshanCount = Integer.parseInt( getCellValue(row.getCell(backlightBase +3 )) );
                	int bOrLshechaCount = Integer.parseInt( getCellValue(row.getCell(backlightBase +4 )) );
                	int bOrLzhangdianCount = Integer.parseInt( getCellValue(row.getCell(backlightBase +5 )) );
                	int blHeiOrBaiyingCount = Integer.parseInt( getCellValue(row.getCell(backlightBase +6 )) );
                	int blHuashanCount = Integer.parseInt( getCellValue(row.getCell(backlightBase +7)) );
                	int blHeibaidianCount = Integer.parseInt( getCellValue(row.getCell(backlightBase +8 )) );
                	int louguanCount = Integer.parseInt( getCellValue(row.getCell( backlightBase +9)) );
                	int blDuanxianCount = Integer.parseInt( getCellValue(row.getCell(backlightBase +10 )) );
                	int mogongCount = Integer.parseInt( getCellValue(row.getCell( backlightBase +11)) );
                	int ganshewenCount = Integer.parseInt( getCellValue(row.getCell( backlightBase +12)) );
                	int anyabaidianCount = Integer.parseInt( getCellValue(row.getCell( backlightBase +13)) );
                	int hunliaoCount = Integer.parseInt( getCellValue(row.getCell(backlightBase +14 )) );
                	int blFahuangCount = Integer.parseInt( getCellValue(row.getCell(backlightBase +15 )) );
                	int lbXianshibulianCount = Integer.parseInt( getCellValue(row.getCell(backlightBase +16 )) );
                	int backlightQitaCount = Integer.parseInt( getCellValue(row.getCell(backlightBase +17 )) );
                	//System.out.println("backlightQitaCount is " + backlightQitaCount); 
                	
                	int pianshanCount = Integer.parseInt( getCellValue(row.getCell(waiguanBase + 1 )) );
                	//System.out.println("pianshanCount is " + pianshanCount); 
                	int qipaoCount = Integer.parseInt( getCellValue(row.getCell(waiguanBase + 2 )) );
                	//System.out.println("qipaoCount is " + qipaoCount); 
                	
                	
                	int pianzhangCount = Integer.parseInt( getCellValue(row.getCell(waiguanBase + 3 )) );
                	int pianxiaoCount = Integer.parseInt( getCellValue(row.getCell(waiguanBase + 4 )) );
                	int maoshiCount = Integer.parseInt( getCellValue(row.getCell(waiguanBase + 5  )) );
                	int paiheibaiyingCount = Integer.parseInt( getCellValue(row.getCell( waiguanBase + 6)) );
                	int pianzhangwuCount = Integer.parseInt( getCellValue(row.getCell(waiguanBase + 7 )) );
                	int pianwaitieCount = Integer.parseInt( getCellValue(row.getCell( waiguanBase + 8)) );
                	int lailiaolouyeCount = Integer.parseInt( getCellValue(row.getCell(waiguanBase + 9 )) );
                	int lailiaoFpcHuaiCount = Integer.parseInt( getCellValue(row.getCell( waiguanBase + 10)) );
                	int aotudianCount = Integer.parseInt( getCellValue(row.getCell( waiguanBase + 11)) );
                	int baohumozhangCount = Integer.parseInt( getCellValue(row.getCell(waiguanBase + 12 )) );
                	int zheyahengCount = Integer.parseInt( getCellValue(row.getCell(waiguanBase + 13 )) );
                	int hunliao2Count = Integer.parseInt( getCellValue(row.getCell( waiguanBase + 14 )) );
                	int tiekuanzhangCount = Integer.parseInt( getCellValue(row.getCell(waiguanBase + 15 )) );
                	int tiekuanbianxingCount = Integer.parseInt( getCellValue(row.getCell( waiguanBase + 16)) );
                	int tiekuanshenxiuCount = Integer.parseInt( getCellValue(row.getCell(waiguanBase + 17 )) );
                	int weitiegaowenjiaoCount = Integer.parseInt( getCellValue(row.getCell(waiguanBase + 18 )) );
                	int shuibowenCount = Integer.parseInt( getCellValue(row.getCell(waiguanBase + 19)) );
                	int kakouhuai2Count = Integer.parseInt( getCellValue(row.getCell( waiguanBase + 20)) );
                	int loujiaoCount = Integer.parseInt( getCellValue(row.getCell( waiguanBase + 21)) );
                	int yiwuCount = Integer.parseInt( getCellValue(row.getCell(waiguanBase + 22 )) );
                	int jiaobuliangCount = Integer.parseInt( getCellValue(row.getCell(waiguanBase + 23)) );
                	int penmabuliangCount = Integer.parseInt( getCellValue(row.getCell(waiguanBase + 24 )) );
                	int qitaCount = Integer.parseInt( getCellValue(row.getCell( waiguanBase + 25)) );
                	//System.out.println("qitaCount is " + qitaCount); 
                	
                	
                	
                	Tuihuo item = new Tuihuo(costem, type,
                			yichangCount,
                        	quehuaCount,
                        	baipingCount,
                        	huapingCount,
                        	shanpingCount,
                        	heipingCount,
                        	wuxiangCount,
                        	fengpingCount,
                        	fangpingCount,
                        	idBrokeCount,
                        	lcdfahuangCount,
                        	lcddianCount,
                        	lailiaopopingCount,
                        	yejingbuliangCount,
                        	liangdianOrCaidianCount,
                        	xianshibuwengCount,
                        	kejihuayiCount,
                        	muraCount,
                        	xianshichuchaoCount,
                        	cangyingCount,
                        	fpchuaOrBuliangCount,
                        	dongFpcHuayiCount,
                        	kakouhuaiCount,
                        	popingCount,
                        	yabaiCount,
                        	qitaFogCount,
                        	
                        	
                        	BlbuliangCount,
                        	dengyangCount,
                        	sidengCount,
                        	ledDengshanCount,
                        	bOrLshechaCount,
                        	bOrLzhangdianCount,
                        	blHeiOrBaiyingCount,
                        	blHuashanCount,
                        	blHeibaidianCount,
                        	louguanCount,
                        	blDuanxianCount,
                        	mogongCount,
                        	ganshewenCount,
                        	anyabaidianCount,
                        	hunliaoCount,
                        	blFahuangCount,
                        	lbXianshibulianCount,
                        	backlightQitaCount,
                        	
                        	
                        	pianshanCount,
                        	qipaoCount,
                        	pianzhangCount,
                        	pianxiaoCount,
                        	maoshiCount,
                        	paiheibaiyingCount,
                        	pianzhangwuCount,
                        	pianwaitieCount,
                        	lailiaolouyeCount,
                        	lailiaoFpcHuaiCount,
                        	aotudianCount,
                        	baohumozhangCount,
                        	zheyahengCount,
                        	hunliao2Count,
                        	tiekuanzhangCount,
                        	tiekuanbianxingCount,
                        	tiekuanshenxiuCount,
                        	weitiegaowenjiaoCount,
                        	shuibowenCount,
                        	kakouhuai2Count,
                        	loujiaoCount,
                        	yiwuCount,
                        	jiaobuliangCount,
                        	penmabuliangCount,
                        	qitaCount);
                	list.add(item);
                	
                 	//System.out.println("Total is " + item.getTotalCount());  
                 
               
//                for (Cell cell : row) {  
//                	if(cell.toString() == null){  
//                		continue;  
//                	}  
//
//
//                	rowValue += cellValue;  
//                }    
               // System.out.println(rowValue);  
                //System.out.println("" + count);  
            }   
           
        	
        	return list;
          
    }
}