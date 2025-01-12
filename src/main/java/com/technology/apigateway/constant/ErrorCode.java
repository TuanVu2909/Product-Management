package com.technology.apigateway.constant;

public class ErrorCode {

    public static final String SUCCESS = "00";
    public static final String SUCCESS_DESCRIPTION = "Successful!";

    public static final String UNKNOWN_ERROR = "01";
    public static final String UNKNOWN_ERROR_DESCRIPTION = "Unknown Error";

    public static final String INVALID_DATA_REQUEST = "02";
    public static final String INVALID_DATA_REQUEST_DESCRIPTION = "Invalid Input's request!";

    public static final String NOT_FOUND_ENTITY = "03";
    public static final String NOT_FOUND_ENTITY_DESCRIPTION = "Not found entity!";

    public static final String INVALID_FILE = "04";
    public static final String INVALID_FILE_DESCRIPTION = "Upload false!";

    public static final String NOT_MATCH_DATA = "05";
    public static final String NOT_MATCH_DATA_DESCRIPTION = "Not match data!";

    public static final String UNAUTHORIZED = "06";
    public static final String UNAUTHORIZED_DESCRIPTION = "No permission to do!";

    public static final String INVALID_SESSION = "07";
    public static final String INVALID_SESSION_DESCRIPTION = "Invalid Session!";

    public static final String FAILED_TO_EXECUTE = "08";
    public static final String FAILED_TO_EXECUTE_DESCRIPTION = "Đã có lỗi xảy ra khi kết nối tới máy chủ. Quý Khách vui lòng liên hệ tổng đài 0123456 để được hỗ trợ!";

    public static final String FAILED_TO_JSON = "09";
    public static final String FAILED_TO_JSON_DESCRIPTION = "Đã có lỗi xảy ra khi kết nối tới máy chủ. Quý Khách vui lòng liên hệ tổng đài 0123456 để được hỗ trợ!";

    public static final String FAILED_TO_FILE = "10";
    public static final String FAILED_TO_FILE_DESCRIPTION = "Can not convert file !";

    public static final String FAILED_SAVE_FILE = "11";
    public static final String FAILED_SAVE_FILE_DESCRIPTION = "Can not save file to server";

    public static final String FAILED_IDENTITY = "12";
    public static final String FAILED_IDENTITY_DESCRIPTION = "FAILED_IDENTITY_DESCRIPTION";

    // public static final String FAILED_SELFIE = "13";
    // public static final String FAILED_SELFIE_DESCRIPTION = "Anh selfie khong khop
    // voi CMND/CCCD";

    public static final String FAILED_OLD_INVALID = "Bạn chưa đủ 18 tuổi!";

    public static final String NOT_FOUND_CUSTOMER = "121";
    public static final String NOT_FOUND_CUSTOMER_DESCRIPTION = "Không tìm thấy khách hàng";
    public static final String NOT_FOUND_DISTRICT_DESCRIPTION = "Không tìm thấy huyện";
    public static final String NOT_FOUND_OPERATOR = "Không tìm thấy hợp đồng";
    public static final String NOT_FOUND_OPERATOR_LOAN = "Không tìm thấy khoản vay";

    public static final String NOT_MATCHING_TYPE = "14";
    public static final String NOT_MATCHING_CMND_DESCRIPTION = "Bạn chọn sai loại giấy tờ tuỳ thân. Hãy chụp loại giấy tờ là CHỨNG MINH NHÂN DÂN!";
    public static final String NOT_MATCHING_CCCD_DESCRIPTION = "Bạn chọn sai loại giấy tờ tuỳ thân. Hãy chụp loại giấy tờ là CĂN CƯỚC CÔNG DÂN!";
    public static final String NOT_MATCHING_HC_DESCRIPTION = "Bạn chọn sai loại giấy tờ tuỳ thân. Hãy chụp loại giấy tờ là HỘ CHIẾU!";
    public static final String NOT_MATCHING_CMCAND_DESCRIPTION = "Bạn chọn sai loại giấy tờ tuỳ thân. Hãy chụp loại giấy tờ là CHỨNG MINH CÔNG AN NHÂN DÂN!";
    public static final String NOT_MATCHING_CMNDQD_DESCRIPTION = "Bạn chọn sai loại giấy tờ tuỳ thân. Hãy chụp loại giấy tờ là CHỨNG MINH NHÂN DÂN QUÂN ĐỘI!";

