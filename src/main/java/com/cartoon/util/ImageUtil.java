package com.cartoon.util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageUtil {

	public void downloadPicture(String imageUrl, String savePath) {
		URL url = null;
		try {
			url = new URL(imageUrl);
			DataInputStream dataInputStream = new DataInputStream(url.openStream());
			String dirPath = savePath.substring(0, savePath.lastIndexOf(File.separator));
			File file= new File(dirPath);
			if(!file.exists()) {
				file.mkdirs();
			}
			FileOutputStream fileOutputStream = new FileOutputStream(new File(savePath));
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int length;
			while ((length = dataInputStream.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
			byte[] context = output.toByteArray();
			fileOutputStream.write(output.toByteArray());
			dataInputStream.close();
			fileOutputStream.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
