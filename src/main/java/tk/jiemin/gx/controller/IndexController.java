package tk.jiemin.gx.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tk.jiemin.gx.service.WordService;

@Controller
public class IndexController {

	@Resource
	WordService wordService;

	@RequestMapping("/download")
	public ResponseEntity<byte[]> export(@RequestParam("company") String company, HttpServletRequest request)
			throws IOException {
		String path = request.getSession().getServletContext().getRealPath("/");

		Map<String, String> map = new HashMap<String, String>();
		map.put("${company}", company);

		String srcPath = "/Users/zjm/Documents/tongda/1、高新技术企业认定委托协议书.doc";
		String fileName = "1、高新技术企业认定委托协议书"+"_"+company+ ".doc";

		wordService.readwriteWord(srcPath, path, fileName, map);

		File file = new File(path + fileName);
		HttpHeaders headers = new HttpHeaders();
		String fn = new String(fileName.getBytes("UTF-8"), "iso-8859-1");

		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fn);

		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
}
