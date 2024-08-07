package com.technology.apigateway.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import com.technology.apigateway.controller.request.AddressRequest;
import org.apache.commons.text.WordUtils;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.Text;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.multipart.MultipartFile;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.MainRequest;
import com.technology.apigateway.database.entity.AdminUser;
import com.technology.apigateway.database.entity.Customer;
import com.technology.apigateway.exception.BusinessException;

/***********************************************************************
 *
 * @package：com.lendbiz.p2p.api.utils，@class-name：Utils.java
 *
 * @copyright Copyright: 2021-2022
 * @creator Hoang Thanh Tu <br/>
 * @create-time Apr 9, 2021 10:56:36 AM
 *
 ***********************************************************************/
public class ApiUtils {

    public static void fillDataToContract(Customer customer,
                                          String urlInputDocx,
                                          String urlOutputDocx,
                                          MainRequest mainRequest,
                                          AdminUser adminUser,
                                          String documentNo,
                                          Double loanRate,
                                          Double feeSoon,
                                          AddressRequest addressRequest,
                                          Double assetManagementFeeRate,
                                          Double expertiseFeeRate)
            throws Docx4JException, IOException, JAXBException {
        String filePath = urlInputDocx;

        ApiUtils docx4j = new ApiUtils();
        WordprocessingMLPackage template = docx4j.getTemplate(filePath);

        //Date date = new Date();
        // Choose time zone in which you want to interpret your Date
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        cal.setTime(addressRequest.getLnDate());
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        cal.add(Calendar.MONTH, mainRequest.getTerm());
        int monthPay = cal.get(Calendar.MONTH) + 1;
        int yearPay = cal.get(Calendar.YEAR);

        List<Object> texts = getAllElementFromObject(template.getMainDocumentPart(), Text.class);

        SimpleDateFormat sdf = new SimpleDateFormat(
                "dd/MM/yyyy");

        NumberFormat numberFormat = NumberFormat.getInstance();

        searchAndReplace(texts, new HashMap<String, String>() {
            private static final long serialVersionUID = 1L;

            {
                this.put("${documentno}", documentNo);
                this.put("${at}", adminUser.getBranchName());
                this.put("${dob}", customer.getDob() != null ? customer.getDob() : "[Ngày sinh]");
                this.put("${branch}", adminUser.getBranchName());
                this.put("${branchaddress}", adminUser.getBranchAddress());
                this.put("${date}", String.valueOf(day));
                this.put("${month}", String.valueOf(month));
                this.put("${year}", String.valueOf(year));
                this.put("${fullname}", WordUtils.capitalize(customer.getFullName().toLowerCase()));
                this.put("${idnumber}", customer.getIdNumber());
                this.put("${gender}", customer.getGenderName());
                this.put("${idplace}", customer.getIdDate() != null ? WordUtils.capitalize(customer.getIdPlace().toLowerCase()) : "[Nơi cấp]");
                this.put("${iddate}", customer.getIdDate() != null ? customer.getIdDate() : "[Ngày cấp]");
                this.put("${phone}", customer.getMobile());
                this.put("${profession}", mainRequest.getProfession());
                this.put("${address}", WordUtils.capitalize(customer.getAddress().toLowerCase()));
                this.put("${ward}", addressRequest.getWard());
                this.put("${district}", addressRequest.getDistrict());
                this.put("${province}", addressRequest.getProvince());
                this.put("${currentaddress}", WordUtils.capitalize(customer.getResidenceAddress().toLowerCase()));
                this.put("${currentward}", addressRequest.getResidenceWard());
                this.put("${currentdistrict}", addressRequest.getResidenceDistrict());
                this.put("${currentprovince}", addressRequest.getResidenceProvince());
                this.put("${email}", customer.getEmail() != null ? customer.getEmail() : "[Email]");
                this.put("${bankno}", mainRequest.getBankAccountNumber());
                this.put("${bankname}", mainRequest.getBankName());
                for (int i = 0; i < mainRequest.getReferences().size(); i++) {
                    String refName = "${ref" + (i + 1) + "}";
                    String refPhone = "${ref" + (i + 1) + "phone}";
                    String refType = "${ref" + (i + 1) + "type}";

                    this.put(refName, WordUtils.capitalize(mainRequest.getReferences().get(i).getRefName().toLowerCase()));
                    this.put(refPhone, WordUtils.capitalize(mainRequest.getReferences().get(i).getMobile().toLowerCase()));
                    this.put(refType, WordUtils.capitalize(mainRequest.getReferences().get(i).getRelation().toLowerCase()));
                }

                if (mainRequest.getReferences().size() == 2) {
                    this.put("${ref3}", " ");
                    this.put("${ref3phone}", " ");
                    this.put("${ref3type}", " ");
                }

                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                this.put("${loanamount}", numberFormat.format(mainRequest.getLoanAmount()) + " VND");
                this.put("${loanpurpose}", mainRequest.getPurposeUsingLoan());
                this.put("${startdate}", day + "/" + month + "/" + year);
                this.put("${enddate}", day + "/" + monthPay + "/" + yearPay);
                this.put("${paydate}", String.valueOf(day));
                this.put("${loanrate}", loanRate.toString());
                this.put("${feesoon}", feeSoon.toString());
                this.put("${paytype}", mainRequest.getPayType());
                this.put("${customername}", WordUtils.capitalize(customer.getFullName().toLowerCase()));
                this.put("${signdate}", day + "/" + month + "/" + year);
                this.put("${vehname}", mainRequest.getVehicleBrand() + " " + addressRequest.getVehicleName());
                this.put("${chassicnumber}", mainRequest.getChassisNumber());
                this.put("${enginenumber}", mainRequest.getEngineNumber());
                this.put("${vehcolor}", mainRequest.getVehicleColor());
                this.put("${fuel}", mainRequest.getFuel());
                this.put("${regnumber}", mainRequest.getRegistrationNumber());
                this.put("${vehnumber}", mainRequest.getVehicleNumber());
                this.put("${vehregissued}", dateFormat.format(mainRequest.getVehicleRegistrationDate()).toString());
                this.put("${vehprice}", numberFormat.format(mainRequest.getVehiclePrice()) + " VND");
                this.put("${assetmanagementfeerate}", assetManagementFeeRate.toString());
                this.put("${expertisefeerate}", expertiseFeeRate.toString());
            }

            @Override
            public String get(Object key) {
                return super.get(key);
            }
        });

        docx4j.writeDocxToStream(template, urlOutputDocx);
    }