    public static final String NOT_MATCHING_SIDE = "15";
    public static final String NOT_MATCHING_FRONT_CMND_DESCRIPTION = "Bạn chụp sai mặt giấy tờ tuỳ thân. Hãy chụp mặt trước CHỨNG MINH NHÂN DÂN!";
    public static final String NOT_MATCHING_BACK_CMND_DESCRIPTION = "Bạn chụp sai mặt giấy tờ tuỳ thân. Hãy chụp mặt sau CHỨNG MINH NHÂN DÂN!";

    public static final String NOT_MATCHING_FRONT_CCCD_DESCRIPTION = "Bạn chụp sai mặt giấy tờ tuỳ thân. Hãy chụp mặt trước CĂN CƯỚC CÔNG DÂN!";
    public static final String NOT_MATCHING_BACK_CCCD_DESCRIPTION = "Bạn chụp sai mặt giấy tờ tuỳ thân. Hãy chụp mặt sau CĂN CƯỚC CÔNG DÂN!";

    public static final String NOT_MATCHING_SIDE_HC_DESCRIPTION = "Bạn chụp sai mặt giấy tờ tuỳ thân. Hãy chụp đúng 2 trang đầu của HỘ CHIẾU!";

    public static final String NOT_MATCHING_FRONT_CMCAND_DESCRIPTION = "Bạn chụp sai mặt giấy tờ tuỳ thân. Hãy chụp mặt trước CHỨNG MINH CÔNG AN NHÂN DÂN!";
    public static final String NOT_MATCHING_BACK_CMCAND_DESCRIPTION = "Bạn chụp sai mặt giấy tờ tuỳ thân. Hãy chụp mặt sau CHỨNG MINH CÔNG AN NHÂN DÂN!";

    public static final String NOT_MATCHING_FRONT_CMNDQD_DESCRIPTION = "Bạn chụp sai mặt giấy tờ tuỳ thân. Hãy chụp mặt trước CHỨNG MINH NHÂN DÂN QUÂN ĐỘI!";
    public static final String NOT_MATCHING_BACK_CMNDQD_DESCRIPTION = "Bạn chụp sai mặt giấy tờ tuỳ thân. Hãy chụp mặt sau CHỨNG MINH NHÂN DÂN QUÂN ĐỘI!";

    public static final String ID_FAKE = "16";
    public static final String ID_FAKE_DESCRIPTION = "Giấy tờ tuỳ thân của Quý Khách không hợp lệ. Vui lòng kiểm tra và thử lại!";

    public static final String FACE_NOT_MATCHING = "17";
    public static final String FACE_NOT_MATCHING_DESCRIPTION = "Khuôn mặt của bạn không khớp với giấy tờ tuỳ thân! Bạn thử chụp lại nhé!";

    public static final String NO_DATA = "18";
    public static final String NO_DATA_DESCRIPTION = "Không có dữ liệu";

    public static final String SIGN_FAIL = "19";
    public static final String SIGN_FAIL_DESCRIPTION = "SIGN_FAIL";

    public static final String NO_CARD = "20";
    public static final String NO_CARD_DESCRIPTION = "HẾT THẺ";

    public static final String NO_refId = "21";
    public static final String NO_refId_DESCRIPTION = "Mã giới thiệu đã tồn tại";

    public static final String USER_EXISTED = "22";
    public static final String USER_EXISTED_DESCRIPTION = "Giấy tờ tuỳ thân đã được sử dụng, vui lòng sử dụng giấy tờ tuỳ thân khác!";

    public static final String VNPT_INVALID_INPUT = "23";
    public static final String VNPT_INVALID_INPUT_DESC = "Ảnh chụp không hợp lệ, vui lòng chụp lại!";

    public static final String VNPT_INVALID_TYPE = "24";
    public static final String VNPT_INVALID_TYPE_DESC = "Loại giấy tờ không hợp lệ, Chỉ được phép sử dụng chứng minh nhân dân, Căn cước công dân, Căn cước gắn chíp!";

