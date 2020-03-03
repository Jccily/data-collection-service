/**
 * Copyright (C),2007-2016, LonBon Technologies Co. Ltd. All Rights Reserved.
 */
/**
 * @Author: hst
 * @Description: 字符串工具类
 * @Date: 2017/11/21
 * @Modified: begin by hst
 * ----@Date: 19:45 2018/1/9
 * ----@Description: 添加isInteger方法
 * @Modified: end
 */
package com.lonbon.datacollectionservice.utils;

import com.alibaba.fastjson.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hst on 2017/11/21.
 * 类描述: 字符串工具类
 */
public class StringUtil {
    private static Logger logger = LoggerFactory.getLogger(StringUtil.class);
    private static Pattern NUMBER_PATTERN = Pattern.compile("^[+]?[0-9]+$");
    private static Pattern IS_DIGIT_PATTERN = Pattern.compile("^[-\\+]?[\\d]*$");
    private static Pattern IP_PATTERN = Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}");
    private static Pattern IS_MOBILE_NUM_PATTERN = Pattern.compile("(^(\\d{3,4}-)?\\d{7,8})$|(1[0-9]{10})");

    //校验字符串
    public static boolean checkStr(String str) {
        return !("".equals(str) || null == str);
    }

    public static boolean equalsString(String argStr1, String argStr2) {
        return (argStr1 == null) && (argStr2 == null) || !((argStr1 == null) || (argStr2 == null)) && argStr1.equals(argStr2);
    }

    /**
     * 判断是否为合法IP
     * @param ipAddress
     * @return the ip
     */
    public static boolean isboolIp(String ipAddress) {
        return IP_PATTERN.matcher(ipAddress).matches();
    }

    /***
     * 判断 String 是否是 int
     *
     * @param input
     * @return
     */
    public static boolean isInteger(String input){
        return NUMBER_PATTERN.matcher(input).find();
    }

    /**
     * Is digit boolean.
     *
     * @param str the str
     * @return the boolean
     */
    public static boolean isDigit(String str) {
        return null != str && IS_DIGIT_PATTERN.matcher(str).matches();
    }

    /**
     * 字符串是否为数字，包含小数
     * @param str
     * @return
     */
    public static boolean isNumber(String str){
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }

    /**
     * 验证手机号码
     */
    public static boolean isMobileNO(String mobiles) {
        return !(null == mobiles || "".equals(mobiles)) && IS_MOBILE_NUM_PATTERN.matcher(mobiles).matches();
    }

    /**
     * 验证时间格式
     */
    public static boolean checkDate(String date){
        Pattern p = Pattern.compile("^\\d{4}[-]([0][1-9]|(1[0-2]))[-]([1-9]|([012]\\d)|(3[01]))" +
                "([ \\t\\n\\x0B\\f\\r])(([0-1]{1}[0-9]{1})|([2]{1}[0-4]{1}))([:])" +
                "(([0-5]{1}[0-9]{1}|[6]{1}[0]{1}))([:])((([0-5]{1}[0-9]{1}|[6]{1}[0]{1})))$");
        Matcher m = p.matcher(date);
        return m.matches();
    }

    /**
     * 验证是否为邮箱格式
     * @param string
     * @return
     */
    public static boolean isEmail(String string) {
        if(null==string||"".equals(string)){
            return false;
        }
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(string);
        return m.matches();
    }


    /**
     * string日期转时间戳
     */

    public static Long stringToTimeStamp(String date_str){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(date_str).getTime()/1000;
        } catch (Exception e) {
            return null;
        }
    }

    public static Long birthdayToTimeStamp(String dateStr){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateStr).getTime()/1000;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(birthdayToTimeStamp("1978-01-01"));
    }


    public static<T> List<T> jsonToList(String jsonString, Class<T> clazz){
        List<T> list = JSONArray.parseArray(jsonString, clazz);
        return null == list || list.size() == 0 ? null : list;
    }

    /**
     * <pre>
     * 省、直辖市代码表：
     *     11 : 北京  12 : 天津  13 : 河北       14 : 山西  15 : 内蒙古
     *     21 : 辽宁  22 : 吉林  23 : 黑龙江  31 : 上海  32 : 江苏
     *     33 : 浙江  34 : 安徽  35 : 福建       36 : 江西  37 : 山东
     *     41 : 河南  42 : 湖北  43 : 湖南       44 : 广东  45 : 广西      46 : 海南
     *     50 : 重庆  51 : 四川  52 : 贵州       53 : 云南  54 : 西藏
     *     61 : 陕西  62 : 甘肃  63 : 青海       64 : 宁夏  65 : 新疆
     *     71 : 台湾
     *     81 : 香港  82 : 澳门
     *     91 : 国外
     * </pre>
     */
    private static String cityCode[] = { "11", "12", "13", "14", "15", "21",
            "22", "23", "31", "32", "33", "34", "35", "36", "37", "41", "42",
            "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62",
            "63", "64", "65", "71", "81", "82", "91" };

    /**
     * 每位加权因子
     */
    private static int power[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5,
            8, 4, 2 };

    /**
     * 验证所有的身份证的合法性
     *
     * @param idcard
     *            身份证
     * @return 合法返回true，否则返回false
     */
    public static boolean isValidatedAllIdcard(String idcard) {
        if (idcard == null || "".equals(idcard)) {
            return false;
        }
        if (idcard.length() == 15) {
            return validate15IDCard(idcard);
        }
        return validate18Idcard(idcard);
    }

    /**
     * <p>
     * 判断18位身份证的合法性
     * </p>
     * 根据〖中华人民共和国国家标准GB11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。
     * 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
     * <p>
     * 顺序码: 表示在同一地址码所标识的区域范围内，对同年、同月、同 日出生的人编定的顺序号，顺序码的奇数分配给男性，偶数分配 给女性。
     * </p>
     * <p>
     * 1.前1、2位数字表示：所在省份的代码； 2.第3、4位数字表示：所在城市的代码； 3.第5、6位数字表示：所在区县的代码；
     * 4.第7~14位数字表示：出生年、月、日； 5.第15、16位数字表示：所在地的派出所的代码；
     * 6.第17位数字表示性别：奇数表示男性，偶数表示女性；
     * 7.第18位数字是校检码：也有的说是个人信息码，一般是随计算机的随机产生，用来检验身份证的正确性。校检码可以是0~9的数字，有时也用x表示。
     * </p>
     * <p>
     * 第十八位数字(校验码)的计算方法为： 1.将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4
     * 2 1 6 3 7 9 10 5 8 4 2
     * </p>
     * <p>
     * 2.将这17位数字和系数相乘的结果相加。
     * </p>
     * <p>
     * 3.用加出来和除以11，看余数是多少
     * </p>
     * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3
     * 2。
     * <p>
     * 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。
     * </p>
     *
     * @param idcard
     * @return
     */
    public static boolean validate18Idcard(String idcard) {
        if (idcard == null) {
            return false;
        }

        // 非18位为假
        if (idcard.length() != 18) {
            return false;
        }
        // 获取前17位
        String idcard17 = idcard.substring(0, 17);

        // 前17位全部为数字
        if (!isDigital(idcard17)) {
            return false;
        }

        String provinceid = idcard.substring(0, 2);
        // 校验省份
        if (!checkProvinceid(provinceid)) {
            return false;
        }

        // 校验出生日期
        String birthday = idcard.substring(6, 14);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        try {
            Date birthDate = sdf.parse(birthday);
            String tmpDate = sdf.format(birthDate);
            if (!tmpDate.equals(birthday)) {// 出生年月日不正确
                return false;
            }

        } catch (ParseException e1) {

            return false;
        }

        // 获取第18位
        String idcard18Code = idcard.substring(17, 18);

        char c[] = idcard17.toCharArray();

        int bit[] = converCharToInt(c);

        int sum17 = 0;

        sum17 = getPowerSum(bit);

        // 将和值与11取模得到余数进行校验码判断
        String checkCode = getCheckCodeBySum(sum17);
        if (null == checkCode) {
            return false;
        }
        // 将身份证的第18位与算出来的校码进行匹配，不相等就为假
        if (!idcard18Code.equalsIgnoreCase(checkCode)) {
            return false;
        }

        return true;
    }

    /**
     * 校验15位身份证
     *
     * <pre>
     * 只校验省份和出生年月日
     * </pre>
     *
     * @param idcard
     * @return
     */
    public static boolean validate15IDCard(String idcard) {
        if (idcard == null) {
            return false;
        }
        // 非15位为假
        if (idcard.length() != 15) {
            return false;
        }

        // 15全部为数字
        if (!isDigital(idcard)) {
            return false;
        }

        String provinceid = idcard.substring(0, 2);
        // 校验省份
        if (!checkProvinceid(provinceid)) {
            return false;
        }

        String birthday = idcard.substring(6, 12);

        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");

        try {
            Date birthDate = sdf.parse(birthday);
            String tmpDate = sdf.format(birthDate);
            if (!tmpDate.equals(birthday)) {// 身份证日期错误
                return false;
            }

        } catch (ParseException e1) {

            return false;
        }

        return true;
    }

    /**
     * 将15位的身份证转成18位身份证
     *
     * @param idcard
     * @return
     */
