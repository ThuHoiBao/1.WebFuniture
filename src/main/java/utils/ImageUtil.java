package utils;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class ImageUtil {
    // Mã hóa ảnh thành chuỗi base64
    public static String DisplayImage(byte[] imageByte) {
        if (imageByte == null) return ""; // Nếu không có dữ liệu ảnh, trả về chuỗi rỗng
        return Base64.getEncoder().encodeToString(imageByte);
    }

    // Đọc dữ liệu ảnh từ file tải lên
    public static byte[] renderImage(Part filePart) throws IOException {
        byte[] avatarBytes = null;
        if (filePart != null && filePart.getSize() > 0) {
            try (InputStream inputStream = filePart.getInputStream()) {
                avatarBytes = inputStream.readAllBytes();
            } catch (IOException e) {
                throw new RuntimeException(e); // Ném ngoại lệ nếu có lỗi
            }
        }
        return avatarBytes; // Trả về dữ liệu ảnh dưới dạng mảng byte
    }
}
