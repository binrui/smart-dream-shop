package com.smart.shop.base.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FtpUtil {

	public static final Logger logger = LoggerFactory.getLogger(FtpUtil.class);
	private static FTPClient ftpClient;

	public static final int BINARY_FILE_TYPE = FTP.BINARY_FILE_TYPE;

	public static final int ASCII_FILE_TYPE = FTP.ASCII_FILE_TYPE;

	public static void connectServer(String server, int port, String user,
			String password, String path) throws SocketException, IOException {
		ftpClient = new FTPClient();
		ftpClient.connect(server);
		logger.info("Connected to [" + server + "]", FtpUtil.class);
		System.out.println(ftpClient.getReplyString());
		System.out.println(ftpClient.getReplyCode());
		//ftpClient.logout();
		ftpClient.login(user, password);
		
		System.out.println(ftpClient.getReplyString());
		System.out.println(ftpClient.getReplyCode());
		if (path.length() != 0) {
			ftpClient.changeWorkingDirectory(path);
		}
		ftpClient.enterLocalPassiveMode();
	}

	public static void setFileType(int fileType) throws IOException {
		ftpClient.setFileType(fileType);
	}

	public static void closeServer() throws IOException {
		if (ftpClient.isConnected()) {
			ftpClient.logout();
			ftpClient.disconnect();
		}
	}

	public static boolean changeDirectory(String path) throws IOException {
		return ftpClient.changeWorkingDirectory(path);
	}
	public static boolean createDirectory(String pathName) throws IOException {
		return ftpClient.makeDirectory(pathName);
	}
	public static boolean removeDirectory(String path) throws IOException {
		return ftpClient.removeDirectory(path);
	}

	public static boolean existDirectory(String path) throws IOException {
		boolean flag = false;
		FTPFile[] ftpFileArr = ftpClient.listFiles(path);
		for (FTPFile ftpFile : ftpFileArr) {
			if (ftpFile.isDirectory()
					&& ftpFile.getName().equalsIgnoreCase(path)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public static List<String> getFileList(String path) throws IOException {
		FTPFile[] ftpFiles = ftpClient.listFiles(path);

		List<String> retList = new ArrayList<String>();
		if (ftpFiles == null || ftpFiles.length == 0) {
			return retList;
		}
		for (FTPFile ftpFile : ftpFiles) {
			if (ftpFile.isFile()) {
				retList.add(ftpFile.getName());
			}
		}
		return retList;
	}

	public static boolean download(String remoteFileName, String localFileName)
			throws IOException {
		boolean flag = false;
		File outfile = new File(localFileName);
		OutputStream oStream = null;
		try {
			oStream = new FileOutputStream(outfile);
			flag = ftpClient.retrieveFile(remoteFileName, oStream);
		} catch (IOException e) {
			flag = false;
			return flag;
		} finally {
			oStream.close();
		}
		return flag;
	}

	public static InputStream downFile(String sourceFileName) throws IOException {
		return ftpClient.retrieveFileStream(sourceFileName);
	}
	
	public static void main(String[] args) {
		try {
			FtpUtil.connectServer("172.31.184.13", 21, "275", "275!", "/");
			FtpUtil.setFileType(FtpUtil.ASCII_FILE_TYPE);
			List<String> file = FtpUtil.getFileList("/");
			for (Iterator<String> iterator = file.iterator(); iterator.hasNext();) {
				String string = iterator.next();
				System.out.println(string);
			}
			//InputStream in = FtpUtil.downFile("/275-20110924.txt");
			FtpUtil.closeServer();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