//    public static String convertIdcarBy15bit(String idcard) {
//        if (idcard == null) {
//            return null;
//        }
//
//        // 非15位身份证
//        if (idcard.length() != 15) {
//            return null;
//        }
//
//        // 15全部为数字
//        if (!isDigital(idcard)) {
//            return null;
//        }
//
//        String provinceid = idcard.substring(0, 2);
//        // 校验省份
//        if (!checkProvinceid(provinceid)) {
//            return null;
//        }
//
//        String birthday = idcard.substring(6, 12);
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
//
//        Date birthdate = null;
//        try {
//            birthdate = sdf.parse(birthday);
//            String tmpDate = sdf.format(birthdate);
//            if (!tmpDate.equals(birthday)) {// 身份证日期错误
//                return null;
//            }
//
//        } catch (ParseException e1) {
//            return null;
//        }
//
//        Calendar cday = Calendar.getInstance();
//        cday.setTime(birthdate);
//        String year = String.valueOf(cday.get(Calendar.YEAR));
//
//        String idcard17 = idcard.substring(0, 6) + year + idcard.substring(8);
//
//        char c[] = idcard17.toCharArray();
//        String checkCode = "";
//
//        // 将字符数组转为整型数组
//        int bit[] = converCharToInt(c);
//
//        int sum17 = 0;
//        sum17 = getPowerSum(bit);
//
//        // 获取和值与11取模得到余数进行校验码
//        checkCode = getCheckCodeBySum(sum17);
//
//        // 获取不到校验位
//        if (null == checkCode) {
//            return null;
//        }
//        // 将前17位与第18位校验码拼接
//        idcard17 += checkCode;
//        return idcard17;
//    }

    /**
     * 校验省份
     *
     * @param provinceid
     * @return 合法返回TRUE，否则返回FALSE
     */
    private static boolean checkProvinceid(String provinceid) {
        for (String id : cityCode) {
            if (id.equals(provinceid)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 数字验证
     *
     * @param str
     * @return
     */
    private static boolean isDigital(String str) {
        return str.matches("^[0-9]*$");
    }

    /**
     * 将身份证的每位和对应位的加权因子相乘之后，再得到和值
     * @param bit
     * @return
     */
    private static int getPowerSum(int[] bit) {

        int sum = 0;

        if (power.length != bit.length) {
            return sum;
        }

        for (int i = 0; i < bit.length; i++) {
            for (int j = 0; j < power.length; j++) {
                if (i == j) {
                    sum = sum + bit[i] * power[j];
                }
            }
        }
        return sum;
    }

    /**
     * 将和值与11取模得到余数进行校验码判断
     * @param sum17
     * @return 校验位
     */
    private static String getCheckCodeBySum(int sum17) {
        String checkCode = null;
        switch (sum17 % 11) {
            case 10:
                checkCode = "2";
                break;
            case 9:
                checkCode = "3";
                break;
            case 8:
                checkCode = "4";
                break;
            case 7:
                checkCode = "5";
                break;
            case 6:
                checkCode = "6";
                break;
            case 5:
                checkCode = "7";
                break;
            case 4:
                checkCode = "8";
                break;
            case 3:
                checkCode = "9";
                break;
            case 2:
                checkCode = "x";
                break;
            case 1:
                checkCode = "0";
                break;
            case 0:
                checkCode = "1";
                break;
            default:
        }
        return checkCode;
    }

    /**
     * 将字符数组转为整型数组
     *
     * @param c
     * @return
     * @throws NumberFormatException
     */
    private static int[] converCharToInt(char[] c) throws NumberFormatException {
        int[] a = new int[c.length];
        int k = 0;
        for (char temp : c) {
            a[k++] = Integer.parseInt(String.valueOf(temp));
        }
        return a;
    }

    public static Boolean checkPass(String str){
        Integer count = 0;
        //是否有字母
        if(str.matches("^.*[a-zA-Z]+.*$")){
            count++;
        }
        //是否有数字
        if(str.matches("^.*[0-9]+.*$")){
            count++;
        }
        //是否有特殊字符
        if(str.matches("^.*[/^/$/.//,;:'!@#%&/*/|/?/+/(/)/[/]/{/}]+.*$")){
            count++;
        }
        return count>=2;
    }

    /**
     * 判断字符是否包含特殊字符
     */
    public static boolean isContainSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * Get uuid string.
     *
     * @return the string
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-","");
    }

    /**
     * 获取16进制随机数
     * @param len
     * @return
     */
    public static String randomHexString(int len)  {
        try {
            StringBuffer result = new StringBuffer();
            for(int i=0;i<len;i++) {
                result.append(Integer.toHexString(new Random().nextInt(16)));
            }
            return result.toString().toUpperCase();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }
    /**
     * 加密
     * @param str
     * @return
     */
    public static String EncoderByMd5(String str) {
        /* 确定算法 */
        try {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            return base64en.encode(md5.digest(str.getBytes("utf-8")));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     * @Description 将截止时间的分秒修改为59分59秒
     * @param endTime 截止时间转换成的秒数
     * @Return java.math.BigInteger
     * @Create 2019/11/25
     */
    public static BigInteger getEndTime(BigInteger endTime){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        date.setTime(endTime.longValue()*1000);
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        date = calendar.getTime();
        Long time = date.getTime()/1000;
        return  new BigInteger(time.toString());
    }

}