    public static final String VNPT_INVALID_ID_TYPE = "25";
    public static final String VNPT_INVALID_ID_TYPE_DESC = "Giấy tờ mặt trước và sau không cùng loại!";

    public static final String VNPT_ID_FRONT_COVER = "26";
    public static final String VNPT_ID_FRONT_COVER_DESC = "Giấy tờ mặt trước bị cắt hoặc bị che!";

    public static final String VNPT_ID_BACK_COVER = "27";
    public static final String VNPT_ID_BACK_COVER_DESC = "Giấy tờ mặt sau bị cắt hoặc bị che!";

    public static final String VNPT_ID_FRONT_INVALID = "28";
    public static final String VNPT_ID_FRONT_INVALID_DESC = "Giấy tờ mặt trước không hợp lệ!";

    public static final String VNPT_ID_BACK_INVALID = "29";
    public static final String VNPT_ID_BACK_INVALID_DESC = "Giấy tờ mặt sau không hợp lệ!";

    public static final String VNPT_ID_EXPIRED = "30";
    public static final String VNPT_ID_EXPIRED_DESC = "Giấy tờ hết hạn sử dụng!";

    public static final String VNPT_ID_NO_CORNER = "31";
    public static final String VNPT_ID_NO_CORNER_DESC = "Giấy tờ bị mất góc!";

    public static final String VNPT_ID_NO_MATCH = "32";
    public static final String VNPT_ID_NO_MATCH_DESC = "Giấy tờ có mặt trước và mặt sau không khớp!";

    public static final String VNPT_NO_IMAGE = "33";
    public static final String VNPT_NO_IMAGE_DESC = "Dữ liệu không phải là ảnh!";

    public static final String VNPT_MULTIPLE_FACES = "34";
    public static final String VNPT_MULTIPLE_FACES_DESC = "Ảnh có nhiều hơn 1 khuôn mặt!";

    public static final String VNPT_FACE_NO_MATCH = "35";
    public static final String VNPT_FACE_NO_MATCH_DESC = "Khuôn mặt không khớp với giấy tờ tùy thân!";

    public static final String VNPT_FACE_NO_FIND = "36";
    public static final String VNPT_FACE_NO_FIND_DESC = "Không tìm thấy khuôn mặt!";

    public static final String EKYC_LIMIT = "37";
    public static final String EKYC_LIMIT_DESC = "Bạn đã vượt quá số lần eKYC trong ngày hôm nay (tối đa 3 lần), vui lòng thử lại vào ngày mai";

    public static final String SESSION_TIMEOUT = "901";
    public static final String SESSION_TIMEOUT_DESCRIPTION = "Hết phiên đăng nhập, vui lòng đăng nhập lại!";

    public static final String FAIL_LOGIN = "100";
    public static final String FAIL_LOGIN_DESCRIPTION = "Tài khoản không tồn tại";

    public static final String ACCOUNT_LOCKED = "101";
    public static final String ACCOUNT_LOCKED_DESCRIPTION = "Tài khoản bị khoá do bạn nhập sai mật khẩu quá 5 lần! Vui lòng thử lại sau 15 phút!";

    public static final String FAIL_PASSWORD_LOGIN = "102";
    public static final String FAIL_PASSWORD_LOGIN_DESCRIPTION = "Tài khoản hoặc mật khẩu không đúng";

    public static final String NOT_ACCEPT_CARDNUMBER = "103";
    public static final String NOT_ACCEPT_CARDNUMBER_DESCRIPTION = "Không được nhập số thẻ";

    public static final String MOBILE_EXISTED = "Số điện thoại đã được sử dụng";

    public static final String ERROR_500 = "500";
    public static final String ERROR_500_DESCRIPTION = "Lỗi không xác định!";

    public static final String VERSION_OUTDATED = "511";
    public static final String VERSION_OUTDATED_DESCRIPTION = "Version outdated";

    public static final String ACCOUNT_NOT_UPDATED = "201";
    public static final String ACCOUNT_NOT_UPDATED_DESCRIPTION = "Tài khoản chưa phân nhánh vào đâu!";

    private final String code;
    private final String description;

    ErrorCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

}