    public static void fillDataToAuthorizationDocument(Customer customer,
                                                        String urlInputDocx,
                                                        String urlOutputDocx,
                                                        MainRequest mainRequest,
                                                        AdminUser adminUser,
                                                        String documentNo,
                                                        AddressRequest addressRequest)
            throws Docx4JException, IOException, JAXBException {
        String filePath = urlInputDocx;

        ApiUtils docx4j = new ApiUtils();
        WordprocessingMLPackage template = docx4j.getTemplate(filePath);

        // Choose time zone in which you want to interpret your Date
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        cal.setTime(addressRequest.getLnDate());
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        cal.add(Calendar.MONTH, mainRequest.getTerm());
        int monthPay = cal.get(Calendar.MONTH) + 1;
        int yearPay = cal.get(Calendar.YEAR);

        List<Object> texts = getAllElementFromObject(template.getMainDocumentPart(), Text.class);

        SimpleDateFormat sdf = new SimpleDateFormat(
                "dd/MM/yyyy");

        NumberFormat numberFormat = NumberFormat.getInstance();

        searchAndReplace(texts, new HashMap<String, String>() {
            private static final long serialVersionUID = 1L;

            {
                this.put("${documentno}", documentNo);
                this.put("${day}", String.valueOf(day));
                this.put("${month}", String.valueOf(month));
                this.put("${year}", String.valueOf(year));
                this.put("${fullname}", WordUtils.capitalize(customer.getFullName().toLowerCase()));
                this.put("${dob}", customer.getDob() != null ? customer.getDob() : "[Ngày sinh]");
                this.put("${idnumber}", customer.getIdNumber());
                this.put("${iddate}", customer.getIdDate() != null ? customer.getIdDate() : "[Ngày cấp]");
                this.put("${idplace}", customer.getIdDate() != null ? WordUtils.capitalize(customer.getIdPlace().toLowerCase()) : "[Nơi cấp]");
                this.put("${address}", WordUtils.capitalize(customer.getAddress().toLowerCase()));
                this.put("${ward}", addressRequest.getWard());
                this.put("${district}", addressRequest.getDistrict());
                this.put("${province}", addressRequest.getProvince());
                this.put("${raddress}", WordUtils.capitalize(customer.getResidenceAddress().toLowerCase()));
                this.put("${rward}", addressRequest.getResidenceWard());
                this.put("${rdistrict}", addressRequest.getResidenceDistrict());
                this.put("${rprovince}", addressRequest.getResidenceProvince());
                this.put("${phone}", customer.getMobile());

                //Thong tin nguoi bao lanh
                this.put("${gfullname}", mainRequest.getGuardName() != null ? WordUtils.capitalize(mainRequest.getGuardName().toLowerCase()) : "[Họ và tên]");
                this.put("${gdob}", mainRequest.getGuardBirth() != null ? mainRequest.getGuardBirth() : "[Ngày sinh]");
                this.put("${gidnumber}", mainRequest.getGuardIdNumber() != null ? mainRequest.getGuardIdNumber() : "[CCCD]");
                this.put("${giddate}", mainRequest.getGuardIdDate() != null ? mainRequest.getGuardIdDate() : "[Ngày cấp]");
                this.put("${gidplace}", mainRequest.getGuardIdPlace() != null ? WordUtils.capitalize(mainRequest.getGuardIdPlace().toLowerCase()) : "[Nơi cấp]");
                this.put("${gaddress}", mainRequest.getGuardAddress() != null ? WordUtils.capitalize(mainRequest.getGuardAddress().toLowerCase()) : "[Địa chỉ thường trú]");
                this.put("${graddress}", mainRequest.getGuardCurrentAddress() != null ? WordUtils.capitalize(mainRequest.getGuardCurrentAddress().toLowerCase()) : "[Địa chỉ hiện tại]");
                this.put("${gphone}", mainRequest.getGuardMobile());

                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                this.put("${vehiclename}", mainRequest.getVehicleBrand() + " " + addressRequest.getVehicleName());
                this.put("${vehiclenumber}", mainRequest.getVehicleNumber());
                this.put("${regnumber}", mainRequest.getRegistrationNumber());
                this.put("${chassicnumber}", mainRequest.getChassisNumber());
                this.put("${enginenumber}", mainRequest.getEngineNumber());
                this.put("${vehicleregdate}", dateFormat.format(mainRequest.getVehicleRegistrationDate()).toString());
            }

            @Override
            public String get(Object key) {
                return super.get(key);
            }
        });

        docx4j.writeDocxToStream(template, urlOutputDocx);
    }

