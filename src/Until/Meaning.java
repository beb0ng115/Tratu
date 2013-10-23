package Until;

import java.io.File;
import java.io.RandomAccessFile;

import android.os.Environment;

public class Meaning {

	public static String convert10to64(int num) {
		String number = "";
		String code = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
		while (num != 0) {
			number = code.charAt(num % 64) + number;
			num = num / 64;
		}
		return number;
	}

	public static int convert64to10(String num) {
		int number = 0;
		int len = num.length();
		String code = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
		for (int i = 0; i < len; i++) {
			number += code.indexOf(num.charAt(i)) * Math.pow(64, len - i - 1);
		}
		return number;
	}

	public static String LoadMean(String words, String wOffset, String wLengths)
			throws Exception {
		// this.mean = "";
		String means = "";
		int offset = convert64to10("nSJ7");
		int lengths = convert64to10("Zu");

		File mfile = new File(System.getProperty("user.dir").concat(
				Environment.getExternalStorageDirectory().getAbsolutePath()
						+ "/EnglishVietnamese.dict"));
		try {
			RandomAccessFile fileAccess = new RandomAccessFile(mfile, "r");
			fileAccess.seek(offset);
			byte[] dst = new byte[lengths];
			fileAccess.read(dst, 0, lengths);
			means = new String(dst);// .replaceAll("\0+", "");
		} catch (Exception exc) {

		}

		return means;
		// Mỗi lần mình nhập, thì mình tìm 1 lần
		// - > thời gian tìm kiếm lâu, thời gian load nhanh
		// String mean =null
		// dau vo : offset -> length
		// dau ra : Nghia
		// 1. tu offset la leng, truy cap vao file dic voi offset va leng
		// FileAccessRandom
		// Lay nghia ra

		/*
		 * int size = address.size(); for (int i = 0; i < size; i++) { int
		 * address = this.address.get(i); int len = this.length.get(i); byte[]
		 * buff = new byte[len]; input.seek(address); input.read(buff, 0, len);
		 * String mean = new String(buff, "UTF8").replaceAll("\0+", ""); if (i
		 * == 0) { this.mean = mean; } else { if
		 * (!this.mean.contains(mean.trim())) { this.mean += '\n' + mean; } } }
		 * this.isLoaded = true;
		 */
	}
}
