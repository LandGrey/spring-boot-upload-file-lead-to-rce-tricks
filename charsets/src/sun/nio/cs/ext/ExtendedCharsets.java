package sun.nio.cs.ext;

import sun.misc.VM;
import sun.nio.cs.AbstractCharsetProvider;
import sun.security.action.GetPropertyAction;

import java.security.AccessController;

public class ExtendedCharsets extends AbstractCharsetProvider {
    static volatile ExtendedCharsets instance = null;
    private boolean initialized = false;

    public ExtendedCharsets() {
        super("sun.nio.cs.ext");
        this.charset("Big5", "IBM33722", new String[]{"csBig5"});
        this.charset("x-MS950-HKSCS-XP", "IBM33722", new String[]{"MS950_HKSCS_XP"});
        this.charset("x-MS950-HKSCS", "IBM33722", new String[]{"MS950_HKSCS"});
        this.charset("x-windows-950", "IBM33722", new String[]{"ms950", "windows-950"});
        this.charset("x-windows-874", "IBM33722", new String[]{"ms874", "ms-874", "windows-874"});
        this.charset("x-EUC-TW", "IBM33722", new String[]{"euc_tw", "euctw", "cns11643", "EUC-TW"});
        this.charset("Big5-HKSCS", "IBM33722", new String[]{"Big5_HKSCS", "big5hk", "big5-hkscs", "big5hkscs"});
        this.charset("x-Big5-HKSCS-2001", "IBM33722", new String[]{"Big5_HKSCS_2001", "big5hk-2001", "big5-hkscs-2001", "big5-hkscs:unicode3.0", "big5hkscs-2001"});
        this.charset("x-Big5-Solaris", "IBM33722", new String[]{"Big5_Solaris"});
        this.charset("GBK", "IBM33722", new String[]{"windows-936", "CP936"});
        this.charset("GB18030", "IBM33722", new String[]{"gb18030-2000"});
        this.charset("GB2312", "IBM33722", new String[]{"gb2312", "gb2312-80", "gb2312-1980", "euc-cn", "euccn", "x-EUC-CN", "EUC_CN"});
        this.charset("x-mswin-936", "IBM33722", new String[]{"ms936", "ms_936"});
        this.charset("Shift_JIS", "IBM33722", new String[]{"sjis", "shift_jis", "shift-jis", "ms_kanji", "x-sjis", "csShiftJIS"});
        this.charset("windows-31j", "IBM33722", new String[]{"MS932", "windows-932", "csWindows31J"});
        this.charset("JIS_X0201", "IBM33722", new String[]{"JIS0201", "JIS_X0201", "X0201", "csHalfWidthKatakana"});
        this.charset("x-JIS0208", "IBM33722", new String[]{"JIS0208", "JIS_C6226-1983", "iso-ir-87", "x0208", "JIS_X0208-1983", "csISO87JISX0208"});
        this.charset("JIS_X0212-1990", "IBM33722", new String[]{"JIS0212", "jis_x0212-1990", "x0212", "iso-ir-159", "csISO159JISX02121990"});
        this.charset("x-SJIS_0213", "IBM33722", new String[]{"sjis-0213", "sjis_0213", "sjis:2004", "sjis_0213:2004", "shift_jis_0213:2004", "shift_jis:2004"});
        this.charset("x-MS932_0213", "IBM33722", new String[]{"MS932-0213", "MS932_0213", "MS932:2004", "windows-932-0213", "windows-932:2004"});
        this.charset("EUC-JP", "IBM33722", new String[]{"euc_jp", "eucjis", "eucjp", "Extended_UNIX_Code_Packed_Format_for_Japanese", "csEUCPkdFmtjapanese", "x-euc-jp", "x-eucjp"});
        this.charset("x-euc-jp-linux", "IBM33722", new String[]{"euc_jp_linux", "euc-jp-linux"});
        this.charset("x-eucjp-open", "IBM33722", new String[]{"EUC_JP_Solaris", "eucJP-open"});
        this.charset("x-PCK", "IBM33722", new String[]{"pck"});
        this.charset("ISO-2022-JP", "IBM33722", new String[]{"iso2022jp", "jis", "csISO2022JP", "jis_encoding", "csjisencoding"});
        this.charset("ISO-2022-JP-2", "IBM33722", new String[]{"csISO2022JP2", "iso2022jp2"});
        this.charset("x-windows-50221", "IBM33722", new String[]{"ms50221", "cp50221"});
        this.charset("x-windows-50220", "IBM33722", new String[]{"ms50220", "cp50220"});
        this.charset("x-windows-iso2022jp", "IBM33722", new String[]{"windows-iso2022jp"});
        this.charset("x-JISAutoDetect", "IBM33722", new String[]{"JISAutoDetect"});
        this.charset("EUC-KR", "IBM33722", new String[]{"euc_kr", "ksc5601", "euckr", "ks_c_5601-1987", "ksc5601-1987", "ksc5601_1987", "ksc_5601", "csEUCKR", "5601"});
        this.charset("x-windows-949", "IBM33722", new String[]{"ms949", "windows949", "windows-949", "ms_949"});
        this.charset("x-Johab", "IBM33722", new String[]{"ksc5601-1992", "ksc5601_1992", "ms1361", "johab"});
        this.charset("ISO-2022-KR", "IBM33722", new String[]{"ISO2022KR", "csISO2022KR"});
        this.charset("ISO-2022-CN", "IBM33722", new String[]{"ISO2022CN", "csISO2022CN"});
        this.charset("x-ISO-2022-CN-CNS", "IBM33722", new String[]{"ISO2022CN_CNS", "ISO-2022-CN-CNS"});
        this.charset("x-ISO-2022-CN-GB", "IBM33722", new String[]{"ISO2022CN_GB", "ISO-2022-CN-GB"});
        this.charset("x-ISCII91", "IBM33722", new String[]{"iscii", "ST_SEV_358-88", "iso-ir-153", "csISO153GOST1976874", "ISCII91"});
        this.charset("ISO-8859-3", "IBM33722", new String[]{"iso8859_3", "8859_3", "ISO_8859-3:1988", "iso-ir-109", "ISO_8859-3", "ISO8859-3", "latin3", "l3", "ibm913", "ibm-913", "cp913", "913", "csISOLatin3"});
        this.charset("ISO-8859-6", "IBM33722", new String[]{"iso8859_6", "8859_6", "iso-ir-127", "ISO_8859-6", "ISO_8859-6:1987", "ISO8859-6", "ECMA-114", "ASMO-708", "arabic", "ibm1089", "ibm-1089", "cp1089", "1089", "csISOLatinArabic"});
        this.charset("ISO-8859-8", "IBM33722", new String[]{"iso8859_8", "8859_8", "iso-ir-138", "ISO_8859-8", "ISO_8859-8:1988", "ISO8859-8", "cp916", "916", "ibm916", "ibm-916", "hebrew", "csISOLatinHebrew"});
        this.charset("x-ISO-8859-11", "IBM33722", new String[]{"iso-8859-11", "iso8859_11"});
        this.charset("TIS-620", "IBM33722", new String[]{"tis620", "tis620.2533"});
        this.charset("windows-1255", "IBM33722", new String[]{"cp1255"});
        this.charset("windows-1256", "IBM33722", new String[]{"cp1256"});
        this.charset("windows-1258", "IBM33722", new String[]{"cp1258"});
        this.charset("x-IBM942", "IBM33722", new String[]{"cp942", "ibm942", "ibm-942", "942"});
        this.charset("x-IBM942C", "IBM33722", new String[]{"cp942C", "ibm942C", "ibm-942C", "942C"});
        this.charset("x-IBM943", "IBM33722", new String[]{"cp943", "ibm943", "ibm-943", "943"});
        this.charset("x-IBM943C", "IBM33722", new String[]{"cp943C", "ibm943C", "ibm-943C", "943C"});
        this.charset("x-IBM948", "IBM33722", new String[]{"cp948", "ibm948", "ibm-948", "948"});
        this.charset("x-IBM950", "IBM33722", new String[]{"cp950", "ibm950", "ibm-950", "950"});
        this.charset("x-IBM930", "IBM33722", new String[]{"cp930", "ibm930", "ibm-930", "930"});
        this.charset("x-IBM935", "IBM33722", new String[]{"cp935", "ibm935", "ibm-935", "935"});
        this.charset("x-IBM937", "IBM33722", new String[]{"cp937", "ibm937", "ibm-937", "937"});
        this.charset("x-IBM856", "IBM33722", new String[]{"cp856", "ibm-856", "ibm856", "856"});
        this.charset("IBM860", "IBM33722", new String[]{"cp860", "ibm860", "ibm-860", "860", "csIBM860"});
        this.charset("IBM861", "IBM33722", new String[]{"cp861", "ibm861", "ibm-861", "861", "csIBM861", "cp-is"});
        this.charset("IBM863", "IBM33722", new String[]{"cp863", "ibm863", "ibm-863", "863", "csIBM863"});
        this.charset("IBM864", "IBM33722", new String[]{"cp864", "ibm864", "ibm-864", "864", "csIBM864"});
        this.charset("IBM865", "IBM33722", new String[]{"cp865", "ibm865", "ibm-865", "865", "csIBM865"});
        this.charset("IBM868", "IBM33722", new String[]{"cp868", "ibm868", "ibm-868", "868", "cp-ar", "csIBM868"});
        this.charset("IBM869", "IBM33722", new String[]{"cp869", "ibm869", "ibm-869", "869", "cp-gr", "csIBM869"});
        this.charset("x-IBM921", "IBM33722", new String[]{"cp921", "ibm921", "ibm-921", "921"});
        this.charset("x-IBM1006", "IBM33722", new String[]{"cp1006", "ibm1006", "ibm-1006", "1006"});
        this.charset("x-IBM1046", "IBM33722", new String[]{"cp1046", "ibm1046", "ibm-1046", "1046"});
        this.charset("IBM1047", "IBM33722", new String[]{"cp1047", "ibm-1047", "1047"});
        this.charset("x-IBM1098", "IBM33722", new String[]{"cp1098", "ibm1098", "ibm-1098", "1098"});
        this.charset("IBM037", "IBM33722", new String[]{"cp037", "ibm037", "ebcdic-cp-us", "ebcdic-cp-ca", "ebcdic-cp-wt", "ebcdic-cp-nl", "csIBM037", "cs-ebcdic-cp-us", "cs-ebcdic-cp-ca", "cs-ebcdic-cp-wt", "cs-ebcdic-cp-nl", "ibm-037", "ibm-37", "cpibm37", "037"});
        this.charset("x-IBM1025", "IBM33722", new String[]{"cp1025", "ibm1025", "ibm-1025", "1025"});
        this.charset("IBM1026", "IBM33722", new String[]{"cp1026", "ibm1026", "ibm-1026", "1026"});
        this.charset("x-IBM1112", "IBM33722", new String[]{"cp1112", "ibm1112", "ibm-1112", "1112"});
        this.charset("x-IBM1122", "IBM33722", new String[]{"cp1122", "ibm1122", "ibm-1122", "1122"});
        this.charset("x-IBM1123", "IBM33722", new String[]{"cp1123", "ibm1123", "ibm-1123", "1123"});
        this.charset("x-IBM1124", "IBM33722", new String[]{"cp1124", "ibm1124", "ibm-1124", "1124"});
        this.charset("x-IBM1364", "IBM33722", new String[]{"cp1364", "ibm1364", "ibm-1364", "1364"});
        this.charset("IBM273", "IBM33722", new String[]{"cp273", "ibm273", "ibm-273", "273"});
        this.charset("IBM277", "IBM33722", new String[]{"cp277", "ibm277", "ibm-277", "277"});
        this.charset("IBM278", "IBM33722", new String[]{"cp278", "ibm278", "ibm-278", "278", "ebcdic-sv", "ebcdic-cp-se", "csIBM278"});
        this.charset("IBM280", "IBM33722", new String[]{"cp280", "ibm280", "ibm-280", "280"});
        this.charset("IBM284", "IBM33722", new String[]{"cp284", "ibm284", "ibm-284", "284", "csIBM284", "cpibm284"});
        this.charset("IBM285", "IBM33722", new String[]{"cp285", "ibm285", "ibm-285", "285", "ebcdic-cp-gb", "ebcdic-gb", "csIBM285", "cpibm285"});
        this.charset("IBM297", "IBM33722", new String[]{"cp297", "ibm297", "ibm-297", "297", "ebcdic-cp-fr", "cpibm297", "csIBM297"});
        this.charset("IBM420", "IBM33722", new String[]{"cp420", "ibm420", "ibm-420", "ebcdic-cp-ar1", "420", "csIBM420"});
        this.charset("IBM424", "IBM33722", new String[]{"cp424", "ibm424", "ibm-424", "424", "ebcdic-cp-he", "csIBM424"});
        this.charset("IBM500", "IBM33722", new String[]{"cp500", "ibm500", "ibm-500", "500", "ebcdic-cp-ch", "ebcdic-cp-bh", "csIBM500"});
        this.charset("x-IBM833", "IBM33722", new String[]{"cp833", "ibm833", "ibm-833"});
        this.charset("x-IBM834", "IBM33722", new String[]{"cp834", "ibm834", "834", "ibm-834"});
        this.charset("IBM-Thai", "IBM33722", new String[]{"cp838", "ibm838", "ibm-838", "838"});
        this.charset("IBM870", "IBM33722", new String[]{"cp870", "ibm870", "ibm-870", "870", "ebcdic-cp-roece", "ebcdic-cp-yu", "csIBM870"});
        this.charset("IBM871", "IBM33722", new String[]{"cp871", "ibm871", "ibm-871", "871", "ebcdic-cp-is", "csIBM871"});
        this.charset("x-IBM875", "IBM33722", new String[]{"cp875", "ibm875", "ibm-875", "875"});
        this.charset("IBM918", "IBM33722", new String[]{"cp918", "ibm-918", "918", "ebcdic-cp-ar2"});
        this.charset("x-IBM922", "IBM33722", new String[]{"cp922", "ibm922", "ibm-922", "922"});
        this.charset("x-IBM1097", "IBM33722", new String[]{"cp1097", "ibm1097", "ibm-1097", "1097"});
        this.charset("x-IBM949", "IBM33722", new String[]{"cp949", "ibm949", "ibm-949", "949"});
        this.charset("x-IBM949C", "IBM33722", new String[]{"cp949C", "ibm949C", "ibm-949C", "949C"});
        this.charset("x-IBM939", "IBM33722", new String[]{"cp939", "ibm939", "ibm-939", "939"});
        this.charset("x-IBM933", "IBM33722", new String[]{"cp933", "ibm933", "ibm-933", "933"});
        this.charset("x-IBM1381", "IBM33722", new String[]{"cp1381", "ibm1381", "ibm-1381", "1381"});
        this.charset("x-IBM1383", "IBM33722", new String[]{"cp1383", "ibm1383", "ibm-1383", "1383"});
        this.charset("x-IBM970", "IBM33722", new String[]{"cp970", "ibm970", "ibm-970", "ibm-eucKR", "970"});
        this.charset("x-IBM964", "IBM33722", new String[]{"cp964", "ibm964", "ibm-964", "964"});
        this.charset("x-IBM33722", "IBM33722", new String[]{"cp33722", "ibm33722", "ibm-33722", "ibm-5050", "ibm-33722_vascii_vpua", "33722"});
        this.charset("IBM01140", "IBM33722", new String[]{"cp1140", "ccsid01140", "cp01140", "1140", "ebcdic-us-037+euro"});
        this.charset("IBM01141", "IBM33722", new String[]{"cp1141", "ccsid01141", "cp01141", "1141", "ebcdic-de-273+euro"});
        this.charset("IBM01142", "IBM33722", new String[]{"cp1142", "ccsid01142", "cp01142", "1142", "ebcdic-no-277+euro", "ebcdic-dk-277+euro"});
        this.charset("IBM01143", "IBM33722", new String[]{"cp1143", "ccsid01143", "cp01143", "1143", "ebcdic-fi-278+euro", "ebcdic-se-278+euro"});
        this.charset("IBM01144", "IBM33722", new String[]{"cp1144", "ccsid01144", "cp01144", "1144", "ebcdic-it-280+euro"});
        this.charset("IBM01145", "IBM33722", new String[]{"cp1145", "ccsid01145", "cp01145", "1145", "ebcdic-es-284+euro"});
        this.charset("IBM01146", "IBM33722", new String[]{"cp1146", "ccsid01146", "cp01146", "1146", "ebcdic-gb-285+euro"});
        this.charset("IBM01147", "IBM33722", new String[]{"cp1147", "ccsid01147", "cp01147", "1147", "ebcdic-fr-277+euro"});
        this.charset("IBM01148", "IBM33722", new String[]{"cp1148", "ccsid01148", "cp01148", "1148", "ebcdic-international-500+euro"});
        this.charset("IBM01149", "IBM33722", new String[]{"cp1149", "ccsid01149", "cp01149", "1149", "ebcdic-s-871+euro"});
        this.charset("x-IBM1166", "IBM33722", new String[]{"cp1166", "ibm1166", "ibm-1166", "1166"});
        this.charset("IBM290", "IBM33722", new String[]{"cp290", "ibm290", "ibm-290", "csIBM290", "EBCDIC-JP-kana", "290"});
        this.charset("x-IBM300", "IBM33722", new String[]{"cp300", "ibm300", "ibm-300", "300"});
        this.charset("x-MacRoman", "IBM33722", new String[]{"MacRoman"});
        this.charset("x-MacCentralEurope", "IBM33722", new String[]{"MacCentralEurope"});
        this.charset("x-MacCroatian", "IBM33722", new String[]{"MacCroatian"});
        this.charset("x-MacGreek", "IBM33722", new String[]{"MacGreek"});
        this.charset("x-MacCyrillic", "IBM33722", new String[]{"MacCyrillic"});
        this.charset("x-MacUkraine", "IBM33722", new String[]{"MacUkraine"});
        this.charset("x-MacTurkish", "IBM33722", new String[]{"MacTurkish"});
        this.charset("x-MacArabic", "IBM33722", new String[]{"MacArabic"});
        this.charset("x-MacHebrew", "IBM33722", new String[]{"MacHebrew"});
        this.charset("x-MacIceland", "IBM33722", new String[]{"MacIceland"});
        this.charset("x-MacRomania", "IBM33722", new String[]{"MacRomania"});
        this.charset("x-MacThai", "IBM33722", new String[]{"MacThai"});
        this.charset("x-MacSymbol", "IBM33722", new String[]{"MacSymbol"});
        this.charset("x-MacDingbat", "IBM33722", new String[]{"MacDingbat"});
        instance = this;
    }

