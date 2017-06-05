package tk.jiemin.gx.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.FieldsDocumentPart;
import org.apache.poi.hwpf.usermodel.Field;
import org.apache.poi.hwpf.usermodel.Fields;
import org.apache.poi.hwpf.usermodel.Range;
import org.springframework.stereotype.Service;

@Service
public class WordService {

	public void readwriteWord(String sourcefilePath, String filepath, String fileName, Map<String, String> map) {
		// 读取word模板
		FileInputStream in = null;
		try {
			in = new FileInputStream(new File(sourcefilePath));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		HWPFDocument hdt = null;
		try {
			hdt = new HWPFDocument(in);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Fields fields = hdt.getFields();
		Iterator<Field> it = fields.getFields(FieldsDocumentPart.MAIN).iterator();
		while (it.hasNext()) {
			System.out.println(it.next().getType());
		}

		// 读取word文本内容
		Range range = hdt.getRange();

		// 替换文本内容
		for (Map.Entry<String, String> entry : map.entrySet()) {
			range.replaceText(entry.getKey(), entry.getValue());
		}
		ByteArrayOutputStream ostream = new ByteArrayOutputStream();
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(filepath + fileName, true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			hdt.write(ostream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 输出字节流
		try {
			out.write(ostream.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ostream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
