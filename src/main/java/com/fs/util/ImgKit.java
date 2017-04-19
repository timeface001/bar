package com.fs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ImgKit
{

	public final static Map<String, String> FILE_TYPE_MAP = new HashMap<String, String>();

	private ImgKit()
	{

	}

	static
	{
		getAllFileType(); // 閸掓繂顫愰崠鏍ㄦ瀮娴犲墎琚崹瀣╀繆閹拷
	}

	private static void getAllFileType()
	{
		FILE_TYPE_MAP.put("ffd8ffe000104a464946", "jpg"); //JPEG (jpg)
		FILE_TYPE_MAP.put("89504e470d0a1a0a0000", "png"); //PNG (png)
		FILE_TYPE_MAP.put("47494638396126026f01", "gif"); //GIF (gif)
		FILE_TYPE_MAP.put("49492a00227105008037", "tif"); //TIFF (tif)
		FILE_TYPE_MAP.put("424d228c010000000000", "bmp"); //16閼硅弓缍呴崶锟絙mp)
		FILE_TYPE_MAP.put("424d8240090000000000", "bmp"); //24娴ｅ秳缍呴崶锟絙mp)
		FILE_TYPE_MAP.put("424d8e1b030000000000", "bmp"); //256閼硅弓缍呴崶锟絙mp)
		FILE_TYPE_MAP.put("41433130313500000000", "dwg"); //CAD (dwg)
		FILE_TYPE_MAP.put("3c21444f435459504520", "html"); //HTML (html)
		FILE_TYPE_MAP.put("3c21646f637479706520", "htm"); //HTM (htm)
		FILE_TYPE_MAP.put("48544d4c207b0d0a0942", "css"); //css
		FILE_TYPE_MAP.put("696b2e71623d696b2e71", "js"); //js
		FILE_TYPE_MAP.put("7b5c727466315c616e73", "rtf"); //Rich Text Format (rtf)
		FILE_TYPE_MAP.put("38425053000100000000", "psd"); //Photoshop (psd)
		FILE_TYPE_MAP.put("46726f6d3a203d3f6762", "eml"); //Email [Outlook Express 6] (eml)
		FILE_TYPE_MAP.put("d0cf11e0a1b11ae10000", "doc"); //MS Excel 濞夈劍鍓伴敍姝竜rd閵嗕沟si 閸滐拷excel閻ㄥ嫭鏋冩禒璺恒仈娑擄拷鐗�
		FILE_TYPE_MAP.put("d0cf11e0a1b11ae10000", "vsd"); //Visio 缂佹ê娴�
		FILE_TYPE_MAP.put("5374616E64617264204A", "mdb"); //MS Access (mdb)
		FILE_TYPE_MAP.put("252150532D41646F6265", "ps");
		FILE_TYPE_MAP.put("255044462d312e350d0a", "pdf"); //Adobe Acrobat (pdf)
		FILE_TYPE_MAP.put("2e524d46000000120001", "rmvb"); //rmvb/rm閻╃鎮�
		FILE_TYPE_MAP.put("464c5601050000000900", "flv"); //flv娑撳穳4v閻╃鎮�
		FILE_TYPE_MAP.put("00000020667479706",    "mp4");
		FILE_TYPE_MAP.put("49443303000000002176", "mp3");
		FILE_TYPE_MAP.put("000001ba210001000180", "mpg"); //
		FILE_TYPE_MAP.put("3026b2758e66cf11a6d9", "wmv"); //wmv娑撳穬sf閻╃鎮�
		FILE_TYPE_MAP.put("52494646e27807005741", "wav"); //Wave (wav)
		FILE_TYPE_MAP.put("52494646d07d60074156", "avi");
		FILE_TYPE_MAP.put("4d546864000000060001", "mid"); //MIDI (mid)
		FILE_TYPE_MAP.put("504b0304140000000800", "zip");
		FILE_TYPE_MAP.put("526172211a0700cf9073", "rar");
		FILE_TYPE_MAP.put("235468697320636f6e66", "ini");
		FILE_TYPE_MAP.put("504b03040a0000000000", "jar");
		FILE_TYPE_MAP.put("00000018667479706d70", "mp4");

		FILE_TYPE_MAP.put("4d5a9000030000000400", "exe");//閸欘垱澧界悰灞炬瀮娴狅拷
		FILE_TYPE_MAP.put("3c25402070616765206c", "jsp");//jsp閺傚洣娆�
		FILE_TYPE_MAP.put("4d616e69666573742d56", "mf");//MF閺傚洣娆�
		FILE_TYPE_MAP.put("3c3f786d6c2076657273", "xml");//xml閺傚洣娆�
		FILE_TYPE_MAP.put("494e5345525420494e54", "sql");//xml閺傚洣娆�
		FILE_TYPE_MAP.put("7061636b616765207765", "java");//java閺傚洣娆�
		FILE_TYPE_MAP.put("406563686f206f66660d", "bat");//bat閺傚洣娆�
		FILE_TYPE_MAP.put("1f8b0800000000000000", "gz");//gz閺傚洣娆�
		FILE_TYPE_MAP.put("6c6f67346a2e726f6f74", "properties");//bat閺傚洣娆�
		FILE_TYPE_MAP.put("cafebabe0000002e0041", "class");//bat閺傚洣娆�
		FILE_TYPE_MAP.put("49545346030000006000", "chm");//bat閺傚洣娆�
		FILE_TYPE_MAP.put("04000000010000001300", "mxp");//bat閺傚洣娆�
		FILE_TYPE_MAP.put("504b0304140006000800", "docx");//docx閺傚洣娆�
		FILE_TYPE_MAP.put("d0cf11e0a1b11ae10000", "wps");//WPS閺傚洤鐡ps閵嗕浇銆冮弽绯磘閵嗕焦绱ㄧ粈绡竝s闁姤妲告稉锟界壉閻拷
		FILE_TYPE_MAP.put("6431303a637265617465", "torrent");


		FILE_TYPE_MAP.put("6D6F6F76", "mov"); //Quicktime (mov)
		FILE_TYPE_MAP.put("FF575043", "wpd"); //WordPerfect (wpd)
		FILE_TYPE_MAP.put("CFAD12FEC5FD746F", "dbx"); //Outlook Express (dbx)
		FILE_TYPE_MAP.put("2142444E", "pst"); //Outlook (pst)
		FILE_TYPE_MAP.put("AC9EBD8F", "qdf"); //Quicken (qdf)
		FILE_TYPE_MAP.put("E3828596", "pwl"); //Windows Password (pwl)
		FILE_TYPE_MAP.put("2E7261FD", "ram"); //Real Audio (ram)
	}

	public final static String getFileByFile(File file,String defaultType)
	{
		String filetype = null;
		byte[] b = new byte[50];
		try
		{
			InputStream is = new FileInputStream(file);
			is.read(b);
			filetype = getFileTypeByStream(b,defaultType);
			is.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return filetype;
	}

	public final static String getFileByFile(InputStream is,String defaultType)
	{
		String filetype = null;
		byte[] b = new byte[50];
		try
		{
			is.read(b);
			filetype = getFileTypeByStream(b,defaultType);
			is.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return filetype;
	}

	public final static String getFileTypeByStream(byte[] b,String defaultType)
	{
		String filetypeHex = String.valueOf(getFileHexString(b));
		Iterator<Entry<String, String>> entryiterator = FILE_TYPE_MAP.entrySet().iterator();
		while (entryiterator.hasNext())
		{
			Entry<String, String> entry = entryiterator.next();
			String fileTypeHexValue = entry.getKey();
			if (filetypeHex.toUpperCase().startsWith(fileTypeHexValue.toUpperCase()))
			{
				return entry.getValue();
			}
		}
		return defaultType;
	}

	public final static String getFileHexString(byte[] b)
	{
		StringBuilder stringBuilder = new StringBuilder();
		if (b == null || b.length <= 0)
		{
			return null;
		}
		for (int i = 0; i < b.length; i++)
		{
			int v = b[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2)
			{
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}
}
