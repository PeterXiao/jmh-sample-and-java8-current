/**
 *
 */
package utils;

/**
 * @author LiY
 *
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexUtils {
	private int index, len;
	public static void fastCopy(String src, String dist) throws IOException {

		/* 获得源文件的输入字节流 */
		FileInputStream fin = new FileInputStream(src);

		/* 获取输入字节流的文件通道 */
		FileChannel fcin = fin.getChannel();

		/* 获取目标文件的输出字节流 */
		FileOutputStream fout = new FileOutputStream(dist);

		/* 获取输出字节流的文件通道 */
		FileChannel fcout = fout.getChannel();

		/* 为缓冲区分配 1024 个字节 */
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

		while (true) {

			/* 从输入通道中读取数据到缓冲区中 */
			int r = fcin.read(buffer);

			/* read() 返回 -1 表示 EOF */
			if (r == -1) {
				break;
			}

			/* 切换读写 */
			buffer.flip();

			/* 把缓冲区的内容写入输出文件中 */
			fcout.write(buffer);

			/* 清空缓冲区 */
			buffer.clear();
		}
	}
	public String longestPalindromes(String s) {
		if (s.length() < 2)
			return s;
		for (int i = 0; i < s.length() - 1; i++) {
			PalindromeHelper(s, i, i);
			PalindromeHelper(s, i, i + 1);
		}
		return s.substring(index, index + len);
	}

	public void PalindromeHelper(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		if (len < r - l - 1) {
			index = l + 1;
			len = r - l - 1;
		}
	}
	public  boolean isPalindrome(String s) {
		if (s.length() == 0)
			return true;
		int l = 0, r = s.length() - 1;
		while (l < r) {
			// 从头和尾开始向中间遍历
			if (!Character.isLetterOrDigit(s.charAt(l))) {// 字符不是字母和数字的情况
				l++;
			} else if (!Character.isLetterOrDigit(s.charAt(r))) {// 字符不是字母和数字的情况
				r--;
			} else {
				// 判断二者是否相等
				if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
					return false;
				l++;
				r--;
			}
		}
		return true;
	}
	public  int longestPalindrome(String s) {
		if (s.length() == 0)
			return 0;
		// 用于存放字符
		HashSet<Character> hashset = new HashSet<Character>();
		char[] chars = s.toCharArray();
		int count = 0;
		for (int i = 0; i < chars.length; i++) {
			if (!hashset.contains(chars[i])) {// 如果hashset没有该字符就保存进去
				hashset.add(chars[i]);
			} else {// 如果有,就让count++（说明找到了一个成对的字符），然后把该字符移除
				hashset.remove(chars[i]);
				count++;
			}
		}
		return hashset.isEmpty() ? count * 2 : count * 2 + 1;
	}
	public static String replaceSpace(String[] strs) {

		// 数组长度
		int len = strs.length;
		// 用于保存结果
		StringBuffer res = new StringBuffer();
		// 注意：=是赋值，==是判断
		if (strs == null || strs.length == 0) {
			return "";
		}
		// 给字符串数组的元素按照升序排序(包含数字的话，数字会排在前面)
		Arrays.sort(strs);
		int m = strs[0].length();
		int n = strs[len - 1].length();
		int num = Math.min(m, n);
		for (int i = 0; i < num; i++) {
			if (strs[0].charAt(i) == strs[len - 1].charAt(i)) {
				res.append(strs[0].charAt(i));
			} else
				break;

		}
		return res.toString();

	}
	/**
	 * 第一种方法：常规方法。利用String.charAt(i)以及String.valueOf(char).equals(" "
	 * )遍历字符串并判断元素是否为空格。是则替换为"%20",否则不替换
	 */
	public static String replaceSpace(StringBuffer str) {

		int length = str.length();
		// System.out.println("length=" + length);
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < length; i++) {
			char b = str.charAt(i);
			if (String.valueOf(b).equals(" ")) {
				result.append("%20");
			} else {
				result.append(b);
			}
		}
		return result.toString();

	}

	/**
	 * 第二种方法：利用API替换掉所用空格，一行代码解决问题
	 */
	public static String replaceSpace2(StringBuffer str) {

		return str.toString().replaceAll("\\s", "%20");
	}
	/**
	 * 验证Email
	 * @param email email地址，格式：zhangsan@sina.com，zhangsan@xxx.com.cn，xxx代表邮件服务商
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkEmail(String email) {
		String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
		return Pattern.matches(regex, email);
	}

	/**
	 * 验证身份证号码
	 * @param idCard 居民身份证号码18位，第一位不能为0，最后一位可能是数字或字母，中间16位为数字 \d同[0-9]
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkIdCard(String idCard) {
		String regex = "[1-9]\\d{16}[a-zA-Z0-9]{1}";
		return Pattern.matches(regex,idCard);
	}

	/**
	 * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
	 * @param mobile 移动、联通、电信运营商的号码段
	 *<p>移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡）
	 *、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）</p>
	 *<p>联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）</p>
	 *<p>电信的号段：133、153、180（未启用）、189</p>
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkMobile(String mobile) {
		String regex = "(\\+\\d+)?1[3458]\\d{9}$";
		return Pattern.matches(regex,mobile);
	}

	/**
	 * 验证固定电话号码
	 * @param phone 电话号码，格式：国家（地区）电话代码 + 区号（城市代码） + 电话号码，如：+8602085588447
	 * <p><b>国家（地区） 代码 ：</b>标识电话号码的国家（地区）的标准国家（地区）代码。它包含从 0 到 9 的一位或多位数字，
	 *  数字之后是空格分隔的国家（地区）代码。</p>
	 * <p><b>区号（城市代码）：</b>这可能包含一个或多个从 0 到 9 的数字，地区或城市代码放在圆括号——
	 * 对不使用地区或城市代码的国家（地区），则省略该组件。</p>
	 * <p><b>电话号码：</b>这包含从 0 到 9 的一个或多个数字 </p>
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkPhone(String phone) {
		String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";
		return Pattern.matches(regex, phone);
	}

	/**
	 * 验证整数（正整数和负整数）
	 * @param digit 一位或多位0-9之间的整数
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkDigit(String digit) {
		String regex = "\\-?[1-9]\\d+";
		return Pattern.matches(regex,digit);
	}

	/**
	 * 验证整数和浮点数（正负整数和正负浮点数）
	 * @param decimals 一位或多位0-9之间的浮点数，如：1.23，233.30
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkDecimals(String decimals) {
		String regex = "\\-?[1-9]\\d+(\\.\\d+)?";
		return Pattern.matches(regex,decimals);
	}

	/**
	 * 验证空白字符
	 * @param blankSpace 空白字符，包括：空格、\t、\n、\r、\f、\x0B
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkBlankSpace(String blankSpace) {
		String regex = "\\s+";
		return Pattern.matches(regex,blankSpace);
	}

	/**
	 * 验证中文
	 * @param chinese 中文字符
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkChinese(String chinese) {
		String regex = "^[\u4E00-\u9FA5]+$";
		return Pattern.matches(regex,chinese);
	}

	/**
	 * 验证日期（年月日）
	 * @param birthday 日期，格式：1992-09-03，或1992.09.03
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkBirthday(String birthday) {
		String regex = "[1-9]{4}([-./])\\d{1,2}\\1\\d{1,2}";
		return Pattern.matches(regex,birthday);
	}

	/**
	 * 验证URL地址
	 * @param url 格式：http://blog.csdn.net:80/xyang81/article/details/7705960? 或 http://www.csdn.net:80
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkURL(String url) {
		String regex = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";
		return Pattern.matches(regex, url);
	}

	/**
	 * <pre>
	 * 获取网址 URL 的一级域名
	 * http://detail.tmall.com/item.htm?spm=a230r.1.10.44.1xpDSH&id=15453106243&_u=f4ve1uq1092 ->> tmall.com
	 * </pre>
	 *
	 * @param url
	 * @return
	 */
	public static String getDomain(String url) {
		Pattern p = Pattern.compile("(?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);
		// 获取完整的域名
		// Pattern p=Pattern.compile("[^//]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = p.matcher(url);
		matcher.find();
		return matcher.group();
	}
	/**
	 * 匹配中国邮政编码
	 * @param postcode 邮政编码
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkPostcode(String postcode) {
		String regex = "[1-9]\\d{5}";
		return Pattern.matches(regex, postcode);
	}

	/**
	 * 匹配IP地址(简单匹配，格式，如：192.168.1.1，127.0.0.1，没有匹配IP段的大小)
	 * @param ipAddress IPv4标准地址
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkIpAddress(String ipAddress) {
		String regex = "[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))";
		return Pattern.matches(regex, ipAddress);
	}

}
