package webCrawling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawling {

	public static void main(String[] args) {
		String address = "https://search.kyobobook.co.kr/web/search?vPstrKeyWord=%25ED%258C%258C%25EC%259D%25B4%25EC%258D%25AC&orderClick=LAG";
		Document doc;
		try {
			doc = Jsoup.connect(address).get();
			Elements resultLinks = doc.select("tr>.price>.sell_price>strong");
			Element elem = resultLinks.get(0);
			List<String> values = new ArrayList<String>();
			for (Element element : resultLinks) {
				values.add(element.text());
			}
			System.out.println(values.toString());
			System.out.println(elem.text());
			
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("sheet");
			for (int i = 0; i < values.size(); i++) {
				XSSFRow row = sheet.createRow(i);
				XSSFCell cell = row.createCell(0);
				cell.setCellValue(values.get(i));
			}
			
			FileOutputStream fout = new FileOutputStream("C:/Users/AORUS/Desktop/Project/sample.xlsx");
			workbook.write(fout);
			fout.close();
			System.out.println("颇老 积己 己傍!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}}