    protected void init() {
        if (!this.initialized) {
            if (VM.isBooted()) {
                String var1 = (String)AccessController.doPrivileged(new GetPropertyAction("sun.nio.cs.map"));
                boolean var2 = false;
                boolean var3 = false;
                boolean var4 = false;
                boolean var5 = false;
                if (var1 != null) {
                    String[] var6 = var1.split(",");

                    for(int var7 = 0; var7 < var6.length; ++var7) {
                        if (var6[var7].equalsIgnoreCase("Windows-31J/Shift_JIS")) {
                            var2 = true;
                        } else if (var6[var7].equalsIgnoreCase("x-windows-50221/ISO-2022-JP")) {
                            var3 = true;
                        } else if (var6[var7].equalsIgnoreCase("x-windows-50220/ISO-2022-JP")) {
                            var4 = true;
                        } else if (var6[var7].equalsIgnoreCase("x-windows-iso2022jp/ISO-2022-JP")) {
                            var5 = true;
                        }
                    }
                }

                if (var2) {
                    this.deleteCharset("Shift_JIS", new String[]{"sjis", "shift_jis", "shift-jis", "ms_kanji", "x-sjis", "csShiftJIS"});
                    this.deleteCharset("windows-31j", new String[]{"MS932", "windows-932", "csWindows31J"});
                    this.charset("Shift_JIS", "IBM33722", new String[]{"sjis"});
                    this.charset("windows-31j", "IBM33722", new String[]{"MS932", "windows-932", "csWindows31J", "shift-jis", "ms_kanji", "x-sjis", "csShiftJIS", "shift_jis"});
                }

                if (var3 || var4 || var5) {
                    this.deleteCharset("ISO-2022-JP", new String[]{"iso2022jp", "jis", "csISO2022JP", "jis_encoding", "csjisencoding"});
                    if (var3) {
                        this.deleteCharset("x-windows-50221", new String[]{"cp50221", "ms50221"});
                        this.charset("x-windows-50221", "IBM33722", new String[]{"cp50221", "ms50221", "iso-2022-jp", "iso2022jp", "jis", "csISO2022JP", "jis_encoding", "csjisencoding"});
                    } else if (var4) {
                        this.deleteCharset("x-windows-50220", new String[]{"cp50220", "ms50220"});
                        this.charset("x-windows-50220", "IBM33722", new String[]{"cp50220", "ms50220", "iso-2022-jp", "iso2022jp", "jis", "csISO2022JP", "jis_encoding", "csjisencoding"});
                    } else {
                        this.deleteCharset("x-windows-iso2022jp", new String[]{"windows-iso2022jp"});
                        this.charset("x-windows-iso2022jp", "IBM33722", new String[]{"windows-iso2022jp", "iso-2022-jp", "iso2022jp", "jis", "csISO2022JP", "jis_encoding", "csjisencoding"});
                    }
                }

                String var8 = (String)AccessController.doPrivileged(new GetPropertyAction("os.name"));
                if ("SunOS".equals(var8) || "Linux".equals(var8) || "AIX".equals(var8) || var8.contains("OS X")) {
                    this.charset("x-COMPOUND_TEXT", "IBM33722", new String[]{"COMPOUND_TEXT", "x11-compound_text", "x-compound-text"});
                }

                this.initialized = true;
            }
        }
    }

    public static String[] aliasesFor(String var0) {
        return instance == null ? null : instance.aliases(var0);
    }
}