    public static void fillDataToAssetTransferDocument(Customer customer,
                                                       String urlInputDocx,
                                                       String urlOutputDocx,
                                                       MainRequest mainRequest,
                                                       AdminUser adminUser,
                                                       String documentNo,
                                                       AddressRequest addressRequest)
            throws Docx4JException, IOException, JAXBException {
        String filePath = urlInputDocx;

        ApiUtils docx4j = new ApiUtils();
        WordprocessingMLPackage template = docx4j.getTemplate(filePath);

        // Choose time zone in which you want to interpret your Date
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        cal.setTime(addressRequest.getLnDate());
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        cal.add(Calendar.MONTH, mainRequest.getTerm());
        int monthPay = cal.get(Calendar.MONTH) + 1;
        int yearPay = cal.get(Calendar.YEAR);

        List<Object> texts = getAllElementFromObject(template.getMainDocumentPart(), Text.class);

        SimpleDateFormat sdf = new SimpleDateFormat(
                "dd/MM/yyyy");

        NumberFormat numberFormat = NumberFormat.getInstance();

        searchAndReplace(texts, new HashMap<String, String>() {
            private static final long serialVersionUID = 1L;

            {
                this.put("${documentno}", documentNo);
                this.put("${day}", String.valueOf(day));
                this.put("${month}", String.valueOf(month));
                this.put("${year}", String.valueOf(year));
                this.put("${fullname}", WordUtils.capitalize(customer.getFullName().toLowerCase()));
                this.put("${dob}", customer.getDob() != null ? customer.getDob() : "[Ngày sinh]");
                this.put("${idnumber}", customer.getIdNumber());
                this.put("${iddate}", customer.getIdDate() != null ? customer.getIdDate() : "[Ngày cấp]");
                this.put("${idplace}", customer.getIdDate() != null ? WordUtils.capitalize(customer.getIdPlace().toLowerCase()) : "[Nơi cấp]");
                this.put("${address}", WordUtils.capitalize(customer.getAddress().toLowerCase()));
                this.put("${ward}", addressRequest.getWard());
                this.put("${district}", addressRequest.getDistrict());
                this.put("${province}", addressRequest.getProvince());
                this.put("${raddress}", WordUtils.capitalize(customer.getResidenceAddress().toLowerCase()));
                this.put("${rward}", addressRequest.getResidenceWard());
                this.put("${rdistrict}", addressRequest.getResidenceDistrict());
                this.put("${rprovince}", addressRequest.getResidenceProvince());
                this.put("${phone}", customer.getMobile());

                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                this.put("${vehiclename}", mainRequest.getVehicleBrand() + " " + addressRequest.getVehicleName());
                this.put("${vehiclenumber}", mainRequest.getVehicleNumber());
                this.put("${regnumber}", mainRequest.getRegistrationNumber());
                this.put("${chassicnumber}", mainRequest.getChassisNumber());
                this.put("${enginenumber}", mainRequest.getEngineNumber());
                this.put("${vehicleregdate}", dateFormat.format(mainRequest.getVehicleRegistrationDate()).toString());
                this.put("${vehicleregissued}", mainRequest.getVehicleRegistrationIssued());
                this.put("${vehiclecolor}", mainRequest.getVehicleColor());
            }

            @Override
            public String get(Object key) {
                return super.get(key);
            }
        });

        docx4j.writeDocxToStream(template, urlOutputDocx);
    }

