package com.ky.core.util;
/**
 * 使用ESUnCase 解析URL编码
 * @author rm
 *
 */
public class EscapeUtils {

    public static String escape(String src) {
        int i;
        char j;
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length() * 6);
        for (i = 0; i < src.length(); i++) {
            j = src.charAt(i);
            if (Character.isDigit(j) || Character.isLowerCase(j)
                    || Character.isUpperCase(j))
                tmp.append(j);
            else if (j < 256) {
                tmp.append("%");
                if (j < 16)
                    tmp.append("0");
                tmp.append(Integer.toString(j, 16));
            } else {
                tmp.append("%u");
                tmp.append(Integer.toString(j, 16));
            }
        }
        return tmp.toString();
    }

    public static String unescape(String src) {
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length());
        int lastPos = 0, pos = 0;
        char ch;
        while (lastPos < src.length()) {
            pos = src.indexOf("%", lastPos);
            if (pos == lastPos) {
                if (src.charAt(pos + 1) == 'u') {
                    ch = (char) Integer.parseInt(src
                            .substring(pos + 2, pos + 6), 16);
                    tmp.append(ch);
                    lastPos = pos + 6;
                } else {
                    ch = (char) Integer.parseInt(src
                            .substring(pos + 1, pos + 3), 16);
                    tmp.append(ch);
                    lastPos = pos + 3;
                }
            } else {
                if (pos == -1) {
                    tmp.append(src.substring(lastPos));
                    lastPos = src.length();
                } else {
                    tmp.append(src.substring(lastPos, pos));
                    lastPos = pos;
                }
            }
        }
        return tmp.toString();
    }

    public static void main (String[] args) {
        String temp = "%3c%3fxml%20version%3d%221%2e0%22%20encoding%3d%22UTF%2d8%22%3f%3e%0a%3cROOT%3e%0a%20%20%3cALLERGIC%5fWITHOUT%3e1%3c%2fALLERGIC%5fWITHOUT%3e%0a%20%20%3cARCHIVE%5fCODE%3e51011300100100566%3c%2fARCHIVE%5fCODE%3e%0a%20%20%3cARCHIVE%5fOPERATOR%20NAME%3d%22%u674e%u8363%u7f8e%22%3e29940%3c%2fARCHIVE%5fOPERATOR%3e%0a%20%20%3cARCHIVE%5fSTATUS%20NAME%3d%22%u6b63%u5e38%22%3e3%3c%2fARCHIVE%5fSTATUS%3e%0a%20%20%3cARCHIVE%5fTIME%3e2015%2d12%2d30%3c%2fARCHIVE%5fTIME%3e%0a%20%20%3cARCHIVING%5fWAY%3e3%3c%2fARCHIVING%5fWAY%3e%0a%20%20%3cBIRTHDAY%3e1948%2d05%2d01%3c%2fBIRTHDAY%3e%0a%20%20%3cBLOOD%3e5%3c%2fBLOOD%3e%0a%20%20%3cBLOOD%5fRH%3e3%3c%2fBLOOD%5fRH%3e%0a%20%20%3cBROTHERS%5fNONE%3e1%3c%2fBROTHERS%5fNONE%3e%0a%20%20%3cCHILDREN%5fNONE%3e1%3c%2fCHILDREN%5fNONE%3e%0a%20%20%3cDISABILITY%5fWITHOUT%3e1%3c%2fDISABILITY%5fWITHOUT%3e%0a%20%20%3cEDUCATION%3e2%3c%2fEDUCATION%3e%0a%20%20%3cEXPOSURE%5fHISTORY%3e1%3c%2fEXPOSURE%5fHISTORY%3e%0a%20%20%3cFATHER%5fNONE%3e1%3c%2fFATHER%5fNONE%3e%0a%20%20%3cGENETIC%3e0%3c%2fGENETIC%3e%0a%20%20%3cHOUSEHOLD%5fADDRESS%3e%u7ea2%u9633%u5df7%3c%2fHOUSEHOLD%5fADDRESS%3e%0a%20%20%3cIDENTITY%5fCARD%5fNO%3e510113194805011440%3c%2fIDENTITY%5fCARD%5fNO%3e%0a%20%20%3cLINKMAN%5fNAME%3e%u65e0%3c%2fLINKMAN%5fNAME%3e%0a%20%20%3cLINKMAN%5fPHONE%3e%u65e0%3c%2fLINKMAN%5fPHONE%3e%0a%20%20%3cLIVE%5fDRINKING%5fWATER%3e1%3c%2fLIVE%5fDRINKING%5fWATER%3e%0a%20%20%3cLIVE%5fEXHAUST%3e2%3c%2fLIVE%5fEXHAUST%3e%0a%20%20%3cLIVE%5fFUELTYPE%3e3%3c%2fLIVE%5fFUELTYPE%3e%0a%20%20%3cLIVE%5fLIVESTOCK%3e0%3c%2fLIVE%5fLIVESTOCK%3e%0a%20%20%3cLIVE%5fTOILET%3e1%3c%2fLIVE%5fTOILET%3e%0a%20%20%3cMARRIAGE%3e30%3c%2fMARRIAGE%3e%0a%20%20%3cMEDICAL%5fEXPENSES%5f2%3e1%3c%2fMEDICAL%5fEXPENSES%5f2%3e%0a%20%20%3cMOTHER%5fNONE%3e1%3c%2fMOTHER%5fNONE%3e%0a%20%20%3cNATION%20NAME%3d%22%u6c49%u65cf%22%3e1%3c%2fNATION%3e%0a%20%20%3cOCCUPATION%3e9%3c%2fOCCUPATION%3e%0a%20%20%3cORG%5fCOMPLETE%3e141%3c%2fORG%5fCOMPLETE%3e%0a%20%20%3cORG%5fID%3e141%3c%2fORG%5fID%3e%0a%20%20%3cORG%5fRELEGATION%3e141%3c%2fORG%5fRELEGATION%3e%0a%20%20%3cORIGO%3e%u7ea2%u9633%u5df7４%u53f7%u9644１%u53f7%3c%2fORIGO%3e%0a%20%20%0a%20%20%0a%20%20%0a%20%20%0a%20%20%0a%20%20%0a%20%20%0a%20%20%0a%20%20%0a%20%20%0a%20%20%0a%20%20%0a%20%20%3cPAST%5fNONE%3e1%3c%2fPAST%5fNONE%3e%0a%20%20%0a%20%20%0a%20%20%0a%20%20%0a%20%20%3cQUALIFIED%5fFLAG%3e0%3c%2fQUALIFIED%5fFLAG%3e%0a%20%20%3cREMARK%3eHYJD52012600000000242779%3c%2fREMARK%3e%0a%20%20%3cRESIDENCE%20NAME%3d%22%u6237%u7c4d%u4f4f%u5740%22%3e1%3c%2fRESIDENCE%3e%0a%20%20%3cRESPON%5fDOCTOR%3e%u674e%u8363%u7f8e%3c%2fRESPON%5fDOCTOR%3e%0a%20%20%3cRESPONSIBLE%5fDOCTOR%20NAME%3d%22%u674e%u9759%22%3e29898%3c%2fRESPONSIBLE%5fDOCTOR%3e%0a%20%20%3cSICK%5fADDRESS%3e%u77f3%u5bb6%u78be%u793e%u533a%u6021%u57ce%u5317%u5c456%2d3%2d4%2d401%u53f7%3c%2fSICK%5fADDRESS%3e%0a%20%20%3cSICK%5fNAME%3e%u5434%u7ef4%u5148%3c%2fSICK%5fNAME%3e%0a%20%20%3cSICK%5fPHONE%3e13438380030%3c%2fSICK%5fPHONE%3e%0a%20%20%3cSICK%5fSEX%3e2%3c%2fSICK%5fSEX%3e%0a%20%20%3cSICK%5fWORK%5fCOMPANY%3e%u65e0%3c%2fSICK%5fWORK%5fCOMPANY%3e%0a%20%20%3cSURGERY%3e1%3c%2fSURGERY%3e%0a%20%20%3cSURGERY%5fNAME1%3e%u80c6%u56ca%u5207%u9664%u624b%u672f%3c%2fSURGERY%5fNAME1%3e%0a%20%20%3cSURGERY%5fNAME1%5fDATE%3e2002%2d06%2d19%3c%2fSURGERY%5fNAME1%5fDATE%3e%0a%20%20%3cSURGERY%5fNAME2%3e%u5c3f%u7ed3%u77f3%u624b%u672f%3c%2fSURGERY%5fNAME2%3e%0a%20%20%3cSURGERY%5fNAME2%5fDATE%3e2018%2d08%2d11%3c%2fSURGERY%5fNAME2%5fDATE%3e%0a%20%20%3cTRANSFUSION%3e0%3c%2fTRANSFUSION%3e%0a%20%20%3cTRAUMA%3e0%3c%2fTRAUMA%3e%0a%20%20%3cZONE%5fCODE%20NAME%3d%22%u77f3%u5bb6%u78be%u793e%u533a%22%3e510113002002%3c%2fZONE%5fCODE%3e%0a%20%20%3cOLD%5fARCHIVE%5fCODE%3e0%2d3484%3c%2fOLD%5fARCHIVE%5fCODE%3e%0a%20%20%3cCREATE%5fOPERATOR%3e29940%3c%2fCREATE%5fOPERATOR%3e%0a%20%20%3cFORM%5fEDIT%5fFLAG%3e1%3c%2fFORM%5fEDIT%5fFLAG%3e%0a%20%20%3cDEATH%5fNO%2f%3e%0a%20%20%3cMIGRATE%5fNO%2f%3e%0a%20%20%3cIS%5fEDIT%5fID%5fCARD%5fNAME%3e0%3c%2fIS%5fEDIT%5fID%5fCARD%5fNAME%3e%0a%3c%2fROOT%3e";
        System.out.println(EscapeUtils.unescape(temp));
    }

}