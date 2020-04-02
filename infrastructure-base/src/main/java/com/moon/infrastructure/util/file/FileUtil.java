package com.moon.infrastructure.util.file;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.moon.infrastructure.exception.IoRuntimeException;
import com.moon.infrastructure.logger.Logger;
import com.moon.infrastructure.logger.LoggerFactory;
import com.moon.infrastructure.util.CharsetUtil;

/**
 * @Author: gongzhipeng
 * @Date: 2020/3/17 3:14 下午
 * @Description:
 * @Project: infrastructure-test
 * @Package com.moon.infrastructure.util
 */
public class FileUtil
{
	private Logger logger = LoggerFactory.getLogger(FileUtil.class);

	/**
	 * 遍历文件下的全部文件
	 * @param filename 文件名
	 * @return
	 */
	public static List<File> listAllFile(String filename)
	{
		if (StringUtils.isBlank(filename))
		{
			return null;
		}
		return listAllFile(new File(filename));
	}

	/**
	 * 遍历文件下的全部文件
	 * @param file 文件
	 * @return
	 */
	public static List<File> listAllFile(File file)
	{
		List<File> fileList = new ArrayList<>();
		if (file.isDirectory())
		{
			File[] files = file.listFiles();
			if (files != null)
			{
				for (File file1 : files)
				{
					fileList.addAll(listAllFile(file1));
				}
			}
		}
		else
		{
			fileList.add(file);
		}
		return fileList;
	}

	/**
	 *
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException
	 */
	 public static BufferedReader getBufferReaderByFile(String fileName) throws FileNotFoundException
	{
		if (StringUtils.isBlank(fileName))
		{
			return null;
		}
		return getBufferReaderByFile(new File(fileName));
	}

	public static BufferedReader getBufferReaderByFile(File file) throws FileNotFoundException
	{
		FileReader fr = null;

		fr = new FileReader(file);
		return new BufferedReader(fr);
	}

	/**
	 * 关闭<br>
	 * 关闭失败不会抛出异常
	 *
	 * @param closeable 被关闭的对象
	 */
	public static void close(Closeable closeable)
	{
		if (null != closeable)
		{
			try
			{
				closeable.close();
			}
			catch (Exception e)
			{
				// 静默关闭
			}
		}
	}


	/**
	 * 单行处理文件内容
	 *
	 * @param file        {@link RandomAccessFile}文件
	 * @param charset     编码
	 * @param lineHandler {@link LineHandler}行处理器
	
	 * @since 4.5.2
	 */
	public static void readLine(RandomAccessFile file, Charset charset, LineHandler lineHandler) {
		final String line = readLine(file, charset);
		if (null != line) {
			lineHandler.handle(line);
		}
	}

	/**
	 * 单行处理文件内容
	 *
	 * @param file    {@link RandomAccessFile}文件
	 * @param charset 编码
	 * @return 行内容
	 * @throws IoRuntimeException IO异常
	 * @since 4.5.18
	 */
	public static String readLine(RandomAccessFile file, Charset charset) {
		String line;
		try {
			line = file.readLine();
		} catch (IOException e) {
			throw new IoRuntimeException("读取文件异常",e);
		}
		if (null != line) {
			return CharsetUtil.convert(line, CharsetUtil.CHARSET_ISO_8859_1, charset);
		}

		return null;
	}


}