    private WordprocessingMLPackage getTemplate(String name) throws Docx4JException, FileNotFoundException {
        WordprocessingMLPackage template = WordprocessingMLPackage.load(new FileInputStream(new File(name)));
        return template;
    }

    private static List<Object> getAllElementFromObject(Object obj, Class<?> toSearch) {
        List<Object> result = new ArrayList<Object>();
        if (obj instanceof JAXBElement)
            obj = ((JAXBElement<?>) obj).getValue();

        if (obj.getClass().equals(toSearch))
            result.add(obj);
        else if (obj instanceof ContentAccessor) {
            List<?> children = ((ContentAccessor) obj).getContent();
            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }
        }
        return result;
    }

    private void writeDocxToStream(WordprocessingMLPackage template, String target)
            throws IOException, Docx4JException {
        File f = new File(target);
        template.save(f);
    }

    public static void searchAndReplace(List<Object> texts, Map<String, String> values) {

        // -- scan all expressions
        // Will later contain all the expressions used though not used at the moment
        List<String> els = new ArrayList<String>();

        StringBuilder sb = new StringBuilder();
        int PASS = 0;
        int PREPARE = 1;
        int READ = 2;
        int mode = PASS;

        // to nullify
        List<int[]> toNullify = new ArrayList<int[]>();
        int[] currentNullifyProps = new int[4];

        for (int i = 0; i < texts.size(); i++) {
            Object text = texts.get(i);
            Text textElement = (Text) text;
            String newVal = "";
            String v = textElement.getValue();
            StringBuilder textSofar = new StringBuilder();
            int extra = 0;
            char[] vchars = v.toCharArray();
            for (int col = 0; col < vchars.length; col++) {
                char c = vchars[col];
                textSofar.append(c);
                switch (c) {
                    case '$': {
                        mode = PREPARE;
                        sb.append(c);
                    }
                    break;
                    case '{': {
                        if (mode == PREPARE) {
                            sb.append(c);
                            mode = READ;
                            currentNullifyProps[0] = i;
                            currentNullifyProps[1] = col + extra - 1;
                        } else {
                            if (mode == READ) {
                                sb = new StringBuilder();
                                mode = PASS;
                            }
                        }
                    }
                    break;
                    case '}': {
                        if (mode == READ) {
                            mode = PASS;
                            sb.append(c);
                            els.add(sb.toString());
                            newVal += textSofar.toString()
                                    + (null == values.get(sb.toString()) ? sb.toString() : values.get(sb.toString()));
                            textSofar = new StringBuilder();
                            currentNullifyProps[2] = i;
                            currentNullifyProps[3] = col + extra;
                            toNullify.add(currentNullifyProps);
                            currentNullifyProps = new int[4];
                            extra += sb.toString().length();
                            sb = new StringBuilder();
                        } else if (mode == PREPARE) {
                            mode = PASS;
                            sb = new StringBuilder();
                        }
                    }
                    default: {
                        if (mode == READ)
                            sb.append(c);
                        else if (mode == PREPARE) {
                            mode = PASS;
                            sb = new StringBuilder();
                        }
                    }
                }
            }
            newVal += textSofar.toString();
            textElement.setValue(newVal);
        }

        if (toNullify.size() > 0)
            for (int i = 0; i < texts.size(); i++) {
                if (toNullify.size() == 0)
                    break;
                currentNullifyProps = toNullify.get(0);
                Object text = texts.get(i);
                Text textElement = (Text) text;
                String v = textElement.getValue();
                StringBuilder nvalSB = new StringBuilder();
                char[] textChars = v.toCharArray();
                for (int j = 0; j < textChars.length; j++) {
                    char c = textChars[j];
                    if (null == currentNullifyProps) {
                        nvalSB.append(c);
                        continue;
                    }
                    int floor = currentNullifyProps[0] * 100000 + currentNullifyProps[1];
                    int ceil = currentNullifyProps[2] * 100000 + currentNullifyProps[3];
                    int head = i * 100000 + j;
                    if (!(head >= floor && head <= ceil)) {
                        nvalSB.append(c);
                    }

                    if (j > currentNullifyProps[3] && i >= currentNullifyProps[2]) {
                        toNullify.remove(0);
                        if (toNullify.size() == 0) {
                            currentNullifyProps = null;
                            continue;
                        }
                        currentNullifyProps = toNullify.get(0);
                    }
                }
                textElement.setValue(nvalSB.toString());
            }
    }

    public static void main(String[] args) {
        String in = "dexuatvayvon.xlsx";
        String out = "output.docx";

        try {
            testFillData(in, out);
        } catch (Docx4JException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void testFillData(
            String urlInputDocx,
            String urlOutputDocx)
            throws Docx4JException, IOException, JAXBException {
        String filePath = urlInputDocx;

        ApiUtils docx4j = new ApiUtils();
        WordprocessingMLPackage template = docx4j.getTemplate(filePath);

        Date date = new Date();
        // Choose time zone in which you want to interpret your Date
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        List<Object> texts = getAllElementFromObject(template.getMainDocumentPart(), Text.class);

        SimpleDateFormat sdf = new SimpleDateFormat(
                "dd/MM/yyyy");

        searchAndReplace(texts, new HashMap<String, String>() {
            private static final long serialVersionUID = 1L;

            {
                this.put("${hopdong}", "123");
            }

            @Override
            public String get(Object key) {
                return super.get(key);
            }
        });

        docx4j.writeDocxToStream(template, urlOutputDocx);
    }

    public static ByteArrayResource convertFile(MultipartFile sourceFile) {
        ByteArrayResource resource = null;
        try {
            resource = new ByteArrayResource(sourceFile.getBytes()) {
                @Override
                public String getFilename() {
                    return sourceFile.getOriginalFilename();
                }
            };
        } catch (IOException e) {
            throw new BusinessException(ErrorCode.FAILED_TO_FILE, ErrorCode.FAILED_TO_FILE_DESCRIPTION);
        }

        return resource;
    }
}
