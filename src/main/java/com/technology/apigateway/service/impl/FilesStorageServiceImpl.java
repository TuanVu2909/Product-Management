package com.technology.apigateway.service.impl;

import com.technology.apigateway.config.MockMultipartFile;
import com.technology.apigateway.constant.Constants;
import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.database.repository.FileInfoRepository;
import com.technology.apigateway.database.repository.UserFileRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.exception.InvalidFileException;
import com.technology.apigateway.service.FilesStorageService;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service("filesStorageService")
@Log4j2
public class FilesStorageServiceImpl extends BaseResponse<FilesStorageService> implements FilesStorageService {

    @Autowired
    FileInfoRepository fileInfoRepository;

    @Autowired
    UserFileRepository fileRepository;

    @Autowired
    UserFileRepository userFileRepository;

    private final String root = "hoso" + Constants.FOLDER_SEPERATE;
    private Path direct;
    private final String rootContract = "contracts" + Constants.FOLDER_SEPERATE;

    @Override
    public String init(String key, String custId) {
        String url = root + custId + Constants.FOLDER_SEPERATE + key;
        direct = Paths.get(url);
        if (!Files.exists(direct)) {
            try {
                Files.createDirectories(direct);
                log.info("Create path = " + direct + " successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                if (key.equalsIgnoreCase("avatar") && !isEmpty(direct)) {
                    FileUtils.cleanDirectory(new File(url));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return direct.toString();
    }

    @Override
    public String initContracts(String mobilesms) {
        String url = rootContract + Constants.FOLDER_SEPERATE + "sign" + Constants.FOLDER_SEPERATE + mobilesms;

        direct = Paths.get(url);

        if (!Files.exists(direct)) {
            try {
                Files.createDirectories(direct);
                log.info("Create path = " + direct + " successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileUtils.cleanDirectory(new File(url));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return direct.toString();
    }

    @Override
    public String save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.direct.resolve(file.getOriginalFilename()));
            return "OK";
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.FAILED_SAVE_FILE,
                    ErrorCode.FAILED_SAVE_FILE_DESCRIPTION + e.getMessage());
        }
    }

    @Override
    public void saveContract(byte[] file, String path) {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(file);
            // fos.close(); There is no more need for this line since you had created the
            // instance of "fos" inside the try. And this will automatically close the
            // OutputStream
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.FAILED_SAVE_FILE,
                    ErrorCode.FAILED_SAVE_FILE_DESCRIPTION + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> uploadFile(MultipartFile file, String key, String custId, String saleId, String type, Integer regId) {

        String direct = init(key, custId);
        MultipartFile mFile;
        // File nfile;
        String extension;
        String fileName = custId + "_" + FilenameUtils.removeExtension(file.getOriginalFilename());
        String contractEncode;

        try {

            extension = FilenameUtils.getExtension(file.getOriginalFilename());
            mFile = new MockMultipartFile(fileName, fileName + "." + extension, "text/plain",
                    IOUtils.toByteArray(file.getInputStream()));

            String fileUrl = "hoso" + Constants.FOLDER_SEPERATE + custId + Constants.FOLDER_SEPERATE + "files"
                    + Constants.FOLDER_SEPERATE + file.getOriginalFilename();

            org.apache.commons.io.FileUtils.writeByteArrayToFile(
                    new File(fileUrl),
                    IOUtils.toByteArray(file.getInputStream()));

            log.info("[API UPLOAD] Uploaded the file successfully: ", file.getOriginalFilename());
            contractEncode = encodeFileToBase64Binary(fileUrl);

            try {
                fileRepository.insertRow(file.getOriginalFilename(), type, fileUrl, Integer.parseInt(custId), Integer.parseInt(saleId), extension, regId);
            } catch (Exception e) {
                log.info(e.getMessage());
            }

            return response(toResult(fileUrl));

        } catch (Exception e) {
            System.out.println("Exception");
            throw new InvalidFileException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> deleteFile(String file, String key, String custId, int id) {

        String url = root + custId + Constants.FOLDER_SEPERATE + key;

        direct = Paths.get(url);
        try {
            try {
                if (!isEmpty(direct)) {
                    String path = url + Constants.FOLDER_SEPERATE + custId + "_" + file;
                    System.out.println(path);
                    File fileDelete = new File(path);
                    if (fileDelete.delete()) {
                        log.info("Delete file" + path + " OK!!");
                        fileInfoRepository.deleteUpdate(custId, FilenameUtils.removeExtension(fileDelete.getName()));
                        userFileRepository.findById(id);
                    } else {
                        log.info("Delete file" + path + " ERROR!!");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return response(toResult("OK"));
        } catch (Exception e) {
            System.out.println("Exception");
            throw new InvalidFileException(e.getMessage());
        }
    }

    public boolean isEmpty(Path path) throws IOException {
        if (Files.isDirectory(path)) {
            try (DirectoryStream<Path> directory = Files.newDirectoryStream(path)) {
                return !directory.iterator().hasNext();
            }
        }
        return false;
    }

    @Override
    public ResponseEntity<?> getFile(String custId) {
        try {
            log.error("e.getMessage()");
            return response(toResult(fileInfoRepository.findAllByCustId(custId)));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException("Unimplemented method 'getFile'");
        }
    }

    private static String encodeFileToBase64Binary(String fileName) throws IOException {
        File file = new File(fileName);
        byte[] encoded = Base64.encodeBase64(org.apache.commons.io.FileUtils.readFileToByteArray(file));
        return new String(encoded, java.nio.charset.StandardCharsets.US_ASCII);
    }

}
